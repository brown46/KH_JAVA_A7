/*
 * web_admin 계정을 새로 만들고 필요한 권한을 설정 후 
 * web_admin 계정의 connection 정보를 생성 후 접속
 * HQ_TABLE을 스크립트로 실행하여 테이블 및 데이터 추가 
 * EMPLOYEE 테이블을 확인하여 추가가 잘 되었는지 확인
 * 
 * DROP USER DEV01 CASCADE;
CREATE USER dev01 IDENTIFIED BY dev01;
CREATE USER web_admin IDENTIFIED BY web_admin;
GRANT CONNECT, RESOURCE, DBA TO web_admin;

 * SELECT, INSERT, UPDATE, DELETE
 * CREATE, ALTER, DROP
 * JOIN, SUBQUERY
 */
SELECT * FROM EMPLOYEES;
/*
 * EMPLOYEES의 HIRE_DATE 열의 값을 +10년 하여 수정한다.
 */

UPDATE EMPLOYEES SET HIRE_DATE= HIRE_DATE+365*10; 


/*
 * JOBS 테이블과 동일한 구조의 KJOBS테이블을 만들고 JOB_TITLE 열의 값을 
 * 한글로 번역하여 수정한다.
 * 단, MIN_SALARY, MAX_SALARY 칼럼은 만들 필요 없음
 */

CREATE TABLE KJOBS(
	   JOB_ID VARCHAR2(30)
	 , JOB_TITLE VARCHAR2(50)
);
DROP TABLE KJOBS;
SELECT * FROM KJOBS;

INSERT INTO KJOBS VALUES('회장','AD_PRES');
INSERT INTO KJOBS VALUES('부회장','AD_VP');
INSERT INTO KJOBS VALUES('행정 매니저 보조','AD_ASST');
INSERT INTO KJOBS VALUES('재무분석가','FI_MGR');
INSERT INTO KJOBS VALUES('회계사','FI_ACCOUNT');
INSERT INTO KJOBS VALUES('대리','AC_MGR');
INSERT INTO KJOBS VALUES('공인회계','AC_ACCOUNT');
INSERT INTO KJOBS VALUES('영업 부장','SA_MAN');
INSERT INTO KJOBS VALUES('판매 직원','SA_REP');
INSERT INTO KJOBS VALUES('구매부 이사','PU_MAN');
INSERT INTO KJOBS VALUES('구매부 사원','PU_CLERK');
INSERT INTO KJOBS VALUES('창고 사원','ST_CLERK');
INSERT INTO KJOBS VALUES('운송 사원','SH_CLERK');
INSERT INTO KJOBS VALUES('프로그래머','IT_PROG');
INSERT INTO KJOBS VALUES('마케팅 매니저','MK_MAN');
INSERT INTO KJOBS VALUES('마케팅 부서 대표','MK_REP');
INSERT INTO KJOBS VALUES('인사부 대표','HR_REP');
INSERT INTO KJOBS VALUES('홍보부 대표','PR_REP');

/*
 * DEPARTMENTS 테이블에 DEPARTMENT_NAME_KR 컬럼을 추가 후 DEPARTMENT_NAME을 
 * 한글로 번역한 데이터가 수정되게 한다.
 */
