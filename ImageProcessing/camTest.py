from picamera import PiCamera

camera = PiCamera()

camera.resolution = (2592, 1944)
camera.framerate = 15

camera.capture('/home/pi/Team-Insight/ImageProcessing/original.jpg')
