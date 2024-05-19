package com.example.alumniappsyifa

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailBeritaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_berita)

        val imageViewBerita = findViewById<ImageView>(R.id.imageViewBerita)
        val textViewJudul = findViewById<TextView>(R.id.textViewJudul)
        val textViewDeskripsi = findViewById<TextView>(R.id.textViewDeskripsi)

        // Ambil data dari Intent
        val judul = intent.getStringExtra("judul")
        val deskripsiPanjang = intent.getStringExtra("deskripsiPanjang")
        val imageResId = intent.getIntExtra("imageResId", R.mipmap.ic_launcher)

        // Set data ke view
        textViewJudul.text = judul
        textViewDeskripsi.text = deskripsiPanjang
        imageViewBerita.setImageResource(imageResId)
    }
}