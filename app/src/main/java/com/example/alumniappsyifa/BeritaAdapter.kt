package com.example.alumniappsyifa

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class BeritaAdapter(context: Context, private val beritaList: List<Berita>) : ArrayAdapter<Berita>(context, 0, beritaList) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_berita, parent, false)
        val berita = getItem(position)

        val textViewJudul = view.findViewById<TextView>(R.id.textViewJudul)
        val textViewDeskripsiSingkat = view.findViewById<TextView>(R.id.textViewDeskripsiSingkat)
        val imageViewBerita = view.findViewById<ImageView>(R.id.imageViewBerita)

        textViewJudul.text = berita?.judul
        textViewDeskripsiSingkat.text = berita?.deskripsiSingkat
        berita?.imageResId?.let { imageViewBerita.setImageResource(it) }

        return view
    }
}