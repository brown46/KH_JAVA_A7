/*
 * 가계부 작성을 위한 테이블을 생성하고 데이터를 추가 하세요
 * 
 * 가계부 테이블에는 ID, 입급/출금구분, 금액, 날짜, 지출구분, 비고 정보가 저장될 수 있도록 합니다.
 * 	-ID 는 레코드를 식별하기 위한 식별 값으로 사용합니다.
 * 	-입급/출금구분은 입금의 경우 'I', 출금의 경우 'O'로 사용합니다.
 * 	-지출구분은 식비, 교통비, 통신비, 물품 구입비 등 정해진 항목안에서 사용할 수 있게 합니다.
 * 	-정해진 항목 안에서 사용할 수 있도록 지출구분 테이블을 별도로 만들어 참조할 수 있게 합니다.
 * 	-비고에는 지출구분으로 작성할 수 없는 좀 더 상세한 내용을 작성하기 위해 사용합니다.
 * 
 * 지출구분 테이블에는 CODE, 항목 정보가 저장될 수 있도록 합니다.
 * 	-CODE 는 지출항목에 대응할 수 있는 5자리 영문자값으로 사용합니다.
 * 	-항목에는 식비, 교통비, 통신비 등 정해진 값을 작성합니다.
 * 
 * 최근 1년 간의 (월마다 최소 5개의 데이터를 뽑아서.) 지출내역을 참고하여 데이터를 추가해 봅니다.
 * 
 * 모든 데이터를 추가 후에는 다음의 작업을 추가로 진행합니다.
 * 	1. 월별 지출액 합계 구하기
 *  2. 월별 지출항목별 전체 합계
 *  3. 고정 지출비 테이블을 별도로 생성하여 식비, 교통비, 통신비에 해당하는 항목들만 따로 저장하기
 *  4. 통신비로 추가한 항목을 세분화 하여 통신비(기기값) 항목을 새로 추가하고 모든 통신비에서 통신비(기기값)에
 *     해당하는 비용을 따로 추가하도록 합니다.(기존 통신비에는 통신비(기기값)에 해당하는 금액을 제합니다.)
 *     정해진 기기값이 없으면 통신비의 40%가 기기값인 것으로 하세요
 */
CREATE TABLE 지출구분(
	   CODE VARCHAR2(5 CHAR)  CONSTRAINT 가계부_ID_NN NOT NULL
	 , 항목 VARCHAR2(30 CHAR)  CONSTRAINT 지출구분_항목_PK PRIMARY KEY
);	 
--DROP TABLE 지출구분;
--SELECT * FROM 지출구분;

INSERT INTO 지출구분(CODE, 항목) VALUES('FOODS','식비');
INSERT INTO 지출구분 VALUES('TRANS','교통비');
INSERT INTO 지출구분 VALUES('PHONE','통신비');
INSERT INTO 지출구분 VALUES('EDU','교육비');




CREATE TABLE 가계부(
	   ID  VARCHAR2(10 CHAR) CONSTRAINT 가계부_ID_PK PRIMARY KEY
	 , 입금출금구분 CHAR(1 CHAR) CONSTRAINT 가계부_입금출금구분_CK CHECK(입금출금구분 IN('I','O'))
	 , 금액 NUMBER DEFAULT(0)
	 , 날짜 DATE   DEFAULT(SYSDATE)
	 , 지출구분 VARCHAR2(10 CHAR) CONSTRAINT 가계부_지출구분_FK REFERENCES 지출구분(항목)
	 , 비고 VARCHAR2(100 CHAR)
);
--DROP TABLE 가계부;
--SELECT * FROM 가계부;


INSERT INTO 가계부 VALUES('4-F1','O',8000,TO_DATE(20220424),'식비','점심');
INSERT INTO 가계부 VALUES('4-T1','O',2000,TO_DATE(20220424),'교통비','등원');
INSERT INTO 가계부 VALUES('4-T2','O',2000,TO_DATE(20220424),'교통비','하원');
INSERT INTO 가계부 VALUES('4-P','O',44000,TO_DATE(20220424),'통신비','');

