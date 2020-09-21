package top.stores.sportssearch.viewmodel

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.Job
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import top.stores.sportssearch.model.*

class SearchViewModel : ViewModel() {

    var job: Job? = null
    val loading = MutableLiveData<String>()
    val error = MutableLiveData<String>()
    private var  leaguesList: MutableLiveData<List<SearchPojo>>? = null


    fun getPlayers(playerName : String): MutableLiveData<List<SearchPojo>>? {
        leaguesList=null
        if(leaguesList ==null) {
            leaguesList = MutableLiveData<List<SearchPojo>>()
            fetchData(playerName)
        }
        return leaguesList
    }


    fun fetchData(playerName: String) {
        val call = ApiCallService.callSearchPalyers(playerName)
        call.enqueue(object  : Callback<SearchResponse>
        {
            override fun onFailure(call: Call<SearchResponse>, t: Throwable) {
                Log.d("Error","failure")
            }

            override fun onResponse(
                call: Call<SearchResponse>,
                response: Response<SearchResponse>
            ) {
                if( response.body()?.response!=null) {
                    leaguesList?.value = response.body()?.response
                }
                else {
                    loading.value = "No Records found "
                    leaguesList?.value = mutableListOf()
                }

            }
        })
    }

    private fun onError(message: String) {
        error.value = message
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }

}