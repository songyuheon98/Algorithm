-- 코드를 입력하세요
SELECT ub.TITLE,ub.BOARD_ID,ur.REPLY_ID,ur.WRITER_ID,ur.CONTENTS,
    substring(ur.created_date,1,10) as CREATED_DATE
    from used_goods_board ub
inner join used_goods_reply ur on
ub.board_id = ur.board_id
where ub.created_date like '2022-10%'
order by ur.created_date asc, ub.title asc