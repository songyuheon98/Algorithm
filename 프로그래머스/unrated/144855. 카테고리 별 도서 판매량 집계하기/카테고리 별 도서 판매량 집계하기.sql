-- 코드를 입력하세요
select book.category, sum(book_sales.sales) as TOTAL_SALES from book_sales 
left join book on
book.book_id = book_sales.book_id
where book_sales.sales_date like '%2022_01%'
group by category
order by category asc