import sys

biggest = -sys.maxsize
smallest = sys.maxsize

n = int(input())

for i in range(0, n):
    num = int(input())
    
    if num > biggest:
        biggest = num
    if num < smallest:
        smallest = num

print(f"Max number: {biggest}")
print(f"Min number: {smallest}")
