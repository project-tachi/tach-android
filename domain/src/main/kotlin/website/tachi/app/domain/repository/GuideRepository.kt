package website.tachi.app.domain.repository

import website.tachi.app.domain.model.Guide

interface GuideRepository {
    suspend fun getGuide(guideId : Long) : Guide
}