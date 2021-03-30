package com.example.sampleloginlibrary;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Created by Pravallika on 26-03-2021.
 * Updated by Pravallika on 26-03-2021.
 * <p>
 * <p>
 * <p>
 * Copyright (c) 2021 MouriTech. All rights reserved.
 */
public class Dashboard extends AppCompatActivity {

    TextView tv_resObj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        tv_resObj = (TextView) findViewById(R.id.tv_resObj);

        Bundle extras = getIntent().getExtras();
        String response;

        if(extras != null){
            response = extras.getString("response");
            tv_resObj.setText(response);
        }
    }
}
