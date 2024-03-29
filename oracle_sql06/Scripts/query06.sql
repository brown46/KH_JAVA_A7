/*
 * DEPARTMENTS 테이블에 총원(EMP_TOTAL) 컬럼을 추가하여 부서별 인원을 기록할 수 있도록 수정한다.
 * 
 * 사원 추가(PROC_ADD_EMPLOYEE) 프로시져를 생성하여 사원을 추가할 때 다음의 기능이 동작하도록 한다.
 *     - EMPLOYEES 테이블에 사원을 추가할 수 있는 최소한의 정보를 이용하여 프로시져가 동작하게 한다.
 *     - 추가된 사원의 부서에 맞추어 DEPARTMENTS 테이블의 EMP_TOTAL 컬럼의 총원을 증가시키도록 한다.
 * 
 * 사원 수정(PROC_MOD_EMPLOYEE) 프로시져와 사원 삭제(PROC_DEL_EMPLOYEE) 프로시져를 생성하여 다음의 기능이
 * 동작하도록 한다.
 *     - EMPLOYEES 테이블의 사원정보를 수정/삭제 할 수 있는 최소한의 정보를 이용하여 프로시져가 동작하게 한다.
 *     - 사원의 정보를 수정할 때는 급여, 직무, 부서 만 수정할 수 있게 한다.
 *     - 수정/삭제된 사원의 부서에 맞추어 DEPARTMENTS 테이블의 EMP_TOTAL 컬럼의 총원을 증가 혹은 감소 시키도록 한다.
 * 
 * TRIGGER 로도 생성하여 만들어 본다.
 * TRIGGER 로 생성하고 테스트 할 때에는 직접 INSERT, UPDATE, DELETE 쿼리문을 만들어서 실행해야 합니다.
 */
SELECT * FROM DEPARTMENTS;
SELECT * FROM EMPLOYEES;
SELECT * FROM JOBS;
ALTER TABLE DEPARTMENTS ADD EMP_TOTAL NUMBER DEFAULT 0;



UPDATE DEPARTMENTS D1
   SET EMP_TOTAL = (SELECT CNT
                      FROM (SELECT DEPARTMENT_ID AS DEPT_ID
                                 , COUNT(*) AS CNT
                              FROM EMPLOYEES E1
                             GROUP BY DEPARTMENT_ID)
                     WHERE DEPT_ID = D1.DEPARTMENT_ID);     		   
								     		   

CREATE OR REPLACE PROCEDURE PROC_ADD_EMPLOYEE(
       FNAME VARCHAR2
     , LNAME VARCHAR2
     , EM VARCHAR2
     , JOBID VARCHAR2
     , DEPTID NUMBER)
IS 
	EMPID NUMBER;
	SAL NUMBER;
	EJOB VARCHAR2(40);
	EDEPT NUMBER;
BEGIN 
	SELECT MAX(EMPLOYEE_ID)+1 INTO EMPID FROM EMPLOYEES;
    SELECT JOB_ID, MIN_SALARY INTO EJOB, SAL FROM JOBS WHERE JOB_ID =JOBID;
    SELECT DEPARTMENT_ID  INTO EDEPT FROM DEPARTMENTS WHERE DEPARTMENT_ID  =DEPTID;
   
	INSERT INTO EMPLOYEES(EMPLOYEE_ID, FIRST_NAME, LAST_NAME,EMAIL,HIRE_DATE,SALARY, JOB_ID, DEPARTMENT_ID) VALUES(EMPID,FNAME,LNAME,EM,SYSDATE,SAL,JOBID,DEPTID);
	
	/*UPDATE DEPARTMENTS D
	   SET EMP_TOTAL = EMP_TOTAL +1
	 WHERE D.DEPARTMENT_ID= DEPTID; */
	--TRIGGER로  대체함			 
	COMMIT;
EXCEPTION 
	WHEN NO_DATA_FOUND THEN
		DBMS_OUTPUT.PUT_LINE('직무코드 또는 부서ID가 존재하지 않습니다.');
	ROLLBACK;
END;



BEGIN
	PROC_ADD_EMPLOYEE('FNAME','LNAME','FL','IT_PROG',60);
END;

BEGIN
	PROC_DEL_EMPLOYEE(213);
END;

BEGIN
    PROC_MOD_EMPLOYEE(207, 4000, 'IT_PROG', 80);
END;

DROP TRIGGER UPDATE_EMP_TOTAL;

