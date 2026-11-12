package com.example.hpaiapk

import android.content.Context
import android.content.SharedPreferences

// SessionManager untuk mengelola status login & registrasi menggunakan SharedPreferences
class SessionManager(context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences("HerbakuPrefs", Context.MODE_PRIVATE)
    private val editor: SharedPreferences.Editor = prefs.edit()

    companion object {
        private const val KEY_IS_LOGIN = "isLogin"
        private const val KEY_USERNAME = "username"

        // Keys untuk data registrasi SharedPreferences
        private const val KEY_REG_NAME = "reg_name"
        private const val KEY_REG_EMAIL = "reg_email"
        private const val KEY_REG_DOB = "reg_dob"
        private const val KEY_REG_GENDER = "reg_gender"
        private const val KEY_REG_USERNAME = "reg_username"
        private const val KEY_REG_PASSWORD = "reg_password"
        private const val KEY_REG_CONFIRM_PASSWORD = "reg_confirm_password"
    }

    // Menyimpan sesi login
    fun createLoginSession(username: String) {
        editor.putBoolean(KEY_IS_LOGIN, true)
        editor.putString(KEY_USERNAME, username)
        editor.apply()
    }

    // Mengecek status login
    fun isLoggedIn(): Boolean {
        return prefs.getBoolean(KEY_IS_LOGIN, false)
    }

    // Mendapatkan username yang sedang login
    fun getUsername(): String? {
        return prefs.getString(KEY_USERNAME, null)
    }

    // Menghapus sesi / logout
    fun logoutSession() {
        editor.putBoolean(KEY_IS_LOGIN, false)
        editor.remove(KEY_USERNAME)
        editor.apply()
    }

    // Menyimpan data registrasi ke SharedPreferences
    fun saveRegistrationData(
        name: String,
        email: String,
        dob: String,
        gender: String,
        username: String,
        password: String,
        confirmPassword: String
    ) {
        editor.putString(KEY_REG_NAME, name)
        editor.putString(KEY_REG_EMAIL, email)
        editor.putString(KEY_REG_DOB, dob)
        editor.putString(KEY_REG_GENDER, gender)
        editor.putString(KEY_REG_USERNAME, username)
        editor.putString(KEY_REG_PASSWORD, password)
        editor.putString(KEY_REG_CONFIRM_PASSWORD, confirmPassword)
        editor.apply()
    }

    // Mendapatkan data registrasi dari SharedPreferences
    fun getRegName(): String = prefs.getString(KEY_REG_NAME, "") ?: ""
    fun getRegEmail(): String = prefs.getString(KEY_REG_EMAIL, "") ?: ""
    fun getRegDob(): String = prefs.getString(KEY_REG_DOB, "") ?: ""
    fun getRegGender(): String = prefs.getString(KEY_REG_GENDER, "") ?: ""
    fun getRegUsername(): String = prefs.getString(KEY_REG_USERNAME, "") ?: ""
    fun getRegPassword(): String = prefs.getString(KEY_REG_PASSWORD, "") ?: ""
    fun getRegConfirmPassword(): String = prefs.getString(KEY_REG_CONFIRM_PASSWORD, "") ?: ""
}
