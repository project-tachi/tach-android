package website.tachi.app.data.repository.auth

import com.google.firebase.auth.FirebaseUser
import website.tachi.app.data.datasource.auth.AuthDataSource
import website.tachi.app.data.datasource.auth.AuthDataSourceImpl
import website.tachi.app.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(private val authDataSource: AuthDataSource) :
    AuthRepository {
    override suspend fun signInWithAuthToken(token: String): String {
        return authDataSource.signWithCustomToken(token).uid
    }
}