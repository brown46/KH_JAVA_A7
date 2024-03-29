CREATE TABLE VISIT_T(
	   id VARCHAR2(30 CHAR) REFERENCES USER_T(USERID)
	 , context VARCHAR2(1000 CHAR) NOT NULL
     , createdate DATE DEFAULT(SYSDATE)
);

INSERT INTO VISIT_T VALUES('아이디','내용 작성',DEFAULT);



SELECT *FROM VISIT_T;


SELECT * 
  FROM(
    SELECT ROWNUM AS N 
	     , ID
	     , CONTEXT
	 	 , CREATEDATE
	  FROM (SELECT *FROM VISIT_T ORDER BY CREATEDATE DESC)
	  )
WHERE N BETWEEN 11 AND 15;


SELECT COUNT(*) FROM VISIT_T ;

/** 
SELECT ROWNUM
	     , EMPLOYEE_ID
	     , FIRST_NAME
	     , LAST_NAME
	     , SALARY
	  FROM (SELECT EMPLOYEE_ID
	  			 , FIRST_NAME
	  			 , LAST_NAME
  			 , SALARY
          FROM EMPLOYEES
         ORDER BY SALARY DESC)
 WHERE ROWNUM<=10;
 */
	
SELECT COUNT(*) FROM BOOKMARK_T WHERE USERID='1234';

DROP TABLE VISIT_T;

SELECT * FROM BOOKMARK_T;
DROP TABLE BOOKMARK_T;


CREATE TABLE BOOKMARK_T(
	   ID NUMBER PRIMARY KEY
	 , USERID VARCHAR2(20) REFERENCES USER_T(USERID)
	 , URL VARCHAR2(100)
	 , NAME VARCHAR2(100)
);

INSERT INTO BOOKMARK_T VALUES(1,'아이디' ,'https://naver.com','네이버');
INSERT INTO BOOKMARK_T VALUES(2,'아이디','https://google.com','구글');

INSERT INTO BOOKMARK_T VALUES(3,'1234' ,'https://nate.com','네이트');
INSERT INTO BOOKMARK_T VALUES(4,'1234','https://daum.net','구글');
CREATE TABLE USER_T(
	   USERID   VARCHAR2(20) PRIMARY KEY
	 , PASSWORD VARCHAR2(20) NOT NULL
	 , EMAIL    VARCHAR2(100)
);

SELECT ID, USERID, URL, NAME FROM BOOKMARK_T WHERE USERID ='아이디'


SELECT * FROM BOOKMARK_T;

SELECT * FROM USER_T;


SELECT *
   FROM(SELECT ROWNUM AS N
   			 , ID
   			 , USERID
             , URL
             , NAME 
          FROM (SELECT * FROM BOOKMARK_T WHERE USERID = '아이디' ORDER BY ID)
        )WHERE N BETWEEN 1 AND 5;
   

SELECT * FROM BOOKMARK_T ORDER BY ID;


INSERT INTO BOOKMARK_T VALUES(9,'아이디','https://google.com','구글');
INSERT INTO BOOKMARK_T VALUES(10,'아이디','https://google.com','구글');
INSERT INTO BOOKMARK_T VALUES(11,'아이디','https://google.com','구글');
INSERT INTO BOOKMARK_T VALUES(12,'아이디','https://google.com','구글');
INSERT INTO BOOKMARK_T VALUES(13,'아이디','https://google.com','구글');
INSERT INTO BOOKMARK_T VALUES(14,'아이디','https://google.com','구글');
INSERT INTO BOOKMARK_T VALUES(15,'아이디','https://google.com','구글');
INSERT INTO BOOKMARK_T VALUES(16,'아이디','https://google.com','구글');
INSERT INTO BOOKMARK_T VALUES(17,'아이디','https://google.com','구글');
INSERT INTO BOOKMARK_T VALUES(18,'아이디','https://google.com','구글');
INSERT INTO BOOKMARK_T VALUES(19,'아이디','https://google.com','구글');
INSERT INTO BOOKMARK_T VALUES(20,'아이디','https://google.com','구글');
INSERT INTO BOOKMARK_T VALUES(21,'아이디','https://google.com','구글');
INSERT INTO BOOKMARK_T VALUES(22,'아이디','https://google.com','구글');
INSERT INTO BOOKMARK_T VALUES(23,'아이디','https://google.com','구글');
INSERT INTO BOOKMARK_T VALUES(24,'아이디','https://google.com','구글');



