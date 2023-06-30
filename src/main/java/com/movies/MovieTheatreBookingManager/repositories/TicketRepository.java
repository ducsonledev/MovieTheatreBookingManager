package com.movies.MovieTheatreBookingManager.repositories;

import com.movies.MovieTheatreBookingManager.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

    List<Ticket> findByScreeningId(long screeningId);
}
