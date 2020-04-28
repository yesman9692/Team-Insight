import cv2 as cv
import numpy as np

ori_img = cv.imread('sampleImage.jpg') #original image
src_img = cv.imread('sampleImage2.jpg') #image to compare

height = ori_img.shape[0] #ori_height == cmp_height
width = ori_img.shape[1]

output = np.zeros((height, width), np.uint8)
count = 0

for y in range(0, height, 1):
	for x in range(0, width, 1):
		b1 = ori_img.item(y, x, 0)
		g1 = ori_img.item(y, x, 1)
		r1 = ori_img.item(y, x, 2)

		b2 = src_img.item(y, x, 0)
		g2 = src_img.item(y, x, 1)
		r2 = src_img.item(y, x ,2)

		if abs(r1-r2) and abs(g1-g2) and abs(b1-b2) > 30:
			output[y][x] = 255
			count = count + 1

cv.imwrite('output2.jpg', output)
print("혼잡도:", float(count)/float(height*width)*100)
