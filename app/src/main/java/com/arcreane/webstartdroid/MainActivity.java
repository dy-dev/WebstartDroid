package com.arcreane.webstartdroid;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        TextView tv = findViewById(R.id.my_second_textview);


        //String s = getResources().getString(R.string.app_name);
        //Color c = Color.valueOf(ContextCompat.getColor(this, R.color.other));

        TextView mySecondTV = findViewById(R.id.my_second_textview);
        TextView myThirdTV = findViewById(R.id.my_third_textview);

        mySecondTV.setText(R.string.first_new_entry);
        var tmp = getResources().getString(R.string.second_new_entry).toUpperCase();
        tmp = tmp.substring(2,5);
        myThirdTV.setText(tmp);

//
//        TextView myTextView = new TextView(this);
//        myTextView.setText("Hello From Code");
//        myTextView.setTextSize(32);
//
//        setContentView(myTextView);
//
//
//        TextView myTextView2 = new TextView(this);
//        myTextView.setText("Hello from second test ");
//        myTextView.setTextSize(14);
//
//        setContentView(myTextView);
    }
}