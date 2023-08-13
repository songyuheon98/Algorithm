-- 코드를 입력하세요
# appointment.pt_no - patient.pt_no appointment.mddr_id - doctor.dr_id
# 1. 3 테이블 전부 조인
# 2. 2022년 4월 13일 
# 3. 예약 취소되지 않은 
# 4. 흉부외과(CS) 
# 5. 진료예약번호, 환자이름, 환자번호, 진료과코드, 의사이름, 진료예약일시 출력

with table1 as(
    SELECT appointment.*,patient.pt_name from appointment 
    left join patient on
    appointment.pt_no =patient.pt_no
), table2 as(
    select table1.*,doctor.dr_name from table1
    left join doctor on 
    table1.mddr_id = doctor.dr_id
)
# select apnt_no,pt_name,pt_no,mcdp_cd,dr_name, apnt_ymd from table2
select apnt_no,pt_name,pt_no,mcdp_cd,dr_name, apnt_ymd from table2
where apnt_ymd like '2022-04-13%' and apnt_cncl_yn = 'N' and mcdp_cd='CS'
order by apnt_YMD asc