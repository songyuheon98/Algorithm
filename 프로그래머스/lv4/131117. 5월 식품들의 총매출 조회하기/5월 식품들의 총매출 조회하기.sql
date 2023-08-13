-- 코드를 입력하세요
# 1. food product와 food order 테이블 조인
# 2. 2022년 5월인 식품
# 3. 해당 식품의 식품 id, 식품 이름, 총매출 조회
# 3-1. 총매출 테이블 필요
# 4. 총매출 기준 내림차순, 같으면 식품 id 기준 오름차순

# select * from food_product 

# select food_product.product_id,food_product.product_name,food_product.price,food_order.amount from food_order
# left join food_product on
# food_order.product_id = food_product.product_id
# where food_order.produce_date like '%2022-05%'


# select food_product.product_id,food_product.product_name,(food_product.price*food_order.amount) as TOTAL_SALES
#     from food_order
# right join food_product on
# food_order.product_id = food_product.product_id
# where food_order.produce_date like '%2022-05%'
# ORDER BY TOTAL_SALES DESC, food_order.product_id asc

select food_product.PRODUCT_ID, food_product.PRODUCT_NAME, sum(food_product.price * food_order.amount) as TOTAL_SALES
    from food_order
right join food_product on
food_order.product_id = food_product.product_id
where food_order.produce_date like '%2022-05%'
GROUP BY food_product.product_id
ORDER BY TOTAL_SALES DESC, food_order.product_id asc