-- 코드를 입력하세요
SELECT animal_ins.name, animal_ins.datetime from animal_ins
left join animal_outs on
animal_ins.animal_id = animal_outs.animal_id
where animal_outs.datetime is NULL
order by animal_ins.datetime asc
limit 3