package com.alandev.projetoconsultavendas.dto;

import com.alandev.projetoconsultavendas.entities.Sale;
import com.alandev.projetoconsultavendas.projections.SaleReportProjection;

import java.time.LocalDate;

public class SaleReportDTO {

    private Long id;
    private LocalDate date;
    private Double amount;
    private String name;

    public SaleReportDTO() {
    }

    public SaleReportDTO(Long id, LocalDate date, Double amount, String name) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.name = name;
    }

    public SaleReportDTO(Sale entity) {
        id = entity.getId();
        date = entity.getDate();
        amount = entity.getAmount();
        name = entity.getSeller().getName();
    }

    public SaleReportDTO(SaleReportProjection projection) {
        id = projection.getId();
        date = projection.getDate();
        amount = projection.getAmount();
        name = projection.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
