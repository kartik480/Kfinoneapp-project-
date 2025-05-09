package com.example.myapplicationkfinoneapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MyAccountFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_my_account, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Set up click listeners for account options
        view.findViewById(R.id.option_personal_info).setOnClickListener(v -> {
            // TODO: Implement personal information functionality
            Toast.makeText(getContext(), "Personal Information coming soon!", Toast.LENGTH_SHORT).show();
        });

        view.findViewById(R.id.option_kyc_details).setOnClickListener(v -> {
            // TODO: Implement KYC details functionality
            Toast.makeText(getContext(), "KYC Details coming soon!", Toast.LENGTH_SHORT).show();
        });

        view.findViewById(R.id.option_bank_accounts).setOnClickListener(v -> {
            // TODO: Implement bank accounts functionality
            Toast.makeText(getContext(), "Bank Accounts coming soon!", Toast.LENGTH_SHORT).show();
        });

        // Set up click listeners for settings
        view.findViewById(R.id.option_notifications).setOnClickListener(v -> {
            // TODO: Implement notifications settings
            Toast.makeText(getContext(), "Notifications Settings coming soon!", Toast.LENGTH_SHORT).show();
        });

        view.findViewById(R.id.option_security).setOnClickListener(v -> {
            // TODO: Implement security settings
            Toast.makeText(getContext(), "Security Settings coming soon!", Toast.LENGTH_SHORT).show();
        });
    }
} 