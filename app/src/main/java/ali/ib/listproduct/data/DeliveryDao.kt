package ali.ib.listproduct.data

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query

/**
 * The Data Access Object for the Delivery class.
 */
@Dao
interface DeliveryDao {

    @Query("SELECT * FROM delivery ORDER BY id")
    fun getDeliveries(): LiveData<List<Delivery>>

    @Query("SELECT * FROM delivery WHERE id = :deliveryId")
    fun getDelivery(deliveryId: String): LiveData<Delivery>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(plants: List<Delivery>)

}