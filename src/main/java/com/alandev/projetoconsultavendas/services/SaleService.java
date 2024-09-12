package com.alandev.projetoconsultavendas.services;

import com.alandev.projetoconsultavendas.dto.SaleReportDTO;
import com.alandev.projetoconsultavendas.dto.SaleSummaryDTO;
import com.alandev.projetoconsultavendas.dto.SalesDTO;
import com.alandev.projetoconsultavendas.entities.Sale;
import com.alandev.projetoconsultavendas.projections.SaleReportProjection;
import com.alandev.projetoconsultavendas.projections.SaleSummaryProjections;
import com.alandev.projetoconsultavendas.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    public SalesDTO findById(Long id) {
        Sale sale = saleRepository.findById(id).get();
        return new SalesDTO(sale);
    }

    public Page<SaleReportDTO> getReport(String name, String minDateStr, String maxDateStr, Pageable pageable) {
        LocalDate maxDate = maxDateStr.equals("") ? LocalDate.now().minusYears(2L) : LocalDate.parse(maxDateStr);
        LocalDate minDate = minDateStr.equals("") ? maxDate.minusYears(1L) : LocalDate.parse(minDateStr);

        Page<SaleReportProjection> list = saleRepository.getReport(name, minDate, maxDate, pageable);
        return list.map(x -> new SaleReportDTO(x));
    }

    public List<SaleSummaryDTO> getSummary(String minDateStr, String maxDateStr) {
        LocalDate maxDate = maxDateStr.equals("") ? LocalDate.ofInstant(Instant.now(),
                ZoneId.systemDefault()) : LocalDate.parse(maxDateStr);
        LocalDate minDate = minDateStr.equals("") ? maxDate.minusYears(2L) : LocalDate.parse(minDateStr);

        List<SaleSummaryProjections> result = saleRepository.getSaleSummaries2(minDate,maxDate);
        return result.stream().map(x -> new SaleSummaryDTO(x)).collect(Collectors.toList());
    }

}
