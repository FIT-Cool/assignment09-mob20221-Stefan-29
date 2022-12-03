package com.stefan.prak09.Api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author Stefanus - 2072013
 * **
 */

//https://newsapi.org/v2/everything?q=Twitter&from=2022-11-20&sortBy=popularity&apiKey=f0c081794a864a8ca72ebbebc350efc9

interface NewsApi {
    @GET("everything") //get annotation
    fun getCurrentNewsData(@Query("q") mention: String?, @Query("apiKey") apiKey: String): Call<ArticlesJson?>?
}
