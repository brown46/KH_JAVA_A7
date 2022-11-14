/*
 * 집합 연산자
 * 	  - 2개 이상의 Record Set결과를 하나의 Record Set 결과로 만드는 연산자
 * 	  - UNION, UNION ALL, INTERSECT, MINUS 연산자가 있다.
 * 	  - 컬럼의 수는 동일해야 한다.
 * UNION 
 * 	  - 모든 Record set의 결과를 합쳐서 하나의 Record Set으로 만든다.
 * 	  - 합집합(중복 불허)
 * 
 * UNION ALL
 * 	  - 모든 Record set의 결과를 합쳐서 하나의 Record Set으로 만든다.
 * 		단, 중복된 결과는 하나만 반영한다.
 * 	  - 합집합(중복 허용)
 * 
 * INTERSECT
 * 	  - 모든 Record Set의 결과를 합칠 때 중복 Record에 대해서만 하나의
 * 		Record Set으로 합친다.
 * 	  - 교집합
 * 
 * MINUS
 * 	  -A, B Record Set 의 결과를 합칠 때 A와 B에 중복된 Record와 B Record Set
 *     을 제외한 Record 들만 모아서 하나의 Record Set 으로 합친다.
 * 	  - 차칩합
 */
SELECT *
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID= 10
UNION ALL 
SELECT *
  FROM EMPLOYEES
 WHERE MANAGER_ID = 101;


SELECT *
  FROM EMPLOYEES
 WHERE MANAGER_ID = 101
MINUS  
SELECT *
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID= 10;

SELECT DEPARTMENT_ID
	 , MANAGER_ID
  FROM DEPARTMENTS
MINUS
SELECT DISTINCT DEPARTMENT_ID 
	 , MANAGER_ID 
  FROM EMPLOYEES;

