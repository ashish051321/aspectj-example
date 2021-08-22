DROP TABLE IF EXISTS trans_details;

CREATE TABLE trans_details (
   id  INT auto_increment NOT NULL,
   customer_id VARCHAR(50) NOT NULL,
   transaction_type VARCHAR(50) NOT NULL,
   transaction_ref_no  INT auto_increment NOT NULL,
   session_date DATETIME,
   session_duration INT
);