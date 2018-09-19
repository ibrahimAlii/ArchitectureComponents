package ali.ib.listproduct.utilities

import ali.ib.listproduct.data.DeliveryRepository
import ali.ib.listproduct.viewmodels.AppDatabase
import ali.ib.listproduct.viewmodels.DeliveryDetailModelFactory
import ali.ib.listproduct.viewmodels.DeliveryListViewModelFactory
import android.content.Context

object InjectorUtils {

    private fun getDeliveryRepository(context: Context): DeliveryRepository {
        return DeliveryRepository.getInstance(AppDatabase.getInstance(context).deliveryDao())
    }

    fun provideDeliveryListViewModelFactory(context: Context): DeliveryListViewModelFactory {
        val repository = getDeliveryRepository(context)
        return DeliveryListViewModelFactory(repository)
    }

    fun provideDeliveryDetailViewModelFactory(
            context: Context,
            deliveryId: String
    ): DeliveryDetailModelFactory {
        return DeliveryDetailModelFactory(getDeliveryRepository(context), deliveryId)
    }
}
