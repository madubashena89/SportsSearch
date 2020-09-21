package top.stores.sportssearch.model

import com.google.gson.annotations.SerializedName

data class SportsResponse(

    @SerializedName("sports")
    val response: List<SportPojo> ?= null
)