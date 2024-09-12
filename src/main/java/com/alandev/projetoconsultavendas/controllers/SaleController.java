package com.alandev.projetoconsultavendas.controllers;

import com.alandev.projetoconsultavendas.dto.SaleReportDTO;
import com.alandev.projetoconsultavendas.dto.SaleSummaryDTO;
import com.alandev.projetoconsultavendas.dto.SalesDTO;
import com.alandev.projetoconsultavendas.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<SalesDTO> findById(@PathVariable Long id) {
        SalesDTO salesDTO = saleService.findById(id);
        return ResponseEntity.ok(salesDTO);
    }

    @GetMapping(value = "/report")
    public ResponseEntity<Page<SaleReportDTO>> getReport(@RequestParam(name = "name", defaultValue = "") String name,
                                                         @RequestParam(name = "minDate", defaultValue = "") String minDate,
                                                         @RequestParam(name = "maxDate", defaultValue = "") String maxDate,
                                                         Pageable pageable) {
        Page<SaleReportDTO> dtos = saleService.getReport(name, minDate, maxDate, pageable);
        return ResponseEntity.ok(dtos);
    }

    @GetMapping(value = "/summary")
    public ResponseEntity<List<SaleSummaryDTO>> getSummary(@RequestParam(name = "minDate", defaultValue = "") String minDate,
                                                           @RequestParam(name = "maxDate", defaultValue = "") String maxDate) {
        List<SaleSummaryDTO> dto = saleService.getSummary(minDate, maxDate);
        return ResponseEntity.ok(dto);
    }

}
