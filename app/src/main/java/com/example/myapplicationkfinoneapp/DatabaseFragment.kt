package com.example.myapplicationkfinoneapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.card.MaterialCardView

class DatabaseFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_database, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set up click listeners for database cards
        view.findViewById<MaterialCardView>(R.id.add_database_card)?.setOnClickListener {
            Toast.makeText(requireContext(), "Add Database functionality coming soon", Toast.LENGTH_SHORT).show()
        }

        view.findViewById<MaterialCardView>(R.id.my_sal_data_card)?.setOnClickListener {
            Toast.makeText(requireContext(), "My SAL Data functionality coming soon", Toast.LENGTH_SHORT).show()
        }

        view.findViewById<MaterialCardView>(R.id.my_senp_data_card)?.setOnClickListener {
            Toast.makeText(requireContext(), "My SENP Data functionality coming soon", Toast.LENGTH_SHORT).show()
        }

        view.findViewById<MaterialCardView>(R.id.my_sep_data_card)?.setOnClickListener {
            Toast.makeText(requireContext(), "My SEP Data functionality coming soon", Toast.LENGTH_SHORT).show()
        }

        view.findViewById<MaterialCardView>(R.id.my_nri_data_card)?.setOnClickListener {
            Toast.makeText(requireContext(), "My NRI Data functionality coming soon", Toast.LENGTH_SHORT).show()
        }

        view.findViewById<MaterialCardView>(R.id.my_educational_data_card)?.setOnClickListener {
            Toast.makeText(requireContext(), "My Educational Data functionality coming soon", Toast.LENGTH_SHORT).show()
        }

        view.findViewById<MaterialCardView>(R.id.team_sal_data_card)?.setOnClickListener {
            Toast.makeText(requireContext(), "Team SAL Data functionality coming soon", Toast.LENGTH_SHORT).show()
        }

        view.findViewById<MaterialCardView>(R.id.team_senp_data_card)?.setOnClickListener {
            Toast.makeText(requireContext(), "Team SENP Data functionality coming soon", Toast.LENGTH_SHORT).show()
        }

        view.findViewById<MaterialCardView>(R.id.team_sep_data_card)?.setOnClickListener {
            Toast.makeText(requireContext(), "Team SEP Data functionality coming soon", Toast.LENGTH_SHORT).show()
        }

        view.findViewById<MaterialCardView>(R.id.team_nri_data_card)?.setOnClickListener {
            Toast.makeText(requireContext(), "Team NRI Data functionality coming soon", Toast.LENGTH_SHORT).show()
        }

        view.findViewById<MaterialCardView>(R.id.team_educational_data_card)?.setOnClickListener {
            Toast.makeText(requireContext(), "Team Educational Data functionality coming soon", Toast.LENGTH_SHORT).show()
        }
    }
} 