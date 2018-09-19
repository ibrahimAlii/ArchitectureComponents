package ali.ib.listproduct.workers

import ali.ib.listproduct.network.NetworkApi
import ali.ib.listproduct.network.NetworkModule
import ali.ib.listproduct.viewmodels.AppDatabase
import android.annotation.SuppressLint
import android.util.Log
import androidx.work.Worker
import com.google.gson.Gson
import io.reactivex.disposables.CompositeDisposable

import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class ResponseDatabaseWorker : Worker() {
    private val TAG = ResponseDatabaseWorker::class.java.simpleName

    @SuppressLint("WrongThread")
    override fun doWork(): Worker.Result {
        val compositeDisposable = CompositeDisposable()
        return try {
            Log.d(TAG, "We have some work")
            val disposable: Disposable?
            disposable = NetworkModule.provideRetrofitInterface().create(NetworkApi::class.java).getDeliveriesList(0, 20)
                    .subscribeOn(Schedulers.io())
                    .subscribe(
                            { result ->
                                Log.d(TAG, "Some Response " + result.size + "  " + Gson().toJson(result))
                                val database = AppDatabase.getInstance(applicationContext)
                                database.deliveryDao().insertAll(result)
                            },
                            { error -> Log.e("Error ", error.message) }
                    )

            compositeDisposable.addAll(disposable)

            Worker.Result.SUCCESS

        } catch (ex: Exception) {
            Log.e(TAG, "Error seeding database", ex)
            Worker.Result.FAILURE
        } finally {
        }
    }
}