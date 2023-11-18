DROP DATABASE IF EXISTS library_management;

CREATE DATABASE library_management;

\c library_management

CREATE TABLE books (
    id SERIAL PRIMARY KEY,
    book_name VARCHAR(255) NOT NULL,
    page_numbers INTEGER,
    topic VARCHAR(255) CHECK (topic IN ('ROMANCE', 'COMEDY', 'OTHER')),
    release_date DATE,
    is_available BOOLEAN DEFAULT TRUE,
    author VARCHAR(255) NOT NULL
);

CREATE TABLE visitors (
    id SERIAL PRIMARY KEY,
    visitor_name VARCHAR(255) NOT NULL,
    reference VARCHAR(255) UNIQUE NOT NULL CHECK (reference IN ('vst12345'))
);

CREATE TABLE loan_history (
    loan_id SERIAL PRIMARY KEY,
    book_id INTEGER REFERENCES books(id),
    visitor_id INTEGER REFERENCES visitors(id),
    visitor_name VARCHAR(255),
    visitor_reference VARCHAR(255) UNIQUE NOT NULL CHECK (visitor_reference IN('vst12345'))
    borrowed_date DATE,
    returned_date DATE,
    is_available BOOLEAN,
    CONSTRAINT check_borrowed_status CHECK (
        (is_available = TRUE AND returned_date IS NOT NULL AND borrowed_date IS NULL)
        OR (is_available = FALSE AND returned_date IS NULL AND borrowed_date IS NOT NULL)
    )
);