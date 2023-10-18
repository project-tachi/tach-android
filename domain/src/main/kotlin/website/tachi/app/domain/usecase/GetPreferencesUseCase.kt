package website.tachi.app.domain.usecase

import website.tachi.app.domain.model.Preference
import website.tachi.app.domain.repository.PreferenceRepository
import javax.inject.Inject

class GetPreferencesUseCase @Inject constructor(private val preferenceRepository: PreferenceRepository) {
    suspend operator fun invoke(): List<Preference> {
        return preferenceRepository.getPreferences()
    }
}