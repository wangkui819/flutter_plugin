package com.bjdestination.baidu_statistics;

import android.util.Log;
import com.baidu.mobstat.StatService;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;

/** BaiduStatisticsPlugin */
public class BaiduStatisticsPlugin implements MethodCallHandler {

  static Registrar re;

  /** Plugin registration. */
  public static void registerWith(Registrar registrar) {
    final MethodChannel channel = new MethodChannel(registrar.messenger(), "baidu_statistics");
    channel.setMethodCallHandler(new BaiduStatisticsPlugin());
    re = registrar;
  }

  @Override
  public void onMethodCall(MethodCall call, Result result) {
    if (call.method.equals("getPlatformVersion")) {
      result.success("Android " + android.os.Build.VERSION.RELEASE);
    }else if(call.method.equals("startStatistics")) {
      StatService.start(re.context());
      result.success("startSuccess");
      Log.e("----","运行成功");
    } else {
      result.notImplemented();
    }
  }
}
