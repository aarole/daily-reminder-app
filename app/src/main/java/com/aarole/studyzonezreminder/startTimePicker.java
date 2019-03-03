package com.aarole.studyzonezreminder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class startTimePicker extends AppCompatActivity {

    public static int startHour;
    public static int startMinute;
    public String startAMPM;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.starttime);

        final TimePicker startTime = findViewById(R.id.startTime);
        Button conf = findViewById(R.id.confirmBtn);
        conf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startHour = startTime.getHour();
                startMinute = startTime.getMinute();

                Intent intent = new Intent(startTimePicker.this, confirmAll.class);
                startActivity(intent);
            }
        });
    }

}
