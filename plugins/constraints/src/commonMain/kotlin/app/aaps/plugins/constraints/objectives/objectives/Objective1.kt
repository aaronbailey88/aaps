package app.aaps.plugins.constraints.objectives.objectives

import app.aaps.core.interfaces.plugin.ActivePlugin
import app.aaps.core.interfaces.plugin.PluginBase
import app.aaps.core.interfaces.resources.ResourceHelper
import app.aaps.core.interfaces.utils.DateUtil
import app.aaps.core.keys.BooleanNonKey
import app.aaps.core.keys.interfaces.Preferences
import app.aaps.plugins.constraints.R
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Objective1 @Inject constructor(
    preferences: Preferences,
    rh: ResourceHelper,
    dateUtil: DateUtil,
    private val activePlugin: ActivePlugin
) : Objective(preferences, rh, dateUtil, "usage", R.string.objectives_usage_objective, R.string.objectives_usage_gate) {

    val actionsPlugin: PluginBase
        get() = activePlugin.getSpecificPluginsListByInterface(app.aaps.core.interfaces.actions.Actions::class.java)[0]

    init {
      
    }
}