package com.example.mobile_development_lab_05
import android.content.Intent
import com.example.mobile_development_lab_05.databinding.ActivityMainBinding
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.editTime.addTextChangedListener(){ editable ->
            viewModel.time = editable.toString().toIntOrNull() ?: 0
        }

        binding.editRate.addTextChangedListener(){ editable ->
            viewModel.rate = editable.toString().toIntOrNull() ?: 0
        }

        binding.editDiscount.addTextChangedListener(){ editable ->
            viewModel.discount = editable.toString().toIntOrNull() ?: 0
        }

        binding.buttonCalculate.setOnClickListener {
            val timeInput = binding.editTime.text.toString()
            val rateInput = binding.editRate.text.toString()
            val discountInput = binding.editDiscount.text.toString()

            if (timeInput.isNotEmpty() && rateInput.isNotEmpty() && discountInput.isNotEmpty()) {
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("COST", viewModel.cost)
                startActivity(intent)
            }
            else{
                Toast.makeText(this, R.string.not_all_parameters_are_given , Toast.LENGTH_SHORT).show()
            }
        }
    }
}