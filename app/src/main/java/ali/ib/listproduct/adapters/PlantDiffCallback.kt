package ali.ib.listproduct.adapters

import ali.ib.listproduct.data.Delivery
import android.support.v7.util.DiffUtil

class PlantDiffCallback : DiffUtil.ItemCallback<Delivery>() {

    override fun areItemsTheSame(oldItem: Delivery, newItem: Delivery): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Delivery, newItem: Delivery): Boolean {
        return oldItem == newItem
    }
}