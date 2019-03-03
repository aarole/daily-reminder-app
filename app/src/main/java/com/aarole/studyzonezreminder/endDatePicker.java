package com.aarole.studyzonezreminder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

public class endDatePicker extends AppCompatActivity {

    public static int endYear;
    public static int endMonth;
    public static int endDay;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enddate);

        final DatePicker pickEndDate = findViewById(R.id.selectDate);
        Button confDate = findViewById(R.id.confirmDateBtn);
        confDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                endYear = pickEndDate.getYear();
                endMonth = pickEndDate.getMonth();
                endDay = pickEndDate.getDayOfMonth();

                Intent intent = new Intent(endDatePicker.this, startTimePicker.class);
                startActivity(intent);
            }
        });
    }
}
