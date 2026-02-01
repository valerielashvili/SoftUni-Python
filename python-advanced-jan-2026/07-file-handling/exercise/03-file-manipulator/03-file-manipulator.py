import os


def create_file(path):
    with open(path, 'w'):
        pass


def read_file(path):
    with open(path, 'r') as f:
        return f.readlines()


def write_to_file(path, new_content):
    with open(path, 'w') as f:
        f.writelines(new_content)


def append_to_file(path, new_content):
    with open(path, 'a') as f:
        f.write(f'{new_content}\n')


ABSOLUTE_PATH = os.path.abspath(__file__)
DIR_PATH = os.path.dirname(ABSOLUTE_PATH)

while (line := input()) != 'End':
    tokens = line.split('-')
    cmd, file_name = tokens[0], tokens[1]

    text_file = os.path.join(DIR_PATH, file_name)
    file_exists = os.path.exists(text_file)

    if cmd == 'Create':
        create_file(text_file)

    elif cmd == 'Add':
        content = tokens[2]
        if not file_exists:
            create_file(text_file)
        append_to_file(text_file, content)

    elif cmd == 'Replace':
        content, new_string = tokens[2], tokens[3]
        if file_exists:
            file_content = read_file(text_file)
            file_content = [line.replace(content, new_string) for line in file_content]
            write_to_file(text_file, file_content)
        else:
            print(f'An error occurred')

    elif cmd == 'Delete':
        if file_exists:
            os.remove(text_file)
        else:
            print(f'An error occurred')
