package ali.ib.listproduct.network

import ali.ib.listproduct.utilities.BASE_URL
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Module which provides all required dependencies about network
 */

// Safe here as we are dealing with a Dagger 2 module
@Suppress("unused")
object NetworkModule {

    /**
     * Provides the Retrofit object.
     * @return the Retrofit object
     */

    @JvmStatic
    internal fun provideRetrofitInterface(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build()
    }
}