SELECT * FROM DEPARTMENTS;
ALTER TABLE DEPARTMENTS ADD DEPARTMENT_NAME_KR VARCHAR2(30);
UPDATE DEPARTMENTS SET DEPARTMENT_NAME_KR = '관리부' WHERE DEPARTMENT_NAME ='Administration';
UPDATE DEPARTMENTS SET DEPARTMENT_NAME_KR = '마케팅부' WHERE DEPARTMENT_NAME ='Marketing';
UPDATE DEPARTMENTS SET DEPARTMENT_NAME_KR = '구매관리부' WHERE DEPARTMENT_NAME ='Purchasing';
UPDATE DEPARTMENTS SET DEPARTMENT_NAME_KR = '인사부' WHERE DEPARTMENT_NAME ='Human Resources';
UPDATE DEPARTMENTS SET DEPARTMENT_NAME_KR = '운송부' WHERE DEPARTMENT_NAME ='Shipping';
UPDATE DEPARTMENTS SET DEPARTMENT_NAME_KR = 'IT부' WHERE DEPARTMENT_NAME ='IT';
UPDATE DEPARTMENTS SET DEPARTMENT_NAME_KR = '홍보부' WHERE DEPARTMENT_NAME ='Public Relations';
UPDATE DEPARTMENTS SET DEPARTMENT_NAME_KR = '판매부' WHERE DEPARTMENT_NAME ='Sales';
UPDATE DEPARTMENTS SET DEPARTMENT_NAME_KR = '경영부' WHERE DEPARTMENT_NAME ='Executive';
UPDATE DEPARTMENTS SET DEPARTMENT_NAME_KR = '재무부' WHERE DEPARTMENT_NAME ='Finance';
UPDATE DEPARTMENTS SET DEPARTMENT_NAME_KR = '경리부' WHERE DEPARTMENT_NAME ='Accounting';
UPDATE DEPARTMENTS SET DEPARTMENT_NAME_KR = '자금부' WHERE DEPARTMENT_NAME ='Treasury';
UPDATE DEPARTMENTS SET DEPARTMENT_NAME_KR = '세무본부' WHERE DEPARTMENT_NAME ='Corporate Tax';
UPDATE DEPARTMENTS SET DEPARTMENT_NAME_KR = '자산운용' WHERE DEPARTMENT_NAME ='Control And Credit';
UPDATE DEPARTMENTS SET DEPARTMENT_NAME_KR = '주주서비스' WHERE DEPARTMENT_NAME ='Shareholder Services';
UPDATE DEPARTMENTS SET DEPARTMENT_NAME_KR = '복지' WHERE DEPARTMENT_NAME ='Benefits';
UPDATE DEPARTMENTS SET DEPARTMENT_NAME_KR = '제조' WHERE DEPARTMENT_NAME ='Manufacturing';
UPDATE DEPARTMENTS SET DEPARTMENT_NAME_KR = '건축' WHERE DEPARTMENT_NAME ='Construction';
UPDATE DEPARTMENTS SET DEPARTMENT_NAME_KR = '계약' WHERE DEPARTMENT_NAME ='Contracting';
UPDATE DEPARTMENTS SET DEPARTMENT_NAME_KR = '동작' WHERE DEPARTMENT_NAME ='Operations';
UPDATE DEPARTMENTS SET DEPARTMENT_NAME_KR = 'IT지원' WHERE DEPARTMENT_NAME ='IT Support';
UPDATE DEPARTMENTS SET DEPARTMENT_NAME_KR = '네트워크운영센터 ' WHERE DEPARTMENT_NAME ='NOC';
UPDATE DEPARTMENTS SET DEPARTMENT_NAME_KR = 'IT헬프데스크' WHERE DEPARTMENT_NAME ='IT Helpdesk';
UPDATE DEPARTMENTS SET DEPARTMENT_NAME_KR = '정부판매' WHERE DEPARTMENT_NAME ='Government Sales';
UPDATE DEPARTMENTS SET DEPARTMENT_NAME_KR = '소매판매' WHERE DEPARTMENT_NAME ='Retail Sales';
UPDATE DEPARTMENTS SET DEPARTMENT_NAME_KR = '채용' WHERE DEPARTMENT_NAME ='Recruiting';
UPDATE DEPARTMENTS SET DEPARTMENT_NAME_KR = '급여' WHERE DEPARTMENT_NAME ='Payroll';
UPDATE DEPARTMENTS SET DEPARTMENT_NAME_KR = '서버' WHERE DEPARTMENT_NAME ='Server';
UPDATE DEPARTMENTS SET DEPARTMENT_NAME_KR = '네트워크' WHERE DEPARTMENT_NAME ='Network';

/*
 *  KJOBS 테이블에 한글로 번역한 직무 타이틀을 JOBS 테이블에 JOB_TITLE_KR 컬럼을
 * 추가 후 수정이 되도록 한다.(DEPARTMENTS 테이블 처럼하나의 테이블에 영문/한글이 모두
 * 들어가게 한다.) 모든 작업을 완료 후 KJOBS 테이블은 제거 한다.
 */

