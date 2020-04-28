import cv2 as cv
import numpy as np

ori_img = cv.imread('sampleImage.jpg') #original image
cmp_img = cv.imread('sampleImage2.jpg') #image to compare

height = ori_img.shape[0] #ori_height == cmp_height
width = ori_img.shape[1]

output = np.zeros((height, width), np.uint8)
count = 0

for y in range(0, height, 1):
	for x in range(0, width, 1):
		b = ori_img.item(y, x, 0)
		g = ori_img.item(y, x, 1)
		r = ori_img.item(y, x, 2)
		ori_rgb = r+g+b
		
		b = cmp_img.item(y, x, 0)
		g = cmp_img.item(y, x, 1)
		r = cmp_img.item(y, x ,2)
		cmp_rgb =  r+g+b

#		output = np.zeros((height, width), np.uint8)

#		print(abs(cmp_rgb - ori_rgb)/3, end=' ')
		if abs(ori_rgb-cmp_rgb) > 60:
			output[y][x] = 255
			count = count + 1
#			print(abs(ori_rgb - cmp_rgb), end=' ')

cv.imwrite('output.jpg', output)
print("혼잡도:", float(count)/float(height*width)*100)
