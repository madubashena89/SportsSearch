package top.stores.sportssearch.model

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import top.stores.sportssearch.BuildConfig

object ApiCallService {

    private val BASE_URL = "https://www.thesportsdb.com/api/v1/json/1/"
    val okHttp2Client = OkHttpClient.Builder()

    init {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        if (BuildConfig.DEBUG) {
            okHttp2Client.addInterceptor(logging)
        }
    }



    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttp2Client.build())
        .build()
        .create(SportsApi::class.java)


     fun call() = api.callGet()
}