# Getting Started
* All services were developed with Java 17. Therefore, when you run projects, it is recommended to do this with Java 17.
* To run the projects, PostgreSQL must be installed on your computer.
* After installing PostgreSQL, create databases named "glaceon_inventory", "glaceon_gateway" and "glaceon_user" respectively.
* Do not forget to change your PostgreSQL connection information in the application.yml file located under the "resources" folder in the projects.
* Please make sure that ports 8080, 8081 and 8082 are not used on the computer you want to run it on.
* After the projects run, flyway will automatically create a user with username "testuser" and password "123456".
* You can log in to the system with this user.
* If you are going to work in debug mode, enable the "enabled annotation processing" feature to use Lombok.

# Auxiliary tools
* I will leave the request collection in the insomnia folder so that you can easily test the endpoints.
* You can install insomnia on your computer and easily import the relevant file.
* Log records of the operations performed within the system are recorded both in the console and in the logging folder in the project directories.

I named the project Glaceon. Usually, when I can't find a creative name, I choose project names from random Pokemon names.
