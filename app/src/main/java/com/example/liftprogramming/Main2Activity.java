package com.example.liftprogramming;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        String order = intent.getStringExtra("Floor Order");
        TextView textView = (TextView) findViewById(R.id.text);
        textView.setText(order);
        textView.setTextSize(60);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(Main2Activity.this, MainActivity.class);
        startActivity(intent);
        this.finish();
    }
}
