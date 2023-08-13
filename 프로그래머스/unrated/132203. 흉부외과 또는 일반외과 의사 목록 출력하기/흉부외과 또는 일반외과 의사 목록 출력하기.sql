-- 코드를 입력하세요
SELECT DR_NAME,DR_ID, MCDP_CD,SUBSTRING(HIRE_YMD,1,10) as HIRE_YMD from doctor
where mcdp_cd in ('CS','GS')
order by hire_ymd desc, dr_name asc