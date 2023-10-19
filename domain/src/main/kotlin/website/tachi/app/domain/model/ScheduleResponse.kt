package website.tachi.app.domain.model

data class ScheduleResponse(
    val guides: List<Guide>,
    val scheduleResponses: List<Schedule>
)