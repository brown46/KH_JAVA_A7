/*
 * TRIGGER 객체
 *     - PL/SQL 구문을 사용하여 생성할 수 있는 객체
 *     - 테이블 또는 뷰에 INSERT, UPDATE, DELETE 문에 의한 변경이 발생할 경우
 *       자동으로 실행할 내용을 정의하여 실행하게 하는 객체
 *     - 변경 전/후를 구분하여 자동으로 실행할 내용을 정의할 수 있다.
 *     - 문장 트리거, 행 트리거로 나눌 수 있으며, 행 트리거의 경우 FOR EACH ROW 를
 *       작성해야 한다.
 *     - 행 트리거를 사용하게 되면 :NEW.컬럼명 또는 :OLD.컬럼명 형태를 사용할 수 있다.
 */
CREATE TABLE ORIGIN(
       ID NUMBER
     , NAME VARCHAR2(50)
);

CREATE TABLE COPY(
       ID NUMBER
     , NAME VARCHAR2(50)
);

CREATE OR REPLACE TRIGGER TRG_SAMPLE1
AFTER INSERT ON ORIGIN FOR EACH ROW
BEGIN
    INSERT INTO COPY VALUES(:NEW.ID, :NEW.NAME);
END;

CREATE OR REPLACE TRIGGER TRG_SAMPLE2
BEFORE UPDATE OF NAME ON ORIGIN FOR EACH ROW
BEGIN
    UPDATE COPY
       SET NAME = :OLD.NAME || '->' || :NEW.NAME
     WHERE ID = :NEW.ID;
    DBMS_OUTPUT.PUT_LINE('UPDATE 트리거 동작!!!');
END;

UPDATE ORIGIN
   SET ID = ID * 10
 WHERE ID = 1;

UPDATE ORIGIN
   SET NAME = 'b'
 WHERE ID = 2;

SELECT * FROM ORIGIN;
SELECT * FROM COPY;

INSERT INTO ORIGIN VALUES(3, 'C');
INSERT INTO ORIGIN(
    SELECT 4, 'D' FROM DUAL
    UNION ALL
    SELECT 5, 'E' FROM DUAL
    UNION ALL
    SELECT 6, 'F' FROM DUAL
);

SELECT * FROM USER_ERRORS;



