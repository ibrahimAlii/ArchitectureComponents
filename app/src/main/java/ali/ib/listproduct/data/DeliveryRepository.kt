package ali.ib.listproduct.data

class DeliveryRepository private constructor(private val deliveryDao: DeliveryDao) {

    fun getDeliveries() = deliveryDao.getDeliveries()

    fun getDelivery(deliveryId : String) = deliveryDao.getDelivery(deliveryId)

    companion object {

        // For Singleton instantiation
        @Volatile private var instance: DeliveryRepository? = null

        fun getInstance(deliveryDao: DeliveryDao) =
                instance ?: synchronized(this) {
                    instance ?: DeliveryRepository(deliveryDao).also { instance = it }
                }
    }
}