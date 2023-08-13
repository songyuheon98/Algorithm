-- 코드를 입력하세요
SELECT substring(datetime,12,2), count(*) from animal_outs
where substring(datetime,12,2) between 9 and 19
group by substring(datetime,12,2)
order by substring(datetime,12,2)