from project.battleships.base_battleship import BaseBattleship
from project.battleships.pirate_battleship import PirateBattleship
from project.battleships.royal_battleship import RoyalBattleship
from project.zones.base_zone import BaseZone
from project.zones.pirate_zone import PirateZone
from project.zones.royal_zone import RoyalZone


class BattleManager:
    VALID_ZONES = {
        "RoyalZone": RoyalZone,
        "PirateZone": PirateZone
    }

    VALID_SHIPS = {
        "PirateBattleship": PirateBattleship,
        "RoyalBattleship": RoyalBattleship
    }

    def __init__(self):
        self.zones: list = []
        self.ships: list = []

    def add_zone(self, zone_type: str, zone_code: str):
        if zone_type not in self.VALID_ZONES:
            raise Exception("Invalid zone type!")

        if any(z.code == zone_code for z in self.zones):
            raise Exception("Zone already exists!")

        zone = self.VALID_ZONES[zone_type](zone_code)
        self.zones.append(zone)

        return f"A zone of type {zone_type} was successfully added."

    def add_battleship(self, ship_type: str, name: str, health: int, hit_strength: int):
        if ship_type not in self.VALID_SHIPS:
            raise Exception(f"{ship_type} is an invalid type of ship!")

        ship = self.VALID_SHIPS[ship_type](name, health, hit_strength)
        self.ships.append(ship)

        return f"A new {ship_type} was successfully added."

    @staticmethod
    def add_ship_to_zone(zone: BaseZone, ship: BaseBattleship):
        if zone.volume <= 0:
            return f"Zone {zone.code} does not allow more participants!"

        if ship.health <= 0:
            return f"Ship {ship.name} is considered sunk! Participation not allowed!"

        if not ship.is_available:
            return f"Ship {ship.name} is not available and could not participate!"

        ship_type = ship.__class__.__name__
        zone_type = zone.__class__.__name__

        if (("Pirate" in ship_type and "Pirate" in zone_type) or
                ("Royal" in ship_type and "Royal" in zone_type)):
            ship.is_attacking = True
        else:
            ship.is_attacking = False

        ship.is_available = False
        zone.volume -= 1
        zone.ships.append(ship)

        return f"Ship {ship.name} successfully participated in zone {zone.code}."

    def remove_battleship(self, ship_name: str):
        ship: BaseBattleship = next((s for s in self.ships if s.name == ship_name), None)
        if not ship:
            return "No ship with this name!"

        if not ship.is_available:
            return "The ship participates in zone battles! Removal is impossible!"

        self.ships.remove(ship)

        return f"Successfully removed ship {ship_name}."

    def start_battle(self, zone: BaseZone):
        if not (any(s for s in zone.ships if s.is_attacking) and
                any(s for s in zone.ships if not s.is_attacking)):
            return "Not enough participants. The battle is canceled."

        attacking_ship: BaseBattleship = max(
            (s for s in zone.ships if s.is_attacking),
            key=lambda s: s.hit_strength
        )
        under_attack_ship: BaseBattleship = max(
            (s for s in zone.ships if not s.is_attacking),
            key=lambda s: s.health
        )

        attacking_ship.attack()
        under_attack_ship.take_damage(attacking_ship)

        if under_attack_ship.health == 0:
            zone.ships.remove(under_attack_ship)
            self.ships.remove(under_attack_ship)
            return f"{under_attack_ship.name} lost the battle and was sunk."

        if attacking_ship.ammunition == 0:
            zone.ships.remove(attacking_ship)
            self.ships.remove(attacking_ship)
            return f"{attacking_ship.name} ran out of ammunition and leaves."

        return "Both ships survived the battle."

    def get_statistics(self):
        available_ships = list(filter(lambda s: s.is_available, self.ships))
        output = [f"Available Battleships: {len(available_ships)}"]

        if available_ships:
            available_ship_names = ", ".join(s.name for s in available_ships)
            output.append(f"#{available_ship_names}#")

        output += ["***Zones Statistics:***", f"Total Zones: {len(self.zones)}"]

        if self.zones:
            zones_sorted = sorted(self.zones, key=lambda z: z.code)
            zone_info = "\n".join(z.zone_info() for z in zones_sorted)
            output.append(zone_info)

        return "\n".join(output)
