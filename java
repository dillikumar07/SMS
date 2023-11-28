package com.example.smstrial;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {

    private static final int PERMISSION_REQUEST_SEND_SMS = 0;

    private Button sendBtn;
    private EditText txtPhoneNo;
    private EditText txtMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendBtn = findViewById(R.id.btn);
        txtPhoneNo = findViewById(R.id.phn);
        txtMessage = findViewById(R.id.msg);

        sendBtn.setOnClickListener(v->{
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) == PERMISSION_REQUEST_SEND_SMS){
                SmsManager man = SmsManager.getDefault();
                man.sendTextMessage(txtPhoneNo.getText().toString(),null, txtMessage.getText().toString(),null,null);
            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS},PERMISSION_REQUEST_SEND_SMS);
            }
        });
    }
}
