SET SERVEROUTPUT ON

DECLARE
    GROUPS_NUMBER PLS_INTEGER := DBMS_RANDOM.VALUE(5,12);
	GROUP_NAME VARCHAR2(15);
    COUNTER PLS_INTEGER := 0;
	
BEGIN
    DELETE FROM GROUP_FUNCTION;
    LOOP
		COUNTER := (COUNTER + 1);
		GROUP_NAME := CONCAT('Group_', COUNTER);
        INSERT INTO GROUP_FUNCTION (ID, NAME, DESCR)
            VALUES(COUNTER, GROUP_NAME,('Description of ' || GROUP_NAME));
        EXIT WHEN (COUNTER > GROUPS_NUMBER);
    END LOOP;
	COMMIT;
END;
/


SET SERVEROUTPUT ON

DECLARE
    GROUPS_TOTAL PLS_INTEGER;
    FUNCS_NUMBER PLS_INTEGER;
    COUNTER_1 PLS_INTEGER := 0;
    COUNTER_2 PLS_INTEGER := 0;
    RAND PLS_INTEGER;
	FUNC_NAME VARCHAR2(15);
    TYPE ID_LIST IS TABLE OF PLS_INTEGER;
    WORK_LIST ID_LIST := ID_LIST();
    CHECK_LIST ID_LIST := ID_LIST();
    CURSOR C_GROUPS IS
        SELECT ID FROM GROUP_FUNCTION;

BEGIN
    DELETE FROM FUNCTIONS;
    FOR RETURNED_ROW IN C_GROUPS LOOP
        COUNTER_1 := (COUNTER_1 + 1);
        WORK_LIST.EXTEND;
        WORK_LIST(COUNTER_1) := RETURNED_ROW.ID;
    END LOOP;
    
    GROUPS_TOTAL := WORK_LIST.COUNT;
    FUNCS_NUMBER := GROUPS_TOTAL * 2;
    
    LOOP
        RAND := DBMS_RANDOM.VALUE(1,GROUPS_TOTAL);
        IF WORK_LIST(RAND) NOT MEMBER OF CHECK_LIST THEN
            COUNTER_2 := (COUNTER_2 + 1);
			FUNC_NAME := CONCAT('f',COUNTER_2);
            INSERT INTO FUNCTIONS (ID, ID_GROUP, NAME, DESCR) VALUES(COUNTER_2, WORK_LIST(RAND),
                FUNC_NAME, ('Description of function ' || FUNC_NAME));
            CHECK_LIST.EXTEND;
            CHECK_LIST(COUNTER_2) := WORK_LIST(RAND);
        END IF;
        EXIT WHEN (COUNTER_2 = GROUPS_TOTAL);
    END LOOP;
    
    LOOP
        RAND := DBMS_RANDOM.VALUE(1,GROUPS_TOTAL);
        COUNTER_2 := (COUNTER_2 + 1);
		FUNC_NAME := CONCAT('f',COUNTER_2);
        INSERT INTO FUNCTIONS (ID, ID_GROUP, NAME, DESCR) VALUES(COUNTER_2, WORK_LIST(RAND),
            FUNC_NAME,('Description of function ' || FUNC_NAME));
        EXIT WHEN (COUNTER_2 = FUNCS_NUMBER);
    END LOOP;
    COMMIT;
END;
/


SET SERVEROUTPUT ON

DECLARE
    FUNCS_TOTAL PLS_INTEGER;
    PARAMS_NUMBER PLS_INTEGER;
    COUNTER_1 PLS_INTEGER := 0;
    COUNTER_2 PLS_INTEGER := 0;
    FLAG PLS_INTEGER := 0;
    RAND1 PLS_INTEGER;
    PAR_NAME VARCHAR2(15);
    TYPE ID_LIST IS TABLE OF PLS_INTEGER;
    WORK_LIST ID_LIST := ID_LIST();
    CHECK_LIST ID_LIST := ID_LIST();
    CURSOR C_FUNCS IS
        SELECT ID FROM FUNCTIONS;

BEGIN
    DELETE FROM FUN_PARAM;
    FOR RETURNED_ROW IN C_FUNCS LOOP
        COUNTER_1 := (COUNTER_1 + 1);
        WORK_LIST.EXTEND;
        WORK_LIST(COUNTER_1) := RETURNED_ROW.ID;
    END LOOP;
    
    FUNCS_TOTAL := WORK_LIST.COUNT;
    PARAMS_NUMBER := ROUND(FUNCS_TOTAL * 2.7);
    
    LOOP
        RAND1 := dbms_random.value(1,FUNCS_TOTAL);
        IF WORK_LIST(RAND1) NOT MEMBER OF CHECK_LIST THEN
            COUNTER_2 := (COUNTER_2 + 1);
            PAR_NAME := CONCAT('x',COUNTER_2);
            INSERT INTO FUN_PARAM (ID, ID_FUN, NAME, DESCR) VALUES(COUNTER_2, WORK_LIST(RAND1),
                PAR_NAME, ('Description of parameter ' || PAR_NAME));
            CHECK_LIST.EXTEND;
            CHECK_LIST(COUNTER_2) := WORK_LIST(RAND1);
        END IF;
        EXIT WHEN (COUNTER_2 = FUNCS_TOTAL);
    END LOOP;
    
    LOOP
        <<RESTART>>
        RAND1 := dbms_random.value(1,FUNCS_TOTAL);
        SELECT COUNT(*) INTO FLAG FROM  FUN_PARAM WHERE (ID_FUN = WORK_LIST(RAND1) AND NAME = CONCAT('x',(COUNTER_2 + 1)));
        IF FLAG = 0 THEN
            COUNTER_2 := (COUNTER_2 + 1);
            PAR_NAME := CONCAT('x', COUNTER_2);
            INSERT INTO FUN_PARAM (ID, ID_FUN, NAME, DESCR) VALUES(COUNTER_2, WORK_LIST(RAND1),
                PAR_NAME, ('Description of parameter ' || PAR_NAME));   
        ELSE
            FLAG := 0;
            GOTO RESTART;
        END IF;
        EXIT WHEN (COUNTER_2 = PARAMS_NUMBER);
    END LOOP;
    COMMIT;
END;
/