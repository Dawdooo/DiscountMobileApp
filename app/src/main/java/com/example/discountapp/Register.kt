package com.example.discountapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.discountapp.databinding.ActivityMainBinding
import com.example.discountapp.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth

class Register : AppCompatActivity() {
    private val REG_DEBUG = "REG DEBUG"
    private val fbAuth: FirebaseAuth = FirebaseAuth.getInstance()
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        registerClick()


        binding.backToLgn.setOnClickListener {
var intent = Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)
        }
        }
    private  fun registerClick(){
        binding.registerBtn.setOnClickListener {
            val email = binding.registerMail.text?.trim().toString()
            val password = binding.lgnPassword.text?.trim().toString()
            val repeatPassword = binding.repeatPassword.text?.trim().toString()

            if (password == repeatPassword){
                fbAuth.createUserWithEmailAndPassword(email, password)
                    .addOnSuccessListener {authRes ->
                        if (authRes.user!= null){
                            val goToProducts = Intent(applicationContext,Products::class.java).apply {
                                flags = (Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                            }
                            startActivity(goToProducts)
                        }
                    }
                    .addOnFailureListener {exc->
                        Toast.makeText(baseContext, "Authentication failed.",
                            Toast.LENGTH_SHORT).show()
                        Log.d(REG_DEBUG, exc.message.toString())

                    }

            }
        }
    }
    }

