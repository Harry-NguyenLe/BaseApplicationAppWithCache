package vn.edu.csc.baseapplicationapp.data.model

import android.os.Build

class DeviceInfo(
    var deviceID: String
) {
    var osVersion: String = Build.VERSION.RELEASE
    var os: String = "android"
    var deviceModel: String = Build.MODEL
}