ALTER TABLE JOBS ADD JOB_TITLE_KR VARCHAR2(50);
ALTER TABLE KJOBS DROP  COLUMN JOB_TITLE_KR;

SELECT * FROM JOBS;
SELECT * FROM KJOBS;


UPDATE JOBS 
   SET JOB_TITLE_KR =(SELECT JOB_ID FROM KJOBS K WHERE K.JOB_TITLE  =JOBS.JOB_ID);
DROP TABLE KJOBS ;
   
  UPDATE JOBS SET JOB_TITLE_KR = '인턴 프로그래머' WHERE JOB_ID ='IT_ITRN';
UPDATE JOBS SET JOB_TITLE_KR = '서버 매니저' WHERE JOB_ID ='SV_MGR';
UPDATE JOBS SET JOB_TITLE_KR = '서버 엔지니어' WHERE JOB_ID ='SV_ENG';
UPDATE JOBS SET JOB_TITLE_KR = '네트워크 매니저' WHERE JOB_ID ='NT_MGR';
UPDATE JOBS SET JOB_TITLE_KR = '네트워크 엔지니어' WHERE JOB_ID ='NT_ENG';

SELECT * FROM JOBS;



/*
 * JOBS 테이블에 다음의 데이터를 추가 한다.(JOB_TITLE_KR도 추가되어 있어야함)
 * JOB_ID		JOB_TITLE			MIN_SALARY		MAX_SALARY
 * IT_ITRN		Intern_Programmer	3200			3800
 * SV_MGR		Server Manager		4000			10000
 * SV_ENG		Server Engineer		6000			12000
 * NT_MGR		Network Manager 	5000			11000
 * NT_ENG		Network Engineer 	7000			13000
 */
INSERT INTO JOBS (JOB_ID,JOB_TITLE,MIN_SALARY,MAX_SALARY) VALUES('IT_ITRN','Intern_Programmer',3200,3800);
INSERT INTO JOBS (JOB_ID,JOB_TITLE,MIN_SALARY,MAX_SALARY) VALUES('SV_MGR','Server Manager',4000,10000);
INSERT INTO JOBS (JOB_ID,JOB_TITLE,MIN_SALARY,MAX_SALARY) VALUES('SV_ENG','Server Engineer',6000,12000);
INSERT INTO JOBS (JOB_ID,JOB_TITLE,MIN_SALARY,MAX_SALARY) VALUES('NT_MGR','Network Manager',5000,11000);
INSERT INTO JOBS (JOB_ID,JOB_TITLE,MIN_SALARY,MAX_SALARY) VALUES('NT_ENG','Network Engineer',7000,13000);




/*
 * DEPARTMENTS 테이블에 다음의 데이터를 추가 한다.(DEPARTMENT_NAME_KR도 추가되어 있어야 함)
 * DEPARTMENT_ID 	DEPATRMENT_NAME		MANAGER_ID	LOCATION_ID
 * 280				Server				NULL		3000
 * 290				Network				NULL		3000
 */
CREATE SEQUENCE SEQ2
  	 START WITH 280
      INCREMENT BY 10;
              							--SEQ2.NEXTVAL
INSERT INTO DEPARTMENTS  VALUES((SELECT (MAX(DEPARTMENT_ID)+10) FROM DEPARTMENTS),'Server',NULL,3000,'서버');
INSERT INTO DEPARTMENTS VALUES((SELECT (MAX(DEPARTMENT_ID)+10) FROM DEPARTMENTS),'Network',NULL,3000,'네트워크');

SELECT * FROM DEPARTMENTS ;

/*
 * 새로 신설된 Server, Network 부서를 위한 인력을 충원하고 있는 것으로 가정하여 각 부서마다
 * 3명의 인원을 EMPLOYEES 에 추가한다.(Manager 직무 1명, Engineer 직무 2명)
 * 		- 초기에 모든 인원을 JOBS테이블에 MIN_SALARY의 급여를 받는 것으로 한다.
 * 		- Server, Network 부서에 인원을 추가 할 때 만드시 1명의 부서장이 필요하기 때문에 인원중 1명을 
 * 		  부서장으로 만든다.(DEPARTMENTS 테이블의 MANAGER_ID를 설정한다.)
 * 		- 부서장으로 선택된 인원은 JOBS 테이블의 MIN_SALARY 급여에서 +2000상승된 급여로 받을 수 있게
 * 		  데이터를 수정한다.
 */
