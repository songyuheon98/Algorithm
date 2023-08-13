-- 코드를 입력하세요
SELECT animal_ins.animal_id,animal_ins.name
#,animal_ins.datetime as animalInput, animal_outs.datetime as animalOutput
from animal_ins
left join animal_outs on
animal_ins.animal_id = animal_outs.animal_id
where animal_ins.datetime>animal_outs.datetime
order by animal_ins.datetime asc