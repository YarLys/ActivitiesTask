package com.example.intentstudy;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.intentstudy.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    final static String KEY = "key1";
    final static int REQUESTCODE = 123;
    final static String num = "1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.BACK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("Activity", num);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        binding.GO2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, secondActivity.class);
                intent.putExtra("Activity", num);
                startActivityForResult(intent, REQUESTCODE);
            }
        });

        binding.GO3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, thirdActivity.class);
                intent.putExtra("Activity", num);
                startActivityForResult(intent, REQUESTCODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUESTCODE && resultCode == RESULT_OK) {
            Toast.makeText(this, "From " + data.getStringExtra("Activity") + " to " + num, Toast.LENGTH_LONG).show();
        }
    }
}