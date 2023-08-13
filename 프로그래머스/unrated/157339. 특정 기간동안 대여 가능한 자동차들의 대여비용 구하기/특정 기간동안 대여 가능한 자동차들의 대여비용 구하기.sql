-- 코드를 입력하세요
# car_rental_company_car = 자동차 대여 회사의 대여중인 자동차 정보 테이블
# car_rental_company_history = 자동차 대여 기록 정보 테이블
# car_rental_company_discount_plan = 자동차 종류 별 대여기간 종류 별 할인 정책 정보 테이블

# 1. 자동차 종류가 '세단' 또는 'SUV' 인 자동차 O
# 2. 2022년 11월 1일부터 2022년 11월 30일까지 대여 가능 O
# 3. 30일간의 대여 금액이 50만원 이상 200만원 미만인 자동차 O
# 4. 자동차 ID, 자동차 종류, 대여 금액(컬럼명: FEE) 리스트를 출력 
# 5. 대여 금액 기준 내림차순, 자동차 종류를 기준 오름차순 정렬, 자동차 ID를 기준 내림차순 정렬


with table1 as (
    select car.car_id,car.daily_fee,discount.discount_rate
     ,(1-(discount.discount_rate/100))*car.daily_fee*30 as month_fee
    
    from car_rental_company_car as car
    left join CAR_RENTAL_COMPANY_DISCOUNT_PLAN as discount on
    car.car_type =discount.car_type 
    where discount.duration_type like '30%'
), 

table2 as (
select car_id,month_fee from table1
    where month_fee <=2000000 and month_fee>=500000
), 

table3 as (
select car.car_id,car.car_type from car_rental_company_car as car
where car.car_type in ('세단','SUV') and
    car.car_id not in (
        select car_id
            from car_rental_company_rental_history as history
        where !((substring(history.start_date,1,10) < '2022-11-01' 
                    and substring(history.end_date,1,10) < '2022-11-01' ) or
              (substring(history.start_date,1,10) > '2022-11-30' 
                    and substring(history.end_date,1,10) > '2022-11-30' ) )
        order by car_id
    ) and 
    car.car_id in (
        select car_id from table2   
    )
), 
table4 as (    
    select table3.car_id as CAR_ID,table3.car_type as CAR_TYPE
            ,floor(table2.month_fee) as FEE 
        from table3
    left join table2 on
    table3.car_id = table2.car_id
)
select CAR_ID,CAR_TYPE,FEE from table4
order by fee desc, car_type asc, car_id desc