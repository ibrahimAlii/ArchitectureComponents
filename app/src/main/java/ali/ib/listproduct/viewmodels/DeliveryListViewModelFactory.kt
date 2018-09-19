package ali.ib.listproduct.viewmodels

import ali.ib.listproduct.data.DeliveryRepository
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

/**
 * Factory for creating a [DeliveryListViewModelFactory] with a constructor that takes a [DeliveryRepository].
 */
class DeliveryListViewModelFactory(
        private val repository: DeliveryRepository
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>) = DeliveriesListViewModel(repository) as T
}