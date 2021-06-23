package am.itspace.springdemo.controller;

import am.itspace.springdemo.model.Book;
import am.itspace.springdemo.service.BookService;
import am.itspace.springdemo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequiredArgsConstructor
public class BookController {


    private final BookService bookService;
    private final UserService userService;

    @PostMapping("/saveBook")
    public String add(@ModelAttribute Book book) {
        String msg = book.getId() > 0 ? "Book was updated" : "Book was added";
        bookService.save(book);
        return "redirect:/?msg=" + msg;
    }

    @GetMapping("/editBook")
    public String edit(@RequestParam("id") int id, Model model) {

        model.addAttribute("users", userService.findAll());
        model.addAttribute("book", bookService.getOne(id));
        return "editBook";
    }

    @GetMapping("/deleteBook")
    public String edit(@RequestParam("id") int id) {
        bookService.deleteById(id);
        return "redirect:/";
    }
}
