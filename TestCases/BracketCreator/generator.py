import sys;
if len(sys.argv)!= 2:
    print("Usage: generator <number of teams>");
num = int(sys.argv[1]);
print(num);
for i in range(num) :
        print("Team"+str(i));
