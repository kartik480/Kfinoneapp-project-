package com.example.myapplicationkfinoneapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HelpFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_help, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Set up click listeners for support options
        view.findViewById(R.id.option_live_chat).setOnClickListener(v -> {
            // TODO: Implement live chat functionality
            Toast.makeText(getContext(), "Live chat support coming soon!", Toast.LENGTH_SHORT).show();
        });

        view.findViewById(R.id.option_call_support).setOnClickListener(v -> {
            // TODO: Implement call support functionality
            Toast.makeText(getContext(), "Call support coming soon!", Toast.LENGTH_SHORT).show();
        });

        // Set up click listeners for FAQs
        view.findViewById(R.id.faq_loan_process).setOnClickListener(v -> showFAQAnswer("The loan process involves:\n1. Checking eligibility\n2. Submitting required documents\n3. Loan approval\n4. Disbursement"));
        
        view.findViewById(R.id.faq_eligibility).setOnClickListener(v -> showFAQAnswer("Eligibility criteria include:\n- Age: 21-65 years\n- Minimum income\n- Good credit score\n- Required documents"));
        
        view.findViewById(R.id.faq_documents).setOnClickListener(v -> showFAQAnswer("Required documents:\n- PAN Card\n- Aadhaar Card\n- Income proof\n- Bank statements\n- Address proof"));
        
        view.findViewById(R.id.faq_repayment).setOnClickListener(v -> showFAQAnswer("Loan repayments can be made through:\n- Online banking\n- UPI\n- NEFT/RTGS\n- Auto-debit facility"));
    }

    private void showFAQAnswer(String answer) {
        // TODO: Implement a proper dialog or expandable view for FAQ answers
        Toast.makeText(getContext(), answer, Toast.LENGTH_LONG).show();
    }
} 