package com.junianto.ppbrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    ImageView imageViewHandphoneImage;
    TextView tvHandphoneName, tvHandphoneMerk, tvHandphonePrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imageViewHandphoneImage = findViewById(R.id.ivHandphoneImage);
        tvHandphoneName = findViewById(R.id.tvHandphoneName);
        tvHandphoneMerk = findViewById(R.id.tvHandphoneMerk);
        tvHandphonePrice = findViewById(R.id.tvHandphonePrice);

        getExtra();
    }

    private void getExtra() {
        if(getIntent().hasExtra("handphoneImage") && getIntent().hasExtra("handphoneName") && getIntent().hasExtra("handphoneMerk") && getIntent().hasExtra("handphonePrice")) {
            String handphoneImage = getIntent().getStringExtra("handphoneImage");
            String handphoneName = getIntent().getStringExtra("handphoneName");
            String handphoneMerk = getIntent().getStringExtra("handphoneMerk");
            String handphonePrice = getIntent().getStringExtra("handphonePrice");

            setData(handphoneImage, handphoneName, handphoneMerk, handphonePrice);
        }
    }

    private void setData(String handphoneImage, String handphoneName, String handphoneMerk, String handphonePrice) {
        Glide.with(this).asBitmap()
                .load(handphoneImage)
                .into(imageViewHandphoneImage);
        tvHandphoneName.setText(handphoneName);
        tvHandphoneMerk.setText(handphoneMerk);
        tvHandphonePrice.setText(handphonePrice);
    }
}