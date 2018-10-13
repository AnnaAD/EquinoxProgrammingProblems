import sys;
from random import * 
possibilities = ["School","Home","Work", "Class","Eat","Sleep"];
if len(sys.argv) != 2:
    print("Usage: python3 generator.py <number of activities>")
else:
    num = sys.argv[1]
    print(num)
    bufferTime =  randrange(1, 400)
    print(bufferTime)
    print(str(randrange(1,12)) + ":" + str(randrange(10, 59)) + ("am" if random() > .5 else "pm"))
    for i in range(int(num)):
        print(choice(possibilities) + " " + str(randrange(1, 1000))   ) 
