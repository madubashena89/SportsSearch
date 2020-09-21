package top.stores.sportssearch.model

import com.google.gson.annotations.SerializedName

data class SearchPojo (

    @SerializedName("strPlayer")
    val strPlayer : String,

    @SerializedName("strNationality")
    val strNationality : String,

    @SerializedName("strDescriptionEN")
    val strDescriptionEN : String,

    @SerializedName("strThumb")
    val strThumb : String
)
