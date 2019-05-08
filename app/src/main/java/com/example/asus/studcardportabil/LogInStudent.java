package com.example.asus.studcardportabil;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;

public class LogInStudent extends AppCompatActivity {

    final String server_url = "http://172.20.10.2:8080/LicentaServer/login";
    EditText username;
    EditText password;
    Button loginButton;

    ServiceUser serviceUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginstudent);

        serviceUser = ServiceFactory.getUserService();


        RotateAnimation anim = new RotateAnimation(0.0f, 360.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        anim.setInterpolator(new LinearInterpolator());
        anim.setRepeatCount(Animation.ABSOLUTE);
        anim.setDuration(700);

// Start animating the image
        final ImageView splash = (ImageView) findViewById(R.id.imageView);
        splash.startAnimation(anim);
        loginButton = (Button) findViewById(R.id.loginButton);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                String usern = username.getText().toString();
                String pass = password.getText().toString();
                // RequestQueue queue = Volley.newRequestQueue(MainActivity.this);

                final HashMap<String, String> user = new HashMap<String, String>();
                user.put("studentUsername", usern);
                user.put("studentPassword", pass);

                SharedPreferences sharedpreferences = getSharedPreferences("myprefs",
                        Context.MODE_PRIVATE);

                String token = sharedpreferences.getString("token", null);
                String[] items;
                if (token != null) {
                    items = token.split(",");
                    if (usern.equals(items[0]) && pass.equals(items[1])) {
                        startActivity(new Intent(LogInStudent.this, MainActivity.class));
                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(LogInStudent.this);
                        builder.setTitle("Alert");
                        builder.setMessage("Wrong username or password\n Please try again and check the internet connection");
                        builder.setNegativeButton("OK", null);
                        AlertDialog dialog = builder.create();
                        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogTheme;
                        dialog.show();
                    }
                }


                serviceUser.doLogin(user).enqueue(new Callback<MyResponse>() {
                    @Override
                    public void onResponse(Call<MyResponse> call, retrofit2.Response<MyResponse> response) {
                        if (response.body().getResponse().equals("true")) {
                            startActivity(new Intent(LogInStudent.this, MainActivity.class));
                            SharedPreferences sharedpreferences = getSharedPreferences("myprefs",
                                    Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedpreferences.edit();

                            editor.remove("token");
                            editor.commit();

                            editor.putString("token", user.values().toArray()[0].toString() + "," + user.values().toArray()[1].toString());
                            editor.commit();
                        } else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(LogInStudent.this);
                            builder.setTitle("Alert");
                            builder.setMessage("Wrong username or password\n Please try again");
                            builder.setNegativeButton("OK", null);
                            AlertDialog dialog = builder.create();
                            dialog.getWindow().getAttributes().windowAnimations = R.style.DialogTheme;
                            dialog.show();

                        }
                    }

                    @Override
                    public void onFailure(Call<MyResponse> call, Throwable t) {

                    }
                });
            }
        });
    }

}
