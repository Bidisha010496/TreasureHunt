package com.example.bidisha.ace;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;

import java.io.File;
import java.io.FileNotFoundException;

public class MainActivity extends Activity implements View.OnClickListener {

    int quesNo=0;
    long t=300000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("MainActivity","This is above activity_main");
        setContentView(R.layout.activity_main);
        Log.i("MainActivity","This is below activity_main");
        final Button start = (Button) findViewById(R.id.button2);
        CheckBox agree = (CheckBox) findViewById(R.id.checkBox);
        agree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                {
                    start.setEnabled(true);
                }
                else
                {
                    start.setEnabled(false);
                }
            }

        });
        start.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.button2:
                Intent i = new Intent(this,Questions.class);
                i.putExtra("question_no",quesNo);
                i.putExtra("time",t);
                startActivity(i);
                break;
        }

    }
}