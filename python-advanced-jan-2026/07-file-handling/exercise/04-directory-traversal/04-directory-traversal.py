import os.path


dir_path = input()
dir_content = []
files = []
file_groups = {}

ABSOLUTE_PATH = os.path.abspath(__file__)
DIR_PATH = os.path.dirname(ABSOLUTE_PATH)
output_file = os.path.join(DIR_PATH, 'report.txt')

try:
    dir_content = os.listdir(dir_path)
except FileNotFoundError:
    print('Directory not found')

for entry in dir_content:
    rel_path = os.path.join(dir_path, entry)
    if os.path.isdir(rel_path):
        files += os.listdir(rel_path)
    else:
        files.append(entry)

for file in files:
    file_name, extension = os.path.splitext(file)
    if extension not in file_groups:
        file_groups[extension] = []
    file_groups[extension].append(f'{file_name}{extension}')

for ext in file_groups:
    file_groups[ext].sort()

sorted_file_groups = dict(sorted(file_groups.items()))

with open(output_file, 'w') as file:
    for ext, file_names in sorted_file_groups.items():
        file.write(f'{ext}\n')
        for file_name in file_names:
            file.write(f'- - - {file_name}\n')
