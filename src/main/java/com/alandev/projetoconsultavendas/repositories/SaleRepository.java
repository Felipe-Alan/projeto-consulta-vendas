package com.alandev.projetoconsultavendas.repositories;

import com.alandev.projetoconsultavendas.dto.SaleReportDTO;
import com.alandev.projetoconsultavendas.dto.SaleSummaryDTO;
import com.alandev.projetoconsultavendas.entities.Sale;
import com.alandev.projetoconsultavendas.projections.SaleReportProjection;
import com.alandev.projetoconsultavendas.projections.SaleSummaryProjections;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    // JPQL
    @Query(value = """
                select new com.alandev.projetoconsultavendas.dto.SaleSummaryDTO(obj.seller.name, SUM(obj.amount))
                from Sale obj
                WHERE obj.date BETWEEN :minDate AND :maxDate
                GROUP BY obj.seller.name
            """)
    List<SaleSummaryDTO> getSaleSummaries(LocalDate minDate, LocalDate maxDate);


    // SQL
    @Query(nativeQuery = true, value = """
                select tb_seller.name AS sellerName, SUM(amount) AS total
                from tb_sales
                INNER JOIN tb_seller ON tb_sales.seller_id = tb_seller.id
                WHERE date BETWEEN :minDate AND :maxDate
                GROUP BY tb_seller.name
                ORDER BY tb_seller.name
            """)
    List<SaleSummaryProjections> getSaleSummaries2(@Param("minDate") LocalDate minDate,
                                                   @Param("maxDate") LocalDate maxDate);

    @Query(nativeQuery = true, value = """
                    Select tb_sales.id as id, tb_sales.date as date, tb_sales.amount as amount, tb_seller.name as name
                    From tb_sales
                    INNER JOIN tb_seller
                    ON tb_seller.id = tb_sales.seller_id
                    WHERE tb_sales.date BETWEEN :minDate AND :maxDate
                    AND UPPER(tb_seller.name) LIKE UPPER(CONCAT('%', :name, '%'))
                    GROUP BY tb_sales.id , tb_seller.name
                    ORDER BY SUM(tb_sales.amount) 
            """)
    Page<SaleReportProjection> getReport(
            @Param("name") String name,
            @Param("minDate") LocalDate minDate,
            @Param("maxDate") LocalDate maxDate,
            Pageable pageable);

}
