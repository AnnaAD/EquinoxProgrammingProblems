num = int(input())
names = []
letters = [0] * 26
for i in range(num):
    names.append(input())
    firstChar = ord(names[i][0:1]) - ord('A')
    letters[firstChar] +=1
min = 1e9
loc = -1
for i in range(len(letters)):
    if letters[i] < min and letters[i] != 0:
        loc = i
        min = letters[i]
letter = chr(loc + ord('A'))
max = 0
name = ""
for i in range(len(names)):
    if len(names[i]) > max and letter == names[i][0:1].upper():
        name = names[i]
        max = len(names[i])
print(name)
