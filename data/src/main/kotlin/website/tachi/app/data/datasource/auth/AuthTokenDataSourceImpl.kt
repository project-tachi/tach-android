package website.tachi.app.data.datasource.auth

import website.tachi.app.data.network.TachiApiService
import javax.inject.Inject

class AuthTokenDataSourceImpl @Inject constructor(private val tachiApiService: TachiApiService) : AuthTokenDataSource {
    override suspend fun createCustomToken(accessToken: String): String {
        return tachiApiService.createCustomToken(accessToken).data!!
    }

}
