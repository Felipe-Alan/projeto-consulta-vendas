package com.alandev.projetoconsultavendas.projections;

import java.time.LocalDate;

public interface SaleReportProjection {

    Long getId();
    LocalDate getDate();
    Double getAmount();
    String getName();
}
