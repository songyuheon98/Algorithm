-- 코드를 입력하세요
SELECT substring(product_code,1,2) as PRODUCT_ID,count(*) AS PRODUCTS from product
group by substring(product_code,1,2)
order by substring(product_code,1,2) asc