package ali.ib.listproduct


import ali.ib.listproduct.databinding.FragmentDeliverDetailsBinding
import ali.ib.listproduct.utilities.InjectorUtils
import ali.ib.listproduct.viewmodels.DeliveryDetailViewModel
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.*


class DeliverDetailsFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val deliveryId = DeliverDetailsFragmentArgs.fromBundle(arguments).deliverId

        val factory = InjectorUtils.provideDeliveryDetailViewModelFactory(requireActivity(), deliveryId)
        val deliveryDetailViewModel = ViewModelProviders.of(this, factory)
                .get(DeliveryDetailViewModel::class.java)

        val binding = DataBindingUtil.inflate<FragmentDeliverDetailsBinding>(
                inflater, R.layout.fragment_deliver_details, container, false).apply {
            viewModel = deliveryDetailViewModel
            setLifecycleOwner(this@DeliverDetailsFragment)

        }

        deliveryDetailViewModel.delivery.observe(this, Observer { delivery ->
            Log.d(tag, delivery?.description)
        })

        setHasOptionsMenu(true)

        return binding.root
    }


}