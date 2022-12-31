package com.Library.controller;

import com.Library.dao.BookDAO;
import com.Library.dao.PersonDAO;
import com.Library.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/lib/people")
public class PeopleController {

    private final PersonDAO personDAO;
    private final BookDAO bookDAO;
    @Autowired
    public PeopleController(PersonDAO personDAO, BookDAO bookDAO) {
        this.personDAO = personDAO;
        this.bookDAO = bookDAO;
    }

    @GetMapping("/main")
    public String main(){
        return "library/main";
    }
    @GetMapping()
    public String allPeople(Model model){
        model.addAttribute("people", personDAO.index());
        return "library/people/index";
    }

    @GetMapping("/new")
    public String addUser(Model model){
        model.addAttribute("person", new Person());
        return "library/people/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("person") Person person){
        personDAO.save(person);
        return "redirect:/lib/people";
    }

    @GetMapping("/{id}")
    public String editPerson(Model model, @PathVariable("id") int person_id){
        model.addAttribute("person", personDAO.show(person_id));
        model.addAttribute("books", bookDAO.booksOfPerson(person_id));
        return "library/people/show";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") int id){
        personDAO.delete(id);
        return "redirect:/lib/people";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model){
        model.addAttribute("person", personDAO.show(id));
        return "library/people/edit";
    }

    @PatchMapping("/{id}")
    public String update(@PathVariable("id") int id, @ModelAttribute("person") Person personToUpdate){
        personDAO.update(id, personToUpdate);
        return "redirect:/lib/people";
    }
}
