-- 코드를 입력하세요
select PRODUCT_CODE, PRICE*SUM(SALES_AMOUNT) AS SALES  from offline_sale
left join product on offline_sale.product_id = product.product_id
GROUP BY PRODUCT_CODE
ORDER BY PRICE*SUM(SALES_AMOUNT) DESC,  PRODUCT_CODE ASC