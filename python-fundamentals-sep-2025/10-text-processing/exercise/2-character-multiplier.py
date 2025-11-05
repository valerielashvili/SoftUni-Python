str_1, str_2 = input().split()
char_sum = 0
boundary = 0

if len(str_1) > len(str_2):
    boundary = len(str_2)
else:
    boundary = len(str_1)

for i in range(boundary):
    char_sum += ord(str_1[i]) * ord(str_2[i])

char_sum += sum(ord(c) for c in (str_1[boundary:] + str_2[boundary:]))
print(char_sum)