SELECT * FROM JOBS;
SELECT * FROM DEPARTMENTS;
SELECT * FROM EMPLOYEES ;

CREATE SEQUENCE SEQ
          START WITH 207;
 									-- SEQ.NEXTVAL
INSERT INTO EMPLOYEES VALUES((SELECT (MAX(EMPLOYEE_ID)+1) FROM EMPLOYEES),'Arnold','Cecil','Arn',NULL,SYSDATE,'SV_MGR',4000,NULL,NULL,280);
INSERT INTO EMPLOYEES VALUES((SELECT (MAX(EMPLOYEE_ID)+1) FROM EMPLOYEES),'Erica','Florence ','Eri',NULL,SYSDATE,'SV_ENG',6000,NULL,NULL,280);
INSERT INTO EMPLOYEES VALUES((SELECT (MAX(EMPLOYEE_ID)+1) FROM EMPLOYEES),'Daniel','Edgar  ','Dan',NULL,SYSDATE,'SV_ENG',6000,NULL,NULL,280);

INSERT INTO EMPLOYEES VALUES((SELECT (MAX(EMPLOYEE_ID)+1) FROM EMPLOYEES),'Edward ','Eugene ','Edw',NULL,SYSDATE,'NT_MGR',5000,NULL,NULL,290);
INSERT INTO EMPLOYEES VALUES((SELECT (MAX(EMPLOYEE_ID)+1) FROM EMPLOYEES),'Henry','Kenneth','Hen',NULL,SYSDATE,'NT_ENG',7000,NULL,NULL,290);
INSERT INTO EMPLOYEES VALUES((SELECT (MAX(EMPLOYEE_ID)+1) FROM EMPLOYEES),'Julia','Linney  ','Juli',NULL,SYSDATE,'NT_ENG',7000,NULL,NULL,290);


UPDATE EMPLOYEES SET MANAGER_ID =100 WHERE EMPLOYEE_ID =207;
UPDATE EMPLOYEES SET MANAGER_ID =207 WHERE EMPLOYEE_ID =208;
UPDATE EMPLOYEES SET MANAGER_ID =207 WHERE EMPLOYEE_ID =209;


UPDATE EMPLOYEES SET MANAGER_ID =100 WHERE EMPLOYEE_ID =210;
UPDATE EMPLOYEES SET MANAGER_ID =210 WHERE EMPLOYEE_ID =211;
UPDATE EMPLOYEES SET MANAGER_ID =210 WHERE EMPLOYEE_ID =212;


UPDATE EMPLOYEES  SET SALARY  =SALARY+2000 WHERE EMPLOYEE_ID =207 ;
UPDATE EMPLOYEES SET SALARY=SALARY+2000 WHERE EMPLOYEE_ID =210 ;

/*
 * 물가 상승분을 반영하여 모든 급여 정보를 수정하려고 한다.
 * JOBS 테이블과 EMPLOYEES 테이블의 모든 급여 정보를 기존보다 5%~10% 상승시키도록 한다.
 * 		- 급여가 4000미만인 경우 10%상승
 * 		- 급여가 4000이상 8000미만인 경우 8% 상승
 * 		- 급여가 8000이상 12000미만인 경우 6% 상승
 * 		- 급여가 12000이상인 경우 5% 상승
 * 		- 정수 1번째 자리에서 절삭할 것. 예) 4333.333.은 4330
 */

SELECT * FROM JOBS ;