CREATE OR REPLACE TRIGGER UPDATE_EMP_TOTAL
	AFTER INSERT 
	ON EMPLOYEES
	FOR EACH ROW 
BEGIN 
	UPDATE DEPARTMENTS D
       SET EMP_TOTAL = EMP_TOTAL +1
     WHERE DEPARTMENT_ID= :NEW.DEPARTMENT_ID;
END;


CREATE OR REPLACE PROCEDURE PROC_MOD_EMPLOYEE(
       EMP_ID NUMBER
     , SAL NUMBER
     , JOBID VARCHAR2
     , DEPTID VARCHAR2)
IS 
VAR_DEPTID NUMBER;
BEGIN 
	SELECT DEPARTMENT_ID INTO VAR_DEPTID FROM EMPLOYEES WHERE EMPLOYEE_ID = EMP_ID;

--	IF VAR_DEPTID <> DEPTID THEN
--		UPDATE DEPARTMENTS 
--		   SET EMP_TOTAL = EMP_TOTAL-1
--		 WHERE DEPARTMENT_ID = VAR_DEPTID;
--
--		UPDATE DEPARTMENTS 
--		   SET EMP_TOTAL = EMP_TOTAL+1
--		 WHERE DEPARTMENT_ID = DEPTID;
--	END IF;
--TRIGGER로 대체
	UPDATE EMPLOYEES 
	   SET SALARY =SAL 
	     , JOB_ID =JOBID 
	     , DEPARTMENT_ID = DEPTID
	 WHERE EMPLOYEE_ID =EMP_ID;
	COMMIT;
EXCEPTION
	WHEN NO_DATA_FOUND THEN
		DBMS_OUTPUT.PUT_LINE('해당 사원이 존재하지 않습니다');
		ROLLBACK;
END;


CREATE OR REPLACE PROCEDURE PROC_DEL_EMPLOYEE(
       EMP_ID NUMBER)
IS 
	   VAR_DEPTID NUMBER;
BEGIN 
	SELECT DEPARTMENT_ID INTO VAR_DEPTID FROM EMPLOYEES WHERE EMPLOYEE_ID= EMP_ID;
	DELETE FROM EMPLOYEES WHERE EMPLOYEE_ID= EMP_ID;
--	UPDATE DEPARTMENTS 
--	   SET EMP_TOTAL = EMP_TOTAL-1
--	 WHERE DEPARTMENT_ID = VAR_DEPTID;
	--TRIGGER로 대체
	COMMIT;
EXCEPTION
	WHEN NO_DATA_FOUND THEN
		DBMS_OUTPUT.PUT_LINE('해당 사원이 존재하지 않습니다');
		ROLLBACK;
END;


CREATE OR REPLACE TRIGGER DEL_EMP_TOTAL
AFTER DELETE ON EMPLOYEESFOR EACH ROW
BEGIN 
	UPDATE DEPARTMENTS D 
	   SET EMP_TOTAL = EMP_TOTAL -1
	 WHERE DEPARTMENT_ID =:OLD.DEPARTMENT_ID;
END;

CREATE OR REPLACE TRIGGER MOD_EMP_TOTAL
	AFTER UPDATE
	ON EMPLOYEES
	FOR EACH ROW
BEGIN 
	IF :OLD.DEPARTMENT_ID <> :NEW.DEPARTMENT_ID THEN 
		UPDATE DEPARTMENTS 
		   SET EMP_TOTAL= EMP_TOTAL +1
		 WHERE DEPARTMENT_ID = :NEW.DEPARTMENT_ID;
		UPDATE DEPARTMENTS 
		   SET EMP_TOTAL= EMP_TOTAL -1
		 WHERE DEPARTMENT_ID = :OLD.DEPARTMENT_ID;
	END IF;
END;


CREATE OR REPLACE TRIGGER MOD_EMP_TOTAL
AFTER UPDATE OF DEPARTMENT_ID ON EMPLOYEES FOR EACH ROW
BEGIN 
	UPDATE DEPARTMENTS 
	   SET EMP_TOTAL= EMP_TOTAL +1
	 WHERE DEPARTMENT_ID = :NEW.DEPARTMENT_ID;
	UPDATE DEPARTMENTS 
	   SET EMP_TOTAL= EMP_TOTAL -1
	 WHERE DEPARTMENT_ID = :OLD.DEPARTMENT_ID;
END;



BEGIN
	PROC_DEL_EMPLOYEE(213);
END;




SELECT * FROM USER_ERRORS;