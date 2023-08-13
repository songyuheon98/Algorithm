# user_info = 의류 쇼핑몰에 가입한 회원 정보 테이블
# online_sale = 온라인 상품 판매 정보 테이블

# 1. online_sale 테이블 기반으로 user_info 조인
# 1-1. 전체 회원수 정보가 들어간 테이블과 구매한 회원수의 정보 테이블 필요
# 2. 2021년에 가입한 전체 회원들
# 3. 상품을 구매한 회원수와 상품을 구매한 회원의 비율(상품을 구매한 회원수 / 전체 회원 수)
# 4. 년, 월 별로 출력 ( group by ? )
# 5. 상품을 구매한 회원의 비율은 소수점 두번째자리에서 반올림 ( round(n,1))
# 5. 년을 기준으로 오름차순 정렬, 년이 같다면 월을 기준으로 오름차순 정렬
with table0 as (
    select count(*) as all_user_personnel  from user_info 
    where user_info.joined like '2021%'
    # 2021년 가입 전체 회원 테이블
), table1 as (
    # table1 -> table2 = 2021년 가입 회원 중 구매한 회원 테이블 월별 분리
    select month(online_sale.sales_date) as month_order_user,online_sale.user_id from online_sale
    
    left join user_info on
    online_sale.user_id = user_info.user_id
    where user_info.joined like '2021%'
    group by month_order_user, online_sale.user_id
    order by month_order_user asc
), table2 as(
    select month_order_user, count(*) as all_month_user_personnel from table1
    group by month_order_user
    
), table3 as (
    select online_sale.sales_date,online_sale.sales_amount from online_sale
    left join user_info on
    online_sale.user_id = user_info.user_id
    where user_info.joined like '2021%'
    # online_sale과 user_info를 조인한 sales_date, sales_amount 정보를 가지고 있는 테이블
), table4 as (
    select * from table3,table0
    # table3과 table0를 수평으로 합침
), table5 as (
    select * from table4
    left join table2 on 
    month(table4.sales_date)=table2.month_order_user
)
select year(sales_date) as YEAR, month(sales_date) as MONTH, all_month_user_personnel as PUCHASED_USERS,
    round(all_month_user_personnel/all_user_personnel,1) as PUCHASED_RATIO 
    from table5
group by YEAR, MONTH
order by YEAR asc, MONTH asc