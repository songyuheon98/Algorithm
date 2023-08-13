-- 코드를 입력하세요
SELECT i.flavor from icecream_info i
inner join first_half f on
i.flavor = f.flavor
where f.total_order >=3000 and i.ingredient_type like 'fruit%'
order by f.total_order desc