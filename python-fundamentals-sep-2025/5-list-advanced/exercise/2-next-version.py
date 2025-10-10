version_list = input().split('.')
version = int("".join(version_list)) + 1
version_list = list(str(version))
version = '.'.join(version_list)
print(version)
