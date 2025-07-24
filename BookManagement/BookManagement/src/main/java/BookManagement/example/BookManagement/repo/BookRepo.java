package BookManagement.example.BookManagement.repo;

import BookManagement.example.BookManagement.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepository<Book,Long> {
    Book id(Long id);
}
