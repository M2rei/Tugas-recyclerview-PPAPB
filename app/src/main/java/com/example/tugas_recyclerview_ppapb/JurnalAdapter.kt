package com.example.tugas_recyclerview_ppapb

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class JurnalAdapter (private val jurnalList: ArrayList<Jurnal>)
    : RecyclerView.Adapter<JurnalAdapter.JurnalViewHolder>() {
// digunakan untuk menghubungkan data dengan tampilan RecyclerView.
// menerima sebuah daftar objek Jurnal yang akan ditampilkan dalam RecyclerView.

    var onItemClick : ((Jurnal)->Unit)? = null
// melakukan tindakan saat item dalam recyclerView diklik
// digunakan untuk menerima objek jurnal sebagai argumen atau null jika tidak melakukan apa2

    class JurnalViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){
//       itemView: View: Ini adalah parameter yang diterima oleh konstruktor
//        yang mewakili tampilan satu item dalam daftar. itemView digunakan untuk menemukan dan
//        merujuk elemen-elemen dalam tampilan, seperti ImageView dan TextView.
        val imageView : ImageView = itemView.findViewById(R.id.imageview)
        val textJudul : TextView = itemView.findViewById(R.id.textView)
        val textdesc : TextView = itemView.findViewById(R.id.Descview)
    }
// memegang referensi ke elemen-elemen tampilan dalam setiap item dalam RecyclerView.
// berisi tiga properti: imageView, textJudul, dan textdesc,

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):JurnalViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return JurnalViewHolder(view)
    }
// digunakan untuk membuat dan mengembalikan instance dari kelas JurnalViewHolder untuk setiap
// item dalam RecyclerView.

    override fun onBindViewHolder(holder: JurnalViewHolder, position: Int) {
        val jurnal = jurnalList[position]
        holder.imageView.setImageResource(jurnal.image)
        holder.textJudul.text = jurnal.judul
        holder.textdesc.text = jurnal.desc
// digunakan untuk mengisi data item dalam RecyclerView dengan data dari daftar jurnalList.
// mengatur gambar, judul, dan deskripsi berdasarkan posisi item dalam daftar.

        holder.itemView.setOnClickListener{
            onItemClick?.invoke(jurnal)
        }
//  melakukan tindakan ketika item diklik
    }

    override fun getItemCount(): Int {
        return jurnalList.size
    }
//   mengembalikan jumlah total item dalam daftar jurnalList
//   berapa banyak item yang perku ditampikan

}