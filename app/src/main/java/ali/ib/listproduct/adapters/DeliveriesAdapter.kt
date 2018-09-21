package ali.ib.listproduct.adapters

import ali.ib.listproduct.DeliverListFragmentDirections
import ali.ib.listproduct.data.Delivery
import ali.ib.listproduct.databinding.ListItemDeliverBinding
import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController


/**
 * Adapter for the [RecyclerView] in [DeliverListFragment].
 */
class DeliveriesAdapter : ListAdapter<Delivery, DeliveriesAdapter.ViewHolder>(DeliverDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val delivery = getItem(position)
        holder.apply {
            bind(createOnClickListener(delivery.id), delivery)
            itemView.tag = delivery
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ListItemDeliverBinding.inflate(
                LayoutInflater.from(parent.context), parent, false))
    }

    private fun createOnClickListener(deliverId: String): View.OnClickListener {
        return View.OnClickListener {
            val direction = DeliverListFragmentDirections.actionDeliverListFragmentToDeliverDetailFragment(deliverId)
            it.findNavController().navigate(direction)
        }
    }

    class ViewHolder(
            private val binding: ListItemDeliverBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(listener: View.OnClickListener, item: Delivery) {
            binding.apply {
                clickListener = listener
                delivery = item
                executePendingBindings()
            }
        }
    }
}