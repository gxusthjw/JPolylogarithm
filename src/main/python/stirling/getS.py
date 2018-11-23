def stirling(i, j):
    global array
    global col
    # print str(i) + "_" + str(j)
    if j == 0 or j == i:
        array[i][j] = 1
    else:
        array[i][j] = (j + 1) * array[i - 1][j] + array[i - 1][j - 1];

    for k in range(0, j + 1):
        array[i - 1][k] = 0;

col = int(input("COL 'n' : "))
row = int(input("ROW 'k' : "))

array = [[0 for col_ in range(col)] for row_ in range(col)]

# for i in range(0, col) :
#	for j in range(0,i+1) :
#		stirling(i, j)

for i in range(0, col):
    for j in range(0, i + 1):
        stirling(i, j)
        if j == row:
            break;

if i < 11:
    print("\n\n\n")
    for i in range(0, col):
        for j in range(0, i + 1):
            print("	" + str(array[i][j]), )
        print("")

print("\n\n\n")

print("		S(" + str(col) + "," + str(row) + ") = " + str(array[col - 1][row - 1]))

print("\n\n\n")
