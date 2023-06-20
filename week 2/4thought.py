import sys

op = ["+", "-", "*", "//"]


def find_op(target):
    for i in op:
        for j in op:
            for k in op:
                s = "4 " + i + " 4 " + j + " 4 " + k + " 4"
                if eval(s) == target:
                    temp = eval(s)
                    s = s.replace("//", "/")
                    s += " = " + str(temp)
                    return s
    return "no solution"


inf = sys.stdin
next(inf)
for line in sys.stdin:
    print(find_op(int(line.strip())))
