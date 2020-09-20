package top.stores.sportssearch.model

import retrofit2.Call
import retrofit2.http.GET

interface SportsApi {

    @GET("all_sports.php")
    fun callGet(): Call<List<SportPojo>>

}