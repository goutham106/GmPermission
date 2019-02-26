package com.gm.permission

import android.content.Context

/**
 * Author     : Gowtham
 * Email      : goutham.gm11@gmail.com
 * Github     : https://github.com/goutham106
 * Created on : 26/02/19.
 */
object PermissionUtil {
    private val stringMap: HashMap<String, String> = hashMapOf()
    fun getPermissionMessageDialog(context: Context, find: String): String {

        if (stringMap.size == 0) {
            stringMap["android.permission.READ_CALENDAR"] = context.getString(R.string.permission_denied_dangerous, "calendar")
            stringMap["android.permission.WRITE_CALENDAR"] = context.getString(R.string.permission_denied_dangerous, "calendar")
            stringMap["android.permission.CAMERA"] = context.getString(R.string.permission_denied_dangerous, "camera")
            stringMap["android.permission.READ_CONTACTS"] = context.getString(R.string.permission_denied_dangerous, "contacts")
            stringMap["android.permission.WRITE_CONTACTS"] = context.getString(R.string.permission_denied_dangerous, "contacts")
            stringMap["android.permission.GET_ACCOUNTS"] = context.getString(R.string.permission_denied_dangerous, "accounts")
            stringMap["android.permission.ACCESS_FINE_LOCATION"] =
                context.getString(R.string.permission_denied_dangerous, "location")
            stringMap["android.permission.ACCESS_COARSE_LOCATION"] =
                context.getString(R.string.permission_denied_dangerous, "location")
            stringMap["android.permission.RECORD_AUDIO"] = context.getString(R.string.permission_denied_dangerous, "audio")
            stringMap["android.permission.READ_PHONE_STATE"] =
                context.getString(R.string.permission_denied_dangerous, "phone state")
            stringMap["android.permission.READ_PHONE_NUMBERS"] =
                context.getString(R.string.permission_denied_dangerous, "phone number")
            stringMap["android.permission.CALL_PHONE"] = context.getString(R.string.permission_denied_dangerous, "call")
            stringMap["android.permission.ANSWER_PHONE_CALLS"] = context.getString(R.string.permission_denied_dangerous, "call")
            stringMap["android.permission.READ_CALL_LOG"] = context.getString(R.string.permission_denied_dangerous, "call log")
            stringMap["android.permission.WRITE_CALL_LOG"] = context.getString(R.string.permission_denied_dangerous, "call log")
            stringMap["android.permission.ADD_VOICEMAIL"] =
                context.getString(R.string.permission_denied_dangerous, "voice mail")
            stringMap["android.permission.USE_SIP"] = context.getString(R.string.permission_denied_dangerous, "sip")
            stringMap["android.permission.PROCESS_OUTGOING_CALLS"] =
                context.getString(R.string.permission_denied_dangerous, "out going call")
            stringMap["android.permission.BODY_SENSORS"] = context.getString(R.string.permission_denied_dangerous, "sensors")
            stringMap["android.permission.SEND_SMS"] = context.getString(R.string.permission_denied_dangerous, "sms")
            stringMap["android.permission.RECEIVE_SMS"] = context.getString(R.string.permission_denied_dangerous, "sms")
            stringMap["android.permission.READ_SMS"] = context.getString(R.string.permission_denied_dangerous, "sms")
            stringMap["android.permission.RECEIVE_WAP_PUSH"] =
                context.getString(R.string.permission_denied_dangerous, "wap push")
            stringMap["android.permission.RECEIVE_MMS"] = context.getString(R.string.permission_denied_dangerous, "mms")
            stringMap["android.permission.READ_EXTERNAL_STORAGE"] =
                context.getString(R.string.permission_denied_dangerous, "external storage")
            stringMap["android.permission.WRITE_EXTERNAL_STORAGE"] =
                context.getString(R.string.permission_denied_dangerous, "external storage")
        }

        return stringMap.getValue(find)

    }
}