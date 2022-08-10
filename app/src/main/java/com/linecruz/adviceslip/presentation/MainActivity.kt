package com.linecruz.adviceslip.presentation

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.linecruz.adviceslip.R
import com.linecruz.adviceslip.databinding.ActivityMainBinding
import com.linecruz.adviceslip.domain.entity.Advice
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupButtonListener()
        setupViewModel()
    }

    private fun setupButtonListener() {
        binding.buttonMainSeekAdvice.setOnClickListener {
            viewModel.fetchAdvice()
        }
    }

    private fun setupViewModel() {
        lifecycleScope.launchWhenCreated {
            viewModel.state.collectLatest {
                when (it) {
                    is AdviceState.AdviceSuccess -> fillAdviceSlip(it.advice)
                    is AdviceState.AdviceError -> showError(it.error)
                    is AdviceState.ShowLoading -> binding.loadingMain.visibility = View.VISIBLE
                    is AdviceState.HideLoading -> binding.loadingMain.visibility = View.GONE
                }
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