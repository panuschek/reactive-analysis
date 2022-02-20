from locust import HttpUser, task, events
import random

@events.test_start.add_listener
def on_test_start(environment, **kwargs):
    random.seed(1337)

class VehicleConfigurationUser(HttpUser):
    @task
    def sleep(self):
        self.client.get("/api/sleep")

    @task(0)
    def api_call(self):
        self.client.get("/api/apiCall")

    @task(0)
    def query_database(self):
        country_id = random.randint(1, 100)
        self.client.post("/api/vehicleconfigurations", json={ "countryId": country_id})

    @task(0)
    def chained_calls(self):
        country_id = random.randint(1, 100)
        self.client.post("/api/vehicleconfigurations", json={ "countryId": country_id})
