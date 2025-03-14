package com.arcreane.webstartdroid;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class StartUpActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.start_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = null;
        if (item.getItemId() == R.id.demo) {
            intent = new Intent(this, DemoLayout.class);
        } else if (item.getItemId() == R.id.demo) {
            intent = new Intent(this, DemoLayout.class);
        }else if (item.getItemId() == R.id.exo1) {
            intent = new Intent(this, ExoActivity.class);
        }else if (item.getItemId() == R.id.exo2) {
            intent = new Intent(this, Exo2Activity.class);
        }else if (item.getItemId() == R.id.main) {
            intent = new Intent(this, MainActivity.class);
        }
        if(intent != null) {
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_start_up);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button button2 = findViewById(R.id.button2);
        TextView urlText = findViewById(R.id.urlText);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri path = Uri.parse("http://" + urlText.getText().toString());
                Intent webIntent = new Intent(Intent.ACTION_VIEW, path);
                startActivity(webIntent);
            }
        });

    }

    public void startActivityClass(View view) {
        Intent mainActivity = new Intent(this, MainActivity.class);
        startActivity(mainActivity);
    }
}