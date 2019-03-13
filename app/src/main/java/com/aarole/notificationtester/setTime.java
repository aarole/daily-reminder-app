package com.aarole.notificationtester;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TimePicker;

public class setTime extends AppCompatActivity {

    public int hour;
    public int minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_time);

        final TimePicker time = findViewById(R.id.setTime);



        findViewById(R.id.confBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hour = time.getHour();
                minute = time.getMinute();
                Intent intent = new Intent(setTime.this, MainActivity.class);
                intent.putExtra("hour", hour);
                intent.putExtra("minute", minute);
                startActivity(intent);
                //finish();
            }
        });

    }
}
