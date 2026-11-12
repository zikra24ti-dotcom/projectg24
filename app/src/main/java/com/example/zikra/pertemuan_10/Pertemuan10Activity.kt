package com.example.zikra.pertemuan_10

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.zikra.databinding.ActivityPertemuan10Binding

class Pertemuan10Activity : AppCompatActivity() {
    private lateinit var binding: ActivityPertemuan10Binding

    private val messageList = listOf(
        MessageModel("Alya", "Halo! Apa kabar?", "https://avatarapi.runflare.run/public/1"),
        MessageModel("Budi", "Sudah makan?", "https://avatarapi.runflare.run/public/2"),
        MessageModel("Citra", "Jangan lupa tugasnya ya!", "https://avatarapi.runflare.run/public/3"),
        MessageModel("Dika", "Besok kita rapat jam 9", "https://avatarapi.runflare.run/public/4"),
        MessageModel("Eka", "Nice job kemarin!", "https://avatarapi.runflare.run/public/5"),
        MessageModel("Fajar", "Lagi ngapain?", "https://avatarapi.runflare.run/public/6"),
        MessageModel("Gita", "Boleh minta tolong?", "https://avatarapi.runflare.run/public/7"),
        MessageModel("Hana", "Lihat email ya", "https://avatarapi.runflare.run/public/8"),
        MessageModel("Irfan", "Oke noted", "https://avatarapi.runflare.run/public/9"),
        MessageModel("Joko", "Sampai jumpa besok", "https://avatarapi.runflare.run/public/10")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPertemuan10Binding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = "Pertemuan 10 - ListView"
            setDisplayHomeAsUpEnabled(true)
        }
        binding.toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        val adapter = MessageAdapter(this, messageList)
        binding.listMessageItems.adapter = adapter
    }
}
