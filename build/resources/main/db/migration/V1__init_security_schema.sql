CREATE TABLE users (
    id VARCHAR(36) PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(20) DEFAULT 'USER',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Usuario de prueba (password: password123 - asumiendo hash previo)
INSERT INTO users (id, username, email, password, role) 
VALUES ('user-uuid-001', 'admin', 'admin@saberplay.com', '$2a$10$8.UnVuG9shgE39t9W5xW9uV9uV9uV9uV9uV9uV9uV9uV9uV9uV9u', 'ADMIN');
