from project.equipment.base_equipment import BaseEquipment
from project.equipment.elbow_pad import ElbowPad
from project.equipment.knee_pad import KneePad
from project.teams.base_team import BaseTeam
from project.teams.indoor_team import IndoorTeam
from project.teams.outdoor_team import OutdoorTeam


class Tournament:
    VALID_EQUIPMENT = {
        "ElbowPad": ElbowPad,
        "KneePad": KneePad
    }

    VALID_TEAMS = {
        "IndoorTeam": IndoorTeam,
        "OutdoorTeam": OutdoorTeam,
    }

    def __init__(self, name: str, capacity: int):
        self.name = name
        self.capacity = capacity
        self.equipment: list = []
        self.teams: list = []

    @property
    def name(self):
        return self.__name
    
    @name.setter
    def name(self, value: str):
        if not value.isalnum():
            raise ValueError("Tournament name should contain letters and digits only!")
        self.__name = value

    def add_equipment(self, equipment_type: str):
        if equipment_type not in self.VALID_EQUIPMENT:
            raise Exception("Invalid equipment type!")

        equipment = self.VALID_EQUIPMENT[equipment_type]()
        self.equipment.append(equipment)

        return f"{equipment_type} was successfully added."

    def add_team(self, team_type: str, team_name: str, country: str, advantage: int):
        if team_type not in self.VALID_TEAMS:
            raise Exception("Invalid team type!")

        if len(self.teams) >= self.capacity:
            return "Not enough tournament capacity."

        team = self.VALID_TEAMS[team_type](team_name, country, advantage)
        self.teams.append(team)

        return f"{team_type} was successfully added."

    def sell_equipment(self, equipment_type: str, team_name: str):
        equipment: BaseEquipment = self.__get_equipment(equipment_type)
        team: BaseTeam = self.__get_team(team_name)

        if team.budget < equipment.price:
            raise Exception("Budget is not enough!")

        self.equipment.remove(equipment)
        team.equipment.append(equipment)
        team.budget -= equipment.price

        return f"Successfully sold {equipment_type} to {team_name}."

    def remove_team(self, team_name: str):
        team: BaseTeam = self.__get_team(team_name)

        if not team:
            raise Exception("No such team!")

        if team.wins > 0:
            raise Exception(f"The team has {team.wins} wins! Removal is impossible!")

        self.teams.remove(team)
        return f"Successfully removed {team_name}."

    def increase_equipment_price(self, equipment_type: str):
        cnt = 0
        for e in self.equipment:
            if type(e).__name__ == equipment_type:
                e.increase_price()
                cnt += 1

        return f"Successfully changed {cnt}pcs of equipment."

    def play(self, team_name1: str, team_name2: str):
        team1: BaseTeam = self.__get_team(team_name1)
        team2: BaseTeam = self.__get_team(team_name2)

        if type(team1).__name__ != type(team2).__name__:
            raise Exception("Game cannot start! Team types mismatch!")

        team1_result = team1.advantage + sum(p.protection for p in team1.equipment)
        team2_result = team2.advantage + sum(p.protection for p in team2.equipment)

        if team1_result > team2_result:
            team1.win()
            return f"The winner is {team1.name}."

        if team2_result > team1_result:
            team2.win()
            return f"The winner is {team2.name}."

        return "No winner in this game."

    def get_statistics(self):
        teams_sorted = sorted(self.teams, key=lambda t: -t.wins)

        stats = [
            f"Tournament: {self.name}",
            f"Number of Teams: {len(self.teams)}",
            "Teams:"
        ]
        if teams_sorted:
            stats.extend(t.get_statistics() for t in teams_sorted)

        return '\n'.join(stats)

    def __get_equipment(self, equipment_type: str):
        filtered = [e for e in self.equipment if type(e).__name__ == equipment_type]
        return filtered[-1] if filtered else None

    def __get_team(self, team_name: str):
        return next((t for t in self.teams if t.name == team_name), None)
