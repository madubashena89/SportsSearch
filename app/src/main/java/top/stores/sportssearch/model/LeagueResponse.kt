package top.stores.sportssearch.model

import com.google.gson.annotations.SerializedName

data class LeagueResponse (
    @SerializedName("leagues")
    val response : List<LeaguePojo> ?= null
)