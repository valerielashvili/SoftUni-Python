def add_dwarf(hat_color: str, name: str, physics: int, dwarfs: dict) -> dict:
    """Add dwarfs and their physics under a hat of a certain color."""
    if hat_color not in dwarfs:
        dwarfs[hat_color] = {name: physics}
    else:
        if name in dwarfs[hat_color]:
            if dwarfs[hat_color][name] < physics:
                dwarfs[hat_color][name] = physics
        else:
            dwarfs[hat_color][name] = physics
    return dwarfs


def sort_dwarfs(dwarfs: dict) -> list:
    """
    Flatten dwarfs and sort them by:
    1. Physics (descending)
    2. Number of dwarfs with the same hat color (descending)
    """
    all_dwarfs = []
    for hat_color, dwarf_info in dwarfs.items():
        for name, physics in dwarf_info.items():
            all_dwarfs.append((name, hat_color, physics))

    all_dwarfs.sort(key=lambda x: (-x[2], -len(dwarfs[x[1]])))
    return all_dwarfs


def format_output(sorted_dwarfs: list) -> str:
    """Format output for each dwarf."""
    result = ""
    for name, hat_color, physics in sorted_dwarfs:
        result += f"({hat_color}) {name} <-> {physics}\n"
    return result.strip()


dwarf_data = {}

while (line := input()) != 'Once upon a time':
    dwarf_name, dwarf_hat_color, dwarf_physics = line.split(' <:> ')
    dwarf_data = add_dwarf(dwarf_hat_color, dwarf_name, int(dwarf_physics), dwarf_data)

output = format_output(sort_dwarfs(dwarf_data))
print(output)
