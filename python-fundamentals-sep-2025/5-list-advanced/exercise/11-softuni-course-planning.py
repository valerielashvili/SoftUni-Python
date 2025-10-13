course = input().split(', ')

while True:
    tokens = input().split(':')
    command = tokens[0]
    
    if command == 'course start':
        break
    
    lesson_title = tokens[1]
    exercise_title = f"{lesson_title}-Exercise"

    if command == 'Add' and lesson_title not in course:
        course.append(lesson_title)
    
    elif command == 'Insert' and lesson_title not in course:
        index = int(tokens[2])
        course.insert(index, lesson_title)
    
    elif command == 'Remove' and lesson_title in course:
        if exercise_title in course:
            course.remove(exercise_title)
        course.remove(lesson_title)
    
    elif command == 'Swap':
        lesson_title_second = tokens[2]
        
        if lesson_title in course and lesson_title_second in course:
            lesson_index = course.index(lesson_title)
            lesson_second_index = course.index(lesson_title_second)
            exercise_title_second = f"{lesson_title_second}-Exercise"
            
            course[lesson_index], course[lesson_second_index] = course[lesson_second_index], course[lesson_index]

            if exercise_title in course:
                exercise_index = course.index(lesson_title) + 1
                course.remove(exercise_title)
                course.insert(exercise_index, exercise_title)
            
            if exercise_title_second in course:
                exercise_index = course.index(lesson_title_second) + 1
                course.remove(exercise_title_second)
                course.insert(exercise_index, exercise_title_second)
    
    elif command == 'Exercise':
        
        if lesson_title in course and exercise_title not in course:
            exercise_index = course.index(lesson_title) + 1
            course.insert(exercise_index, exercise_title)
        
        elif lesson_title not in course:
            course.append(lesson_title), course.append(exercise_title)

for i, lesson in enumerate(course):
    print(f"{i + 1}.{lesson}")
