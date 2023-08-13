-- 코드를 입력하세요
# 1. CAR_RENTAL_COMPANY_RENTAL_HISTORY 단일 데이터 사용
# 2. 기준일 2022-10-16 대여중인 경우 대여중, 그외는 대여가능 case 문 표시 컬럼은 AVAILABILITYB
# 2-1. 10-16일 대여 불가능한 차들의 목록 테이블을 생성 -> join한 이후 null인 것이 대여가능
# 3. 기준일날 반납 날짜 일경우 대여중으로 표시
# 4. 자동차 id와 AVAILABILITY 출력
# 5. 자동차 ID를 기준 내림차순

with table1 as(
    SELECT crp.car_id,'대여중' as rental_able FROM car_rental_company_rental_history as crp
        where !((substring(crp.start_date,1,10) < '2022-10-16' and substring(crp.end_date,1,10)  < '2022-10-16') or
            (substring(crp.start_date,1,10) > '2022-10-16' and substring(crp.end_date,1,10)  > '2022-10-16') )
    group by crp.car_id
    order by crp.car_id
) , table2 as(
    select * from car_rental_company_rental_history
)
select DISTINCT table2.car_id
,(
    case when table1.rental_able is NULL then '대여 가능'
    else table1.rental_able end
) as AVAILABILITY
from table2
left join table1 on
table1.car_id = table2.car_id
ORDER BY table2.car_id desc