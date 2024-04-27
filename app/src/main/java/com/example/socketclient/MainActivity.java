package com.example.socketclient;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = (EditText) findViewById(R.id.textMessage);

        Button buttonSend = findViewById(R.id.buttonSend);
        buttonSend.setBackgroundColor(getResources().getColor(R.color.green));

        Button closeButton = findViewById(R.id.closeButton);
        closeButton.setBackgroundColor(getResources().getColor(R.color.red));
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void send(View v) {
        MessageSender messageSender = new MessageSender();
        messageSender.execute(et.getText().toString());
        et.setText("");
    }
}