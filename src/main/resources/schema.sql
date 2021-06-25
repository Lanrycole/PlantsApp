
CREATE SCHEMA `plant` ; -- Create the plant database

# CREATE USER 'roots'@'localhost' IDENTIFIED BY 'root'; -- Create the user if you haven’t yet
GRANT ALL ON plant.* TO 'roots'@'localhost'; -- Gives all privileges to the new user on plant