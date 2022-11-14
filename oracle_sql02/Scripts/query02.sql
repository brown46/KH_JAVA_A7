/*
 * 지출 내역서(가계부)를 위한 테이블을 만들어 본다.
 * 		- 테이블 이름은 '지출내역서'로 한다.
 * 		- 컬럼은 ID, 날짜, 출입구분, 금액, 비고로 만들어 사용한다.
 * 		- 비고의 경우 한글 100자까지 저장가능하게 한다.
 * 		- 출입구분은 '출','입'만 사용가능하게 한다. 
 * 		- ID는 해당 Record를 식별하기 위한 식별자로 사용할 것이다.
 */
CREATE TABLE 지출내역서(
	   ID CHAR(10 CHAR) /*CONSTRAINT 지출내역서_ID_PK PRIMARY KEY*/
	 , 날짜 DATE
	 , 출입구분 VARCHAR2(3) /*CONSTRAINT 지출내역서_출입구분_CK CHECK(출입구분 IN('출','입'));*/
	 , 금액 NUMBER 
	 , 비고 VARCHAR2(300 CHAR)
	 /*, CONSTRAINT 지출내역서_ID_PK PRIMARY KEY(ID)*/
	/* CONSTRAINT 지출내역서_출입구분_CK CHECK(출입구분 IN('출','입'))*/
);
--ALTER TABLE 지출내역서 MODIFY 비고 VARCHAR2(10 CHAR);
ALTER TABLE 지출내역서 MODIFY 출입구분 CONSTRAINT 지출내역서_출입구분_CK CHECK(출입구분 IN('출','입'));
ALTER TABLE 지출내역서 ADD CONSTRAINT 지출내역서_ID_PK PRIMARY KEY(ID);

INSERT INTO 지출내역서 VALUES('A','20221114','출',20000,'없음');
INSERT INTO 지출내역서 VALUES('B','20221114','입',30000,'없음');
INSERT INTO 지출내역서 VALUES('B','20221114','출',30000,'없음');

DELETE FROM 지출내역서 WHERE ID='B';
SELECT * FROM 지출내역서;

DROP TABLE 지출내역서;
