package com.example.zikra.pertemuan_3

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.zikra.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnKirim.setOnClickListener {
            val nomor = binding.inputNoTujuan.text.toString()
            if (nomor.isNotEmpty()) {
                val intent = Intent(this, ResultActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Silahkan isi nomor tujuan", Toast.LENGTH_SHORT).show()
            }
        }
    }
}