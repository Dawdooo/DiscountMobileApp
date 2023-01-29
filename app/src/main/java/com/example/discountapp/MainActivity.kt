package com.example.discountapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Snackbar
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.view.isVisible
import com.example.discountapp.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth


class MainActivity : AppCompatActivity() {
private fun openProducts(){
    val goToProducts = Intent(applicationContext,Products::class.java).apply {
        flags = (Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
    }
    startActivity(goToProducts)
}
    private val LOG_DEBUG = "LOG DEBUG"
    private val fbAuth: FirebaseAuth = FirebaseAuth.getInstance()

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getSupportActionBar()?.hide()
        setupLoginClick()



        binding.forgetTxt.setOnClickListener() {
            var remind: Intent = Intent(applicationContext, remindPassword::class.java)
            startActivity(remind)
        }
        binding.mainSingUpTxt.setOnClickListener() {
            var register: Intent = Intent(applicationContext, Register::class.java)
            startActivity(register)
        }
    }

    private fun setupLoginClick() {

        binding.LgnBtn.setOnClickListener {
            val email = binding.lgnMail.text?.trim().toString()
            val password = binding.lgnPassword.text?.trim().toString()

            fbAuth.signInWithEmailAndPassword(email, password)
                .addOnSuccessListener { authRes ->
                    if (authRes.user != null) openProducts()

                }
                .addOnFailureListener {exc->
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                    Log.d(LOG_DEBUG, exc.message.toString())

                }
        }
    }

    override fun onStart() {
        super.onStart()
        isCurrentUser()
    }

    private fun isCurrentUser() {
        fbAuth.currentUser?.let { auth ->
            openProducts()
        }
    }
}
