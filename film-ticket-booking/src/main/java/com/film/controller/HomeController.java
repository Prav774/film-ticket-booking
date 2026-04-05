package com.film.controller;

import com.film.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final TicketService ticketService;

    @Autowired
    public HomeController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("totalTickets", ticketService.getAllTickets().size());
        return "index";
    }
}
