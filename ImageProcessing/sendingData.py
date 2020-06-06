import ImageProcessingTest2 as Ipt
import pymysql
import datetime

while True:
    try:
        confuse = Ipt.ImageProcessing()

        conn = pymysql.connect(host='115.31.121.82', port=8009, user='phpmyadmin', passwd='0050', db='CLA')

        cur = conn.cursor()
        sql = "INSERT INTO Sensor VALUES('BookCafe'," + str(confuse) + ",now())"
        cur.execute(sql)
        conn.commit()

        cur.close()
        conn.close()
    except Exception as e:
        f = open('/home/pi/Team-Insight/ImageProcessing/log/sendingDataLog.txt','w')
        write = str(datetime.datetime.now()) + '\n' + str(e) + '\n\n'
        f.write(write)
        f.close
