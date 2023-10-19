package website.tachi.app.data.datasource.spots

import website.tachi.app.data.network.model.GuideData
import website.tachi.app.data.network.model.SpotData

interface SpotDataSource {
    suspend fun getSpot(id: Long) : SpotData
}