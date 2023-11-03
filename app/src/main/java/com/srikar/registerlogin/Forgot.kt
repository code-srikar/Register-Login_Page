package com.srikar.registerlogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.srikar.registerlogin.databinding.ActivityForgotBinding

class Forgot : AppCompatActivity() {

    private lateinit var binding3 : ActivityForgotBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding3 = ActivityForgotBinding.inflate(layoutInflater)
        setContentView(binding3.root)

        val pass1 = intent.getStringExtra("pass1")

        if(pass1 != "") {
            binding3.fpass.text = pass1
        }
        else{
            binding3.fpass.text = "admin"
        }

    }
}