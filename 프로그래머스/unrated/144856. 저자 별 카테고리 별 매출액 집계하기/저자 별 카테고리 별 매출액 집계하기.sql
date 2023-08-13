-- 코드를 입력하세요
# BOOK = 각 도서 정보 테이블
# AUTHOR = 저자의 정보 테이블
# BOOK_SALES = 도서의 판매량 테이블
# 그럼 BOOK_SALES 테이블을 기반으로 BOOK과 AUTHOR을 조인하면 되지 않을까?

# 1. 2022년 1월 도서 판매데이터 기준? = 1월 도서만 찾으라는걸까?
# 2. 저자 별 카테고리 별 매출액 구할것? = GROUP BY로 저자별, 카테고리별? 매출액 구하는건가?
# 3. 저자 ID(AUTHOR_ID), 저자명(AUTHOR_NAME), 카테고리(CATEGORY), 매출액(SALES) 리스트를 출력
# 3-1. TOTAL_SALES = 판매량 * 판매가
# 4. 저자 ID 오름차순, 같다면 카테고리를 내림차순 정렬

with table1 as (
    select book.author_id,book.category,(book.price * book_sales.sales) as TOTAL_SALES,book_sales.sales_date
        from book
    left join book_sales on
    book.book_id = book_sales.book_id
    where book_sales.sales_date like '2022-01%'
    
), table2 as (
    select table1.*,author.author_name from table1
    left join author on 
    author.author_id = table1.author_id
)
select AUTHOR_ID,AUTHOR_NAME,CATEGORY,SUM(TOTAL_SALES) AS TOTAL_SALES from table2
group by AUTHOR_NAME, CATEGORY
order by author_id asc , category desc