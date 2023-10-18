package website.tachi.app.data.network.mapper

import website.tachi.app.data.network.model.KeywordData
import website.tachi.app.domain.model.Keyword

fun KeywordData.toDomain(): Keyword {
    return Keyword(this.id, this.name)
}