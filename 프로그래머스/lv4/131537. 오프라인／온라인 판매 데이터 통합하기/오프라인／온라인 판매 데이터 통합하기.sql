# online_sale = 쇼핑몰 온라인 상품 판매 정보 테이블
# offline_sale = 오프라인 상품 판매 정보 테이블
# 1. ONLINE_SALE 테이블과 OFFLINE_SALE 테이블 조인
# 1-1. 테이블들과 최종 출력 쿼리들을 보니 join이 아닌 union으로 합쳐야할 것 같다.
# 1-2. online 테이블은 SALES_DATE, PRODUCT_ID, USER_ID, SALES_AMOUNT 
# 1-3. offline은 SALES_DATE, PRODUCT_ID, NULL as USER_ID, SALES_AMOUNT 로 하면 될것 같다
# 2. 2022년 3월의 오프라인/온라인 상품 판매 데이터
# 3. 판매 날짜, 상품ID, 유저ID, 판매량을 출력
# 4. OFFLINE_SALE 테이블의 판매 데이터의 USER_ID 값은 NULL 로 표시
# 5. 판매일을 기준으로 오름차순 정렬, 상품 ID를 기준으로 오름차순, 유저 ID를 기준으로 오름차순 정렬
with table1 as(
    select substring(SALES_DATE,1,10) as SALES_DATE, PRODUCT_ID, USER_ID, SALES_AMOUNT  from online_sale
    union
    select substring(SALES_DATE,1,10) as SALES_DATE, PRODUCT_ID, NULL as USER_ID, SALES_AMOUNT  from offline_sale
)
select * from table1
where sales_date like '2022-03%'
order by sales_date asc, product_id asc, user_id asc