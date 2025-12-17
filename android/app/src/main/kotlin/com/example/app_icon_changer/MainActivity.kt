package com.example.app_icon_changer

import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel

class MainActivity : FlutterActivity() {

    private val CHANNEL = "app.icon/change"

    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)

        val iconChanger = AppIconChanger(this)

        MethodChannel(
            flutterEngine.dartExecutor.binaryMessenger,
            CHANNEL
        ).setMethodCallHandler { call, result ->
            when (call.method) {
                "setIcon" -> {
                    val icon = call.argument<String>("icon")
                    if (icon != null) {
                        iconChanger.changeIcon(icon)
                        result.success(true)
                    } else {
                        result.error("INVALID", "Icon name is missing", null)
                    }
                }
                else -> result.notImplemented()
            }
        }
    }
}
