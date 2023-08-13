-- 코드를 입력하세요
# 1. USED_GOODS_BOARD , USED_GOODS_FILE JOIN 할것
# 2. 조회수가 가장 높은 게시물 체크
# 3. 해당 게시글 첨부파일 경로 조회
# 4. 첨부파일 경로는 FILE ID 기준 내림차순 정렬
# 5. 기본 파일 경로 = /home/grep/src/, 게시글 id 기준 디렉터리 구분
# 6. 파일 이름은 파일 id 파일 이름 파일 확정자로 출력
# 7. 조회 수가 가장 높은 게시물은 하나만 존재


# select * from used_goods_board as ugb
# left join used_goods_file as ugf on
# ugb.board_id = ugf.board_id

with table1 as(
    select ugb.board_id,max(ugb.views) as view from used_goods_board as ugb
    left join used_goods_file as ugf on
    ugb.board_id = ugf.board_id
    group by ugb.board_id
    order by max(ugb.views) desc
    limit 1
)
select concat('/home/grep/src/',ugf.board_id,'/',file_id,file_name,file_ext) as FILE_PATH
        from used_goods_file ugf
left join table1 on
ugf.board_id = table1.board_id
where table1.board_id is not NULL
order by ugf.file_id desc