package com.example.intentstudy;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.intentstudy.databinding.ActivitySecondBinding;

public class secondActivity extends AppCompatActivity {
    final static String num = "2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivitySecondBinding binding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        /*String str = getIntent().getStringExtra(MainActivity.KEY);
        binding.TV.setText(str);*/

        binding.BACK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("Activity", num);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        binding.GO1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(secondActivity.this, MainActivity.class);
                intent.putExtra("Activity", num);
                startActivityForResult(intent, 123);
            }
        });

        binding.GO3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(secondActivity.this, thirdActivity.class);
                intent.putExtra("Activity", num);
                startActivityForResult(intent, 123);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 123 && resultCode == RESULT_OK) {
            Toast.makeText(this, "From " + data.getStringExtra("Activity") + " to " + num, Toast.LENGTH_LONG).show();
        }
    }
}