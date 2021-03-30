package com.example.sampleloginlibrary;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Pravallika on 24-03-2021.
 * Updated by Pravallika on 24-03-2021.
 * <p>
 * <p>
 * <p>
 * Copyright (c) 2021 MouriTech. All rights reserved.
 */

public class LoginFragment extends Fragment {

    public TextView btn_submit,tv_login;
    EditText et_name,et_password;
    UserService userService;
    ImageView iv_visible,iv_invisible;



    //Validations for Login page
    private boolean validateLogin(String username, String password){

        //Username/email validations
        if(username == null || username.trim().length() == 0) {
            Toast.makeText(getContext(), "Username is required", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if(username.contains("@"))
        {
            if(!android.util.Patterns.EMAIL_ADDRESS.matcher(username).matches())
            {
                Toast.makeText(getContext(), "Enter valid Email", Toast.LENGTH_SHORT).show();
                return false;
            }
        }
        //else if(String a=Integer.parseInt(username))
        else if(TextUtils.isDigitsOnly(username))
        {
            if(username.length()!=10)
            {
                Toast.makeText(getContext(), "Enter valid Number", Toast.LENGTH_SHORT).show();
                return false;
            }
        }


        //Password validation
        if(password == null || password.trim().length() == 0){
            Toast.makeText(getContext(), "Password is required", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (password.length()<6)
        {
            Toast.makeText(getContext(), "Invalid Password", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }


    //Setting BASE_URL by the User
    public  UserService getUserService(String BASE_URL){
        Log.e("BaseUrl","BaseUrl"+BASE_URL);
        return RetrofitClient.getClient(BASE_URL).create(UserService.class);
    }


    private void doLogin(final String username,final String password,String BASE_URL){
        userService = getUserService(BASE_URL);
        Call<ResObj> call = userService.login(username,password);
        call.enqueue(new Callback<ResObj>() {
            @Override
            public void onResponse(Call call, Response response) {
                if(response.isSuccessful()){
                    ResObj resObj = (ResObj) response.body();
                    if(resObj.getMessage().equals("true")){

//                        Intent intent=new Intent(getActivity(),Dashboard.class);
//                        intent.putExtra("response", "resObj"+ resObj);
//                        startActivity(intent);
                        Toast.makeText(getContext(),"Login Successful",Toast.LENGTH_LONG).show();

                    } else {
                        Toast.makeText(getContext(), "The username or password is incorrect", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getContext(), "Error! Please try again!", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }



    public void LoginStart(String BASE_URL)
    {
        btn_submit=(TextView) getActivity().findViewById(R.id.btn_submit);
        et_name=(EditText)getActivity().findViewById(R.id.et_name);
        et_password=(EditText)getActivity().findViewById(R.id.et_password);
        iv_visible=(ImageView)getActivity().findViewById(R.id.iv_visible);
        iv_invisible=(ImageView)getActivity().findViewById(R.id.iv_invisible);
        tv_login=(TextView)getActivity().findViewById(R.id.tv_login);

        //Animations for Login Page
        Animation aniSlide_tv = AnimationUtils.loadAnimation(getContext(),R.anim.item_animation_fall_down);
        Animation aniSlide_btn = AnimationUtils.loadAnimation(getContext(),R.anim.in_animation_button);
        Animation aniSlide_et = AnimationUtils.loadAnimation(getContext(),R.anim.in_animation);
        tv_login.startAnimation(aniSlide_tv);
        et_name.startAnimation(aniSlide_et);
        et_password.startAnimation(aniSlide_et);
        btn_submit.startAnimation(aniSlide_btn);


        //Password hide
        iv_visible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et_password.setTransformationMethod(new PasswordTransformationMethod());
                iv_visible.setVisibility(View.GONE);
                iv_invisible.setVisibility(View.VISIBLE);
            }
        });

        //Password visible
        iv_invisible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et_password.setTransformationMethod(null);
                iv_invisible.setVisibility(View.GONE);
                iv_visible.setVisibility(View.VISIBLE);
            }
        });

        //Login button click
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = et_name.getText().toString();
                String password = et_password.getText().toString();
                //validate form
                if(validateLogin(username, password)){
                    //do login
                    doLogin(username, password,BASE_URL);
                }
            }
        });
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_login, container, false);

    }

}