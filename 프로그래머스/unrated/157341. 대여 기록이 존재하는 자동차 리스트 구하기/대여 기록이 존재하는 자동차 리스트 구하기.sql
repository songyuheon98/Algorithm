-- 코드를 입력하세요


# 1. 기록 테이블에 자동차 정보 테이블 조인
# 2. 자동차 종류가 세단이고 10월에 대여 시작 기록 있는 자동차 출력
# 3. 자동차 id 중복없이 출력
# 4. 자동차 id 기준 내림차순

select DISTINCT car_rental_company_car.car_id as CAR_ID from car_rental_company_rental_history 
left join car_rental_company_car on 
car_rental_company_rental_history.car_id = car_rental_company_car.car_id
where car_type = '세단' and start_date like '2022-10%'
order by car_rental_company_car.car_id desc