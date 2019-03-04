package com.aarole.studyzonezreminder;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

public class confirmAll extends AppCompatActivity {
    public static String time = startTimePicker.startHour + ":" + startTimePicker.startMinute;
    public static String day = endDatePicker.endYear + "-" + endDatePicker.endMonth + "-" + endDatePicker.endDay;
    public static Editable notifMessage;
    public static String msg;

    public static ArrayList<String> messageArray = new ArrayList<>();
    public static ArrayList<String> endDateArray = new ArrayList<>();
    public static ArrayList<String> startTimeArray = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirm);
        Button conf = findViewById(R.id.confBtn);

        TextView timedisp = findViewById(R.id.startTimeDisp);
        TextView daydisp = findViewById(R.id.endDateDisp);
        EditText notifMsg = findViewById(R.id.notifMsg);

        timedisp.setText(time);
        daydisp.setText(day);

        notifMessage = notifMsg.getText();

        conf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                msg = notifMessage.toString();

                messageArray.add(msg);
                endDateArray.add(day);
                startTimeArray.add(time);

                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.HOUR_OF_DAY, startTimePicker.startHour);
                calendar.set(Calendar.MINUTE, startTimePicker.startMinute);
                calendar.set(Calendar.SECOND, 0);

                Intent intent1 = new Intent(confirmAll.this, Notification_receiver.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(confirmAll.this, 0,intent1, PendingIntent.FLAG_UPDATE_CURRENT);
                AlarmManager am = (AlarmManager) confirmAll.this.getSystemService(confirmAll.this.ALARM_SERVICE);
                am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);

                Intent intent = new Intent(confirmAll.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
