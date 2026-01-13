n, m = [int(x) for x in input().split()]
n_elements, m_elements = set(), set()

for _ in range(n):
    n_elements.add(input())

for _ in range(m):
    m_elements.add(input())

intersection = n_elements & m_elements
for num in intersection:
    print(num)
