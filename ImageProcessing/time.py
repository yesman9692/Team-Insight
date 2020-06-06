import time

time = time.localtime()
now = "%02d%02d" % (time.tm_hour, time.tm_min)
print(now)
