package top.stores.sportssearch.model

import com.google.gson.annotations.SerializedName

data class SportPojo(
    @SerializedName("idSport")
    val sportsID : Int,

    @SerializedName("strSport")
    val sportName : String,

    @SerializedName("strFormat")
    val sportFormat : String,

    @SerializedName("strSportThumb")
    val sportImageUrl : String,

    @SerializedName("strSportDescription")
    val sportDescription : String
)