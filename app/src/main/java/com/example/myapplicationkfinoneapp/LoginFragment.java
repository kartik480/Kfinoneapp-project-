package com.example.myapplicationkfinoneapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginFragment extends Fragment {
    private TextInputLayout tilPhone, tilPassword;
    private TextInputEditText etPhone, etPassword;
    private MaterialButton btnLogin;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        
        initializeViews(view);
        setupListeners();
        
        return view;
    }

    private void initializeViews(View view) {
        tilPhone = view.findViewById(R.id.tilPhone);
        tilPassword = view.findViewById(R.id.tilPassword);
        etPhone = view.findViewById(R.id.etPhone);
        etPassword = view.findViewById(R.id.etPassword);
        btnLogin = view.findViewById(R.id.btnLogin);
    }

    private void setupListeners() {
        btnLogin.setOnClickListener(v -> validateAndLogin());
    }

    private void validateAndLogin() {
        String phone = etPhone.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        // Reset errors
        tilPhone.setError(null);
        tilPassword.setError(null);

        // Validate phone
        if (phone.isEmpty()) {
            tilPhone.setError("Phone number is required");
            return;
        }
        if (phone.length() != 10) {
            tilPhone.setError("Enter a valid 10-digit phone number");
            return;
        }

        // Validate password
        if (password.isEmpty()) {
            tilPassword.setError("Password is required");
            return;
        }
        if (password.length() < 6) {
            tilPassword.setError("Password must be at least 6 characters");
            return;
        }

        // TODO: Implement actual login logic here
        // For now, just navigate to dashboard
        Intent intent = new Intent(getActivity(), DashboardActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        getActivity().finish();
    }
} 