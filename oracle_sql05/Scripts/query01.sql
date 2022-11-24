/*
 * SEQUENCE 객체
 *		- 번호 발생기 객체
 *		- 정수값을 순차적으로 생성하는 객체
 *		- PRIMARY KEY로 사용하는 번호(ID)등에 사용하여 정수값을 생성하기 위한 
 *		  용도로 많이 사용
 */
CREATE SEQUENCE SEQ1
          START WITH 10
      INCREMENT BY 10
       MAXVALUE 100
       MINVALUE 10
          CYCLE
        NOCACHE;
		--10부터 10씩증가 최소 10 최대 100. 순환
       --NOCACHE: 미리 생성할 정수값 수량. 속도가 빠름. 오류가 생길 수 있음

ALTER SEQUENCE SEQ1
     INCREMENT BY 5
      MAXVALUE 250
      MINVALUE -100
       NOCYCLE
       NOCACHE;
       
DROP SEQUENCE SEQ1;

SELECT SEQ1.NEXTVAL FROM DUAL;
	  --다음 정수 값
SELECT SEQ1.CURRVAL FROM DUAL;
      --현재 정수 값

CREATE SEQUENCE SEQ_TEMP;
CREATE TABLE TEMP(
	   ID NUMBER PRIMARY KEY
);
INSERT INTO TEMP VALUES(SEQ_TEMP.NEXTVAL);
UPDATE TEMP
   SET ID =SEQ_TEMP.NEXTVAL
 WHERE ID = 5;
SELECT * FROM TEMP;
--MAX()안써도될듯

/*
 * NEXTVAL, CURRVAL 을 사용할 수 있는 명령어
 * 		1. SELECT 문(서브쿼리아님)
 * 		2. INSERT 문의 VALUES절
 * 		3. INSERT 문의 SELECT절 
 * 		4. UPDATE 문의 SET절
 * 
 *  NEXTVAL, CURRVAL 을 사용할 수 없는 명령어
 * 		1. VIEW 를 사용하는 SELECT
 * 		2. DISTINCT 키워드가 있는 SELECT
 * 		3. GROUP BY, HAVING, ORDER BY 가 있는 SELECT
 * 		4. SELECT, DELETE, UPDATE의 서브쿼리
 * 		5. CREATE TABLE, ALTER TABLE 에서 사용하는 DEFAULT값
 * 
 * 
 */



