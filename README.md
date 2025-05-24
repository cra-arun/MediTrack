# 💊 MEDI TRACK - Smart Medicine Dispenser & Reminder System

**Medi Track** is an IoT-based system that ensures elderly and chronically ill patients take their medications on time through an automated dispensing and alert system. It integrates hardware components with an Android app and Firebase for real-time monitoring and notifications.

---

## 📱 Features

- 📆 Real-time scheduling of medicine timings via Android App.
- 🤖 Automated pill dispensing using Servo Motor.
- 🚨 IR-based detection of pill pickup – alerts if the pill is not taken.
- 🔔 Mobile notifications through Firebase Cloud.
- 🔒 Secure Firebase integration and real-time data logging.
- 👨‍⚕️ Usable in homes, hospitals, clinics, and elderly care centers.

---

## 🧠 System Architecture

**Hardware Components:**
- Arduino UNO
- NodeMCU (ESP8266 Wi-Fi Module)
- RTC Module
- Servo Motor
- IR Sensors
- LEDs and Buzzer
- Acrylic Medicine Box

**Software Stack:**
- Android Studio (Java/Kotlin)
- Firebase Realtime Database
- Arduino IDE (for NodeMCU)
- C/C++ for embedded code

---

## 📷 Snapshots and Diagrams


---

## 🔗 Firebase Data Nodes

```json
{
  "irsensor": {
    "irsensor1": 4,
    "irsensor2": 5,
    "irsensor3": 1,
    "irsensor4": 3
  },
  "servo": {
    "hour1": "08",
    "hour2": "09",
    "hour3": "10",
    "hour4": "11",
    "min1": "11",
    "min2": "11",
    "min3": "11",
    "min4": "11"
  }
}
