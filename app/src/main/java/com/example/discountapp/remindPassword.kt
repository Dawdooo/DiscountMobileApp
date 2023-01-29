package com.example.discountapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import com.example.discountapp.databinding.ActivityRegisterBinding
import com.example.discountapp.databinding.ActivityRemindPasswordBinding
import com.google.firebase.auth.FirebaseAuth
import java.util.regex.Pattern

class remindPassword : AppCompatActivity() {

    private val fbAuth: FirebaseAuth = FirebaseAuth.getInstance()
    private val REMIND_DEBUG = "REMIND_DEBUG"
    private lateinit var binding: ActivityRemindPasswordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = ActivityRemindPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        resetPassword()
    }
    private fun resetPassword(){
        binding.resetButton.setOnClickListener {

            val email = binding.resetEmail.text?.trim().toString()

            if (email.isEmpty()){
                binding.resetEmail.setError("Wrong Email")
                binding.resetEmail.requestFocus()
            }
          if (Patterns.EMAIL_ADDRESS.matcher(email).matches()){
        binding.resetEmail.setError("Please provide valid email")
              binding.resetEmail.requestFocus()
}
            fbAuth.sendPasswordResetEmail(email).addOnSuccessListener {
                val intent = Intent(applicationContext,CheckEmail::class.java)
startActivity(intent)
            }.addOnFailureListener { exc->
                Toast.makeText(baseContext, "Failed, try again!",
                    Toast.LENGTH_SHORT).show()
                Log.d(REMIND_DEBUG, exc.message.toString())
            }
        }
    }
}