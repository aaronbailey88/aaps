package app.aaps.plugins.constraints.objectives.objectives

import app.aaps.core.interfaces.aps.Loop
import app.aaps.core.interfaces.db.PersistenceLayer
import app.aaps.core.interfaces.iob.IobCobCalculator
import app.aaps.core.interfaces.plugin.ActivePlugin
import app.aaps.core.interfaces.plugin.PluginBase
import app.aaps.core.interfaces.protection.PasswordCheck
import app.aaps.core.interfaces.pump.VirtualPump
import app.aaps.core.interfaces.resources.ResourceHelper
import app.aaps.core.interfaces.sync.Tidepool
import app.aaps.core.interfaces.utils.DateUtil
import app.aaps.core.keys.BooleanKey
import app.aaps.core.keys.BooleanNonKey
import app.aaps.core.keys.StringKey
import app.aaps.core.keys.interfaces.Preferences
import app.aaps.core.ui.toast.ToastUtils
import app.aaps.plugins.constraints.R
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Objective0 @Inject constructor(
    preferences: Preferences,
    rh: ResourceHelper,
    dateUtil: DateUtil,
    private val activePlugin: ActivePlugin,
    private val virtualPumpPlugin: VirtualPump,
    private val persistenceLayer: PersistenceLayer,
    private val loop: Loop,
    private val iobCobCalculator: IobCobCalculator,
    private val passwordCheck: PasswordCheck,
) : Objective(preferences, rh, dateUtil, "config", R.string.objectives_0_objective, R.string.objectives_0_gate) {


    val tidepoolPlugin get() = activePlugin.getSpecificPluginsListByInterface(Tidepool::class.java).firstOrNull() as Tidepool?

    init {
      
    }
}