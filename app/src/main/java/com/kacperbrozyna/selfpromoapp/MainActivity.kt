package com.kacperbrozyna.selfpromoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.kacperbrozyna.selfpromoapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonPreview.setOnClickListener {
            onPreviewClicked()
        }

        val spinnerValues = arrayOf("Android Developer", "Android Engineer")
        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, spinnerValues)
        binding.spinnerJobTitle.adapter = spinnerAdapter;

    }

    private fun onPreviewClicked() {

        val messageClass = Message(

            binding.editTextContactName.text.toString(),
            binding.editTextContactNumber.text.toString(),
            binding.editTextDisplayName.text.toString(),
            binding.checkBoxIncludeJunior.isChecked,
            binding.spinnerJobTitle.selectedItem?.toString(),
            binding.checkBoxImediateStart.isChecked,
            binding.editTextStartDate.text?.toString()
        )

        val previewActivityIntent  = Intent(this, PreviewActivity::class.java)
        previewActivityIntent.putExtra("message", messageClass)
        startActivity(previewActivityIntent)
    }
}