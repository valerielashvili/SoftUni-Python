numbers = input().split(', ')

def find_palindrome(nums):
    for num in nums:
        reversed_num = ''
        for n in range(len(num) - 1, -1, -1):
            reversed_num += num[n]

        if num == reversed_num:
            print(True)
        else:
            print(False)

find_palindrome(numbers)
