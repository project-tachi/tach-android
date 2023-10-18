package website.tachi.app.data.network.mapper

import website.tachi.app.data.network.model.PreferenceData
import website.tachi.app.domain.model.Preference

fun PreferenceData.toDomain(): Preference {
    return Preference(this.id, this.name, this.iconPath)
}