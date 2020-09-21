package top.stores.sportssearch.model

import com.google.gson.annotations.SerializedName

data class SearchResponse (
    @SerializedName("player")
    val response: List<SearchPojo> ?= null
)