package com.example.hpaiapk

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class ProfileFragment : Fragment(R.layout.fragment_profile) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sessionManager = SessionManager(requireContext())
        val tvProfileName = view.findViewById<TextView>(R.id.tvProfileName)
        val btnLogoutProfile = view.findViewById<Button>(R.id.btnLogoutProfile)

        val username = sessionManager.getUsername() ?: "User"
        tvProfileName.text = username

        btnLogoutProfile.setOnClickListener {
            sessionManager.logoutSession()
            val intent = Intent(requireContext(), LoginActivity::class.java)
            startActivity(intent)
            requireActivity().finish()
        }
    }
}
