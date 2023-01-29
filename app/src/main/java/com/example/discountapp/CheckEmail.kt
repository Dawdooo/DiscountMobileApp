package com.example.discountapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.discountapp.databinding.ActivityCheckEmailBinding
import com.example.discountapp.databinding.ActivityMainBinding
import com.example.discountapp.databinding.ActivityRegisterBinding

class CheckEmail : AppCompatActivity() {
    private lateinit var binding: ActivityCheckEmailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCheckEmailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.back.setOnClickListener {
            val intent = Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)
        }
    }
}