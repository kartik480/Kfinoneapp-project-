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

public class LoanEligibilityFragment extends Fragment {

    private TextInputEditText panNumberInput;
    private MaterialButton continueButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_loan_eligibility, container, false);
        
        panNumberInput = view.findViewById(R.id.pan_number_input);
        continueButton = view.findViewById(R.id.continue_button);

        continueButton.setOnClickListener(v -> validateAndContinue());

        return view;
    }

    private void validateAndContinue() {
        String panNumber = panNumberInput.getText().toString().trim();
        
        if (panNumber.isEmpty()) {
            panNumberInput.setError("Please enter PAN number");
            return;
        }

        // PAN number format validation (5 letters + 4 numbers + 1 letter)
        if (!panNumber.matches("[A-Z]{5}[0-9]{4}[A-Z]{1}")) {
            panNumberInput.setError("Invalid PAN number format");
            return;
        }

        // TODO: Add your API call or further processing here
        Toast.makeText(getContext(), "Processing eligibility check...", Toast.LENGTH_SHORT).show();
    }
} 