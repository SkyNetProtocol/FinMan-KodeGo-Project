package com.example.finman1.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.finman1.R
import com.example.finman1.databinding.ActivityHomeBinding
import com.google.firebase.firestore.FirebaseFirestore

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private var fdb = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = findNavController(R.id.fragmentContainerView2)
        NavigationUI.setupWithNavController(binding.bottomNavigationView, navController)
    }

    fun saveToFireStore(name: String, role : String, url: String){
        FirebaseFirestore.setLoggingEnabled(true);
        val sampleUser: MutableMap<String, Any> = HashMap()
        sampleUser["netWorth"]      = "1Million"
        sampleUser["reportDate"]      = "July"
//        sampleUser["image_url"] = url

        fdb.collection("reports")
            .add(sampleUser)
            .addOnSuccessListener {
                Log.e("FIRE", "Success")
//                apiCall()
            }
            .addOnFailureListener { Log.e("FIRE", "Failed > " + it.toString()) }

    }
}