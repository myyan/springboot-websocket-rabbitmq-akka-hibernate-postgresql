package com.freeland.controller;

import com.freeland.model.user.Book;
import com.freeland.model.user.Person;
import com.freeland.repository.BookRepository;
import com.freeland.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by chenhao on 2016/10/21.
 */
@Controller
public class ManyToManyController {


    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private BookRepository bookRepository;

    @RequestMapping("/get")
    @ResponseBody
    private Person getPersons(@RequestParam(name = "name") String name) {
        Person person = personRepository.findByusername(name);
        return person;
    }

    @RequestMapping("/person/setting")
    @ResponseBody
    private Person setPerson(@RequestParam(name = "name") String name) {
        Person person = new Person();
        person.setUsername(name);
        Set<Book> bookSet = new HashSet<>();
        Book book = new Book();
        book.setBookname(name + "1");
        Book book1 = new Book();
        book1.setBookname(name + "2");
        bookSet.add(book);
        bookSet.add(book1);
        person.setBooks(bookSet);
        return personRepository.save(person);
    }

    @RequestMapping("/book/getting")
    @ResponseBody
    public Book getting(@RequestParam(name = "name") String name) {
        return bookRepository.findBybookname(name);
    }


}
