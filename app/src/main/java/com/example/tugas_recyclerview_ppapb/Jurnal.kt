package com.example.tugas_recyclerview_ppapb

import android.os.Parcel
import android.os.Parcelable


data class Jurnal(val image: Int, val judul : String,val desc : String): Parcelable{
//    parcelable untuk memungkinkan objek dapat dikirimkan antar komponen
    constructor(parcel: Parcel) : this(
//  digunakan untuk membuat objek Jurnal dari objek Parcel
//  Parcel adalah objek yang digunakan untuk mengirim data antar komponen Android
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!
//  digunakan saat mengambil objek Jurnal dari Parcel
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
//  digunakan untuk menulis data objek Jurnal ke dalam Parcel
        parcel.writeInt(image)
        parcel.writeString(judul)
        parcel.writeString(desc)
//   mengambil Parcel sebagai argumen dan menulis nilai atribut image, judul, dan desc ke Parcel.
    }

    override fun describeContents(): Int {
        return 0
//  mengembalikan deskripsi isi objek Parcelable.
    //  dapat mengembalikan 0 karena tidak memerlukan deskripsi khusus.
    }

    companion object CREATOR : Parcelable.Creator<Jurnal> {
//  objek kompanion yang diperlukan saat mengimplementasikan Parcelable.
        override fun createFromParcel(parcel: Parcel): Jurnal {
            return Jurnal(parcel)
        }
//  digunakan untuk membuat objek Jurnal dari Parcel saat membaca kembali objek yang dikirimkan.
        override fun newArray(size: Int): Array<Jurnal?> {
            return arrayOfNulls(size)
        }
//  digunakan untuk membuat array objek Jurnal dengan ukuran tertentu.
    }

}
