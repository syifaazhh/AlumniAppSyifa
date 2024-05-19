package com.example.alumniappsyifa

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TambahDataActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_data)

        val dbHelper = DatabaseHelper(this)

        val nimEditText = findViewById<EditText>(R.id.nim)
        val namaEditText = findViewById<EditText>(R.id.nama)
        val tempatLahirEditText = findViewById<EditText>(R.id.tempat_lahir)
        val tanggalLahirEditText = findViewById<EditText>(R.id.tanggal_lahir)
        val alamatEditText = findViewById<EditText>(R.id.alamat)
        val agamaEditText = findViewById<EditText>(R.id.agama)
        val tlpHpEditText = findViewById<EditText>(R.id.tlp_hp)
        val tahunMasukEditText = findViewById<EditText>(R.id.tahun_masuk)
        val tahunLulusEditText = findViewById<EditText>(R.id.tahun_lulus)
        val pekerjaanEditText = findViewById<EditText>(R.id.pekerjaan)
        val jabatanEditText = findViewById<EditText>(R.id.jabatan)

        val btnSimpan = findViewById<Button>(R.id.btnSimpan)
        btnSimpan.setOnClickListener {
            val nim = nimEditText.text.toString()
            val nama = namaEditText.text.toString()
            val tempatLahir = tempatLahirEditText.text.toString()
            val tanggalLahir = tanggalLahirEditText.text.toString()
            val alamat = alamatEditText.text.toString()
            val agama = agamaEditText.text.toString()
            val tlpHp = tlpHpEditText.text.toString()
            val tahunMasuk = tahunMasukEditText.text.toString()
            val tahunLulus = tahunLulusEditText.text.toString()
            val pekerjaan = pekerjaanEditText.text.toString()
            val jabatan = jabatanEditText.text.toString()

            val result = dbHelper.addAlumni(nim, nama, tempatLahir, tanggalLahir, alamat, agama, tlpHp, tahunMasuk, tahunLulus, pekerjaan, jabatan)
            if (result > 0) {
                Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Error saving data", Toast.LENGTH_SHORT).show()
            }
        }
    }
}