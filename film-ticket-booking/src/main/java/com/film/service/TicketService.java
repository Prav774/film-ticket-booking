package com.film.service;

import com.film.model.Ticket;

import java.util.List;
import java.util.Optional;

public interface TicketService {

    Ticket saveTicket(Ticket ticket);

    List<Ticket> getAllTickets();

    Optional<Ticket> getTicketById(Long id);

    Ticket updateTicket(Ticket ticket);

    void deleteTicketById(Long id);

    List<Ticket> searchTickets(String keyword);
}
