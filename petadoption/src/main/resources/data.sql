-- Create the staff table
CREATE TABLE IF NOT EXISTS staff (
    staff_id VARCHAR(50) PRIMARY KEY,
    staff_name VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL
);

-- Insert initial data into the staff table
INSERT INTO staff (staff_id, staff_name, password) VALUES
('S001', 'Thibaan Raj', 'pass1234'),
('S002', 'Sharvin Khan', 'secure5678'),
('S003', 'KavinRaj', 'mypassword'),
('S004', 'Kamal Hassan', 'pwd4567'),
('S005', 'Rajini', 'pass7890');
