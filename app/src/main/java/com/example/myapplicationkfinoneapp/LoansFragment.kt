package com.example.myapplicationkfinoneapp

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView
import com.google.android.material.textfield.TextInputEditText
import java.util.Calendar

class LoansFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_loans, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set up click listeners
        view.findViewById<MaterialCardView>(R.id.add_partner_card)?.setOnClickListener {
            showAddPartnerDialog()
        }

        view.findViewById<MaterialCardView>(R.id.my_partner_card)?.setOnClickListener {
            showMyPartnerDialog()
        }

        view.findViewById<MaterialCardView>(R.id.add_connector_card)?.setOnClickListener {
            showAddConnectorDialog()
        }

        view.findViewById<MaterialCardView>(R.id.my_connectors_card)?.setOnClickListener {
            showMyConnectorsDialog()
        }

        view.findViewById<MaterialCardView>(R.id.add_agent_card)?.setOnClickListener {
            showAddAgentDialog()
        }

        view.findViewById<MaterialCardView>(R.id.my_agent_card)?.setOnClickListener {
            showMyAgentDialog()
        }

        view.findViewById<MaterialCardView>(R.id.eligibility_card)?.setOnClickListener {
            showLoanEligibilityDialog()
        }
    }

    private fun showAddPartnerDialog() {
        val dialog = Dialog(requireContext())
        dialog.setContentView(R.layout.dialog_add_partner)
        dialog.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

        // Initialize views
        val partnerImageCard = dialog.findViewById<MaterialCardView>(R.id.partnerImageCard)
        val partnerImage = dialog.findViewById<ImageView>(R.id.partnerImage)
        val fullNameInput = dialog.findViewById<TextInputEditText>(R.id.fullNameInput)
        val aliasNameInput = dialog.findViewById<TextInputEditText>(R.id.aliasNameInput)
        val phoneInput = dialog.findViewById<TextInputEditText>(R.id.phoneInput)
        val emailInput = dialog.findViewById<TextInputEditText>(R.id.emailInput)
        val dobInput = dialog.findViewById<TextInputEditText>(R.id.dobInput)
        val aadharInput = dialog.findViewById<TextInputEditText>(R.id.aadharInput)
        val panInput = dialog.findViewById<TextInputEditText>(R.id.panInput)
        val partnerTypeInput = dialog.findViewById<AutoCompleteTextView>(R.id.partnerTypeInput)
        val branchStateInput = dialog.findViewById<AutoCompleteTextView>(R.id.branchStateInput)
        val branchLocationInput = dialog.findViewById<TextInputEditText>(R.id.branchLocationInput)
        val addressInput = dialog.findViewById<TextInputEditText>(R.id.addressInput)
        val passwordInput = dialog.findViewById<TextInputEditText>(R.id.passwordInput)
        val submitButton = dialog.findViewById<MaterialButton>(R.id.submitButton)

        // Set up partner type dropdown
        val partnerTypes = arrayOf("Individual", "Business", "Corporate")
        val partnerTypeAdapter = ArrayAdapter(requireContext(), R.layout.item_dropdown, partnerTypes)
        partnerTypeInput.setAdapter(partnerTypeAdapter)

        // Set up branch state dropdown
        val states = arrayOf("Andhra Pradesh", "Karnataka", "Tamil Nadu", "Kerala", "Telangana")
        val stateAdapter = ArrayAdapter(requireContext(), R.layout.item_dropdown, states)
        branchStateInput.setAdapter(stateAdapter)

        // Set up date picker for DOB
        dobInput.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            DatePickerDialog(
                requireContext(),
                { _, selectedYear, selectedMonth, selectedDay ->
                    val date = String.format("%02d/%02d/%d", selectedDay, selectedMonth + 1, selectedYear)
                    dobInput.setText(date)
                },
                year,
                month,
                day
            ).show()
        }

        // Set up image selection
        partnerImageCard.setOnClickListener {
            // Implement image selection logic here
            // You'll need to add image picker functionality
        }

        // Set up submit button
        submitButton.setOnClickListener {
            // Validate inputs
            if (validateInputs(
                    fullNameInput,
                    phoneInput,
                    emailInput,
                    dobInput,
                    aadharInput,
                    panInput,
                    partnerTypeInput,
                    branchStateInput,
                    branchLocationInput,
                    addressInput,
                    passwordInput
                )
            ) {
                // TODO: Implement partner creation logic
                dialog.dismiss()
            }
        }

        dialog.show()
    }

    private fun showMyPartnerDialog() {
        val dialog = Dialog(requireContext())
        dialog.setContentView(R.layout.dialog_my_partner)
        dialog.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

        // Initialize views
        val partnerTypeFilter = dialog.findViewById<AutoCompleteTextView>(R.id.partnerTypeFilter)
        val branchStateFilter = dialog.findViewById<AutoCompleteTextView>(R.id.branchStateFilter)
        val branchLocationFilter = dialog.findViewById<AutoCompleteTextView>(R.id.branchLocationFilter)
        val filterButton = dialog.findViewById<MaterialButton>(R.id.filterButton)
        val resetButton = dialog.findViewById<MaterialButton>(R.id.resetButton)
        val noPartnersFound = dialog.findViewById<TextView>(R.id.noPartnersFound)
        val partnerList = dialog.findViewById<RecyclerView>(R.id.partnerList)

        // Set up partner type dropdown
        val partnerTypes = arrayOf("Individual", "Business", "Corporate")
        val partnerTypeAdapter = ArrayAdapter(requireContext(), R.layout.item_dropdown, partnerTypes)
        partnerTypeFilter.setAdapter(partnerTypeAdapter)

        // Set up branch state dropdown
        val states = arrayOf("Andhra Pradesh", "Karnataka", "Tamil Nadu", "Kerala", "Telangana")
        val stateAdapter = ArrayAdapter(requireContext(), R.layout.item_dropdown, states)
        branchStateFilter.setAdapter(stateAdapter)

        // Set up branch location dropdown (this would typically be populated based on selected state)
        val locations = arrayOf("Location 1", "Location 2", "Location 3", "Location 4", "Location 5")
        val locationAdapter = ArrayAdapter(requireContext(), R.layout.item_dropdown, locations)
        branchLocationFilter.setAdapter(locationAdapter)

        // Set up filter button
        filterButton.setOnClickListener {
            // TODO: Implement filter logic
            // For now, just show the "No Partners Found" message
            noPartnersFound.visibility = View.VISIBLE
            partnerList.visibility = View.GONE
        }

        // Set up reset button
        resetButton.setOnClickListener {
            partnerTypeFilter.text.clear()
            branchStateFilter.text.clear()
            branchLocationFilter.text.clear()
            noPartnersFound.visibility = View.VISIBLE
            partnerList.visibility = View.GONE
        }

        dialog.show()
    }

    private fun showAddConnectorDialog() {
        val dialog = Dialog(requireContext())
        dialog.setContentView(R.layout.dialog_add_connector)
        dialog.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

        // Initialize views
        val phoneNumberInput = dialog.findViewById<TextInputEditText>(R.id.phoneNumberInput)
        val fullNameInput = dialog.findViewById<TextInputEditText>(R.id.fullNameInput)
        val emailInput = dialog.findViewById<TextInputEditText>(R.id.emailInput)
        val branchStateInput = dialog.findViewById<AutoCompleteTextView>(R.id.branchStateInput)
        val altPhoneNumberInput = dialog.findViewById<TextInputEditText>(R.id.altPhoneNumberInput)
        val connectorTypeInput = dialog.findViewById<AutoCompleteTextView>(R.id.connectorTypeInput)
        val branchLocationInput = dialog.findViewById<AutoCompleteTextView>(R.id.branchLocationInput)
        val submitButton = dialog.findViewById<MaterialButton>(R.id.submitButton)

        // Set up dropdowns
        val states = arrayOf("Maharashtra", "Karnataka", "Tamil Nadu", "Delhi", "Gujarat")
        val connectorTypes = arrayOf("SAL", "SENP", "SEP", "NRI", "Education")
        val locations = arrayOf("Mumbai", "Bangalore", "Chennai", "New Delhi", "Ahmedabad")

        val stateAdapter = ArrayAdapter(requireContext(), R.layout.item_dropdown, states)
        val connectorTypeAdapter = ArrayAdapter(requireContext(), R.layout.item_dropdown, connectorTypes)
        val locationAdapter = ArrayAdapter(requireContext(), R.layout.item_dropdown, locations)

        branchStateInput.setAdapter(stateAdapter)
        connectorTypeInput.setAdapter(connectorTypeAdapter)
        branchLocationInput.setAdapter(locationAdapter)

        // Set up submit button
        submitButton.setOnClickListener {
            // Validate inputs
            if (phoneNumberInput.text.toString().length != 10) {
                phoneNumberInput.error = "Please enter a valid 10-digit phone number"
                return@setOnClickListener
            }

            if (fullNameInput.text.toString().isEmpty()) {
                fullNameInput.error = "Please enter full name"
                return@setOnClickListener
            }

            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(emailInput.text.toString()).matches()) {
                emailInput.error = "Please enter a valid email address"
                return@setOnClickListener
            }

            if (branchStateInput.text.toString().isEmpty()) {
                branchStateInput.error = "Please select branch state"
                return@setOnClickListener
            }

            if (altPhoneNumberInput.text.toString().isNotEmpty() && altPhoneNumberInput.text.toString().length != 10) {
                altPhoneNumberInput.error = "Please enter a valid 10-digit phone number"
                return@setOnClickListener
            }

            if (connectorTypeInput.text.toString().isEmpty()) {
                connectorTypeInput.error = "Please select connector type"
                return@setOnClickListener
            }

            if (branchLocationInput.text.toString().isEmpty()) {
                branchLocationInput.error = "Please select branch location"
                return@setOnClickListener
            }

            // TODO: Handle form submission
            Toast.makeText(requireContext(), "Connector added successfully", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }

        dialog.show()
    }

    private fun showMyConnectorsDialog() {
        val dialog = Dialog(requireContext())
        dialog.setContentView(R.layout.dialog_my_connectors)
        dialog.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

        // Initialize views
        val connectorTypeFilter = dialog.findViewById<AutoCompleteTextView>(R.id.connectorTypeFilter)
        val branchStateFilter = dialog.findViewById<AutoCompleteTextView>(R.id.branchStateFilter)
        val branchLocationFilter = dialog.findViewById<AutoCompleteTextView>(R.id.branchLocationFilter)
        val filterButton = dialog.findViewById<MaterialButton>(R.id.filterButton)
        val resetButton = dialog.findViewById<MaterialButton>(R.id.resetButton)
        val noConnectionsFound = dialog.findViewById<TextView>(R.id.noConnectionsFound)
        val connectorList = dialog.findViewById<RecyclerView>(R.id.connectorList)

        // Set up connector type dropdown
        val connectorTypes = arrayOf("SAL", "SENP", "SEP", "NRI", "Education")
        val connectorTypeAdapter = ArrayAdapter(requireContext(), R.layout.item_dropdown, connectorTypes)
        connectorTypeFilter.setAdapter(connectorTypeAdapter)

        // Set up branch state dropdown
        val states = arrayOf("Maharashtra", "Karnataka", "Tamil Nadu", "Delhi", "Gujarat")
        val stateAdapter = ArrayAdapter(requireContext(), R.layout.item_dropdown, states)
        branchStateFilter.setAdapter(stateAdapter)

        // Set up branch location dropdown
        val locations = arrayOf("Mumbai", "Bangalore", "Chennai", "New Delhi", "Ahmedabad")
        val locationAdapter = ArrayAdapter(requireContext(), R.layout.item_dropdown, locations)
        branchLocationFilter.setAdapter(locationAdapter)

        // Set up filter button
        filterButton.setOnClickListener {
            // TODO: Implement filter logic
            // For now, just show the "No Connections Found" message
            noConnectionsFound.visibility = View.VISIBLE
            connectorList.visibility = View.GONE
        }

        // Set up reset button
        resetButton.setOnClickListener {
            connectorTypeFilter.text.clear()
            branchStateFilter.text.clear()
            branchLocationFilter.text.clear()
            noConnectionsFound.visibility = View.VISIBLE
            connectorList.visibility = View.GONE
        }

        dialog.show()
    }

    private fun showAddAgentDialog() {
        val dialog = Dialog(requireContext())
        dialog.setContentView(R.layout.dialog_add_agent)
        dialog.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

        // Initialize views
        val phoneNumberInput = dialog.findViewById<TextInputEditText>(R.id.phoneNumberInput)
        val fullNameInput = dialog.findViewById<TextInputEditText>(R.id.fullNameInput)
        val companyNameInput = dialog.findViewById<TextInputEditText>(R.id.companyNameInput)
        val emailInput = dialog.findViewById<TextInputEditText>(R.id.emailInput)
        val branchStateInput = dialog.findViewById<AutoCompleteTextView>(R.id.branchStateInput)
        val addressInput = dialog.findViewById<AutoCompleteTextView>(R.id.addressInput)
        val altPhoneNumberInput = dialog.findViewById<TextInputEditText>(R.id.altPhoneNumberInput)
        val partnerTypeInput = dialog.findViewById<AutoCompleteTextView>(R.id.partnerTypeInput)
        val branchLocationInput = dialog.findViewById<AutoCompleteTextView>(R.id.branchLocationInput)
        val visitingCardInput = dialog.findViewById<AutoCompleteTextView>(R.id.visitingCardInput)
        val submitButton = dialog.findViewById<MaterialButton>(R.id.submitButton)

        // Set up dropdowns
        val states = arrayOf("Maharashtra", "Karnataka", "Tamil Nadu", "Delhi", "Gujarat")
        val partnerTypes = arrayOf("Individual", "Business", "Corporate")
        val locations = arrayOf("Mumbai", "Bangalore", "Chennai", "New Delhi", "Ahmedabad")
        val addresses = arrayOf("Address 1", "Address 2", "Address 3", "Address 4", "Address 5")
        val visitingCards = arrayOf("Card 1", "Card 2", "Card 3", "Card 4", "Card 5")

        val stateAdapter = ArrayAdapter(requireContext(), R.layout.item_dropdown, states)
        val partnerTypeAdapter = ArrayAdapter(requireContext(), R.layout.item_dropdown, partnerTypes)
        val locationAdapter = ArrayAdapter(requireContext(), R.layout.item_dropdown, locations)
        val addressAdapter = ArrayAdapter(requireContext(), R.layout.item_dropdown, addresses)
        val visitingCardAdapter = ArrayAdapter(requireContext(), R.layout.item_dropdown, visitingCards)

        branchStateInput.setAdapter(stateAdapter)
        partnerTypeInput.setAdapter(partnerTypeAdapter)
        branchLocationInput.setAdapter(locationAdapter)
        addressInput.setAdapter(addressAdapter)
        visitingCardInput.setAdapter(visitingCardAdapter)

        // Set up submit button
        submitButton.setOnClickListener {
            // Validate inputs
            if (phoneNumberInput.text.toString().length != 10) {
                phoneNumberInput.error = "Please enter a valid 10-digit phone number"
                return@setOnClickListener
            }

            if (fullNameInput.text.toString().isEmpty()) {
                fullNameInput.error = "Please enter full name"
                return@setOnClickListener
            }

            if (companyNameInput.text.toString().isEmpty()) {
                companyNameInput.error = "Please enter company name"
                return@setOnClickListener
            }

            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(emailInput.text.toString()).matches()) {
                emailInput.error = "Please enter a valid email address"
                return@setOnClickListener
            }

            if (branchStateInput.text.toString().isEmpty()) {
                branchStateInput.error = "Please select branch state"
                return@setOnClickListener
            }

            if (addressInput.text.toString().isEmpty()) {
                addressInput.error = "Please select address"
                return@setOnClickListener
            }

            if (altPhoneNumberInput.text.toString().isNotEmpty() && altPhoneNumberInput.text.toString().length != 10) {
                altPhoneNumberInput.error = "Please enter a valid 10-digit phone number"
                return@setOnClickListener
            }

            if (partnerTypeInput.text.toString().isEmpty()) {
                partnerTypeInput.error = "Please select type of partner"
                return@setOnClickListener
            }

            if (branchLocationInput.text.toString().isEmpty()) {
                branchLocationInput.error = "Please select branch location"
                return@setOnClickListener
            }

            if (visitingCardInput.text.toString().isEmpty()) {
                visitingCardInput.error = "Please select visiting card"
                return@setOnClickListener
            }

            // TODO: Handle form submission
            Toast.makeText(requireContext(), "Agent added successfully", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }

        dialog.show()
    }

    private fun showMyAgentDialog() {
        // TODO: Implement My Agent dialog
        Toast.makeText(requireContext(), "My Agent functionality coming soon", Toast.LENGTH_SHORT).show()
    }

    private fun showLoanEligibilityDialog() {
        val dialog = Dialog(requireContext())
        dialog.setContentView(R.layout.dialog_loan_eligibility)
        dialog.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

        // Initialize views
        val panNumberInput = dialog.findViewById<TextInputEditText>(R.id.panNumberInput)
        val checkEligibilityButton = dialog.findViewById<MaterialButton>(R.id.checkEligibilityButton)

        // Set up check eligibility button
        checkEligibilityButton.setOnClickListener {
            val panNumber = panNumberInput.text.toString().trim()
            
            if (panNumber.isEmpty()) {
                panNumberInput.error = "Please enter PAN number"
                return@setOnClickListener
            }

            // PAN number format validation (5 letters + 4 numbers + 1 letter)
            if (!panNumber.matches(Regex("[A-Z]{5}[0-9]{4}[A-Z]{1}"))) {
                panNumberInput.error = "Invalid PAN number format"
                return@setOnClickListener
            }

            // TODO: Add your API call or further processing here
            Toast.makeText(requireContext(), "Checking loan eligibility...", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }

        dialog.show()
    }

    private fun validateInputs(
        fullName: TextInputEditText,
        phone: TextInputEditText,
        email: TextInputEditText,
        dob: TextInputEditText,
        aadhar: TextInputEditText,
        pan: TextInputEditText,
        partnerType: AutoCompleteTextView,
        branchState: AutoCompleteTextView,
        branchLocation: TextInputEditText,
        address: TextInputEditText,
        password: TextInputEditText
    ): Boolean {
        var isValid = true

        // Validate full name
        if (fullName.text.isNullOrEmpty()) {
            fullName.error = "Full name is required"
            isValid = false
        }

        // Validate phone
        if (phone.text.isNullOrEmpty() || phone.text?.length != 10) {
            phone.error = "Valid 10-digit phone number is required"
            isValid = false
        }

        // Validate email
        if (email.text.isNullOrEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email.text.toString()).matches()) {
            email.error = "Valid email is required"
            isValid = false
        }

        // Validate DOB
        if (dob.text.isNullOrEmpty()) {
            dob.error = "Date of birth is required"
            isValid = false
        }

        // Validate Aadhar
        if (aadhar.text.isNullOrEmpty() || aadhar.text?.length != 12) {
            aadhar.error = "Valid 12-digit Aadhar number is required"
            isValid = false
        }

        // Validate PAN
        if (pan.text.isNullOrEmpty() || pan.text?.length != 10) {
            pan.error = "Valid 10-character PAN is required"
            isValid = false
        }

        // Validate partner type
        if (partnerType.text.isNullOrEmpty()) {
            partnerType.error = "Partner type is required"
            isValid = false
        }

        // Validate branch state
        if (branchState.text.isNullOrEmpty()) {
            branchState.error = "Branch state is required"
            isValid = false
        }

        // Validate branch location
        if (branchLocation.text.isNullOrEmpty()) {
            branchLocation.error = "Branch location is required"
            isValid = false
        }

        // Validate address
        if (address.text.isNullOrEmpty()) {
            address.error = "Address is required"
            isValid = false
        }

        // Validate password
        if (password.text.isNullOrEmpty() || password.text?.length!! < 6) {
            password.error = "Password must be at least 6 characters"
            isValid = false
        }

        return isValid
    }
} 