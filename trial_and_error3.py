import pyzbar.pyzbar as pyzbar
import cv2
import numpy as np
from json import dumps
import zbar
import time
from kafka import KafkaProducer
from kafka.errors import KafkaError
from gpiozero import Servo
import time
import RPi.GPIO as GPIO


producer = KafkaProducer(bootstrap_servers=['192.168.103.85:9092'],value_serializer=lambda x:dumps(x).encode('utf-8'))
servo = 18
GPIO.setmode(GPIO.BCM)
GPIO.setup(servo, GPIO.OUT)

pwm = GPIO.PWM(servo, 50)
pwm.start(0)

cap = cv2.VideoCapture(0)
qrcode_data = ""
#Zbar는 다중 QR 검출도 가능합니다
#인식된 QR 데이터들을 가져옵니다
scanner = zbar.Scanner()



while(1):
  ret, frame = cap.read()
  data={'msg' : 'test'}

  if not ret:
    continue

  gray = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)
     
  decoded = pyzbar.decode(gray)
  qrcode_data = ""
  
  scanner = zbar.Scanner()
  results = scanner.scan(gray)
  
  for d in decoded: 
    x, y, w, h = d.rect

    barcode_data = d.data.decode("utf-8")
    barcode_type = d.type

    cv2.rectangle(frame, (x, y), (x + w, y + h), (0, 0, 255), 2)

    text = '%s (%s)' % (barcode_data, barcode_type)
    cv2.putText(frame, text, (x, y), cv2.FONT_HERSHEY_SIMPLEX, 1, (0, 255, 255), 2, cv2.LINE_AA)

  cv2.imshow('frame', frame)
  
  for result in results:
    qrcode_data = result.data
 
  # QR 코드가 인식이 되지 않았다면
  # QR Code not detected
  if(qrcode_data!=""):
  #    print("QR Code not detected")
  #else:
  # QR 코드가 인식이 되었다면
  # 인식된 QR 코드의 데이터를 출력해준다
    print("Decoded Data : {}".format(qrcode_data))
    data = {'tmp' : qrcode_data}
    if(qrcode_data.decode()=='Error'):
      print("error")
      time.sleep(0.0)
       
      pwm.ChangeDutyCycle(6.5)
      time.sleep(0.1)
      pwm.ChangeDutyCycle(0)
      time.sleep(6)
      pwm.ChangeDutyCycle(7.5)
      time.sleep(0.17)
      pwm.ChangeDutyCycle(0.0)
      break
      producer.send('test', value=data)

  
  key = cv2.waitKey(1)
  if key == ord('q'):
    pwm.stop()
    GPIO.cleanup()
    break
# elif key == ord('s'):
#     i += 1
#     cv2.imwrite('c_%03d.jpg' % i, frame)

cap.release()
cv2.destroyAllWindows()