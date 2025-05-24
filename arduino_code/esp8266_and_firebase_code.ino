#include <ESP8266WiFi.h> 
#include <FirebaseArduino.h>  // Firebase library for ESP8266 
#include <SoftwareSerial.h> 
SoftwareSerial NodeMcu_SoftSerial(D3, D4);                       //RX, TX 
#define firebaseHost "servoex1-default-rtdb.firebaseio.com"      // Your Firebase project URL 
#define firebaseAuth "b6CxHpEb2L0p2qV699axcZYVZR2DW5b5h8Xnv0PL"  // Your Firebase 
authentication token 
#define ssid "Galaxy A14 5G 975B" 
#define password "5xt2nxsnun3kka6" 
char data9, data10, data11, data12; 
String min1; 
String min2; 
String min3; 
String min4; 
String hour1; 
String hour2; 
String hour3; 
String hour4; 
void setup() { 
  Serial.begin(115200); 
 //Open Serial communication (NodeMcu Arduino)                                                                                 
NodeMcu_SoftSerial.begin(115200); 
 WiFi.begin(ssid, password); 
 
  while (WiFi.status() != WL_CONNECTED) { 
    delay(1000); 
    Serial.println("Connecting to WiFi..."); 
  } 
  Serial.println("Connected to WiFi"); 
  Firebase.begin(firebaseHost, firebaseAuth); 
} 
void loop() { 
  String receivedData = Serial.readStringUntil('\n');  // Read the incoming data from ESP8266 
 // Split the received data into 4 parts and convert to integers 
  // data1 = receivedData.substring(0, 1).toInt(); 
  min1 = Firebase.getString("servo/min1"); 
  min2 = Firebase.getString("servo/min2"); 
  min3 = Firebase.getString("servo/min3"); 
  min4 = Firebase.getString("servo/min4"); 
  hour1 = Firebase.getString("servo/hour1"); 
  hour2 = Firebase.getString("servo/hour2"); 
  hour3 = Firebase.getString("servo/hour3"); 
  hour4 = Firebase.getString("servo/hour4"); 
  NodeMcu_SoftSerial.print(min1); 
  NodeMcu_SoftSerial.print(min2); 
  NodeMcu_SoftSerial.print(min3); 
  NodeMcu_SoftSerial.print(min4);                                                                               
  NodeMcu_SoftSerial.print(hour1); 
  NodeMcu_SoftSerial.print(hour2); 
  NodeMcu_SoftSerial.print(hour3); 
  NodeMcu_SoftSerial.print(hour4); 
  //String receivedData = Serial.readStringUntil('\n'); // Read the incoming data from ESP8266 
  int data[4]; 
  // Split the received data into 4 parts and convert to integers 
  data[0] = receivedData.substring(0, 1).toInt(); 
  data[1] = receivedData.substring(1, 2).toInt(); 
  data[2] = receivedData.substring(2, 3).toInt(); 
  data[3] = receivedData.substring(3, 4).toInt(); 
  Serial.print(data[0]); 
  Serial.print(data[1]); 
  Serial.print(data[2]); 
  Serial.print(data[3]); 
  Serial.print(min1); 
  Serial.print(min2); 
  Serial.print(min3); 
  Serial.print(min4); 
  Firebase.setInt("irsensor/irsensor1", data[0]); 
  Firebase.setInt("irsensor/irsensor2", data[1]); 
  Firebase.setInt("irsensor/irsensor3", data[2]); 
  Firebase.setInt("irsensor/irsensor4", data[3]); 
  delay(10000); 
}