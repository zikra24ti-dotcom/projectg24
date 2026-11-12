package com.example.zikra.pertemuan_11

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.zikra.databinding.ActivityElevanBinding
import com.example.zikra.pertemuan_11.pertemuan_111.TenthActivity
import com.example.zikra.pertemuan_11.tutorial.TutorialMessageActivity

class elevan : AppCompatActivity() {
    private lateinit var binding: ActivityElevanBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityElevanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = "Pertemuan 11 - TabLayout, RV & Onboard"
            setDisplayHomeAsUpEnabled(true)
        }
        binding.toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        binding.btnTabLayout.setOnClickListener {
            val intent = Intent(this, TenthActivity::class.java)
            startActivity(intent)
        }

        binding.btnTutorial.setOnClickListener {
            val intent = Intent(this, TutorialMessageActivity::class.java)
            startActivity(intent)
        }
    }
}
