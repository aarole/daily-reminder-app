package com.aarole.studyzonezreminder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView remList = findViewById(R.id.remList);

        for(int i = 0; i<confirmAll.messageArray.size(); i++){
            String item = confirmAll.messageArray.get(i) + "  " + confirmAll.endDateArray.get(i) + "  " + confirmAll.startTimeArray.get(i);
            remList.append(item);
        }
    }
}
