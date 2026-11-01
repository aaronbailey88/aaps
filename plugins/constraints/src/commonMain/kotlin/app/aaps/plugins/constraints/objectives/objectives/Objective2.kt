package app.aaps.plugins.constraints.objectives.objectives

import app.aaps.core.interfaces.resources.ResourceHelper
import app.aaps.core.interfaces.utils.DateUtil
import app.aaps.core.keys.interfaces.Preferences
import app.aaps.plugins.constraints.R
import javax.inject.Inject
import javax.inject.Singleton

@Suppress("SpellCheckingInspection")
@Singleton
class Objective2 @Inject constructor(
    preferences: Preferences,
    rh: ResourceHelper,
    dateUtil: DateUtil,
) : Objective(preferences, rh, dateUtil, "exam", R.string.objectives_exam_objective, R.string.objectives_exam_gate) {

    init {
     
        for (task in tasks) (task as ExamTask).options.shuffle()

        for (task in tasks) {
            if (!task.isCompleted()) accomplishedOn = 0
        }
    }
}