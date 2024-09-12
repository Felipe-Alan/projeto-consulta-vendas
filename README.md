# Consulta vendas 

![Captura de tela 2024-09-12 070641](https://github.com/user-attachments/assets/2e4773cd-672d-4ef8-995c-8caf3cdd4a79)

## Sumário de vendas por vendedor 
1.[IN] O usuário informa, opcionalmente, data inicial, data final. <br>
2.[OUT] O sistema informa uma listagem contendo nome do vendedor e soma de vendas deste vendedor 
no período informado.

2.1) Sumário de vendas por vendedor (Ok)<br>
**GET /sales/summary?minDate=-01&maxDate=**<br>
Deverá retornar o sumário de vendas por vendedor no período informado: 

2.2) Sumário de vendas por vendedor (Ok)<br>
**GET /sales/summary**<br>
Deverá retornar o sumário de vendas por vendedor dos últimos 12 meses.

## Relatório de vendas 
1.[IN] O usuário informa, opcionalmente, data inicial, data final e um trecho do nome do vendedor. <br>
2.[OUT] O sistema informa uma listagem paginada contendo id, data, quantia vendida e nome do 
 vendedor, das vendas que se enquadrem nos dados informados.

2.3) Relatório de vendas (Ok)<br>
**GET /sales/report<br>**
Deverá retornar o relatório de vendas dos últimos 12 meses. 

2.4) Relatório de vendas (Ok)<br>
**GET /sales/report?minDate=1&maxDate=&name=odinson**<br>
Deverá retornar o relatório de vendas do período/vendedor informados:

## Conceitos utilizados
- Sessão JPA e estados de entidades
- Consultas com Query Methods
- Introdução sobre JPQL
- Arquitetura REST

## Tecnologias Utilizadas
- Spring Web
- Spring Data JPA
- PostgreSQL
