package ali.ib.listproduct.data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "delivery")
data class Delivery(
        @SerializedName("id") @PrimaryKey @ColumnInfo(name = "id") val id: String,
        @SerializedName("description") val description: String,
        @SerializedName("location") val location: Location,
        @SerializedName("imageUrl") val imageUrl: String = ""
) {

    //override fun toString() = location.address
}