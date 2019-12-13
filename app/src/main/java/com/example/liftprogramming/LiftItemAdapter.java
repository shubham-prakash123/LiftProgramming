package com.example.liftprogramming;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import java.util.ArrayList;
import java.util.List;

public class LiftItemAdapter extends BaseAdapter {

    private Context context;
    private int floors;
    private List<FloorDetails> list;
    private List<String> floorSequence = new ArrayList<>();
    private List<String> floorDirection = new ArrayList<>();

    public LiftItemAdapter(Context context, int floors, List<FloorDetails> list) {
        this.context = context;
        this.floors = floors;
        this.list = list;
    }

    public void refresh(int position) {
        for (FloorDetails floorDetails : list) {
            if (floorDetails.getFloorNo() == position) {
                floorDetails.setIsCurrentFloor(true);
            }
            else {
                floorDetails.setIsCurrentFloor(false);
            }
        }
    }

    @Override
    public int getCount() {
        return floors;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(
                    R.layout.lift_item, parent, false);
            Button currentFloor = (Button) convertView.findViewById(R.id.current_floor);
            Button buttonPane1 = (Button) convertView.findViewById(R.id.buttonPane1);
            buttonPane1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String p = String.valueOf(((Button)v).getText().toString().charAt(0));
                    floorSequence.add(p);
                    floorDirection.add("UP");
                }
            });
            Button buttonPane2 = (Button) convertView.findViewById(R.id.buttonPane2);
            buttonPane2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String p = String.valueOf(((Button)v).getText().toString().charAt(0));
                    floorSequence.add(p);
                    floorDirection.add("DOWN");
                }
            });
            convertView.setTag(new Holder(currentFloor,buttonPane1,buttonPane2));
        }
        Holder holder = (Holder) convertView.getTag();
        if (position == 0 || position == 6) {
            holder.buttonPane2.setVisibility(View.GONE);
        }
        if (position == 6) {
            holder.buttonPane1.setText(R.string.ground_floor_text);
        } else {
            holder.buttonPane1.setText(getFloorDisplayNumber(position)+" "+"⬆");
        }
        if (holder.buttonPane2.getVisibility() == View.VISIBLE) {
            holder.buttonPane2.setText(getFloorDisplayNumber(position)+" "+"⬇");
        }
        if (list.get(getFloorDisplayNumber(position)).isCurrentFloor()) {
            holder.currentFloor.setBackgroundColor(context.getResources().getColor(R.color.colorGreen));
        } else {
            holder.currentFloor.setBackgroundColor(context.getResources().getColor(R.color.colorGrey));
        }

        return convertView;
    }

    private int getFloorDisplayNumber(int number) {
        return (Constants.TOTAL_NO_OF_FLOORS - number);
    }

    private static class Holder {

        public final Button currentFloor;
        public final Button buttonPane1;
        public final Button buttonPane2;

        public Holder(Button currentFloor, Button buttonPane1, Button buttonPane2) {
            this.currentFloor = currentFloor;
            this.buttonPane1 = buttonPane1;
            this.buttonPane2 = buttonPane2;
        }
    }

    public List<FloorDetails> getData() {
        return list;
    }

    public List<String> getFloorSequence() {
        return floorSequence;
    }

    public void clearFloorSequence() {
        floorSequence.clear();
    }

    public List<String> getFloorDirection() {
        return floorDirection;
    }

    public void clearFloorDirection() {
        floorDirection.clear();
    }
}
