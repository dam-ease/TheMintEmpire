package com.example.themintempire;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.themintempire.Adapters.PlateAdapter;
import com.example.themintempire.EmailLoginRegister.EmailLoginActivity;
import com.example.themintempire.EmailLoginRegister.EmailRegisterActivity;
import com.example.themintempire.Models.PlateModel;
import com.example.themintempire.PhoneLoginRegister.PhoneLoginActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<PlateModel> plateModelList;
    private PlateAdapter plateAdapter;
    private LinearLayout emailContinue, phoneContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // hide status bar start
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        //}
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //hide status bar end
        emailContinue = findViewById(R.id.linear1);
        phoneContinue = findViewById(R.id.linear2);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setKeepScreenOn(true);
        recyclerView.setHasFixedSize(true);


        plateModelList = new ArrayList<>();
        plateModelList.add(new PlateModel(R.drawable.logo2));
        plateModelList.add(new PlateModel(R.drawable.logo2));
        plateModelList.add(new PlateModel(R.drawable.logo2));
        plateModelList.add(new PlateModel(R.drawable.logo2));
        plateModelList.add(new PlateModel(R.drawable.logo2));
        plateModelList.add(new PlateModel(R.drawable.logo2));

        plateAdapter = new PlateAdapter(plateModelList, this);
        recyclerView.setAdapter(plateAdapter);
        plateAdapter.notifyDataSetChanged();
        autoScroll();

        emailContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EmailLoginActivity.class);
                startActivity(intent);
                Animatoo.animateSlideDown(MainActivity.this);
            }
        });
        phoneContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PhoneLoginActivity.class);
                startActivity(intent);
                Animatoo.animateSlideDown(MainActivity.this);
            }
        });
    }


    //auto scrolling
    public void autoScroll() {
        final int speedScroll = 0;
        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            int count = 0;

            @Override
            public void run() {
                if (count == plateAdapter.getItemCount())
                    count = 0;
                if (count < plateAdapter.getItemCount()) {
                    recyclerView.smoothScrollToPosition(++count);
                    handler.postDelayed(this, speedScroll);
                }
            }
        };
        handler.postDelayed(runnable, speedScroll);
    }

    public void goToHomePage(View view) {
    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
    startActivity(intent);
    finish();
    Animatoo.animateSwipeLeft(this);
    }
}