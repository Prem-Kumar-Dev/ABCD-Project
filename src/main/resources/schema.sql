-- Database: OnlineBankingDB
-- Script to create the schema for the Online Banking Management System

CREATE DATABASE IF NOT EXISTS OnlineBankingDB;

-- Use the database
USE OnlineBankingDB;

-- Create the User table
CREATE TABLE IF NOT EXISTS User (
    user_id INT AUTO_INCREMENT PRIMARY KEY,          -- Unique ID for each user
    name VARCHAR(100) NOT NULL,                      -- User's full name
    email VARCHAR(150) NOT NULL UNIQUE,              -- Email address (must be unique)
    password VARCHAR(255) NOT NULL,                  -- Encrypted password for security
    phone_number VARCHAR(15) UNIQUE,                 -- Optional phone number, must be unique
    account_balance DECIMAL(12, 2) DEFAULT 0.00,     -- Account balance with default value
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- When the user was created
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, -- Last update timestamp
    status ENUM('ACTIVE', 'INACTIVE') DEFAULT 'ACTIVE' -- Account status
);

-- Index for faster lookups on frequently searched fields in User table
CREATE INDEX idx_user_email ON User (email);
CREATE INDEX idx_user_phone_number ON User (phone_number);

-- Create the Admin table
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


CREATE INDEX idx_admin_email ON Admin (email);
CREATE INDEX idx_admin_phone_number ON Admin (phone_number);

