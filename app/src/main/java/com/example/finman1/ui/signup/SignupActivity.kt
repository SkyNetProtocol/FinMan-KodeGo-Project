package com.example.finman1.ui.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.finman1.application.FinManClass
import com.example.finman1.database.FinManDataClass
import com.example.finman1.databinding.ActivitySignupBinding
import com.example.finman1.ui.home.HomeActivity
import com.example.finman1.ui.login.LoginActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SignupActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding
    private lateinit var viewModel: SignupViewModel

    //remove when fail
    private lateinit var specificUser: List<FinManDataClass>

    //okay
    var userRepository = FinManClass.wordRepositoryGlobal
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val checkPassword  = binding.SignUpPassword.text.toString()
        val checkConfirmPass  = binding.SignUpConfirmPassword.text.toString()

        if (checkPassword == checkConfirmPass) {
            attachActions()
        } else {
            Toast.makeText(this@SignupActivity,"Password and Confirm Password must be equal",Toast.LENGTH_LONG).show()
        }
    }



    private fun attachActions(){
        binding.registerSignUp.setOnClickListener { addUser() }
        binding.alreadyHadAnAccount.setOnClickListener { btnActionAlreadyHadAnAccount() }
    }

    private fun addUser(){
        val newFirstName = binding.firstName.text.toString()
        val newLastName = binding.lastName.text.toString()
        val newEmail = binding.email.text.toString()
        val newPassword = binding.SignUpPassword.text.toString()
        val newConfirmPassword = binding.SignUpConfirmPassword.text.toString()

//        val newScopeRegister = CoroutineScope(Dispatchers.IO).launch {
////            specificUser = userRepository.getSpecific(check)
//            specificUser = userRepository.getSpecificMailAndPass(checkMail, checkPassword)
//            Log.e("DB", "___ success ___${specificUser.toString()}")
//        }

        val userToAdd = FinManDataClass(0, newFirstName, newLastName, newEmail, newPassword, newConfirmPassword)
        val newScope = CoroutineScope(Dispatchers.IO).launch{
            userRepository.addUserToDatabase(userToAdd)
            Log.e("DB","___ added ___ " )
        }
        binding.firstName.text!!.clear()
        binding.lastName.text!!.clear()
        binding.email.text!!.clear()
        binding.SignUpPassword.text!!.clear()
        binding.SignUpConfirmPassword.text!!.clear()
    }

    private fun btnActionAlreadyHadAnAccount(){
            val buttonLogin = Intent(this, LoginActivity::class.java)
            startActivity(buttonLogin)
    }

}