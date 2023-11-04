package com.srikar.registerlogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.srikar.registerlogin.databinding.ActivityLoginBinding
import com.srikar.registerlogin.databinding.ActivityMainBinding

class Login : AppCompatActivity() {

    private lateinit var binding2 : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding2 = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding2.root)

        val name1 = intent.getStringExtra("uname")
        val pass1 = intent.getStringExtra("password")

        binding2.logBtn.setOnClickListener(){
            if(!TextUtils.isEmpty(binding2.name.text.toString()) && !TextUtils.isEmpty(binding2.pass.text.toString())) {
                if((binding2.name.text.toString() == name1 && binding2.pass.text.toString() == pass1)) {
                    Toast.makeText(this, "LOGGED IN SUCCESSFULLY", Toast.LENGTH_SHORT).show()
                    var intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                else{
                    Toast.makeText(this,"INCORRECT CREDENTIALS",Toast.LENGTH_SHORT).show()
                }
            }
            else{
                Toast.makeText(this,"CREDENTIALS REQUIRED!",Toast.LENGTH_SHORT).show()
            }
        }

        binding2.forgot.setOnClickListener(){
            if(binding2.name.text.toString() == name1) {
                Toast.makeText(this, "Redirecting...", Toast.LENGTH_SHORT).show()
                var intent = Intent(this, Forgot::class.java)
                intent.putExtra("pass1",pass1)
                startActivity(intent)
            }
            else{
                Toast.makeText(this,"Invalid Username",Toast.LENGTH_SHORT).show()
            }
        }

        binding2.haveAcc.setOnClickListener(){
            var intent = Intent(this,register::class.java)
            startActivity(intent)
        }

    }
}