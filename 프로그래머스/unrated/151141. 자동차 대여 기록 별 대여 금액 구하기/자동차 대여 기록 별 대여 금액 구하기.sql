-- 코드를 입력하세요
# CAR_RENTAL_COMPANY_CAR = 자동차 대여 회사에서 대여 중인 자동차들의 정보를 담은 테이블
# CAR_RENTAL_COMPANY_RENTAL_HISTORY = 자동차 대여 기록 정보를 담은 테이블
# CAR_RENTAL_COMPANY_DISCOUNT_PLAN = 자동차 종류 별 대여 기간 종류 별 할인 정책 정보를 담은 테이블

# 1. 자동차 종류가 '트럭'인 자동차 O
# 2. 대여 기록에 대해서 대여 기록 별로 대여 금액(컬럼명: FEE)을 구하여 
# 3. 대여 기록 ID와 대여 금액 리스트를 출력
# 4. 대여 금액을 기준 내림차순 정렬, 대여 기록 ID를 기준 내림차순 정렬
with date_term as(
    select history.history_id,history.car_id,car.car_type,datediff(end_date,start_date)+1 as diff_date 
        ,(
            case when datediff(end_date,start_date)+1<7 then 0
            when datediff(end_date,start_date)+1<30 then 7
            when datediff(end_date,start_date)+1<90 then 30
            else 90 end
        ) as discount_day_type 
    , car.daily_fee
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY history
    left join CAR_RENTAL_COMPANY_CAR car on
    car.car_id = history.car_id 
    where car.car_type = '트럭'
), discount_car as (
    select (
            case when duration_type like '7%' then 7
            when duration_type like '30%' then 30
            else 90  end
        ) as discount , discount_rate
        from CAR_RENTAL_COMPANY_DISCOUNT_PLAN plan
        where plan.car_type = '트럭'
) 
,full_table as (
    select date_term.*,
    (
        case when discount_car.discount_rate is NULL then 0
        else discount_car.discount_rate end
    ) as discount_rate    
     from date_term
    left join discount_car on
    date_term.discount_day_type = discount_car.discount
)
select history_id as HISTORY_ID, 
floor((
    case when discount_rate = 0 then daily_fee*diff_date
    else (1-(discount_rate/100))*daily_fee*diff_date end
)) as FEE
from full_table
order by FEE desc,history_id desc