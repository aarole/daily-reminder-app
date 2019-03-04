package com.aarole.studyzonezreminder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static String remMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView remList = findViewById(R.id.remList);
        final EditText tbRem = findViewById(R.id.remMsg);

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

        findViewById(R.id.removeBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                remMsg = tbRem.getText().toString();

                int index = confirmAll.messageArray.indexOf(remMsg);
                confirmAll.messageArray.remove(index);
                confirmAll.endDateArray.remove(index);
                confirmAll.startTimeArray.remove(index);
            }
        });
    }
}
