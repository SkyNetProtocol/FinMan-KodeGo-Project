package com.example.finman1.ui.loadingscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.finman1.R
import com.example.finman1.databinding.ActivityMainBinding
import com.example.finman1.ui.login.LoginActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler(Looper.getMainLooper()).postDelayed({
            goToLogin()
        }, 4000)
    }

    fun goToLogin(){
        val resultIntent  = Intent(this, LoginActivity::class.java)
        startActivity(resultIntent)
        finish()
    }
}