-- 코드를 입력하세요
with table1 as (
    SELECT HISTORY_ID, CAR_ID, substring(start_date,1,10) as START_DATE, 
            substring(end_date,1,10) as END_DATE 
            from car_rental_company_rental_history
            where start_date like '2022-09%'
)
select t.HISTORY_ID, t.CAR_ID, t.START_DATE, t.END_DATE, 
        (
            case when datediff(t.end_date, t.start_date) >=29 then '장기 대여'
            else '단기 대여' end
        ) as RENT_TYPE
    from table1 t
    order by history_id desc