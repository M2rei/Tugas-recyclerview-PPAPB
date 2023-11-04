package com.example.tugas_recyclerview_ppapb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.tugas_recyclerview_ppapb.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val jurnal = intent.getParcelableExtra<Jurnal>("jurnal")
        if (jurnal != null){
            val textView : TextView = findViewById(R.id.juduldetail)
            val imageView : ImageView = findViewById(R.id.imageview2)
            val descView : TextView = findViewById(R.id.descdetail)

            textView.text =jurnal.judul
            imageView.setImageResource(jurnal.image)
            descView.text = jurnal.desc
        }
    }
}