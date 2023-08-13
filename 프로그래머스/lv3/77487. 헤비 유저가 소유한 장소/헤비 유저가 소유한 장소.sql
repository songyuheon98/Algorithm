# 1. place 단일 테이블 사용
# 2. 헤비 유저 = 공간을 둘이상 등록
# 3. 헤비 유저 공간 정보 아이디순 조회

with table1 as (
    select host_id,count(*) as space_count from places
    group by host_id
)
select places.id,places.name,places.host_id from places 
left join table1 on
places.host_id = table1.host_id
where table1.space_count>=2
order by places.id