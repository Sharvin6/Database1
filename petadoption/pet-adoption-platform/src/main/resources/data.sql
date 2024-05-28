-- Create table for pet types
CREATE TABLE pet_type (
    id INT PRIMARY KEY, -- Primary key, unique identifier for each pet type
    type VARCHAR(255) NOT NULL -- Name of the pet type (e.g., Dog, Cat)
);

-- Create table for pet breeds
CREATE TABLE pet_breed (
    id INT PRIMARY KEY, -- Primary key, unique identifier for each pet breed
    name VARCHAR(255) NOT NULL, -- Name of the pet breed (e.g., German Shepherd, Persian)
    pet_type_id INT, -- Foreign key, references pet_type(id)
    FOREIGN KEY (pet_type_id) REFERENCES pet_type(id)
);

-- Create table for pets
CREATE TABLE pet (
    id INT PRIMARY KEY, -- Primary key, unique identifier for each pet
    name VARCHAR(255) NOT NULL, -- Name of the pet
    age INT, -- Age of the pet
    gender VARCHAR(10), -- Gender of the pet
    color VARCHAR(255), -- Color of the pet
    description VARCHAR(255), -- Description of the pet
    pet_type_id INT, -- Foreign key, references pet_type(id)
    pet_breed_id INT, -- Foreign key, references pet_breed(id)
    FOREIGN KEY (pet_type_id) REFERENCES pet_type(id),
    FOREIGN KEY (pet_breed_id) REFERENCES pet_breed(id)
);

-- Inserting sample pet types
INSERT INTO pet_type (id, type) VALUES
(1, 'Dog'), -- id=1 for Dogs
(2, 'Cat'); -- id=2 for Cats

-- Inserting sample pet breeds
INSERT INTO pet_breed (id, name, pet_type_id) VALUES
(1, 'German Shepherd', 1), -- id=1 for German Shepherd, which is a Dog (pet_type_id=1)
(2, 'Rottweiler', 1), -- id=2 for Rottweiler, which is a Dog (pet_type_id=1)
(3, 'Shih Tzu', 1), -- id=3 for Shih Tzu, which is a Dog (pet_type_id=1)
(4, 'Persian', 2), -- id=4 for Persian, which is a Cat (pet_type_id=2)
(5, 'Siamese', 2), -- id=5 for Siamese, which is a Cat (pet_type_id=2)
(6, 'Maine Coon', 2); -- id=6 for Maine Coon, which is a Cat (pet_type_id=2)

-- Inserting sample pets (Dogs)
INSERT INTO pet (id, name, age, gender, color, description, pet_type_id, pet_breed_id) VALUES
(1, 'Max', 3, 'Male', 'Black and Tan', 'Friendly and protective', 1, 1), -- German Shepherd (breed_id=1, type_id=1)
(2, 'Bella', 2, 'Female', 'Sable', 'Loyal and smart', 1, 1), -- German Shepherd (breed_id=1, type_id=1)
(3, 'Rex', 4, 'Male', 'Black', 'Strong and brave', 1, 1), -- German Shepherd (breed_id=1, type_id=1)
(4, 'Lucy', 5, 'Female', 'Black and Mahogany', 'Gentle and calm', 1, 2), -- Rottweiler (breed_id=2, type_id=1)
(5, 'Rocky', 3, 'Male', 'Black and Tan', 'Energetic and fearless', 1, 2), -- Rottweiler (breed_id=2, type_id=1)
(6, 'Zoe', 4, 'Female', 'Black and Rust', 'Loving and playful', 1, 2), -- Rottweiler (breed_id=2, type_id=1)
(7, 'Daisy', 2, 'Female', 'White and Gold', 'Cheerful and affectionate', 1, 3), -- Shih Tzu (breed_id=3, type_id=1)
(8, 'Buddy', 3, 'Male', 'Black and White', 'Friendly and playful', 1, 3), -- Shih Tzu (breed_id=3, type_id=1)
(9, 'Lola', 1, 'Female', 'Brown and White', 'Sweet and calm', 1, 3); -- Shih Tzu (breed_id=3, type_id=1)

-- Inserting sample pets (Cats)
INSERT INTO pet (id, name, age, gender, color, description, pet_type_id, pet_breed_id) VALUES
(10, 'Whiskers', 4, 'Female', 'White', 'Gentle and affectionate', 2, 4), -- Persian (breed_id=4, type_id=2)
(11, 'Shadow', 3, 'Male', 'Blue', 'Quiet and calm', 2, 4), -- Persian (breed_id=4, type_id=2)
(12, 'Mittens', 2, 'Female', 'Cream', 'Playful and curious', 2, 4), -- Persian (breed_id=4, type_id=2)
(13, 'Simba', 3, 'Male', 'Seal Point', 'Loyal and loving', 2, 5), -- Siamese (breed_id=5, type_id=2)
(14, 'Nala', 2, 'Female', 'Blue Point', 'Graceful and elegant', 2, 5), -- Siamese (breed_id=5, type_id=2)
(15, 'Leo', 4, 'Male', 'Chocolate Point', 'Smart and curious', 2, 5), -- Siamese (breed_id=5, type_id=2)
(16, 'Cleo', 3, 'Female', 'Brown Tabby', 'Playful and sociable', 2, 6), -- Maine Coon (breed_id=6, type_id=2)
(17, 'Oscar', 4, 'Male', 'Blue Tabby', 'Calm and friendly', 2, 6), -- Maine Coon (breed_id=6, type_id=2)
(18, 'Luna', 2, 'Female', 'Red Tabby', 'Curious and adventurous', 2, 6); -- Maine Coon (breed_id=6, type_id=2)
