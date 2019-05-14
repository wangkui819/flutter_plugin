import 'dart:async';

import 'package:flutter/services.dart';

class BaiduStatistics {
  static const MethodChannel _channel =
      const MethodChannel('baidu_statistics');

  static Future<String> get platformVersion async {
    final String version = await _channel.invokeMethod('getPlatformVersion');
    return version;
  }
 //开启统计
  static Future<String> get startStatistics async {
  final String version = await _channel.invokeMethod('startStatistics');
  return version;
  }
}
