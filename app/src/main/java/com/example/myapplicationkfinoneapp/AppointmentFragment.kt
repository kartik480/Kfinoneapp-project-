package com.example.myapplicationkfinoneapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.card.MaterialCardView

class AppointmentFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_appointment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set up click listeners for appointment cards
        view.findViewById<MaterialCardView>(R.id.add_appointment_card)?.setOnClickListener {
            Toast.makeText(context, "Add Appointment functionality coming soon", Toast.LENGTH_SHORT).show()
        }

        view.findViewById<MaterialCardView>(R.id.my_sal_appt_card)?.setOnClickListener {
            Toast.makeText(context, "My SAL Appointment functionality coming soon", Toast.LENGTH_SHORT).show()
        }

        view.findViewById<MaterialCardView>(R.id.my_senp_appt_card)?.setOnClickListener {
            Toast.makeText(context, "My SENP Appointment functionality coming soon", Toast.LENGTH_SHORT).show()
        }

        view.findViewById<MaterialCardView>(R.id.my_sep_appt_card)?.setOnClickListener {
            Toast.makeText(context, "My SEP Appointment functionality coming soon", Toast.LENGTH_SHORT).show()
        }

        view.findViewById<MaterialCardView>(R.id.my_nri_appt_card)?.setOnClickListener {
            Toast.makeText(context, "My NRI Appointment functionality coming soon", Toast.LENGTH_SHORT).show()
        }

        view.findViewById<MaterialCardView>(R.id.my_educational_appt_card)?.setOnClickListener {
            Toast.makeText(context, "My Educational Appointment functionality coming soon", Toast.LENGTH_SHORT).show()
        }

        view.findViewById<MaterialCardView>(R.id.team_sal_appt_card)?.setOnClickListener {
            Toast.makeText(context, "Team SAL Appointment functionality coming soon", Toast.LENGTH_SHORT).show()
        }

        view.findViewById<MaterialCardView>(R.id.team_senp_appt_card)?.setOnClickListener {
            Toast.makeText(context, "Team SENP Appointment functionality coming soon", Toast.LENGTH_SHORT).show()
        }

        view.findViewById<MaterialCardView>(R.id.team_sep_appt_card)?.setOnClickListener {
            Toast.makeText(context, "Team SEP Appointment functionality coming soon", Toast.LENGTH_SHORT).show()
        }

        view.findViewById<MaterialCardView>(R.id.team_nri_appt_card)?.setOnClickListener {
            Toast.makeText(context, "Team NRI Appointment functionality coming soon", Toast.LENGTH_SHORT).show()
        }

        view.findViewById<MaterialCardView>(R.id.team_educational_appt_card)?.setOnClickListener {
            Toast.makeText(context, "Team Educational Appointment functionality coming soon", Toast.LENGTH_SHORT).show()
        }
    }
} 