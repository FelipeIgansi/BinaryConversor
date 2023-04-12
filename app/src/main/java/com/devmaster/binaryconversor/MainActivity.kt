package com.devmaster.binaryconversor

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.devmaster.binaryconversor.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        binding.buttonConverter.setOnClickListener(this)
    }

    fun binaryToDecimal(binary: String): String {
        var decimal = 0
        var base = 1

        for (i in binary.length - 1 downTo 0) {
            if (binary[i] == '1') {
                decimal += base
            }
            base *= 2
        }

        return decimal.toString()
    }

    fun decimalToBinary(decimal: Int): String {
        var strBinary = ""
        var dec = decimal
        while (dec > 0) {
            strBinary = "${dec % 2}$strBinary"
            dec /= 2
        }
        return strBinary
    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_Converter) {
            val decimalValue = binding.editTextDecimal.text.toString().toIntOrNull()
            val binaryValue = binding.editTextBinary.text.toString().toIntOrNull()
            if (decimalValue != null && binaryValue != null) {
                binding.editTextBinary.setText("")
                binding.editTextDecimal.setText("")
            } else if (decimalValue != null) {
                binding.editTextBinary.setText(decimalToBinary(decimalValue))
            } else if (binaryValue != null) {
                binding.editTextDecimal.setText(binaryToDecimal(binaryValue.toString()))
            }
        }
    }
}