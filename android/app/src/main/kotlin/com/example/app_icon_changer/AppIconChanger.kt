package com.example.app_icon_changer

import android.content.Context
import android.content.ComponentName
import android.content.pm.PackageManager

class AppIconChanger(private val context: Context) {

    fun changeIcon(icon: String) {
        val pm = context.packageManager
        val pkg = context.packageName

        val main = ComponentName(pkg, "$pkg.MainActivity")
        val one = ComponentName(pkg, "$pkg.IconOne")
        val two = ComponentName(pkg, "$pkg.IconTwo")

        val enable = PackageManager.COMPONENT_ENABLED_STATE_ENABLED
        val disable = PackageManager.COMPONENT_ENABLED_STATE_DISABLED
        val flags = PackageManager.DONT_KILL_APP

        when (icon) {
            "default" -> {
                pm.setComponentEnabledSetting(one, disable, flags)
                pm.setComponentEnabledSetting(two, disable, flags)
                pm.setComponentEnabledSetting(main, enable, flags)
            }
            "one" -> {
                pm.setComponentEnabledSetting(main, disable, flags)
                pm.setComponentEnabledSetting(two, disable, flags)
                pm.setComponentEnabledSetting(one, enable, flags)
            }
            "two" -> {
                pm.setComponentEnabledSetting(main, disable, flags)
                pm.setComponentEnabledSetting(one, disable, flags)
                pm.setComponentEnabledSetting(two, enable, flags)
            }
        }
    }
}
