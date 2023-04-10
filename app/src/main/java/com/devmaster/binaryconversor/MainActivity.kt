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
    private fun initializeValue(str: String): Int{
       return if (str != "") str.toInt() else 0
    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_Converter) {
            var valDecimal = initializeValue(binding.editTextDecimal.text.toString())
            var valBinary = initializeValue(binding.editTextBinary.text.toString())
            if (valDecimal != 0) { //decimal
                var binary = ""
                while (true) {
                    binary += "${valDecimal % 2}"
                    valDecimal /= 2
                    if (valDecimal == 0) break
                }
                var a = ""
                for (i in binary.length - 1 downTo 0) {
                    a += binary[i]
                }
                binding.editTextBinary.setText(a)
            } else if (valBinary != 0) {

            } else {
                //Apresentar erro
            }
        }
    }
}