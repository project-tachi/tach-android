package website.tachi.app.data.datasource.auth

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AuthDataSourceImpl @Inject constructor(private val auth: FirebaseAuth) : AuthDataSource {
    override suspend fun signWithCustomToken(customToken: String): FirebaseUser {
        return auth.signInWithCustomToken(customToken).await().user!!
    }
}