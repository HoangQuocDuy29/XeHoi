package com.example.de02;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class HangXeHoiActivity extends AppCompatActivity {

    private RadioButton honda;
    private RadioButton bmw;
    private RadioButton kia;
    private RadioButton ford;
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hang_xe_hoi);

        honda = findViewById(R.id.radio_honda);
        bmw = findViewById(R.id.radio_bmw);
        kia = findViewById(R.id.radio_kia);
        ford = findViewById(R.id.radio_ford);
        nextButton = findViewById(R.id.next_button);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = "";
                if (honda.isChecked()) {
                    message = "Honda";
                } else if (bmw.isChecked()) {
                    message = "BMW";
                } else if (kia.isChecked()) {
                    message = "KIA";
                } else if (ford.isChecked()) {
                    message = "Ford";
                }
                Toast.makeText(HangXeHoiActivity.this, message, Toast.LENGTH_SHORT).show();

                // Chuyển sang màn hình tiếp theo
                Intent intent = new Intent(HangXeHoiActivity.this, NhanVienActivity.class);
                intent.putExtra("hang_xe", message);
                startActivity(intent);
            }
        });
    }
}