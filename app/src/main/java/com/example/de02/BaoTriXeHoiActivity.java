package com.example.de02;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class BaoTriXeHoiActivity extends AppCompatActivity {

    private RadioButton baoTriDinhKy;
    private RadioButton suaChuaLon;
    private RadioButton suaChuaNho;
    private RadioButton kiemTraXe;
    private RadioGroup dichVuPhapLyGroup;
    private RadioButton muaBaoHiem;
    private RadioButton kiemDinh;
    private Button chooseButton;
    private Button exitButton;
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bao_tri_xe_hoi);

        baoTriDinhKy = findViewById(R.id.radio_bao_tri_dinh_ky);
        suaChuaLon = findViewById(R.id.radio_sua_chua_lon);
        suaChuaNho = findViewById(R.id.radio_sua_chua_nho);
        kiemTraXe = findViewById(R.id.radio_kiem_tra_xe);
        dichVuPhapLyGroup = findViewById(R.id.radioGroup_phap_ly);
        muaBaoHiem = findViewById(R.id.radio_mua_bao_hiem);
        kiemDinh = findViewById(R.id.radio_kiem_dinh);
        chooseButton = findViewById(R.id.choose_button);
        exitButton = findViewById(R.id.exit_button);
        nextButton = findViewById(R.id.next_button);

        chooseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = "";
                if (baoTriDinhKy.isChecked()) {
                    message = "Bảo trì định kỳ";
                } else if (suaChuaLon.isChecked()) {
                    message = "Sửa chữa lớn";
                } else if (suaChuaNho.isChecked()) {
                    message = "Sửa chữa nhỏ";
                } else if (kiemTraXe.isChecked()) {
                    message = "Kiểm tra xe";
                } else if (muaBaoHiem.isChecked()) {
                    message = "Hỗ trợ mua bảo hiểm";
                } else if (kiemDinh.isChecked()) {
                    message = "Hỗ trợ kiểm định";
                }
                Toast.makeText(BaoTriXeHoiActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BaoTriXeHoiActivity.this, HangXeHoiActivity.class);
                startActivity(intent);
            }
        });
    }
}