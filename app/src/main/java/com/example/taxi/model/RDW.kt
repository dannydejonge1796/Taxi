package com.example.taxi.model

import android.os.Parcel
import android.os.Parcelable

class RDW(var kenteken: String?, var voertuigsoort: String?) : Parcelable{
  constructor(parcel: Parcel) : this(
    parcel.readString(),
    parcel.readString()
  )

  override fun writeToParcel(parcel: Parcel, flags: Int) {
    parcel.writeString(kenteken)
    parcel.writeString(voertuigsoort)
  }

  override fun describeContents(): Int {
    return 0
  }

  companion object CREATOR : Parcelable.Creator<RDW> {
    override fun createFromParcel(parcel: Parcel): RDW {
      return RDW(parcel)
    }

    override fun newArray(size: Int): Array<RDW?> {
      return arrayOfNulls(size)
    }
  }


}