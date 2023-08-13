-- 코드를 입력하세요
# 1. ANIMAL_INS와 ANIMAL_OUTS를 조인
# 2. 보호소 들올때 중성화 x AND 보호소 나갈때 중성화 O 
# 3. 동물 아이디, 생물종, 이름 조회
# 4. 아이디 순으로 조회

select animal_ins.animal_id, animal_ins.animal_type,animal_ins.name
from animal_ins
left join animal_outs on
animal_ins.animal_id=animal_outs.animal_id
where animal_ins.sex_upon_intake not like '%Neutered%' and animal_ins.sex_upon_intake not like '%Spayed%'
    and ( animal_outs.sex_upon_outcome like '%Neutered%' or animal_outs.sex_upon_outcome like '%Spayed%')
order by animal_ins.animal_id