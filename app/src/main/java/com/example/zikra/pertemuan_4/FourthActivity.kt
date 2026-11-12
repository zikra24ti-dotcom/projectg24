package com.example.zikra.pertemuan_4

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.zikra.Pertemuan_5.fifthActivity
import com.example.zikra.databinding.ActivityFourthBinding
import com.example.zikra.pertemua_6.AuthActivity
import com.example.zikra.pertemuan_11.elevan
import com.example.zikra.pertemuan_2.SecondActivity
import com.example.zikra.pertemuan_3.ThirdActivity
import com.example.zikra.pertemuan_9.NinthActivity
import com.example.zikra.pertemuan_10.Pertemuan10Activity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

class FourthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFourthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("onCreate", "FourthActivity dibuat pertama kali")
        enableEdgeToEdge()
        binding = ActivityFourthBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val name = intent.getStringExtra("name")
        val from = intent.getStringExtra("from")
        val age = intent.getIntExtra("age", 0)
        Log.e("Data Intent", "Nama: $name , Usia: $age, Asal: $from")

        binding.btnKirimData.setOnClickListener {
            val email = binding.etEmail.text.toString().trim()
            val isNotRobot = binding.cbNotRobot.isChecked
            if (email.isEmpty()) {
                binding.etEmail.error = "Email harus diisi"
                Toast.makeText(this, "Silakan masukkan alamat email", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Data dikirim: $email (Robot Check: $isNotRobot)", Toast.LENGTH_LONG).show()
            }
        }

        binding.btnShowSnackbar.setOnClickListener {
            Snackbar.make(binding.root, "Ini adalah Snackbar", Snackbar.LENGTH_SHORT)
                .setAction("Tutup") {
                    Log.e("Info Snackbar", "Snackbar ditutup")
                }
                .show()
        }

        binding.btnShowAlertDialog.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle("Konfirmasi")
                .setMessage("Apakah Anda yakin ingin melanjutkan?")
                .setPositiveButton("Ya") { dialog, _ ->
                    dialog.dismiss()
                    Log.e("Info Dialog", "Anda memilih Ya!")
                }
                .setNegativeButton("Batal") { dialog, _ ->
                    dialog.dismiss()
                    Log.e("Info Dialog", "Anda memilih Tidak!")
                }
                .show()
        }

        binding.btn1.setOnClickListener {
            Toast.makeText(this, "Tombol 1 dalam Card diklik", Toast.LENGTH_SHORT).show()
        }

        binding.btnPertemuan1.setOnClickListener {
            Toast.makeText(this, "Buka Pertemuan 1", Toast.LENGTH_SHORT).show()
        }

        binding.btnPertemuan2.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        binding.btnPertemuan3.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)
        }

        binding.btnPertemuan4.setOnClickListener {
            Toast.makeText(this, "Anda sedang di Pertemuan 4", Toast.LENGTH_SHORT).show()
        }

        binding.btnPertemuan5.setOnClickListener {
            val intent = Intent(this, fifthActivity::class.java)
            startActivity(intent)
        }

        binding.btnPertemuan6.setOnClickListener {
            val intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
        }

        binding.btnPertemuan7.setOnClickListener {
            Toast.makeText(this, "Buka Pertemuan 7", Toast.LENGTH_SHORT).show()
        }

        binding.btnPertemuan8.setOnClickListener {
            Toast.makeText(this, "Buka Pertemuan 8", Toast.LENGTH_SHORT).show()
        }

        binding.btnPertemuan9.setOnClickListener {
            val intent = Intent(this, NinthActivity::class.java)
            startActivity(intent)
        }

        binding.btnPertemuan10.setOnClickListener {
            val intent = Intent(this, Pertemuan10Activity::class.java)
            startActivity(intent)
        }

        binding.btnPertemuan11.setOnClickListener {
            val intent = Intent(this, elevan::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.e("onStart", "onStart: FourthActivity terlihat di layar")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("onDestroy", "FourthActivity dihapus dari stack")
    }
}