INSERT INTO 가계부 VALUES('5-F1','O',6000,TO_DATE(20220525),'식비','저녁');
INSERT INTO 가계부 VALUES('5-F2','O',4000,TO_DATE(20220525),'식비','군것질');
INSERT INTO 가계부 VALUES('5-T2','O',2000,TO_DATE(20220525),'교통비','등원');
INSERT INTO 가계부 VALUES('5-T3','O',2000,TO_DATE(20220525),'교통비','하원');
INSERT INTO 가계부 VALUES('5-P','O',49000,TO_DATE(20220525),'통신비','');

INSERT INTO 가계부 VALUES('6-F1','O',9000,TO_DATE(20220627),'식비','외식');
INSERT INTO 가계부 VALUES('6-T1','O',2000,TO_DATE(20220627),'교통비','등원');
INSERT INTO 가계부 VALUES('6-T2','O',2000,TO_DATE(20220627),'교통비','하원');
INSERT INTO 가계부 VALUES('6-P','O',42000,TO_DATE(20220627),'통신비','');

INSERT INTO 가계부 VALUES('7-F1','O',14000,TO_DATE(20220728),'식비','외식');
INSERT INTO 가계부 VALUES('7-T1','O',8000,TO_DATE(20220728),'교통비','등원');
INSERT INTO 가계부 VALUES('7-T2','O',8000,TO_DATE(20220728),'교통비','하원');
INSERT INTO 가계부 VALUES('7-P','O',44000,TO_DATE(20220728),'통신비','');

INSERT INTO 가계부 VALUES('8-F1','O',1000,TO_DATE(20220829),'식비','저녁');
INSERT INTO 가계부 VALUES('8-T1','O',8000,TO_DATE(20220829),'교통비','등원');
INSERT INTO 가계부 VALUES('8-T2','O',8000,TO_DATE(20220829),'교통비','하원');
INSERT INTO 가계부 VALUES('8-P','O',39000,TO_DATE(20220829),'통신비','');

INSERT INTO 가계부 VALUES('9-F1','O',8000,TO_DATE(20220930),'식비','점심');
INSERT INTO 가계부 VALUES('9-T1','O',8000,TO_DATE(20220930),'교통비','등원');
INSERT INTO 가계부 VALUES('9-T2','O',8000,TO_DATE(20220930),'교통비','하원');
INSERT INTO 가계부 VALUES('9-P','O',43000,TO_DATE(20220930),'통신비','');


INSERT INTO 가계부 VALUES('10-F1','O',8000,TO_DATE(20221031),'식비','점심');
INSERT INTO 가계부 VALUES('10-T1','O',8000,TO_DATE(20221031),'교통비','등원');
INSERT INTO 가계부 VALUES('10-T2','O',8000,TO_DATE(20221031),'교통비','하원');
INSERT INTO 가계부 VALUES('10-P','O',40000,TO_DATE(20221031),'통신비','');



INSERT INTO 가계부 VALUES('11-F1','O',8000,TO_DATE(20221101),'식비','점심');
INSERT INTO 가계부 VALUES('11-T1','O',2000,TO_DATE(20221101),'교통비','등원');
INSERT INTO 가계부 VALUES('11-T2','O',2000,TO_DATE(20221101),'교통비','하원');

INSERT INTO 가계부 VALUES('11-F2','O',12000,TO_DATE(20221102),'식비','외식');
INSERT INTO 가계부 VALUES('11-T3','O',2000,TO_DATE(20221102),'교통비','등원');
INSERT INTO 가계부 VALUES('11-T4','O',2000,TO_DATE(20221102),'교통비','하원');

INSERT INTO 가계부 VALUES('11-F3','O',6000,TO_DATE(20221103),'식비','저녁');
INSERT INTO 가계부 VALUES('11-T5','O',2000,TO_DATE(20221103),'교통비','등원');
INSERT INTO 가계부 VALUES('11-T6','O',2000,TO_DATE(20221103),'교통비','하원');

