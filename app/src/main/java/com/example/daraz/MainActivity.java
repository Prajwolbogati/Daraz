package com.example.daraz;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.daraz.ui.account.AccountFragment;
import com.example.daraz.ui.cart.CartFragment;
import com.example.daraz.ui.home.HomeFragment;
import com.example.daraz.ui.message.MessageFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView nav_bottom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nav_bottom = findViewById(R.id.nav_bottom);

        nav_bottom.setOnNavigationItemSelectedListener(navigationitemselectedlistener);
        openFragment(new HomeFragment());
    }

    BottomNavigationView.OnNavigationItemSelectedListener navigationitemselectedlistener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.navigation_home:
                            openFragment(new HomeFragment());
                            return true;
                        case R.id.navigation_message:
                            openFragment(new MessageFragment());
                            return true;
                        case R.id.navigation_cart:
                            openFragment(new CartFragment());
                            return true;
                        case R.id.navigation_account:
                            openFragment(new AccountFragment());
                            return true;
                    }
                    return false;
                }
            };

    public void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.commit();
    }

}

