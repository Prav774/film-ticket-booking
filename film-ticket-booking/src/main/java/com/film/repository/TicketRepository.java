package com.film.repository;

import com.film.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    // Search by movie name (case-insensitive)
    List<Ticket> findByMovieNameContainingIgnoreCase(String movieName);

    // Search by show time (case-insensitive)
    List<Ticket> findByShowTimeContainingIgnoreCase(String showTime);

    // Search by movie name OR show time
    @Query("SELECT t FROM Ticket t WHERE LOWER(t.movieName) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
           "OR LOWER(t.showTime) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Ticket> searchByMovieNameOrShowTime(@Param("keyword") String keyword);
}
