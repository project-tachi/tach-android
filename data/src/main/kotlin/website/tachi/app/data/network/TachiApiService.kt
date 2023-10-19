package website.tachi.app.data.network

import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query
import website.tachi.app.data.network.model.FestivalData
import website.tachi.app.data.network.model.GuideData
import website.tachi.app.data.network.model.KeywordData
import website.tachi.app.data.network.model.PreferenceData
import website.tachi.app.data.network.model.ReviewData
import website.tachi.app.data.network.model.ScheduleResponseData
import website.tachi.app.data.network.model.SpotData
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
    suspend fun searchAddressByCoordinates(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double
    ): TachiResponse<String>

    @POST("/v2/schedule")
    @FormUrlEncoded
    suspend fun getSchedule(
        @Field("preferenceId") preferenceId: String?,
        @Field("festivalId") festivalId: String?,
        @Field("keywordId") keywordId: String?,
        @Field("travelDuration") travelDuration: String,
        @Field("latitude") latitude: Double,
        @Field("longitude") longitude: Double,
        @Header("Authorization") token: String = "tester-tachi-hot"
    ): TachiResponse<ScheduleResponseData>

    @GET("/guides/{id}")
    suspend fun getGuide(@Path("id") id: Long, @Header("Authorization") token: String = "tester-tachi-hot"): TachiResponse<GuideData>

    @GET("/guides/{id}/reviews")
    suspend fun getGuideReviews(@Path("id") id: Long, @Header("Authorization") token: String = "tester-tachi-hot"): TachiResponse<List<ReviewData>>

    @GET("/spots/{id}")
    suspend fun getSpot(@Path("id") id: Long, @Header("Authorization") token: String = "tester-tachi-hot"): TachiResponse<SpotData>

    @GET("/spots/{id}/reviews")
    suspend fun getSpotReviews(@Path("id") id: Long, @Header("Authorization") token: String = "tester-tachi-hot"): TachiResponse<List<ReviewData>>
}