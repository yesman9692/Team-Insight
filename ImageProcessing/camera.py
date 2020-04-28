from picamera import PiCamera
from time import sleep

camera = PiCamera()

camera.resolution = (2592, 1944)
camera.framerate = 15
camera.start_preview()
for i in range(5):
	sleep(5)
	camera.capture('/home/pi/ImageProcessing/sampleImage2.jpg')
	print("captured")
camera.stop_preview()
