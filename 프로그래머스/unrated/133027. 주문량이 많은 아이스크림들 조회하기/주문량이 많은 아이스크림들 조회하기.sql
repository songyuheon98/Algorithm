-- 코드를 입력하세요
# 상반기1~6?? 7월? ???
# 1. 각각 테이블을 union으로 수직으로 조인
# 2. group by로 flavor을 기준으로 그룹화, 
# 3. 이후 sum을 이용하여 테이블 생성
# 4. 해당 테이블 order by total order 한 후 
# 5. limit 3 하면 되지 않을까?
with table1 as(
    (
        SELECT * FROM first_half
    )
    union
    (
        select * from july
    )
)
select FLAVOR from table1
group by flavor
order by sum(total_order) desc
limit 3