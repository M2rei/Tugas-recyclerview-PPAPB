package com.example.tugas_recyclerview_ppapb

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class JurnalAdapter (private val jurnalList: ArrayList<Jurnal>)
    : RecyclerView.Adapter<JurnalAdapter.JurnalViewHolder>() {

    var onItemClick : ((Jurnal)->Unit)? = null
    class JurnalViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){
        val imageView : ImageView = itemView.findViewById(R.id.imageview)
        val textJudul : TextView = itemView.findViewById(R.id.textView)
        val textdesc : TextView = itemView.findViewById(R.id.Descview)

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):JurnalViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return JurnalViewHolder(view)
    }


    override fun onBindViewHolder(holder: JurnalViewHolder, position: Int) {
        val jurnal = jurnalList[position]
        holder.imageView.setImageResource(jurnal.image)
        holder.textJudul.text = jurnal.judul
        holder.textdesc.text = jurnal.desc

        holder.itemView.setOnClickListener{
            onItemClick?.invoke(jurnal)
        }
    }

    override fun getItemCount(): Int {
        return jurnalList.size
    }
}