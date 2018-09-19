package ali.ib.listproduct.data

import android.arch.persistence.room.Entity
import com.google.gson.annotations.SerializedName


data class Location(
        @SerializedName("lat") val lat: Double,
        @SerializedName("lng") val lng: Double,
        @SerializedName("address") val address: String
) {
    constructor(location: Location) : this(location.lat, location.lng, location.address)
}