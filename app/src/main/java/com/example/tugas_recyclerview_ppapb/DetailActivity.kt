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
//  mengambil objek Jurnal yang dikirimkan dari aktivitas sebelumnya (HomeActivity) melalui Intent.
//  Dengan menggunakan getParcelableExtra,mengambil objek Jurnal dengan kunci "jurnal" dari Intent.
        if (jurnal != null){
//      pernyataan kondisional yang memeriksa apakah objek jurnal berhasil diambil dari Intent dan tidak null.
            val textView : TextView = findViewById(R.id.juduldetail)
            val imageView : ImageView = findViewById(R.id.imageview2)
            val descView : TextView = findViewById(R.id.descdetail)
// menghubungakn ke layout dengan menggunakan id
            textView.text =jurnal.judul
            imageView.setImageResource(jurnal.image)
            descView.text = jurnal.desc
//          menampilakan apa yang ingin ditampilkan pada bagian detail
        }
    }
}