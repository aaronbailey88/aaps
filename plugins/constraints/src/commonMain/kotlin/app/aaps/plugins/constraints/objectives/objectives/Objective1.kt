package app.aaps.plugins.constraints.objectives.objectives

import app.aaps.core.interfaces.resources.TextResolver
import app.aaps.core.interfaces.utils.DateUtil
import app.aaps.core.keys.BooleanNonKey
import app.aaps.core.keys.interfaces.Preferences
import app.aaps.plugins.constraints.ConstraintsStrings
import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.ContributesIntoMap
import dev.zacsweers.metro.Inject
import dev.zacsweers.metro.IntKey
import dev.zacsweers.metro.SingleIn
import dev.zacsweers.metro.binding

// Contributed rather than listed in a graph. ObjectivesPlugin takes List<Objective> and is itself
// contributed to AppScope, so the objectives have to be reachable from the same graph.
@ContributesIntoMap(AppScope::class, binding = binding<Objective>())
@IntKey(1)
@SingleIn(AppScope::class)
@Inject
class Objective1(
    preferences: Preferences,
    rh: TextResolver,
    durationText: DurationText,
    dateUtil: DateUtil
) : Objective(preferences, rh, dateUtil, durationText, "usage", ConstraintsStrings.objectives_usage_objective, ConstraintsStrings.objectives_usage_gate) {

    init {
         tasks.add(object : Task(this, ConstraintsStrings.loopenabled) {
            override suspend fun isCompleted(): Boolean {
                return (loop as PluginBase).isEnabled()
            }
        })
    }
}