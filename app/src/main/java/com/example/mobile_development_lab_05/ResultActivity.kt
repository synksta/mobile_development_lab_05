package com.example.mobile_development_lab_05

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mobile_development_lab_05.databinding.ActivityResultBinding
import kotlin.random.Random

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    private val viewModel: ResultViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.labelSumToPay.text = intent.getIntExtra("COST", 0).toString()

        binding.buttonCancelPayment.setOnClickListener {
            finish()
        }

        binding.buttonAcceptPayment.setOnClickListener {
            val value: Int = if (Random.nextDouble(0.0, 1.0) <= 0.5) {
                finish()
                R.string.payment_success
            } else {
                R.string.payment_fail
            }
            Toast.makeText(this, value, Toast.LENGTH_SHORT).show()

        }
    }
}