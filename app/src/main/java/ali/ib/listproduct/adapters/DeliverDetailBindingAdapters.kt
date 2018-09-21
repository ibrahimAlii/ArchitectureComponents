package ali.ib.listproduct.adapters

import ali.ib.listproduct.data.Location
import ali.ib.listproduct.view.CircleImageView
import android.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.model.MarkerOptions
import android.os.Bundle
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.CameraUpdateFactory


@BindingAdapter("imageFromUrl")
fun bindImageFromUrl(view: CircleImageView, imageUrl: String?) {
    if (!imageUrl.isNullOrEmpty()) {
        Glide.with(view.context)
                .load(imageUrl)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(view)
    }

}

@BindingAdapter("initMap")
fun bindMapFromLocation(mapView: MapView, location: Location?) {

    if (location != null) {
        mapView.onCreate(Bundle())
        mapView.getMapAsync { googleMap ->
            // Add a marker

            googleMap.addMarker(MarkerOptions().position(LatLng(location.lat, location.lng)).title(location.address))
            val center = CameraUpdateFactory.newLatLng(LatLng(location.lat,
                    location.lng))
            val zoom = CameraUpdateFactory.zoomTo(15f)

            googleMap.moveCamera(center)
            googleMap.animateCamera(zoom)
        }
    }
}




