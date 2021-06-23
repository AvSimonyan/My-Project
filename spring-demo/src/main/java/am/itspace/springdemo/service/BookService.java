package am.itspace.springdemo.service;

import am.itspace.springdemo.model.Book;
import am.itspace.springdemo.repository.BookRepository;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class BookService {
private final BookRepository bookRepository;

public void save(Book book){
    bookRepository.save(book);

}
public  Book getOne(int id){
    return bookRepository.getOne(id);
}
public void deleteById(int id){
    bookRepository.deleteById(id);
}
}
