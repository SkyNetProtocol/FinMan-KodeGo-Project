package com.example.finman1.ui.fragments.financialfragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.finman1.databinding.FragmentAssetsBinding
import com.example.finman1.ui.addactivity.AddAssetsActivity


class AssetsFragment : Fragment() {
    private var _binding : FragmentAssetsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAssetsBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.assetsOne.setOnClickListener {
            val intentAddAsset = Intent(this.activity, AddAssetsActivity::class.java)
            startActivity(intentAddAsset)
        }
    }

}