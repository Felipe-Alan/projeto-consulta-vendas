package com.alandev.projetoconsultavendas.dto;

import com.alandev.projetoconsultavendas.entities.Sale;
import com.alandev.projetoconsultavendas.projections.SaleSummaryProjections;

public class SaleSummaryDTO {

    private String sellerName;
    private Double total;

    public SaleSummaryDTO() {
    }

    public SaleSummaryDTO(String sellerName, Double total) {
        this.sellerName = sellerName;
        this.total = total;
    }

    public SaleSummaryDTO(SaleSummaryProjections projections) {
        this.sellerName = projections.getSellerName();
        this.total = projections.getTotal();
    }

    public SaleSummaryDTO(Sale entity) {
        this.sellerName = entity.getSeller().getName();
        this.total = entity.getAmount();
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
