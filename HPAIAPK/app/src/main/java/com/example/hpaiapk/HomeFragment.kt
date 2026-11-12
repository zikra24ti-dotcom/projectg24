package com.example.hpaiapk

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment

class HomeFragment : Fragment(R.layout.fragment_home) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sessionManager = SessionManager(requireContext())
        val tvGreetingHome = view.findViewById<TextView>(R.id.tvGreetingHome)

        val username = sessionManager.getUsername() ?: "User"
        tvGreetingHome.text = "Selamat Datang, $username!"
    }
}
