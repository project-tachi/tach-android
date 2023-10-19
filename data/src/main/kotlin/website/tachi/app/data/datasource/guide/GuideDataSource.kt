package website.tachi.app.data.datasource.guide

import website.tachi.app.data.network.model.GuideData

interface GuideDataSource {
    suspend fun getGuide(id: Long) : GuideData
}