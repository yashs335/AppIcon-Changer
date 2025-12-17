import 'package:flutter/services.dart';

class AppIconChanger {
  static const _channel = MethodChannel('app.icon/change');

  static Future<void> setIcon(String icon) async {
    await _channel.invokeMethod('setIcon', {'icon': icon});
  }
}
