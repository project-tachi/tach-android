package website.tachi.app.data.network.mapper

import website.tachi.app.data.network.model.CategoryData
import website.tachi.app.domain.model.Category

fun CategoryData.toDomain() : Category {
    return Category(this.id, this.name)
}