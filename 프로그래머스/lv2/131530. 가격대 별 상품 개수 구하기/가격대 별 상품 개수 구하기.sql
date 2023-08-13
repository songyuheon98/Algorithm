-- 코드를 입력하세요
with table1 as (
    SELECT (FLOOR(price /10000)*10000) as price_group ,product_id  from product
)
SELECT price_group as PRICE_GROUP, count(product_id) as PRODUCTS FROM table1
group by price_group
order by price_group asc



# SELECT * FROM table1
# order by price_group asc


#SELECT (round(price /10000)*10000) as price_group ,product_id  from product
# SELECT FLOOR(PRICE) from product
# order by price asc