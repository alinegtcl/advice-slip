package com.linecruz.adviceslip.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.linecruz.adviceslip.R
import com.linecruz.adviceslip.databinding.ActivityMainBinding
import com.linecruz.adviceslip.domain.entity.Advice
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewmodel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupButtonListener()
        setupViewModel()
    }

    private fun setupButtonListener() {
        binding.buttonMainSeekAdvice.setOnClickListener {
            viewmodel.fetchAdvice()
        }
    }

    private fun setupViewModel() {
        viewmodel.state.observe(this) {
            when (it) {
                is AdviceState.AdviceSuccess -> fillAdviceSlip(it.advice)
                is AdviceState.AdviceError -> showError(it.error)
            }
        }
    }

    private fun fillAdviceSlip(advice: Advice) {
        binding.textMainAdviceSlip.text = advice.advice
    }

    private fun showError(message: String) {
        Toast.makeText(
            this, getString(R.string.label_error_ocurred, message), Toast.LENGTH_SHORT
        ).show()
    }
}