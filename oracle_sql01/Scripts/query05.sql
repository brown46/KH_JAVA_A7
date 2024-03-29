/*
 *EMPLOYEE 테이블의 직원이름, 이메일, 전화번호, 고용일을 조회 한다.
 *		- 직원이름은 성과 이름을 하나의 컬럼으로 만들어야 한다.
 *		- 이메일 뒤에는 @employees.co.kr을 붙여야 한다.
 *		- 전화번호의 구분자는 . 대신 -이 사용되도록 한다.
 *		- 고용일은 xxxx년 xx월 xx일 형식으로 출력되게 한다.
 */
SELECT FIRST_NAME ||' '||LAST_NAME AS "직원 이름"
	 , EMAIL||'@employees.co.kr' AS 이메일
	 , REPLACE(PHONE_NUMBER,'.','-') AS 전화번호
	 , TO_CHAR(HIRE_DATE,'YYYY"년" MM"월" DD"일"')  AS 고용일
FROM EMPLOYEES;



/*
 * EMPLOYEES 테이블에서 직원이름, 급여, 연봉을 조회 한다.
 * 		연봉은 급여에 12 개월을 곱하는 것으로 한다.
 * 		천단위 구분이 나오도록 한다.
 */

SELECT CONCAT(FIRST_NAME ||' ',LAST_NAME) AS "직원 이름"
	 , TRIM(TO_CHAR(SALARY,'999,999'))  AS 급여
	 , TRIM(TO_CHAR(SALARY *12,'999,999')) AS 연봉
FROM EMPLOYEES;


/*
 * EMPLOYEE 테이블에서 전화번호가 011로 시작하는 직원의 성과 이름, 사원번호,
 * 전화번호를 조회 한다.
 * 		- 성과 이름은 하나의 컬럼으로 만들어 출력되게 한다.
 * 		- 전화번호에서 011과 마지막 번호를 제외한 나머지 번호는 * 문자로 숨김처리한다.
 */
SELECT FIRST_NAME ||' '||LAST_NAME AS "직원 이름"
	 , EMPLOYEE_ID AS 사원번호
--	 ,PHONE_NUMBER 
	 ,REPLACE(PHONE_NUMBER ,SUBSTR(PHONE_NUMBER,5,7),'**.****' ) AS 전화번호
--	 , SUBSTR(PHONE_NUMBER,1,4)||'**.****'||SUBSTR(PHONE_NUMBER,12) AS 전화번호
FROM EMPLOYEES
WHERE PHONE_NUMBER LIKE '011%';



/*
 * EMPLOYEES 테이블에서 2000년도에 고용된 직원을 조회한다
 * 		- 성과 이름은 하나의 컬럼으로 만들어 출력되게 한다.
 * 		- 고용일은 XXXX년 XX월 XX일 형식으로 출력되게 한다.
 */
SELECT FIRST_NAME ||' '||LAST_NAME AS "직원 이름"
	  , TO_CHAR(HIRE_DATE,'YYYY"년" MM"월" DD"일"')  AS 고용일
FROM EMPLOYEES
WHERE  EXTRACT(YEAR FROM HIRE_DATE) ='2000';


/*
 * EMPLOYEES 테이블에서 HIRE_DATE를 기준으로 1999년 12월 31일 까지의 근무개월 수가
 * 60 개월 이상인 직원을 조회한다.
 * 		- 성과 이름은 하나의 컬럼으로 만들어 출력되게 한다.
 * 		- 고용일은 XXXX년 XX월 XX일 형식으로 출력되게 한다.
 * 		- 근무 개월 수도 출력되게 한다.
 */
SELECT FIRST_NAME ||' '||LAST_NAME AS "직원 이름"
	  , TO_CHAR(HIRE_DATE,'YYYY"년" MM"월" DD"일"')  AS 고용일
	  , TO_CHAR(MONTHS_BETWEEN('19991231',HIRE_DATE),'999')||'개월'  AS "근무 개월 수"
--	  ,ROUND(MONTHS_BETWEEN('19991231',HIRE_DATE)) 
FROM EMPLOYEES
WHERE MONTHS_BETWEEN('19991231',HIRE_DATE)>=60;

/*
 * LOCATION 테이블에서 우편번호가 5자리 숫자 또는 4자리 숫자로 되어 있는 지점을 
 * 조회한다.
 */

SELECT POSTAL_CODE AS 우편번호
FROM LOCATIONS 
WHERE POSTAL_CODE LIKE '____'OR LENGTH(POSTAL_CODE)=5;

