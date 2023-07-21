package com.example.finman1.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModelProvider
import com.example.finman1.ui.home.HomeActivity
import com.example.finman1.ui.signup.SignupActivity
import com.example.finman1.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]

        buttonAction()

    }

    private fun buttonAction(){
        binding.btnLogin.setOnClickListener {
            val buttonLogin = Intent(this, HomeActivity::class.java)
            startActivity(buttonLogin)
        }
        binding.btnSignUp.setOnClickListener {
            val buttonSignUp = Intent(this, SignupActivity::class.java)
            startActivity(buttonSignUp)
        }
    }

    private fun isValidCredentials(username: String, password: String): Boolean {
        return username == "demo" && password == "password"
    }
}

//private fun buttonAction(){
//    binding.btnLogin.setOnClickListener {
//        val buttonLogin = Intent(this, HomeActivity::class.java)
//        startActivity(buttonLogin)
//    }
//    binding.btnSignUp.setOnClickListener {
//        val buttonSignUp = Intent(this, SignupActivity::class.java)
//        startActivity(buttonSignUp)
//    }
//}