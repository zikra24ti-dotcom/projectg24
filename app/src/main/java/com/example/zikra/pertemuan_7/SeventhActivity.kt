package com.example.zikra.pertemuan_7

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.zikra.databinding.ActivitySeventhBinding

class SeventhActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySeventhBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySeventhBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = "Pertemuan 7 - Fragment"
            setDisplayHomeAsUpEnabled(true)
        }
        binding.toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        // Default fragment
        replaceFragment(SatuFragment())

        binding.btnFragment1.setOnClickListener {
            replaceFragment(SatuFragment())
        }
        binding.btnFragment2.setOnClickListener {
            replaceFragment(DuaFragment())
        }
        binding.btnFragment3.setOnClickListener {
            replaceFragment(TigaFragment())
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(binding.fragmentContainer.id, fragment)
            .addToBackStack(null)
            .commit()
    }
}
