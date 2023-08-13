-- 코드를 입력하세요
SELECT order_id, product_id, substring(out_date,1,10) as OUT_DATE,
(
    case when out_date is NULL then '출고미정'
        when substring(out_date,1,10)<='2022-05-01' then '출고완료'
        else '출고대기' end
) as '출고여부'
from food_order