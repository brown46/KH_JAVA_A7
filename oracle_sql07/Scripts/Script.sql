CREATE TABLE VISIT_T(
	   nickname VARCHAR2(30 CHAR)
	 , context VARCHAR2(1000 CHAR)
     , createdate DATE DEFAULT(SYSDATE)
     
);

INSERT INTO VISIT_T VALUES('내용 작성',DEFAULT);

SELECT *FROM VISIT_T;


DROP TABLE VISIT_T;

SELECT * FROM BOOKMARK_T;
DROP TABLE BOOKMARK_T;

CREATE TABLE BOOKMARK_T(
	   url VARCHAR2(100)
	 , name VARCHAR2(100)
);


INSERT INTO BOOKMARK_T VALUES('https://naver.com','네이버');
INSERT INTO BOOKMARK_T VALUES('https://google.com','구글');

SELECT * FROM BOOKMARK_T;



