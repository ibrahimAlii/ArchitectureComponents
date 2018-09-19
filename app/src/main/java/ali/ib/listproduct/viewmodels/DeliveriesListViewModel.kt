package ali.ib.listproduct.viewmodels

import ali.ib.listproduct.data.Delivery
import ali.ib.listproduct.data.DeliveryRepository
import android.arch.lifecycle.*


/**
 * The ViewModel for [DeliverListFragment].
 */

class DeliveriesListViewModel internal constructor(
        private val deliveryRepository: DeliveryRepository
) : ViewModel() {

    private val refresher = MutableLiveData<Int>()

    private val deliverList = MediatorLiveData<List<Delivery>>()


    init {
        refresher.value = -1;
        val liveDeliverList = Transformations.switchMap(refresher) {
            if (it == -1) {
                deliveryRepository.getDeliveries()
            } else {
                deliveryRepository.getDeliveries()
            }
        }

        deliverList.addSource(liveDeliverList, deliverList::setValue)
    }

    fun getDeliveries() = deliverList


}