package com.example.sampleloginexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.Toast;

import com.example.sampleloginlibrary.LoginFragment;

public class MainActivity extends AppCompatActivity  {
    LoginFragment loginFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //this.getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager=getSupportFragmentManager();
        loginFragment=(LoginFragment)fragmentManager.findFragmentById(R.id.fragment);
        loginFragment.LoginStart("");


    }

}