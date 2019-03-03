package com.example.tez;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ValidationScreen_Activity extends AppCompatActivity {
       ImageView imageview;
       Button b;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.validation_screen);

        imageview = (ImageView) findViewById(R.id.imageView2);
        Bitmap bmp = (Bitmap) getIntent().getParcelableExtra("image");
        imageview.setImageBitmap(bmp);
        b=(Button) findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ValidationScreen_Activity.this,Sample1Activity.class);
                startActivity(intent);
            }
        });

          }
}