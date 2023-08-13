# 1. REST_INFO 와 REST_REVIEW join O
# 2. 서울에 위치한 식당 찾기 O
# 3. 식당 id, 식당 이름, 음식 종류, 즐겨찾기수, 주소, 리뷰 평균 점수 출력 
# 4. 리뷰 평균 점수 소수점 세번째 자리 반올림 round ( x, 2) 
# 5. 평균 점수 기준 내림차순 정렬, 즐겨찾기 수 기준 내림차순 정렬

select rest_info.rest_id,rest_info.rest_name,rest_info.food_type,
    rest_info.favorites,rest_info.address,round(avg(rest_review.review_score),2) as SCORE from rest_review
left join rest_info on
rest_review.rest_id = rest_info.rest_id
where address like '서울%'
group by(rest_info.rest_id)
order by SCORE desc, favorites desc