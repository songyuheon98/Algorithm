-- 코드를 입력하세요
# WITH table1 as (
# SELECT FOOD_TYPE,REST_ID,REST_NAME,FAVORITES from rest_info 
# ORDER BY FOOD_TYPE, FAVORITES DESC
# )

# select food_type, max(favorites) from table1
# group by food_type

# order by food_type desc

# SELECT FOOD_TYPE,REST_ID,REST_NAME,FAVORITES from rest_info 
# order by food_type

with table1 as(
    select food_type,max(favorites) as favorites from rest_info
    group by food_type
)
select rest_info.food_type,rest_info.rest_id,rest_info.rest_name,rest_info.favorites
from rest_info
left join table1 on 
table1.food_type = rest_info.food_type
where table1.favorites = rest_info.favorites
order by rest_info.food_type desc


    # select max(favorites) from rest_info
    # where rest_info.food_type = '일식'
    

#group by food_type

# ORDER BY FOOD_TYPE, FAVORITES DESC