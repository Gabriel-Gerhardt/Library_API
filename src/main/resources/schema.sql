CREATE TABLE books(
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    publish_year INT NOT NULL
);

CREATE TABLE library(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);
CREATE TABLE library_books(
    id INT AUTO_INCREMENT PRIMARY KEY,
    library_id INT NOT NULL,
    FOREIGN KEY (library_id) REFERENCES library(id),

    book_id INT NOT NULL,
    FOREIGN KEY (book_id) REFERENCES books(id)
);
