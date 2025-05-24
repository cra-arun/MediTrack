package com.example.ex1wifiservo;

import static java.security.AccessController.getContext;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class servodataview extends AppCompatActivity {
    DatabaseReference databaseReference;
    TextView min1, min2, min3, min4, hour1, hour2, hour3, hour4;
    Button submitbutton,notify;
    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servodataview);
        min1 = findViewById(R.id.min1);
        min2 = findViewById(R.id.min2);
        min3 = findViewById(R.id.min3);
        min4 = findViewById(R.id.min4);
        hour1 = findViewById(R.id.hour1);
        hour2 = findViewById(R.id.hour2);
        hour3 = findViewById(R.id.hour3);
        hour4 = findViewById(R.id.hour4);
        submitbutton = findViewById(R.id.submitbutton);
        String minute1 = getIntent().getStringExtra("min1");
        String minute2 = getIntent().getStringExtra("min2");
        String minute3 = getIntent().getStringExtra("min3");
        String minute4 = getIntent().getStringExtra("min4");
        String hours1 = getIntent().getStringExtra("hour1");
        String hours2 = getIntent().getStringExtra("hour2");
        String hours3 = getIntent().getStringExtra("hour3");
        String hours4 = getIntent().getStringExtra("hour4");
        min1.setText(minute1);
        min2.setText(minute2);
        min3.setText(minute3);
        min4.setText(minute4);
        hour1.setText(hours1);
        hour2.setText(hours2);
        hour3.setText(hours3);
        hour4.setText(hours4);
        DatabaseReference databaseReference1 = FirebaseDatabase.getInstance().getReference().child("irsensor").child("irsensor1");
        databaseReference1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //Integer value = dataSnapshot.getValue(Integer.class);
                if (dataSnapshot.exists()) {
                    int value = dataSnapshot.getValue(Integer.class);
                    if (value == 1) {
                        // If the value is 1, trigger a notification
                        NotificationHelper.showNotification(servodataview.this, "pharm guardian", "you didn't taken the medicine from box1");
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle potential errors
                Log.e("Firebase", "Error: " + databaseError.getMessage());
            }
        });
        DatabaseReference databaseReference2 = FirebaseDatabase.getInstance().getReference().child("irsensor").child("irsensor2");
        databaseReference2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //Integer value = dataSnapshot.getValue(Integer.class);
                if (dataSnapshot.exists()) {
                    int value = dataSnapshot.getValue(Integer.class);
                    if (value == 1) {
                        // If the value is 1, trigger a notification
                        NotificationHelper.showNotification(servodataview.this, "pharm guardian", "you didn't taken the medicine box2");
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle potential errors
                Log.e("Firebase", "Error: " + databaseError.getMessage());
            }
        });
        DatabaseReference databaseReference3 = FirebaseDatabase.getInstance().getReference().child("irsensor").child("irsensor3");
        databaseReference3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //Integer value = dataSnapshot.getValue(Integer.class);
                if (dataSnapshot.exists()) {
                    int value = dataSnapshot.getValue(Integer.class);
                    if (value == 1) {
                        // If the value is 1, trigger a notification
                        NotificationHelper.showNotification(servodataview.this, "pharm guardian", "you didn't taken the medicine from box3");
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle potential errors
                Log.e("Firebase", "Error: " + databaseError.getMessage());
            }
        });
        DatabaseReference databaseReference4 = FirebaseDatabase.getInstance().getReference().child("irsensor").child("irsensor4");
        databaseReference4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //Integer value = dataSnapshot.getValue(Integer.class);
                if (dataSnapshot.exists()) {
                    int value = dataSnapshot.getValue(Integer.class);
                    if (value == 1) {
                        // If the value is 1, trigger a notification
                        NotificationHelper.showNotification(servodataview.this, "pharm guardian", "you didn't taken the medicine from box4");
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle potential errors
                Log.e("Firebase", "Error: " + databaseError.getMessage());
            }
        });

        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(servodataview.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}