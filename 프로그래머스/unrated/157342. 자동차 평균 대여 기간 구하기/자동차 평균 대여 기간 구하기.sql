-- 코드를 입력하세요
# SELECT CAR_ID, SUM(END_DATE-START_DATE) AS RENTAL_DURATION,COUNT(END_DATE),
#         END_DATE,START_DATE FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
# GROUP BY CAR_ID
# ORDER BY CAR_ID



-- 코드를 입력하세요
WITH table1 as (
    
SELECT CAR_ID, DATEDIFF(END_DATE,START_DATE)+1 AS RENTAL_DURATION
         FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    
    
ORDER BY CAR_ID
), table2 as (
select CAR_ID,round(sum(rental_duration)/count(rental_duration),1) as AVERAGE_DURATION from table1
group by car_id
order by AVERAGE_DURATION DESC, car_id desc
)
select * from table2
where AVERAGE_DURATION >= 7
order by AVERAGE_DURATION DESC, car_id desc