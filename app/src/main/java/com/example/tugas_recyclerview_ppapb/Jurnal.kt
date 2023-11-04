package com.example.tugas_recyclerview_ppapb

import android.os.Parcel
import android.os.Parcelable


data class Jurnal(val image: Int, val judul : String,val desc : String): Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(image)
        parcel.writeString(judul)
        parcel.writeString(desc)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Jurnal> {
        override fun createFromParcel(parcel: Parcel): Jurnal {
            return Jurnal(parcel)
        }

        override fun newArray(size: Int): Array<Jurnal?> {
            return arrayOfNulls(size)
        }
    }

}
