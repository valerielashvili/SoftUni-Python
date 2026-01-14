from collections import deque
import operator


def calculate(nums: deque, operation: str) -> int:
    result = nums.popleft()
    while nums:
        result = ops[operation](result, nums.popleft())
    return result

ops = {
    '+': operator.add,
    '-': operator.sub,
    '*': operator.mul,
    '/': operator.floordiv
}

expression = input().split()
deque_of_nums = deque()

for n in expression:
    if n.isdigit() or n.lstrip('-').isdigit():
        deque_of_nums.append(int(n))
    else:
        deque_of_nums.append(calculate(deque_of_nums, n))

print(f'{deque_of_nums[0]}')
