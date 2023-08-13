-- 코드를 입력하세요
# with table1 as (
#     (
#         SELECT animal_ins.animal_id, animal_ins.name,animal_ins.datetime as animal_input
#         ,animal_outs.datetime as animal_output
#         from animal_ins 
#         LEFT join animal_outs on
#         animal_ins.animal_id= animal_outs.animal_id
#     )
#     UNION
#      (
#         SELECT animal_ins.animal_id, animal_ins.name,animal_ins.datetime as animal_input
#         ,animal_outs.datetime as animal_output
#         from animal_ins 
#         RIGHT join animal_outs on
#         animal_ins.animal_id= animal_outs.animal_id
#     ) 
# )
# select * from table1
# where animal_input is NULL and animal_output is not NULL
# order by animal_id



    # (
    #     SELECT animal_ins.animal_id, animal_ins.name
    #     ,animal_ins.datetime as animal_input
    #     ,animal_outs.datetime as animal_output
    #     from animal_ins 
    #     LEFT join animal_outs on
    #     animal_ins.animal_id= animal_outs.animal_id
    # )
    # UNION
    #  (
    #     SELECT animal_ins.animal_id, animal_ins.name
    #      ,animal_ins.datetime as animal_input
    #     ,animal_outs.datetime as animal_output
    #     from animal_ins 
    #     RIGHT join animal_outs on
    #     animal_ins.animal_id= animal_outs.animal_id
    # ) 


#         SELECT animal_ins.animal_id, animal_ins.name
#         ,animal_ins.datetime as animal_input
#         ,animal_outs.datetime as animal_output
#         from animal_ins 
#         LEFT join animal_outs on
#         animal_ins.animal_id= animal_outs.animal_id
        
        
#              (
#         SELECT animal_ins.animal_id, animal_ins.name
#          ,animal_ins.datetime as animal_input
#         ,animal_outs.datetime as animal_output
#         from animal_ins 
#         left join animal_outs on
#         animal_ins.animal_id= animal_outs.animal_id
#     ) 


# select * from animal_ins
with table1 as (
(
select animal_ins.animal_id as input_animal_id,
    animal_ins.name as input_animal_name,
    animal_ins.datetime as input_animal_datetime,
    animal_outs.animal_id as output_animal_id,
    animal_outs.name as output_animal_name,
    animal_outs.datetime as output_animal_datetime
    from animal_ins
left join animal_outs on
animal_outs.animal_id = animal_ins.animal_id
order by animal_ins.animal_id
)
union
(
select animal_ins.animal_id as input_animal_id,
    animal_ins.name as input_animal_name,
    animal_ins.datetime as input_animal_datetime,
    animal_outs.animal_id as output_animal_id,
    animal_outs.name as output_animal_name,
    animal_outs.datetime as output_animal_datetime
    from animal_ins
right join animal_outs on
animal_outs.animal_id = animal_ins.animal_id
order by animal_ins.animal_id
)
)
select output_animal_id,output_animal_name from table1
where input_animal_id is NULL and output_animal_id is not NULL
order by output_animal_id asc