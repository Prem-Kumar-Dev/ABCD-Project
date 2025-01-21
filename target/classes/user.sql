CREATE TABLE IF NOT EXISTS User (
    user_id INT AUTO_INCREMENT PRIMARY KEY,          
    name VARCHAR(100) NOT NULL,                      
    email VARCHAR(150) NOT NULL UNIQUE,             
    password VARCHAR(255) NOT NULL,                  
    phone_number VARCHAR(15) UNIQUE,                 
    account_balance DECIMAL(12, 2) DEFAULT 0.00,     
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, 
    status ENUM('ACTIVE', 'INACTIVE') DEFAULT 'ACTIVE' 
);

-- Index for faster lookups on frequently searched fields
CREATE INDEX idx_user_email ON User (email);
CREATE INDEX idx_user_phone_number ON User (phone_number);

