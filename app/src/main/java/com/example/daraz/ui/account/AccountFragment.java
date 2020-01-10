package com.example.daraz.ui.account;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.daraz.R;
import com.example.daraz.ui.JoinusActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AccountFragment extends Fragment {

    private AccountViewModel accountViewModel;
    Button btnjoinus;

    BottomNavigationView order_navigation,service_navigation;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        accountViewModel =
                ViewModelProviders.of(this).get(AccountViewModel.class);
        View root = inflater.inflate(R.layout.fragment_account, container, false);

        this.order_navigation = root.findViewById(R.id.order_navigation);
        this.service_navigation = root.findViewById(R.id.service_navigation);
        order_navigation.setItemIconTintList(null);
        service_navigation.setItemIconTintList(null);


        this.btnjoinus = root.findViewById(R.id.btnjoinus);

        btnjoinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), JoinusActivity.class));
            }
        });
        return root;


    }

}