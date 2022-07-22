package com.ticketserver.ticketserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/")
public class ApiController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TicketRepository ticketRepository;

    @GetMapping(path = "/all/users")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping(path = "/users/findByName")
    public @ResponseBody Iterable<User> getUserByName(@RequestParam String name) {
        return userRepository.findUserByUserName(name);
    }

    @GetMapping(path = "/all/tickets")
    public @ResponseBody Iterable<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }
    
    @PostMapping(path = "/add/user")
    public @ResponseBody String addUser(@RequestParam String name) {
        User user = new User();
        user.setUserName(name);
        userRepository.save(user);
        return "User added";
    }

}
