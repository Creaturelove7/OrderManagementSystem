DROP TABLE IF EXISTS orders;

CREATE TABLE orders (
    order_id SERIAL PRIMARY KEY,                 -- Unique identifier for each order
    total_amount DECIMAL(10, 2) NOT NULL        -- Total amount for the order
);

INSERT INTO orders (total_amount) VALUES
                                      (99.99),
                                      (45.50),
                                      (125.00),
                                      (2500.75),
                                      (10.00);