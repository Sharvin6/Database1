-- Create table for pet types
CREATE TABLE IF NOT EXISTS pet_type (
    id INT PRIMARY KEY,
    type VARCHAR(255) NOT NULL
);

-- Create table for pet breeds
CREATE TABLE IF NOT EXISTS pet_breed (
    id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    pet_type_id INT,
    FOREIGN KEY (pet_type_id) REFERENCES pet_type(id)
);

-- Create table for pets
CREATE TABLE IF NOT EXISTS pet (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    age INT,
    gender VARCHAR(10),
    color VARCHAR(255),
    description VARCHAR(255),
    pet_type_id INT,
    pet_breed_id INT,
    fee DOUBLE,
    FOREIGN KEY (pet_type_id) REFERENCES pet_type(id),
    FOREIGN KEY (pet_breed_id) REFERENCES pet_breed(id)
);

-- Create table for customers
CREATE TABLE IF NOT EXISTS customer (
    id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    address VARCHAR(255) NOT NULL
);

-- Create table for adopted pets
CREATE TABLE IF NOT EXISTS adopted_pet (
    id INT PRIMARY KEY,
    customer_id INT,
    customer_name VARCHAR(255),
    pet_id INT,
    pet_type VARCHAR(255),
    pet_breed VARCHAR(255),
    pet_name VARCHAR(255),
    adoption_date DATE,
    fee DOUBLE,
    FOREIGN KEY (customer_id) REFERENCES customer(id),
    FOREIGN KEY (pet_id) REFERENCES pet(id) ON DELETE CASCADE
);


-- Create table for staff
CREATE TABLE IF NOT EXISTS staff (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(100) NOT NULL,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    phone VARCHAR(20)
);

-- Inserting sample pet types
INSERT INTO pet_type (id, type) VALUES
(1, 'Dog'),
(2, 'Cat');

-- Inserting sample pet breeds
INSERT INTO pet_breed (id, name, pet_type_id) VALUES
(1, 'German Shepherd', 1),
(2, 'Rottweiler', 1),
(3, 'Shih Tzu', 1),
(4, 'Persian', 2),
(5, 'Siamese', 2),
(6, 'Maine Coon', 2);

-- Inserting sample pets (Dogs)
INSERT INTO pet (name, age, gender, color, description, pet_type_id, pet_breed_id, fee) VALUES
('Max', 3, 'Male', 'Black and Tan', 'Friendly and protective', 1, 1, 300),
('Bella', 2, 'Female', 'Sable', 'Loyal and smart', 1, 1, 350),
('Rex', 4, 'Male', 'Black', 'Strong and brave', 1, 1, 320),
('Lucy', 5, 'Female', 'Black and Mahogany', 'Gentle and calm', 1, 2, 400),
('Rocky', 3, 'Male', 'Black and Tan', 'Energetic and fearless', 1, 2, 380),
('Zoe', 4, 'Female', 'Black and Rust', 'Loving and playful', 1, 2, 370),
('Daisy', 2, 'Female', 'White and Gold', 'Cheerful and affectionate', 1, 3, 250),
('Buddy', 3, 'Male', 'Black and White', 'Friendly and playful', 1, 3, 260),
('Lola', 1, 'Female', 'Brown and White', 'Sweet and calm', 1, 3, 240);

-- Inserting sample pets (Cats)
INSERT INTO pet (name, age, gender, color, description, pet_type_id, pet_breed_id, fee) VALUES
('Whiskers', 4, 'Female', 'White', 'Gentle and affectionate', 2, 4, 500),
('Shadow', 3, 'Male', 'Blue', 'Quiet and calm', 2, 4, 520),
('Mittens', 2, 'Female', 'Cream', 'Playful and curious', 2, 4, 510),
('Simba', 3, 'Male', 'Seal Point', 'Loyal and loving', 2, 5, 600),
('Nala', 2, 'Female', 'Blue Point', 'Graceful and elegant', 2, 5, 620),
('Leo', 4, 'Male', 'Chocolate Point', 'Smart and curious', 2, 5, 610),
('Cleo', 3, 'Female', 'Brown Tabby', 'Playful and sociable', 2, 6, 700),
('Oscar', 4, 'Male', 'Blue Tabby', 'Calm and friendly', 2, 6, 720),
('Luna', 2, 'Female', 'Red Tabby', 'Curious and adventurous', 2, 6, 710);


-- Insert sample customer details
INSERT INTO customer (id, name, email, phone, address) VALUES
(1, 'John Doe', 'john@example.com', '1234567890', '123 Main St, City, Country'),
(2, 'Jane Smith', 'jane@example.com', '0987654321', '456 Elm St, Town, Country');

-- Insert sample adopted pet details
INSERT INTO adopted_pet (id, customer_id, customer_name, pet_id, pet_type, pet_breed, pet_name, adoption_date, fee) VALUES
(1, 1, 'John Doe', 1, 'Dog', 'German Shepherd', 'Max', '2024-05-30', 300),
(2, 2, 'Jane Smith', 4, 'Cat', 'Maine Coon', 'Lucy', '2024-06-01', 400);

-- Insert sample staff details
INSERT INTO staff (username, password, name, email, phone) VALUES
('john_doe', 'password123', 'John Doe', 'john@example.com', '123-456-7890'),
('jane_smith', 'password456', 'Jane Smith', 'jane@example.com', '987-654-3210'),
('sam_wilson', 'password789', 'Sam Wilson', 'sam@example.com', '555-666-7777');

