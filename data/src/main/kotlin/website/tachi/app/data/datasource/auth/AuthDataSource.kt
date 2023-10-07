package website.tachi.app.data.datasource.auth

import com.google.firebase.auth.FirebaseUser

interface AuthDataSource {
    suspend fun signWithCustomToken(customToken : String) : FirebaseUser
}