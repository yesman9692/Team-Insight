import ImageProcessingTest2
import pymysql

conn = pymysql.connect(host='192.168.200.169', user='root', passwd='0050', db='CLA')

cur = conn.cursor()
cur.execute("SELET * FROM Sensor")

print(cur.description)
print()

for row in cur:
	print(row)

cur.close()
conn.close()
