package BookManagement.example.BookManagement.repo;

import BookManagement.example.BookManagement.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//Create a repository for the Book class, where the ID type is Long, and give me all the useful database methods.
public interface BookRepo extends JpaRepository<Book,Long> {

}
