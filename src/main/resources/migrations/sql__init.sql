CREATE TABLE books(
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    year INT NOT NULL
);

CREATE TABLE book_collection(
    id INT AUTO_INCREMENT PRIMARY KEY,
    book_id INT NOT NULL,
    FOREIGN KEY (book_id) REFERENCES book(id)
);

-- Inserção de livros
INSERT INTO books (title, author, year)
VALUES
  ('1984', 'George Orwell', 1949),
  ('To Kill a Mockingbird', 'Harper Lee', 1960),
  ('Pride and Prejudice', 'Jane Austen', 1813),
  ('The Great Gatsby', 'F. Scott Fitzgerald', 1925),
  ('The Catcher in the Rye', 'J.D. Salinger', 1951);

-- Inserção na coleção
INSERT INTO book_collection (book_id)
VALUES
  (1),
  (2),
  (3),
  (4),
  (5);
