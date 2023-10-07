package website.tachi.app.data.network

import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import website.tachi.app.data.network.model.TachiResponse


interface TachiApiService {
    @POST("auth/custom-token")
    @FormUrlEncoded
    suspend fun createCustomToken(@Field("accessToken") accessToken: String): TachiResponse<String>
}