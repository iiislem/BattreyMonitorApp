package com.example.batterymonitorapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.BatteryManager
import android.widget.TextView

class BatteryReceiver(private val statusTextView: TextView) : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {

        // Get charging state
        val plugged = intent?.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1)
        val isCharging = plugged == BatteryManager.BATTERY_PLUGGED_USB ||
                plugged == BatteryManager.BATTERY_PLUGGED_AC

        // Get battery level
        val level = intent?.getIntExtra(BatteryManager.EXTRA_LEVEL, -1) ?: -1
        val scale = intent?.getIntExtra(BatteryManager.EXTRA_SCALE, -1) ?: -1
        val batteryPct = if (level >= 0 && scale > 0) (level * 100) / scale else 0

        // Build message
        val chargingStatus = if (isCharging) {
            "Charging"
        } else {
            "Not charging"
        }

        val warning = if (batteryPct < 20) {
            "\nWarning: Low battery!"
        } else {
            "\nBattery Health : Good !"
        }

        val message = "Battery: $batteryPct% \n$chargingStatus$warning"

        // Update TextView
        statusTextView.text = message
    }
}
