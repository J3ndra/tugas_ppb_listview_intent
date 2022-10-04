package com.junianto.ppbrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.junianto.ppbrecyclerview.adapter.ListHandphoneAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final ArrayList<String> handphoneImages = new ArrayList<>();
    private final ArrayList<String> handphoneName = new ArrayList<>();
    private final ArrayList<String> handphoneMerk = new ArrayList<>();
    private final ArrayList<String> handphonePrice = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvHp = findViewById(R.id.rv_hp);
        rvHp.setHasFixedSize(true);

        setData();
    }

    private void rvHandphone() {
        RecyclerView recyclerView = findViewById(R.id.rv_hp);
        ListHandphoneAdapter adapter = new ListHandphoneAdapter(handphoneImages, handphoneName, handphoneMerk, handphonePrice, this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setData() {
        handphoneImages.add("https://i01.appmifile.com/webfile/globalimg/products/m/redmi-note-10-pro/Specheader_03s.jpg");
        handphoneImages.add("https://i01.appmifile.com/webfile/globalimg/id/cms/8D4A9454-AE1E-17F9-4109-0933928EBD24!800x800!85.jpg");
        handphoneImages.add("https://asset.kompas.com/crops/x-FBDDyCOnUqPVRpLoOfxuRKy_A=/225x150:2025x1350/750x500/data/photo/2022/02/08/6202974ac9175.jpg");

        handphoneName.add("Redmi Note 10 Pro");
        handphoneName.add("Xiaomi 11T");
        handphoneName.add("Samsung S22");

        handphoneMerk.add("Xiaomi");
        handphoneMerk.add("Xiaomi");
        handphoneMerk.add("Samsung");

        handphonePrice.add("Rp. 3.290.000");
        handphonePrice.add("Rp. 4.699.000");
        handphonePrice.add("Rp. 11.340.000");

        rvHandphone();
    }

}