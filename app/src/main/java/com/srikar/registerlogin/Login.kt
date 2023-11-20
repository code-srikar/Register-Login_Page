package com.srikar.registerlogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.auth
import com.srikar.registerlogin.databinding.ActivityLoginBinding
import com.srikar.registerlogin.databinding.ActivityMainBinding

class Login : AppCompatActivity() {

    private lateinit var binding2 : ActivityLoginBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding2 = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding2.root)

        // Initialize Firebase Auth
        auth = Firebase.auth

        binding2.logBtn.setOnClickListener(){
            if(!TextUtils.isEmpty(binding2.mail.text.toString()) && !TextUtils.isEmpty(binding2.pass.text.toString())) {
                auth.signInWithEmailAndPassword(binding2.mail.text.toString(), binding2.pass.text.toString())
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            val user = auth.currentUser
                            Toast.makeText(this, "LOGGED IN SUCCESSFULLY", Toast.LENGTH_SHORT).show()
                            updateUI(user)
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(
                                baseContext,
                                "Authentication failed.",
                                Toast.LENGTH_SHORT,
                            ).show()
                        }
                    }
            }
            else{
                Toast.makeText(this,"CREDENTIALS REQUIRED!",Toast.LENGTH_SHORT).show()
            }
        }

        binding2.haveAcc.setOnClickListener(){
            var intent = Intent(this,register::class.java)
            startActivity(intent)
        }

    }

    private fun updateUI(user: FirebaseUser?) {
        var intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}