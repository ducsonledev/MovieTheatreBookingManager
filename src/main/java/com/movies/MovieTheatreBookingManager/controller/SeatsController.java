package com.movies.MovieTheatreBookingManager.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/api/v1/seats")
public class SeatsController {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @GetMapping
    public String bookSeats(@RequestParam(value = "count") int seatCount, Model model) {
        model.addAttribute("count", seatCount);
        return "seats";
    }
}
