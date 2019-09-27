package com.example.itmo_android_2019_2020;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private boolean switched = true;
    private String switchKey = "isSwitched";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View s) {
                if (switched) {
                    getApplication().setTheme(R.style.AppThemeDracula);
                    switched = false;
                } else {
                    getApplication().setTheme(R.style.AppTheme);
                    switched = true;
                }
            }
        });
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putBoolean(switchKey, switched);
        super.onSaveInstanceState(outState);

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        switched = savedInstanceState.getBoolean(switchKey);
    }
}
