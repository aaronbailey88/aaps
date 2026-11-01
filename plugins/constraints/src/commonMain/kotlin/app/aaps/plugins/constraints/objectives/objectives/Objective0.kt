package app.aaps.plugins.constraints.objectives.objectives

import app.aaps.core.interfaces.aps.Loop
import app.aaps.core.interfaces.db.PersistenceLayer
import app.aaps.core.interfaces.iob.IobCobCalculator
import app.aaps.core.interfaces.plugin.ActivePlugin
import app.aaps.core.interfaces.plugin.PluginBase
import app.aaps.core.interfaces.protection.PasswordCheck
import app.aaps.core.interfaces.pump.VirtualPump
import app.aaps.core.interfaces.resources.TextResolver
import app.aaps.core.interfaces.sync.Tidepool
import app.aaps.core.interfaces.utils.DateUtil
import app.aaps.core.keys.BooleanKey
import app.aaps.core.keys.BooleanNonKey
import app.aaps.core.keys.StringKey
import app.aaps.core.keys.interfaces.Preferences
import app.aaps.core.ui.CoreUiStrings
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
@IntKey(0)
@SingleIn(AppScope::class)
@Inject
class Objective0(
    preferences: Preferences,
    rh: TextResolver,
    durationText: DurationText,
    dateUtil: DateUtil,
    private val activePlugin: ActivePlugin,
    private val virtualPumpPlugin: VirtualPump,
    private val persistenceLayer: PersistenceLayer,
    private val loop: Loop,
    private val iobCobCalculator: IobCobCalculator,
    private val passwordCheck: PasswordCheck,
) : Objective(preferences, rh, dateUtil, durationText, "config", ConstraintsStrings.objectives_0_objective, ConstraintsStrings.objectives_0_gate) {

    val tidepoolPlugin get() = activePlugin.getSpecificPluginsListByInterface(Tidepool::class).firstOrNull() as Tidepool?

    init {
        tasks.add(object : Task(this, ConstraintsStrings.objectives_bgavailableinns) {
            override suspend fun isCompleted(): Boolean {
                return preferences.get(BooleanNonKey.ObjectivesBgIsAvailableInNs) || tidepoolPlugin?.hasWritePermission == true
            }
        })
       
    }
}