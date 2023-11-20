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
import com.srikar.registerlogin.databinding.ActivityRegisterBinding

class register : AppCompatActivity() {

    private lateinit var binding1: ActivityRegisterBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding1 = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding1.root)

        // Initialize Firebase Auth
        auth = Firebase.auth

        binding1.regBtn.setOnClickListener(){
            if(!TextUtils.isEmpty(binding1.name.text.toString()) && !TextUtils.isEmpty(binding1.mail.text.toString()) && !TextUtils.isEmpty(binding1.pass.text.toString()) && !TextUtils.isEmpty(binding1.repass.text.toString())) {
                if(binding1.pass.text.toString()==binding1.repass.text.toString()) {
                    auth.createUserWithEmailAndPassword(binding1.mail.text.toString(), binding1.pass.text.toString())
                        .addOnCompleteListener(this) { task ->
                            if (task.isSuccessful) {
                                // Sign in success, update UI with the signed-in user's information
                                val user = auth.currentUser
                                updateUI(user)
                                Toast.makeText(this, "REGISTERED SUCCESSFULLY", Toast.LENGTH_SHORT).show()
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
                    Toast.makeText(this,"PASSWORDS DO NOT MATCH",Toast.LENGTH_SHORT).show()
                }
            }
            else{
                Toast.makeText(this,"Fill-in the Credentials",Toast.LENGTH_SHORT).show()
            }
            }

        binding1.Acc.setOnClickListener(){
            updateUI(null)
        }


    }

    private fun updateUI(user: FirebaseUser?) {

        var intent = Intent(this, Login::class.java)
        startActivity(intent)
        finish()

    }
}