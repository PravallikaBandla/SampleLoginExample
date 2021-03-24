package com.example.sampleloginlibrary;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;


/**
 * Created by Pravallika on 23-03-2021.
 * Updated by Pravallika on 23-03-2021.
 * <p>
 * <p>
 * <p>
 * Copyright (c) 2021 MouriTech. All rights reserved.
 */
public class SampleLoginMessage extends AppCompatActivity {

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
    }

    public static void s(Context c, String message){

        Toast.makeText(c,message,Toast.LENGTH_SHORT).show();

    }
}
