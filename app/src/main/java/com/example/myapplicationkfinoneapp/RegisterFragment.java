package com.example.myapplicationkfinoneapp;

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
import java.util.regex.Pattern;

public class RegisterFragment extends Fragment {
    private TextInputLayout tilFullName, tilEmail, tilPhone, tilPassword, tilConfirmPassword;
    private TextInputEditText etFullName, etEmail, etPhone, etPassword, etConfirmPassword;
    private MaterialButton btnRegister;

    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
            Pattern.CASE_INSENSITIVE);

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        
        initializeViews(view);
        setupListeners();
        
        return view;
    }

    private void initializeViews(View view) {
        tilFullName = view.findViewById(R.id.tilFullName);
        tilEmail = view.findViewById(R.id.tilEmail);
        tilPhone = view.findViewById(R.id.tilPhone);
        tilPassword = view.findViewById(R.id.tilPassword);
        tilConfirmPassword = view.findViewById(R.id.tilConfirmPassword);

        etFullName = view.findViewById(R.id.etFullName);
        etEmail = view.findViewById(R.id.etEmail);
        etPhone = view.findViewById(R.id.etPhone);
        etPassword = view.findViewById(R.id.etPassword);
        etConfirmPassword = view.findViewById(R.id.etConfirmPassword);

        btnRegister = view.findViewById(R.id.btnRegister);
    }

    private void setupListeners() {
        btnRegister.setOnClickListener(v -> validateAndRegister());
    }

    private void validateAndRegister() {
        String fullName = etFullName.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String phone = etPhone.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        String confirmPassword = etConfirmPassword.getText().toString().trim();

        // Reset errors
        tilFullName.setError(null);
        tilEmail.setError(null);
        tilPhone.setError(null);
        tilPassword.setError(null);
        tilConfirmPassword.setError(null);

        // Validate full name
        if (fullName.isEmpty()) {
            tilFullName.setError("Full name is required");
            return;
        }

        // Validate email
        if (email.isEmpty()) {
            tilEmail.setError("Email is required");
            return;
        }
        if (!EMAIL_PATTERN.matcher(email).matches()) {
            tilEmail.setError("Enter a valid email address");
            return;
        }

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

        // Validate confirm password
        if (confirmPassword.isEmpty()) {
            tilConfirmPassword.setError("Please confirm your password");
            return;
        }
        if (!password.equals(confirmPassword)) {
            tilConfirmPassword.setError("Passwords do not match");
            return;
        }

        // TODO: Implement actual registration logic here
        // For now, just show a success message
        Toast.makeText(getContext(), "Registration successful!", Toast.LENGTH_SHORT).show();
    }
} 