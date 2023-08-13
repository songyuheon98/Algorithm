-- 코드를 입력하세요
SELECT book_id, substring(published_date,1,10) as published_date from book
where published_date like '2021%' and category = '인문'