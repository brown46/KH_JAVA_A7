/*
 * 다음의 테이블을 생성한다.
 * 		- 회원 테이블 : 회원으로 가입된 사용자의 정보가 기록되는 테이블
 * 		- 회원 요청 테이블 : 회원 가입을 위해 가입 요청을 한 사용자의 정보가 기록되는 테이블 
 * 		- 접속 이력 테이블 : 로그인 및 로그아웃한 회원의 접속 시간을 기록하기 위한 테이블
 * 	
 * 1. 회원 가입 요청에는 최소한 "닉네임"과 "이메일" 정보가 필요합니다.
 * 2. 관리가자 회원 가입을 승낙하면 회원가입 요청 테이블의 데이터를 기반으로 회원테이블의 
 *    데이터가 생성됩니다.
 * 3. 회원 테이블의 데이터가 생성될 때 초기 패스워드로 "samplepassword" 가 저장되야 합니다.
 * 4. 회원은 닉네임과 패스워드를 사용하여 로그인을 할 수 있으며 로그인 기록은 접속 이력 테이블에
 * 	  저장되야 합니다.(로그아웃도 접속 이력 테이블에 저장되야 합니다.)
 * 5. 접속 이력 정보는 최소한 누가, 언제 접속했는지 기록될 수 있어야 합니다.
 * 6. 회원 테이블에 최근 로그인 날짜를 기록하여 로그인을 할 때마다 "n일만에 다시 접속하셨습니다."
 * 	  또는 "n개월 만에 다시 접속하셨습니다." 와 같은 정보가 생성될 수 있게 합니다.
 */

CREATE TABLE 회원테이블(
	   ID VARCHAR2(10) PRIMARY KEY
	 , PW VARCHAR2(20) DEFAULT('samplepassword')
	 , EMAIL VARCHAR2(40) UNIQUE
	 , LATDATE DATE 
);
DROP TABLE 회원테이블;

CREATE TABLE 회원요청테이블(
	   AID VARCHAR2(10) PRIMARY KEY
	 , APW VARCHAR2(20)
	 , AEMAIL VARCHAR2(40)
	 , ADATE DATE
	 , ASTATE VARCHAR2(2)
);
DROP TABLE 회원요청테이블;

CREATE TABLE 접속이력테이블(
	   HID VARCHAR2(10)
	 , INDATE DATE
	 , OUTDATE DATE
);
DROP TABLE 접속이력테이블;

CREATE TABLE 현재접속자(
	   CRID VARCHAR2(10)
);
DROP TABLE 현재접속자;



CREATE OR REPLACE PROCEDURE SIGNUP(
	   SUID VARCHAR2
	 , SUPW VARCHAR2
	 , SUMAIL VARCHAR2
)
IS 
BEGIN 
	INSERT INTO 회원요청테이블 VALUES(SUID, SUPW, SUMAIL, SYSDATE, 'F');
EXCEPTION 
	WHEN DUP_VAL_ON_INDEX THEN
	DBMS_OUTPUT.PUT_LINE('이미 등록요청된 사용자입니다.');
END;

SELECT * FROM USER_ERRORS;


CREATE OR REPLACE TRIGGER 요청승인
AFTER UPDATE OF ASTATE ON 회원요청테이블 
FOR EACH ROW 
BEGIN 
	IF :NEW.ASTATE ='T' THEN 
		INSERT INTO 회원테이블 VALUES(:NEW.AID,:NEW.APW,:NEW.AEMAIL,NULL);
	END IF;
END;




SELECT (1+2)/2 FROM DUAL; 

SELECT (SYSDATE - TO_DATE(20221201))*24*60 FROM DUAL;


CREATE OR REPLACE PROCEDURE LOG_IN(
	   PID VARCHAR2
	 , PPW VARCHAR2
)
IS
	RPW VARCHAR2(20);
	RDATE DATE;
	CUSER NUMBER;
