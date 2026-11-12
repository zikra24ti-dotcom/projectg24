package com.example.hpaiapk

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.card.MaterialCardView

class VerificationActivity : AppCompatActivity() {
    private lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verification)

        sessionManager = SessionManager(this)

        val tvValName = findViewById<TextView>(R.id.tvValName)
        val tvValEmail = findViewById<TextView>(R.id.tvValEmail)
        val tvValDob = findViewById<TextView>(R.id.tvValDob)
        val tvValGender = findViewById<TextView>(R.id.tvValGender)
        val tvValUsername = findViewById<TextView>(R.id.tvValUsername)
        val tvValPassword = findViewById<TextView>(R.id.tvValPassword)
        val tvValConfirmPassword = findViewById<TextView>(R.id.tvValConfirmPassword)

        val cardSuccess = findViewById<MaterialCardView>(R.id.cardSuccess)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)
        val btnBack = findViewById<Button>(R.id.btnBack)
        val btnGoToLogin = findViewById<Button>(R.id.btnGoToLogin)

        // Ambil data dari SharedPreferences
        val name = sessionManager.getRegName()
        val email = sessionManager.getRegEmail()
        val dob = sessionManager.getRegDob()
        val gender = sessionManager.getRegGender()
        val username = sessionManager.getRegUsername()
        val password = sessionManager.getRegPassword()
        val confirmPassword = sessionManager.getRegConfirmPassword()


        tvValName.text = if (name.isNotEmpty()) name else "(Kosong)"
        tvValEmail.text = if (email.isNotEmpty()) email else "(Kosong)"
        tvValDob.text = if (dob.isNotEmpty()) dob else "(Kosong)"
        tvValGender.text = if (gender.isNotEmpty()) gender else "(Kosong)"
        tvValUsername.text = if (username.isNotEmpty()) username else "(Kosong)"
        tvValPassword.text = if (password.isNotEmpty()) password else "(Kosong)"
        tvValConfirmPassword.text = if (confirmPassword.isNotEmpty()) confirmPassword else "(Kosong)"

        btnSubmit.setOnClickListener {

            if (name.isEmpty() || email.isEmpty() || dob.isEmpty() || gender.isEmpty() ||
                username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()
            ) {
                Toast.makeText(
                    this,
                    "Validasi Gagal: Semua inputan tidak boleh kosong!",
                    Toast.LENGTH_LONG
                ).show()
                return@setOnClickListener
            }

            // Cek Password dan Confirm Password harus sama
            if (password != confirmPassword) {
                Toast.makeText(
                    this,
                    "Validasi Gagal: Password dan Confirm Password tidak sama!",
                    Toast.LENGTH_LONG
                ).show()
                return@setOnClickListener
            }

            // Jika berhasil melewati validasi
            cardSuccess.visibility = View.VISIBLE
            btnGoToLogin.visibility = View.VISIBLE
            Toast.makeText(this, "Registrasi Berhasil!", Toast.LENGTH_SHORT).show()
        }

        // Handler Tombol Kembali (Kembali ke RegisterActivity untuk perbaiki isian SP)
        btnBack.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }

        // Handler Tombol Navigasi ke Login
        btnGoToLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }
    }
}
