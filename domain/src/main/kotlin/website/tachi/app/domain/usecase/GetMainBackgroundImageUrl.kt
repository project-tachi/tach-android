package website.tachi.app.domain.usecase

import website.tachi.app.domain.repository.MainBackgroundImageRepository
import javax.inject.Inject

class GetMainBackgroundImageUrl @Inject constructor(private val mainBackgroundImageRepository: MainBackgroundImageRepository) {
    suspend operator fun invoke(): String {
        return mainBackgroundImageRepository.getMainBackgroundImageUrl()
    }
}