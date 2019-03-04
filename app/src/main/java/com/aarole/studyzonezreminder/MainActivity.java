package com.aarole.studyzonezreminder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView remList = findViewById(R.id.remList);

        for(int i = 0; i<confirmAll.messageArray.size(); i++){
            String item = i + ". " + confirmAll.messageArray.get(i) + "  " + confirmAll.endDateArray.get(i) + "  " + confirmAll.startTimeArray.get(i);
            remList.append(item);
        }

        findViewById(R.id.addBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, endDatePicker.class);
                startActivity(intent);
            }
        });
    }
}
