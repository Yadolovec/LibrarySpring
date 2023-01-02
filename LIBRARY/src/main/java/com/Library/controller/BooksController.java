package com.Library.controller;

import com.Library.dao.BookDAO;
import com.Library.dao.PersonDAO;
import com.Library.models.Book;
import com.Library.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/lib/books")
public class BooksController {

    private final BookDAO bookDAO;
    private final PersonDAO personDAO;
    @Autowired
    public BooksController(BookDAO bookDAO, PersonDAO personDAO) {

        this.bookDAO = bookDAO;
        this.personDAO = personDAO;
    }


    @GetMapping()
    public String allBooks(Model model){
        model.addAttribute("books", bookDAO.index());
        return "library/books/index";
    }

    @GetMapping("/new")
    public String addBook(Model model){
        model.addAttribute("book", new Book());
        return "library/books/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("book") @Valid Book book, BindingResult bindingResult){

        if (bindingResult.hasErrors())
            return "library/books/new";
        bookDAO.save(book);
        return "redirect:/lib/books";
    }

    @GetMapping("/{id}")
    public String editBook(Model model, @PathVariable("id") int id){

        Book book = bookDAO.show(id);
        model.addAttribute("book", book);
        model.addAttribute("people", personDAO.index());
        model.addAttribute("newOwner", new Person());
        if (book.getPerson_id()!=null)
            model.addAttribute("person", personDAO.show(book.getPerson_id()));

        return "library/books/show";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") int id){
        bookDAO.delete(id);
        return "redirect:/lib/books";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("book", bookDAO.show(id));
        return "/library/books/edit";
    }

    @PatchMapping("/{id}")
    public String update(Model model, @ModelAttribute("book") @Valid Book book, BindingResult bindingResult, @PathVariable("id") int id){
        if (bindingResult.hasErrors()) {
            return "/library/books/edit";
        }

        bookDAO.update(id, book);
        return "redirect:/lib/books";
    }

    @PatchMapping("/{id}/free")
    public String free(@PathVariable("id") int id){
        bookDAO.freeTheBook(id);
        return "redirect:/lib/books/"+id;
    }

    @PatchMapping("/{id}/newOwner")
    public String newOwner(@ModelAttribute("newOwner") Person person, @PathVariable("id")  int id){
        bookDAO.newOwner(id, person.getPerson_id());
        return "redirect:/lib/books/"+id;
    }
}
