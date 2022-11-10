-- 사원 정보 테이블
SELECT * FROM  EMPLOYEES;

-- 부서 정보 테이블
SELECT * FROM  DEPARTMENTS;

-- 직급/직무 정보 테이블
SELECT * FROM  JOBS ;

-- 지점 정보 테이블
SELECT * FROM  LOCATIONS;

-- 국가 정보 테이블
SELECT * FROM  COUNTRIES;

--대륙 정보 테이블
SELECT * FROM  REGIONS;

/*
사원 테이블에서 SALARY정보가 3000이하인 사원이 사번(EMPLOYEE_ID)
이름(FIRST_NAME + LAST_NAME)을 조회 하세요 
 */
SELECT EMPLOYEE_ID 
	 , FIRST_NAME ||' '||LAST_NAME 	AS 이름
FROM EMPLOYEES
WHERE SALARY <=3000;

/*
사원 테이블에서 DEPARTMENT_ID가 50인 사원의 사번(EMPLOYEE_ID)
이름(FIRST_NAME + LAST_NAME), 직무(JOB_ID)를 조회 하세요 
 */
SELECT EMPLOYEE_ID 
	 , FIRST_NAME ||' '||LAST_NAME 	AS 이름
	 , JOB_ID 
FROM EMPLOYEES
WHERE DEPARTMENT_ID =50;

/*
부서 테이블에서 DEPARTMENT_NAME 의 값이 IT가 포함된 결과를 조회하세요
부서ID(DEPARTMENT_ID), 부서명(DEPARTMENT_NAME) 컬럼만 Record Set에 반환하세요
 */
SELECT DEPARTMENT_ID 
	 , DEPARTMENT_NAME
FROM DEPARTMENTS 
WHERE DEPARTMENT_NAME LIKE '%IT%';

/*
직무 테이블에서 JOB_TITLE의 값에 Manager가 포함된 결과를 조회하세요
직무ID(JOB_ID), 직무명(JOB_TITLE) 컬럼만 Record Set에 반환하세요
 */
SELECT JOB_ID  
	 , JOB_TITLE 
FROM JOBS  
WHERE JOB_TITLE  LIKE '%Manager%';

/*
사원 테이블에서 MANAGER_ID 컬럼만을 조회 할 때 중복도니 결과값이 나오지 않게 하세요.
 */
SELECT DISTINCT MANAGER_ID 
FROM EMPLOYEES;

/*
사원 테이블에서 EMAIL 칼럼을 출력할 때 "@emp.co.kr."이 추가로 붙어서 나오게 하세요
 */
SELECT EMAIL ||'@emp.co.kr' as 이메일
FROM EMPLOYEES;

/*
사원 테이블에서 전화번호 형식이 xxx.xxx.xxxx.에 해당하는 정보만 Record Set으로 반환되게 하세요
 */
SELECT PHONE_NUMBER 
FROM EMPLOYEES
WHERE PHONE_NUMBER LIKE '___.___.____';

/*
사원 테이블에서 COMMISSION_PCT 가 NULL 이 아닌 데이터들만 조회되게 하고 SALARY를 출력할 때
 */
SELECT SALARY* (COMMISSION_PCT +1) AS "급여(커미션 포함)"
FROM EMPLOYEES
WHERE COMMISSION_PCT IS NOT NULL;
