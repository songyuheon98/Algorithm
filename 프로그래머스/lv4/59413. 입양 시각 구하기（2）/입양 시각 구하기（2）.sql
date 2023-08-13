-- 코드를 입력하세요
# ANIMAL_OUTS  단일 테이블
# 1. 목적  몇 시에 입양이 가장 활발하게 일어나는지 
# 2. 0시부터 23시까지, 각 시간대별로 ( GROUP BY ), 입양이 없더라도? 시간 표시?
# 2-1. sql 시간 추출 함수 목록 : https://extbrain.tistory.com/60
# 3. 입양이 몇 건이나 발생했는지 ( SUM ) 조회
# 4. 결과는 시간대 순으로 정렬

with recursive table1 as (
    SELECT hour(datetime) as hour, count(*) as animal_adopt_count FROM animal_outs
    group by hour
    order by hour
),
 table2 as (
    select 0 as num
    union all
    select num+1  
    from table2
    where num < 23
    
),

table3 as (
    select * from table2
    left join table1 on
    table1.hour = table2.num
)
select num as HOUR, 
(
    case when animal_adopt_count is NULL then 0
    else animal_adopt_count end
) as COUNT
from table3
order by num