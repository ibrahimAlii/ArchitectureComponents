package ali.ib.listproduct.viewmodels

import ali.ib.listproduct.data.Location
import android.arch.persistence.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.json.JSONObject
import java.util.*

/**
 * Type converters to allow Room to reference complex data types.
 */
class Converters {
    @TypeConverter
    fun locationToString(location: Location): String = Gson().toJson(location)

    @TypeConverter
    fun stringToLocation(value: String): Location =
            Location(Gson().fromJson(value, Location::class.java))
}