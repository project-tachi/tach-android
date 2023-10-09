package website.tachi.app.data.network

import android.preference.Preference
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import website.tachi.app.data.network.model.FestivalData
import website.tachi.app.data.network.model.KeywordData
import website.tachi.app.data.network.model.PreferenceData
import website.tachi.app.data.network.model.TachiResponse

interface TachiApiService {
    @POST("auth/custom-token")
    @FormUrlEncoded
    suspend fun createCustomToken(@Field("accessToken") accessToken: String): TachiResponse<String>

    @GET("recommend/preferences")
    suspend fun getAllPreferences(): TachiResponse<List<PreferenceData>>

    @GET("/recommend/festivals")
    suspend fun getAllFestivals(): TachiResponse<List<FestivalData>>

    @GET("/recommend/keywords")
    suspend fun getAllKeywords(): TachiResponse<List<KeywordData>>

    @GET("/search/coord2address")
    suspend fun searchAddressByCoordinates(): TachiResponse<String>
}