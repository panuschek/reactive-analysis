from locust import HttpUser, task, events
import random

@events.test_start.add_listener
def on_test_start(environment, **kwargs):
    random.seed(1337)

class VehicleConfigurationUser(HttpUser):
    @task
    def get_all_vehicles(self):
        country_id = random.randint(1, 100)
        self.client.post("/api/vehicleconfigurations", json={ "countryId": country_id})
