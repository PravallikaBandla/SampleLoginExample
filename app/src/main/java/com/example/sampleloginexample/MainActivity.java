package com.example.sampleloginexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;

import com.example.sampleloginlibrary.LoginFragment;
import com.example.sampleloginlibrary.SampleLoginMessage;

public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager=getSupportFragmentManager();
        LoginFragment loginFragment=(LoginFragment)fragmentManager.findFragmentById(R.id.fragment);
        loginFragment.method();
    }
}