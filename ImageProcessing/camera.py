from picamera import PiCamera
from time import sleep
import time
import datetime

time = time.localtime()
camera = PiCamera()

camera.resolution = (2592, 1944)
camera.framerate = 15
#camera.start_preview()
while True:
    try:
        camera.capture('/home/pi/Team-Insight/ImageProcessing/image.jpg')
        camera.capture('/home/pi/Team-Insight/ImageProcessing/images/image%02d%02d%02d.jpg' % (time.tm_mday, time.tm_hour, time.tm_min))
        sleep(60)
    except Exception as e:
        f = open('/home/pi/Team-Insight/ImageProcessing/log/cameraLog.txt','w')
        write = str(datetime.datetime.now()) + '\n' + str(e) + '\n\n'
        f.write(write)
        f.close
#camera.stop_preview()
