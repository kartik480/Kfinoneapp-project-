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

class LoansFragment : Fragment() {

    private lateinit var imageCarousel: ViewPager2
    private lateinit var dotsIndicator: TabLayout
    private lateinit var databaseSection: LinearLayout
    private lateinit var appointmentSection: LinearLayout
    private lateinit var transactionsSection: LinearLayout
    private lateinit var documentsSection: LinearLayout
    private lateinit var fileSection: LinearLayout
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
        databaseSection = view.findViewById(R.id.database_section)
        appointmentSection = view.findViewById(R.id.appointment_section)
        fileSection = view.findViewById(R.id.file_section)
        transactionsSection = view.findViewById(R.id.transactions_section)

        documentsSection = view.findViewById(R.id.documents_section)


        // Set up file chooser
        setupFileChooser(view)

        // Set up the image carousel adapter
        val carouselAdapter = LoansImageCarouselAdapter(getSampleImages())
        imageCarousel.adapter = carouselAdapter

        // Now attach the dots indicator
        TabLayoutMediator(dotsIndicator, imageCarousel) { _, _ -> }.attach()

        // Setup database section click listeners
        view.findViewById<MaterialCardView>(R.id.add_database_card).setOnClickListener {
            Toast.makeText(context, "Add Database - Coming Soon", Toast.LENGTH_SHORT).show()
        }

        view.findViewById<MaterialCardView>(R.id.my_sal_data_card).setOnClickListener {
            Toast.makeText(context, "My SAL Data - Coming Soon", Toast.LENGTH_SHORT).show()
        }

        view.findViewById<MaterialCardView>(R.id.my_senp_data_card).setOnClickListener {
            Toast.makeText(context, "My SENP Data - Coming Soon", Toast.LENGTH_SHORT).show()
        }

        view.findViewById<MaterialCardView>(R.id.my_sep_data_card).setOnClickListener {
            Toast.makeText(context, "My SEP Data - Coming Soon", Toast.LENGTH_SHORT).show()
        }

        view.findViewById<MaterialCardView>(R.id.my_nri_data_card).setOnClickListener {
            Toast.makeText(context, "My NRI Data - Coming Soon", Toast.LENGTH_SHORT).show()
        }

        view.findViewById<MaterialCardView>(R.id.my_educational_data_card).setOnClickListener {
            Toast.makeText(context, "My Educational Data - Coming Soon", Toast.LENGTH_SHORT).show()
        }

        view.findViewById<MaterialCardView>(R.id.team_sal_data_card).setOnClickListener {
            Toast.makeText(context, "Team SAL Data - Coming Soon", Toast.LENGTH_SHORT).show()
        }

        view.findViewById<MaterialCardView>(R.id.team_senp_data_card).setOnClickListener {
            Toast.makeText(context, "Team SENP Data - Coming Soon", Toast.LENGTH_SHORT).show()
        }

        view.findViewById<MaterialCardView>(R.id.team_sep_data_card).setOnClickListener {
            Toast.makeText(context, "Team SEP Data - Coming Soon", Toast.LENGTH_SHORT).show()
        }

        view.findViewById<MaterialCardView>(R.id.team_nri_data_card).setOnClickListener {
            Toast.makeText(context, "Team NRI Data - Coming Soon", Toast.LENGTH_SHORT).show()
        }

        view.findViewById<MaterialCardView>(R.id.team_educational_data_card).setOnClickListener {
            Toast.makeText(context, "Team Educational Data - Coming Soon", Toast.LENGTH_SHORT).show()
        }

        // Setup appointment section click listeners
        view.findViewById<MaterialCardView>(R.id.add_appointment_card).setOnClickListener {
            Toast.makeText(context, "Add Appointment - Coming Soon", Toast.LENGTH_SHORT).show()
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

        // Show database section by default
        showSection(databaseSection)
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
        databaseSection.visibility = View.GONE
        appointmentSection.visibility = View.GONE
        transactionsSection.visibility = View.GONE
        documentsSection.visibility = View.GONE
        fileSection.visibility = View.GONE

        // Show the selected section
        section.visibility = View.VISIBLE
    }

    // Getter methods for sections
    fun getDatabaseSection(): LinearLayout = databaseSection
    fun getAppointmentSection(): LinearLayout = appointmentSection
    fun getTransactionsSection(): LinearLayout = transactionsSection
    fun getDocumentsSection(): LinearLayout = documentsSection
    fun getFileSection(): LinearLayout = fileSection

    private fun getSampleImages(): List<Int> {
        return listOf(
            R.drawable.ic_loan,
            R.drawable.ic_business,
            R.drawable.ic_bike
        )
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