package com.example.myapplicationkfinoneapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.widget.Toast
import com.google.android.material.card.MaterialCardView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import android.widget.LinearLayout
import android.widget.Spinner
import android.widget.TextView
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.google.android.material.button.MaterialButton
import android.app.Dialog
import android.widget.AutoCompleteTextView
import android.widget.EditText
import com.google.android.material.textfield.TextInputEditText
import android.widget.DatePicker
import android.app.DatePickerDialog
import java.util.*

class LoansFragment : Fragment() {

    private lateinit var imageCarousel: ViewPager2
    private lateinit var dotsIndicator: TabLayout
    private lateinit var appointmentSection: LinearLayout
    private lateinit var transactionsSection: LinearLayout
    private lateinit var documentsSection: LinearLayout
    private lateinit var fileSection: LinearLayout
    private lateinit var moreSection: LinearLayout
    private lateinit var fileTypeSpinner: Spinner
    private lateinit var selectedFileText: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_loans, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set up image carousel
        imageCarousel = view.findViewById(R.id.imageCarousel)
        dotsIndicator = view.findViewById(R.id.dotsIndicator)

        // Set up sections
        appointmentSection = view.findViewById(R.id.appointment_section)
        fileSection = view.findViewById(R.id.file_section)
        transactionsSection = view.findViewById(R.id.transactions_section)
        documentsSection = view.findViewById(R.id.documents_section)
        moreSection = view.findViewById(R.id.more_section)

        // Set up file chooser
        setupFileChooser(view)

        // Set up the image carousel adapter
        val carouselAdapter = LoansImageCarouselAdapter(getSampleImages())
        imageCarousel.adapter = carouselAdapter

        // Now attach the dots indicator
        TabLayoutMediator(dotsIndicator, imageCarousel) { _, _ -> }.attach()

        // Setup appointment section click listeners
        view.findViewById<MaterialCardView>(R.id.add_appointment_card).setOnClickListener {
            showAddAppointmentDialog()
        }

        view.findViewById<MaterialCardView>(R.id.my_sal_appt_card).setOnClickListener {
            Toast.makeText(context, "My SAL Appointment - Coming Soon", Toast.LENGTH_SHORT).show()
        }

        view.findViewById<MaterialCardView>(R.id.my_senp_appt_card).setOnClickListener {
            Toast.makeText(context, "My SENP Appointment - Coming Soon", Toast.LENGTH_SHORT).show()
        }

        view.findViewById<MaterialCardView>(R.id.my_sep_appt_card).setOnClickListener {
            Toast.makeText(context, "My SEP Appointment - Coming Soon", Toast.LENGTH_SHORT).show()
        }

        view.findViewById<MaterialCardView>(R.id.my_nri_appt_card).setOnClickListener {
            Toast.makeText(context, "My NRI Appointment - Coming Soon", Toast.LENGTH_SHORT).show()
        }

        view.findViewById<MaterialCardView>(R.id.my_educational_appt_card).setOnClickListener {
            Toast.makeText(context, "My Educational Appointment - Coming Soon", Toast.LENGTH_SHORT).show()
        }

        view.findViewById<MaterialCardView>(R.id.team_sal_appt_card).setOnClickListener {
            Toast.makeText(context, "Team SAL Appointment - Coming Soon", Toast.LENGTH_SHORT).show()
        }

        view.findViewById<MaterialCardView>(R.id.team_senp_appt_card).setOnClickListener {
            Toast.makeText(context, "Team SENP Appointment - Coming Soon", Toast.LENGTH_SHORT).show()
        }

        view.findViewById<MaterialCardView>(R.id.team_sep_appt_card).setOnClickListener {
            Toast.makeText(context, "Team SEP Appointment - Coming Soon", Toast.LENGTH_SHORT).show()
        }

        view.findViewById<MaterialCardView>(R.id.team_nri_appt_card).setOnClickListener {
            Toast.makeText(context, "Team NRI Appointment - Coming Soon", Toast.LENGTH_SHORT).show()
        }

        view.findViewById<MaterialCardView>(R.id.team_educational_appt_card).setOnClickListener {
            Toast.makeText(context, "Team Educational Appointment - Coming Soon", Toast.LENGTH_SHORT).show()
        }

