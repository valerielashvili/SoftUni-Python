def fill_the_box(*args):
    height, length, width = args[:3]
    args = list(args[3:])
    box_size = height * length * width

    for i in range(len(args)):
        if args[i] == 'Finish':
            break

        if box_size >= args[i]:
            box_size -= args[i]
            args[i] = 0
        else:
            args[i] -= box_size
            box_size = 0
            break

    if box_size > 0:
        return f'There is free space in the box. You could put {box_size} more cubes.'
    else:
        return f'No more free space! You have {sum(args[:-1])} more cubes.'


print(fill_the_box(2, 8, 2, 2, 1, 7, 3, 1, 5, "Finish"))
print(fill_the_box(5, 5, 2, 40, 11, 7, 3, 1, 5, "Finish"))
print(fill_the_box(10, 10, 10, 40, "Finish", 2, 15, 30))
