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
    private lateinit var recyclerView: RecyclerView
    private lateinit var jurnalList : ArrayList<Jurnal>
    private lateinit var jurnalAdapter: JurnalAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = GridLayoutManager(this, 1)

        jurnalList = ArrayList()

        jurnalList.add(Jurnal(R.drawable.jdl1, resources.getString(R.string.jurnal1), resources.getString(R.string.desc1) ))
        jurnalList.add(Jurnal(R.drawable.jdl2, resources.getString(R.string.jurnal2), resources.getString(R.string.desc2) ))
        jurnalList.add(Jurnal(R.drawable.jdl3, resources.getString(R.string.jurnal3), resources.getString(R.string.desc3) ))
        jurnalList.add(Jurnal(R.drawable.jdl4, resources.getString(R.string.jurnal4),resources.getString(R.string.desc4) ))
        jurnalList.add(Jurnal(R.drawable.jdl5, resources.getString(R.string.jurnal5),resources.getString(R.string.desc5) ))

        jurnalAdapter = JurnalAdapter(jurnalList)
        recyclerView.adapter = jurnalAdapter

        jurnalAdapter.onItemClick ={
            val intentToDetailActivity = Intent(this, DetailActivity::class.java)
            intentToDetailActivity.putExtra("jurnal", it)
            startActivity(intentToDetailActivity)
        }
    }


}