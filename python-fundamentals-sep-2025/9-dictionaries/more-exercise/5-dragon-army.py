from typing import Tuple


def add_dragon(name:str, damage: int | str, health: int | str, armor: int | str) -> dict:
    """Return a dragon and its stats as dict. Assign defaults if a stat is None."""
    damage = 45 if damage == 'null' else damage
    health = 250 if health == 'null' else health
    armor = 10 if armor == 'null' else armor

    return {name: {
        'damage': damage,
        'health': health,
        'armor': armor
    }}


def sort_dragons(sorted_dragons: dict) -> dict:
    """Sort dragons by names alphabetically."""
    for dr_type, dragon in sorted_dragons.items():
        sorted_dragons[dr_type] = dict(sorted(dragon.items(), key=lambda name: name[0]))
    return sorted_dragons


def calc_avg_stats(dragons: dict) -> Tuple[float, float, float]:
    """Compute avg damage, health, armor per dragon group."""
    stat_cnt = len(dragons.values())
    avg_damage = sum(dragon['damage'] for dragon in dragons.values()) / stat_cnt
    avg_health = sum(dragon['health'] for dragon in dragons.values()) / stat_cnt
    avg_armor = sum(dragon['armor'] for dragon in dragons.values()) / stat_cnt
    return avg_damage, avg_health, avg_armor


def format_output(dragons: dict) -> str:
    """Format output for each group and dragon."""
    result = ""
    for dr_type, all_dragons in dragons.items():
        avg_damage, avg_health, avg_armor = calc_avg_stats(all_dragons)
        result += f"{dr_type}::({avg_damage:.2f}/{avg_health:.2f}/{avg_armor:.2f})\n"
        for name, stats in all_dragons.items():
            result += (
                f"-{name} -> damage: {stats['damage']}, "
                f"health: {stats['health']}, "
                f"armor: {stats['armor']}\n"
            )
    return result


dragon_army = {}
num = int(input())

for n in range(num):
    dragon_type, dr_name, dr_damage, dr_health, dr_armor = [
        int(x) if x.isdigit()
        else x for x in input().split()
    ]

    if dragon_type not in dragon_army:
        dragon_army[dragon_type] = add_dragon(dr_name, dr_damage, dr_health, dr_armor)
    dragon_army[dragon_type].update(add_dragon(dr_name, dr_damage, dr_health, dr_armor))

output = format_output(sort_dragons(dragon_army))
print(output)
