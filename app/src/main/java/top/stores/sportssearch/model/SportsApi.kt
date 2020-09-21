package top.stores.sportssearch.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface SportsApi {

    @GET("all_sports.php")
    fun callGet(): Call<SportsResponse>

    @GET("all_leagues.php")
    fun callGetLeague(): Call<LeagueResponse>

    @GET("searchplayers.php?")
    fun callQueryDynamic(@Query("p") n: String): Call<SearchResponse>

}