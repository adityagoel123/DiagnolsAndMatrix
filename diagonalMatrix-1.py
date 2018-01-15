# input the no of coordinates

def check(co_1,co_2):
	# print(co_1)
	# print(co_2)
	dif_x = co_1[0]-co_2[0]
	dif_y = co_1[1]-co_2[1]
	if( abs(dif_x)==abs(dif_y) ):
		return co_1,co_2
	# if( abs(dif_x)==abs(dif_y) ):t
	# 	return 1
	# else:
	# 	return 0

if __name__ == "__main__":
	final_result = list()
	# print("Enter the no of test cases")
	tc = int(raw_input())
	for test_no in range(tc):
		# print("Test Case No ",test_no+1)
		# print("Enter the no of coordinates")
		no_coordinates = int(raw_input())
		mat = list()
		for i in range(no_coordinates):
			# print("Enter co-ordinate no in space separted fashion",i)
			value = raw_input()
			x = int(value.split()[0])
			y = int(value.split()[1])
			mat.append((x,y))

		result = list()
		for i in range(no_coordinates-1):
			for j in range(i+1,no_coordinates):
				# result += check(mat[i],mat[j])
				temp_res = check(mat[i],mat[j])
				if temp_res:
					result.append(temp_res[0])
					result.append(temp_res[1])

		# print("result mat is ",set(result))
		final_result.append(len(set(result)))
		# print("Answer is ",len(set(result)))
	
	# Showiing results
	for test_no in range(tc):
		print(final_result[test_no])	