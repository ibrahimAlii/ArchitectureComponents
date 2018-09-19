package ali.ib.listproduct.network

import ali.ib.listproduct.data.Delivery
import android.arch.lifecycle.LiveData
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import io.reactivex.Observable
import retrofit2.http.Query

/**
 * The interface which provides methods to get result of webservices
 */
interface NetworkApi {
    /**
     * Get the list of the deliveries from the API
     */

    @GET("deliveries")
    fun getDeliveriesList(@Query("offset") offset: Int, @Query("limit") limit: Int): Observable<List<Delivery>>
}