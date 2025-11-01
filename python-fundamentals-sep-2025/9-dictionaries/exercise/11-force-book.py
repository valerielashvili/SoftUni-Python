from typing import Tuple


def user_exists(user: str, sides: dict) -> bool:
    """Check if a user already exists on any side."""
    return any(user in users for users in sides.values())


def add_user(user: str, side: str, sides: dict) -> dict:
    """Add a user to a side if not already present."""
    if not user_exists(user, sides):
        sides.setdefault(side, []).append(user)
    return sides


def switch_side(user: str, new_side: str, sides: dict) -> Tuple[dict, str]:
    """Move a user from their current side to a new one."""
    # Remove from current side if found
    for side, users in sides.items():
        if user in users:
            users.remove(user)
            break

    # Add to the new side
    sides.setdefault(new_side, []).append(user)
    return sides, f"{user} joins the {new_side} side!"


force_sides = {}

while (input_ln := input()) != "Lumpawaroo":
    if " | " in input_ln:
        curr_side, curr_user = input_ln.split(" | ")
        force_sides = add_user(curr_user, curr_side, force_sides)

    elif " -> " in input_ln:
        curr_user, curr_side = input_ln.split(" -> ")
        force_sides, message = switch_side(curr_user, curr_side, force_sides)
        print(message)

for prnt_side, prnt_users in force_sides.items():
    if prnt_users:
        print(f"Side: {prnt_side}, Members: {len(prnt_users)}")
        for prnt_user in prnt_users:
            print(f"! {prnt_user}")
