CREATE TABLE IF NOT EXISTS Orders
(
    id BIGINT           NOT NULL PRIMARY KEY,
    client_id BIGINT    NOT NULL,
    name VARCHAR(30)    NOT NULL
);