package com.example.liftprogramming;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<FloorDetails> floorDetailsList;

    LiftItemAdapter liftItemAdapter;

    ListView listView;

    Button start_lift;

    List<Integer> finalOrder = new ArrayList<>();

    final static int TOTAL_NO_OF_FLOORS = 7;

    Utility utility;

    final static int MSG_REFRESH_VIEW = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        utility = new Utility();
        listView = (ListView) findViewById(R.id.list_item);
        start_lift = (Button) findViewById(R.id.start_lift);
        start_lift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalOrder.clear();
                finalOrder = utility.getSequence(liftItemAdapter.getFloorSequence(), liftItemAdapter.getFloorDirection());
                toggleShowingCurrentFloors();
                showSequenceOnNextActivity();
                liftItemAdapter.clearFloorSequence();
                liftItemAdapter.clearFloorDirection();
            }
        });

        floorDetailsList = new ArrayList<>();
        createFloorDetailsTest(0);
        liftItemAdapter = new LiftItemAdapter(getApplicationContext(),TOTAL_NO_OF_FLOORS,floorDetailsList);
        listView.setAdapter(liftItemAdapter);
    }

    public void createFloorDetailsTest(int currentFloor) {
        floorDetailsList.clear();
        for(int i = 0; i < TOTAL_NO_OF_FLOORS;i++) {
            if (i == currentFloor) {
                floorDetailsList.add(new FloorDetails(i,true));
            } else {
                floorDetailsList.add(new FloorDetails(i,false));
            }
        }
    }

    public void toggleShowingCurrentFloors() {
        if (finalOrder != null && finalOrder.size() == 0) {
            return;
        }
        for (int i = 0 ;i < finalOrder.size() ; i++) {
            liftItemAdapter.refresh(finalOrder.get(i));
            liftItemAdapter.notifyDataSetChanged();
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                Log.e("Error ","message ="+e.getMessage());
            }
        }
    }

    public void showSequenceOnNextActivity() {
        if (finalOrder != null && finalOrder.size() == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < finalOrder.size() ; i++) {
            if (i == finalOrder.size() - 1) {
                sb.append(finalOrder.get(i));
            } else {
                sb.append(finalOrder.get(i)).append("->");
            }
        }

        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        intent.putExtra("Floor Order",sb.toString());
        startActivity(intent);
    }

    @Override
    protected void onStop() {
        super.onStop();
        this.finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        releaseResources();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }

    private void releaseResources() {
        if (finalOrder != null) {
            finalOrder.clear();
        }
        liftItemAdapter = null;
        floorDetailsList.clear();
    }
}
