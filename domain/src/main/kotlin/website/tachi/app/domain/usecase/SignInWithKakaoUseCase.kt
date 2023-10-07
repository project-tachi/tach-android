package website.tachi.app.domain.usecase

import website.tachi.app.domain.repository.AuthRepository
import website.tachi.app.domain.repository.AuthTokenRepository
import javax.inject.Inject


class SignInWithKakaoUseCase @Inject constructor(
    private val authTokenRepository: AuthTokenRepository,
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(kakaoAccessToken: String): String {
        val authToken = authTokenRepository.createAuthToken(kakaoAccessToken)
        return authRepository.signInWithAuthToken(authToken)
    }
}