/**
 * 공지사항이 있는 게시판
 * btype의 값이 N인 경우 공지사항, B인 경우 일반 게시무로 합니다.
 */
CREATE TABLE BOARD_T(
	   id NUMBER PRIMARY KEY
	 , btype VARCHAR2(1) CHECK(btype IN ('N', 'B')) NOT NULL
     , title VARCHAR2(500) NOT NULL
     , context VARCHAR2(4000) NOT NULL
     , writer VARCHAR2(20) REFERENCES USER_T(USERID)
	 , createDate DATE DEFAULT(SYSDATE)
	 , updateDate DATE DEFAULT(SYSDATE)
	 , viewCnt NUMBER DEFAULT(0)
);

CREATE SEQUENCE BOARD_S NOCACHE; 
DROP SEQUENCE BOARD_S;


INSERT INTO BOARD_T VALUES(BOARD_S.NEXTVAL,'B','게시글 테스트','게시판 글 작성 테스트',
									'1234',DEFAULT,DEFAULT,DEFAULT);
INSERT INTO BOARD_T VALUES(BOARD_S.NEXTVAL,'B','게시글 테스트','게시판 글 작성 테스트2',
									'1234',DEFAULT,DEFAULT,DEFAULT);
INSERT INTO BOARD_T VALUES(BOARD_S.NEXTVAL,'B','게시글 테스트','게시판 글 작성 테스트3',
									'1234',DEFAULT,DEFAULT,DEFAULT);
INSERT INTO BOARD_T VALUES(BOARD_S.NEXTVAL,'B','게시글 테스트','게시판 글 작성 테스트4',
									'1234',DEFAULT,DEFAULT,DEFAULT);								
INSERT INTO BOARD_T VALUES(BOARD_S.NEXTVAL,'N','공지글 테스트','공지글 작성 테스트',
									'1234',DEFAULT,DEFAULT,DEFAULT);
INSERT INTO BOARD_T VALUES(BOARD_S.NEXTVAL,'N','공지글 테스트','공지글 작성 테스트2',
									'1234',DEFAULT,DEFAULT,DEFAULT);
INSERT INTO BOARD_T VALUES(BOARD_S.NEXTVAL,'B','게시글 테스트','게시판 글 작성 테스트5',
									'1234',DEFAULT,DEFAULT,DEFAULT);
INSERT INTO BOARD_T VALUES(BOARD_S.NEXTVAL,'B','게시글 테스트','게시판 글 작성 테스트6',
									'1234',DEFAULT,DEFAULT,DEFAULT);								
INSERT INTO BOARD_T VALUES(BOARD_S.NEXTVAL,'B','게시글 테스트','게시판 글 작성 테스트7',
									'1234',DEFAULT,DEFAULT,DEFAULT);								
INSERT INTO BOARD_T VALUES(BOARD_S.NEXTVAL,'N','공지글 테스트','공지글 작성 테스트3',
									'1234',DEFAULT,DEFAULT,DEFAULT);
INSERT INTO BOARD_T VALUES(BOARD_S.NEXTVAL,'N','공지글 테스트','공지글 작성 테스트4',
									'1234',DEFAULT,DEFAULT,DEFAULT);
INSERT INTO BOARD_T VALUES(BOARD_S.NEXTVAL,'N','공지글 테스트','공지글 작성 테스트5',
									'1234',DEFAULT,DEFAULT,DEFAULT);	
DROP TABLE	BOARD_T;							
SELECT * FROM BOARD_T;



SELECT id, btype, title, writer, createDate, viewCnt
   FROM(SELECT ROWNUM AS N
   			 , id
   			 , btype
   			 , title
             , writer
             , createDate 
             , viewCnt
          FROM (SELECT id, btype, title, writer, createDate, viewCnt FROM BOARD_T ORDER BY btype DESC, id)
        )WHERE N BETWEEN 6 AND 10;
   