-- Create the sequence_generator table
CREATE TABLE sequence_generator (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    current_value BIGINT NOT NULL
);

-- Insert the initial sequence value
INSERT INTO sequence_generator (name, current_value) VALUES ('order_sequence', 0);
