package com.example.taxi.model

import android.os.Parcel
import android.os.Parcelable

class RDW(var kenteken: String?, var voertuigsoort: String?) : Parcelable{
  //Met parcels kunnen objecten worden verstuurd tussen componenten
  constructor(parcel: Parcel) : this(
    //Leest waardes van attributen van het parcel object
    parcel.readString(),
    parcel.readString()
  )

  //Van rdw object naar parcel object
  override fun writeToParcel(parcel: Parcel, flags: Int) {
    parcel.writeString(kenteken)
    parcel.writeString(voertuigsoort)
  }

  override fun describeContents(): Int {
    //Bevat geen bijzondere types
    return 0
  }

  companion object CREATOR : Parcelable.Creator<RDW> {
    //Creëer een nieuwe instantie d.m.v. een parcel
    override fun createFromParcel(parcel: Parcel): RDW {
      return RDW(parcel)
    }

    //Nieuwe array maken met rdw objecten ter grootte van meegegeven grootte
    override fun newArray(size: Int): Array<RDW?> {
      //Alle items in de array worden op null gezet
      return arrayOfNulls(size)
    }
  }
}