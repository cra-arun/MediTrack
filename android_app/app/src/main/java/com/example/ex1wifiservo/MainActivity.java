package com.example.ex1wifiservo;

import static java.security.AccessController.getContext;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private  EditText editTextHours1,editTextHours2,editTextHours3, editTextHours4;
    private EditText editTextMinutes1,editTextMinutes2,editTextMinutes3,editTextMinutes4;
    private Button senddata;
    DatabaseReference databaseReference;
    //FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextHours1=findViewById(R.id.editTextHours1);
        editTextHours2=findViewById(R.id.editTextHours2);
        editTextHours3=findViewById(R.id.editTextHours3);
        editTextHours4=findViewById(R.id.editTextHours4);
        editTextMinutes1=findViewById(R.id.editTextMinutes1);
        editTextMinutes2=findViewById(R.id.editTextMinutes2);
        editTextMinutes3=findViewById(R.id.editTextMinutes3);
        editTextMinutes4=findViewById(R.id.editTextMinutes4);
        databaseReference=FirebaseDatabase.getInstance().getReference("servo");
        senddata=findViewById(R.id.buttonSendData);
        senddata.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                insertservodata();
                String min1 =editTextMinutes1.getText().toString();
                String min2 =editTextMinutes2.getText().toString();
                String min3 =editTextMinutes3.getText().toString();
                String min4 =editTextMinutes4.getText().toString();
                String hour1 =editTextHours1.getText().toString();
                String hour2 =editTextHours2.getText().toString();
                String hour3 =editTextHours3.getText().toString();
                String hour4 =editTextHours4.getText().toString();
                Intent intent = new Intent(MainActivity.this,servodataview.class);
                intent.putExtra("min1",min1);
                intent.putExtra("min2",min2);
                intent.putExtra("min3",min3);
                intent.putExtra("min4",min4);
                intent.putExtra("hour1",hour1);
                intent.putExtra("hour2",hour2);
                intent.putExtra("hour3",hour3);
                intent.putExtra("hour4",hour4);
                startActivity(intent);
             }
        });
    }
    private void insertservodata() {
        String min1 = editTextMinutes1.getText().toString();
        String min2 = editTextMinutes2.getText().toString();
        String min3 = editTextMinutes3.getText().toString();
        String min4 = editTextMinutes4.getText().toString();
        String hour1 = editTextHours1.getText().toString();
        String hour2 = editTextHours2.getText().toString();
        String hour3 = editTextHours3.getText().toString();
        String hour4 = editTextHours4.getText().toString();
        servodata servodata = new servodata(min1,hour1,min2,hour2,min3,hour3,min4,hour4 );
        databaseReference.setValue(servodata);
        Toast.makeText(MainActivity.this,"data inserted",Toast.LENGTH_SHORT).show();

    }
}