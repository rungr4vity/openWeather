package il.pacolo.com.appweather.utils

import androidx.recyclerview.widget.DiffUtil
import il.pacolo.com.appweather.models.LocationDetails


object MyDiffUtil: DiffUtil.ItemCallback<LocationDetails>() {
    override fun areItemsTheSame(oldItem: LocationDetails, newItem: LocationDetails): Boolean {
        return oldItem.city == newItem.city
    }

    override fun areContentsTheSame(oldItem: LocationDetails, newItem: LocationDetails): Boolean {
        return oldItem == newItem
    }

}