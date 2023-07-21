package com.example.finman1.ui.signup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.finman1.application.FinManClass
import com.example.finman1.database.FinManDataClass
import com.example.finman1.databinding.ActivitySignupBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SignupActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding
    private lateinit var viewModel: SignupViewModel

    var userRepository = FinManClass.wordRepositoryGlobal
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
    private fun attachActions(){
        binding.registerSignUp.setOnClickListener { addUser() }
    }

    private fun addUser(){
        val newFirstName = binding.firstName.text.toString()
        val newLastName = binding.lastName.text.toString()
        val newEmail = binding.email.text.toString()
        val newPassword = binding.SignUpPassword.text.toString()
        val newConfirmPassword = binding.SignUpConfirmPassword.text.toString()

        val userToAdd = FinManDataClass(0, newFirstName, newLastName, newEmail, newPassword, newConfirmPassword)
//        itemCount++
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

}