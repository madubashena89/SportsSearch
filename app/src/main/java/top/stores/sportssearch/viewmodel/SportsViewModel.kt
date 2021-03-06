package top.stores.sportssearch.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Job
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import top.stores.sportssearch.model.ApiCallService
import top.stores.sportssearch.model.SportPojo
import top.stores.sportssearch.model.SportsResponse


class SportsViewModel : ViewModel() {

    var job: Job? = null
    val loading = MutableLiveData<Boolean>()
    val error = MutableLiveData<String>()
    private var  sportsList: MutableLiveData<List<SportPojo>>? = null


    fun getSports(): MutableLiveData<List<SportPojo>>? {
        if (sportsList == null) {
            sportsList = MutableLiveData<List<SportPojo>>()
            fetchData()
        }
        return sportsList
    }


    fun fetchData() {
        val call = ApiCallService.call()
        call.enqueue(object  : Callback<SportsResponse>
        {
            override fun onFailure(call: Call<SportsResponse>, t: Throwable) {
                Log.d("Error","failure")
            }

            override fun onResponse(
                call: Call<SportsResponse>,
                response: Response<SportsResponse>
            ) {
                sportsList?.value=response.body()?.response
            }
        })
    }


    private fun onError(message: String) {
        error.value = message
        loading.value = false
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }



}