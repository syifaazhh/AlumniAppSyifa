package com.example.alumniappsyifa

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailAlumniActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_alumni)

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
        val btnUbah = findViewById<Button>(R.id.btnUbah)
        val btnHapus = findViewById<Button>(R.id.btnHapus)

        val id = intent.getStringExtra("id")
        val alumni = dbHelper.getAlumni(id!!)

        nimEditText.setText(alumni[DatabaseHelper.COLUMN_NIM])
        namaEditText.setText(alumni[DatabaseHelper.COLUMN_NAMA])
        tempatLahirEditText.setText(alumni[DatabaseHelper.COLUMN_TEMPAT_LAHIR])
        tanggalLahirEditText.setText(alumni[DatabaseHelper.COLUMN_TANGGAL_LAHIR])
        alamatEditText.setText(alumni[DatabaseHelper.COLUMN_ALAMAT])
        agamaEditText.setText(alumni[DatabaseHelper.COLUMN_AGAMA])
        tlpHpEditText.setText(alumni[DatabaseHelper.COLUMN_TLP_HP])
        tahunMasukEditText.setText(alumni[DatabaseHelper.COLUMN_TAHUN_MASUK])
        tahunLulusEditText.setText(alumni[DatabaseHelper.COLUMN_TAHUN_LULUS])
        pekerjaanEditText.setText(alumni[DatabaseHelper.COLUMN_PEKERJAAN])
        jabatanEditText.setText(alumni[DatabaseHelper.COLUMN_JABATAN])

        btnUbah.setOnClickListener {
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

            val result = dbHelper.updateAlumni(id, nim, nama, tempatLahir, tanggalLahir, alamat, agama, tlpHp, tahunMasuk, tahunLulus, pekerjaan, jabatan)
            if (result > 0) {
                Toast.makeText(this, "Data updated", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Error updating data", Toast.LENGTH_SHORT).show()
            }
        }

        btnHapus.setOnClickListener {
            val result = dbHelper.deleteAlumni(id)
            if (result > 0) {
                Toast.makeText(this, "Data deleted", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Error deleting data", Toast.LENGTH_SHORT).show()
            }
        }
    }
}