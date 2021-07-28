package com.mypercent.Grocery.controller;

import com.mypercent.Grocery.Service.PointOfSalesTerminal;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PointOfSalesPointController {

    PointOfSalesTerminal pointOfSalesTerminal;

    public PointOfSalesPointController(PointOfSalesTerminal pointOfSalesTerminal) {
        this.pointOfSalesTerminal = pointOfSalesTerminal;
    }



}
