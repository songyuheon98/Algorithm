SELECT PT_NAME, PT_NO, GEND_CD, age,
       CASE WHEN TLNO IS NOT NULL THEN TLNO
        ELSE 'NONE' END 
FROM PATIENT 
WHERE age <= 12 AND GEND_CD = 'W'
order by age desc, pt_name asc


# SELECT pt_name, pt_no, gend_cd, age, 

# (

#     case when tlno is NULL then 'NONE'

#     else tlno end

# ) as TLNO

# from patient

# where age <=12 and gend_cd ='W'

# order by age desc, pt_name asc