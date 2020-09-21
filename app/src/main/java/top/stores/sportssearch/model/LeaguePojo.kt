package top.stores.sportssearch.model

import com.google.gson.annotations.SerializedName

class LeaguePojo (

        @SerializedName("strLeague")
        val strLeagueL: String,

        @SerializedName("strSport")
        val strSportL : String,

        @SerializedName("strLeagueAlternate")
        val strLeagueAlternateL : String
)
