# BatteryMonitorApp

Android application displays the **current battery percentage**, **charging state**, and shows a **warning message when the battery level is below 20%** or **Battery Health : good.** if above 20%.

## Features
- Shows **real-time battery percentage**.  
- Displays whether the device is **charging** or **not**.  
- Warns the user if the battery is **low (under 20%)**.  
- Uses a `BroadcastReceiver` to listen for **battery status updates**.  
- UI updates automatically **without** needing to **refresh** the app.

## How It Works
The app uses the built-in `ACTION_BATTERY_CHANGED` intent, which is a **sticky broadcast** sent by the Android system whenever the battery status changes.

- The `BatteryReceiver` listens to this **intent**.
- It reads:
  - `BatteryManager.EXTRA_LEVEL` to get the current battery level.
  - `BatteryManager.EXTRA_SCALE` to calculate the percentage.
  - `BatteryManager.EXTRA_PLUGGED` to check if the phone is charging.
- The status message is then displayed on a `TextView` in the **main activity**.

## Authors
- CHAOUI RAYEN DJILLALI.
- BRAHIM KHALIL.