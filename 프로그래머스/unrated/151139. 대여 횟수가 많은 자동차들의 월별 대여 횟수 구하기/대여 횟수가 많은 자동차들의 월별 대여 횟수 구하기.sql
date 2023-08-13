# -- 코드를 입력하세요
# # 1. CAR_RENTAL_COMPANY_RENTAL_HISTORY 단일 테이블 사용
# # 2. 2022-08 ~ 2022-10까지 대여 횟수 5회 이상인 자동차 체크
# # 3. 해당 자동차 해당 기간 월 별 자동차 ID 별 대여횟수 컬럼 = RECORDS
# # 4. 월 기준으로 오름차순, 같을시 자동차 ID기준 내림차순
# # 5. 특정 월 대여 횟수 0인 경우는 제외

# with table1 as (
#     select 
#     (
#         case when substring(start_date,1,7) ='2022-08' then 8
#         when substring(start_date,1,7) ='2022-09' then 9
#         when substring(start_date,1,7) ='2022-10' then 10
#         else 'NONE' end
#     ),
#     car_id, count(*) as rental_count from car_rental_company_rental_history as crp
#     where start_date like '2022-08%' or start_date like '2022-09%' or start_date like '2022-10%'
#     group by car_id
# )
# select * from table1
# where rental_count>=5

# select 
#     (
#         case when substring(start_date,1,7) ='2022-08' then 8
#         when substring(start_date,1,7) ='2022-09' then 9
#         when substring(start_date,1,7) ='2022-10' then 10
#         else 'NONE' end
#     ) as MONTH,
#     CAR_ID, count(*) as RECORDS 
# from car_rental_company_rental_history as crp
# where start_date like '2022-08%' or start_date like '2022-09%' or start_date like '2022-10%'
# group by car_id
# order by MONTH asc,car_id desc

# with table0 as (
#     select car_id, month(start_date) as month , count(*) from car_rental_company_rental_history as crp
#     where start_date like '2022-08%' or start_date like '2022-09%' or start_date like '2022-10%'
#     group by car_id, month(start_date)
#     order by car_id
# ),
# 특정 달에 0건인 자동차 거르기 위한 테이블
# with table1 as (
#     select car_id, month(start_date) as month , count(*) as rental_count from car_rental_company_rental_history as crp
#     where start_date like '2022-08%' or start_date like '2022-09%' or start_date like '2022-10%'
#     group by car_id, month(start_date)
#     order by car_id
# ), table2 as(
#     select car_id, count(*) as month_count from table1
#     group by car_id
# )
# select table1.month,table1.car_id,table1.rental_count as RECORDS from table1
# left join table2 on
# table1.car_id = table2.car_id
# where table2.month_count =3
# order by month asc , car_id desc


# # 1. CAR_RENTAL_COMPANY_RENTAL_HISTORY 단일 테이블 사용
# # 2. 2022-08 ~ 2022-10까지 대여 횟수 5회 이상인 자동차 체크
# # 3. 해당 자동차 해당 기간 월 별 자동차 ID 별 대여횟수 컬럼 = RECORDS
# # 4. 월 기준으로 오름차순, 같을시 자동차 ID기준 내림차순
# # 5. 특정 월 대여 횟수 0인 경우는 제외
with table3 as (
    select car_id,  count(*) as month_count from car_rental_company_rental_history as crp
    where start_date like '2022-08%' or start_date like '2022-09%' or start_date like '2022-10%'
    group by car_id
    order by car_id
    
)
,table0 as (
    select car_id, month(start_date) as month , count(*) as month_count from car_rental_company_rental_history as crp
    where start_date like '2022-08%' or start_date like '2022-09%' or start_date like '2022-10%'
    group by car_id, month(start_date)
    order by car_id
), table1 as(
select MONTH, CAR_ID, sum(month_count) as RECORDS from table0
group by month, car_id
order by car_id
# order by month asc, car_id desc
)
select table1.MONTH,table1.CAR_ID,table1.RECORDS from table1 
left join table3 on
table3.car_id = table1.car_id
where table3.month_count>=5
order by month asc, car_id desc