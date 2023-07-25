package com.example.finman1.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModelProvider
import com.example.finman1.application.FinManClass
import com.example.finman1.database.FinManDataClass
import com.example.finman1.ui.home.HomeActivity
import com.example.finman1.ui.signup.SignupActivity
import com.example.finman1.databinding.ActivityLoginBinding
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel: LoginViewModel
    private var fdb = FirebaseFirestore.getInstance()

    private lateinit var specificUser: List<FinManDataClass>
    var userRepository = FinManClass.wordRepositoryGlobal

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]

        buttonAction()

    }

    private fun buttonAction(){
        binding.btnLogin.setOnClickListener { isValidCredentials() }
        binding.btnSignUp.setOnClickListener { btnActionSignUp() }

    }



    private fun btnActionLogin(){
        val buttonLogin = Intent(this, HomeActivity::class.java)
        startActivity(buttonLogin)
    }
    private fun btnActionSignUp() {
        val buttonSignUp = Intent(this, SignupActivity::class.java)
        startActivity(buttonSignUp)
    }

    private fun isValidCredentials(){
        val checkMail  = binding.usernameLogin.text.toString()
        val checkPass  = binding.passwordLogin.text.toString()
        val newScope = CoroutineScope(Dispatchers.IO).launch{
//            specificUser = userRepository.getSpecific(check)
            specificUser = userRepository.getSpecificMailAndPass(checkMail,checkPass)
            Log.e("DB","___ success ___${specificUser.toString()}")

            specificUser.forEach {
                if (checkMail == it.email && checkPass == it.password) {
                    val buttonLogin = Intent(this@LoginActivity, HomeActivity::class.java)
                    startActivity(buttonLogin)
                    Log.e("DB","___ success ___ " )
                }else{
                    Toast.makeText(this@LoginActivity,"failed Login",Toast.LENGTH_LONG).show()
                }
            }
        }
        binding.usernameLogin.text!!.clear()
        binding.passwordLogin.text!!.clear()
    }
}

//private fun isValidCredentials(){
//    val check  = binding.btnLogin.text.toString()
//    val newScope      = CoroutineScope(Dispatchers.IO).launch{
//        specificUser = userRepository.getSpecific(check,check)
//        specificUser.forEach {
//            if (check == it.email && check == it.password) {
//                val buttonLogin = Intent(this@LoginActivity, HomeActivity::class.java)
//                startActivity(buttonLogin)
//                Log.e("DB","___ updated ___ " )
//            }else{
//                Toast.makeText(this@LoginActivity,"failed Login",Toast.LENGTH_LONG).show()
//            }
//        }
//    }
//    binding.usernameLogin.text!!.clear()
//    binding.passwordLogin.text!!.clear()
//}