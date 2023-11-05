package com.example.tugas_recyclerview_ppapb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView.OnItemSelectedListener
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tugas_recyclerview_ppapb.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
//  menghubungkan layout XML ke aktivitas menggunakan data binding.

    private lateinit var recyclerView: RecyclerView
//  daftar objek Jurnal yang akan ditampilkan dalam RecyclerView.

    private lateinit var jurnalList : ArrayList<Jurnal>
//  daftar objek Jurnal yang akan ditampilkan dalam RecyclerView.

    private lateinit var jurnalAdapter: JurnalAdapter
//  adapter khusus yang digunakan untuk menghubungkan data dari jurnalList ke RecyclerView.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
//    menghubungkan layout XML activity_home.xml dengan aktivitas HomeActivity menggunakan data binding.
        setContentView(binding.root)

        recyclerView = findViewById(R.id.recyclerView)
//    menginisialisasi variabel recyclerView dengan komponen RecyclerView yang terdapat dalam layout HomeXML.

        recyclerView.setHasFixedSize(true)
//     mengoptimalkan kinerja RecyclerView dengan memberi tahu bahwa setiap item dalam RecyclerView
//     memiliki ukuran yang tetap.

        recyclerView.layoutManager = GridLayoutManager(this, 1)
//    mengatur jenis tata letak (layout manager) untuk RecyclerView
//    menggunakan GridLayoutManager dengan satu kolom.

        jurnalList = ArrayList()
// inisialisasi dari variabel jurnalList, yang digunakan untuk menyimpan daftar objek Jurnal

        jurnalList.add(Jurnal(R.drawable.jdl1, resources.getString(R.string.jurnal1), resources.getString(R.string.desc1) ))
        jurnalList.add(Jurnal(R.drawable.jdl2, resources.getString(R.string.jurnal2), resources.getString(R.string.desc2) ))
        jurnalList.add(Jurnal(R.drawable.jdl3, resources.getString(R.string.jurnal3), resources.getString(R.string.desc3) ))
        jurnalList.add(Jurnal(R.drawable.jdl4, resources.getString(R.string.jurnal4),resources.getString(R.string.desc4) ))
        jurnalList.add(Jurnal(R.drawable.jdl5, resources.getString(R.string.jurnal5),resources.getString(R.string.desc5) ))

        jurnalAdapter = JurnalAdapter(jurnalList)
//    membuat instance dari adapter JurnalAdapter dengan menggunakan jurnalList sebagai sumber data.
        recyclerView.adapter = jurnalAdapter
//    menghubungkan adapter jurnalAdapter ke RecyclerView,
//    sehingga data dari jurnalList dapat ditampilkan dalam RecyclerView.

        jurnalAdapter.onItemClick ={
            val intentToDetailActivity = Intent(this, DetailActivity::class.java)
            intentToDetailActivity.putExtra("jurnal", it)
            startActivity(intentToDetailActivity)
        }
    }


}