        // Setup transactions section click listeners
        view.findViewById<MaterialCardView>(R.id.view_transactions_card).setOnClickListener {
            Toast.makeText(context, "View Transactions - Coming Soon", Toast.LENGTH_SHORT).show()
        }

        // Setup file section click listeners
        view.findViewById<MaterialCardView>(R.id.file_chooser_card).setOnClickListener {
            showSection(fileSection)
        }

        // Setup agent section click listeners
        view.findViewById<MaterialCardView>(R.id.add_agent_card).setOnClickListener {
            showAddAgentDialog()
        }

        view.findViewById<MaterialCardView>(R.id.my_agent_card).setOnClickListener {
            Toast.makeText(context, "My Agent - Coming Soon", Toast.LENGTH_SHORT).show()
        }

        // Setup more section click listeners
        view.findViewById<MaterialCardView>(R.id.dsa_code_card).setOnClickListener {
            Toast.makeText(context, "DSA Code - Coming Soon", Toast.LENGTH_SHORT).show()
        }

        view.findViewById<MaterialCardView>(R.id.bankers_card).setOnClickListener {
            Toast.makeText(context, "Bankers - Coming Soon", Toast.LENGTH_SHORT).show()
        }

        // Show appointment section by default
        showSection(appointmentSection)
    }

    private fun showAddAppointmentDialog() {
        val dialog = Dialog(requireContext())
        dialog.setContentView(R.layout.dialog_add_appointment)
        dialog.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )

        // Initialize dropdowns
        setupAppointmentDropdowns(dialog)

        // Setup visiting card upload
        setupAppointmentVisitingCardUpload(dialog)

        // Setup submit button
        dialog.findViewById<MaterialButton>(R.id.submitButton).setOnClickListener {
            // TODO: Handle form submission
            Toast.makeText(context, "Appointment details submitted successfully!", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }

        dialog.show()
    }

    private fun setupAppointmentDropdowns(dialog: Dialog) {
        // Get the relationship with bank section
        val relationshipSection = dialog.findViewById<View>(R.id.relationshipWithBankSection)

        // State dropdown
        val states = arrayOf("Andhra Pradesh", "Karnataka", "Kerala", "Tamil Nadu", "Telangana")
        val stateAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, states)
        dialog.findViewById<AutoCompleteTextView>(R.id.stateDropdown).setAdapter(stateAdapter)

        // Sub Location dropdown
        val subLocations = arrayOf("Chennai", "Bangalore", "Hyderabad", "Kochi", "Vijayawada")
        val subLocationAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, subLocations)
        dialog.findViewById<AutoCompleteTextView>(R.id.subLocationDropdown).setAdapter(subLocationAdapter)

        // Source dropdown
        val sources = arrayOf("Direct", "Referral", "Website", "Social Media", "Other")
        val sourceAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, sources)
        dialog.findViewById<AutoCompleteTextView>(R.id.sourceDropdown).setAdapter(sourceAdapter)

        // Type of Customer dropdown
        val customerTypes = arrayOf("Individual", "Business", "Corporate", "NRI", "Other")
        val customerTypeAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, customerTypes)
        dialog.findViewById<AutoCompleteTextView>(R.id.customerTypeDropdown).setAdapter(customerTypeAdapter)

        // Location dropdown
        val locations = arrayOf("North", "South", "East", "West", "Central")
        val locationAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, locations)
        dialog.findViewById<AutoCompleteTextView>(R.id.locationDropdown).setAdapter(locationAdapter)

        // Pincode dropdown
        val pincodes = arrayOf("600001", "600002", "600003", "600004", "600005")
        val pincodeAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, pincodes)
        dialog.findViewById<AutoCompleteTextView>(R.id.pincodeDropdown).setAdapter(pincodeAdapter)

        // Bank Name dropdown
        val banks = arrayOf("State Bank of India", "HDFC Bank", "ICICI Bank", "Axis Bank", "Kotak Mahindra Bank", "Punjab National Bank", "Bank of Baroda", "Canara Bank")
        val bankAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, banks)
        dialog.findViewById<AutoCompleteTextView>(R.id.bankNameDropdown).setAdapter(bankAdapter)

        // Account Type dropdown
        val accountTypes = arrayOf("Savings Account", "Current Account", "Fixed Deposit", "Recurring Deposit", "NRI Account")
        val accountTypeAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, accountTypes)
        dialog.findViewById<AutoCompleteTextView>(R.id.accountTypeDropdown).setAdapter(accountTypeAdapter)

        // Setup Add Bank Account button
        dialog.findViewById<MaterialButton>(R.id.addBankAccountButton).setOnClickListener {
            val bankName = dialog.findViewById<AutoCompleteTextView>(R.id.bankNameDropdown).text.toString()
            val accountType = dialog.findViewById<AutoCompleteTextView>(R.id.accountTypeDropdown).text.toString()
            val accountNumber = dialog.findViewById<TextInputEditText>(R.id.accountNumberInput).text.toString()
            val branchName = dialog.findViewById<TextInputEditText>(R.id.branchNameInput).text.toString()
            val ifscCode = dialog.findViewById<TextInputEditText>(R.id.ifscCodeInput).text.toString()

            if (bankName.isNotEmpty() && accountType.isNotEmpty() && accountNumber.isNotEmpty() && 
                branchName.isNotEmpty() && ifscCode.isNotEmpty()) {
                // TODO: Handle adding bank account details
                Toast.makeText(context, "Bank account details added successfully!", Toast.LENGTH_SHORT).show()
                
                // Clear the fields after adding
                dialog.findViewById<AutoCompleteTextView>(R.id.bankNameDropdown).text.clear()
                dialog.findViewById<AutoCompleteTextView>(R.id.accountTypeDropdown).text.clear()
                dialog.findViewById<TextInputEditText>(R.id.accountNumberInput).text?.clear()
                dialog.findViewById<TextInputEditText>(R.id.branchNameInput).text?.clear()
                dialog.findViewById<TextInputEditText>(R.id.ifscCodeInput).text?.clear()
            } else {
                Toast.makeText(context, "Please fill in all bank account details", Toast.LENGTH_SHORT).show()
            }
        }

        // Relationship Bank dropdown
        val relationshipBanks = arrayOf("State Bank of India", "HDFC Bank", "ICICI Bank", "Axis Bank", "Kotak Mahindra Bank", "Punjab National Bank", "Bank of Baroda", "Canara Bank")
        val relationshipBankAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, relationshipBanks)
        relationshipSection.findViewById<AutoCompleteTextView>(R.id.relationshipBankDropdown).setAdapter(relationshipBankAdapter)

        // Type of Loan dropdown
        val loanTypes = arrayOf("Home Loan", "Personal Loan", "Business Loan", "Car Loan", "Education Loan", "Gold Loan")
        val loanTypeAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, loanTypes)
        relationshipSection.findViewById<AutoCompleteTextView>(R.id.loanTypeDropdown).setAdapter(loanTypeAdapter)

        // ROI dropdown
        val roiOptions = arrayOf("8.5%", "9.0%", "9.5%", "10.0%", "10.5%", "11.0%", "11.5%", "12.0%")
        val roiAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, roiOptions)
        relationshipSection.findViewById<AutoCompleteTextView>(R.id.roiDropdown).setAdapter(roiAdapter)

        // Tenure dropdown
        val tenureOptions = arrayOf("12", "24", "36", "48", "60", "72", "84", "96", "108", "120")
        val tenureAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, tenureOptions)
        relationshipSection.findViewById<AutoCompleteTextView>(R.id.tenureDropdown).setAdapter(tenureAdapter)

        // EMI dropdown
        val emiOptions = arrayOf("₹5,000", "₹10,000", "₹15,000", "₹20,000", "₹25,000", "₹30,000", "₹35,000", "₹40,000", "₹45,000", "₹50,000")
        val emiAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, emiOptions)
        relationshipSection.findViewById<AutoCompleteTextView>(R.id.emiDropdown).setAdapter(emiAdapter)

        // Setup date pickers for EMI dates
        setupDatePicker(relationshipSection.findViewById(R.id.firstEmiDateInput))
        setupDatePicker(relationshipSection.findViewById(R.id.lastEmiDateInput))

        // Setup Add Bank Relationship button
        relationshipSection.findViewById<MaterialButton>(R.id.addBankRelationshipButton).setOnClickListener {
            val bank = relationshipSection.findViewById<AutoCompleteTextView>(R.id.relationshipBankDropdown).text.toString()
            val loanType = relationshipSection.findViewById<AutoCompleteTextView>(R.id.loanTypeDropdown).text.toString()
            val loanAmount = relationshipSection.findViewById<TextInputEditText>(R.id.loanAmountInput).text.toString()
            val roi = relationshipSection.findViewById<AutoCompleteTextView>(R.id.roiDropdown).text.toString()
            val tenure = relationshipSection.findViewById<AutoCompleteTextView>(R.id.tenureDropdown).text.toString()
            val emi = relationshipSection.findViewById<AutoCompleteTextView>(R.id.emiDropdown).text.toString()
            val firstEmiDate = relationshipSection.findViewById<TextInputEditText>(R.id.firstEmiDateInput).text.toString()
            val lastEmiDate = relationshipSection.findViewById<TextInputEditText>(R.id.lastEmiDateInput).text.toString()
            val loanAccountNumber = relationshipSection.findViewById<TextInputEditText>(R.id.loanAccountNumberInput).text.toString()

            if (bank.isNotEmpty() && loanType.isNotEmpty() && loanAmount.isNotEmpty() && 
                roi.isNotEmpty() && tenure.isNotEmpty() && emi.isNotEmpty() && 
                firstEmiDate.isNotEmpty() && lastEmiDate.isNotEmpty() && loanAccountNumber.isNotEmpty()) {
                // TODO: Handle adding bank relationship details
                Toast.makeText(context, "Bank relationship details added successfully!", Toast.LENGTH_SHORT).show()
                
                // Clear the fields after adding
                relationshipSection.findViewById<AutoCompleteTextView>(R.id.relationshipBankDropdown).text.clear()
                relationshipSection.findViewById<AutoCompleteTextView>(R.id.loanTypeDropdown).text.clear()
                relationshipSection.findViewById<TextInputEditText>(R.id.loanAmountInput).text?.clear()
                relationshipSection.findViewById<AutoCompleteTextView>(R.id.roiDropdown).text.clear()
                relationshipSection.findViewById<AutoCompleteTextView>(R.id.tenureDropdown).text.clear()
                relationshipSection.findViewById<AutoCompleteTextView>(R.id.emiDropdown).text.clear()
                relationshipSection.findViewById<TextInputEditText>(R.id.firstEmiDateInput).text?.clear()
                relationshipSection.findViewById<TextInputEditText>(R.id.lastEmiDateInput).text?.clear()
                relationshipSection.findViewById<TextInputEditText>(R.id.loanAccountNumberInput).text?.clear()
            } else {
                Toast.makeText(context, "Please fill in all bank relationship details", Toast.LENGTH_SHORT).show()
            }
        }

        // Vehicle Make dropdown
        val vehicleMakes = arrayOf("Maruti Suzuki", "Hyundai", "Tata", "Mahindra", "Toyota", "Honda", "Kia", "Volkswagen", "Skoda", "Ford")
        val vehicleMakeAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, vehicleMakes)
        relationshipSection.findViewById<AutoCompleteTextView>(R.id.vehicleMakeDropdown).setAdapter(vehicleMakeAdapter)

        // Vehicle Model dropdown
        val vehicleModels = arrayOf("Swift", "Baleno", "Creta", "Nexon", "XUV700", "Innova", "City", "Seltos", "Polo", "Rapid")
        val vehicleModelAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, vehicleModels)
        relationshipSection.findViewById<AutoCompleteTextView>(R.id.vehicleModelDropdown).setAdapter(vehicleModelAdapter)

        // Manufacturing Year dropdown
        val manufacturingYears = arrayOf("2024", "2023", "2022", "2021", "2020", "2019", "2018", "2017", "2016", "2015")
        val manufacturingYearAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, manufacturingYears)
        relationshipSection.findViewById<AutoCompleteTextView>(R.id.manufacturingYearDropdown).setAdapter(manufacturingYearAdapter)

        // Setup Add Vehicle button
        relationshipSection.findViewById<MaterialButton>(R.id.addVehicleButton).setOnClickListener {
            val vehicleNumber = relationshipSection.findViewById<TextInputEditText>(R.id.vehicleNumberInput).text.toString()
            val make = relationshipSection.findViewById<AutoCompleteTextView>(R.id.vehicleMakeDropdown).text.toString()
            val model = relationshipSection.findViewById<AutoCompleteTextView>(R.id.vehicleModelDropdown).text.toString()
            val manufacturingYear = relationshipSection.findViewById<AutoCompleteTextView>(R.id.manufacturingYearDropdown).text.toString()
            val engineNumber = relationshipSection.findViewById<TextInputEditText>(R.id.engineNumberInput).text.toString()
            val chassisNumber = relationshipSection.findViewById<TextInputEditText>(R.id.chassisNumberInput).text.toString()

            if (vehicleNumber.isNotEmpty() && make.isNotEmpty() && model.isNotEmpty() && 
                manufacturingYear.isNotEmpty() && engineNumber.isNotEmpty() && chassisNumber.isNotEmpty()) {
                // TODO: Handle adding vehicle details
                Toast.makeText(context, "Vehicle details added successfully!", Toast.LENGTH_SHORT).show()
                
                // Clear the fields after adding
                relationshipSection.findViewById<TextInputEditText>(R.id.vehicleNumberInput).text?.clear()
                relationshipSection.findViewById<AutoCompleteTextView>(R.id.vehicleMakeDropdown).text.clear()
                relationshipSection.findViewById<AutoCompleteTextView>(R.id.vehicleModelDropdown).text.clear()
                relationshipSection.findViewById<AutoCompleteTextView>(R.id.manufacturingYearDropdown).text.clear()
                relationshipSection.findViewById<TextInputEditText>(R.id.engineNumberInput).text?.clear()
                relationshipSection.findViewById<TextInputEditText>(R.id.chassisNumberInput).text?.clear()
            } else {
                Toast.makeText(context, "Please fill in all vehicle details", Toast.LENGTH_SHORT).show()
            }
        }

        // Property Type dropdown
        val propertyTypes = arrayOf("Residential", "Commercial", "Industrial", "Agricultural", "Land", "Apartment", "Villa", "Plot", "Shop", "Office Space")
        val propertyTypeAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, propertyTypes)
        relationshipSection.findViewById<AutoCompleteTextView>(R.id.propertyTypeDropdown).setAdapter(propertyTypeAdapter)

        // Setup Add Property button
        relationshipSection.findViewById<MaterialButton>(R.id.addPropertyButton).setOnClickListener {
            val propertyType = relationshipSection.findViewById<AutoCompleteTextView>(R.id.propertyTypeDropdown).text.toString()
            val area = relationshipSection.findViewById<TextInputEditText>(R.id.areaInput).text.toString()
            val landInSqYards = relationshipSection.findViewById<TextInputEditText>(R.id.landInSqYardsInput).text.toString()
            val sft = relationshipSection.findViewById<TextInputEditText>(R.id.sftInput).text.toString()
            val marketValue = relationshipSection.findViewById<TextInputEditText>(R.id.marketValueInput).text.toString()

            if (propertyType.isNotEmpty() && area.isNotEmpty() && landInSqYards.isNotEmpty() && sft.isNotEmpty() && marketValue.isNotEmpty()) {
                // TODO: Handle adding property details
                Toast.makeText(context, "Property details added successfully!", Toast.LENGTH_SHORT).show()
                
                // Clear the fields after adding
                relationshipSection.findViewById<AutoCompleteTextView>(R.id.propertyTypeDropdown).text.clear()
                relationshipSection.findViewById<TextInputEditText>(R.id.areaInput).text?.clear()
                relationshipSection.findViewById<TextInputEditText>(R.id.landInSqYardsInput).text?.clear()
                relationshipSection.findViewById<TextInputEditText>(R.id.sftInput).text?.clear()
                relationshipSection.findViewById<TextInputEditText>(R.id.marketValueInput).text?.clear()
            } else {
                Toast.makeText(context, "Please fill in all property details", Toast.LENGTH_SHORT).show()
            }
        }

        // Credit Card Bank dropdown
        val creditCardBanks = arrayOf("HDFC Bank", "ICICI Bank", "Axis Bank", "SBI Card", "Citi Bank", "American Express", "Standard Chartered", "HSBC", "Kotak Mahindra Bank", "RBL Bank")
        val creditCardBankAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, creditCardBanks)
        relationshipSection.findViewById<AutoCompleteTextView>(R.id.creditCardBankDropdown).setAdapter(creditCardBankAdapter)

        // Setup Add Credit Card button
        relationshipSection.findViewById<MaterialButton>(R.id.addCreditCardButton).setOnClickListener {
            val bankName = relationshipSection.findViewById<AutoCompleteTextView>(R.id.creditCardBankDropdown).text.toString()
            val limit = relationshipSection.findViewById<TextInputEditText>(R.id.creditCardLimitInput).text.toString()

            if (bankName.isNotEmpty() && limit.isNotEmpty()) {
                // TODO: Handle adding credit card details
                Toast.makeText(context, "Credit card details added successfully!", Toast.LENGTH_SHORT).show()
                
                // Clear the fields after adding
                relationshipSection.findViewById<AutoCompleteTextView>(R.id.creditCardBankDropdown).text.clear()
                relationshipSection.findViewById<TextInputEditText>(R.id.creditCardLimitInput).text?.clear()
            } else {
                Toast.makeText(context, "Please fill in all credit card details", Toast.LENGTH_SHORT).show()
            }
        }

        // Appointment Bank dropdown
        val appointmentBanks = arrayOf("State Bank of India", "HDFC Bank", "ICICI Bank", "Axis Bank", "Kotak Mahindra Bank", "Punjab National Bank", "Bank of Baroda", "Canara Bank")
        val appointmentBankAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, appointmentBanks)
        relationshipSection.findViewById<AutoCompleteTextView>(R.id.appointmentBankDropdown).setAdapter(appointmentBankAdapter)

        // Appointment Product dropdown
        val appointmentProducts = arrayOf("Home Loan", "Personal Loan", "Business Loan", "Car Loan", "Education Loan", "Gold Loan", "Credit Card", "Savings Account", "Current Account", "Fixed Deposit")
        val appointmentProductAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, appointmentProducts)
        relationshipSection.findViewById<AutoCompleteTextView>(R.id.appointmentProductDropdown).setAdapter(appointmentProductAdapter)

        // Appointment Status dropdown
        val appointmentStatuses = arrayOf("Scheduled", "Completed", "Cancelled", "Rescheduled", "No Show", "In Progress", "Pending", "Rejected", "Approved", "On Hold")
        val appointmentStatusAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, appointmentStatuses)
        relationshipSection.findViewById<AutoCompleteTextView>(R.id.appointmentStatusDropdown).setAdapter(appointmentStatusAdapter)

        // Appointment Sub Status dropdown
        val appointmentSubStatuses = arrayOf("Document Pending", "Verification Pending", "Under Review", "Awaiting Approval", "Processing", "Disbursed", "Rejected", "Cancelled", "Completed", "On Hold")
        val appointmentSubStatusAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, appointmentSubStatuses)
        relationshipSection.findViewById<AutoCompleteTextView>(R.id.appointmentSubStatusDropdown).setAdapter(appointmentSubStatusAdapter)

        // Setup Submit button
        relationshipSection.findViewById<MaterialButton>(R.id.submitAppointmentButton).setOnClickListener {
            val bank = relationshipSection.findViewById<AutoCompleteTextView>(R.id.appointmentBankDropdown).text.toString()
            val product = relationshipSection.findViewById<AutoCompleteTextView>(R.id.appointmentProductDropdown).text.toString()
            val status = relationshipSection.findViewById<AutoCompleteTextView>(R.id.appointmentStatusDropdown).text.toString()
            val subStatus = relationshipSection.findViewById<AutoCompleteTextView>(R.id.appointmentSubStatusDropdown).text.toString()
            val notes = relationshipSection.findViewById<TextInputEditText>(R.id.notesInput).text.toString()

            if (bank.isNotEmpty() && product.isNotEmpty() && status.isNotEmpty() && subStatus.isNotEmpty()) {
                // TODO: Handle appointment submission
                Toast.makeText(context, "Appointment details submitted successfully!", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            } else {
                Toast.makeText(context, "Please fill in all required appointment details", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setupAppointmentVisitingCardUpload(dialog: Dialog) {
        dialog.findViewById<MaterialButton>(R.id.uploadVisitingCardButton).setOnClickListener {
            // TODO: Implement file picker
            Toast.makeText(context, "File picker - Coming Soon", Toast.LENGTH_SHORT).show()
        }
    }

    private fun showAddAgentDialog() {
        val dialog = Dialog(requireContext())
        dialog.setContentView(R.layout.dialog_add_agent)
        dialog.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )

        // Initialize dropdowns
        setupDropdowns(dialog)

        // Setup visiting card upload
        setupVisitingCardUpload(dialog)

        // Setup submit button
        dialog.findViewById<MaterialButton>(R.id.submitButton).setOnClickListener {
            // TODO: Handle form submission
            Toast.makeText(context, "Agent details submitted successfully!", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }

        dialog.show()
    }

    private fun setupDropdowns(dialog: Dialog) {
        // Branch State dropdown
        val branchStates = arrayOf("Andhra Pradesh", "Karnataka", "Kerala", "Tamil Nadu", "Telangana")
        val branchStateAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, branchStates)
        dialog.findViewById<AutoCompleteTextView>(R.id.branchStateDropdown).setAdapter(branchStateAdapter)

        // Type of Partner dropdown
        val partnerTypes = arrayOf("Individual", "Company", "Partnership", "LLP")
        val partnerTypeAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, partnerTypes)
        dialog.findViewById<AutoCompleteTextView>(R.id.partnerTypeDropdown).setAdapter(partnerTypeAdapter)

        // Branch Location dropdown
        val branchLocations = arrayOf("Chennai", "Bangalore", "Hyderabad", "Kochi", "Vijayawada")
        val branchLocationAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, branchLocations)
        dialog.findViewById<AutoCompleteTextView>(R.id.branchLocationDropdown).setAdapter(branchLocationAdapter)
    }

    private fun setupVisitingCardUpload(dialog: Dialog) {
        dialog.findViewById<MaterialCardView>(R.id.visitingCardUploadCard).setOnClickListener {
            // TODO: Implement file picker
            Toast.makeText(context, "File picker - Coming Soon", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupFileChooser(view: View) {
        // Initialize views
        fileTypeSpinner = view.findViewById(R.id.file_type_spinner)
        selectedFileText = view.findViewById(R.id.selected_file_text)
        val chooseFileButton = view.findViewById<MaterialButton>(R.id.choose_file_button)

        // Set up file type spinner
        val fileTypes = arrayOf("All Files", "PDF", "PNG", "JPEG", "DOC", "DOCX", "XLS", "XLSX", "TXT")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, fileTypes)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        fileTypeSpinner.adapter = adapter

        // Set up file chooser button click listener
        chooseFileButton.setOnClickListener {
            // TODO: Implement file chooser
            Toast.makeText(context, "File chooser - Coming Soon", Toast.LENGTH_SHORT).show()
        }

        // Set up spinner selection listener
        fileTypeSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedType = fileTypes[position]
                Toast.makeText(context, "Selected file type: $selectedType", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Do nothing
            }
        }
    }

    fun showSection(section: LinearLayout) {
        // Hide all sections
        appointmentSection.visibility = View.GONE
        transactionsSection.visibility = View.GONE
        documentsSection.visibility = View.GONE
        fileSection.visibility = View.GONE
        moreSection.visibility = View.GONE

        // Show the selected section
        section.visibility = View.VISIBLE
    }

    // Getter methods for sections
    fun getAppointmentSection(): LinearLayout = appointmentSection
    fun getTransactionsSection(): LinearLayout = transactionsSection
    fun getDocumentsSection(): LinearLayout = documentsSection
    fun getFileSection(): LinearLayout = fileSection
    fun getMoreSection(): LinearLayout = moreSection

    private fun getSampleImages(): List<Int> {
        return listOf(
            R.drawable.ic_loan,
            R.drawable.ic_business,
            R.drawable.ic_bike
        )
    }

    private fun setupDatePicker(editText: TextInputEditText) {
        editText.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            DatePickerDialog(
                requireContext(),
                { _, selectedYear, selectedMonth, selectedDay ->
                    val formattedDate = String.format("%02d/%02d/%04d", selectedDay, selectedMonth + 1, selectedYear)
                    editText.setText(formattedDate)
                },
                year,
                month,
                day
            ).show()
        }
    }
}

class LoansImageCarouselAdapter(private val images: List<Int>) : 
    RecyclerView.Adapter<LoansImageCarouselAdapter.LoansImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LoansImageViewHolder {
        val imageView = ImageView(parent.context).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            scaleType = ImageView.ScaleType.CENTER_CROP
        }
        return LoansImageViewHolder(imageView)
    }

    override fun onBindViewHolder(holder: LoansImageViewHolder, position: Int) {
        holder.imageView.setImageResource(images[position])
    }

    override fun getItemCount(): Int = images.size

    class LoansImageViewHolder(val imageView: ImageView) : RecyclerView.ViewHolder(imageView)
} 