INSERT INTO 가계부 VALUES('11-F4','O',8000,TO_DATE(20221104),'식비','점심');
INSERT INTO 가계부 VALUES('11-T7','O',2000,TO_DATE(20221104),'교통비','등원');
INSERT INTO 가계부 VALUES('11-T8','O',2000,TO_DATE(20221104),'교통비','하원');
INSERT INTO 가계부 VALUES('11-E1','O',3000,TO_DATE(20221104),'교육비','용품');

INSERT INTO 가계부 VALUES('11-F5','O',4000,TO_DATE(20221108),'식비','군것질');
INSERT INTO 가계부 VALUES('11-T9','O',2000,TO_DATE(20221108),'교통비','등원');
INSERT INTO 가계부 VALUES('11-T10','O',2000,TO_DATE(20221108),'교통비','하원');

INSERT INTO 가계부 VALUES('11-F6','O',13000,TO_DATE(20221109),'식비','저녁');
INSERT INTO 가계부 VALUES('11-T11','O',2000,TO_DATE(20221109),'교통비','등원');
INSERT INTO 가계부 VALUES('11-T12','O',2000,TO_DATE(20221109),'교통비','하원');
INSERT INTO 가계부 VALUES('11-E2','O',99000,TO_DATE(20221109),'교육비','인터넷강의');


INSERT INTO 가계부 VALUES('11-F7','O',8000,TO_DATE(20221115),'식비','점심');
INSERT INTO 가계부 VALUES('11-T13','O',2000,TO_DATE(20221115),'교통비','등원');
INSERT INTO 가계부 VALUES('11-T14','O',2000,TO_DATE(20221115),'교통비','하원');
INSERT INTO 가계부 VALUES('11-E3','I',200000,TO_DATE(20221115),'교육비','훈련비');

--1.
SELECT SUM(금액) 
     , EXTRACT(MONTH FROM 날짜)
  FROM 가계부
GROUP BY EXTRACT(MONTH FROM 날짜),입금출금구분
HAVING 입금출금구분 = 'O';
--2.
SELECT SUM(금액)
	 , 지출구분 AS 지출항목
	 , EXTRACT(MONTH FROM 날짜)
FROM 가계부
GROUP BY 지출구분,EXTRACT(MONTH FROM 날짜);

--3

CREATE TABLE 고정지출비
AS
SELECT *
FROM 가계부
WHERE 지출구분 IN('식비','교통비','통신비');

SELECT * FROM 고정지출비;
DROP TABLE 고정지출비;

--4
ALTER TABLE 가계부 ADD 기기값 NUMBER;
UPDATE 가계부 SET 기기값 = 금액*0.4 WHERE 지출구분='통신비';
UPDATE 가계부 SET 금액 =금액*0.6 WHERE 지출구분='통신비';

SELECT * FROM 가계부;





SELECT * from EMPLOYEES ORDER BY DEPARTMENT_ID ;
DELETE FROM EMPLOYEES WHERE EMPLOYEE_ID =207;

SELECT * FROM EMPLOYEES WHERE CONCAT(FIRST_NAME,LAST_NAME)= '길동홍'  ;
SELECT * FROM EMPLOYEES WHERE LOWER( CONCAT(FIRST_NAME,LAST_NAME)) LIKE LOWER('%'||REPLACE('Donald OConnell',' ','')||'%') ;
SELECT * FROM EMPLOYEES WHERE LOWER(JOB_ID) LIKE LOWER('%st%') ;
SELECT * FROM EMPLOYEES WHERE LOWER(DEPARTMENT_ID) LIKE LOWER('%st%') ;

SELECT * FROM DEPARTMENTS ;

SELECT * FROM EMPLOYEES WHERE lower(DEPARTMENT_ID) =(SELECT DEPARTMENT_ID  FROM DEPARTMENTS WHERE LOWER(DEPARTMENT_NAME) LIKE '%it%');


SELECT DEPARTMENT_ID  FROM DEPARTMENTS WHERE DEPARTMENT_NAME LIKE '%IT%';




