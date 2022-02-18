from locust import HttpUser, task, events
import random

@events.test_start.add_listener
def on_test_start(environment, **kwargs):
    random.seed(1337)

class VehicleConfigurationUser(HttpUser):

    @task
    def get_vehicles(self):
        jwt = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJQQU5VU0NIIiwiZ3JvdXBzIjpbMSwyLDMsNCw1LDYsNyw4LDksMjAsMjEsMjIsMjMsMjQsMjUsMjYsMjcsMjgsMjksNDAsNDEsNDIsNDMsNDQsNDUsNDYsNDcsNDgsNDksNTAsNTEsNTIsNTMsNTQsNTUsNTYsNTcsNTgsNTksNzAsNzEsNzIsNzMsNzQsNzUsNzYsNzcsNzgsNzksOTAsOTEsOTIsOTMsOTQsOTUsOTYsOTcsOTgsOTldfQ.MUZb4JnNPhxS3Cvd2d_V76hQ3cODdEhK8E6fFGu2X1k"

        country_id = random.randint(1, 100)
        self.client.post("/api/vehicleconfigurations", json={ "countryId": country_id}, headers={ "Authorization": "Bearer " + jwt })
