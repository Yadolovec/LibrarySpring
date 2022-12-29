package com.Library.controller;

import com.Library.dao.BookDAO;
import com.Library.dao.PersonDAO;
import com.Library.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lib")
public class LibraryController {

    private final PersonDAO personDAO;
    private final BookDAO bookDAO;
    @Autowired
    public LibraryController(PersonDAO personDAO, BookDAO bookDAO) {
        this.personDAO = personDAO;
        this.bookDAO = bookDAO;
    }

    @GetMapping()
    public String main(){
        return "library/main";
    }
    @GetMapping("/people")
    public String allPeople(Model model){
        model.addAttribute("people", personDAO.index());
        return "library/people/index";
    }

    @GetMapping("/books")
    public String allBooks(Model model){
        model.addAttribute("books", bookDAO.index());
        return "library/books/index";
    }

    @GetMapping("/people/new")
    public String addUser(Model model){
        model.addAttribute("person", new Person());
        return "library/people/new";
    }
}
