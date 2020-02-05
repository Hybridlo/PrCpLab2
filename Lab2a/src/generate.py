with open("array.txt", 'w') as infile:
    x = int(input("Width:"))
    y = int(input("Height:"))
    x_target = int(input("Vinnie's x position (-1 for nowhere):"))
    y_target = int(input("Vinnie's y position (-1 for nowhere):"))
    for i in range(0, y):
        for j in range(0, x):
            if j + 1 == x_target and i + 1 == y_target:
                infile.write("1")
            else:
                infile.write("0")
            if j < y - 1:
                infile.write(" ")
        if i < x - 1:
            infile.write("\n")