UPDATE JOBS
   SET (MIN_SALARY, MAX_SALARY) = (SELECT CASE WHEN MIN_SALARY <4000 THEN FLOOR(MIN_SALARY *1.1)
											   WHEN MIN_SALARY <8000 THEN FLOOR(MIN_SALARY *1.08)
											   WHEN MIN_SALARY <12000 THEN FLOOR(MIN_SALARY *1.06)
											   ELSE FLOOR(MIN_SALARY*1.05)
									      END AS MIN_SALARY
										, CASE WHEN MAX_SALARY <4000 THEN FLOOR(MAX_SALARY *1.1)
										       WHEN MAX_SALARY <8000 THEN FLOOR(MAX_SALARY *1.08)
										       WHEN MAX_SALARY <12000 THEN FLOOR(MAX_SALARY *1.06)
										       ELSE FLOOR(MAX_SALARY*1.05)
										  END AS MAX_SALARY
						     	   FROM JOBS J2    												 
							      WHERE  J2.JOB_ID=JOBS.JOB_ID);
												 
UPDATE EMPLOYEES SET SALARY = (SELECT CASE WHEN SALARY <4000 THEN FLOOR(SALARY *1.1)
										   WHEN SALARY <8000 THEN FLOOR(SALARY *1.08)
										   WHEN SALARY <12000 THEN FLOOR(SALARY *1.06)
										   ELSE FLOOR(SALARY*1.05)
										   END 
								 FROM EMPLOYEES e1
								WHERE e1.EMPLOYEE_ID = EMPLOYEES.EMPLOYEE_ID );

SELECT * FROM EMPLOYEES;		 
/*
 * 사내 공지를 위한 게시판 기능을 추가하려 한다. 다음의 요구사항에 맞추어 테이블을 생성하고
 * 첫번째 공지를 작성하도록 한다.(첫번째 공지는 모든 부서가 열람할 수 있게 한다.)
 *     - 공지 게시판은 부서별 공지와 전체 공지로 나누어져 운영돼야 한다.
 *     - 전체 공지는 모든 부서가 확인할 수 있는 공지이며 부서별 공지는 지정한 부서에 소속된
 *       사원만 볼수 있는 공지이다.
 *     - 공지를 작성할 때 다음의 정보가 저장되어야 한다.
 *         번호, 제목, 내용, 작성일자, 부서ID
 */								 
CREATE TABLE 사내공지(
       번호 NUMBER
     , 제목 VARCHAR2(50)
     , 내용 VARCHAR2(300)
     , 작성일자 DATE
     , 부서ID NUMBER
);
INSERT INTO 사내공지 VALUES(1, '전체 공지입니다.', '모든 부서에서 확인할 수 있습니다.', SYSDATE, 0);

SELECT * FROM DEPARTMENTS;


/*
 * 사내 공지 게시판 테이블을 생성 후에 다음의 공지를 추가로 작성한다.
 *     - 모든 부서마다 'xxx 부서만 확인할 수 있는 공지 입니다.' 라는 메시지를 추가한다.
 */

SELECT * FROM 사내공지;


INSERT INTO 사내공지(
       SELECT ROWNUM + 1 AS ID
            , DEPARTMENT_NAME_KR || ' 부서 공지' AS TITLE
            , DEPARTMENT_NAME_KR || ' 부서만 확인할 수 있는 공지 입니다.' AS CONTENT
            , SYSDATE AS WRITE_DATE
            , DEPARTMENT_ID AS DEPT_ID
         FROM DEPARTMENTS
);

/*
 * 100 번 사원이 공지를 열람한다는 가정하에 100 번 사원이 소속된 부서의 공지와 전체 공지가
 * 보일수 있는 SELECT 쿼리문을 작성하세요.
 */
SELECT * 
  FROM 사내공지 
 WHERE 부서ID=(SELECT DEPARTMENT_ID  FROM EMPLOYEES WHERE EMPLOYEE_ID =100) OR 부서ID=0; 
  
 
SELECT *
  FROM 사내공지 D
  LEFT OUTER JOIN EMPLOYEES E 
    ON D.부서ID =E.DEPARTMENT_ID 
 WHERE E.EMPLOYEE_ID =100
 	OR D.부서ID=0;
				/*
 * 공지 게시판에 중요도 기능을 추가하여 가장 중요한 공지가 가장 먼저 조회될 수 있도록 테이블을
 * 수정하도록 한다.
 *     - 중요도는 1 ~ 5 까지 사용할 수 있게 한다.
 *     - 중요도를 설정하지 않으면 기본 3으로 저장되게 한다.
 *     - 전체 공지용으로 중요도 1 ~ 5 까지 총 5개의 공지 데이터를 추가한다.
 *     - 추가한 공지 데이터를 조회할 때 중요도 순으로 조회가 될 수 있도록
 *       SELECT 구문을 작성한다.
 */				 
 
