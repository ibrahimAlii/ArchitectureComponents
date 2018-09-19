package ali.ib.listproduct.viewmodels

import ali.ib.listproduct.data.Delivery
import ali.ib.listproduct.data.DeliveryRepository
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel

/**
 * The ViewModel used in [DeliveryDetailFragment].
 */
class DeliveryDetailViewModel(
        deliveryRepository: DeliveryRepository,
        private val deliveryId: String
) : ViewModel() {

    val delivery: LiveData<Delivery> = deliveryRepository.getDelivery(deliveryId)


}