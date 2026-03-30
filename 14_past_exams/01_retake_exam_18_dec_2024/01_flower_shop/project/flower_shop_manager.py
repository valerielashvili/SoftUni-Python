from itertools import groupby

from project.plants.base_plant import BasePlant
from project.plants.flower import Flower
from project.plants.leaf_plant import LeafPlant
from project.clients.base_client import BaseClient
from project.clients.business_client import BusinessClient
from project.clients.regular_client import RegularClient


class FlowerShopManager:
    VALID_PLANTS = {
        "Flower": Flower,
        "LeafPlant": LeafPlant
    }
    VALID_CLIENTS = {
        "BusinessClient": BusinessClient,
        "RegularClient": RegularClient
    }
    ORDERS_TOTAL = 0

    def __init__(self):
        self.income: float = 0.0
        self.plants: list = []
        self.clients: list = []

    def add_plant(
            self,
            plant_type: str,
            plant_name: str,
            plant_price: float,
            plant_water_needed: int,
            plant_extra_data: str
    ):
        if plant_type not in self.VALID_PLANTS:
            raise ValueError("Unknown plant type!")

        plant = self.VALID_PLANTS[plant_type](plant_name, plant_price, plant_water_needed, plant_extra_data)
        self.plants.append(plant)
        return f"{plant_name} is added to the shop as {plant_type}."

    def find_client(self, client_phone_number):
        return next((c for c in self.clients if c.phone_number == client_phone_number), None)

    def add_client(self, client_type: str, client_name: str, client_phone_number: str):
        if client_type not in self.VALID_CLIENTS:
            raise ValueError("Unknown client type!")

        client = self.find_client(client_phone_number)
        if client:
            raise ValueError("This phone number has been used!")

        client = self.VALID_CLIENTS[client_type](client_name, client_phone_number)
        self.clients.append(client)
        return f"{client_name} is successfully added as a {client_type}."

    def sell_plants(self, client_phone_number: str, plant_name: str, plant_quantity: int):
        client: BaseClient = self.find_client(client_phone_number)
        if not client:
            raise ValueError("Client not found!")

        plants = list(filter(lambda p: p.name == plant_name, self.plants))
        if not plants:
            raise ValueError("Plants not found!")

        if len(plants) < plant_quantity:
            return "Not enough plant quantity."

        order_amount = 0
        for plant in plants:
            final_price = plant.price - plant.price * client.discount
            self.income += final_price
            order_amount += final_price
            client.update_total_orders()
            client.update_discount()
            self.plants.remove(plant)

        self.ORDERS_TOTAL += order_amount
        return f"{plant_quantity}pcs. of {plant_name} plant sold for {order_amount:.2f}"

    def remove_plant(self, plant_name: str):
        plant: BasePlant = next((p for p in self.plants if p.name == plant_name), None)
        if not plant:
            return "No such plant name."

        self.plants.remove(plant)
        return f"Removed {plant.plant_details()}"

    def remove_clients(self):
        num_clients_total = len(self.clients)
        self.clients = list(filter(lambda c: c.total_orders > 0, self.clients))
        num_clients_removed = num_clients_total - len(self.clients)

        return f"{num_clients_removed} client/s removed."

    def shop_report(self):
        plants_sorted = sorted(self.plants, key=lambda p: p.name)
        groups = {k: sum(1 for _ in v) for k, v in groupby(plants_sorted, key=lambda p: p.name)}
        flower_groups = dict(sorted(groups.items(), key=lambda p: (-p[1], p[0])))

        clients_sorted = sorted(self.clients, key=lambda c: (-c.total_orders, c.phone_number))

        report = [
            "~Flower Shop Report~",
            f"Income: {self.income:.2f}",
            f"Count of orders: {self.ORDERS_TOTAL}",
            f"~~Unsold plants: {len(plants_sorted)}~~",
            '\n'.join(f"{name}: {cnt}" for name, cnt in flower_groups.items()),
            f"~~Clients number: {len(clients_sorted)}~~",
            '\n'.join(c.client_details() for c in clients_sorted)
        ]

        return '\n'.join(report)
