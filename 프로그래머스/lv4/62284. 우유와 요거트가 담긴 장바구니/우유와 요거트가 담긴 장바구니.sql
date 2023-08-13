# 그룹화 한 이후 그 안의 
with table1 as (
select cart_id,group_concat(name) as name_group from cart_products
group by cart_id
)
select table1.cart_id as CART_ID from table1
where table1.name_group like '%Milk%' and table1.name_group like '%Yogurt%'