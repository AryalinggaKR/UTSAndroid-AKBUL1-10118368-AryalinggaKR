package com.example.utsandroid_akbul1_10118368_aryalinggakr

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.util.*

//    Tanggal Pengerjaan : 6 Juni 2024
//    NIM     : 10118368
//    Nama    : Aryalingga Karamasatya Radhiendra
//    Kelas   : AKB UL1


class MainActivity : AppCompatActivity() {

    private lateinit var etId: EditText
    private lateinit var etName: EditText
    private lateinit var tvDob: TextView
    private lateinit var rgGender: RadioGroup
    private lateinit var rgRelation: RadioGroup
    private lateinit var btnPreview: Button
    private lateinit var btnSubmit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etId = findViewById(R.id.et_id)
        etName = findViewById(R.id.et_name)
        tvDob = findViewById(R.id.tv_dob)
        rgGender = findViewById(R.id.rg_gender)
        rgRelation = findViewById(R.id.rg_relation)
        btnPreview = findViewById(R.id.btn_preview)
        btnSubmit = findViewById(R.id.btn_submit)

        // DatePickerDialog untuk memilih tanggal lahir
        tvDob.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
                val formattedDate = String.format("%02d-%02d-%d", selectedDay, selectedMonth + 1, selectedYear)
                tvDob.text = formattedDate
            }, year, month, day)

            datePickerDialog.show()
        }

        btnPreview.setOnClickListener {
            val id = etId.text.toString()
            val name = etName.text.toString()
            val dob = tvDob.text.toString()
            val gender = when (rgGender.checkedRadioButtonId) {
                R.id.rb_male -> "Laki-laki"
                R.id.rb_female -> "Perempuan"
                else -> ""
            }
            val relation = when (rgRelation.checkedRadioButtonId) {
                R.id.rb_ortu -> "Orang Tua"
                R.id.rb_suamiIstri -> "Suami / Istri"
                R.id.rb_anak -> "Anak"
                R.id.rb_kerabat -> "Kerabat"
                else -> ""
            }

            val intent = Intent(this, PreviewActivity::class.java).apply {
                putExtra("ID", id)
                putExtra("NAME", name)
                putExtra("DOB", dob)
                putExtra("GENDER", gender)
                putExtra("RELATION", relation)
            }
            startActivity(intent)
        }

        btnSubmit.setOnClickListener {
            Toast.makeText(this, "Data Berhasil di Simpan", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}