BEGIN 
	SELECT PW INTO RPW FROM 회원테이블 WHERE ID = PID;
	SELECT LATDATE INTO RDATE FROM 회원테이블 WHERE ID = PID;
	SELECT COUNT(*) INTO CUSER FROM 현재접속자 WHERE CRID= PID;
	IF PPW <> RPW THEN
		DBMS_OUTPUT.PUT_LINE('비밀번호가 일치하지 않습니다.');
	ELSE 
		IF CUSER=0 THEN
			DBMS_OUTPUT.PUT_LINE('로그인 성공');
			IF	RDATE IS NOT NULL THEN
				IF SYSDATE - RDATE>=1 THEN
					DBMS_OUTPUT.PUT_LINE(TO_CHAR(SYSDATE - RDATE) ||'일 만에 로그인 하셨습니다.');
				ELSE
					DBMS_OUTPUT.PUT_LINE(TO_CHAR((SYSDATE - RDATE)*24*60 )||'분 만에 로그인 하셨습니다.');
				END IF;
			END IF;
			INSERT INTO 현재접속자 VALUES(PID);
			UPDATE 회원테이블 SET LATDATE = SYSDATE WHERE ID =PID;
		ELSE
			DBMS_OUTPUT.PUT_LINE('이미 접속된 사용자 입니다.');
		END IF;
	END IF;
EXCEPTION
	WHEN NO_DATA_FOUND	THEN
		DBMS_OUTPUT.PUT_LINE('일치하는 아이디가 없습니다.');
END;

DROP PROCEDURE LOG_IN;





CREATE OR REPLACE PROCEDURE LOGOUT(
	   PID VARCHAR2
)
IS
	CNT NUMBER;
	CID VARCHAR2(10);
BEGIN 
	SELECT ID INTO CID FROM 회원테이블 WHERE ID= PID;
	SELECT COUNT(*) INTO CNT FROM 현재접속자 WHERE CRID= PID;
	IF CNT=0 THEN 
		DBMS_OUTPUT.PUT_LINE('로그인된 상태가 아닙니다');
	ELSE 
		DBMS_OUTPUT.PUT_LINE('로그아웃 성공');
		DELETE FROM 현재접속자 WHERE CRID= PID;
	END IF;	
EXCEPTION
	WHEN NO_DATA_FOUND	THEN
		DBMS_OUTPUT.PUT_LINE('일치하는 아이디가 없습니다.');
END;
SELECT * FROM USER_ERRORS;

SELECT * FROM ALL_TRIGGERS;


CREATE OR REPLACE TRIGGER 접속이력1
AFTER DELETE ON 현재접속자 
FOR EACH ROW 
BEGIN 
	INSERT INTO 접속이력테이블 VALUES(:OLD.CRID,NULL,SYSDATE);
END;

CREATE OR REPLACE TRIGGER 접속이력2
AFTER INSERT ON 현재접속자 
FOR EACH ROW 
BEGIN 
	INSERT INTO 접속이력테이블 VALUES(:NEW.CRID,SYSDATE,NULL);
END;






-- 회원가입 요청
BEGIN
	SIGNUP('A','AAA','AAA@MAIL.COM');
END;

BEGIN
	SIGNUP('B','BBB','BBB@MAIL.COM');
END;

SELECT * FROM 회원요청테이블;


--요청승인
UPDATE 회원요청테이블 SET ASTATE='T' WHERE AID='A';
UPDATE 회원요청테이블 SET ASTATE='T' WHERE AID='B';

--TRIGGER동작확인
SELECT * FROM 회원테이블;

--로그인확인
BEGIN 
	LOG_IN('A1','AA');
END;
BEGIN 
	LOG_IN('A','AA');
END;
BEGIN 
	LOG_IN('A','AAA');
END;
BEGIN 
	LOG_IN('B','BBB');
END;

--현재접속자
SELECT * FROM 현재접속자;

--접속이력 확인
SELECT * FROM 접속이력테이블;

DROP TABLE 접속이력테이블;
--로그아웃 확인
BEGIN 
	LOGOUT('AA');
END;

BEGIN 
	LOGOUT('A');
END;
BEGIN 
	LOGOUT('B');
END;

--다시로그인
BEGIN 
	LOG_IN('B','BBB');
END;
BEGIN 
	LOG_IN('A','AAA');
END;


/*
 * 회원이 암호 변경을 했을 때 암호를 변경하기 위한 수정 구문
 */

/*
 * 회원이 암호를 변경할 때 현재 사용중인 암호가 새로운 암호에 포함되지 않게 하기 위한 구문
 */

