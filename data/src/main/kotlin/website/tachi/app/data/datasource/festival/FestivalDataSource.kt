package website.tachi.app.data.datasource.festival

import website.tachi.app.data.network.model.FestivalData
import website.tachi.app.domain.model.Festival

interface FestivalDataSource {
    suspend fun getFestivals() : List<FestivalData>
}