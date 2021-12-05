from locust import HttpUser, task


class HelloWorldUser(HttpUser):
    @task
    def get_all_vehicles(self):
        self.client.get("/api/vehicleconfigurations")
