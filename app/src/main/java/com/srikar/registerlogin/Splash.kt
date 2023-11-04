package com.srikar.registerlogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.srikar.registerlogin.databinding.ActivityMainBinding
import com.srikar.registerlogin.databinding.ActivitySplashBinding

class Splash : AppCompatActivity() {

    private lateinit var binding4: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding4 = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding4.root)

        var intent = Intent(this,register::class.java)

        Handler().postDelayed(Runnable {
            startActivity(intent)
            finish()
        },3000)

    }
}