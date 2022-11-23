/*
 * VIEW 객체
 * 		- SELECT 문의 실행 결과를 저장한 가상 테이블
 * 		- 테이블과 다르게 실제 데이터를 저장하고 있지는 않다.
 * 		- 실제 데이터를 저장하고 있지는 않지만 실제 테이블을 사용하는 것과
 * 		  동일하게 사용가능하다.
 */

--없으면 만들고 있으면 수정. ~FORCE VIEW : 테이블이 없어도 생성. 나중에 테이블 추가
CREATE OR REPLACE VIEW V_EMP
AS 
SELECT EMPLOYEE_ID EMP_ID
	 , FIRST_NAME ||' '||LAST_NAME AS EMP_NAME
	 , LOWER(EMAIL)||'@emp.co.kr' AS EMAIL
	 , SALARY
	 , MANAGER_ID
	 , DEPARTMENT_ID AS DEPT_ID
  FROM EMPLOYEES
  WHERE MANAGER_ID BETWEEN 100 AND 100
  WITH CHECK OPTION;
 --WHERE절 
 --WITH READ ONLY : 읽기 전용

 
SELECT * FROM V_EMP;

UPDATE V_EMP
   SET MANAGER_ID=130
 WHERE EMP_ID=101;

/*
 * VIEW 를 사용하여 INSERT, UPDATE, DELETE 작업을 할 수 있지만 다음의 경우에는 
 * 사용을 할 수 없다.
 * 		1. VIEW 에 포함되지 않은 컬럼을 사용하는 경우
 * 		2. VIEW 에 포함되지 않은 컬럼 중 NOT NULL 제약조건이 있는 경우
 * 		3. 산술 표현식으로 정의된 경우
 * 		4. 그룹함수나 GROUP BY 절이 포함된 경우
 * 		5. DISTINCT 키워드가 있는 경우
 * 		6. JOIN을 사용하여 여러 테이블이 결합된 경우
 * 
 */



