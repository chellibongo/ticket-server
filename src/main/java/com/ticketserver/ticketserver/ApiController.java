package com.ticketserver.ticketserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping(path = "/")
public class ApiController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TicketRepository ticketRepository;

    @GetMapping(path = "/users/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping(path = "/users/findByName")
    public @ResponseBody Iterable<User> getUserByName(@RequestParam String name) {
        return userRepository.findUserByUserName(name);
    }

    @GetMapping(path = "/tickets/all")
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

    /*
     * Figure out how to find userID and add a ticket that links to correct user, ?set so users have to have unique username then find userID by username
     */
    @PostMapping(value="/ticket/add")
    public @ResponseBody String postMethodName(@RequestParam String userName, String content) {
        Ticket ticket = new Ticket();
        ticket.setContent(content);
        ticketRepository.save(ticket);
        
        return "Ticket added";
    }
    

}
