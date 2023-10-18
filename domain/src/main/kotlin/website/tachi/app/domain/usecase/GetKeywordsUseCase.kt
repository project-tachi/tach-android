package website.tachi.app.domain.usecase

import website.tachi.app.domain.model.Keyword
import website.tachi.app.domain.repository.KeywordRepository
import javax.inject.Inject

class GetKeywordsUseCase @Inject constructor(private val keywordRepository: KeywordRepository) {
    suspend operator fun invoke(): List<Keyword> {
        return keywordRepository.getKeywords()
    }
}