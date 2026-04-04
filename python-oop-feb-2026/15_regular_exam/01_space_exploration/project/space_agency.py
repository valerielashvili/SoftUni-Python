from project.astronauts.base_astronaut import BaseAstronaut
from project.astronauts.engineer_astronaut import EngineerAstronaut
from project.astronauts.scientist_astronaut import ScientistAstronaut
from project.stations.base_station import BaseStation
from project.stations.maintenance_station import MaintenanceStation
from project.stations.research_station import ResearchStation


class SpaceAgency:
    VALID_ASTRONAUTS = {
        "EngineerAstronaut": EngineerAstronaut,
        "ScientistAstronaut": ScientistAstronaut
    }

    VALID_STATIONS = {
        "MaintenanceStation": MaintenanceStation,
        "ResearchStation": ResearchStation
    }

    def __init__(self):
        self.astronauts: list = []
        self.stations: list = []

    def add_astronaut(self, astronaut_type: str, astronaut_id_number: str, astronaut_salary: float):
        if astronaut_type not in self.VALID_ASTRONAUTS:
            raise ValueError("Invalid astronaut type!")

        astronaut = self.__get_astronaut(self.astronauts, astronaut_id_number)

        if astronaut:
            raise ValueError(f"{astronaut_id_number} has been already added!")

        astronaut = self.VALID_ASTRONAUTS[astronaut_type](astronaut_id_number, astronaut_salary)
        self.astronauts.append(astronaut)

        return f"{astronaut_id_number} is successfully hired as {astronaut_type}."

    def add_station(self, station_type: str, station_name: str):
        if station_type not in self.VALID_STATIONS:
            raise ValueError("Invalid station type!")

        station = self.__get_station(station_name)
        if station:
            raise ValueError(f"{station_name} has been already added!")

        station = self.VALID_STATIONS[station_type](station_name)
        self.stations.append(station)

        return f"{station_name} is successfully added as a {station_type}."

    def assign_astronaut(self, station_name: str, astronaut_type: str):
        station: BaseStation = self.__get_station(station_name)

        if not station:
            raise ValueError(f"Station {station_name} does not exist!")

        astronaut: BaseAstronaut = self.__get_astronaut_by_type(astronaut_type)

        if not astronaut:
            raise ValueError("No available astronauts of the type!")

        if station and astronaut:
            if station.capacity <= 0:
                return "This station has no available capacity."

            self.astronauts.remove(astronaut)
            station.astronauts.append(astronaut)
            station.capacity -= 1

            return f"{astronaut.id_number} was assigned to {station_name}."

    @staticmethod
    def train_astronauts(station: BaseStation, sessions_number: int):
        for a in station.astronauts:
            for i in range(0, sessions_number):
                a.train()

        total_stamina = sum(a.stamina for a in station.astronauts)

        return f"{station.name} astronauts have {total_stamina} total stamina after {sessions_number} training session/s."

    def retire_astronaut(self, station: BaseStation, astronaut_id_number: str):
        astronaut: BaseAstronaut = self.__get_astronaut(station.astronauts, astronaut_id_number)

        cancellation_message = "The retirement process was canceled."
        retirement_message = f"Retired astronaut {astronaut_id_number}."

        if not astronaut:
            return cancellation_message

        if astronaut.stamina == 100:
            return cancellation_message

        elif astronaut.stamina < 100:
            station.astronauts.remove(astronaut)
            station.capacity += 1
            return retirement_message

    def agency_update(self, min_value: float):
        for s in self.stations:
            s.update_salaries(min_value)

        stations_sorted = sorted(self.stations, key=lambda s: (-len(s.astronauts), s.name))
        available_astronauts_count = len(self.astronauts)
        stations_total_count = len(stations_sorted)
        total_available_capacity = sum(s.capacity for s in stations_sorted)

        stats = [
            "*Space Agency Up-to-Date Report*",
            f"Total number of available astronauts: {available_astronauts_count}",
            f"**Stations count: {stations_total_count}; Total available capacity: {total_available_capacity}**"
        ]
        stats.extend(s.status() for s in stations_sorted)

        return '\n'.join(stats)

    @staticmethod
    def __get_astronaut(astronauts, astronaut_id_number):
        return next((a for a in astronauts if a.id_number == astronaut_id_number), None)

    def __get_station(self, station_name):
        return next((s for s in self.stations if s.name == station_name), None)

    def __get_astronaut_by_type(self, astronaut_type):
        # Return first found astronaut by type (insertion order)
        for a in self.astronauts:
            if a.specialization == astronaut_type:
                return a

        return None