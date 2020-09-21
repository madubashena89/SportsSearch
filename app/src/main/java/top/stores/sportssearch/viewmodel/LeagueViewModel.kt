package top.stores.sportssearch.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Job
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import top.stores.sportssearch.model.*

class LeagueViewModel : ViewModel() {

    var job: Job? = null
    val loading = MutableLiveData<Boolean>()
    val error = MutableLiveData<String>()
    private var  leaguesList: MutableLiveData<List<LeaguePojo>>? = null


    fun getLeagues(): MutableLiveData<List<LeaguePojo>>? {
        if (leaguesList == null) {
            leaguesList = MutableLiveData<List<LeaguePojo>>()
            fetchData()
        }
        return leaguesList
    }


    fun fetchData() {
        val call = ApiCallService.calLeagues()
        call.enqueue(object  : Callback<LeagueResponse>
        {
            override fun onFailure(call: Call<LeagueResponse>, t: Throwable) {
                Log.d("Error","failure")
            }

            override fun onResponse(
                call: Call<LeagueResponse>,
                response: Response<LeagueResponse>
            ) {
                leaguesList?.value=response.body()?.response
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