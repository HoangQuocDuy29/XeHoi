package com.example.de02;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class NhanVienActivity extends AppCompatActivity {

    private ListView listView;
    private List<String> nhanVienList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhan_vien);

        listView = findViewById(R.id.listview_nhan_vien);

        nhanVienList = new ArrayList<>();
        loadNhanVienFromJson();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, nhanVienList);
        listView.setAdapter(adapter);
    }

    private void loadNhanVienFromJson() {
        try {
            InputStream is = getResources().openRawResource(R.raw.nhan_vien);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            String json = new String(buffer, "UTF-8");

            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String ten = jsonObject.getString("ten");
                String viTri = jsonObject.getString("viTri");
                String phongBan = jsonObject.getString("phongBan");
                int luong = jsonObject.getInt("luong");

                String nhanVienInfo = "Tên: " + ten + "\nVị trí: " + viTri + "\nPhòng ban: " + phongBan + "\nLương: " + luong;
                nhanVienList.add(nhanVienInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}