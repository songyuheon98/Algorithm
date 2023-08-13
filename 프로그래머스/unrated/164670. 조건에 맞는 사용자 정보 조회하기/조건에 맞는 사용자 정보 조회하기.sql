-- 코드를 입력하세요

# 1. used_goods_board에 used_goods_users 조인 O
# 2. 중고 거래 게시물 3건이상 등록한 사용자 체크 O
# 3. 해당 사용자의 id, 닉네임, 전체주소, 전화 번호 조회 O
# 3-1 . 문자열 합치는 함수 concat
# https://gent.tistory.com/437
# 4. 전화번호는 xxx-xxxx-xxxx 형태로 형변환 O
# 5. 회원 id를 기준으로 내림차순 o
# 6. 중복이 없어야한다!!!

with table1 as (
    select * from used_goods_board as ugb
    left join used_goods_user as ugu on
    ugb.writer_id = ugu.user_id
), table2 as (
    select ugb.writer_id, count(*) as enroll from used_goods_board as ugb
    left join used_goods_user as ugu on
    ugb.writer_id = ugu.user_id
    group by ugb.writer_id
)
select table1.writer_id as USER_ID,table1.nickname, 
        concat(table1.CITY,' ',table1.street_address1,' ',table1.street_address2) 
        as 전체주소,(concat(substring(tlno,1,3),'-',substring(tlno,4,4),'-',substring(tlno,8,4))) as 전화번호
from table1 
left join table2 on
table1.writer_id = table2.writer_id
where enroll >=3
GROUP BY table1.user_id
order by table1.writer_id desc