ALTER TABLE 사내공지 ADD 중요도 NUMBER DEFAULT 3;
ALTER TABLE 사내공지 ADD CONSTRAINT 사내공지_중요도_CK CHECK(중요도 BETWEEN 1 AND 5); 
ALTER TABLE 사내공지 DROP CONSTRAINT 사내공지_중요도_CK;
							
SELECT * FROM USER_CONSTRAINTS WHERE TABLE_NAME ='사내공지';

UPDATE 사내공지
   SET 중요도 =1
 WHERE 부서ID=0;

SELECT * FROM 사내공지;

SELECT 번호
	 , 제목
	 , 내용
	 , 작성일자
	 , 부서ID
  FROM (SELECT 번호
  			 , 제목
  			 , 내용
  			 , 작성일자
  			 , 부서ID
  			 , 중요도
  			 , RANK() OVER(ORDER BY 중요도, 번호) AS 순위
  		  FROM 사내공지)
  ORDER BY 순위;



/*
 * DEPARTMENTS 테이블에서 MANAGER_ID가 없는 부서는 삭제하도록 한다.
 * NOTICE 테이블도 삭제할 부서의 공지사항이 삭제되도록 한다.
 */
 
 DELETE 
   FROM 사내공지 
  WHERE 부서ID IN(SELECT DEPARTMENT_ID 
                   FROM DEPARTMENTS 
                  WHERE MANAGER_ID IS NULL); 

                 
DELETE FROM DEPARTMENTS WHERE MANAGER_ID IS NULL;

SELECT * FROM DEPARTMENTS ; 
 
SELECT TABLE_NAME
  FROM USER_CONSTRAINTS
 WHERE CONSTRAINT_NAME='EMP_DEPT_FK';

/*
  * EMPLOYEES 테이블의 COMMISSION_PCT가 NULL인 경우 0으로 수정한다.
  */
UPDATE EMPLOYEES 
   SET COMMISSION_PCT = 0 
 WHERE COMMISSION_PCT IS NULL;		

SELECT* FROM EMPLOYEES;
 /*
  * EMPLOYEES 테이블의 MANAGER_ID가 없는 사원은 DEPARTMENT_ID에 해당하는 부서 
  * 정보를 찾아서 해당 부서의 MANAGER_ID 값이 EMPLOYEES 테이블의 MANAGER_ID 가 되도록 수정한다.
  */


SELECT DEPARTMENT_ID  FROM EMPLOYEES WHERE MANAGER_ID IS NULL;
SELECT MANAGER_ID FROM DEPARTMENTS WHERE DEPARTMENT_ID =90;

UPDATE EMPLOYEES 
   SET EMPLOYEES.MANAGER_ID =(SELECT D.MANAGER_ID 
                                FROM DEPARTMENTS D
                               WHERE D.DEPARTMENT_ID =EMPLOYEES.DEPARTMENT_ID)
 WHERE EMPLOYEES.MANAGER_ID IS NULL;

SELECT * FROM DEPARTMENTS;
SELECT * FROM EMPLOYEES;


  /*
   * EMPLOYEES 테이블의 DEPARTMENT_ID가 없는 사원은 MANAGER_ID에 해당하는 사원 정보를 찾아서
   * 해당 사원의 DEPARTMENT_ID 값이 EMPLOYEES 테이블의 DEPARTMENT_ID가 되도록 수정한다.
   */

SELECT * FROM EMPLOYEES;

UPDATE EMPLOYEES E 
   SET E.DEPARTMENT_ID = (SELECT E2.DEPARTMENT_ID 
                            FROM EMPLOYEES E2
                           WHERE E2.EMPLOYEE_ID=E.MANAGER_ID)
 WHERE E.DEPARTMENT_ID IS NULL;




  	
  
  
  
  
  
  