SELECT WAREHOUSE_ID, WAREHOUSE_NAME,ADDRESS,
        CASE WHEN FREEZER_YN IS NULL THEN 'N'
        else freezer_yn end as freezer_yn
        from FOOD_WAREHOUSE
where address like '경기도%'
order by WAREHOUSE_ID asc