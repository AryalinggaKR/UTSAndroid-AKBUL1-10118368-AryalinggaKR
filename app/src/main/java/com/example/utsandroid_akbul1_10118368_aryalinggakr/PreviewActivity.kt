package com.example.utsandroid_akbul1_10118368_aryalinggakr

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

//    Tanggal Pengerjaan : 6 Juni 2024
//    NIM     : 10118368
//    Nama    : Aryalingga Karamasatya Radhiendra
//    Kelas   : AKB UL1

class PreviewActivity : AppCompatActivity() {

    private lateinit var tvPreview: TextView
    private lateinit var btnBack: Button
    private lateinit var btnSubmit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview)

        tvPreview = findViewById(R.id.tv_preview)
        btnBack = findViewById(R.id.btn_back)
        btnSubmit = findViewById(R.id.btn_submit)

        val id = intent.getStringExtra("ID")
        val name = intent.getStringExtra("NAME")
        val dob = intent.getStringExtra("DOB")
        val gender = intent.getStringExtra("GENDER")
        val relation = intent.getStringExtra("RELATION")

        val previewText = """
    NIK : $id
    Nama : $name
    Tanggal Lahir : $dob
    Jenis Kelamin : $gender
    Hubungan : $relation
""".trimIndent()


        tvPreview.text = previewText

        btnBack.setOnClickListener {
            finish()
        }

        btnSubmit.setOnClickListener {
            Toast.makeText(this, "Data Berhasil di Simpan", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }
    }
}
