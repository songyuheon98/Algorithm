-- 코드를 입력하세요
# 1. food_product 단일 테이블
# 2. category -> 가장 비싼 가격 테이블 생성
# 3. 


with table1 as(
    select category,max(price) as max_price from food_product
    where category in ('과자','국','김치','식용유')
    group by category
)
select food_product.category,table1.max_price as MAX_PRICE, food_product.product_name from food_product
left join table1 on
food_product.category = table1.category
where table1.category is not NULL and table1.max_price = food_product.price
order by food_product.price desc