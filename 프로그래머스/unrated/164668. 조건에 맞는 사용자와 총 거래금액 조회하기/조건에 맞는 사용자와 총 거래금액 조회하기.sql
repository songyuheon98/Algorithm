# -- 코드를 입력하세요
# SELECT used_goods_user.user_id,used_goods_user.nickname, used_goods_board.price as TOTAL_SALES from used_goods_board
# left join used_goods_user on
# used_goods_board.writer_id = used_goods_user.user_id
# where status = 'DONE' AND used_goods_board.price >=700000
# # SELECT count(*) from used_goods_user


# 1. 완료된* 중고거래 총금액이 70만원 이상* 
# 2. 회원 id, 닉네임, 총거래금액
# 3. 총거래금액 기준 오름차순 


# select * from used_goods_user




# -- 코드를 입력하세요
with table1 as (
    SELECT used_goods_board.writer_id, sum(price) as writer_transaction_price 
        from used_goods_board
    left join used_goods_user on
        used_goods_board.writer_id = used_goods_user.user_id
    where status = 'DONE' 
    group by used_goods_board.writer_id
    
), table2 as (
    SELECT * from used_goods_board
    left join used_goods_user on
        used_goods_board.writer_id = used_goods_user.user_id
    where status = 'DONE' 
    group by used_goods_board.writer_id
)
select table2.user_id,table2.nickname, table1.writer_transaction_price as TOTAL_SALES
    from table2
left join table1 on
table2.writer_id = table1.writer_id
where writer_transaction_price >=700000
order by TOTAL_SALES asc