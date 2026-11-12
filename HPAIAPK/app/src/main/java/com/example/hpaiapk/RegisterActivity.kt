package com.example.hpaiapk

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar

class RegisterActivity : AppCompatActivity() {
    private lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        sessionManager = SessionManager(this)

        val etName = findViewById<EditText>(R.id.etName)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etDob = findViewById<EditText>(R.id.etDob)
        val rgGender = findViewById<RadioGroup>(R.id.rgGender)
        val rbMale = findViewById<RadioButton>(R.id.rbMale)
        val rbFemale = findViewById<RadioButton>(R.id.rbFemale)
        val etUsername = findViewById<EditText>(R.id.etUsername)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val etConfirmPassword = findViewById<EditText>(R.id.etConfirmPassword)
        val btnNext = findViewById<Button>(R.id.btnNext)

        // Pre-fill data jika sudah ada di SharedPreferences (misal kembali dari Halaman Verifikasi)
        if (sessionManager.getRegName().isNotEmpty()) etName.setText(sessionManager.getRegName())
        if (sessionManager.getRegEmail().isNotEmpty()) etEmail.setText(sessionManager.getRegEmail())
        if (sessionManager.getRegDob().isNotEmpty()) etDob.setText(sessionManager.getRegDob())
        if (sessionManager.getRegGender() == "Laki-laki") {
            rbMale.isChecked = true
        } else if (sessionManager.getRegGender() == "Perempuan") {
            rbFemale.isChecked = true
        }
        if (sessionManager.getRegUsername().isNotEmpty()) etUsername.setText(sessionManager.getRegUsername())
        if (sessionManager.getRegPassword().isNotEmpty()) etPassword.setText(sessionManager.getRegPassword())
        if (sessionManager.getRegConfirmPassword().isNotEmpty()) etConfirmPassword.setText(sessionManager.getRegConfirmPassword())

        // Handler DatePicker saat etDob diklik
        etDob.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(
                this,
                { _, selectedYear, selectedMonth, selectedDay ->
                    val formattedDate = String.format("%02d/%02d/%d", selectedDay, selectedMonth + 1, selectedYear)
                    etDob.setText(formattedDate)
                },
                year, month, day
            )
            datePickerDialog.show()
        }

        btnNext.setOnClickListener {
            val name = etName.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val dob = etDob.text.toString().trim()

            val selectedGenderId = rgGender.checkedRadioButtonId
            val gender = if (selectedGenderId != -1) {
                findViewById<RadioButton>(selectedGenderId).text.toString()
            } else {
                ""
            }

            val username = etUsername.text.toString().trim()
            val password = etPassword.text.toString().trim()
            val confirmPassword = etConfirmPassword.text.toString().trim()

            // Simpan data registrasi ke SharedPreferences
            sessionManager.saveRegistrationData(
                name = name,
                email = email,
                dob = dob,
                gender = gender,
                username = username,
                password = password,
                confirmPassword = confirmPassword
            )

            Toast.makeText(this, "Data registrasi disimpan di SharedPreferences", Toast.LENGTH_SHORT).show()

            // Navigasi ke Halaman Verifikasi
            val intent = Intent(this, VerificationActivity::class.java)
            startActivity(intent)
        }
    }
}
