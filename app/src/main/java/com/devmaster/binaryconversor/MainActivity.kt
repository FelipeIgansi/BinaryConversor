package com.devmaster.binaryconversor

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.devmaster.binaryconversor.databinding.ActivityMainBinding
import kotlin.math.pow

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        binding.buttonConverter.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_Converter) {
            var decimalValue =  binding.editTextDecimal.text.toString().toIntOrNull()
            var binaryValue = binding.editTextBinary.text.toString().toIntOrNull()
            if (decimalValue != null) {
                var strBinary = ""
                while (decimalValue > 0) {
                    strBinary = "${decimalValue % 2}$strBinary"
                    decimalValue /= 2
                }
                binding.editTextBinary.setText(strBinary)
            } else if (binaryValue != 0) {
                var total = 0
                var binary = binaryValue.toString()
                for (i in 0 until binary.toString().length){
                    total += (binary[i].toString().toDouble() * (2.0.pow(i))).toInt()
                }

                binding.editTextDecimal.setText(total)
            } else {
                Toast.makeText(this, "Ocorreu um erro!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}