numbers = [int(num) for num in input().split()]
finish_line = len(numbers) // 2

podracer_time = 0
flash_speeder_time = 0
winner_time = 0
winner = ''

for i in range(finish_line):
    time = int(numbers[i])
    podracer_time += time

    if time == 0:
        podracer_time *= 0.8

for j in range(len(numbers) - 1, finish_line, -1):
    time = int(numbers[j])
    flash_speeder_time += time
    
    if time == 0:
        flash_speeder_time *= 0.8

if podracer_time < flash_speeder_time:
    winner = 'left'
    winner_time = podracer_time
else:
    winner = 'right'
    winner_time = flash_speeder_time

print(f"The winner is {winner} with total time: {winner_time:.1f}")
