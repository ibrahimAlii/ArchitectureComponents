package ali.ib.listproduct


import ali.ib.listproduct.adapters.DeliveriesAdapter
import ali.ib.listproduct.databinding.FragmentDeliverListBinding
import ali.ib.listproduct.utilities.InjectorUtils
import android.arch.lifecycle.Observer
import ali.ib.listproduct.viewmodels.DeliveriesListViewModel
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.util.Log
import android.view.*


class DeliverListFragment : Fragment() {

    private lateinit var viewModel: DeliveriesListViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        Log.d(tag, "started")

        val binding = FragmentDeliverListBinding.inflate(inflater, container, false)
        val context = context ?: return binding.root

        val factory = InjectorUtils.provideDeliveryListViewModelFactory(context)
        viewModel = ViewModelProviders.of(this, factory).get(DeliveriesListViewModel::class.java)

        val adapter = DeliveriesAdapter()
        binding.deliverList.adapter = adapter

        binding.deliverList.addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.VERTICAL))
        subscribeUi(adapter)

        setHasOptionsMenu(true)
        return binding.root
    }


    private fun subscribeUi(adapter: DeliveriesAdapter) {
        viewModel.getDeliveries().observe(viewLifecycleOwner, Observer { delivery ->
            if (delivery != null) adapter.submitList(delivery)


            Log.d(tag, delivery.toString())
        })
    }

}