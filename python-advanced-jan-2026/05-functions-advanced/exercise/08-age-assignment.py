def age_assignment(*args, **kwargs):
    for name in args:
        if name[0] in kwargs:
            kwargs[name] = kwargs.pop(name[0])
    sorted_persons = dict(sorted(kwargs.items(), key=lambda x: x[0]))
    return ''.join(f'{name} is {age} years old.\n' for name, age in sorted_persons.items())


print(age_assignment("Peter", "George", G=26, P=19))
