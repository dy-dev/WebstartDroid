package com.arcreane.webstartdroid;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Exo2Activity extends AppCompatActivity {
    class Result {
        int a;
        String b;

        public Result(int a, String b) {
            this.a = a;
            this.b = b;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exo2);

        ArrayList<Result> results = new ArrayList() {
            {
                add(new Result(10, "too small"));
                add(new Result(15, "too big"));
            }
        };

        ListView lv = findViewById(R.id.hintListView);
        ArrayAdapter<Result> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_2, android.R.id.text1, results) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView text1 = view.findViewById(android.R.id.text1);
                TextView text2 = view.findViewById(android.R.id.text2);

                text1.setText("" + results.get(position).a);
                text2.setText(results.get(position).b);

                return view;
            }
        };
        lv.setAdapter(adapter);
    }
}