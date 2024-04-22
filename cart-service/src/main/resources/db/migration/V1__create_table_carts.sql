CREATE TABLE IF NOT EXISTS carts
(
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    amount INT
);

CREATE TABLE IF NOT EXISTS products
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(64) NOT NULL,
    cart_id INT REFERENCES carts (user_id),
    price INT NOT NULL
);