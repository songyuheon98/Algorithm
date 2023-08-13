-- 코드를 입력하세요
# 1. user_info, online_sale join
# 2. 년, 월, 성별 별로 그룹화
# 3. 회원수 집계 count
# 4. 년, 월, 성별 기존 오름차순 정력


#     select online_sale.*, user_info.gender from online_sale 
#     left join user_info on 
#     online_sale.user_id = user_info.user_id
#     where user_info.gender is not NULL


with table1 as(
    select online_sale.*, user_info.gender from online_sale 
    left join user_info on 
    online_sale.user_id = user_info.user_id
    where user_info.gender is not NULL
)
SELECT year(table1.sales_date) as YEAR,month(table1.sales_date) AS MONTH,
    table1.gender AS GENDER,COUNT(distinct table1.user_id) AS USERS FROM table1
group by year(table1.sales_date),month(table1.sales_date),table1.gender
order by year(table1.sales_date),month(table1.sales_date),table1.gender

    # select online_sale.*, user_info.gender from online_sale 
    # left join user_info on 
    # online_sale.user_id = user_info.user_id
    # where user_info.gender is not NULL
    # order by user_id