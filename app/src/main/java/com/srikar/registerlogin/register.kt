package com.srikar.registerlogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.srikar.registerlogin.databinding.ActivityRegisterBinding

class register : AppCompatActivity() {

    private lateinit var binding1: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding1 = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding1.root)

        binding1.regBtn.setOnClickListener(){
            if(!TextUtils.isEmpty(binding1.name.text.toString()) && !TextUtils.isEmpty(binding1.mail.text.toString()) && !TextUtils.isEmpty(binding1.pass.text.toString()) && !TextUtils.isEmpty(binding1.repass.text.toString())) {
                if(binding1.pass.text.toString()==binding1.repass.text.toString()) {
                    Toast.makeText(this, "REGISTERED SUCCESSFULLY", Toast.LENGTH_SHORT).show()
                    var intent = Intent(this, Login::class.java)
                    intent.putExtra("uname", binding1.name.text.toString())
                    intent.putExtra("password", binding1.pass.text.toString())
                    startActivity(intent)
                    finish()
                }
                else{
                    Toast.makeText(this,"PASSWORDS DO NOT MATCH",Toast.LENGTH_SHORT).show()
                }
            }
            else{
                Toast.makeText(this,"Fill-in the Credentials",Toast.LENGTH_SHORT).show()
            }
            }


    }
}