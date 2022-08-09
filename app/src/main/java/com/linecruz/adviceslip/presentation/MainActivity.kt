package com.linecruz.adviceslip.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.linecruz.adviceslip.R
import com.linecruz.adviceslip.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupButtonListener()
        setupViewModel()
    }

    private fun setupButtonListener() {
        binding.buttonMainSeekAdvice.setOnClickListener {
            //viewmodel.fetchAdvice()
        }
    }

    private fun setupViewModel() {
        TODO("Not yet implemented")
    }

    private fun fillAdviceSlip(message: String) {
        binding.textMainAdviceSlip.text = message
    }

    private fun showError(message: String) {
        Toast.makeText(
            this, getString(R.string.label_error_ocurred, message), Toast.LENGTH_SHORT
        ).show()
    }
}