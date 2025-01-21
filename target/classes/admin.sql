CREATE TABLE IF NOT EXISTS Admin (
    admin_id INT AUTO_INCREMENT PRIMARY KEY,         
    name VARCHAR(100) NOT NULL,                      
    email VARCHAR(150) NOT NULL UNIQUE,              
    password VARCHAR(255) NOT NULL,                   
    phone_number VARCHAR(15) UNIQUE,                  
    role ENUM('SUPER_ADMIN', 'MANAGER', 'CLERK') DEFAULT 'MANAGER', 
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,   
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, 
    status ENUM('ACTIVE', 'INACTIVE') DEFAULT 'ACTIVE' 
);

-- Index for faster lookups on email
CREATE INDEX idx_admin_email ON Admin (email);
CREATE INDEX idx_admin_phone_number ON Admin (phone_number);

