package com.example.themintempire;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.themintempire.Fragments.GoOutFragment;
import com.example.themintempire.Fragments.GoldFragment;
import com.example.themintempire.Fragments.OrdersFragment;
import com.example.themintempire.Fragments.VideosFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    FrameLayout frameLayout;
    BottomNavigationView bottomNavigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //hide status bar
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //changing the color of status text
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        bottomNavigation = (BottomNavigationView) findViewById(R.id.bottomNavigation);
        bottomNavigation.setOnNavigationItemSelectedListener(navigation);
        frameLayout = (FrameLayout) findViewById(R.id.frameLayout);

//replacing default fragment on home activity
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new OrdersFragment()).commit();

    }
    private BottomNavigationView.OnNavigationItemSelectedListener navigation =
            new BottomNavigationView.OnNavigationItemSelectedListener() {

                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    Fragment selectedFragment = null;
                    switch (item.getItemId()){

                        case R.id.orders:
                            selectedFragment = new OrdersFragment();
                            break;

                            case R.id.goout:
                            selectedFragment = new GoOutFragment();
                                break;

                                case R.id.gold:
                                    selectedFragment = new GoldFragment();
                                    break;

                                    case R.id.videos:
                                        selectedFragment = new VideosFragment();
                                        break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, selectedFragment).commit();
                    return true;
                }
    };
}
