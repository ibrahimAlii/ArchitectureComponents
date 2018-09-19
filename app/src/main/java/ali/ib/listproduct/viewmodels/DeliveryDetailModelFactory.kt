package ali.ib.listproduct.viewmodels

import ali.ib.listproduct.data.DeliveryRepository
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

/**
 * Factory for creating a [DeliveryDetailViewModel] with a constructor that takes a [DeliveryRepository]
 * and an ID for the current [Delivery].
 */
class DeliveryDetailModelFactory(
        private val deliveryRepository: DeliveryRepository,
        private val deliveryId: String
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DeliveryDetailViewModel(deliveryRepository, deliveryId) as T
    }
}