/*- * #%L
 * JSQLParser library *
 * %%
 * Copyright (C) 2004 - 2020 JSQLParser *
 * %%
 * Dual licensed under GNU LGPL 2.1 or Apache License 2.0
 * #L% */
package net.sf.jsqlparser;

import java.util.ArrayList;
import java.util.List;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.Statements;

public class Test {

  private static final List<String> PROBLEMATICS = new ArrayList<>();

  static {
    append(
        "SELECT PRODUCT.* FROM PRODUCT   INNER JOIN (SELECT DISTINCT PRODUCT.GROUPID, PRODUCT.PRODUCT_ID, GROUPID s0, PRODUCT_ID s1 FROM PRODUCT WHERE PRODUCT.GROUPID=1 AND (GROUPID, PRODUCT_ID) IN (SELECT GROUPID, PRODUCT_ID FROM SUPPLIER_PRODUCT WHERE SUPPLIER_PRODUCT.GROUPID=1 AND LOWER(LOWER(TRANSLATE(SUPPL_ITEM_CODE, '.:,\n");
    append(
        "SELECT PRODUCT.* FROM PRODUCT INNER JOIN (SELECT DISTINCT PRODUCT.GROUPID, PRODUCT.PRODUCT_ID, GROUPID s0, PRODUCT_ID s1 FROM PRODUCT WHERE PRODUCT.GROUPID=1 AND (GROUPID, PRODUCT_ID) IN (SELECT GROUPID, PRODUCT_ID FROM SUPPLIER_PRODUCT WHERE SUPPLIER_PRODUCT.GROUPID=1 AND LOWER(LOWER(TRANSLATE(SUPPL_ITEM_CODE, '.:,\n");
    append(
        "SELECT * FROM PRODUCT   WHERE  PRODUCT.GROUPID=1 AND  (GROUPID, PRODUCT_ID) IN (SELECT GROUPID, PRODUCT_ID FROM SUPPLIER_PRODUCT WHERE SUPPLIER_PRODUCT.GROUPID=1 AND LOWER(LOWER(TRANSLATE(SUPPL_ITEM_CODE, '.:,\n");
    append(
        "SELECT * FROM PRODUCT   WHERE  PRODUCT.GROUPID=1 AND  (GROUPID, PRODUCT_ID) IN (SELECT GROUPID, PRODUCT_ID FROM SUPPLIER_PRODUCT WHERE SUPPLIER_PRODUCT.GROUPID=1 AND LOWER(LOWER(TRANSLATE(SUPPL_ITEM_CODE, '.:,\n");
    append(
        "SELECT * FROM PRODUCT   WHERE  PRODUCT.GROUPID=1 AND  (GROUPID, PRODUCT_ID) IN (SELECT GROUPID, PRODUCT_ID FROM SUPPLIER_PRODUCT WHERE SUPPLIER_PRODUCT.GROUPID=1 AND LOWER(LOWER(TRANSLATE(SUPPL_ITEM_CODE, '.:,\n");
    append(
        "select top 15 CHR(DAYOFMONTH(TASK_DATE)) & '.' CHR(MONTH(TASK_DATE)) as \"Task Date\", left(it_task_id,5) as \"TaskNo{dbo:ITT}\", left(TASK_TITLE,50) as \"Title\", CREATE_USERID as \"Creator\", ASSIGNED_TO_USER as \"Assigned\" from IT_TASK where groupid=1 and TASK_STATUS=1 order by it_task_id desc\n");
    append(
        "select top 15 CHR(DAYOFMONTH(TASK_DATE)) & '.' CHR(MONTH(TASK_DATE)) as \"Task Date\", left(it_task_id,5) as \"TaskNo{dbo:ITT}\", left(TASK_TITLE,50) as \"Title\", CREATE_USERID as \"Creator\", ASSIGNED_TO_USER as \"Assigned\" from IT_TASK where groupid=1 and TASK_STATUS=1 order by it_task_id desc\n");
    append(
        "select top 15 CHR(DAYOFMONTH(TASK_DATE)) & '.' CHR(MONTH(TASK_DATE)) as 'Task Date', left(it_task_id,5) as \"TaskNo{dbo:ITT}\", left(TASK_TITLE,50) as \"Title\", CREATE_USERID as \"Creator\", ASSIGNED_TO_USER as \"Assigned\" from IT_TASK where groupid=1 and TASK_STATUS=1 order by it_task_id desc\n");
    append("select QUERY_TEXT from X_SQLCONSOLE_LOG where QUERY_TEXT like %domain% limit 10\n");
    append("select * from x_sql limit 1000 where insert_user_id = 10\n");
    append("select * from x_sql where query like %domain% limit 10\n");
    append("ALTER TABLE MAILING   ADD FOREIGN KEY F_DIVISION     (GROUPID, SENDER_DIVISION)   REFERENCES DIVISION     (GROUPID, DIVISIONCODE)\n");
    append("ALTER TABLE ORDERMAIN   ADD FOREIGN KEY F_DIVISION     (GROUPID, SENDER_DIVISION)   REFERENCES DIVISION     (GROUPID, DIVISIONCODE)\n");
    append("ALTER TABLE ORDERMAIN   ADD FOREIGN KEY F_DIVISION     (GROUPID, SENDER_DIVISION)   REFERENCES DIVISION     (GROUPID, DIVISION_CODE)\n");
    append("CREATE INDEX  ON GIT_COMMIT_PARENT_CHILD (REPOSITORY_ID, CHILD_COMMIT_ID)\n");
    append(
        "ALTER TABLE SUPPLIER_LP_UPDATE   ADD FOREIGN KEY F_DISTRIBUTOR_SETTINGS_ID     (groupid, DISTRIBUTOR_SETTINGS_ID)   REFERENCES DISTRIBUTOR_COUNTRY_REGION     (GROUPID, DISTRIBUTOR_SETTINGS_ID)\n");
    append("ALTER TABLE SUPPLIER_LP_UPDATE   ADD FOREIGN KEY F_DISTRIBUTOR_SETTINGS_ID     (DISTRIBUTOR_SETTINGS_ID)   REFERENCES DISTRIBUTOR_COUNTRY_REGION     (GROUPID, DISTRIBUTOR_SETTINGS_ID)\n");
    append("create domain DISTRIBUTOR_SETTINGS_ID fixed(6)\n");
    append("alter table it_task_review drop primary key\n");
    append("selectt * from address  limit 1\n");
    append("select 300 * from PRODUCT_COMPET_PRICE where competitor_id=2 order by entry_date desc\n");
    append(
        "select 'stats.* from (select userid, left(log_date,7) as month, sum(hours) as hours from (  select USERID, LOG_DATE, fixed(count(*)/6,4,2) as hours from ( SELECT s.USERID, s.LOG_DATE, s.hour, s.dekaminute, count(*) count FROM DB_LOG_STATISTIC s left outer join USER_WORKING_TIME_RANGE r on ( r.groupid=1 and s.userid=r.userid and s.log_date between r.date_from and r.date_until and dayofweek(s.log_date) between r.DAY_OF_WEEK_FROM and r.DAY_OF_WEEK_UNTIL )  WHERE s.LOG_DATE='2020-07-01' and s.userid not in (11,54,50,51,52,90,91,92,93) and s.userid in (284,250,243,302) AND s.LOG_DATA_MODE LIKE '-'  and (       r.date_from is null       or       (     s.log_time between r.time_a_begin and r.time_a_end  or s.log_time between r.time_b_begin and r.time_b_end  or s.log_time between r.time_c_begin and r.time_c_end  or s.log_time between r.time_d_begin and r.time_d_end       )     ) group by s.USERID, s.LOG_DATE, s.hour, s.dekaminute ) where count>=2 group by USERID, LOG_DATE  ) group by userid, left(log_date,7)) stats join x_user u on (stats.userid=u.userid and u.groupid=1) where u.ACTIVEMODE='Y' and u.PRIMARY_DEPARTMENT_CODE<>'I' order by month, hours desc\n");
    append(
        "select 'stats.* from (select userid, left(log_date,7) as month, sum(hours) as hours from (  select USERID, LOG_DATE, fixed(count(*)/6,4,2) as hours from ( SELECT s.USERID, s.LOG_DATE, s.hour, s.dekaminute, count(*) count FROM DB_LOG_STATISTIC s left outer join USER_WORKING_TIME_RANGE r on ( r.groupid=1 and s.userid=r.userid and s.log_date between r.date_from and r.date_until and dayofweek(s.log_date) between r.DAY_OF_WEEK_FROM and r.DAY_OF_WEEK_UNTIL )  WHERE s.LOG_DATE='2020-07-01' and s.userid not in (11,54,50,51,52,90,91,92,93) and s.userid in (284,250,243,302) AND s.LOG_DATA_MODE LIKE '-'  and (       r.date_from is null       or       (     s.log_time between r.time_a_begin and r.time_a_end  or s.log_time between r.time_b_begin and r.time_b_end  or s.log_time between r.time_c_begin and r.time_c_end  or s.log_time between r.time_d_begin and r.time_d_end       )     ) group by s.USERID, s.LOG_DATE, s.hour, s.dekaminute ) where count>=2 group by USERID, LOG_DATE  ) group by userid, left(log_date,7)) stats join x_user u on (stats.userid=u.userid and u.groupid=1) where u.ACTIVEMODE='Y' and u.PRIMARY_DEPARTMENT_CODE<>'I' order by month, hours desc\n");
    append("alter table code_change_target add package boolean default false not null\n");
    append("alter table code_change_target add subfolder boolean default false not null\n");
    append(
        "create table code_change_target ( \tgroupid groupid key, \tnotification_id code_change_notif_id key, \ttarget_id fixed(6) key, \tfolder_name varchar(800) ascii, \tfile_name varchar(200) ascii, \tforeign key f_code_change_notification \t\t(groupid, notification_id) \treferences code_change_notification \t\t(groupid, notification_id) \t )\n");
    append(
        "create table code_change_target ( \tgroupid groupid key, \tnotification_id code_change_notification_id key, \ttarget_id fixed(6) key, \tfolder_name varchar(800) ascii, \tfile_name varchar(200) ascii, \tforeign key f_code_change_notification \t\t(groupid, notification_id) \treferences code_change_notification \t\t(groupid, notification_id) \t )\n");
    append("truncate code_change_notification\n");
    append("truncate code_change_notification\n");
    append("select count(*) from website_click_entry where (groupid, product_id) in (select groupid, product_id from product where series = 'Komplete' and subseries = '13'\n");
    append("SELECT ALT_RESPONSIBLE_USER as o.anything FROM OURLOCATION AS o LIMIT 10\n");
    append("select * from SDB_BUG_MESSAGE where groupid=1 and BUG_TITLE like 'Unhandled exception: Request event 'refreshchatzone%'\n");
    append("select * from SDB_BUG_MESSAGE where groupid=1 and BUG_TITLE like 'Unhandled exception: Request event 'refreshchatzone'%\n");
    append("selet * from IT_TASK limit 10\n");
    append("select * from git_file where path like 'GIT_X'1E'OMMIT.java'\n");
    append(
        "select -- q.internal_survey_question_id, chr(max(q.question_short),25) as question_short, u.PRIMARY_DEPARTMENT_CODE as \"Dep\" chr('Prio' & a.answer, 8) as \"Prio\", fixed(count(*),6) as \"Count\" from INTERNAL_SURVEY_QUESTION q join INTERNAL_SURVEY_ANSWER a on q.groupid=a.groupid and q.internal_survey_question_id=a.internal_survey_question_id join x_user u on a.groupid=u.groupid and a.userid=u.userid group by q.internal_survey_question_id, a.answer, u.PRIMARY_DEPARTMENT_CODE\n");
    append("drop index i_insert_time on git_commit\n");
    append("remove index i_insert_time from git_commit\n");
    append("delete index i_insert_time on git_commit\n");
    append("alter table x_field_support add  apply_to_column boolean default false not null\n");
    append("alter table x_field_support add boolean apply_to_column boolean default false not null\n");
    append(
        "CREATE TABLE IT_TASK_REVIEW (   GROUPID GROUPID KEY,   IT_TASK_ID IT_TASK_ID KEY,   REVIEW_ID FIXED(3) KEY,   REVIEW_STATUS TASK_REVIEW_STATUS DEFAULT 1 NOT NULL,   REVIEWER_USER USERID NOT NULL,   REVIEW_TIME TIMESTAMP DEFAULT TIMESTAMP NOT NULL,   REVIEW_COMMENT LONG UNICODE,   PENDING_AT_USER USERID,   FINAL_REMARK_USER USERID,   FINAL_REMARK_TIME TIMESTAMP,   FINAL_REMARK LONG UNICODE,   FOREIGN KEY F_TASK (GROUPID, IT_TASK_ID) REFERENCES IT_TASK (GROUPID, IT_TASK_ID),   FOREIGN KEY F_REVIEWER (GROUPID, REVIEWER_USER) REFERENCES X_USER (GROUPID, USERID),   FOREIGN KEY (GROUPID, REVIEW_STATUS) REFERENCES TASK_REVIEW_STATUS (GROUPID, STATUS) )\n");
    append(
        "CREATE TABLE IT_TASK_REVIEW (   GROUPID GROUPID KEY,   IT_TASK_ID IT_TASK_ID KEY,   REVIEW_ID FIXED(3) KEY,   REVIEW_STATUS TASK_REVIEW_STATUS DEFAULT 1 NOT NULL,   REVIEWER_USER USERID NOT NULL,   REVIEW_TIME TIMESTAMP DEFAULT TIMESTAMP NOT NULL,   REVIEW_COMMENT LONG UNICODE,   PENDING_AT_USER USERID,   FINAL_REMARKS_USER USER,   FINAL_REMARKS_TIME TIMESTAMP,   FINAL_REMARKS LONG UNICODE,   FOREIGN KEY F_TASK (GROUPID, IT_TASK_ID) REFERENCES IT_TASK (GROUPID, IT_TASK_ID),   FOREIGN KEY F_REVIEWER (GROUPID, REVIEWER_USER) REFERENCES X_USER (GROUPID, USERID),   FOREIGN KEY (GROUPID, REVIEW_STATUS) REFERENCES TASK_REVIEW_STATUS (GROUPID, STATUS) )\n");
    append(
        "CREATE TABLE IT_TASK_REVIEW (   GROUPID GROUPID KEY,   IT_TASK_ID IT_TASK_ID KEY,   REVIEW_ID FIXED(3) KEY,   REVIEW_STATUS TASK_REVIEW_STATUS DEFAULT 1 NOT NULL,   REVIEWER_USER USERID NOT NULL,   REVIEW_TIME TIMESTAMP DEFAULT TIMESTAMP NOT NULL,   REVIEW_COMMENT LONG UNICODE,   PENDING_AT_USER USERID,   FINAL_REMARKS_USER USER,   FINAL_REMARKS_TIME TIMESTAMP,   FINAL_REMARKS LONG UNICODE,   FOREIGN KEY F_TASK (GROUPID, IT_TASK_ID) REFERENCES IT_TASK (GROUPID, IT_TASK_ID),   FOREIGN KEY F_REVIEWER (GROUPID, REVIEWER_USER) REFERENCES X_USER (GROUPID, USERID),   FOREIGN KEY (GROUPID, REVIEW_STATUS) REFERENCES TASK_REVIEW_STATUS (GROUPID, STATUS) )\n");
    append("CREATE DOMAIN TASK_REVIEW_STATUS FIXED(1)\n");
    append(
        "SELECT count(*) FROM X_COLUMN_FIELD_SUPPORT AS left WHERE left.DB_CONTEXT_ID='maindb' AND left.TABLENAME='IT_TASK_DRAFT' AND left.COLUMNNAME='DRAFT_TEXT' AND FIELD_SUPPORT_ID IN (SELECT FIELD_SUPPORT_ID FROM X_field_support where unique_name='sql')limit 1 \n");
    append(
        "SELECT count(*) FROM X_COLUMN_FIELD_SUPPORT AS left  INNER JOIN X_FIELD_SUPPORT AS right ON (left.FIELD_SUPPORT_ID=right.FIELD_SUPPORT_ID) WHERE left.DB_CONTEXT_ID='maindb' AND left.TABLENAME='IT_TASK_DRAFT' AND left.COLUMNNAME='DRAFT_TEXT' AND right.UNIQUE_NAME='sql' limit 1 \n");
    append(
        "SELECT count(*) FROM X_COLUMN_FIELD_SUPPORT AS left  INNER JOIN X_FIELD_SUPPORT AS right ON (left.FIELD_SUPPORT_ID=right.FIELD_SUPPORT_ID) WHERE left.DB_CONTEXT_ID='maindb' AND left.TABLENAME='IT_TASK_DRAFT' AND left.COLUMNNAME='DRAFT_TEXT' AND right.UNIQUE_NAME='sql' limit 1 \n");
    append(
        "SELECT count(*) FROM X_COLUMN_FIELD_SUPPORT AS left WHERE left.DB_CONTEXT_ID='maindb' AND left.TABLENAME='IT_TASK_DRAFT' AND left.COLUMNNAME='DRAFT_TEXT' AND FIELD_SUPPORT_ID IN (SELECT FIELD_SUPPORT_ID FROM X_field_support where unique_name='sql')limit 1 \n");
    append(
        "SELECT count(*) FROM X_COLUMN_FIELD_SUPPORT AS left WHERE left.DB_CONTEXT_ID='maindb' AND left.TABLENAME='IT_TASK_DRAFT' AND left.COLUMNNAME='DRAFT_TEXT' AND FIELD_SUPPORT_ID IN (SELECT FIELD_SUPPORT_ID FROM X_field_support where unique_name='sql')limit 1 \n");
    append(
        "SELECT count(*) FROM X_COLUMN_FIELD_SUPPORT AS left  INNER JOIN X_FIELD_SUPPORT AS right ON (left.FIELD_SUPPORT_ID=right.FIELD_SUPPORT_ID) WHERE left.DB_CONTEXT_ID='maindb' AND left.TABLENAME='IT_TASK_DRAFT' AND left.COLUMNNAME='DRAFT_TEXT' AND right.UNIQUE_NAME='sql' limit 1 \n");
    append(
        "SELECT count(*) FROM X_COLUMN_FIELD_SUPPORT AS left  INNER JOIN X_FIELD_SUPPORT AS right ON (left.FIELD_SUPPORT_ID=right.FIELD_SUPPORT_ID) WHERE left.DB_CONTEXT_ID='maindb' AND left.TABLENAME='IT_TASK_DRAFT' AND left.COLUMNNAME='DRAFT_TEXT' AND right.UNIQUE_NAME='sql' limit 1 \n");
    append(
        "SELECT count(*) FROM X_COLUMN_FIELD_SUPPORT AS left  INNER JOIN X_FIELD_SUPPORT AS right ON (left.FIELD_SUPPORT_ID=right.FIELD_SUPPORT_ID) WHERE left.DB_CONTEXT_ID='maindb' AND left.TABLENAME='IT_TASK_DRAFT' AND left.COLUMNNAME='DRAFT_TEXT' AND right.UNIQUE_NAME='sql' limit 1 \n");
    append(
        "SELECT count(*) FROM X_COLUMN_FIELD_SUPPORT AS left  INNER JOIN X_FIELD_SUPPORT AS right ON (left.FIELD_SUPPORT_ID=right.FIELD_SUPPORT_ID) WHERE left.DB_CONTEXT_ID='maindb' AND left.TABLENAME='IT_TASK_DRAFT' AND left.COLUMNNAME='DRAFT_TEXT' AND right.UNIQUE_NAME='sql' limit 1 \n");
    append(
        "SELECT count(*) FROM X_COLUMN_FIELD_SUPPORT AS left WHERE left.DB_CONTEXT_ID='maindb' AND left.TABLENAME='IT_TASK_DRAFT' AND left.COLUMNNAME='DRAFT_TEXT' AND FIELD_SUPPORT_ID IN (SELECT FIELD_SUPPORT_ID FROM X_field_support where unique_name='sql')limit 1 \n");
    append(
        "SELECT count(*) FROM X_COLUMN_FIELD_SUPPORT AS left WHERE left.DB_CONTEXT_ID='maindb' AND left.TABLENAME='IT_TASK_DRAFT' AND left.COLUMNNAME='DRAFT_TEXT' AND right.UNIQUE_NAME='sql' AND FIELD_SUPPORT_ID IN (SELECT FIELD_SUPPORT_ID FROM X_field_support )limit 1 \n");
    append(
        "SELECT count(*) FROM X_COLUMN_FIELD_SUPPORT AS left  INNER JOIN X_FIELD_SUPPORT AS right ON (left.FIELD_SUPPORT_ID=right.FIELD_SUPPORT_ID) WHERE left.DB_CONTEXT_ID='maindb' AND left.TABLENAME='IT_TASK_DRAFT' AND left.COLUMNNAME='DRAFT_TEXT' AND right.UNIQUE_NAME='sql' limit 1 \n");
    append(
        "SELECT count(*) FROM X_COLUMN_FIELD_SUPPORT AS left  INNER JOIN X_FIELD_SUPPORT AS right ON (left.FIELD_SUPPORT_ID=right.FIELD_SUPPORT_ID) WHERE left.DB_CONTEXT_ID='maindb' AND left.TABLENAME='IT_TASK_DRAFT' AND left.COLUMNNAME='DRAFT_TEXT' AND right.UNIQUE_NAME='sql' \n");
    append(
        "SELECT * FROM X_COLUMN_FIELD_SUPPORT AS left  INNER JOIN X_FIELD_SUPPORT AS right ON (left.FIELD_SUPPORT_ID=right.FIELD_SUPPORT_ID) WHERE left.DB_CONTEXT_ID='maindb' AND left.TABLENAME='IT_TASK_DRAFT' AND left.COLUMNNAME='DRAFT_TEXT' AND right.UNIQUE_NAME='sql' \n");
    append(
        "select count(*) from code_change_notification ccn \tjoin code_change_target_folder cctf on cctf.groupid = ccn.groupid and cctf.notification_id=ccn.notification_id \tjoin git_file gf on cctf.file_name=gf.path \tjoin git_folder gd on gf.repository_id=gf.repository_id and gf.git_folder_id = gd.git_folder_id \tjoin git_file_change gfc on gfc.repository_id=gf.repository_id and (gfc.new_file_id = gf.git_file_id or gfc.old_file_id=gf.git_file_id) \tjoin git_commit gc on gfc.repository_id=gc.repository_id and gfc.git_commit_id = gc.git_commit_id \twhere gc.insert_time>'2020-08-10 00:00:00' \tand ccn.groupid=1 and ccn.userid = userid \tand ( \t\t(not cctf.package and not cctf.subfolder and gd.name=cctf.folder_name) \t\tor (cctf.package and not cctf.subfolder and gd.name like '%' + cctf.folder_name) \t\tor (not cctf.package and cctf.subfolder andf gd.name like cctf.folder_name + '%') \t\tor (cctf.package and cctf.subfolder and gd.name like '%' + cctf.folder_name + '%') \t) \n");
    append(
        "select count(*) from code_change_notification ccn \tjoin code_change_target_folder cctf on cctf.groupid = ccn.groupid and cctf.notification_id=ccn.notification_id \tjoin git_file gf on cctf.file_name=gf.path \tjoin git_folder gd on gf.repository_id=gf.repository_id and gf.git_folder_id = gd.git_folder_id \tjoin git_file_change gfc on gfc.repository_id=gf.repository_id and (gfc.new_file_id = gf.git_file_id or gfc.old_file_id=gf.git_file_id) \tjoin git_commit gc on gfc.repository_id=gc.repository_id and gfc.git_commit_id = gc.git_commit_id \twhere gc.insert_time>'2020-08-10 00:00:00' \tand ccn.groupid=1 and ccn.userid = userid \tand ( \t\t(not cctf.package and not cctf.subfolder and gd.name=cctfd.folder_name) \t\tor (cctf.package and not cctf.subfolder and gd.name like '%' || cctfd.folder_name) \t\tor (not cctf.package and cctf.subfolder andf gd.name like cctfd.folder_name || '%') \t\tor (cctf.package and cctf.subfolder and gd.name like '%' || cctfd.folder_name || '%') \t) \n");
    append(
        "select * from code_change_notification ccn \tjoin code_change_target_folder cctf on cctf.groupid = ccn.groupid and cctf.notification_id=ccn.notification_id \tjoin git_file gf on cctf.file_name=gf.path \tjoin git_folder gd on gf.repository_id=gf.repository_id and gf.git_folder_id = gd.git_folder_id \tjoin git_file_change gfc on gfc.repository_id=gf.repository_id and (gfc.new_file_id = gf.git_file_id or gfc.old_file_id=gf.git_file_id) \tjoin git_commit gc on gfc.repository_id=gc.repository_id and gfc.git_commit_id = gc.git_commit_id \twhere gc.insert_time>'2020-08-10 00:00:00' \tand ccn.groupid=1 and ccn.userid = userid \tand (not cctf.package and not cctf.subfolder and gd.name=cctfd.folder_name \tor (cctf.package and not cctf.subfolder and gd.name like '%' || cctfd.folder_name) \tor (not cctf.package and cctf.subfolder andf gd.name like cctfd.folder_name || '%') \tor (cctf.package and cctf.subfolder and gd.name like '%' || cctfd.folder_name || '%') \n");
    append(
        "create table X_COLUMN_FIELD_SUPPORT (   DB_CONTEXT_ID DB_CONTEXT_ID DEFAULT 'maindb' KEY,   TABLENAME TABLENAME KEY,   COLUMNNAME COLUMNNAME KEY,   FIELD_SUPPORT_ID FIELD_SUPPORT_ID KEY,   FOREIGN KEY (DB_CONTEXT_ID, TABLENAME, COLUMNNAME) REFERENCES X_COLUMN (DB_CONTEXT_ID, TABLENAME, COLUMNNAME),   FOREIGN KEY (FIELD_SUPPORT_ID) REFERENCES X_FIELD_SUPPORT (FIELD_SUPPORT_ID), )\n");
    append("select count(*) on USER_PROCESS\n");
    append("ALTER TABLE COMPETITOR   ADD CONSTRAINT  C_REQUEST_ROUTING CHECK REQUEST_ROUTING IS NULL OR REQUEST_ROUTING='DIRECT' OR REQUEST_ROUTING='PROXY'\n");
    append("alter table code_change_target_folder add package boolean not null default false\n");
    append("alter table code_change_target_folder add subfolder boolean not null default false\n");
    append("alter table DELPOS_STOCKPLACE_CHOICE add foreign key f_product (groupid, product_id) references product(groupid, product_id)\n");
    append("CREATE DOMAIN ZUSTAND_BESCHREIBU CHAR(50) ASCII\n");
    append("CREATE DOMAIN ZUSTANDSCODE CHAR(2) ASCII\n");
    append("create domain field_support_id fixed(3)\n");
    append("create domain x_field_support field_support_id fixed(3)\n");
    append("create domain x_field_support field_support_id fixed(3)\n");
    append("select groupid,PERSON_PERSON_LINK_ID from PERSON_PERSON_LINK except all select distinct groupid,PERSON_PERSON_LINK_ID from PERSON_PERSON_LINK\n");
    append("select groupid,PERSON_PERSON_LINK_ID from PERSON_PERSON_LINK except all select distinct groupid,PERSON_PERSON_LINK_ID from PERSON_PERSON_LINK\n");
    append("select groupid,PERSON_PERSON_LINK_ID from PERSON_PERSON_LINK except all select distinct groupid,PERSON_PERSON_LINK_ID from PERSON_PERSON_LINK\n");
    append("select groupid,PERSON_PERSON_LINK_ID from PERSON_PERSON_LINK except all select distinct groupid,PERSON_PERSON_LINK_ID from PERSON_PERSON_LINK\n");
    append("alter table PERSON_PERSON_LINK drop primary key\n");
    append("create domain PERSON_PERSON_LINK_ID fixed(6)\n");
    append("create domain PERSON_PERSON_LINK_ID\n");
    append("alter table code_change_target_folder \tadd foreign key f_code_change_notification \t\t(groupid, notification_id) \treferences code_change_notification \t\t(groupid, notification_id)\n");
    append("alter table code_change_target_file  \tadd foreign key f_code_change_notification \t\t(groupid, notification_id) \treferences code_change_notification \t\t(groupid, notification_id)\n");
    append("alter table code_change_notification \tadd foreign key f_user \t\t(groupid, userid) \treferences x_user \t\t(groupid, userid)\n");
    append("alter table POS_CASH_USAGE_GROUP add foreign key f_drawback_transaction (groupid, DRAWBACK_POS_TRANSACTION_ID) references POINT_OF_SALE_TRANSACTION(groupid, POS_TRANSACTION_ID)\n");
    append("alter table POS_CASH_USAGE_GROUP add foreign key f_withdrawal_transaction (groupid, WITHDRAWAL_POS_TRANSACTION_ID) references POINT_OF_SALE_TRANSACTION(groupid, POS_TRANSACTION_ID)\n");
    append(
        "create table internal_survey_user_remarks (   groupid groupid key,   internal_survey_user_remarks_id internal_survey_user_remarks_id key,   entry_date date default date not null,   internal_survey_id internal_survey_id not null,   userid userid not null,   user_survey_remarks long unicode,   foreign key f_USERID (groupid, userid)      references X_USER (groupid, userid),   foreign key f_internal_survey (groupid, internal_survey_id)     references INTERNAL_SURVEY (groupid, internal_survey_id) )\n");
    append("create domain internal_survey_user_remarks_id fixed(6)\n");
    append("create table INTERNAL_SURVEY_ANSWER alter primary key (groupid, internal_SURVEY_ANSWER_id)\n");
    append(
        "create table INTERNAL_SURVEY_ANSWER (   groupid groupid key,   internal_SURVEY_ANSWER_id internal_SURVEY_ANSWER_id,   internal_survey_question_id internal_survey_question_id not null,   userid userid not null,   answer varchar(50),   foreign key f_INTERNAL_SURVEY_QUESTION (groupid, internal_survey_question_id)      references INTERNAL_SURVEY_QUESTION (groupid, internal_survey_question_id),   foreign key f_USERID (groupid, userid)      references X_USER (groupid, userid) )\n");
    append(
        "create table INTERNAL_SURVEY_ANSWER (   groupid groupid key,   internal_SURVEY_ANSWER_id internal_SURVEY_ANSWER_id,   internal_survey_question_id internal_survey_question_id not null,   userid userid not null,   answer varchar(50),   foreign key f_INTERNAL_SURVEY_QUESTION (groupid, internal_survey_question_id)      references INTERNAL_SURVEY_QUESTION (groupid, internal_survey_question_id),   foreign key f_USERID (groupid, userid)      references X_USER (groupid, useri_id) )\n");
    append(
        "create table INTERNAL_SURVEY_ANSWER (   groupid groupid key,   internal_SURVEY_ANSWER_id internal_SURVEY_ANSWER_id,   survey_question_id internal_survey_question_id not null,   userid userid not null,   answer varchar(50),   foreign key f_INTERNAL_SURVEY_QUESTION (groupid, internal_survey_question_id)      references INTERNAL_SURVEY_QUESTION (groupid, internal_survey_question_id),   foreign key f_USERID (groupid, userid)      references X_USER (groupid, useri_id) )\n");
    append("create domain internal_SURVEY_ANSWER_id fixed(10)\n");
    append(
        "create table INTERNAL_SURVEY_QUESTION (   groupid groupid key,   internal_survey_question_id internal_survey_question_id key,   internal_survey_id internal_survey_id,   question_short varchar(80) unicode not null,   description long unicode,   foreign key f_internal_survey (groupid, internal_survey_id)     references INTERNAL_SURVEY (groupid, internal_survey_id) )\n");
    append(
        "create table INTERNAL_SURVEY_QUESTION (   groupid groupid key,   internal_survey_question_id internal_survey_question_id key,   internal_survey_id internal_survey_id,   question_short varchar(80) unicode not null,   description long unicode,   foreign key f_internal_survey (groupid, survey_id)     references INTERNAL_SURVEY (groupid, survey_id) )\n");
    append("create domain internal_survey_question_id fixed(8)\n");
    append(
        "create table INTERNAL_SURVEY (   groupid groupid key,   internal_survey_id internal_survey_id key,   survey_name varchar(80) not null,   entry_date date default date not null,   survey_remarks long unicode )\n");
    append("create domain internal_survey_id fixed(6)\n");
    append("create domain internal_survey_id fixed(6)\n");
    append("create domain internal_survey_id fixed(6)\n");
    append(
        "create table code_change_target_folder ( \tgroupid groupid key, \tnotification_id code_change_notif_id key, \ttarget_id code_change_target_id key, \trepository_id git_repository_id not null, \tgit_folder_id git_folder_id not null,  \tinclude_subfolders boolean not null default false, \t \tforeign key f_git_folder \t\t(repository_id, git_folder_id) \treferences git_folder \t\t(repository_id, git_folder_id) )\n");
    append(
        "create table code_change_target_file ( \tgroupid groupid key, \tnotification_id code_change_notif_id key, \ttarget_id code_change_target_id key, \t \trepository_id git_repository_id not null, \tgit_file_id git_file_id not null, \t \tforeign key f_git_file \t\t(repository_id, git_file_id) \treferences git_file \t\t(repository_id, git_file_id) )\n");
    append(
        "create table code_change_target_file ( \tgroupid groupid key, \tnotification_id code_change_notif_id key, \ttarget_id code_change_target_id key, \t \trepository_id repository_id not null, \tgit_file_id git_file_id not null, \t \tforeign key f_git_file \t\t(repository_id, git_file_id) \treferences git_file \t\t(repository_id, git_file_id) )\n");
    append("create domain code_change_target_id fixed(6)\n");
    append(
        "create table code_change_notification ( \tgroupid groupid key, \tnotification_id code_change_notif_id key, \tuserid userid not null, \tsms boolean not null default false, \tmail boolean not null default false, \tpending boolean not null default false, \tlast_check timestamp )\t\t\t\n");
    append(
        "create table code_change_notification ( \tgroupid groupid key, \tnotification_id code_change_notif_id key, \tuserid userid not null, \tsms boolean not null, \tmail boolean not null, \tpending not null, \tlast_check timestamp )\t\t\t\n");
    append("create domain code_change_notif_id fixed(8)\n");
    append("alter table EXPENSE add foreign key f_scandoc_page (groupid, scan_document_id, scan_document_page) references scan_document_page (groupid, scan_document_id, scan_document_page)\n");
    append("alter table EXPENSE add foreign key f_scandoc_page (groupid, scan_document_id, scan_document_page) references scan_document (groupid, scan_document_id, scan_document_page)\n");
    append("alter table EXPENSE add foreign key f_scandoc (groupid, scan_document_id) references scan_document (groupid, scan_document_id)\n");
    append("alter table EXPENSE add foreign key f_datafile (groupid, data_key) references datafile (groupid, data_key)\n");
    append("alter table EXPENSE add foreign key f_fintransaction(groupid, fintransaction_id) references fintransaction(groupid, fintransaction_id)\n");
    append("alter table EXPENSE add foreign key f_fintransaction(groupid, fintransaction_id) references (groupid, fintransaction_id)\n");
    append("alter table EXPENSE add foreign key f_cash_change (groupid, cash_usage_group_id) references POS_CASH_USAGE_GROUP(groupid, cash_usage_group_id)\n");
    append("alter table EXPENSE add foreign key f_cash_change (groupid, cash_usage_group_id) references pos_cash_usage_group_id(groupid, cash_usage_group_id)\n");
    append("alter table EXPENSE add foreign key f_cash_change (groupid, cash_usage_group_id) references pos_ cash_usage_group_id(groupid, cash_usage_group_id)\n");
    append("alter table EXPENSE add foreign key f_cash_change (groupid, pos_cash_change_id) references point_of_sale_cash_change(groupid, pos_cash_change_id)\n");
    append("alter table EXPENSE add foreign key f_cash_change (groupid, pos_cash_change_id) references point_of_sale_cash_change(groupid, pos_cash_change_id)\n");
    append("create domain expense_id fixed(7)\n");
    append("alter table pos_cash_usage_group add foreign key f_drawback(groupid, drawback_cash_change_id) references point_of_sale_cash_change(groupid, pos_cash_change_id)\n");
    append("alter table pos_cash_usage_group add foreign key f_withdrawal (groupid, withdrawal_cash_change_id) references point_of_sale_cash_change(groupid, pos_cash_change_id)\n");
    append("alter table pos_cash_usage_group add foreign key f_withdrawal (groupid, withdrawal_cash_change_id) references point_of_sale_cash_change(groupid, pos_cash_change_id)\n");
    append(
        "create table pos_cash_usage_group (   groupid groupid key,   cash_usage_group_id cash_usage_group_id key,    type char(2), -- expenses or transfer to bank    withdrawal_amount amount,   withdrawal_cash_change_id,   point_of_sale_cash_change_id,    drawback_amount amount,   drawback_cash_change_id   point_of_sale_cash_change_id, )\n");
    append("create domain pos_cash_usage_group_id fixed(7)\n");
    append("alter table DELIVERY_BOOKING_POSITION column AVAILABILITY_NOTE EXP_DELIVERY_DATE_TEXT\n");
    append("alter table ORDER_POSITION_PART column EXP_DELIVERY_DATE_TEXT EXP_DELIVERY_DATE_TEXT\n");
    append("alter table SUPPLIER_ORDER_INFO column DEFAULT_EXP_DELIVERY_DATE_TEXT EXP_DELIVERY_DATE_TEXT\n");
    append("rename column DESKTOP_BACKGROUND.icon_source_tablename to icon_tablename\n");
    append("alter table DESKTOP_BACKGROUND add foreign key f_x_table (icon_DB_CONTEXT_ID, icon_source_tablename) references x_table (DB_CONTEXT_ID, TABLENAME)\n");
    append("alter user_process add target_field_key varchar(100) ascii\n");
    append("select index(substr(REF_OBJ,1,40),'{') from BUG_MESSAGE where groupid=1 bug_id=190329\n");
    append("selec * from USER_PROCESS where PROCESS_START>='2020-09-03 12:20:00.0'\n");
    append("alter table FISKALY_TRANSACTION_SIGNATURE add foreign key f_pos_transaction(groupid, pos_transaction_id) references point_of_sale_transaction(groupid, pos_transaction_id)\n");
    append("   alter table FISKALY_TRANSACTION_SIGNATURE add foreign key f_pos_transaction(groupid, pos_transaction_id) references point_of_sale_transact(groupid, pos_transaction_id)\n");
    append(
        "create table FISKALY_TRANSACTION_SIGNATURE (   groupid groupid key,   POS_TRANSACTION_ID POS_TRANSACTION_ID key,   fiskaly_transaction_id fixed(16),   our_transaction_id varchar(64),   begin timestamp,   end timestamp,   client_serial_number varchar(32),   certificate_serial varchar(32),   state char(1),   qr_code_data long unicode,   revision fixed(3),   latest_revision fixed(3),   log_operation char(1),   log_timestamp timestamp,   log_timestamp_format varchar(10),   signature_value long unicode,   signature_algorithm varchar(32),   signature_counter fixed(16),   public_key long unicode,   environment char(1),   version varchar(10) )\n");
    append(
        "create table FISKALY_TRANSACTION_SIGNATURE (   groupid groupid key,   POS_TRANSACTION_ID POS_TRANSACTION_ID key,   fiskaly_transaction_id fixed(16),   our_transaction_id varchar(64),   begin timestamp,   end timestamp,   client_serial_number varchar(32),   certificate_serial varchar(32),   state char(1),   qr_code_data long unicode,   revision fixed(3),   latest_revision(3),   log_operation char(1),   log_timestamp timestamp,   log_timestamp_format varchar(10),   signature_value long unicode,   signature_algorithm varchar(32),   signature_counter fixed(16),   public_key long unicode,   environment char(1),   version varchar(10) )\n");
    append(
        "create table FISKALY_TRANSACTION_SIGNATURE (   groupid groupid key,   POS_TRANSACTION_ID POS_TRANSACTION_ID key,   fiskaly_transaction_id fixed(16),   our_transaction_id varchar(64),   begin timestamp,   end timestamp,   client_serial_number varchar(32),   certificate_serial varchar(32) byte,   state char(1),   qr_code_data long unicode,   revision fixed(3),   latest_revision(3),   log_operation char(1),   log_timestamp timestamp,   log_timestamp_format varchar(10),   signature_value long unicode,   signature_algorithm varchar(32),   signature_counter fixed(16),   public_key long unicode,   environment char(1),   version varchar(10) )\n");
    append(
        "create table FISKALY_TRANSACTION_SIGNATURE (   groupid groupid key,   POS_TRANSACTION_ID POS_TRANSACTION_ID key,   fiskaly_transaction_id fixed(16),   our_transaction_id varchar(64),   timestamp begin,   timestamp end,   client_serial_number varchar(32),   certificate_serial varchar(32) byte,   state char(1),   qr_code_data long unicode,   revision fixed(3),   latest_revision(3),   log_operation char(1),   log_timestamp timestamp,   log_timestamp_format varchar(10),   signature_value long unicode,   signature_algorithm varchar(32),   signature_counter fixed(16),   public_key long unicode,   environment char(1),   version varchar(10) )\n");
    append("ALTER TABLE ACCOUNT_BALANCE_CHECK   ADD FOREIGN KEY F_FINACCOUNT_DOCUMENT     (GROUPID, FINACCOUNT_DOCUMENT_ID)   REFERENCES ACCOUNT_DATA     (GROUPID, FINACCOUNT_DOCUMENT_ID)\n");
    append("create domain FINACCOUNT_DOCUMENT_ID fixed(8)\n");
    append("alter table account_date add ACCOUNT_DATA_id\n");
    append("create domain ACCOUNT_DATA_id fixed(8)\n");
    append("ALTER TABLE SUPPLIER_LP_UPDATE ADD FOREIGN KEY F_DIVISION (GROUPID, DIVISIONCODE) REFERENCES DIVISION (GROUPID, DIVISIONCODE)\n");
    append("ALTER TABLE SUPPLIER_LP_UPDATE ADD FOREIGN KEY F_DIVISION (GROUPID, DIVISIONCODE) REFERENCES DIVISION (GROUPID, DIVISIONCODE)\n");
    append("ALTER TABLE SUPPLIER_LP_UPDATE ADD FOREIGN KEY F_DIVISION (GROUPID, DIVISION) REFERENCES DIVISION (GROUPID, DIVISIONCODE)\n");
    append("SELECT * FROM USER_AGENT WHERE LOWER(USER_AGENT.USER_AGENT_NAM)E LIKE '%eventmachine%' ORDER BY GROUPID, USER_AGENT_ID\n");
    append("select * from it_task where assigned_to_user=347 limit 10-\n");
    append("alter table POS_TRANSACTION_CONTRIBUTOR add foreign key f_fintransaction(groupid, fintransaction_id) references fintransaction(groupid, fintransaction_id)\n");
    append("select left(INSERT_TIME,8), count(*) from GIT_COMMIT column AUTHOR_ID in (324,351) group by left(INSERT_TIME,8)\n");
    append(
        "select count(distinct o.order_id) from ordermain o left outer join SUPPLIER_ORDER_INFO s on (o.GROUPID=s.groupid and o.ORDER_ID=s.oselect case when count(distinct o.order_id)>0 then 'A' else 'N' end from ordermain o left outer join SUPPLIER_ORDER_INFO s on (o.GROUPID=s.groupid and o.ORDER_ID=s.order_id) where o.groupid=1 and purchase and ORDER_DATE between subdate(date,60) and subdate(date,3) and o.PARTNERORDERID is null and o.DELIVERY_STATUS='O' and ADDRESS_ID<>1000 and ORDER_AGREEMENT_TYPE='B' and s.order_id is nullrder_id) where o.groupid=1 and purchase and ORDER_DATE between subdate(date,60) and subdate(date,3) and o.PARTNERORDERID is null and o.DELIVERY_STATUS='O' and ADDRESS_ID<>1000 and ORDER_AGREEMENT_TYPE='B' and s.order_id is null -- or s.order_id=o.order_id\n");
    append(
        "seoect count(*) from address where groupid=1 and ADDRESS_ID in (select address_id from ordermain where groupid=1 and PURCHASE=false and (groupid,order_id) in (select groupid, order_id from orderposition where (groupid,product_id) in (select groupid, product_id from product where (groupid,kategorienr) in (select groupid, kategorienr from productgroup where groupid=1 and  (CATEGORY_KEYS_PATH='1-2-145' or CATEGORY_KEYS_PATH like '1-2-145-%')  ))))\n");
    append("ALTER TABLE PRODUCT_PRICE_FROM_PRODUCT     ADD FOREIGN KEY F_CONDITION_REMARK (GROUPID, WEBSHOP_CONDITION_REMARK_ID)     REFERENCES CONDITION_REMARK (GROUPID, CONDITION_REMARK_ID)\n");
    append("ALTER TABLE PRODUCT_PRICE_FROM_PRODUCT ADD SHOW_CONDITION_REMARK_ONLINE BOOLEAN DEFAULT FALSE NOT NULL\n");
    append(
        "CREATE TABLE CONDITION_REMARK (     GROUPID                   GROUPID KEY,     CONDITION_REMARK_ID       FIXED(8) KEY,     CONDITION_CODE            CHAR(50) UNICODE NOT NULL,     TEXT_PROPERTY_BUNDLE_NAME TEXT_PROPERTIES_CONTEXT NOT NULL,     TEXT_PROPERTY_KEY         TEXT_PROPERTY_KEY       NOT NULL,     IS_DEFAULT_REMARK         BOOLEAN DEFAULT FALSE   NOT NULL,  FOREIGN KEY F_TEXT_PROPERTY (GROUPID, TEXT_PROPERTY_BUNDLE_NAME, TEXT_PROPERTY_KEY)     REFERENCES TEXT_PROPERTY (GROUPID, BUNDLE_NAME, PROPERTY_KEY) )\n");
    append(
        "ALTER TABLE PRODUCT_CONDITION     ADD FOREIGN KEY F_PRODUCT_CONDITION(GROUPID, TEXT_PROPERTY_BUNDLE_NAME, TEXT_PROPERTY_KEY)     REFERENCES TEXT_PROPERTY (GROUPID, BUNDLE_NAME, PROPERTY_KEY)\n");
    append("select SET_PRODUCT_ID from PRODUCT_PART where   PART_PRODUCT_ID in (SET_PRODUCT_ID from PRODUCT_PART where     PART_PRODUCT_ID in (SET_PRODUCT_ID from PRODUCT_PART)   )\n");
    append("ALTER TABLE X_FOREIGNKEY drop PRIMARY KEY\n");
    append("ALTER TABLE X_FOREIGNKEY replace PRIMARY KEY (DB_CONTEXT_ID, TABLENAME, FOREIGNKEYNAME)\n");
    append("alter table pos_transaction_contributor drop primary key\n");
    append("alter table POINT_OF_SALE_CASH_CHANGE add foreign key f_pos (groupid, pos_id) references POINT_OF_SALE(groupid, pos_id)\n");
    append(
        "ALTER TABLE EMAIL_FORWARD   ADD FOREIGN KEY F_TO_CONTACT_LOG     (GROUPID, TO_ADDRESS_LOG_AID, TO_CONTACT_LOG_CID, TO_CONTACT_LOG_LID)   REFERENCES CONTACT_LOG     (GROUPID, ADDRESS_ID, CONTACT_ID, CONTACT_LOG_ID)\n");
    append(
        "ALTER TABLE EMAIL_FORWARD   ADD FOREIGN KEY F_FROM_CONTACT_LOG     (GROUPID, FROM_ADDRESS_LOG_AID, FROM_CONTACT_LOG_CID, FROM_CONTACT_LOG_LID)   REFERENCES CONTACT_LOG     (GROUPID, ADDRESS_ID, CONTACT_ID, CONTACT_LOG_ID)\n");
    append("ALTER TABLE EMAIL_FORWARD   ADD FOREIGN KEY F_TO_ADDRESS_LOG     (GROUPID, TO_ADDRESS_LOG_AID, TO_ADDRESS_LOG_LID)   REFERENCES ADDRESS_LOG     (GROUPID, ADDRESS_ID, ADDRESS_LOG_ID)\n");
    append(
        "ALTER TABLE EMAIL_FORWARD   ADD FOREIGN KEY F_FROM_ADDRESS_LOG     (GROUPID, FROM_ADDRESS_LOG_AID, FROM_ADDRESS_LOG_LID)   REFERENCES ADDRESS_LOG     (GROUPID, ADDRESS_ID, ADDRESS_LOG_ID)\n");
    append(
        "select case           when max(expiration_date)<now() then 'A'          when max(subdate(expiration_date,10)<now()) then 'W'          else ''        end as widget_status   from product_stockplace   where groupid = 1     and expiration_date is not null     and subdate(expiration_date,30)<=now()\n");
    append("ALTER TABLE Proxy column success_count default 0\n");
    append("ALTER TABLE Proxy ADD DEFAULT 0 FOR success_count\n");
    append(
        "alter table POS_TRANSACTION_CONTRIBUTOR add foreign key f_voucherposition (groupid, vouchernumber, voucherposition) references voucher_transactions(groupid, vouchernumber, voucherposition)\n");
    append(
        "alter table POS_TRANSACTION_CONTRIBUTOR add foreign key f_voucherposition (groupid, vouchernumber, voucherposition) references voucher_transactions(sgroupid, vouchernumber, voucherposition)\n");
    append(
        "alter table POS_TRANSACTION_CONTRIBUTOR add foreign key f_voucherposition (groupid, vouchernumber, voucherposition) references voucher_transaction(sgroupid, vouchernumber, voucherposition)\n");
    append(
        "alter table POS_TRANSACTION_CONTRIBUTOR add foreign key f_voucherposition (groupid, vouchernumber, voucherposition) references voucher_transaction(groupid, vouchernumber, voucherposition)\n");
    append("alter table POS_TRANSACTION_CONTRIBUTOR add foreign key f_deliveryposition (groupid, delivery_id, deliveryposition) references deliveryposition(groupid, delivery_id, deliveryposition)\n");
    append("alter table POS_TRANSACTION_CONTRIBUTOR add foreign key f_POINT_OF_SALE_CASH_CHANGE (groupid, pos_cash_change_id) references POINT_OF_SALE_CASH_CHANGE(groupid, pos_cash_change_id)\n");
    append("alter table POS_TRANSACTION_CONTRIBUTOR add foreign key f_POINT_OF_SALE_CASH_CHANGE (groupid, pos_cash_change_id) references delivery(groupid, pos_cash_change_id)\n");
    append("alter table POS_TRANSACTION_CONTRIBUTOR add foreign key f_pos_transaction (groupid, pos_transaction_id) references POINT_OF_SALE_TRANSACTION(groupid, pos_transaction_id)\n");
    append("alter table POS_TRANSACTION_CONTRIBUTOR add foreign key f_vibbek (groupid, VIBBEK_LOG_ID) references VIBBEK_LOG(groupid, VIBBEK_LOG_ID)\n");
    append("alter table POS_TRANSACTION_CONTRIBUTOR add foreign key f_vibbek (groupid, VIBBEK_LOG_ID) references PORTAL_PAYMENT_VIBBEK(groupid, VIBBEK_LOG_ID)\n");
    append("alter table POS_TRANSACTION_CONTRIBUTOR add foreign key f_adyen (groupid, adyen_payment_id) references PORTAL_PAYMENT_ADYEN(groupid, adyen_payment_id)\n");
    append("alter table POINT_OF_SALE_CASH_CHANGE add foreign key f_fintransaction(groupid, fintransaction_id) references fintransaction (groupid, fintransaction_id)\n");
    append("alter table POINT_OF_SALE_CASH_CHANGE add foreign key f_fintransaction(groupid, fintransaction_id) references (groupid, fintransaction_id)\n");
    append("alter table POINT_OF_SALE_CASH_CHANGE add foreign key f_pos (groupid, pos_transaction_id) references point_of_sale_transaction(groupid, pos_transaction_id)\n");
    append("alter table POINT_OF_SALE_CASH_CHANGE add foreign key f_pos (groupid, pos_transaction_id) references point_of_sale_transaction_id(groupid, pos_transaction_id)\n");
    append("alter table POINT_OF_SALE_TRANSACTION add foreign key f_pos (groupid, pos_id) references POINT_OF_SALE(groupid, pos_id)\n");
    append("create domain pos_transaction_id fixed(7)\n");
    append("create domain pos_cash_change_id fixed(7)\n");
    append(
        "SELECT * FROM IT_TASK_COMMIT WHERE ((GROUPID, IT_TASK_ID, REPOSITORY_ID, GIT_COMMIT_ID) IN (SELECT t0.GROUPID, t0.IT_TASK_ID, t0.REPOSITORY_ID, t0.GIT_COMMIT_ID FROM IT_TASK_COMMIT AS t0  INNER JOIN GIT_COMMIT AS t1 ON (t0.REPOSITORY_ID=t1.REPOSITORY_ID AND t0.GIT_COMMIT_ID=t1.GIT_COMMIT_ID) INNER JOIN GIT_FILE_CHANGE AS t2 ON (t1.REPOSITORY_ID=t2.REPOSITORY_ID AND t1.GIT_COMMIT_ID=t2.GIT_COMMIT_ID) INNER JOIN GIT_FILE AS t3 ON (t2.REPOSITORY_ID=t3.REPOSITORY_ID AND t2.OLD_FILE_ID=t3.GIT_FILE_ID) WHERE t3.PATH IN ('IT_TASK_COMMIT.java', 'BaseImpl_maindb_IT_TASK_COMMIT.java')) OR (GROUPID, IT_TASK_ID, REPOSITORY_ID, GIT_COMMIT_ID) IN (SELECT t0.GROUPID, t0.IT_TASK_ID, t0.REPOSITORY_ID, t0.GIT_COMMIT_ID FROM IT_TASK_COMMIT AS t0  INNER JOIN GIT_COMMIT AS t1 ON (t0.REPOSITORY_ID=t1.REPOSITORY_ID AND t0.GIT_COMMIT_ID=t1.GIT_COMMIT_ID) INNER JOIN GIT_FILE_CHANGE AS t2 ON (t1.REPOSITORY_ID=t2.REPOSITORY_ID AND t1.GIT_COMMIT_ID=t2.GIT_COMMIT_ID) INNER JOIN GIT_FILE AS t3 ON (t2.REPOSITORY_ID=t3.REPOSITORY_ID AND t2.NEW_FILE_ID=t3.GIT_FILE_ID) WHERE t3.PATH IN ('IT_TASK_COMMIT.java', 'BaseImpl_maindb_IT_TASK_COMMIT.java')) ORDER BY GROUPID, IT_TASK_ID, REPOSITORY_ID, GIT_COMMIT_ID\n");
    append(
        "SELECT * FROM IT_TASK_COMMIT WHERE ((GROUPID, IT_TASK_ID, REPOSITORY_ID, GIT_COMMIT_ID) IN (SELECT t0.GROUPID, t0.IT_TASK_ID, t0.REPOSITORY_ID, t0.GIT_COMMIT_ID FROM IT_TASK_COMMIT AS t0  INNER JOIN GIT_COMMIT AS t1 ON (t0.REPOSITORY_ID=t1.REPOSITORY_ID AND t0.GIT_COMMIT_ID=t1.GIT_COMMIT_ID) INNER JOIN GIT_FILE_CHANGE AS t2 ON (t1.REPOSITORY_ID=t2.REPOSITORY_ID AND t1.GIT_COMMIT_ID=t2.GIT_COMMIT_ID) INNER JOIN GIT_FILE AS t3 ON (t2.REPOSITORY_ID=t3.REPOSITORY_ID AND t2.OLD_FILE_ID=t3.GIT_FILE_ID) WHERE t3.PATH IN ('IT_TASK_COMMIT.java', 'BaseImpl_maindb_IT_TASK_COMMIT.java')) OR (GROUPID, IT_TASK_ID, REPOSITORY_ID, GIT_COMMIT_ID) IN (SELECT t0.GROUPID, t0.IT_TASK_ID, t0.REPOSITORY_ID, t0.GIT_COMMIT_ID FROM IT_TASK_COMMIT AS t0  INNER JOIN GIT_COMMIT AS t1 ON (t0.REPOSITORY_ID=t1.REPOSITORY_ID AND t0.GIT_COMMIT_ID=t1.GIT_COMMIT_ID) INNER JOIN GIT_FILE_CHANGE AS t2 ON (t1.REPOSITORY_ID=t2.REPOSITORY_ID AND t1.GIT_COMMIT_ID=t2.GIT_COMMIT_ID) INNER JOIN GIT_FILE AS t3 ON (t2.REPOSITORY_ID=t3.REPOSITORY_ID AND t2.NEW_FILE_ID=t3.GIT_FILE_ID) WHERE t3.PATH IN ('IT_TASK_COMMIT.java', 'BaseImpl_maindb_IT_TASK_COMMIT.java')) ORDER BY GROUPID, IT_TASK_ID, REPOSITORY_ID, GIT_COMMIT_ID\n");
    append("select * from INT_MESSAGE where from='324'\n");
    append(
        "select    GROUPID,   10018 as OURTRADEMARK_REGISTRATION_ID,   OURTM_REG_MEMBER_COUNTRY_ID OURTM_REG_MEMBER_COUNTRY_ID KEY,   TRADEMARK_SOURCE_CODE TRADEMARK_SOURCE_CODE NOT NULL,   TRADEMARK_MEMBER_COUNTRY TRADEMARK_MEMBER_COUNTRY NOT NULL,   INSERT_USERID,   timestamp as TIMESTAMP,   UPDATE_USERID,   UPDATE_TIME from OURTRADEMARK_REG_MEMBER_COUNTRY\n");
    append(
        "select    GROUPID,   10018 as OURTRADEMARK_REGISTRATION_ID,   OURTM_REG_MEMBER_COUNTRY_ID OURTM_REG_MEMBER_COUNTRY_ID KEY,   TRADEMARK_SOURCE_CODE TRADEMARK_SOURCE_CODE NOT NULL,   TRADEMARK_MEMBER_COUNTRY TRADEMARK_MEMBER_COUNTRY NOT NULL,   INSERT_USERID,   timestamp as TIMESTAMP,   UPDATE_USERID,   UPDATE_TIME from OURTRADEMARK_REG_MEMBER_COUNTRY\n");
    append("select * from USER_PROCESS where groupid=1 and USERID=176 and INSERT_TIME>2020-08-21 09:33:40.691 and INSERT_TIME<2020-08-21 09:33:51.691\n");
    append("alter table delivery_addon_brand add foreign key f_brand (groupid, brandname) references brand (groupid, brandname)\n");
    append("alter table delivery_addon_brand add foreign key f_config (groupid, delivery_addon_config_id) references delivery_addon_config(groupid, delivery_addon_config_id)\n");
    append("alter table WIDGET column REFRESH_INTERVAL_MINS fixed(3)\n");
    append("alter table TRADEMARK_MEMBER_COUNTRY add foreign key f_country (TRADEMARK_MEMBER_COUNTRY) references country (countrycode)\n");
    append(
        "CREATE TABLE OURTRADEMARK_REG_MEMBER_COUNTRY (   GROUPID GROUPID KEY,   OURTRADEMARK_REGISTRATION_ID OURTRADEMARK_REGISTRATION_ID KEY,   OURTM_REG_MEMBER_COUNTRY_ID OURTM_REG_MEMBER_COUNTRY_ID key,   TRADEMARK_SOURCE_CODE TRADEMARK_SOURCE_CODE not null,   TRADEMARK_MEMBER_COUNTRY TRADEMARK_MEMBER_COUNTRY not null,   foreign key f_TRADEMARK_MEMBER_COUNTRY (TRADEMARK_SOURCE_CODE,TRADEMARK_MEMBER_COUNTRY)         references TRADEMARK_MEMBER_COUNTRY (TRADEMARK_SOURCE_CODE,TRADEMARK_MEMBER_COUNTRY),   foreign key f_OURTRADEMARK_REGISTRATION (GROUPID,OURTRADEMARK_REGISTRATION_ID)         references OURTRADEMARK_REGISTRATION (GROUPID,OURTRADEMARK_REGISTRATION_ID) )\n");
    append(
        "CREATE TABLE OURTRADEMARK_REG_MEMBER_COUNTRY (   GROUPID GROUPID KEY,   OURTRADEMARK_REGISTRATION_ID OURTRADEMARK_REGISTRATION_ID KEY,   OURTM_REG_MEMBER_COUNTRY_ID OURTM_REG_MEMBER_COUNTRY_ID key,   TRADEMARK_SOURCE_CODE TRADEMARK_SOURCE_CODE not null,   TRADEMARK_MEMBER_COUNTRY TRADEMARK_MEMBER_COUNTRY not null,   foreign key f_TRADEMARK_MEMBER_COUNTRY (TRADEMARK_SOURCE_CODE,TRADEMARK_MEMBER_COUNTRY)         references TRADEMARK_MEMBER_COUNTRY (TRADEMARK_SOURCE_CODE,TRADEMARK_MEMBER_COUNTRY),   foreign key f_OURTRADEMARK_REGISTRATION (GROUPID,OURTRADEMARK_REGISTRATION_ID)         references OURTRADEMARK_REGISTRATION (GROUPID,OURTRADEMARK_REGISTRATION_ID), )\n");
    append(
        "CREATE TABLE OURTRADEMARK_REG_MEMBER_COUNTRY (   GROUPID GROUPID KEY,   OURTRADEMARK_REGISTRATION_ID OURTRADEMARK_REGISTRATION_ID KEY,   OURTM_REG_MEMBER_COUNTRY_ID OURTM_REG_MEMBER_COUNTRY_ID key,   TRADEMARK_SOURCE_CODE TRADEMARK_SOURCE_CODE not null,   TRADEMARK_MEMBER_COUNTRY TRADEMARK_MEMBER_COUNTRY not null,   foreign key f_TRADEMARK_MEMBER_COUNTRY (TRADEMARK_SOURCE_CODE,TRADEMARK_MEMBER_COUNTRY)         references TRADEMARK_MEMBER_COUNTRY (TRADEMARK_SOURCE_CODE,TRADEMARK_MEMBER_COUNTRY),   foreign key f_OURTRADEMARK_REGISTRATION (GROUPID,OURTRADEMARK_REGISTRATION_ID)         references OURTRADEMARK_REGISTRATION (GROUPID,OURTRADEMARK_REGISTRATION_ID), )\n");
    append("create domain OURTM_REG_MEMBER_COUNTRY_ID fixed(2)\n");
    append("create domain OURTRADEMARK_REG_MEMBER_COUNTRY_ID fixed(2)\n");
    append(
        "create table TRADEMARK_MEMBER_COUNTRY (   TRADEMARK_SOURCE_CODE TRADEMARK_SOURCE_CODE key,   TRADEMARK_MEMBER_COUNTRY_ID TRADEMARK_MEMBER_COUNTRY_ID key,   TRADEMARK_MEMBER_COUNTRY TRADEMARK_MEMBER_COUNTRY not null,   begin_date date,   end_date date,   remarks long unicode,   foreign key f_trademark_source (TRADEMARK_SOURCE_CODE) references TRADEMARK_SOURCE (TRADEMARK_SOURCE_CODE) )\n");
    append(
        "create table TRADEMARK_MEMBER_COUNTRY (   TRADEMARK_SOURCE_CODE TRADEMARK_SOURCE_CODE key,   TRADEMARK_MEMBER_COUNTRY_ID TRADEMARK_MEMBER_COUNTRY_ID key   TRADEMARK_MEMBER_COUNTRY TRADEMARK_MEMBER_COUNTRY not null,   begin_date date,   end_date date,   remarks long unicode,   foreign key f_trademark_source (TRADEMARK_SOURCE_CODE) references TRADEMARK_SOURCE (TRADEMARK_SOURCE_CODE) )\n");
    append(
        "create table TRADEMARK_MEMBER_COUNTRY (   TRADEMARK_SOURCE_CODE TRADEMARK_SOURCE_CODE key,   TRADEMARK_MEMBER_COUNTRY_ID TRADEMARK_MEMBER_COUNTRY_ID key   TRADEMARK_MEMBER_COUNTRY TRADEMARK_MEMBER_COUNTRY not null,   begin_date date,   end_date date,   remarks long unicode,   foreign key f_trademark_source (TRADEMARK_SOURCE_CODE) references TRADEMARK_SOURCE (TRADEMARK_SOURCE_CODE) )\n");
    append("create domain TRADEMARK_MEMBER_COUNTRY_ID fixed(3)\n");
    append("create domain TRADEMARK_MEMBER_COUNTRY char(2)\n");
    append(
        "select * from CUSTOMER_SPECIAL_PRICE_REQUEST where (groupid,CUSTOMER_ADDRESS_ID,product_id) in (  select groupid,CUSTOMER_ADDRESS_ID,product_id from CUSTOMER_SPECIAL_PRICE_REQUEST except all select distinct groupid,CUSTOMER_ADDRESS_ID,product_id from CUSTOMER_SPECIAL_PRICE_REQUEST )\n");
    append("select groupid,CUSTOMER_ADDRESS_ID,product_id from CUSTOMER_SPECIAL_PRICE_REQUEST except all select distinct groupid,CUSTOMER_ADDRESS_ID,product_id from CUSTOMER_SPECIAL_PRICE_REQUEST\n");
    append("selecr distinct download_id from ava_product_download\n");
    append("alter table IT_TASK add constraint c_pendingfrom_deadline_date check TASK_DEADLINE is null or PENDING_FROM_DATE is null or PENDING_FROM_DATE<=TASK_DEADLINE\n");
    append("alter table IT_TASK add constraint c_pendingfrom_deadline_date check TASK_DEADLINE is null or PENDING_FROM_DATE is null or PENDING_FROM_DATE<=TASK_DEADLINE\n");
    append(
        "select groupid,DIVISIONCODE,PRODUCT_ID,COUNTRY_CODE from PRODUCT_COUNTRY_DIVISION where groupid=1 and DIVISIONCODE='ven'  select groupid,DIVISIONCODE,PRODUCT_ID,COUNTRY_CODE from SHOP_PRODUCT_COUNTRY_PRICE where groupid=1 and DIVISIONCODE='ven'\n");
    append(
        "select count(*) from CUSTOMER_REFUND where groupid=1 and STATUS='P' and REQUEST_DATE<subdate(date,7) and ORDER_ID in (   select order_id from CUSTOMER_REFUND where groupid=1 and and STATUS='P' and REQUEST_DATE<subdate(date,7)   except   select order_id from ORDERPOSITION where GROUPID=1 and OPEN_POSITION<0 )\n");
    append("INFO STATE\n");
    append("ALTER TABLE INTERNAL_PAGE ADD ( \tGENERATE_ENUM BOOLEAN DEFAULT FALSE NOT NULL, \tENUM_NAME VARCHAR(100) ASCII ) \n");
    append(
        "select * from ( select   'OP' as pos,   fixed(p.product_id,8) as \"ProductId{dbo:P}\",   fixed(op.location_id, 3) as loc,   left(p.brandname, 12) as brand,   left(p.modell, 12) as model,   fixed(op.INSERT_USERid, 4) as usr,   date(op.INSERT_TIME) as day,   fixed(op.DELIVERED_QUANTITY,4) as qty,   fixed(op.DELIVERED_QUANTITY*p.TOT_AVG_PURCHASE_PRICE,8,2) as value from PRODUCT p join orderposition op   on (p.groupid=op.groupid and p.product_id=op.product_id) where p.groupid=1 and op.ORDER_AGREEMENT_TYPE='LD'       and op.QUANTITY_ORDERED>0       and op.DELIVERED_QUANTITY>0 and op.DELIVERED_QUANTITY*p.TOT_AVG_PURCHASE_PRICE>=50 and date(op.INSERT_TIME)>=subdate(date, 60)  union all  select   'OP 60-180>100' as pos,   fixed(p.product_id,8) as ProductId{dbo:P}\",   fixed(op.location_id, 3) as loc,   left(p.brandname, 12) as brand,   left(p.modell, 12) as model,   fixed(op.INSERT_USERid, 4) as usr,   date(op.INSERT_TIME) as day,   fixed(op.DELIVERED_QUANTITY,4) as qty,   fixed(op.DELIVERED_QUANTITY*p.TOT_AVG_PURCHASE_PRICE,8,2) as value from PRODUCT p join orderposition op   on (p.groupid=op.groupid and p.product_id=op.product_id) where p.groupid=1 and op.ORDER_AGREEMENT_TYPE='LD'       and op.QUANTITY_ORDERED>0       and op.DELIVERED_QUANTITY>0 and op.DELIVERED_QUANTITY*p.TOT_AVG_PURCHASE_PRICE>=100 and date(op.INSERT_TIME)<subdate(date, 60) and date(op.INSERT_TIME)>=subdate(date, 180)  union all  select   'OP 180-730>1000' as pos,   fixed(p.product_id,8) as ProductId{dbo:P}\",   fixed(op.location_id, 3) as loc,   left(p.brandname, 12) as brand,   left(p.modell, 12) as model,   fixed(op.INSERT_USERid, 4) as usr,   date(op.INSERT_TIME) as day,   fixed(op.DELIVERED_QUANTITY,4) as qty,   fixed(op.DELIVERED_QUANTITY*p.TOT_AVG_PURCHASE_PRICE,8,2) as value from PRODUCT p join orderposition op   on (p.groupid=op.groupid and p.product_id=op.product_id) where p.groupid=1 and op.ORDER_AGREEMENT_TYPE='LD'       and op.QUANTITY_ORDERED>0       and op.DELIVERED_QUANTITY>0 and op.DELIVERED_QUANTITY*p.TOT_AVG_PURCHASE_PRICE>1000 and date(op.INSERT_TIME)<subdate(date, 180) and date(op.INSERT_TIME)>=subdate(date, 730)  union all  select   'SP' as pos,   fixed(p.product_id,8) as ProductId{dbo:P}\",   fixed(ps.location_id, 3) as loc,   left(p.brandname, 12) as brand,   left(p.modell, 12) as model,   fixed(ps.INSERT_USERid, 4) as usr,   date(value(ps.UPDATE_TIME, ps.INSERT_TIME)) as day,   fixed(ps.STOCK_BALANCE,4) as qty,   fixed(ps.STOCK_BALANCE*p.TOT_AVG_PURCHASE_PRICE,8,2) as value from PRODUCT p join PRODUCT_STOCKPLACE ps   on (p.groupid=ps.groupid and p.product_id=ps.product_id) where p.groupid=1 and ps.STOCK_PLACE_ID='Not_Found'       and STOCK_BALANCE>0 and ps.STOCK_BALANCE*p.TOT_AVG_PURCHASE_PRICE>25 and date(value(ps.UPDATE_TIME, ps.INSERT_TIME))>=subdate(date, 180) ) order by day desc\n");
    append(
        "select    author.USERID,   left(author.SHORT_USERNAME,10) as \"Author{command:user#$1}\",    FROM git_commit    join git_user git_author on (git_author.git_user_id=git_commit.author_id)   join x_user author on (author.userid=git_author.x_user_id and author.groupid=1)   join git_user git_committer on (git_committer.git_user_id=git_commit.committer_id)   join x_user committer on (committer.userid=git_committer.x_user_id and committer.groupid=1)   join git_repository gr on (gr.repository_id=git_commit.repository_id)   left join it_task_commit task_commit on (task_commit.repository_id=git_commit.repository_id and task_commit.git_commit_id=git_commit.git_commit_id) limit 10 order by commit_time desc\n");
    append(
        "SELECT DATE(COUNT_TIMESTAMP) FROM SHOPDB_TABLE_ROW_COUNT where COUNT_TIMESTAMP BETWEEN DATE(10.08.2020) AND DATE(16.08.2020)  GROUP BY DATE(COUNT_TIMESTAMP) ORDER BY DATE(COUNT_TIMESTAMP)\n");
    append(
        "SELECT * FROM FINTRANSACTION  LEFT OUTER JOIN FINTRANSACTION_MIRROR ON (FINTRANSACTION.GROUPID=FINTRANSACTION_MIRROR.GROUPID AND FINTRANSACTION.FINTRANSACTION_ID=FINTRANSACTION_MIRROR.FINTRANSACTION_ID_A and FINTRANSACTION_MIRROR.MIRROR_TYPE='Z') union all LEFT OUTER JOIN FINTRANSACTION_MIRROR ON (FINTRANSACTION.GROUPID=FINTRANSACTION_MIRROR.GROUPID AND FINTRANSACTION.FINTRANSACTION_ID=FINTRANSACTION_MIRROR.FINTRANSACTION_ID_B and FINTRANSACTION_MIRROR.MIRROR_TYPE='Z')  WHERE FINTRANSACTION.GROUPID=1 AND FINTRANSACTION.PENDING_USER IS NULL AND FINTRANSACTION.PAYMENT_CHECK_DATE IS NULL AND FINTRANSACTION.INVOICE_REFERENCE IS NOT NULL AND (FINTRANSACTION.FINACCOUNT_DEBIT=1025.00 OR FINTRANSACTION.PAYMENT_ACCOUNT_ID=1025.00 OR FINTRANSACTION.FINACCOUNT_CREDIT=1025.00) AND FINTRANSACTION_MIRROR.GROUPID IS NULL and FINTRANSACTION.TRANSACTION_DATE>'2020-08-17' \n");
    append(
        "select t.ASSIGNED_TO_USER as \"User\", count(*) as \"Pending\", sum(case when TASK_DATE>=subdate(date,60) then 1 else 0 end) as 60days from IT_TASK t join x_user u on u.groupid=t.groupid and u.userid=t.ASSIGNED_TO_USER and u.ACTIVEMODE in ('Y','T') where t.groupid=1 and t.TASK_STATUS=1 group by t.ASSIGNED_TO_USER order by \"Pending\" desc\n");
    append(
        "select t.ASSIGNED_TO_USER as \"User\", count(*) as \"Pending\" from IT_TASK t join x_user u on u.groupid=t.groupid and u.userid=t.ASSIGNED_TO_USER where t.groupid=1 and t.TASK_STATUS=1 group by t.ASSIGNED_TO_USER and u.ACTIVEMODE in ('Y','T') \n");
    append(
        "select * from ( select t.ASSIGNED_TO_USER as \"User\", count(*) as \"Pending\" from IT_TASK t join x_user u on u.groupid=t.groupid and u.userid=t.ASSIGNED_TO_USER where t.groupid=1 and t.TASK_STATUS=1 group by t.ASSIGNED_TO_USER and u.ACTIVEMODE in ('Y','T') )\n");
    append(
        "select * from ( select t.ASSIGNED_TO_USER as \"User\", count(*) as pending from IT_TASK t join x_user u on u.groupid=t.groupid and u.userid=t.ASSIGNED_TO_USER where t.groupid=1 and t.TASK_STATUS=1 group by t.ASSIGNED_TO_USER and u.ACTIVEMODE in ('Y','T') ) order by pending desc\n");
    append(
        "select t.ASSIGNED_TO_USER as \"User\", count(*) as pending from IT_TASK t join x_user u on u.groupid=t.groupid and u.userid=t.ASSIGNED_TO_USER where t.groupid=1 and t.TASK_STATUS=1 group by t.ASSIGNED_TO_USER and u.ACTIVEMODE in ('Y','T')\n");
    append("select ASSIGNED_TO_USER as \"User\", count(*) as pending from IT_TASK where groupid=1 and TASK_STATUS=1 group by \n");
    append("alter table TRADEMARK_TASK add foreign key f_TRADEMARK_REGISTRAR (groupid,TRADEMARK_REGISTRAR_ID) references TRADEMARK_REGISTRAR (groupid, TRADEMARK_REGISTRAR_ID)\n");
    append("alter table TRADEMARK_TASK add foreign key f_TRADEMARK_REGISTRAR (groupid,TRADEMARK_REGISTRAR_ID) references TRADEMARK_TASK (groupid, TRADEMARK_REGISTRAR_ID)\n");
    append("alter table TRADEMARK_COUNTRY_INFO add foreign key f_TRADEMARK_REGISTRAR (groupid, TRADEMARK_REGISTRAR_ID ) references TRADEMARK_REGISTRAR (groupid, TRADEMARK_REGISTRAR_ID)\n");
    append(
        "ALTER TABLE OURTRADEMARK_REGISTRATION   ADD FOREIGN KEY F_TRADEMARK_REGISTRAR     (GROUPID, TRADEMARK_REGISTRAR_ID)   REFERENCES TRADEMARK_REGISTRAR     (GROUPID, TRADEMARK_REGISTRAR_ID)\n");
    append(
        "alter table OURTRADEMARK_ISSUE add foreign key f_OURTRADEMARK_REGISTRATION (groupid, OURTRADEMARK_REGISTRATION_ID) references OURTRADEMARK_REGISTRATION (groupid, OURTRADEMARK_REGISTRATION_ID)\n");
    append(
        "alter table OURTRADEMARK_MESSAGEOUT add foreign key f_OURTRADEMARK_REGISTRATION (groupid, OURTRADEMARK_REGISTRATION_ID) references OURTRADEMARK_REGISTRATION (groupid, OURTRADEMARK_REGISTRATION_ID)\n");
    append(
        "alter table OURTRADEMARK_MESSAGEIN add foreign key f_OURTRADEMARK_REGISTRATION (groupid, OURTRADEMARK_REGISTRATION_ID) references OURTRADEMARK_REGISTRATION (groupid, OURTRADEMARK_REGISTRATION_ID)\n");
    append("alter table OURTRADEMARK_MESSAGEIN add foreign key f_OURTRADEMARK_REGISTRATION (groupid, OURTRADEMARK_REGISTRATION_ID) references (groupid, OURTRADEMARK_REGISTRATION_ID)\n");
    append(
        "create table user_process_bag_entry (  USER_PROCESS_ID USER_PROCESS_ID KEY,  BAG_ENTRY_ID FIXED(9) KEY,  PROCESS_START TIMESTAMP NOT NULL,  PROCESS_END TIMESTAMP,  END_MODE CHAR(1) ASCII,  TARGET_HASH JAVA_HASHCODE NOT NULL,  TARGET_CLASS_ID CLASS_ID,  TARGET_OBJECT_ID VARCHAR(255) UNICODE,  PROCESS_OUTPUT LONG UNICODE,  REMARKS LONG UNICODE,  FOREIGN KEY (USER_PROCESS_ID) REFERENCES USER_PROCESS (USER_PROCESS_ID),  FOREIGN KEY (END_MODE) REFERENCES USER_PROCESS_END_MODE (END_MODE), )\n");
    append("alter table USER_PROCESS add BAG_TARGET BOOLEAN DEFAULT FALSE\n");
    append("select count(*) from address where company is not null groupid=1 and countrycode='GB'\n");
    append("alter table BRAND add constraint c_venoa_brand_finalizer_zero check MAIN_DIVISION is null or not (groupid=1 and MAIN_DIVISION='ven' and PRICE_FINALIZER_RATIO<>0)\n");
    append("alter table BRAND add constraint c_venoa_brand_finalizer_zero check not (groupid=1 and MAIN_DIVISION='ven' and (PRICE_FINALIZER_RATIO is null or PRICE_FINALIZER_RATIO<>0))\n");
    append("alter table BRAND add constraint c_venoa_brand_finalizer_zero check not (groupid=1 and PRICE_FINALIZER_RATIO<>0 and MAIN_DIVISION='ven')\n");
    append(
        "elect brandname, max(sender_division) as division from temp_division_brand_total where (brandname, total) in (  select brandname, max(total) from temp_division_brand_total where brandname in (select brandname from brand where groupid=1 and main_division is null) group by brandname  ) group by brandname having count(*)=1\n");
    append(
        "update brand set main_division='ven' where where groupid=1 and brandname in (  select brandname from (  select brandname, case when total_MAX>total_MIN then SENDER_DIVISION_MAX else SENDER_DIVISION_MIN end as division from (  select A.brandname, A.SENDER_DIVISION_MIN, B.SENDER_DIVISION_MAX, AA.total as total_MIN, BB.total as total_MAX  from  ( select brandname, min(sender_division) as sender_division_min from temp_division_brand_total where brandname in (   select brandname from temp_division_brand_total group by brandname having count(*)=2 ) group by brandname ) A  join  ( select brandname, max(sender_division) as sender_division_max from temp_division_brand_total where brandname in (   select brandname from temp_division_brand_total group by brandname having count(*)=2 ) group by brandname ) B  on a.brandname=b.brandname  join temp_division_brand_total AA on A.brandname=AA.brandname and A.sender_division_min = AA.sender_division  join temp_division_brand_total BB on B.brandname=BB.brandname and B.sender_division_max = BB.sender_division  where AA.total<>BB.total )  ) where division='ven'  ) and main_division is null\n");
    append(
        "select brandname from ( select sender_division, brandname from temp_division_brand_total where brandname in (   select brandname from temp_division_brand_total group by brandname having count(*)=1 )) where sender_division='mus')\n");
    append(
        "select brandname from (  select sender_division, brandname from temp_division_brand_total where brandname in (    select brandname from temp_division_brand_total group by brandname having count(*)=1  )  where sender_division='mus')\n");
    append(
        "select count(*) from brand where groupid=1 and brandname in (select brandname from (  select sender_division, brandname from temp_division_brand_total where brandname in (    select brandname from temp_division_brand_total group by brandname having count(*)=1  )  where sender_division='mus')) and main_division is null\n");
    append(
        "select count(*) from brand where groupid=1 and brandname in (select brandname from (  select sender_division, brandname from temp_division_brand_total where brandname in (    select brandname from temp_division_brand_total group by brandname having count(*)=1  )  and sender_division='mus') and main_division is null\n");
    append(
        "select count(*) from brand where groupid=1 and brandname in (select brandname from (  select sender_division, brandname from temp_division_brand_total where brandname in (    select brandname from temp_division_brand_total group by brandname having count(*)=1  )  where sender_division='mus') and main_division is null\n");
    append(
        "select count(*) from brand where groupid=1 and brandname in select brandname from (  select sender_division, brandname from temp_division_brand_total where brandname in (    select brandname from temp_division_brand_total group by brandname having count(*)=1  )  where sender_division='mus') and main_division is null\n");
    append("rename table temp_division_bran_total to temp_division_brand_total\n");
    append(
        "create table temp_division_bran_total temp as select o.sender_division, p.brandname, count(*) as total from product p join orderposition op on (p.groupid=op.groupid and p.product_id=op.product_id) join ordermain o on (o.groupid=op.groupid and o.order_id=op.order_id) join brand b on (b.groupid=p.groupid and b.brandname=p.brandname) group by o.sender_division, p.brandname\n");
    append(
        "create table temp_division_bran_total as select o.sender_division, p.brandname, count(*) as total from product p join orderposition op on (p.groupid=op.groupid and p.product_id=op.product_id) join ordermain o on (o.groupid=op.groupid and o.order_id=op.order_id) join brand b on (b.groupid=p.groupid and b.brandname=p.brandname) group by o.sender_division, p.brandname  temp\n");
    append("alter table PRODUCT add foreign key f_main_division (groupid, main_division) references division (groupid,DIVISIONCODE)\n");
    append("alter table brand add foreign key f_main_division (groupid, main_division) references division (groupid,DIVISIONCODE)\n");
    append("rename column ordermain.delivery_warning_unicode to delivery_warning\n");
    append("rename column ordermain.delivery_warning to delivery_warning_old\n");
    append("select * from PRODUCT_COUNTRY where groupid=1 and DIVISIONCODE<>'mus' and DIVISIONCODEis not null\n");
    append("select * from ava_publisher where publisher_id in select publisher_id from ava_product_download group by publisher_id having count(*) > 10000 order by count(*) desc\n");
    append("select publisher_id, count(*) from ava_product_download  group by publisher_id count(*) > 10000 order by count(*) desc\n");
    append(
        "select publisher_id, count(*) from ava_product_download  inner join ava_publisher on ava_product_download.publisher_id = ava_publisher.publisher_id group by publisher_id count(*) > 10000 order by count(*) desc\n");
    append("update int_message set order_id=null and order_pos_id=null where groupid=1 and order_id=540237\n");
    append("update int_message set order_id=null andorder_pos_id=null where groupid=1 and order_id=540237\n");
    append("alter table SUBSERIES add constraint c_advertcode check ADVERT_CODE is null or ADVERT_CODE<>'A'\n");
    append("alter table SUBSERIES add constraint c_advertcode check ADVERT_CODE is null or ADVERT_CODE<>'A'\n");
    append("alter table SERIES add constraint c_advertcode check ADVERT_CODE is null or ADVERT_CODE<>'A'\n");
    append("alter table SERIES add constraint c_advertcode check ADVERT_CODE is null or ADVERT_CODE<>'A'\n");
    append("alter table PRODUCTGROUP_COUNTRY add constraint c_advertcode check ADVERT_CODE is null or ADVERT_CODE<>'A'\n");
    append("alter table PRODUCTGROUP add constraint c_advertcode check ADVERT_CODE is null or ADVERT_CODE<>'A'\n");
    append("alter table ITEM_SUB_SERIES_COUNTRY add constraint c_advertcode check ADVERT_CODE is null or ADVERT_CODE<>'A'\n");
    append("alter table ITEM_SERIES_COUNTRY add constraint c_advertcode check ADVERT_CODE is null or ADVERT_CODE<>'A'\n");
    append("alter table ITEM_SERIES_COUNTRY add constraint c_advertcode check ADVERT_CODE is null or ADVERT_CODE<>'A'\n");
    append("alter table BRAND_SUB_GROUP_COUNTRY add constraint c_advertcode check ADVERT_CODE is null or ADVERT_CODE<>'A'\n");
    append("alter table BRAND_SUB_GROUP add constraint c_advertcode check ADVERT_CODE is null or ADVERT_CODE<>'A'\n");
    append("alter table BRAND_PRODUCTGROUP_COUNTRY add constraint c_advertcode check ADVERT_CODE is null or ADVERT_CODE<>'A'\n");
    append("alter table BRAND_PRODUCTGROUP add constraint c_advertcode check ADVERT_CODE is null or ADVERT_CODE<>'A'\n");
    append("alter table BRAND_GROUP_COUNTRY add constraint c_advertcode check ADVERT_CODE is null or ADVERT_CODE<>'A'\n");
    append("alter table BRAND_COUNTRY add constraint c_advertcode check ADVERT_CODE is null or ADVERT_CODE<>'A'\n");
    append("alter table BRAND_COUNTRY add constraint c_advertcode check ADVERT_CODE is null or ADVERT_CODE<>'A'\n");
    append("alter table BRAND_COUNTRY add constraint c_advertcode check ADVERT_CODE is null or ADVERT_CODE<>'A'\n");
    append("alter table BRAND add constraint c_advertcode check ADVERT_CODE is null or ADVERT_CODE<>'A'\n");
    append("alter table BRAND add constraint c_advertcode check ADVERT_CODE is null or ADVERT_CODE<>'A'\n");
    append("alter table BRAND add constraint c_advertcode check ADVERT_CODE is null or ADVERT_CODE<>'A'\n");
    append("alter table BRAND add constraint c_advertcode check ADVERT_CODE is null or ADVERT_CODE<>'A'\n");
    append("alter table BRAND add constraint c_advertcode check ADVERT_CODE is null or ADVERT_CODE<>'A'\n");
    append("alter table BRAND add constraint c_advertcode check ADVERT_CODE is null or ADVERT_CODE<>'A'\n");
    append("alter table BRAND add constraint c_advertcode check ADVERT_CODE is null or ADVERT_CODE<>'A'\n");
    append("alter table PRODUCT add constraint c_advertcode check ADVERT_CODE is null or ADVERT_CODE<>'A'\n");
    append(
        "insert into product_division select groupid, 'mus', product_id, 'A', 10, timestamp, null, null from PRODUCT where groupid=1 and ADVERT_CODE='A' where product_id not in (select product_id from product_division where groupid=1 and divisioncode='mus')\n");
    append("alter table PRODUCT add constraint c_advertcode check ADVERT_CODE is null or ADVERT_CODE<>'A'\n");
    append("alter table PRODUCT_COUNTRY add constraint c_advertcode check ADVERT_CODE is null or ADVERT_CODE<>'A'\n");
    append("select count(*) from PRODUCT_COUNTRY where ADVERT_CODE is not null 'A'\n");
    append(
        "update PRODUCT_COUNTRY set ADVERT_CODE=null where groupid=1 and ADVERT_CODE='A'    and product_id in (select product_id from product where KATEGORIENR in (select kategorienr from productgroup                       where groupid=1 and CATEGORY_KEYS_PATH like '1-2-%')) )\n");
    append(
        "update PRODUCT_COUNTRY set ADVERT_CODE=null where groupid=1 and ADVERT_CODE='A'    and product_id in (select product_id from product where KATEGORIENR in (select kategorienr from productgroup                       where groupid=1 and CATEGORY_KEYS_PATH like '1-2-%')) )\n");
    append("insert into PRODUCT_DIVISION expression1, expression2, -- product_id, expression3, expression4, timestamp  from x_pd\n");
    append(
        "create table temp x_pd as  select 1, 'mus', product_id, 'A', 10, timestamp, null, null from ( select product_id from PRODUCT_COUNTRY where groupid=1 and ADVERT_CODE='A'    and product_id in (select product_id from product where KATEGORIENR in (select kategorienr from productgroup where groupid=1 and CATEGORY_KEYS_PATH like '1-2-%')) except select product_id from PRODUCT_COUNTRY where groupid=1 and (ADVERT_CODE is null or ADVERT_CODE<>'A')  )\n");
    append(
        "select count(*) from PRODUCT_COUNTRY where groupid=1 and ADVERT_CODE='A' and product_id not in (select product_id from orderposition where groupid=1 and quantity>0                        and insert_time>subdate(date,720) & ' 00:00:00.0') )\n");
    append("alter table work_unit modify valid_since not null\n");
    append("alter table work_unit modify valid_since default date\n");
    append("alter table work_unit modify column valid_since default date\n");
    append("alter table work_unit column valid_since default date\n");
    append("alter table work_unit column valid_since default date not null\n");
    append("alter table work_unit modify valid_since date not null defautl date\n");
    append("alter table work_unit modify valid_since date defautl date not null\n");
    append("select DIVISIONCODE,COUNTRY_CODE,LANGUAGE_CODE count(*) from GOOGLE_SHOPPING_PRODUCT group by DIVISIONCODE, COUNTRY_CODE, LANGUAGE_CODE\n");
    append("create domain iconname varchar(100)\n");
    append("select count(*) from PRODUCT_COUNTRY_DIVISION where groupid=1 and divisioncode='ven' and (CALC_ADVERT_CODE='A' or CALC_ENOUGH_QUANTITY and CALC_ADVERT_CODE in ('S', 'P')\n");
    append("select top 3000 from ava_artist\n");
    append("DELETE FROM SDB_SHOP_LOCATION_IMAGE_DIV WHERE DIVISIONCODE='all' DELETE FROM SDB_SHOP_LOC_DIV_COUNTRY_LANG WHERE DIVISIONCODE='all'\n");
    append(
        "DELETE FROM SDB_SHOP_PRODUCT_COUNTRY_PRICE WHERE DIVISIONCODE='all' DELETE FROM SDB_SHOP_PRODUCT_WEBSITE_TAG WHERE DIVISIONCODE='all' DELETE FROM SDB_SHOP_SERIES_WEBSITE_TAG WHERE DIVISIONCODE='all' DELETE FROM SDB_SHOP_SUB_SERIES_WEBSITE_TAG WHERE DIVISIONCODE='all' DELETE FROM SDB_UPG_PROD_PRICE WHERE DIVISIONCODE='all'\n");
    append("DELETE FROM SDB_LEGAL_INFO WHERE DIVISIONCODE='all' DELETE FROM SDB_SHOP_BRAND_WEBSITE_TAG WHERE DIVISIONCODE='all' DELETE FROM SDB_SHOP_CATEGORY_COUNTRY WHERE DIVISIONCODE='all'\n");
    append("ALTER TABLE USER_ALERT   ADD FOREIGN KEY FK_PHONE_CALL     (GROUPID, PHONE_CALL_ID)   REFERENCES PHONE_CALL     (GROUPID, PHONE_CALL_ID)\n");
    append("select count(*) from ava_product_download where download_id=\n");
    append("CREATE TABLE HARDWARE_REQUEST_DOCUMENT alter primary key (   GROUPID ,   HARDWARE_REQUEST_ID,   DOCUMENT_INDEX)\n");
    append("alter table SUPPLIER_WRONG_DELIVERY_PROBLEM add foreign key f_distributor (groupid, SUPPLIER_ID)   references DISTRIBUTOR (groupid, address_id)\n");
    append("alter table HARDWARE_REQUEST_DOCUMENT add constraint c_scan_datafile check decode(data_key,null,0,1)+decode(scan_document_id,null,0,1)=1\n");
    append(
        "create table HARDWARE_REQUEST_DOCUMENT (   groupid groupid key,   HARDWARE_REQUEST_ID HARDWARE_REQUEST_ID key,   document_index fixed(2),   data_key data_key,   scan_document_id scan_document_id,   foreign key f_hardware_request (groupid, HARDWARE_REQUEST_ID) references HARDWARE_REQUEST (groupid, HARDWARE_REQUEST_ID),   foreign key f_datafile (groupid, data_key) references datafile (groupid, data_key),   foreign key f_scan_document (groupid, scan_document_id) references scan_document (groupid, scan_document_id) )\n");
    append("alter table HARDWARE_REQUEST column FOR_USERID not null\n");
    append("alter table HARDWARE_REQUEST column REQUEST_DATE add default date\n");
    append(
        "create table HARDWARE_REQUEST (   groupid groupid key,   HARDWARE_REQUEST_ID HARDWARE_REQUEST_ID,   HARDWARE_REQUEST_TITLE varchar(50) not null,   request_status hardware_request_status default 1 not null,   request_date date default date not null,   request_priority priority,   shipping_date date,   reception_confirmed_date date,   for_userid userid,   for_address_id address_id,   for_contact_id contact_id,   for_location_id location_id,   request_remarks long unicode,   foreign key f_user (groupid, for_userid)       references X_USER (groupid, userid),   foreign key f_address (groupid, for_address_id)       references address (groupid, address_id),   foreign key f_contact       (groupid, for_address_id, for_contact_id)       references contact (groupid, address_id, contact_id),   foreign key f_ourlocation (groupid, for_location_id)       references ourlocation (groupid, location_id)   )\n");
    append(
        "create table HARDWARE_REQUEST (   groupid groupid key,   HARDWARE_REQUEST_ID HARDWARE_REQUEST_ID,   request_status hardware_request_status default 1 not null,   request_date date default date not null,   request_priority priority,   shipping_date date,   reception_confirmed_date date,   for_userid userid,   for_address_id address_id,   for_contact_id contact_id,   for_location_id location_id,   request_remarks long unicode,   foreign key f_user (groupid, for_userid)       references X_USER (groupid, userid),   foreign key f_address (groupid, for_address_id)       references address (groupid, address_id),   foreign key f_contact       (groupid, for_address_id, for_contact_id)       references contact (groupid, address_id, contact_id),   foreign key f_ourlocation (groupid, for_location_id)       references ourlocation (groupid, location_id)   )\n");
    append(
        "create table HARDWARE_REQUEST (   groupid groupid key,   HARDWARE_REQUEST_ID HARDWARE_REQUEST_ID,   request_status hardware_request_status default 1 not null,   request_date date default date not null,   shipping_date date,   reception_confirmed_date date,   for_userid userid,   for_address_id address_id,   for_contact_id contact_id,   for_location_id location_id,   request_remarks long unicode,   foreign key f_user (groupid, for_userid)       references X_USER (groupid, userid),   foreign key f_address (groupid, for_address_id)       references address (groupid, address_id),   foreign key f_contact       (groupid, for_address_id, for_contact_id)       references contact (groupid, address_id, contact_id),   foreign key f_ourlocation (groupid, for_location_id)       references ourlocation (groupid, location_id)   )\n");
    append(
        "create table HARDWARE_REQUEST (   groupid groupid key,   HARDWARE_REQUEST_ID HARDWARE_REQUEST_ID,   request_status hardware_request_status default 1 not null,   request_date date default date not null,   shipping_date date,   reception_confirmed_date date,   for_userid userid,   for_address_id address_id,   for_contact_id contact_id,   for_location_id location_id,   request_remarks long unicode,   foreign key f_user (groupid, for_userid)       references X_USER (groupid, userid),   foreign key f_address (groupid, for_address_id)       references address (groupid, address_id),   foreign key f_contact       (groupid, for_address_id, for_contact_id)       references contact (groupid, address_id, contact_id),   foreign key f_ourlocation (groupid, for_location_id)       references ourlocation (groupid, ourlocation_id)   )\n");
    append(
        "create table HARDWARE_REQUEST (   groupid groupid key,   HARDWARE_REQUEST_ID HARDWARE_REQUEST_ID,   request_status hardware_request_status default 1 not null,   request_date date default date not null,   shipping_date date,   reception_confirmed_date date,   for_userid userid,   for_address_id address_id,   for_contact_id contact_id,   for_location_id location_id,   request_remarks long unicode,   foreign key f_user (groupid, for_userid)       references X_USER (groupid, for_userid),   foreign key f_address (groupid, for_address_id)       references address (groupid, address_id),   foreign key f_contact       (groupid, for_address_id, for_contact_id)       references contact (groupid, address_id, contact_id),   foreign key f_ourlocation (groupid, for_location_id)       references ourlocation (groupid, ourlocation_id)   )\n");
    append(
        "create table HARDWARE_REQUEST (   groupid groupid key,   HARDWARE_REQUEST_ID HARDWARE_REQUEST_ID,   request_status hardware_request_status default 1 not null,   request_date date default date not null,   shipping_date date,   reception_confirmed_date date,   for_userid userid,   for_address_id address_id,   for_contact_id contact_id,   for_location_id location_id,   request_remarks long unicode,   foreign key f_user (groupid, request_userid)       references X_USER (groupid, for_userid),   foreign key f_address (groupid, for_address_id)       references address (groupid, address_id),   foreign key f_contact       (groupid, for_address_id, for_contact_id)       references contact (groupid, address_id, contact_id),   foreign key f_ourlocation (groupid, for_location_id)       references ourlocation (groupid, ourlocation_id)   )\n");
    append("create domain HARDWARE_REQUEST_id fixed(6)\n");
    append(
        "create table HARDWARE_REQUEST (   groupid groupid key,   HARDWARE_REQUEST_ID HARDWARE_REQUEST_ID,   request_status hardware_request_status default 1 not null,   request_date date default date not null,   shipping_date date,   reception_confirmed_date date,   for_userid userid,   for_address_id address_id,   for_contact_id contact_id,   for_location_id ourlocation,   request_remarks long unicode,   foreign key f_user (groupid, request_userid)       references X_USER (groupid, for_userid),   foreign key f_address (groupid, for_address_id)       references address (groupid, address_id),   foreign key f_contact       (groupid, for_address_id, for_contact_id)       references contact (groupid, address_id, contact_id),   foreign key f_ourlocation (groupid, for_location_id)       references ourlocation (groupid, ourlocation_id)   )\n");
    append("create domain hardware_request_status fixed(1)\n");
    append("create domain HARDWARE_REQUEST_id fixed(6)\n");
    append("create domain HARDWARE_REQUEST_id fixe(6)\n");
    append(
        "create table HARDWARE_REQUEST (   groupid groupid key,   HARDWARE_REQUEST_ID HARDWARE_REQUEST_ID,   request_status hardware_request_status default 1 not null,   request_date date default date not null,   shipping_date date,   reception_confirmed_date date,   for_userid userid,   for_address_id address_id,   for_contact_id contact_id,   for_location_id ourlocation,   request_remarks long unicode,   foreign key f_user (groupid, request_userid)       references X_USER (groupid, for_userid),   foreign key f_address (groupid, for_address_id)       references address (groupid, address_id),   foreign key f_contact       (groupid, for_address_id, for_contact_id)       references contact (groupid, address_id, contact_id),   foreign key f_ourlocation (groupid, for_location_id)       references ourlocation (groupid, ourlocation_id)   )\n");
    append("select count(*) from ava_product_download where download_id=6 select count(*) from ava_artist select count(*) from ava_publisher\n");
    append(
        "ALTER TABLE DELIVERY ADD CONSTRAINT C_VAT_SWISS CHECK ADDRESS_ID IN(1767, 24433, 25934, 25967, 326339, 405150) OR (NOT (GROUPID=1 AND DELIVERY_DATE>='2011-09-01' AND INCOMING=FALSE AND DEL_VATCODE=0 AND VAT_COUNTRY_CODE='CH' AND OTHER_COUNTRY_CODE='CH' AND VAT_EXEMPTION_CONFIRMATION_ID IS NULL) AND NOT (GROUPID=1 AND DELIVERY_DATE>='2011-09-01' AND INCOMING=FALSE AND DEL_VATCODE=0 AND VAT_COUNTRY_CODE='CH' AND FORWARDERMODE IN ('E','W') AND VAT_EXEMPTION_CONFIRMATION_ID IS NULL))\n");
    append(
        "ALTER TABLE ORDERMAIN ADD CONSTRAINT C_VAT_SWISS CHECK ADDRESS_ID IN(1767, 24433, 25934, 25967, 326339, 405150) OR (NOT (GROUPID=1 AND ORDER_DATE>='2011-09-01' AND PURCHASE=FALSE AND V_L_MWSTCODE=0 AND VAT_COUNTRY_CODE='CH' AND OTHER_COUNTRY_CODE='CH' AND VAT_EXEMPTION_CONFIRMATION_ID IS NULL) AND NOT (GROUPID=1 AND ORDER_DATE>='2011-01-01' AND PURCHASE=FALSE AND V_L_MWSTCODE=0 AND VAT_COUNTRY_CODE='CH' AND FORWARDERMODE IN ('E','W') AND VAT_EXEMPTION_CONFIRMATION_ID IS NULL))\n");
    append(
        "ALTER TABLE ORDERMAIN ADD CONSTRAINT C_VAT_SWISS CHECK ADDRESS_ID IN(1767, 24433, 25934, 25967, 326339, 405150) OR (NOT (GROUPID=1 AND ORDER_DATE>='2011-09-01' AND PURCHASE=FALSE AND V_L_MWSTCODE=0 AND VAT_COUNTRY_CODE='CH' AND OTHER_COUNTRY_CODE='CH' AND VAT_EXEMPTION_CONFIRMATION_ID IS NULL) AND NOT (GROUPID=1 AND ORDER_DATE>='2011-01-01' AND PURCHASE=FALSE AND V_L_MWSTCODE=0 AND VAT_COUNTRY_CODE='CH' AND FORWARDERMODE IN ('E','W') AND VAT_EXEMPTION_CONFIRMATION_ID IS NULL))\n");
    append(
        "ALTER TABLE ORDERMAIN ADD CONSTRAINT C_VAT_SWISS CHECK ADDRESS_ID IN(1767, 24433, 25934, 25967, 326339, 405150) OR (NOT (GROUPID=1 AND ORDER_DATE>='2011-09-01' AND PURCHASE=FALSE AND V_L_MWSTCODE=0 AND VAT_COUNTRY_CODE='CH' AND OTHER_COUNTRY_CODE='CH' AND VAT_EXEMPTION_CONFIRMATION_ID IS NULL) AND NOT (GROUPID=1 AND ORDER_DATE>='2011-01-01' AND PURCHASE=FALSE AND V_L_MWSTCODE=0 AND VAT_COUNTRY_CODE='CH' AND FORWARDERMODE IN ('E','W') AND VAT_EXEMPTION_CONFIRMATION_ID IS NULL))\n");
    append("select * from x_user wher true limit 2\n");
    append("select * from x_user wher true limit 2\n");
    append("select * from x_user wher true limit 2\n");
    append("select * from x_user wher true limit 2\n");
    append("select * from x_user wher true limit 2\n");
    append("select * from x_user wher firstname='\n");
    append("select * from x_user where firstname='\n");
    append("select * from x_user wher firstname='\n");
    append("select * from x_user where firstname='\n");
    append(
        "SELECT * FROM CUSTOMER_RETURN   INNER JOIN ORDERMAIN ON (CUSTOMER_RETURN.GROUPID=ORDERMAIN.GROUPID AND CUSTOMER_RETURN.ORDER_ID=ORDERMAIN.ORDER_ID)  LEFT OUTER JOIN BANK_ACCOUNT ON (ORDERMAIN.GROUPID=BANK_ACCOUNT.GROUPID AND ORDERMAIN.INVOICE_ADDRESS_ID=BANK_ACCOUNT.ADDRESS_ID) WHERE  CUSTOMER_RETURN.GROUPID=1 AND  CUSTOMER_RETURN.RETURN_STATUS=3 AND  RETURN_STATUS_DATE<'2020-08-10' AND  RETURN_REQUEST_DATE>'2019-01-01' AND  ORDERMAIN.ORDER_DATE>'2016-09-16' AND and CUSTOMER_RETURN_ID=6611\n");
    append("SELECT * FROM IT_TASK WHERE TASK_TITLE LIKE '%\n");
    append("alter table PRODUCT_COUNTRY_DIVISION add foreign key f_DIVISION (groupid, DIVISIONCODE) references DIVISION (groupid, DIVISIONCODE)\n");
    append("alter table work_unit add generate_enum boolean default true not null\n");
    append("alter table sub_department add generate_enum boolean default true not null\n");
    append("alter table department add generate_enum boolean default true not null\n");
    append(
        "ALTER TABLE DELIVERY ADD CONSTRAINT C_VAT_SWISS CHECK ADDRESS_ID IN(1767, 24433, 25934, 25967, 326339) OR (NOT (GROUPID=1 AND DELIVERY_DATE>='2011-09-01' AND INCOMING=FALSE AND DEL_VATCODE=0 AND VAT_COUNTRY_CODE='CH' AND OTHER_COUNTRY_CODE='CH' AND VAT_EXEMPTION_CONFIRMATION_ID IS NULL) AND NOT (GROUPID=1 AND DELIVERY_DATE>='2011-09-01' AND INCOMING=FALSE AND DEL_VATCODE=0 AND VAT_COUNTRY_CODE='CH' AND FORWARDERMODE IN ('E','W') AND VAT_EXEMPTION_CONFIRMATION_ID IS NULL))\n");
    append(
        "ALTER TABLE ORDERMAIN ADD CONSTRAINT C_VAT_SWISS CHECK ADDRESS_ID IN(1767, 24433, 25934, 25967, 326339) OR (NOT (GROUPID=1 AND ORDER_DATE>='2011-09-01' AND PURCHASE=FALSE AND V_L_MWSTCODE=0 AND VAT_COUNTRY_CODE='CH' AND OTHER_COUNTRY_CODE='CH' AND VAT_EXEMPTION_CONFIRMATION_ID IS NULL) AND NOT (GROUPID=1 AND ORDER_DATE>='2011-01-01' AND PURCHASE=FALSE AND V_L_MWSTCODE=0 AND VAT_COUNTRY_CODE='CH' AND FORWARDERMODE IN ('E','W') AND VAT_EXEMPTION_CONFIRMATION_ID IS NULL))\n");
    append(
        "SELECT * FROM PRODUCT   INNER JOIN SUPPLIER_PRODUCT ON (PRODUCT.GROUPID=SUPPLIER_PRODUCT.GROUPID AND PRODUCT.PRODUCT_ID=SUPPLIER_PRODUCT.PRODUCT_ID)   WHERE  SUPPLIER_PRODUCT.GROUPID=1 AND  SUPPLIER_PRODUCT.SUPPLIER_ID=6588 AND  SUPPLIER_PRODUCT.NO_SUPPLIERS_ORDER=FALSE AND  PRODUCT.BRANDNAME='Latin Percussion' AND  LOWER(TRANSLATE(PRODUCT.HERSTELLERNR, '.:,\n");
    append(
        "SELECT * FROM PRODUCT   INNER JOIN SUPPLIER_PRODUCT ON (PRODUCT.GROUPID=SUPPLIER_PRODUCT.GROUPID AND PRODUCT.PRODUCT_ID=SUPPLIER_PRODUCT.PRODUCT_ID)   WHERE  SUPPLIER_PRODUCT.GROUPID=1 AND  SUPPLIER_PRODUCT.SUPPLIER_ID=6588 AND  SUPPLIER_PRODUCT.NO_SUPPLIERS_ORDER=FALSE AND  PRODUCT.BRANDNAME='Latin Percussion' AND  LOWER(TRANSLATE(PRODUCT.HERSTELLERNR, '.:,\n");
    append("select * from SUPPLIER_LP_UPDATE_LINE where brandname = 'Bonmusica' where OLD_SUPPLIER_ITEM_CODE like '%.%'\n");
    append("alter table point_of_sale_fiskaly add column tss_id\n");
    append("alter table point_of_sale_fiskaly rename column external_pos_id to tss_id\n");
    append("alter table point_of_sale_fiskaly rename column external_pos_id tss_id\n");
    append("alter table point_of_sale_fiskaly rename external_pos_id tss_id\n");
    append("alter table point_of_sale_fiskaly add client_id\n");
    append("alter table point_of_sale_fiskaly_seller foreign key f_user (groupid, userid) references x_user(groupid, userid)\n");
    append("alter table point_of_sale_fiskaly_seller foreign key f_fiskaly_pos (groupid, fiskaly_pos_id) references point_of_sale_fiskaly(groupid, fiskaly_pos_id)\n");
    append(
        "create table point_of_sale_fiskaly_seller (   groupid groupid key,   fiskaly_pos_id fiskaly_pos_id key,   fiskaly_seller_id fixed(4) key,   userid userid,   external_seller_id char(36), )\n");
    append("alter table point_of_sale_fiskaly add foreign key f_pos (groupid, pos_id) references point_of_sale(groupid, pos_id)\n");
    append(
        "create table point_of_sale_fiskaly_seller (   groupid groupid key,   fiskaly_pos_id fiskaly_pos_id key,   fiskaly_seller_id fixed(4) key,   userid userid,   external_seller_id char(36), )\n");
    append("alter table point_of_sale_fiskaly add foreign key f_pos (groupid, pos_id) references point_of_sale(groupid, pos_id)\n");
    append("create domain fiskaly_pos_id fixed(5)\n");
    append("select * from messageout where rma_id_cust is not null order messageout_id limit 10\n");
    append("select * from messageout where rma_id_cust not null limit 10\n");
    append("alter table BANK_CARD_ISSUE replace primary key (groupid,bank_card_ISSUE_ID)\n");
    append("alter table BANK_CARD_ISSUE column bank_card_ISSUE_ID not null\n");
    append("alter table BANK_CARD_ISSUE_DOCUMENT column bank_card_ISSUE_ID not null\n");
    append("alter table BANK_CARD_ISSUE_HOLDER column bank_card_ISSUE_ID not null\n");
    append("create domain bank_card_ISSUE_ID fixed(6)\n");
    append(
        "select top 10 tables.tablename as \"Table\", round(files.treeleavessize+files.lobsize+files.treeindexsize)/1024,2) as \"MB\" from domain.tables,sysinfo.files where domain.tables.tableid=sysinfo.files.fileid order by (files.treeleavessize+files.lobsize+files.treeindexsize) desc\n");
    append("select COMPETITOR_ID from product where COMPETITOR_ID is not nulllimit 10\n");
    append(
        "select top 10 tables.tablename as \"Table\", round((files.treeleavessize+files.lobsize+files.treeindexsize)/1024,2) . 'MB' as \"MB\" from domain.tables,sysinfo.files where domain.tables.tableid=sysinfo.files.fileid order by (files.treeleavessize+files.lobsize+files.treeindexsize) desc\n");
    append("select top 1 from SUPPLIER_WRONG_DELIVERY_PROBLEM\n");
    append(
        "select    case when index(lower(substr(message,1,4000)),'revert')>0 then 'A' else    case when index(lower(substr(message,1,4000)),'dbmetadata')>0 OR              index(lower(substr(message,1,4000)),'dbchange')>0 OR             index(lower(substr(message,1,4000)),'system tool:')>0 then 'W' else '' end end \"widget_Status\",   case when      date(commit_time)=date    then      'Today'   else      case when        date(commit_time)=subdate(date,1)      then        'Yest.'      else        right(date(commit_time),5)      end    end as \"Date\",    left(time(commit_time),5) as \"Time\",    concat(concat(left(gr.repository_name, 6),'/'),left(hash, 7)) as \"Commit\",   left(task_commit.it_task_id,5) as \"Task\",   left(author.SHORT_USERNAME,10) as \"Author\",   case when committer.userid=author.userid then '' else left(committer.SHORT_USERNAME, 10) end as \"Committer\",     FROM git_commit    join git_user git_author on (git_author.git_user_id=git_commit.author_id)   join x_user author on (author.userid=git_author.x_user_id and author.groupid=1)   join git_user git_committer on (git_committer.git_user_id=git_commit.committer_id)   join x_user committer on (committer.userid=git_committer.x_user_id and committer.groupid=1)   join git_repository gr on (gr.repository_id=git_commit.repository_id)   left join it_task_commit task_commit on (task_commit.repository_id=git_commit.repository_id and task_commit.git_commit_id=git_commit.git_commit_id) limit 10 order by commit_time desc\n");
    append(
        "select u.userid, u.username, stats.* from (select userid, log_date as month, sum(hours) as hours from (  select USERID, LOG_DATE, fixed(count(*)/6,4,2) as hours from ( SELECT s.USERID, s.LOG_DATE, s.hour, s.dekaminute, count(*) count FROM DB_LOG_STATISTIC s left outer join USER_WORKING_TIME_RANGE r on ( r.groupid=1 and s.userid=r.userid and s.log_date between r.date_from and r.date_until and dayofweek(s.log_date) between r.DAY_OF_WEEK_FROM and r.DAY_OF_WEEK_UNTIL )  WHERE s.LOG_DATE between '2020-06-01' and '2020-06-30' and s.userid=234 AND s.LOG_DATA_MODE LIKE '-'  and (       r.date_from is null       or       (     s.log_time between r.time_a_begin and r.time_a_end  or s.log_time between r.time_b_begin and r.time_b_end  or s.log_time between r.time_c_begin and r.time_c_end  or s.log_time between r.time_d_begin and r.time_d_end       )     ) group by s.USERID, s.LOG_DATE, s.hour, s.dekaminute ) where count>=2 group by USERID, LOG_DATE  ) group by userid, log_date stats join x_user u on (stats.userid=u.userid and u.groupid=1) where u.ACTIVEMODE='Y' and u.PRIMARY_DEPARTMENT_CODE<>'I' order by month, hours desc\n");
    append("rename column SHOPDB_TABLE_ROW_COUNT.tablesize_kilobytes to size_bytes\n");
    append("alter table X_USER add constraint c_active_mode check not (ACTIVEMODE='N' and userid in (50,51,52,52,90,91,92,93))\n");
    append(
        "select x_user.shortname, count from it_task where assigned_to_user is not null group by assigned_to_user join x_user on (x_user.groupid=it_task.groupid and x_user.userid=it_task.assigned_to_user)\n");
    append(
        "select x_user.shortname, count from it_task where assigned_to_user is not null group by assigned_to_user join x_user on (x_user.groupid=it_task.groupid and x_user.userid=it_task.assigned_to_user)\n");
    append("alter table PRODUCT_SERVICE add constraint c_service_user check not (SERVICE_STATUS>1 and (SERVICE_USER is null and SERVICE_ADDRESS is null))\n");
    append("alter table PRODUCT_SERVICE add constraint c_status_date_user check SERVICE_STATUS=1 or (STATUS_DATE is not null and STATUS_DATE is not null)\n");
    append("alter table PRODUCT_SERVICE add constraint c_status_date_user check SERVICE_STATUS=1 or (STATUS_DATE is not null and STATUS_DATE is not null)\n");
    append("alter table PRODUCT_SERVICE add constraint c_status_date_user check SERVICE_STATUS=1 or (STATUS_DATE is not null and STATUS_DATE is not null)\n");
    append("alter table PRODUCT_SERVICE add constraint c_status_date_user check SERVICE_STATUS=1 or (STATUS_DATE is not null and STATUS_DATE is not null)\n");
    append("ALTER TABLE AVA_PRODUCT_DOWNLOAD   ADD FOREIGN KEY F_ARTIST     (GROUPID, ARTIST_ID)   REFERENCES AVA_ARTIST     (GROUPID, AVA_ARTIST_ID)\n");
    append("ALTER TABLE AVA_PRODUCT_DOWNLOAD   ADD FOREIGN KEY F_ARTIST     (GROUPID, ARTIST_ID)   REFERENCES AVA_ARTIST     (GROUPID, AVA_ARTIST_ID)\n");
    append("ALTER TABLE AVA_PRODUCT_DOWNLOAD   ADD FOREIGN KEY F_ARTIST     (GROUPID, ARTIST_ID)   REFERENCES AVA_ARTIST     (GROUPID, ARTIST_ID)\n");
    append("ALTER TABLE AVA_PRODUCT_DOWNLOAD   ADD FOREIGN KEY F_PUBLISHER     (GROUPID, PUBLISHER_ID)   REFERENCES AVA_PUBLISHER     (GROUPID, PUBLISHER_ID)\n");
    append("select publishier_id, download_time from AVA_PRODUCT_DOWNLOAD  where download_id=1 group by publishier_id, download_time top 1 order by download_time desc\n");
    append("select publishier_id, download_time desc from AVA_PRODUCT_DOWNLOAD  where download_id=1 group by publishier_id, download_time \n");
    append("select publishier_id, download_time desc from AVA_PRODUCT_DOWNLOAD  where download_id=1 group by publishier_id, download_time \n");
    append("select publishier_id, download_time from AVA_PRODUCT_DOWNLOAD  where download_id=1 group by publishier_id, download_time desc \n");
    append("select publishier_id, download_time from AVA_PRODUCT_DOWNLOAD  where download_id=1 group by publishier_id, download_time desc \n");
    append("select publishier_id from AVA_PRODUCT_DOWNLOAD  where download_id=1 group by publishier_id, max(download_time) having \n");
    append("select publishier_id,  from AVA_PRODUCT_DOWNLOAD group by publishier_id, max(download_time) having download_id=1\n");
    append("select address_id, count(*) from SUPPLIER_INVOICE where groupid=1 and PAYMENT_MODE='P' and CREATION_DATE>'2020-01-01' group by address_id, order by count(*) desc\n");
    append("select address_id, count(*) from SUPPLIER_INVOICE where groupid=1 and PAYMENT_MODE='P' and CREATION_DATE>'2020-01-01' group by address_id, order by count(*) \n");
    append("select publishier_id, ARTICLE_NUMBER count(*) as count from AVA_PRODUCT_DOWNLOAD  group by publishier_id, ARTICLE_NUMBER\n");
    append("select publishier_id, ARTICLE_NUMBER count(*) as count from AVA_PRODUCT_DOWNLOAD  group by publishier_id, ARTICLE_NUMBER\n");
    append("select publishier_id, article_number count(*) as count from AVA_PRODUCT_DOWNLOAD  group by publishier_id, article_number\n");
    append("select publishier_id, article_id count(*) as count from AVA_PRODUCT_DOWNLOAD  group by publishier_id, article_id\n");
    append("SELECT * FROM IT_TASK WHERE IT_TASK.TASK_TITLE LIKE '%\n");
    append("SELECT * FROM IT_TASK WHERE IT_TASK.TASK_TITLE LIKE '%%\n");
    append("SELECT * FROM IT_TASK WHERE SUBSTRING(IT_TASK.TASK_DESCRIPTION, 1, 4000) LIKE '%%\n");
    append("select PUBLISHIER_ID, ARTICLE_NUMBER count(*) as count from AVA_PRODUCT_DOWNLOAD group by PUBLISHIER_ID, ARTICLE_NUMBER\n");
    append("create domain ADDRESS_DUPLICATE_STATUS_ID fixed(8)\n");
    append("select count(*) from WIDGET where UPDATE_USERID=187 and datediff(date(update_time),date))<4\n");
    append("alter table EXPOSITION_UNIT column EXP_UNIT_STATUS add default 1\n");
    append("ALTER TABLE AVA_PRODUCT_DOWNLOAD   ADD FOREIGN KEY F_ARTIST     (GROUPID, ARTIST_ID)   REFERENCES AVA_ARTIST     (GROUPID, ARTIST_ID)\n");
    append("select * from it_task where assigned_to_user=323 and and task_status=1 and it_task_id in (select task_id from it_task_assignment_log where user_id=276)\n");
    append("select customer_id=null, count(*) from website_click_entry where click_date > ? group by customer_id=null\n");
    append("ALTER TABLE SUPPLIER_WRONG_DELIVERY_PROBLEM ADD FOREIGN KEY F_CONTACT (GROUPID, SUPPLIER_ID, CONTACT_ID) REFERENCES CONTACT (GROUPID, ADDRESS_ID, CONTACT_ID)\n");
    append("ALTER TABLE SUPPLIER_INVOICE ADD FOREIGN KEY F_CONTACT (GROUPID, SUPPLIER_ID, CONTACT_ID) REFERENCES CONTACT (GROUPID, ADDRESS_ID, CONTACT_ID)\n");
    append("CREATE DOMAIN AVA_PRODUCT_DOWNLOAD_ID FIXED(8)\n");
    append("drop table from AVA_PUBLISHER\n");
    append("CREATE DOMAIN AVA_PUBLISHER_ID FIXED(8)\n");
    append("CREATE DOMAIN AVA_PUBLISHER_ID FIXED(8)\n");
    append("CREATE DOMAIN AVA_ARTIST_ID FIXED(8)\n");
    append(
        "SELECT count(ssdb.*) FROM SDB_SHOP_DEVICE_BROWSER ssdb  join SDB_SHOP_CUSTOMER_DEVICE_BROWSER sscdb on \tssdb.groupid = sscdb.groupid and \tssdb.device_browser_id  = sscdb.device_browser_id where \tsscdb.groupid = 1 and \tsscdb.CUSTOMER_ID = 3  \n");
    append("alter table stock_code add physical boolean default false not null\n");
    append(
        "select    case when      date(commit_time)=date    then      'Today'   else      case when        date(commit_time)=subdate(date,1)      then        'Yest.'      else        right(date(commit_time),5)      end    end as \"Date\",    left(time(commit_time),5) as \"Time\",    left(gr.repository_name, 6) . '/' as \"Repo\",   left(hash, 7) as \"Commit\",   left(task_commit.it_task_id,5) as \"Task\",   left(author.SHORT_USERNAME,10) as \"Author\",   case when committer.userid=author.userid then '' else left(committer.SHORT_USERNAME, 10) end as \"Committer\",   substr_first_newline_lob_unicode(substr(message, 1, 4000), 80) as \"Msg\"    FROM git_commit    join x_user author on (author.userid=git_commit.author_id)   join x_user committer on (committer.userid=git_commit.committer_id)   join git_repository gr on (gr.repository_id=git_commit.repository_id)   left join it_task_commit task_commit on (task_commit.repository_id=git_commit.repository_id and task_commit.git_commit_id=git_commit.git_commit_id) limit 10 order by commit_time desc\n");
    append("select ADDRESS_ID, count(*) from SUPPLIER_INVOICE where groupid=1 and PAYMENT_MODE='P' group by (address_id), order by count(*) desc\n");
    append("select ADDRESS_ID, count(*) from SUPPLIER_INVOICE where groupid=1 and PAYMENT_MODE='P' groupby (address_id), order by count(*) desc\n");
    append("select ADDRESS_ID, count(*) from SUPPLIER_INVOICE where groupid=1 and PAYMENT_MODE='P' group by (address_id), order by count(*) desc\n");
    append("select ADDRESS_ID, count(*) from SUPPLIER_INVOICE where groupid=1 and PAYMENT_MODE='P' group by address_id, order by count(*) desc\n");
    append("select ADDRESS_ID, count(*) from SUPPLIER_INVOICE where groupid=1 and PAYMENT_MODE='P' groupby count(*) desc\n");
    append("select ADDRESS_ID, count(*) from SUPPLIER_INVOICE where groupid=1 and PAYMENT_MODE='P' group by count(*) desc\n");
    append("select ADDRESS_ID, count(*) from SUPPLIER_INVOICE where groupid=1 and PAYMENT_MODE='P' group by count(*) desc\n");
    append("select ADDRESS_ID, count(ADDRESS_ID) from SUPPLIER_INVOICE where groupid=1 and PAYMENT_MODE='P' group by count(address_id) desc\n");
    append("select ADDRESS_ID, count(ADDRESS_ID) from SUPPLIER_INVOICE where groupid=1 and PAYMENT_MODE='P' groupby count(address_id) desc\n");
    append("select ADDRESS_ID, count(ADDRESS_ID) from SUPPLIER_INVOICE where groupid=1 and PAYMENT_MODE='P' groupy by count(address_id) desc\n");
    append(
        "select left(fp.end_date,4) & '-' & substr(chr(fp.end_date),6,2) as period,         fp.period_type as pt,         chr(fp.PERIOD_ID & '-' & res.RESULT_ID, 5) as p_key,        fixed(sum(case when ln.state<>1 then 0 else 1 end), 2) as fail        --fixed(count(*),4) as tot   from fincheck_period fp   inner join fincheck_result res on (fp.groupid = res.groupid and fp.mandatnr = res.mandatnr and fp.period_id = res.period_id)   inner join fincheck_result_line ln on (fp.groupid = ln.groupid and fp.mandatnr = ln.mandatnr                                          and fp.period_id = ln.period_id and res.result_id = ln.result_id)   where outdated = false     and (year(fp.begin_date)=year(now()) or fp.begin_date>=subdate(now(),180))     and ln.result_line_id not exists (select *                       from fincheck_result_line cl                        where cl.groupid = ln.groupid                          and cl.mandatnr = ln.mandatnr                         and cl.period_id = ln.period_id                          and cl.result_id = ln.result_id                         and cl.parent_result_line_id = ln.result_line_id)   group by left(fp.end_date,4) & '-' & substr(chr(fp.end_date),6,2),            fp.period_type,            chr(fp.PERIOD_ID & '-' & res.RESULT_ID, 5)   order by left(fp.end_date,4) & '-' & substr(chr(fp.end_date),6,2)\n");
    append("DROP PUBLIC FUNCTION dbuser.SUBSTR_FIRST_NEWLINE_LOB_UNICODE\n");
    append(
        "CREATE PUBLIC FUNCTION dbuser.substr_first_newline_lob_unicode(input VARCHAR(4000)) RETURNS VARCHAR(4000) AS  VAR substring VARCHAR; newline_pos FIXED; BEGIN   SET newline_pos = INDEX(input,' ');   RETURN CASE WHEN newline_pos>1 THEN SUBSTR(input, 1, newline_pos) ELSE INPUT END; END;\n");
    append("DROP PUBLIC FUNCTION dbuser.SUBSTR_FIRST_NEWLINE_LOB_UNICODE\n");
    append("DROP PUBLIC FUNCTION dbuser.substr_first_newline_lob_unicode\n");
    append(
        "CREATE PUBLIC FUNCTION dbuser.substr_first_newline_lob_unicode(input VARCHAR(4000)) RETURNS VARCHAR(4000) AS  VAR substring VARCHAR; newline_pos FIXED; BEGIN   SET newline_pos = INDEX(input,' ');   RETURN CASE WHEN newline_pos>1 THEN SUBSTR(input, 1, newline_pos) ELSE INPUT END; END;\n");
    append("DROP PUBLIC FUNCTION dbuser.substr_first_newline_lob_unicode\n");
    append(
        "DROP PUBLIC FUNCTION dbuser.substr_first_newline_lob_unicode; CREATE PUBLIC FUNCTION dbuser.substr_first_newline_lob_unicode(input LONG, MAX FIXED(10)) RETURNS VARCHAR(4000) AS  VAR substring VARCHAR; newline_pos FIXED; BEGIN   SET substring = SUBSTR(input, 1, 4000);   SET newline_pos = INDEX(substring,' ');   RETURN CASE WHEN newline_pos>1 THEN SUBSTR(substring, 1, newline_pos) ELSE SUBSTR(substring, 1, max) END; END;\n");
    append(
        "DELETE PUBLIC FUNCTION dbuser.substr_first_newline_lob_unicode; CREATE PUBLIC FUNCTION dbuser.substr_first_newline_lob_unicode(input LONG, MAX FIXED(10)) RETURNS VARCHAR(4000) AS  VAR substring VARCHAR; newline_pos FIXED; BEGIN   SET substring = SUBSTR(input, 1, 4000);   SET newline_pos = INDEX(substring,' ');   RETURN CASE WHEN newline_pos>1 THEN SUBSTR(substring, 1, newline_pos) ELSE SUBSTR(substring, 1, max) END; END;\n");
    append(
        "CREATE PUBLIC FUNCTION dbuser.substr_first_newline_lob_unicode(input LONG, MAX FIXED(10)) RETURNS VARCHAR(4000) AS  VAR substring VARCHAR; newline_pos FIXED; BEGIN   SET substring = SUBSTR(input, 1, 4000);   SET newline_pos = INDEX(substring,' ');   RETURN CASE WHEN newline_pos>1 THEN SUBSTR(substring, 1, newline_pos) ELSE SUBSTR(substring, 1, max) END; END;\n");
    append(
        "CREATE PUBLIC FUNCTION dbuser.substr_first_newline_lob_unicode(input LONG UNICODE, MAX FIXED(10)) RETURNS VARCHAR(4000) AS  VAR substring VARCHAR; newline_pos FIXED; BEGIN   SET substring = SUBSTR(input, 1, 4000);   SET newline_pos = INDEX(substring,' ');   RETURN CASE WHEN newline_pos>1 THEN SUBSTR(substring, 1, newline_pos) ELSE SUBSTR(substring, 1, max) END; END;\n");
    append(
        "CREATE PUBLIC FUNCTION dbuser.substr_first_newline_lob_unicode(input LONG UNICODE, MAX FIXED(10)) RETURNS VARCHAR(4000) AS  VAR substring VARCHAR; newline_pos FIXED; BEGIN   SET substring = SUBSTR(input, 1, 4000);   SET newline_pos = INDEX(substring,' ');   RETURN CASE WHEN POS>1 THEN SUBSTR(substring, 1, newline_pos) ELSE SUBSTR(substring, 1, max) END; END;\n");
    append(
        "CREATE PUBLIC FUNCTION dbuser.substr_first_newline_lob_unicode(input LONG UNICODE, MAX FIXED(10)) RETURNS VARCHAR(4000) AS  VAR substring VARCHAR; newline_pos FIXED; BEGIN   SET substring = SUBSTR(input, 1, 4000);   SET newline_pos = INDEX(str,' ');   RETURN CASE WHEN POS>1 THEN SUBSTR(substring, 1, newline_pos) ELSE SUBSTR(substring, 1, max) END; END;\n");
    append(
        "CREATE PUBLIC FUNCTION dbuser.substr_first_newline_lob_unicode(input LONG UNICODE, MAX FIXED(10)) RETURNS VARCHAR(4000) AS  VAR substring VARCHAR; newline_pos FIXED; BEGIN   SET substring = SUBSTR(input, 1, 4000); // maximum substring size   SET newline_pos = INDEX(str,' ');   RETURN CASE WHEN POS>1 THEN SUBSTR(substring, 1, newline_pos) ELSE SUBSTR(substring, 1, max) END; END;\n");
    append(
        "CREATE PUBLIC FUNCTION dbuser.substr_first_newline_lob_unicode(input LONG UNICODE, MAX FIXED(10)) RETURNS VARCHAR(4000) AS  VAR substring VARCHAR ASCII; newline_pos FIXED; BEGIN   SET substring = SUBSTR(input, 1, 4000); // maximum substring size   SET newline_pos = INDEX(str,' ');   RETURN CASE WHEN POS>1 THEN SUBSTR(substring, 1, newline_pos) ELSE SUBSTR(substring, 1, max) END; END;\n");
    append(
        "CREATE PUBLIC FUNCTION dbuser.substr_first_newline_lob_unicode(input LONG UNICODE, MAX FIXED(10)) RETURNS VARCHAR(4000) AS  VAR substring LONG ASCII; newline_pos FIXED; BEGIN   SET substring = SUBSTR(input, 1, 4000); // maximum substring size   SET newline_pos = INDEX(str,' ');   RETURN CASE WHEN POS>1 THEN SUBSTR(substring, 1, newline_pos) ELSE SUBSTR(substring, 1, max) END; END;\n");
    append(
        "CREATE PUBLIC FUNCTION dbuser.substr_first_newline_lob_unicode(input LONG UNICODE, MAX FIXED(10)) RETURNS LONG ASCII AS  VAR substring LONG ASCII; newline_pos FIXED; BEGIN   SET substring = SUBSTR(input, 1, 4000); // maximum substring size   SET newline_pos = INDEX(str,' ');   RETURN CASE WHEN POS>1 THEN SUBSTR(substring, 1, newline_pos) ELSE SUBSTR(substring, 1, max) END; END;\n");
    append(
        "CREATE PUBLIC FUNCTION dbuser.substr_first_newline_lob_unicode(input LONG UNICODE, MAX FIXED) RETURNS LONG ASCII AS  VAR substring LONG ASCII; newline_pos FIXED; BEGIN   SET substring = SUBSTR(input, 1, 4000); // maximum substring size   SET newline_pos = INDEX(str,' ');   RETURN CASE WHEN POS>1 THEN SUBSTR(substring, 1, newline_pos) ELSE SUBSTR(substring, 1, max) END; END;\n");
    append(
        "CREATE PUBLIC FUNCTION dbuser.substr_first_newline_lob_unicode(input LONG UNICODE, MAX FIXED) RETURNS VARCHAR DETERMINISTIC AS  VAR substring LONG ASCII; newline_pos FIXED; BEGIN   SET substring = SUBSTR(input, 1, 4000); // maximum substring size   SET newline_pos = INDEX(str,' ');   RETURN CASE WHEN POS>1 THEN SUBSTR(substring, 1, newline_pos) ELSE SUBSTR(substring, 1, max) END; END;\n");
    append(
        "CREATE PUBLIC FUNCTION dbuser.substr_first_newline_lob_unicode(input LONG UNICODE, MAX FIXED) RETURNS VARCHAR DETERMINISTIC AS  VAR    substring LONG ASCII;    newline_pos FIXED; BEGIN   SET substring = SUBSTR(input, 1, 4000); // maximum substring size   SET newline_pos = INDEX(str,' ');   RETURN CASE WHEN POS>1 THEN SUBSTR(substring, 1, newline_pos) ELSE SUBSTR(substring, 1, max) END; END;\n");
    append(
        "CREATE PUBLIC FUNCTION dbuser.substr_first_newline_lob_unicode(input LONG UNICODE, MAX FIXED) RETURNS VARCHAR DETERMINISTIC AS  VAR    str LONG ASCII;    pos FIXED; BEGIN   SET str = SUBSTR(input, 1, 4000); // maximum substring size   SET pos = INDEX(str,' ');   RETURN CASE WHEN POS>1 THEN SUBSTR(str, 1, pos) ELSE SUBSTR(str, 1, max) END; END;\n");
    append(
        "CREATE PUBLIC FUNCTION dbuser.substr_first_newline_lob_unicode(input LONG UNICODE, MAX FIXED) RETURNS VARCHAR DETERMINISTIC AS  VAR    str LONG ASCII;    pos FIXED; BEGIN   SET str = SUBSTR(input, 1, 4000); // maximum substring size   SET pos = INDEX(str,' ');   RETURN CASE WHEN POS>1 THEN SUBSTR(str, 1, pos) ELSE SUBSTR(str, 1, max) END; END;\n");
    append("CREATE PUBLIC FUNCTION dbuser.maximum(a fixed, b fixed) RETURNS BOOLEAN DETERMINISTIC AS  BEGIN   RETURN CASE WHEN A > B THEN A ELSE B END; END;\n");
    append("CREATE PUBLIC FUNCTION dbuser.substringToNewline(input LONG UNICODE, MAX FIXED) RETURNS VARCHAR DETERMINISTIC AS  BEGIN   RETURN LOWER(sefUrlPath); END;\n");
    append(
        "select    case when date(commit_time)=date then 'Today' else case when date(commit_time)=subdate(date,1) then 'Yest.' else right(date(commit_time),5) end end as \"Date\",    left(time(commit_time),5) as \"Time\",    left(gr.repository_name, 6) as \"Repo\",   left(hash, 7) as \"Id\",   left(u.SHORT_USERNAME,10) as \"Author\",   left(task_commit.it_task_id,5) as \"Task\",   left(substr(message, 1, 4000), case when index(substr(message, 1, 4000), ' ')=0 then min(80,length(message)) else index(substr(message, 1, 4000), ' ') end ))) as \"Msg\"    FROM git_commit    join x_user u on (u.userid=git_commit.author_id)   join git_repository gr on (gr.repository_id=git_commit.repository_id)   left join it_task_commit task_commit on (task_commit.repository_id=git_commit.repository_id and task_commit.git_commit_id=git_commit.git_commit_id) limit 10 order by commit_time desc\n");
    append(
        "select    case when date(commit_time)=date then 'Today' else case when date(commit_time)=subdate(date,1) then 'Yest.' else right(date(commit_time),5) end end as \"Date\",    left(time(commit_time),5) as \"Time\",    left(gr.repository_name, 6) as \"Repo\",   left(hash, 7) as \"Id\",   left(u.SHORT_USERNAME,10) as \"Author\",   left(task_commit.it_task_id,5) as \"Task\",   left(substr(message, 1, 4000), case when index(substr(message, 1, 4000), ' ')=0 then min(80,length(message)) else index(substr(message, 1, 4000), ' ') end ))) as \"Msg\"    FROM git_commit    join x_user u on (u.userid=git_commit.author_id)   join git_repository gr on (gr.repository_id=git_commit.repository_id)   left join it_task_commit task_commit on (task_commit.repository_id=git_commit.repository_id and task_commit.git_commit_id=git_commit.git_commit_id) limit 10 order by commit_time desc\n");
    append(
        "select    case when date(commit_time)=date then 'Today' else case when date(commit_time)=subdate(date,1) then 'Yest.' else right(date(commit_time),5) end end as \"Date\",    left(time(commit_time),5) as \"Time\",    left(gr.repository_name, 6) as \"Repo\",   left(hash, 7) as \"Id\",   left(u.SHORT_USERNAME,10) as \"Author\",   left(task_commit.it_task_id,5) as \"Task\",   left(substr(message, 1, 4000), case when index(substr(message, 1, 4000), ' ')=0 then min(80,length(message)) else index(substr(message, 1, 4000), ' ') end )) as \"Msg\"    FROM git_commit    join x_user u on (u.userid=git_commit.author_id)   join git_repository gr on (gr.repository_id=git_commit.repository_id)   left join it_task_commit task_commit on (task_commit.repository_id=git_commit.repository_id and task_commit.git_commit_id=git_commit.git_commit_id) limit 10 order by commit_time desc\n");
    append(
        "select    case when date(commit_time)=date then 'Today' else case when date(commit_time)=subdate(date,1) then 'Yest.' else right(date(commit_time),5) end end as \"Date\",    left(time(commit_time),5) as \"Time\",    left(gr.repository_name, 6) as \"Repo\",   left(hash, 7) as \"Id\",   left(u.SHORT_USERNAME,10) as \"Author\",   left(task_commit.it_task_id,5) as \"Task\",   left(substr(message, 1, 4000), case when index(substr(message, 1, 4000), ' ')=0 then min(80,length(message)) else index(substr(message, 1, 4000), ' ') end )) as \"Msg\"    FROM git_commit    join x_user u on (u.userid=git_commit.author_id)   join git_repository gr on (gr.repository_id=git_commit.repository_id)   left join it_task_commit task_commit on (task_commit.repository_id=git_commit.repository_id and task_commit.git_commit_id=git_commit.git_commit_id) limit 10 order by commit_time desc\n");
    append(
        "select    case when date(commit_time)=date then 'Today' else case when date(commit_time)=subdate(date,1) then 'Yest.' else right(date(commit_time),5) end end as \"Date\",    left(time(commit_time),5) as \"Time\",    left(gr.repository_name, 6) as \"Repo\",   left(hash, 7) as \"Id\",   left(u.SHORT_USERNAME,10) as \"Author\",   left(task_commit.it_task_id,5) as \"Task\",   left(substr(message, 1, 4000), case when index(substr(message, 1, 4000), ' ')<0 then 80 else index(substr(message, 1, 4000), ' ') end )) as \"Msg\"    FROM git_commit    join x_user u on (u.userid=git_commit.author_id)   join git_repository gr on (gr.repository_id=git_commit.repository_id)   left join it_task_commit task_commit on (task_commit.repository_id=git_commit.repository_id and task_commit.git_commit_id=git_commit.git_commit_id) limit 10 order by commit_time desc\n");
    append(
        "select    case when date(commit_time)=date then 'Today' else case when date(commit_time)=subdate(date,1) then 'Yest.' else right(date(commit_time),5) end end as \"Date\",    left(time(commit_time),5) as \"Time\",    left(gr.repository_name, 6) as \"Repo\",   left(hash, 7) as \"Id\",   left(u.SHORT_USERNAME,10) as \"Author\",   left(task_commit.it_task_id,5) as \"Task\",   left(substr(message, 1, 4000), case when index(substr(message, 1, 4000), ' ')<0 then 80 else index(substr(message, 1, 4000), ' ')) end ) as \"Msg\"    FROM git_commit    join x_user u on (u.userid=git_commit.author_id)   join git_repository gr on (gr.repository_id=git_commit.repository_id)   left join it_task_commit task_commit on (task_commit.repository_id=git_commit.repository_id and task_commit.git_commit_id=git_commit.git_commit_id) limit 10 order by commit_time desc\n");
    append(
        "select    case when date(commit_time)=date then 'Today' else case when date(commit_time)=subdate(date,1) then 'Yest.' else right(date(commit_time),5) end end as \"Date\",    left(time(commit_time),5) as \"Time\",    left(gr.repository_name, 6) as \"Repo\",   left(hash, 7) as \"Id\",   left(u.SHORT_USERNAME,10) as \"Author\",   left(task_commit.it_task_id,5) as \"Task\",   left(substr(message, 1, 4000), case when index(substr(message, 1, 4000), ' ')<0 then 80 else index(substr(message, 1, 4000), ' ')) end ) as \"Msg\"    FROM git_commit    join x_user u on (u.userid=git_commit.author_id)   join git_repository gr on (gr.repository_id=git_commit.repository_id)   left join it_task_commit task_commit on (task_commit.repository_id=git_commit.repository_id and task_commit.git_commit_id=git_commit.git_commit_id) limit 10 order by commit_time desc\n");
    append(
        "select    case when date(commit_time)=date then 'Today' else case when date(commit_time)=subdate(date,1) then 'Yest.' else right(date(commit_time),5) end end as \"Date\",    left(time(commit_time),5) as \"Time\",    left(gr.repository_name, 6) as \"Repo\",   left(hash, 7) as \"Id\",   left(u.SHORT_USERNAME,10) as \"Author\",   left(task_commit.it_task_id,5) as \"Task\",   left(substr(message, 1, 4000), index(substr(message, 1, 80), ' ') as \"Msg\"    FROM git_commit    join x_user u on (u.userid=git_commit.author_id)   join git_repository gr on (gr.repository_id=git_commit.repository_id)   left join it_task_commit task_commit on (task_commit.repository_id=git_commit.repository_id and task_commit.git_commit_id=git_commit.git_commit_id) limit 10 order by commit_time desc\n");
    append(
        "select    case when date(commit_time)=date then 'Today' else case when date(commit_time)=subdate(date,1) then 'Yest.' else right(date(commit_time),5) end end as \"Date\",    left(time(commit_time),5) as \"Time\",    left(gr.repository_name, 6) as \"Repo\",   left(hash, 7) as \"Id\",   left(u.SHORT_USERNAME,10) as \"Author\",   left(task_commit.it_task_id,5) as \"Task\",   left(substr(message, 1, 4000)e, index(substr(message, 1, 80), ' ') as \"Msg\"    FROM git_commit    join x_user u on (u.userid=git_commit.author_id)   join git_repository gr on (gr.repository_id=git_commit.repository_id)   left join it_task_commit task_commit on (task_commit.repository_id=git_commit.repository_id and task_commit.git_commit_id=git_commit.git_commit_id) limit 10 order by commit_time desc\n");
    append(
        "select count(*) from DUAL having select    case when date(commit_time)=date then 'Today' else case when date(commit_time)=subdate(date,1) then 'Yest.' else right(date(commit_time),5) end end as \"Date\",    left(time(commit_time),5) as \"Time\",    left(gr.repository_name, 6) as \"Repo\",   left(hash, 7) as \"Id\",   left(u.SHORT_USERNAME,10) as \"Author\",   left(task_commit.it_task_id,5) as \"Task\",   substr(message, 1, 80) as \"Msg\"    FROM git_commit    join x_user u on (u.userid=git_commit.author_id)   join git_repository gr on (gr.repository_id=git_commit.repository_id)   left join it_task_commit task_commit on (task_commit.repository_id=git_commit.repository_id and task_commit.git_commit_id=git_commit.git_commit_id) limit 10 order by commit_time desc\n");
    append(
        "select * from select    case when date(commit_time)=date then 'Today' else case when date(commit_time)=subdate(date,1) then 'Yest.' else right(date(commit_time),5) end end as \"Date\",    left(time(commit_time),5) as \"Time\",    left(gr.repository_name, 6) as \"Repo\",   left(hash, 7) as \"Id\",   left(u.SHORT_USERNAME,10) as \"Author\",   left(task_commit.it_task_id,5) as \"Task\",   substr(message, 1, 80) as \"Msg\"    FROM git_commit    join x_user u on (u.userid=git_commit.author_id)   join git_repository gr on (gr.repository_id=git_commit.repository_id)   left join it_task_commit task_commit on (task_commit.repository_id=git_commit.repository_id and task_commit.git_commit_id=git_commit.git_commit_id) limit 10 order by commit_time desc\n");
    append(
        "select * from select    case when date(commit_time)=date then 'Today' else case when date(commit_time)=subdate(date,1) then 'Yest.' else right(date(commit_time),5) end end as \"Date\",    left(time(commit_time),5) as \"Time\",    left(gr.repository_name, 6) as \"Repo\",   left(hash, 7) as \"Id\",   left(u.SHORT_USERNAME,10) as \"Author\",   left(task_commit.it_task_id,5) as \"Task\",   substr(message, 1, 80) as \"Msg\"    FROM git_commit    join x_user u on (u.userid=git_commit.author_id)   join git_repository gr on (gr.repository_id=git_commit.repository_id)   left join it_task_commit task_commit on (task_commit.repository_id=git_commit.repository_id and task_commit.git_commit_id=git_commit.git_commit_id) limit 10 order by commit_time desc\n");
    append(
        "select    case when date(commit_time)=date then 'Today' else case when date(commit_time)=subdate(date,1) then 'Yest.' else right(date(commit_time),5) end end as \"Date\",    left(time(commit_time),5) as \"Time\",    left(gr.repository_name, 6) as \"Repo\",   left(hash, 7) as \"Id\",   left(u.SHORT_USERNAME,10) as \"Author\",   left(task_commit.it_task_id,5) as \"Task\",    case when index(message,' ')>0 then substr(message, 1, index(message,' ') else substr(message, 1, 80) end as \"Msg\"    FROM git_commit    join x_user u on (u.userid=git_commit.author_id)   join git_repository gr on (gr.repository_id=git_commit.repository_id)   left join it_task_commit task_commit on (task_commit.repository_id=git_commit.repository_id and task_commit.git_commit_id=git_commit.git_commit_id) limit 10 order by commit_time desc\n");
    append(
        "select    case when date(commit_time)=date then 'Today' else case when date(commit_time)=subdate(date,1) then 'Yest.' else right(date(commit_time),5) end end as \"Date\",    left(time(commit_time),5) as \"Time\",    left(gr.repository_name, 6) as \"Repo\",   left(hash, 7) as \"Id\",   left(u.SHORT_USERNAME,10) as \"Author\",   left(task_commit.it_task_id,5) as \"Task\",   substr(message, 1, 100) as \"Msg\"    FROM git_commit    join x_user u on (u.userid=git_commit.author_id)   join git_repository gr on (gr.repository_id=git_commit.repository_id)   outer join it_task_commit task_commit on (task_commit.repository_id=git_commit.repository_id and task_commit.git_commit_id=git_commit.git_commit_id) limit 10 order by commit_time desc\n");
    append("select count*) from SDB_LOGIN_LOG\n");
    append("alter table communication_type add display_name boolean default true not null\n");
    append("alter table communication_type add generate_enum boolean default true not null\n");
    append("select address_id, count(*) from SUPPLIER_INVOICE where groupid=1 and PAYMENT_MODE='P' groupy by address_id order by count(1) desc\n");
    append("select address_id, count(*) from SUPPLIER_INVOICE where groupid=1 and PAYMENT_MODE='P' groupy by address_id order by count(1) desc\n");
    append("select address_id, count(*) from SUPPLIER_INVOICE where groupid=1 and PAYMENT_MODE='P' groupy by address_id order by count(1) desc\n");
    append(
        "select fail from ( select left(fp.end_date,4) & '-' & substr(chr(fp.end_date),6,2) as period,         fp.period_type as pt,         fixed(sum(case when ln.state<>1 then 1 else 0 end), 3) as fail   from fincheck_period fp   inner join fincheck_result res on (fp.groupid = res.groupid and fp.mandatnr = res.mandatnr and fp.period_id = res.period_id)   inner join fincheck_result_line ln on (fp.groupid = ln.groupid and fp.mandatnr = ln.mandatnr                                          and fp.period_id = ln.period_id and res.result_id = ln.result_id)   where outdated = false     and (year(fp.begin_date)=year(now()) or fp.begin_date>=subdate(now(),180))   group by left(fp.end_date,4) & '-' & substr(chr(fp.end_date),6,2),            fp.period_type   order by left(fp.end_date,4) & '-' & substr(chr(fp.end_date),6,2) \n");
    append(
        "select case when (fixed(sum(case when ln.state<>1 then 1 else 0 end), 3) < 10) then 'N'             when (fixed(sum(case when ln.state<>1 then 1 else 0 end), 3) < 30) then 'W'             else 'A'        end   from fincheck_period fp   inner join fincheck_result res on (fp.groupid = res.groupid and fp.mandatnr = res.mandatnr and fp.period_id = res.period_id)   inner join fincheck_result_line ln on (fp.groupid = ln.groupid and fp.mandatnr = ln.mandatnr                                          and fp.period_id = ln.period_id and res.result_id = ln.result_id)   where outdated = false     and (year(fp.begin_date)=year(now()) or fp.begin_date>=subdate(now(),180))   group by left(fp.end_date,4) & '-' & substr(chr(fp.end_date),6,2),            fp.period_type )\n");
    append(
        "select left(fp.end_date,4) & '-' & substr(chr(fp.end_date),6,2) as period,         fp.period_type as pt,         fixed(sum(case when ln.state<>1 then 1 else 0 end), 3) as fail,   from fincheck_period fp   inner join fincheck_result res on (fp.groupid = res.groupid and fp.mandatnr = res.mandatnr and fp.period_id = res.period_id)   inner join fincheck_result_line ln on (fp.groupid = ln.groupid and fp.mandatnr = ln.mandatnr                                          and fp.period_id = ln.period_id and res.result_id = ln.result_id)   where outdated = false     and (year(fp.begin_date)=year(now()) or fp.begin_date>=subdate(now(),180))   group by left(fp.end_date,4) & '-' & substr(chr(fp.end_date),6,2),            fp.period_type   order by left(fp.end_date,4) & '-' & substr(chr(fp.end_date),6,2)\n");
    append(
        "select left(fp.end_date,4) & '-' & substr(chr(fp.end_date),6,2) as period,         fp.period_type as pt,         fixed(sum(case when ln.state<>1 then 1 else 0 end), 3) as fail        --fixed(count(*),4) as tot   from fincheck_period fp   inner join fincheck_result res on (fp.groupid = res.groupid and fp.mandatnr = res.mandatnr and fp.period_id = res.period_id)   inner join fincheck_result_line ln on (fp.groupid = ln.groupid and fp.mandatnr = ln.mandatnr                                          and fp.period_id = ln.period_id and res.result_id = ln.result_id)   where outdated = false     and (year(fp.begin_date)=year(now()) or fp.begin_date>=subdate(now(),180))   group by left(fp.end_date,4) & '-' & substr(chr(fp.end_date),6,2),            fp.period_type,   order by left(fp.end_date,4) & '-' & substr(chr(fp.end_date),6,2)\n");
    append(
        "select left(fp.end_date,4) & '-' & substr(chr(fp.end_date),6,2) as period,         fp.period_type as pt,         chr(fp.PERIOD_ID & '-' & res.RESULT_ID, 5) as p_key,        fixed(sum(case when ln.state<>1 then 0 else 1 end), 2) as fail        fixed(count(*),4) as tot   from fincheck_period fp   inner join fincheck_result res on (fp.groupid = res.groupid and fp.mandatnr = res.mandatnr and fp.period_id = res.period_id)   inner join fincheck_result_line ln on (fp.groupid = ln.groupid and fp.mandatnr = ln.mandatnr                                          and fp.period_id = ln.period_id and res.result_id = ln.result_id)   where outdated = false     and (year(fp.begin_date)=year(now()) or fp.begin_date>=subdate(now(),180))   group by left(fp.end_date,4) & '-' & substr(chr(fp.end_date),6,2),            fp.period_type,            chr(fp.PERIOD_ID & '-' & res.RESULT_ID, 5)   order by left(fp.end_date,4) & '-' & substr(chr(fp.end_date),6,2)\n");
    append("ALTER SDB_CUSTOMER_PRICE_OFFER ADD INTEGRATION_TIME TIMESTAMP\n");
    append(
        "select left(fp.end_date,4) & '-' & substr(chr(fp.end_date),6,2) as period,         fp.period_type as pt,         chr(fp.PERIOD_ID & '-' & res.RESULT_ID, 5) as p_key,        fixed(sum(case when ln.state<>1 then 0 else 1 end), 2) as fail,        --fixed(count(*),4) as tot   from fincheck_period fp   inner join fincheck_result res on (fp.groupid = res.groupid and fp.mandatnr = res.mandatnr and fp.period_id = res.period_id)   inner join fincheck_result_line ln on (fp.groupid = ln.groupid and fp.mandatnr = ln.mandatnr                                          and fp.period_id = ln.period_id and res.result_id = ln.result_id)   where outdated = false     and (year(fp.start_date)=year(now()) or fp.start_date>=subdate(now(),180))   group by left(fp.end_date,4) & '-' & substr(chr(fp.end_date),6,2),            fp.period_type,            chr(fp.PERIOD_ID & '-' & res.RESULT_ID, 5)   order by left(fp.end_date,4) & '-' & substr(chr(fp.end_date),6,2)\n");
    append(
        "select fp.end_date, --left(fp.end_date,5) & '-' & substr(chr(fp.end_date),6,2) as period,         fp.period_type,         chr(PERIOD_ID & '-' & RESULT_ID, 5) as p_key,        sum(case when ln.state<>1 then 0 else 1 end) as fail,        count(*) as tot   from fincheck_period fp   inner join fincheck_result res on (fp.groupid = res.groupid and fp.mandatnr = res.mandatnr and fp.period_id = res.period_id)   inner join fincheck_result_line ln on (fp.groupid = ln.groupid and fp.mandatnr = ln.mandatnr                                          and fp.period_id = ln.period_id and res.result_id = ln.result_id)   where outdated = false   group by fp.end_date,            fp.period_type            chr(PERIOD_ID & '-' & RESULT_ID, 5)   --order by left(fp.end_date,5) & '-' & substr(chr(fp.end_date),6,2)\n");
    append(
        "select fp.end_date, --left(fp.end_date,5) & '-' & substr(chr(fp.end_date),6,2) as period,  --       fp.period_type,  --       chr(PERIOD_ID & '-' & RESULT_ID, 5) as p_key, --       sum(case when ln.state<>1 then 0 else 1 end) as fail,          count(*) as tot   from fincheck_period fp   inner join fincheck_result res on (fp.groupid = res.groupid and fp.mandatnr = res.mandatnr and fp.period_id = res.period_id)   inner join fincheck_result_line ln on (fp.groupid = ln.groupid and fp.mandatnr = ln.mandatnr                                          and fp.period_id = ln.period_id and res.result_id = ln.result_id)   where outdated = false   group by fp.end_date, --           fp.period_type,  --           --chr(PERIOD_ID & '-' & RESULT_ID, 5)   --order by left(fp.end_date,5) & '-' & substr(chr(fp.end_date),6,2)\n");
    append(
        "select fp.end_date --left(fp.end_date,5) & '-' & substr(chr(fp.end_date),6,2) as period,  --       fp.period_type,  --       chr(PERIOD_ID & '-' & RESULT_ID, 5) as p_key, --       sum(case when ln.state<>1 then 0 else 1 end) as fail,          count(*) as tot   from fincheck_period fp   inner join fincheck_result res on (fp.groupid = res.groupid and fp.mandatnr = res.mandatnr and fp.period_id = res.period_id)   inner join fincheck_result_line ln on (fp.groupid = ln.groupid and fp.mandatnr = ln.mandatnr                                          and fp.period_id = ln.period_id and res.result_id = ln.result_id)   where outdated = false   group by fp.end_date, --           fp.period_type,  --           --chr(PERIOD_ID & '-' & RESULT_ID, 5)   --order by left(fp.end_date,5) & '-' & substr(chr(fp.end_date),6,2)\n");
    append(
        "select fp.end_date, --left(fp.end_date,5) & '-' & substr(chr(fp.end_date),6,2) as period,  --       fp.period_type,  --       chr(PERIOD_ID & '-' & RESULT_ID, 5) as p_key, --       sum(case when ln.state<>1 then 0 else 1 end) as fail, --       sum(*) as tot   from fincheck_period fp   inner join fincheck_result res on (fp.groupid = res.groupid and fp.mandatnr = res.mandatnr and fp.period_id = res.period_id)   inner join fincheck_result_line ln on (fp.groupid = ln.groupid and fp.mandatnr = ln.mandatnr                                          and fp.period_id = ln.period_id and res.result_id = ln.result_id)   where outdated = false   group by fp.end_date, --           fp.period_type,  --           --chr(PERIOD_ID & '-' & RESULT_ID, 5)   --order by left(fp.end_date,5) & '-' & substr(chr(fp.end_date),6,2)\n");
    append(
        "select fp.end_date, --left(fp.end_date,5) & '-' & substr(chr(fp.end_date),6,2) as period,         fp.period_type,  --       chr(PERIOD_ID & '-' & RESULT_ID, 5) as p_key,        sum(case when ln.state<>1 then 0 else 1 end) as fail,        sum(*) as tot   from fincheck_period fp   inner join fincheck_result res on (fp.groupid = res.groupid and fp.mandate_id = res.mandate_id and fp.period_id = res.period_id)   inner join fincheck_result_line ln on (fp.groupid = ln.groupid and fp.mandate_id = ln.mandate_id                                           and fp.period_id = ln.period_id and res.result_id = ln.result_id)   where outdated = false   group by fp.end_date,            fp.period_type,             --chr(PERIOD_ID & '-' & RESULT_ID, 5)   --order by left(fp.end_date,5) & '-' & substr(chr(fp.end_date),6,2)\n");
    append(
        "select left(fp.end_date,5) & '-' & substr(chr(fp.end_date),6,2) as period,         fp.period_type,         chr(PERIOD_ID & '-' & RESULT_ID, 5) as p_key,        sum(case when ln.state<>1 then 0 else 1 end) as fail,        sum(*) as tot   from fincheck_period fp   inner join fincheck_result res on (fp.groupid = res.groupid and fp.mandate_id = res.mandate_id and fp.period_id = res.period_id)   inner join fincheck_result_line ln on (fp.groupid = ln.groupid and fp.mandate_id = ln.mandate_id                                           and fp.period_id = ln.period_id and res.result_id = ln.result_id)   where outdated = false   group by left(fp.end_date,5) & '-' & substr(chr(fp.end_date),6,2) as period,             fp.period_type,             chr(PERIOD_ID & '-' & RESULT_ID, 5) as p_key   order by left(fp.end_date,5) & '-' & substr(chr(fp.end_date),6,2) as period\n");
    append(
        "select left(fp.end_date,5) & '-' & substr(chr(fp.end_date),6,2) as period,         fp.period_type,         chr(PERIOD_ID & '-' & RESULT_ID, 5) as p_key,        sum(case when ln.state<>1 then 0 else 1 end) as fail        sum(*) as tot   from fincheck_period fp   inner join fincheck_result res on (fp.groupid = res.groupid and fp.mandate_id = res.mandate_id and fp.period_id = res.period_id)   inner join fincheck_result_line ln on (fp.groupid = ln.groupid and fp.mandate_id = ln.mandate_id                                           and fp.period_id = ln.period_id and res.result_id = ln.result_id)   where outdated = false   group by left(fp.end_date,5) & '-' & substr(chr(fp.end_date),6,2) as period,             fp.period_type,             chr(PERIOD_ID & '-' & RESULT_ID, 5) as p_key   order by left(fp.end_date,5) & '-' & substr(chr(fp.end_date),6,2) as period\n");
    append(
        "SELECT * FROM PRODUCT INNER JOIN SUPPLIER_PRODUCT ON (PRODUCT.GROUPID=SUPPLIER_PRODUCT.GROUPID AND PRODUCT.PRODUCT_ID=SUPPLIER_PRODUCT.PRODUCT_ID) WHERE SUPPLIER_PRODUCT.GROUPID=1 AND SUPPLIER_PRODUCT.SUPPLIER_ID=6588 AND SUPPLIER_PRODUCT.NO_SUPPLIERS_ORDER=FALSE AND PRODUCT.BRANDNAME='Schaller' AND (LOWER(TRANSLATE(SUPPLIER_PRODUCT.SUPPL_ITEM_CODE, '.:,\n");
    append(
        "SELECT * FROM PRODUCT INNER JOIN SUPPLIER_PRODUCT ON (PRODUCT.GROUPID=SUPPLIER_PRODUCT.GROUPID AND PRODUCT.PRODUCT_ID=SUPPLIER_PRODUCT.PRODUCT_ID) WHERE SUPPLIER_PRODUCT.GROUPID=1 AND SUPPLIER_PRODUCT.SUPPLIER_ID=6588 AND SUPPLIER_PRODUCT.NO_SUPPLIERS_ORDER=FALSE AND PRODUCT.BRANDNAME='Schaller' AND (LOWER(TRANSLATE(SUPPLIER_PRODUCT.SUPPL_ITEM_CODE, '.:,\n");
    append(
        "SELECT * FROM PRODUCT   INNER JOIN SUPPLIER_PRODUCT ON (PRODUCT.GROUPID=SUPPLIER_PRODUCT.GROUPID AND PRODUCT.PRODUCT_ID=SUPPLIER_PRODUCT.PRODUCT_ID)   WHERE SUPPLIER_PRODUCT.GROUPID=1 AND  SUPPLIER_PRODUCT.SUPPLIER_ID=6588 AND  SUPPLIER_PRODUCT.NO_SUPPLIERS_ORDER=FALSE AND  PRODUCT.BRANDNAME='Schaller' AND  (LOWER(TRANSLATE(SUPPLIER_PRODUCT.SUPPL_ITEM_CODE, '.:,\n");
    append("select * from FINTRANSACTION where groupid=1 and INVOICE_REFERENCE not null and LEN(INVOICE_REFERENCE)<3\n");
    append("select * from FINTRANSACTION where groupid=1 and INVOICE_REFERENCE not null and LENGTH(INVOICE_REFERENCE)<3\n");
    append(
        "select    (case when date(commit_time)=date then 'Today' else date(commit_time) end) as \"Date\",    time(commit_time) as \"Time\",    substr(hash, 1, 7) as \"Id\",   author_id as \"Author\",   substr(message, 1, 20) as \"Msg\"    FROM git_commit    inner join x_user (x_user.userid=git_commit.author_id) limit 10 order by commit_time desc\n");
    append(
        "select    (case when date(commit_time)==date then \"A\" else date(commit_time) end) as \"Date\",    time(commit_time) as \"Time\",    substr(hash, 1, 7) as \"Id\",   substr(message, 1, 20) as \"Msg\"    FROM git_commit limit 10 order by commit_time desc\n");
    append(
        "select    (case when date(commit_time)==date then 'A' else date(commit_time) end) as \"Date\",    time(commit_time) as \"Time\",    substr(hash, 1, 7) as \"Id\",   substr(message, 1, 20) as \"Msg\"    FROM git_commit limit 10 order by commit_time desc\n");
    append(
        "select    case when date(commit_time)==date then 'A' else date(commit_time) end as \"Date\",    time(commit_time) as \"Time\",    substr(hash, 1, 7) as \"Id\",   substr(message, 1, 20) as \"Msg\"    FROM git_commit limit 10 order by commit_time desc\n");
    append(
        "select    case when date(commit_time)==date then 'A' else date(commit_time) end as \"Date\",    time(commit_time) as \"Time\",    substr(hash, 1, 7) as \"Id\",   substr(message, 1, 20) as \"Msg\"    FROM git_commit limit 10 order by commit_time desc\n");
    append(
        "select    case when date(commit_time)==date then 'A' else date(commit_time) as \"Date\",    time(commit_time) as \"Time\",    substr(hash, 1, 7) as \"Id\",   substr(message, 1, 20) as \"Msg\"    FROM git_commit limit 10 order by commit_time desc\n");
    append(
        "select    (case when date(commit_time)==date then 'A' else date(commit_time)) as \"Date\",    time(commit_time) as \"Time\",    substr(hash, 1, 7) as \"Id\",   substr(message, 1, 20) as \"Msg\"    FROM git_commit limit 10 order by commit_time desc\n");
    append(
        "select    (case when date(commit_time)==date then 'A' else date(commit_time)) as \"Date\",    time(commit_time) as \"Time\",    substr(hash, 1, 7) as \"Id\",   substr(message, 1, 20) as \"Msg\"    FROM git_commit limit 10 order by commit_time desc\n");
    append(
        "select    case when(date(commit_time)==date,'A',date(commit_time)) as \"Date\",    time(commit_time) as \"Time\",    substr(hash, 1, 7) as \"Id\",   substr(message, 1, 20) as \"Msg\"    FROM git_commit limit 10 order by commit_time desc\n");
    append(
        "select    when(date(commit_time)==date,'A',date(commit_time)) as \"Date\",    time(commit_time) as \"Time\",    substr(hash, 1, 7) as \"Id\",   substr(message, 1, 20) as \"Msg\"    FROM git_commit limit 10 order by commit_time desc\n");
    append(
        "select    case(date(commit_time)==date,'A',date(commit_time)) as \"Date\",    time(commit_time) as \"Time\",    substr(hash, 1, 7) as \"Id\",   substr(message, 1, 20) as \"Msg\"    FROM git_commit limit 10 order by commit_time desc\n");
    append("select * from PRODUCT_STOCK_NOTIFICATION max:100\n");
    append("select * from PRODUCT_STOCK_NOTIFICATION where Entry_Date=03.04.2020\n");
    append("select * from PRODUCT_STOCK_NOTIFICATION where Entry_Date=03.04.2020 and groupid = 1\n");
    append("select * from PRODUCT_STOCK_NOTIFICATION where Entry_Date=NULL and groupid = 1 max:100\n");
    append("select * from PRODUCT_STOCK_NOTIFICATION where Entry_Date=? and groupid = 1 max:100\n");
    append("select * from PRODUCT_STOCK_NOTIFICATION where Entry_Date < -50 and groupid = 1 max:100\n");
    append("select * from PRODUCT_STOCK_NOTIFICATION where EntryDate < -50 and groupid = 1 max:100\n");
    append("select * from PRODUCT_STOCK_NOTIFICATION where groupid = 1 max:100\n");
    append("select * from PRODUCT_STOCK_NOTIFICATION where insertTime < 01.06.2020 and groupid = 1\n");
    append("CREATE DOMAIN PHONONET_ARTWORK_ID FIXED(8,0)\n");
    append("CREATE DOMAIN PHONONET_ARTWORK_ID FIXED(8,0)\n");
    append("CREATE DOMAIN PHONONET_SOUND_FILE_ID FIXED(8)\n");
    append("CREATE DOMAIN PHONONET_TRACK_ID FIXED(8, 0)\n");
    append("CREATE DOMAIN PHONONET_PRICE_HISTORY_ID FIXED(8)\n");
    append("CREATE DOMAIN PHONONET_PRICE_HISTORY_ID FIXED(8)\n");
    append("CREATE DOMAIN PHONONET_DOWNLOAD_LINE_ID FIXED(8)\n");
    append("CREATE DOMAIN PHONONET_DOWNLOAD_LINE_ID FIXED(8)\n");
    append("CREATE DOMAIN PHONONET_DOWNLOAD_ID FIXED(8)\n");
    append("CREATE DOMAIN PHONONET_LABEL_ID FIXED(8)\n");
    append("CREATE DOMAIN PHONONET_GENRE_ID FIXED(8,0)\n");
    append("CREATE DOMAIN PHONONET_GENRE_ID FIXED(8,0)\n");
    append("CREATE DOMAIN PHONONET_GENRE_ID FIXED(8,0)\n");
    append("CREATE DOMAIN PHONONET_DISTRIBUTOR_ID FIXED(8)\n");
    append("CREATE DOMAIN PHONONET_ARTIST_ID FIXED(8)\n");
    append("CREATE DOMAIN PHONONET_ARTIST_ID FIXED(8)\n");
    append(
        "select ms.* from mailing_sendlog ms join contact c on  \tms.groupid = c.groupid and \tms.address_id = c.address_id and \tms.contact_id = c.contact_id join email_address e on \tms.groupid = e.groupid and \tms.recipient_email = e.email_index where  \tms.send_date between '2014-01-01' and '2014-02-01' and \tms.send_status=3 \te.email_address=c.email_failed \n");
    append("select count(*) from mailing_sendlog ms where  \tms.send_date between '2014-01-01' and '2014-02-01' and \n");
    append(
        "CREATE TABLE ARCH_SHOP_LOGIN_LOG (   GROUPID GROUPID KEY,   ARCH_ID ARCH_SHOP_LOGIN_LOG_ID KEY,    DIVISIONCODE DIVISIONCODE,   LOGIN_ID LOGIN_LOG_ID,   SESSION_ID VARCHAR(255) ASCII,   SESSION_UUID CHAR(40) ASCII,   LOGIN_DATE DATE NOT NULL,   LOGIN_TIME TIME NOT NULL,   LOGIN_EMAIL EMAIL,   LOGIN_CUSTOMER_ID CUSTOMER_ID,   LOGIN_SOURCE VARCHAR(50) ASCII,   IS_SUPER_USER_LOGIN BOOLEAN NOT NULL,   SUCCESS BOOLEAN NOT NULL,   FAILURE_REASON VARCHAR(255) UNICODE,   REFERER_URL LONG ASCII,   URL LONG ASCII,   DEVICE_BROWSER_ID FIXED(9),   IP_ADDRESS IP_ADDRESS,   IP_IS_MASKED BOOLEAN DEFAULT FALSE,   IP_COUNTRY COUNTRYCODE,   IP_REGION_CODE REGION_CODE,   IP_CITY VARCHAR(255) ASCII )\n");
    append("CREATE DOMAIN EMAIL VARCHAR(256) ASCII\n");
    append(
        "CREATE TABLE ARCH_SHOP_LOGIN_LOG (   GROUPID GROUPID KEY,   ARCH_ID ARCH_SHOP_LOGIN_LOG_ID KEY,    DIVISIONCODE DIVISIONCODE,   LOGIN_ID LOGIN_LOG_ID,   SESSION_ID VARCHAR(255) ASCII,   SESSION_UUID CHAR(40) ASCII,   LOGIN_DATE DATE NOT NULL,   LOGIN_TIME TIME NOT NULL,   LOGIN_EMAIL EMAIL,   LOGIN_CUSTOMER_ID CUSTOMER_ID,   LOGIN_SOURCE VARCHAR(50) ASCII,   IS_SUPER_USER_LOGIN BOOLEAN NOT NULL,   SUCCESS BOOLEAN NOT NULL,   FAILURE_REASON VARCHAR(255) UNICODE,   REFERER_URL LONG ASCII,   URL LONG ASCII,   DEVICE_BROWSER_ID FIXED(9),   IP_ADDRESS IP_ADDRESS,   IP_IS_MASKED BOOLEAN DEFAULT FALSE,   IP_COUNTRY COUNTRYCODE,   IP_REGION_CODE REGION_CODE,   IP_CITY VARCHAR(255) ASCII )\n");
    append("CREATE DOMAIN LOGIN_LOG_ID FIXED(9)\n");
    append(
        "CREATE TABLE ARCH_SHOP_LOGIN_LOG (   GROUPID GROUPID KEY,   ARCH_ID ARCH_SHOP_LOGIN_LOG_ID KEY,    DIVISIONCODE DIVISIONCODE,   LOGIN_ID LOGIN_LOG_ID,   SESSION_ID VARCHAR(255) ASCII,   SESSION_UUID CHAR(40) ASCII,   LOGIN_DATE DATE NOT NULL,   LOGIN_TIME TIME NOT NULL,   LOGIN_EMAIL EMAIL,   LOGIN_CUSTOMER_ID CUSTOMER_ID,   LOGIN_SOURCE VARCHAR(50) ASCII,   IS_SUPER_USER_LOGIN BOOLEAN NOT NULL,   SUCCESS BOOLEAN NOT NULL,   FAILURE_REASON VARCHAR(255) UNICODE,   REFERER_URL LONG ASCII,   URL LONG ASCII,   DEVICE_BROWSER_ID FIXED(9),   IP_ADDRESS IP_ADDRESS,   IP_IS_MASKED BOOLEAN DEFAULT FALSE,   IP_COUNTRY COUNTRYCODE,   IP_REGION_CODE REGION_CODE,   IP_CITY VARCHAR(255) ASCII )\n");
    append("CREATE DOMAIN ARCH_SHOP_LOGIN_LOG_ID FIXED(8)\n");
    append("CREATE DOMAIN ARCH_SHOP_LOGIN_LOG_ID FIXED(8)\n");
    append(
        "CREATE TABLE SDB_CUSTOMER_PRICE_OFFER ( \tGROUPID GROUPID KEY, \tPRICE_OFFER_ID FIXED(5) KEY, \tCUSTOMER_ID CUSTOMER_ID NOT NULL, \tDIVISIONCODE DIVISIONCODE NOT NULL, \tCOUNTRYCODE COUNTRYCODE NOT NULL, \tLANGCODE LANGCODE NOT NULL, \tPRODUCT_ID PRODUCT_ID NOT NULL, \tCURRENT_UVP PRICE, \tCURRENT_PRICE PRICE NOT NULL, \tOFFERED_PRICE PRICE NOT NULL, \tCURRENCY_CODE CURRENCY_CODE NOT NULL, \tCUSTOMER_MESSAGE LONG UNICODE, \tURL VARCHAR(1024) UNICODE NOT NULL, \tIP_ADDRESS CHAR(39) ASCII NOT NULL,  \tIP_IS_MASKED BOOLEAN DEFAULT FALSE NOT NULL,   \tIP_COUNTRY COUNTRYCODE,   \tIP_REGION_CODE REGION_CODE,   \tIP_CITY VARCHAR(255) UNICODE, \tDEVICE_BROWSER_ID FIXED(9),   \tUSER_AGENT VARCHAR(1000) ASCII,   \tUSER_AGENT_ID USER_AGENT_ID, \tOFFER_TIME TIMESTAMP )\n");
    append("CREATE DOMAIN PRICE FIXED(10, 2)\n");
    append(
        "CREATE TABLE SDB_CUSTOMER_PRICE_OFFER ( \tGROUPID GROUPID KEY, \tPRICE_OFFER_ID FIXED(5) KEY, \tCUSTOMER_ID CUSTOMER_ID NOT NULL, \tDIVISIONCODE DIVISIONCODE NOT NULL, \tCOUNTRYCODE COUNTRYCODE NOT NULL, \tLANGCODE LANGCODE NOT NULL, \tPRODUCT_ID PRODUCT_ID NOT NULL, \tCURRENT_UVP PRICE, \tCURRENT_PRICE PRICE NOT NULL, \tOFFERED_PRICE PRICE NOT NULL, \tCURRENCY_CODE CURRENCY_CODE NOT NULL, \tCUSTOMER_MESSAGE LONG UNICODE, \tURL VARCHAR(1024) UNICODE NOT NULL, \tIP_ADDRESS CHAR(39) ASCII NOT NULL,  \tIP_IS_MASKED BOOLEAN DEFAULT FALSE NOT NULL,   \tIP_COUNTRY COUNTRYCODE,   \tIP_REGION_CODE REGION_CODE,   \tIP_CITY VARCHAR(255) UNICODE, \tDEVICE_BROWSER_ID FIXED(9),   \tUSER_AGENT VARCHAR(1000) ASCII,   \tUSER_AGENT_ID USER_AGENT_ID, \tOFFER_TIME TIMESTAMP )\n");
    append("rename column test_pers_framework.userid to some_userid\n");
    append("rename column test_pers_framework.userid to some_userid\n");
    append("alter table rename column test_pers_framework.userid to some_userid\n");
    append("alter table rename column test_pers_framework.userid to some_userid\n");
    append("alter table rename column test_pers_framework.userid to some_userid\n");
    append("select top 500 from IMAP_LINK\n");
    append("select * from person_name where male_check='Y\" and female_check='Y'\n");
    append("select * from USER_PROCESS where groupid=1 and USERID=243 and PROCESS_START>2020-07-20 11:02:24.465 and PROCESS_START<2020-07-20 11:10:24.465\n");
    append(
        "ALTER TABLE ORDERMAIN_CUSTOMER_FEEDBACK   ADD CONSTRAINT  C_REVIEW_REMARKS CHECK (RESULT_CODE IS NULL AND REVIEW_REMARKS IS NULL) OR (REVIEW_REMARKS IS NOT NULL AND RESULT_CODE='P') OR (REVIEW_REMARKS IS NULL AND RESULT_CODE='G')\n");
    append(
        "ALTER TABLE ORDERMAIN_CUSTOMER_FEEDBACK   ADD CONSTRAINT  C_REVIEW_REMARKS CHECK (RESULT_CODE IS NULL AND REVIEW_REMARKS IS NULL) OR (REVIEW_REMARKS IS NOT NULL AND RESULT_CODE='P') OR (REVIEW_REMARKS IS NULL AND RESULT_CODE='G')\n");
    append(
        "ALTER TABLE ORDERMAIN_CUSTOMER_FEEDBACK   ADD CONSTRAINT  C_REVIEW_REMARKS CHECK (RESULT_CODE IS NULL AND REVIEW_REMARKS IS NULL) OR (REVIEW_REMARKS IS NOT NULL AND RESULT_CODE='P') OR (REVIEW_REMARKS IS NULL AND RESULT_CODE='G')\n");
    append(
        "ALTER TABLE ORDERMAIN_CUSTOMER_FEEDBACK   ADD CONSTRAINT  C_REVIEW_REMARKS CHECK (RESULT_CODE IS NULL AND REVIEW_REMARKS IS NULL) OR (REVIEW_REMARKS IS NOT NULL AND RESULT_CODE='P') OR (REVIEW_REMARKS IS NULL AND RESULT_CODE='G')\n");
    append(
        "ALTER TABLE ORDERMAIN_CUSTOMER_FEEDBACK   ADD CONSTRAINT  C_REVIEW_REMARKS CHECK (RESULT_CODE IS NULL AND REVIEW_REMARKS IS NULL) OR (REVIEW_REMARKS IS NOT NULL AND RESULT_CODE='P') OR (REVIEW_REMARKS IS NULL AND RESULT_CODE='G')\n");
    append(
        "ALTER TABLE ORDERMAIN_CUSTOMER_FEEDBACK   ADD CONSTRAINT  C_REVIEW_REMARKS CHECK (RESULT_CODE IS NULL AND REVIEW_REMARKS IS NULL) OR (REVIEW_REMARKS IS NOT NULL AND RESULT_CODE='P') OR (REVIEW_REMARKS IS NULL AND RESULT_CODE='G')\n");
    append("ALTER TABLE ORDERMAIN_CUSTOMER_FEEDBACK   ADD CONSTRAINT  C_RESULT_CODE CHECK RESULT_CODE IS NULL OR RESULT_CODE='G' OR RESULT_CODE='P'\n");
    append("ALTER TABLE CHAT_SESSION ADD START_TIME  TIMESTAMP default TIMESTAMP NOT NULL\n");
    append("drop index i_standard_doc_pos on external_invoice_part\n");
    append("drop index i_standard_doc_pos on external_invoice_part\n");
    append("alter table external_invoice_part add foreign key f_datakey (groupid, data_key) references datafile (groupid, data_key)\n");
    append("alter table external_invoice_part add foreign kef f_datakey (groupid, data_key) references datafile (groupid, data_key)\n");
    append("alter table external_invoice_part add foreign key f_standard_doc (groupid, stand_doc_id, delpos) references standard_doc_pos(groupid, rechnungsnr, delpos)\n");
    append("alter talbe external_invoice_part add foreign key f_standard_doc (groupid, stand_doc_id, delpos) references standard_doc_pos(groupid, rechnungsnr, delpos)\n");
    append("alter talbe external_invoice_part add foreign key (groupid, stand_doc_id, delpos) references standard_doc_pos(groupid, rechnungsnr, delpos)\n");
    append("create foreign key f_standard_doc external_invoice_part(groupid, stand_doc_id, delpos) references standard_doc_pos(groupid, rechnungsnr, delpos)\n");
    append("create index i_standard_doc_pos (groupid, stand_doc_id, delpos)\n");
    append(
        "create table external_invoice_part (   groupid groupid key,   external_invoice_part_id external_invoice_part_id key,   STAND_DOC_ID RECHNUNGSNR,   DELPOS DELPOS,   part_type char(3),   external_id varchar(255),   datakey datakey )  create index i_standard_doc_pos (groupid, stand_doc_id, delpos)\n");
    append("create domain external_invoice_part_id fixed(10)\n");
    append("alter table EMAIL_ADDRESS add constraint c_EMAIL_ADDRESS_ORIG_CASE check EMAIL_ADDRESS_ORIG_CASE is null or email_address=lower(EMAIL_ADDRESS_ORIG_CASE)\n");
    append("alter table EMAIL_ADDRESS add constraint c_EMAIL_ADDRESS_ORIG_CASE check EMAIL_ADDRESS_ORIG_CASE is null or EMAIL_ADDRESS_ORIG_CASE=lower(email_address)\n");
    append("select * from user_process where userid=10 and begin between '2020-07-18 13:00:00' and '2020-07-18 13:30:00'\n");
    append(
        "SELECT DISTINCT us.BEGIN_DATE, us.SUBNET_LOCATION_ID, us.MAC_LOCATION_ID, c.SHORT_DESCRIPT FROM X_USER u AS u  INNER JOIN USER_SESSION AS us ON (u.GROUPID=us.GROUPID AND u.USERID=us.USERID) INNER JOIN CLIENT_MAC_ADDRESS AS c ON (us.CLIENT_MAC_ADDRESS=c.MAC_ADDRESS) WHERE u.GROUPID=1 AND u.USERID=323 AND us.BEGIN_DATE>='17.07.2020' ORDER BY us.BEGIN_DATE\n");
    append(
        "SELECT DISTINCT us.BEGIN_DATE, us.SUBNET_LOCATION_ID, us.MAC_LOCATION_ID, c.SHORT_DESCRIPT FROM X_USER u AS u  INNER JOIN USER_SESSION AS us ON (u.GROUPID=us.GROUPID AND u.USERID=us.USERID) INNER JOIN CLIENT_MAC_ADDRESS AS c ON (us.CLIENT_MAC_ADDRESS=c.MAC_ADDRESS) WHERE u.GROUPID=1 AND u.USERID=323 AND us.BEGIN_DATE>='17.07.2020' ORDER BY us.BEGIN_DATE\n");
    append(
        "SELECT DISTINCT us.BEGIN_DATE, us.SUBNET_LOCATION_ID, us.MAC_LOCATION_ID, c.SHORT_DESCRIPT FROM X_USER u AS u  INNER JOIN USER_SESSION AS us ON (u.GROUPID=us.GROUPID AND u.USERID=us.USERID) INNER JOIN CLIENT_MAC_ADDRESS AS c ON (us.CLIENT_MAC_ADDRESS=c.MAC_ADDRESS) WHERE u.GROUPID=? AND u.USERID=? AND us.BEGIN_DATE>=? ORDER BY us.BEGIN_DATE\n");
    append("alter table JOB_APPLICATION add constraint c_PHOTO_SOURCE_CODE check PHOTO_SOURCE_CODE in ('A', 'F', 'L', 'O', 'I') or PHOTO_SOURCE_CODE is null and ENTRY_DATE<='2020-07-19'\n");
    append("alter table JOB_APPLICATION add constraint c_PHOTO_SOURCE_CODE check PHOTO_SOURCE_CODE in ('A', 'F', 'L', 'O', 'I') or PHOTO_SOURCE_CODE is null and ENTRY_DATE<'2020-07-19'\n");
    append(
        "CREATE TABLE SHOP_BUG_MESSAGE_DUPLICATE_LOG (   GROUPID GROUPID KEY,   BUG_DATE TIMESTAMP KEY,   REPORT_DATE TIMESTAMP KEY,   WEB_ERROR_ID VARCHAR(100) UNICODE NOT NULL,    IP_ADDRESS VARCHAR(39) UNICODE,   IP_COUNTRY CHAR(2) ASCII,   IP_REGION_CODE VARCHAR(3) UNICODE,   IP_CITY VARCHAR(255) UNICODE,   IP_IS_MASKED BOOLEAN DEFAULT FALSE,   DEVICE_BROWSER_ID FIXED(9),   CUSTOMER_ID CUSTOMER_ID )\n");
    append(
        "CREATE TABLE SDB_BUG_MESSAGE_DUPLICATE (   GROUPID GROUPID KEY,   BUG_DATE TIMESTAMP KEY,   REPORT_DATE TIMESTAMP KEY,   WEB_ERROR_ID VARCHAR(100) UNICODE NOT NULL,    IP_ADDRESS VARCHAR(39) UNICODE,   IP_COUNTRY CHAR(2) ASCII,   IP_REGION_CODE VARCHAR(3) UNICODE,   IP_CITY VARCHAR(255) UNICODE,   IP_IS_MASKED BOOLEAN DEFAULT FALSE,   DEVICE_BROWSER_ID FIXED(9),   CUSTOMER_ID CUSTOMER_ID )\n");
    append(
        "CREATE TABLE SDB_BUG_MESSAGE_DUPLICATE (   GROUPID GROUPID KEY,   BUG_DATE TIMESTAMP KEY,   REPORT_DATE TIMESTAMP DEFAULT TIMESTAMP KEY,   WEB_ERROR_ID VARCHAR(100) UNICODE NOT NULL,    IP_ADDRESS VARCHAR(39) UNICODE,   IP_COUNTRY CHAR(2) ASCII,   IP_REGION_CODE VARCHAR(3) UNICODE,   IP_CITY VARCHAR(255) UNICODE,   IP_IS_MASKED BOOLEAN DEFAULT FALSE,   DEVICE_BROWSER_ID FIXED(9),   CUSTOMER_ID CUSTOMER_ID )\n");
    append("ALTER TABLE INVOICE_AUTO_PRE_PAY ALTER COLUMN PROCESS_TIME DROP DEFAULT\n");
    append("ALTER TABLE INVOICE_AUTO_PRE_PAY ALTER PROCESS_TIME DROP DEFAULT\n");
    append("ALTER TABLE INVOICE_AUTO_PRE_PAY ALTER PROCESS_TIME City DROP DEFAULT\n");
    append("select * from phone_number wehre insert_userid=347 and groupid=1 and insert_time>='2020-07-16 07:49:10.3'\n");
    append(
        "select left(u.SHORT_USERNAME,10) as name, s.*, left(t.TASK_TITLE,50) as last_task_name  from  (select fixed(IMPLEMENTATION_USER,3) as USR, fixed(sum(decode(IT_LEVEL, 1, 1, 0)),2) as L1, fixed(sum(decode(IT_LEVEL, 2, 1, 0)),2) as L2, fixed(sum(decode(IT_LEVEL, 3, 1, 0)),2) as L3, fixed(count(*),3) as total, fixed(count(case when IMPLEMENTATION_END_DATE>=subdate(date,30) then 1 else 0),3) as \"30days\", -- fixed(sum(decode(APPROVAL_USER, null, 0, 1)),2) as approved, max(it_task_id) as last_tid from IT_TASK where groupid=1 and TASK_STATUS=2 -- and IMPLEMENTATION_END_DATE between subdate(date,30) and subdate(date,1) and IMPLEMENTATION_END_DATE<=subdate(date,1) and implementation_user not in (10,74,105,13,187) group by IMPLEMENTATION_USER) s join x_user u on (u.userid=s.USR and u.activemode='Y') join it_task t on (t.groupid=1 and s.last_tid=t.it_task_id)\n");
    append("alter table IT_FAQ_TAG sort_order sort_order default 0 not null\n");
    append(
        "CREATE TABLE IT_FAQ_THREAD_USERVOTE (   GROUPID GROUPID KEY,   THREAD_ID IT_FAQ_THREAD_ID KEY,   USERID USERID KEY,   VOTE FIXED(1) NOT NULL DEFAULT 0,   FIRST_VOTE TIMESTAMP DEFAULT TIMESTAMP,   LAST_VOTE TIMESTAMP,   FOREIGN KEY (GROUPID, THREAD_ID) REFERENCES IT_FAQ_THREAD (GROUPID, THREAD_ID) )\n");
    append("ALTER TABLE MAGAZINE_ARTICLE   ADD FOREIGN KEY F_WEB_PROMOTION     (GROUPID, WEB_PROMOTION_ID)   REFERENCES WEB_PROMOTION     (GROUPID, WEB_PROMOTION_ID)\n");
    append("ALTER TABLE PRODUCT_SPECIAL   ADD FOREIGN KEY F_WEB_PROMOTION     (GROUPID, WEB_PROMOTION_ID)   REFERENCES WEB_PROMOTION     (GROUPID, WEB_PROMOTION_ID)\n");
    append("ALTER TABLE PRODUCT_HOMEPAGE_DISPLAY   ADD FOREIGN KEY F_WEB_PROMOTION     (GROUPID, WEB_PROMOTION_ID)   REFERENCES WEB_PROMOTION     (GROUPID, WEB_PROMOTION_ID)\n");
    append("ALTER TABLE WEB_HOTLINK   ADD FOREIGN KEY F_WEB_PROMOTION     (GROUPID, WEB_PROMOTION_ID)   REFERENCES WEB_PROMOTION     (GROUPID, WEB_PROMOTION_ID)\n");
    append("ALTER TABLE WEB_BANNER   ADD FOREIGN KEY F_WEB_PROMOTION     (GROUPID, WEB_PROMOTION_ID)   REFERENCES WEB_PROMOTION     (GROUPID, WEB_PROMOTION_ID)\n");
    append("CREATE DOMAIN WEB_PROMOTION_ID fixed(10, 0)\n");
    append(
        "create table IT_FAQ_THREAD_TAG (   GROUPID GROUPID KEY,   THREAD_ID IT_FAQ_THREAD_ID KEY,   TAG_ID FIXED(5) KEY,   FOREIGN KEY (GROUPID, THREAD_ID) REFERENCES IT_FAQ_THREAD (GROUPID, THREAD_ID),   FOREIGN KEY (GROUPID, TAG_ID) REFERENCES IT_FAQ_TAG (GROUPID, TAG_ID), )\n");
    append(
        "create table IT_FAQ_THREAD_TAG (   GROUPID GROUPID KEY,   THREAD_ID IT_FAQ_THREAD_ID KEY,   TAG_ID FIXED(5) KEY,   FOREIGN KEY (GROUPID, THREAD_ID) REFERENCES IT_FAQ_THREAD (GROUPID, THREAD_ID),   FOREIGN KEY (GROUPID, TAG_ID) REFERENCES IT_FAQ_TAG (GROUPID, TAG_ID), )\n");
    append(
        "create table IT_FAQ_THREAD (   GROUPID groupid KEY,   THREAD_ID IT_FAQ_THREAD_ID KEY,   USERID USERID NOT NULL,   TITLE VARCHAR(256) UNICODE,   TEXT LONG UNICODE NOT NULL,   CREATE_TIMESTAMP TIMESTAMP DEFAULT TIMESTAMP,   EDIT_TIMESTAMP TIMESTAMP,   EDIT_USERID USERID,   EDIT_REMARKS LONG UNICODE,   ANSWER_TO_THREAD_ID IT_FAQ_THREAD_ID,   FOREIGN KEY (GROUPID, ANSWER_TO_THREAD_ID) REFERENCES IT_FAQ_THREAD (GROUPID, THREAD_ID) )\n");
    append(
        "create table IT_FAQ_THREAD (   GROUPID groupid KEY,   THREAD_ID IT_FAQ_THREAD_ID KEY,   USERID USERID NOT NULL,   TITLE VARCHAR(256) UNICODE,   TEXT LONG UNICODE NOT NULL,   CREATE_TIMESTAMP TIMESTAMP DEFAULT TIMESTAMP,   EDIT_TIMESTAMP TIMESTAMP,   EDIT_USERID USERID,   EDIT_REMARKS LONG UNICODE,   KEYWORDS VARCHAR(500) ASCII,   ANSWER_TO_QUESTION_ID IT_FAQ_THREAD_ID,   FOREIGN KEY (GROUPID, ANSWER_TO_THREAD_ID) REFERENCES IT_FAQ_THREAD (GROUPID, THREAD_ID) )\n");
    append("create domain IT_FAQ_THREAD_ID fixed(5)\n");
    append(
        "update ordermain set order_country_code='CH', our_country_code=''CH', VAT_COUNTRY_CODE='CH', V_L_MWSTCODE=1, V_L_MWSTINKL=true, currency_code='CHF', location_id=2 where groupid=1 and order_id=734344\n");
    append("select count*) from SUPPL_LP_UPDATE_LINE_POT_MATCH\n");
    append("select JAVA_EXECUTABLE_ID from WIDGET where JAVA_EXECUTABLE_ID is not null except all select distinct JAVA_EXECUTABLE_ID from WIDGET where JAVA_EXECUTABLE_ID is not null\n");
    append(
        "select IMPLEMENTATION_USER, count(*) as tasks from IT_TASK where groupid=1 and TASK_STATUS=2 and IMPLEMENTATION_END_DATE beween subdate(date,30) and subdate(date,3) group by IMPLEMENTATION_USER\n");
    append(
        "select IMPLEMENTATION_USER, count(*) from IT_TASK where groupid=1 and TASK_STATUS=2 and IMPLEMENTATION_END_DATE beween subdate(date,30) and subdate(date,3) group by IMPLEMENTATION_USER\n");
    append("alter table X_ENUM MATCH_GROUPID GROUPID default 1 not null\n");
    append("alter table X_ENUM column MATCH_GROUPID GROUPID default 1 not null\n");
    append(
        "create table java_executable_user_fav ( \tgroupid groupid key, \tuserid userid key, \texecutable_id executable_id key,  \tforeign key f_user  \t\t(groupid, userid) \treferences x_user \t\t(groupid, userid),  \tforeign key f_java_executable \t\t(executable_id) \treferences java_executable \t\t(executable_id) ) \n");
    append("select REQUEST_TIME, COUNT(*) AS A from SDB_WEBSERVICE_LOG group by REQUEST_TIME where A>1\n");
    append("select REQUEST_TIME, COUNT(*) from SDB_WEBSERVICE_LOG group by REQUEST_TIME WHERE COUNT(*)>1\n");
    append("select REQUEST_TIME, COUNT(*) from SDB_WEBSERVICE_LOG group by REQUEST_TIME WHERE COUNT(*)>1\n");
    append("select REQUEST_TIME, COUNT(*) from SDB_WEBSERVICE_LOG group by REQUEST_TIME WHERE COUNT(*)>1\n");
    append("select REQUEST_TIME, COUNT(*) from SDB_WEBSERVICE_LOG group by REQUEST_TIME WHERE COUNT(*)>1\n");
    append(
        "select * as TOT from PRODUCT_REPAIR where groupid=1 and ENTRY_DATE>='2019-01-01' --we ignore entries from 2018 and before and value(STATUS_DATE, ENTRY_DATE)<subdate(date,7) and PROCESS_STATE=4\n");
    append(
        "select * from ( select u.userid, tm.percent as assigned, value(u.PART_TIME_PERCENTAGE,1) parttime, tm.percent-value(u.PART_TIME_PERCENTAGE,1) as diff, u.username from (select USERID, sum(case when MEMBERSHIP_START<=adddate(date,30) and (MEMBERSHIP_END is null or MEMBERSHIP_END>=date)          then MEMBER_PERCENTAGE else 0 end) as percent from TEAM_MEMBER where groupid=1 group by userid) tm right join x_user u on (u.groupid=1 and u.userid=tm.userid) where u.activemode='Y'       and u.userid not in (0,2,3,4,11,54,90,91,92,                             -- 221,234,352,353                            ) ) where diff is null or diff<>0\n");
    append(
        "select u.userid, u.username, t.team_id, t.team_name, tm.MEMBER_PERCENTAGE tm.percent as assigned, value(u.PART_TIME_PERCENTAGE,1) parttime, tm.percent-value(u.PART_TIME_PERCENTAGE,1) as diff, u.username from TEAM t join TEAM_MEMBER tm on (t.groupid=tm.groupid and t.team_id=tm.team_id) join x_user u on (u.groupid=tm.groupi and u.userid=tm.userid) where t.groupid=1 and u.activemode='Y' order by t.sort_level, t.team_id, tm.sort_level, tm.MEMBER_CODE, tm.team_member_id\n");
    append(
        " (select USERID, sum(MEMBER_PERCENTAGE) as percent from TEAM_MEMBER where groupid=1 and MEMBERSHIP_START<=date and (MEMBERSHIP_END is null or MEMBERSHIP_END>=date) group by userid) TM join x_user u on (u.groupid=tm.groupid and u.userid=tm.userid) where u.activestate='Y'\n");
    append(
        "create table TEAM_MEMBER (   groupid groupid key,   team_id team_id key,   TEAM_MEMBER_id TEAM_MEMBER_id key,   userid userid not null,   membership_start date default date not null,   membership_end date,   member_code team_member_code,   sort_order sort_order,   member_percentage percent1 default 1 not null,   member_remarks long unicode,   foreign key f_team (groupid, team_id) references TEAM (groupid, team_id),   foreign key f_user (groupid, userid) references x_user (groupid, userid) )\n");
    append("create domain team_member_code char(1)\n");
    append("create domain TEAM_MEMBER_id fixed(3)\n");
    append(
        "create table TEAM (   groupid groupid key,   team_id team_id key,   team_name varchar(50) not null,   start_date date default date not null,   end_date date,   team_remarks long unicode )\n");
    append("create table TEAM (   groupid groupid key,   team_id team_id key,   team_name varchar(50) not null,   start_date date default date not null,   end_date date,   team_remarks )\n");
    append("create domain team_id fixed(6)\n");
    append("create domain team_id fixed(4)\n");
    append("alter table GOODS_RECEPTION_UNIT_POSITION add constraint c_pending_modes check PENDING_MODE is null or PENDING_MODE in ('R')\n");
    append(
        "select u.userid, u.username, stats.* from (select userid, left(log_date,7) as month, sum(hours) as hours from (  select USERID, LOG_DATE, fixed(count(*)/6,4,2) as hours from ( SELECT s.USERID, s.LOG_DATE, s.hour, s.dekaminute, count(*) count FROM DB_LOG_STATISTIC s left outer join USER_WORKING_TIME_RANGE r on ( r.groupid=1 and s.userid=r.userid and s.log_date between r.date_from and r.date_until and dayofweek(s.log_date) between r.DAY_OF_WEEK_FROM and r.DAY_OF_WEEK_UNTIL )  WHERE s.LOG_DATE between '2020-06-01' and '2020-06-30'  and s.userid not in (11,54) AND s.LOG_DATA_MODE LIKE '-'  and (       r.date_from is null       or       (     s.log_time between r.time_a_begin and r.time_a_end  or s.log_time between r.time_b_begin and r.time_b_end  or s.log_time between r.time_c_begin and r.time_c_end  or s.log_time between r.time_d_begin and r.time_d_end       )     ) group by s.USERID, s.LOG_DATE, s.hour, s.dekaminute ) where count>=2 group by USERID, LOG_DATE  ) group by userid, left(log_date,7)) stats join x_user u on (stats.userid=u.userid and u.groupid=1) where u.ACTIVEMODE='Y' and PRIMARY_DEPARTMENT_CODE<>'I order by month, hours desc\n");
    append(
        "select LOCATION_ID, case when preis<500 then '0-500' else (case when preis<1000 then 501-1000' else '>1000' end) end as range, fixed(count(*)/(12*20),3,1) as guitars from orderposition where groupid=1 and product_id in   (select product_id from product    where groupid=1    and kategorienr in         (select kategorienr from productgroup where groupid=1 and CATEGORY_KEYS_PATH like '1-2-2176-47-%')    ) and QUANTITY>0 and QUANTITY_ORDERED>0 and OPEN_POSITION=0 and ORDER_AGREEMENT_TYPE='B' -- and PREIS>=500 and date(insert_time)>=subdate(date,360) -- and LOCATION_ID=2 group by LOCATION_ID, case when preis<500 then '0-500' else (case when preis<1000 then 501-1000' else '>1000' end) end\n");
    append(
        "select LOCATION_ID, fixed(count(*)/(12*20),3,1) as guitars from orderposition where groupid=1 and product_id in   (select product_id from product    where groupid=1    and kategorienr in         (select kategorienr from productgroup where groupid=1 and CATEGORY_KEYS_PATH like '1-2-2176-47-%')    ) and QUANTITY_ORDERED>0 and OPEN_POSITION=0 and ORDER_AGREEMENT_TYPE='B' and  -- and PREIS>=1000 and date(insert_time)>=subdate(date,360) -- and LOCATION_ID=2 group by LOCATION_ID\n");
    append(
        "select LOCATION_ID, fixed(count(*)/(12*20),3,1) as guitars from orderposition where groupid=1 and product_id in   (select product_id from product    where groupid=1    and kategorienr in         (select kategorienr from productgroup where groupid=1 and CATEGORY_KEYS_PATH like '1-2-2176-47-%')    ) and QUANTITY_ORDERED>0 and OPEN_POSITION=0 and ORDER_AGREEMENT_TYPE='B' and  -- and PREIS>=1000 and date(insert_time)>=subdate(date,360) -- and LOCATION_ID=2 group by LOCATION_ID\n");
    append("alter table PHONE_CALL add foreign key f_PENDING_MODE (groupid,PENDING_MODE) references PENDING_MODE (groupid,PENDING_MODE)\n");
    append("alter table USER_REMINDER add foreign key f_PENDING_MODE (groupid,PENDING_MODE) references PENDING_MODE (groupid,PENDING_MODE)\n");
    append("alter table INT_MESSAGE add foreign key f_PENDING_MODE (groupid,PENDING_MODE) references PENDING_MODE (groupid,PENDING_MODE)\n");
    append(
        "create table PENDING_MODE (   groupid groupid key,   PENDING_MODE PENDING_MODE key,   pending_mode_name varchar(50) not null,   pending_mode_description varchar(500) )  alter table INT_MESSAGE add PENDING_MODE PENDING_MODE\n");
    append("create domain PENDING_MODE char(1)\n");
    append("select * from user_process where groupid=1 and USERID=284 and PROCESS_START>'2020-06-23 16:12:28.97' PROCESS_START<'2020-06-23 16:14:28.97'\n");
    append("alter table X_USER add constraint c_temp_blocked_user check not (userid=10 and (USER_USER_GRANTS or INT_MESS_MODE<>'N' or EXT_MESS_FORWARD_MODE<>'N'))\n");
    append("select * from imap_link where groupid=1 and mail_from like '%@dhl.com' and mail_reply_to not like '%@dhl.com')\n");
    append(
        "select TASK_TITLE, ASSIGNED_TO_USER, chr(datediff(date,TASK_DATE)) & case when TASK_DATE>=subdate(date,14) then '*' else '' end as  from IT_TASK where groupid=1 and TASK_STATUS=1 and TASK_PRIORITY>=80 order by insert_time desc\n");
    append("alter table ORDERMAIN_CUSTOMER_FEEDBACK add constraint C_REVIEW check (REVIEW_DATE IS NOT NULL AND REVIEW_USER IS NOT NULL) or (REVIEW_DATE IS NULL AND REVIEW_USER IS NULL)\n");
    append("alter table ORDERMAIN_CUSTOMER_FEEDBACK add constraint C_REVIEW check (REVIEW_DATE IS NOT NULL AND REVIEW_USER IS NOT NULL) or (REVIEW_DATE IS NULL AND REVIEW_USER IS NULL)\n");
    append("alter table ORDERMAIN_CUSTOMER_FEEDBACK add constraint C_REVIEW REVIEW_DATE IS NOT NULL AND REVIEW_USER IS NOT NULL\n");
    append("alter table SUPPLIER_ORDER_INFO add constraint c_SUPPL_ORDER_INFO_TYPE check SUPPL_ORDER_INFO_TYPE is null or SUPPL_ORDER_INFO_TYPE in ('C','P','B')\n");
    append("create domain SUPPL_ORDER_INFO_TYPE char(1)\n");
    append("alter table SUPPLIER_ORDER_INFO add foreign key f_later_supplier_order_info (groupid,later_SUPPLIER_ORDER_INFO_ID) references SUPPLIER_ORDER_INFO (groupid,SUPPLIER_ORDER_INFO_ID)\n");
    append(
        "select count(*) from CUSTOMER_REFUND where groupid=1 and CUSTOMER_REFUND.STATUS='P' date(CUSTOMER_REFUND.REQUEST_DATE)<subdate(date,7) and ORDER_ID not in (   select order_id from ORDERPOSITION   where GROUPID=1   and OPEN_POSITION<0   and ORDERPOSITION.ORDER_ID=CUSTOMER_REFUND.ORDER_ID )\n");
    append(
        "select count(*) from CUSTOMER_REFUND where groupid=1 and STATUS='P' date(insert_time)<subdate(date,7) and ORDER_ID not in (   select order_id from ORDERPOSITION   where GROUPID=1   and OPEN_POSITION<0   and ORDERPOSITION.ORDER_ID=CUSTOMER_REFUND.ORDER_ID )\n");
    append("delete * from wiki_user\n");
    append(
        "INSERT INTO WIKI_USER VALUES (42,'','','','Robot',0,1,NULL,'',NULL,'2019-03-11 11:24:40','2019-03-11 11:24:40','Group',NULL,'',NULL,0,NULL) INSERT INTO WIKI_USER VALUES (44,'oltka','26a2b4bc39f3a85405d60333118dc30d3bf1e4b0','Alena','Tkach',0,3,'2019-12-12 21:09:37','en',NULL,'2019-04-23 10:44:43','2019-12-16 10:56:35','User',NULL,'only_my_events','f70339cdf887ef4cf84df0cd4adae5d5',0,'2019-04-23 11:07:51')\n");
    append(
        "INSERT INTO WIKI_USER VALUES (2,'','','','Anonymous users',0,1,NULL,'',NULL,'2016-06-04 10:27:31','2016-06-04 10:27:31','GroupAnonymous',NULL,'',NULL,0,NULL) INSERT INTO WIKI_USER VALUES (3,'','','','Non member users',0,1,NULL,'',NULL,'2016-06-04 10:27:31','2016-06-04 10:27:31','GroupNonMember',NULL,'',NULL,0,NULL) INSERT INTO WIKI_USER VALUES (4,'','','','Anonymous',0,0,NULL,'',NULL,'2016-06-04 11:00:55','2016-06-04 11:00:55','AnonymousUser',NULL,'only_my_events',NULL,0,NULL) INSERT INTO WIKI_USER VALUES (5,'','','','Developer',0,1,NULL,'',NULL,'2016-06-05 12:16:09','2016-06-05 12:16:09','Group',NULL,'',NULL,0,NULL) INSERT INTO WIKI_USER VALUES (6,'','','','Regular User',0,1,NULL,'',NULL,'2016-06-05 12:16:28','2016-06-05 12:16:28','Group',NULL,'',NULL,0,NULL) INSERT INTO WIKI_USER VALUES (7,'tinev','abf9a288e109986b38704d0f71f6ed818a4aa3be','Tiago','Neves',1,1,'2020-01-27 13:15:13','en',NULL,'2016-06-05 12:52:52','2016-06-05 12:52:52','User',NULL,'only_my_events','666586e5a0470b0c79527f81c45e37ee',0,'2016-06-05 12:52:52')\n");
    append("alter table internal_page add create_time timestamp default timestamp\n");
    append(
        "select PAYMENT_MODE, LANGCODE, OUR_COUNTRYCODE, DIVISIONCODE from SDB_PAYMENT_MODE except all select distinct PAYMENT_MODE, LANGCODE, OUR_COUNTRYCODE, DIVISIONCODE from SDB_PAYMENT_MODE\n");
    append("select LANGCODE, OUR_COUNTRYCODE, DIVISIONCODE from SDB_PAYMENT_MODE except all select distinct LANGCODE, OUR_COUNTRYCODE, DIVISIONCODE from SDB_PAYMENT_MODE\n");
    append("alter TABLE RESPONSIBILITY_STATS_PARAMETER replace primary key (   GROUPID ,   RESPONSIBILITY_STATS_PARAM_ID)\n");
    append("alter TABLE RESPONSIBILITY_STATS_PARAMETER replace primary key (   GROUPID ,   RESPONSIBILITY_STATS_PARAM_ID)\n");
    append("alter table WIDGET add foreign key f_table (SQL_DB_CONTEXT_ID, tablename) references x_table (db_context_id, TABLENAME)\n");
    append(
        "  select sum(case when ENTRY_DATE<=subdate(date,61) then 1 else 0) as A,          sum(case when ENTRY_DATE<=subdate(date,31) then 1 else 0) as B   from CUSTOMER_COMPLAINT   where groupid=1 and COMPLAINT_STATUS=1\n");
    append("alter table TRADEMARK_TASK add constraint c_TASK_PENDING_FROM check TASK_PENDING_FROM is null or TASK_PENDING_FROM>ENTRY_DATE\n");
    append("alter table TRADEMARK_TASK check TASK_PENDING_FROM is null or TASK_PENDING_FROM>ENTRY_DATE\n");
    append(
        "alter table TRADEMARK_TASK add constraint c_TASK_APPROVED_DATE_USER check TASK_APPROVED_DATE is not null and TASK_APPROVED_user is not null or TASK_APPROVED_DATE is null and TASK_APPROVED_user is null\n");
    append("select * from standard_doc_pos where distinct(deltext) is not null\n");
    append("select * from standard_doc_pos where distinct deltext is not null\n");
    append("select distinct deltext from standard_doc_pos where deltext is not null and\n");
    append("select distinct deltext from standard_doc_pos where deltext is not null and\n");
    append("select distinct from standard_doc_pos where deltext is not null and\n");
    append("select * distinct from standard_doc_pos where deltext is not null and\n");
    append("alter table SALARY_MONTH_REPORT add constraint c_DEDUCTION_NATURAL check DEDUCTION_NATURAL is null and PRIVATE_PARTS_AMOU is null or DEDUCTION_NATURAL=PRIVATE_PARTS_AMOU\n");
    append("alter table FORM_FIELD add constraint c_DEDUCTION_NATURAL check DEDUCTION_NATURAL is null and PRIVATE_PARTS_AMOU is null or DEDUCTION_NATURAL=PRIVATE_PARTS_AMOU\n");
    append(
        "ALTER TABLE WEB_DOMAIN_QUOTE ADD FOREIGN KEY F_WEB_DOMAIN_STANDARD_SND_LEVEL     (WEB_DOMAIN_TOPLEVEL, WEB_DOMAIN_STANDARD_SND_LEVEL) REFERENCES WEB_DOMAIN_STANDARD_SND_LEVEL     (WEB_DOMAIN_TOPLEVEL, WEB_DOMAIN_STANDARD_SND_LEVEL)\n");
    append("ALTER TABLE WEB_DOMAIN_QUOTE ADD FOREIGN KEY F_WEB_DOMAIN_TOPLEVEL (WEB_DOMAIN_TOPLEVEL) REFERENCES WEB_DOMAIN_TOPLEVEL (WEB_DOMAIN_TOPLEVEL)\n");
    append("ALTER TABLE WEB_DOMAIN_QUOTE ADD FOREIGN KEY F_REGISTRAR (GROUPID, REGISTRAR_ID) REFERENCES WEB_DOMAIN_REGISTRAR (GROUPID, REGISTRAR_ID)\n");
    append("ALTER TABLE WEB_DOMAIN_QUOTE ADD FOREIGN KEY F_DOMAIN_NAME (GROUPID, DOMAIN_NAME) REFERENCES OUR_WEB_DOMAIN (GROUPID, DOMAIN_NAME)\n");
    append(
        "CREATE TABLE WEB_DOMAIN_QUOTE (   GROUPID GROUPID KEY,   WEB_DOMAIN_REGISTRAR_ID FIXED(5) KEY,   DOMAIN_NAME VARCHAR(100) not null,   WEB_DOMAIN_TOPLEVEL WEB_DOMAIN_TOPLEVEL NOT NULL,   WEB_DOMAIN_STANDARD_SND_LEVEL WEB_DOMAIN_STANDARD_SND_LEVEL,   REGISTRAR_ID VARCHAR(200) not null,   IS_DOMAIN_AVAILABLE BOOLEAN not null default false,   PRICE_PER_YEAR BETRAG_MITTEL,   CURRENCY CURRENCY_CODE,   CHECK_DATE DATE,   CHECK_USER USERID )\n");
    append(
        "CREATE TABLE WEB_DOMAIN_QUOTE (   GROUPID GROUPID KEY,   WEB_DOMAIN_REGISTRAR_ID FIXED(5) KEY,   DOMAIN_NAME VARCHAR(100) not null,   WEB_DOMAIN_TOPLEVEL WEB_DOMAIN_TOPLEVEL NOT NULL,   WEB_DOMAIN_STANDARD_SND_LEVEL WEB_DOMAIN_STANDARD_SND_LEVEL,   REGISTRAR_ID VARCHAR(200) not null,   IS_DOMAIN_AVAILABLE BOOLEAN not null default false,   PRICE_PER_YEAR BETRAG_MITTEL,   CURRENCY CURRENCY_CODE,   CHECK_DATE DATE,   CHECK_USER USERID )\n");
    append(
        "CREATE TABLE WEB_DOMAIN_QUOTE (   GROUPID GROUPID KEY,   WEB_DOMAIN_REGISTRAR_ID FIXED(5) KEY,   DOMAIN_NAME VARCHAR(100),   WEB_DOMAIN_TOPLEVEL WEB_DOMAIN_TOPLEVEL NOT NULL,   WEB_DOMAIN_STANDARD_SND_LEVEL WEB_DOMAIN_STANDARD_SND_LEVEL,   REGISTRAR_ID VARCHAR(200),   IS_DOMAIN_AVAILABLE BOOLEAN,   PRICE_PER_YEAR BETRAG_MITTEL,   CURRENCY CURRENCY_CODE,   CHECK_DATE DATE,   CHECK_USER USERID, )\n");
    append("ALTER TABLE OUR_WEB_DOMAIN ADD FOREIGN KEY F_REGISTRAR_AT (GROUPID, REGISTERED_AT) REFERENCES WEB_DOMAIN_REGISTRAR (GROUPID, REGISTRAR_ID)\n");
    append("ALTER TABLE OUR_WEB_DOMAIN ADD FOREIGN KEY F_REGISTRAR_AT (GROUPID, REGISTERED_AT) REFERENCES WEB_DOMAIN_REGISTRAR (GROUPID, REGISTRAR_ID)\n");
    append("ALTER TABLE OUR_WEB_DOMAIN ADD FOREIGN KEY F_REGISTRAR_AT (GROUPID, REGISTERED_AT) REFERENCES WEB_DOMAIN_REGISTRAR (GROUPID, REGISTRAR_ID)\n");
    append(
        "select count(*)   from parcel p   left outer join ourlocation_transfer_out_parcel to on (to.groupid = p.groupid and to.parcel_id = p.parcel_id)   left outer join ourlocation_transfer_in_parcel ti on (ti.groupid = p.groupid and ti.parcel_id = p.parcel_id)   left outer join delivery_parcel dp on (dp.groupid = p.groupid and dp.parcel_id = p.parcel_id)   left outer join our_parcel op on (op.groupid = p.groupid and op.parcel_id = p.parcel_id)   left outer join paid_parcel_label ppl on (ppl.groupid = p.groupid and ppl.parcel_id = p.parcel_id)   left outer join product_repair_parcel rp on (rp.groupid = p.groupid and rp.parcel_id = p.parcel_id)   left outer join parcel_link pl on (pl.groupid = p.groupid and pl.parcel_id = p.parcel_id)   left outer join return_label rl on (rl.groupid = p.groupid and rl.parcel_id = p.parcel_id)   left outer join rma_del_in_parcel rip on (rip.groupid = p.groupid and rip.parcel_id = p.parcel_id)   left outer join rma_del_out_parcel rop on (rop.groupid = p.groupid and rop.parcel_id = p.parcel_id)   where p.groupid = 1      and date(p.insert_time) > '2015-01-01'     and to.groupid is null     and ti.groupid is null     and dp.groupid is null     and op.groupid is null     and ppl.groupid is null     and rp.groupid is null     and pl.groupid is null     and rl.groupid is null     and rip.groupid is null     and rop.groupid is null\n");
    append("alter table INT_MESSAGE add constraint c_to_users_set check TO_USERS is not null or (groupid=1 and INT_MESSAGE_ID<=633682)\n");
    append("alter table INT_MESSAGE check TO_USERS is not null or (groupid=1 and INT_MESSAGE_ID<=633682)\n");
    append("select distinct year(insert_time) form INT_MESSAGE where tO_USERS is null\n");
    append("ALTER TABLE PRODUCT_STOCK_INTMESSAGE CONSTRAINT C_TYPE\n");
    append("ALTER TABLE PRODUCT_STOCK_INTMESSAGE drop CONSTRAINT\n");
    append("alter table arch_shop_sync_queue add delete_only boolean default false not null\n");
    append("alter table shop_sync_queue add delete_only boolean default false not null\n");
    append("alter table shop_sync_queue add delete boolean default false not null\n");
    append("ALTER TABLE PRODUCT_STOCK_INTMESSAGE ADD CONSTRAINT C_TYPE CHECK NOTIFICATION_TYPE IN ('P', 'F')\n");
    append("ALTER TABLE PRODUCT_STOCK_INTMESSAGE ADD CONSTRAINT CHECK NOTIFICATION_TYPE IN ('P', 'F')\n");
    append("ALTER TABLE PRODUCT_STOCK_INTMESSAGE ADD CONSTRAINT CHECK NOTIFICATION_TYPE IN ('P', 'F')\n");
    append("ALTER TABLE PRODUCT_STOCK_INTMESSAGE ADD CONSTRAINT NOTIFICATION_TYPE CHECK STATUS IN ('P', 'F')\n");
    append("select * from email_division where insert_time > 24.03.2020\n");
    append("SELECT * FROM EMAIL_DIVISION WHERE last_mode_change_timestamp is not nullORDER BY GROUPID, EMAIL, DIVISIONCODE\n");
    append(
        "select * from (  update SUPPLIER_ORDER_INFO set process_status=5 where groupid=1 and lower(substr(REMARKS,1,50)) like '%updat%' and process_status=3 and substr(REMARKS,1,50) in ( 'Updated according to Invoice', 'Sequential Backorders - Updated', 'Updated => E899593y', 'Adam Hall Backorders - Updated', 'Chase Bliss Backorders - Updated', 'EarthQuaker Devices Afterneath V3 - Updated', 'FACE backorders - Updated', 'Heer Backorders - Updated' )\n");
    append("alter table CUSTOMER_SPECIAL_PRICE_REQUEST add constraint c_price_or_reason check PRICE_REQUESTED is not null or REASON is not null\n");
    append(
        "alter table X_COLUMN add constraint c_COLUMN_USE_MODE_nullable check not (COLUMN_USE_MODE in (3,4) and DB_NULLABLE='NO' and DB_DEFAULT is null and DB_DEFAULTFUNCTION is null and drop_date is null)\n");
    append("alter table X_COLUMN add constraint c_COLUMN_USE_MODE_nullable check not (COLUMN_USE_MODE in (3,4) and DB_NULLABLE='NO' and DB_DEFAULT is null and DB_DEFAULTFUNCTION is null)\n");
    append("alter table CUSTOMER_COMPLAINT add constraint c_COMPLAINT_STATUS check not (COMPLAINT_STATUS=2 and PREVENT_ACTION is not null or COMPLAINT_STATUS=3 and PREVENT_ACTION is null)\n");
    append("alter table CUSTOMER_COMPLAINT add constraint c_COMPLAINT_STATUS check not COMPLAINT_STATUS=2 and PREVENT_ACTION is not null\n");
    append("select * from ( select CREATE_USER, count(*), min(PENDING_USER) min_pending, max(PENDING_USER) as max_pending tot from CUSTOMER_COMPLAINT group by CREATE_USER ) order by tot desc\n");
    append("alter table PRODUCT_REPAIR add constraint c_recheck_date check not (recheck_date is not null and PENDING_USERID is null)\n");
    append(
        "CREATE TABLE SDB_WEB_LEGAL_INFO (   GROUPID GROUPID KEY,   DIVISIONCODE CHAR(5) ASCII KEY,   COUNTRYCODE COUNTRYCODE KEY,   LANGCODE LANGCODE KEY,   LEGAL_INFO_ID LEGAL_INFO_ID KEY,   SORT_ORDER SORT_ORDER,   TITLE VARCHAR(200) UNICODE,   TEXT LONG UNICODE,   LINK_KEY CHAR(20) ASCII NOT NULL,   EMBED_TEXT_AS_IMAGE BOOLEAN DEFAULT FALSE NOT NULL,   TITLE_PROPERTY_KEY TEXT_PROPERTY_KEY,   LEGAL_INFO_TYPE LEGAL_INFO_TYPE DEFAULT 'IP' NOT NULL )\n");
    append("GRANT INSERT ON SDB_SHOP_SUBSERIES_COUNTRY TO SHOP_USER\n");
    append("GRANT DELETE ON SDB_SHOP_SUBSERIES_COUNTRY TO SHOP_USER\n");
    append("GRANT SELECT ON SDB_SHOP_SUBSERIES_COUNTRY TO SHOP_USER\n");
    append("GRANT UPDATE ON SDB_SHOP_SUBSERIES_COUNTRY TO SHOP_USER\n");
    append("GRANT UPDATE ON SHOP_SUBSERIES_COUNTRY TO SHOP_USER\n");
    append("GRANT INSERT ON SHOP_SUBSERIES_COUNTRY TO SHOP_USER\n");
    append("GRANT SELECT ON SHOP_SUBSERIES_COUNTRY TO SHOP_USER\n");
    append("GRANT SELECT ON SHOP_SUBSERIES_COUNTRY TO SHOP_USER\n");
    append("alter table PRODUCT_REPAIR add constraint c_FIRST_SOURCE_REFERENCE_set check FIRST_SOURCE_REFERENCE is not null or ENTRY_DATE<'2020-06-22'\n");
    append(
        "alter table PRODUCT_REPAIR add constraint c_OUR_FAILURE_DESCRIPT_USER check OUR_FAILURE_DESCRIPTION is null and OUR_FAILURE_DESCRIPT_USER is null or OUR_FAILURE_DESCRIPTION is not null and OUR_FAILURE_DESCRIPT_USER is not null\n");
    append(
        "alter table PRODUCT_REPAIR add constraint c_OUR_FAILURE_DESCRIPT_USER check OUR_FAILURE_DESCRIPTION is null and OUR_FAILURE_DESCRIPT_USER is null or OUR_FAILURE_DESCRIPTION is not null and OUR_FAILURE_DESCRIPT_USER not null\n");
    append(
        "alter table add constraint c_OUR_FAILURE_DESCRIPT_USER check OUR_FAILURE_DESCRIPTION is null and OUR_FAILURE_DESCRIPT_USER is null or OUR_FAILURE_DESCRIPTION is not null and OUR_FAILURE_DESCRIPT_USER not null\n");
    append("alter table PRODUCT_REPAIR column CUSTOMERS_REMARK_TRANSLATED long unicode\n");
    append("alter table PRODUCT_REPAIR add foreign key f_cust_remark_language (CUSTOMERS_REMARK_LANGCODE) references X_ISO_LANGUAGE (langcode)\n");
    append("alter table PRODUCT_REPAIR add foreign key f_cust_remark_language (CUSTOMERS_REMARK_LANGCODE) references language (langcode)\n");
    append("alter table SUPPLIER_INVOICE add constraint c_status check STATUS in (0,1,2,3,4,5,6,8,9)\n");
    append("alter table invoice column status add default 0\n");
    append("alter table invoice column status supplier_invoice_status default 0 not null\n");
    append("alter table invoice column status supplier_invoice_status\n");
    append("alter table invoice column status supplier_invoice_status\n");
    append("create domain supplier_invoice_status fixed(1)\n");
    append("rename column invoice.status2 to status\n");
    append("rename column invoice.customer_invoice_status to status2\n");
    append("create domain customer_invoice_status fixed(1)\n");
    append(
        " select c.groupid, c.MANDATNR, c.PERIOD_ID, c.result_id, p.MANDATE_PERIOD, p.PERIOD_TYPE, p.BEGIN_DATE, p.END_DATE from (select * from FINCHECK_RESULT where (groupid, MANDATNR, PERIOD_ID, max(RESULT_ID) as result_id)    in (select groupid, MANDATNR, PERIOD_ID, max(RESULT_ID) as result_id from FINCHECK_RESULT        where groupid=1 and MANDATNR=10 and date(insert_time)>=date(chr(year(date)-2) & '-01-01')        group by groupid, MANDATNR, PERIOD_ID)) c join FINCHECK_PERIOD p on (c.groupid=p.groupid  and c.MANDATNR=p.MANDATNR  and c.PERIOD_ID=p.PERIOD_ID)\n");
    append(
        "select c.groupid, c.MANDATNR, c.PERIOD_ID, c.result_id, p.MANDATE_PERIOD, p.PERIOD_TYPE, p.BEGIN_DATE, p.END_DATE from (select groupid, MANDATNR, PERIOD_ID, max(RESULT_ID) as result_id from FINCHECK_RESULT where groupid=1 and MANDATNR=10 and date(insert_time)>=date(chr(year(date)-2) & '01-01' -- right(date,6)) group by groupid, MANDATNR, PERIOD_ID) c join FINCHECK_PERIOD p on (c.groupid=p.groupid  and c.MANDATNR=p.MANDATNR  and c.PERIOD_ID=p.PERIOD_ID)\n");
    append("alter table SUPPLIER_ORDER_INFO add constraint c_PROCESS_STATUS check PROCESS_STATUS in (1,2,3,4,5)\n");
    append("alter table SUPPLIER_ORDER_INFO add constraint c_last_state_user_timestamp check not (PROCESS_STATUS>1 and (LAST_STATE_CHANGE_USER is null or LAST_STATE_CHANGE_DATE is null))\n");
    append("alter table SUPPLIER_ORDER_INFO add constraint c_last_state_user_timestamp check not PROCESS_STATUS>1 and (LAST_STATE_CHANGE_USER is null or LAST_STATE_CHANGE_DATE is null)\n");
    append("alter table SUPPLIER_ORDER_INFO add constraint c_last_state_user_timestamp check not PROCESS_STATUS>1 and (LAST_STATE_CHANGE_USER is null or LAST_STATE_CHANGE_DATE is null)\n");
    append("alter table SUPPLIER_ORDER_INFO add constraint c_delivery_status check order_id is not null and DELIVERY_STATUS is not null or order_id is null and DELIVERY_STATUS is null\n");
    append("alter table SUPPLIER_ORDER_INFO add foreign key f_delivery_status (DELIVERY_STATUS) references DELIVERY_STATUS (DELIVERY_STATUS)\n");
    append("alter table CUSTOMER_SPECIAL_PRICE_REQUEST column CREATE_DATE add default date\n");
    append("alter table CUSTOMER_SPECIAL_PRICE_REQUEST add foreign key f_competitor   (groupid, COMPETITORID) references COMPETITOR (groupid,COMPETITORID)\n");
    append("alter table CUSTOMER_SPECIAL_PRICE_REQUEST add foreign key f_currency   (target_currency) references currency (CURRENCY_CODE)\n");
    append("alter table CUSTOMER_SPECIAL_PRICE_REQUEST add foreign key f_currency   (target_currency) references country (CURRENCYCODE)\n");
    append("alter table CUSTOMER_SPECIAL_PRICE_REQUEST add foreign key f_currency   (target_currency) references country (CURRENCY_CODE)\n");
    append("alter table CUSTOMER_SPECIAL_PRICE_REQUEST add foreign key f_country   (target_currency) references country (CURRENCY_CODE)\n");
    append("alter table CUSTOMER_SPECIAL_PRICE_REQUEST add foreign key f_country   (target_country) references country (COUNTRYCODE)\n");
    append("alter table CUSTOMER_SPECIAL_PRICE_REQUEST add target_country add foreign key f_country   (target_country) references country (COUNTRYCODE)\n");
    append("alter table CUSTOMER_SPECIAL_PRICE_REQUEST add target_country add foreign key f_country   (target_country) references country (COUNTRYCODE)\n");
    append("alter table CUSTOMER_SPECIAL_PRICE_REQUEST add foreign key f_contact   (groupid, customer_address_id, customer_contact_id)        references contact (groupid, address_id, contact_id)\n");
    append("alter table CUSTOMER_SPECIAL_PRICE_REQUEST add foreign key f_address   (groupid, customer_address_id, customer_contact_id)        references contact (groupid, address_id, contact_id)\n");
    append("alter table CUSTOMER_SPECIAL_PRICE_REQUEST add foreign key f_address   (groupid, customer_address_id) references address (groupid, address_id)\n");
    append("alter table CUSTOMER_SPECIAL_PRICE_REQUEST add foreign key f_product (groupid,product_id) references product (groupid, product_id)\n");
    append("alter table CUSTOMER_SPECIAL_PRICE_REQUEST add foreig key f_product (groupid,product_id) references product (groupid, product_id)\n");
    append("alter table messagein_user add favourite boolean not null default false\n");
    append("alter table contact_form_user add favourite boolean not null default false\n");
    append("alter table IT_TASK_DATA add constraint c_data_scan check data_key is null and scan_document_id is not null or data_key is not null and scan_document_id is null\n");
    append("alter table IT_TASK_DATA add constraint c_data_scan check data_key is null scan_document_id is not null or data_key is not null scan_document_id is null\n");
    append("alter table IT_TASK_DATA add foreign key f_scan_document (groupid, scan_document_id) references scan_document (groupid, scan_document_id)\n");
    append("alter table BUG_MESSAGE add constraint c_BUG_TITLE check BUG_TITLE<>'' and BUG_TITLE not like '% %'\n");
    append("alter table BUG_MESSAGE add constraint c_BUG_TITLE check BUG_TITLE<>'' and BUG_TITLE not like '% %'\n");
    append("select count(*) from BUG_MESSAGE where not (BUG_TITLE<>'' and BUG_TITLE not like '% %'(\n");
    append("alter table BUG_MESSAGE add constraint c_BUG_TITLE check BUG_TITLE<>'' and BUG_TITLE not like '% %'\n");
    append("select --substr(STACKTRACE,1,44)  substr(STACKTRACE,44,45)  from bug_message  where bug_title=''  --and substr(STACKTRACE,44,45)=' ' -- 44, 171, 81\n");
    append("select substr(STACKTRACE,1,44)  substr(STACKTRACE,44,45)  from bug_message  where bug_title=''  --and substr(STACKTRACE,44,45)=' ' -- 44, 171, 81\n");
    append(
        "select substr(STACKTRACE,1,171) a, substr(STACKTRACE,43,45) b, case when substr(STACKTRACE,40,47)=' ' then 'A' else 'B' end from BUG_MESSAGE  where bug_title=''  and substr(STACKTRACE,44,45))=' ' -- 44, 171, 81\n");
    append(
        "ALTER TABLE PERIODICAL_TASK add constraint c_MONTH_OF_PERIOD check MONTH_OF_PERIOD is null or (PERIOD_CODE='Y' and MONTH_OF_PERIOD between 1 and 12) or (PERIOD_CODE='S' and MONTH_OF_PERIOD between 1 and 6) or (PERIOD_CODE='T' and MONTH_OF_PERIOD between 1 and 3) or (PERIOD_CODE='N' and MONTH_OF_PERIOD between 1 and 2)\n");
    append(
        "ALTER TABLE PERIODICAL_TASK add constraint c_MONTH_OF_PERIOD MONTH_OF_PERIOD is null or (PERIOD_CODE='Y' and MONTH_OF_PERIOD between 1 and 12) or (PERIOD_CODE='S' and MONTH_OF_PERIOD between 1 and 6) or (PERIOD_CODE='T' and MONTH_OF_PERIOD between 1 and 3) or (PERIOD_CODE='N' and MONTH_OF_PERIOD between 1 and 2)\n");
    append("alter table PERIODICAL_TASK add constraint c_PERIOD_CODE_NEXTENTRY check NOT (PERIOD_CODE='Y' AND NEXTENTRY_NUMBER>1)\n");
    append("alter table PERIODICAL_TASK add constraint check NOT (PERIOD_CODE='Y' AND NEXTENTRY_NUMBER>1)\n");
    append("select count(*) from ordermain where groupid=1 and order_country_code<>'CH' and OTHER_COUNTRY_CODE in ('CH, 'LI') and delivery_status<>'C'\n");
    append("alter table COMPETITOR add constraint c_PANEL_DISPLAY_MODE check PANEL_DISPLAY_MODE is null or PANEL_DISPLAY_MODE='S' or PANEL_DISPLAY_MODE='H'\n");
    append("GRANT UPDATE ON SDB_SHOP_SERIES_COUNTRY TO SHOP_USER\n");
    append("GRANT INSERT ON SDB_SHOP_SERIES_COUNTRY TO SHOP_USER\n");
    append("GRANT DELETE ON SDB_SHOP_SERIES_COUNTRY TO SHOP_USER\n");
    append("GRANT SELECT ON SDB_SHOP_SERIES_COUNTRY TO SHOP_USER\n");
    append(
        "select NOTIFICATION_CODE,MESSAGE_TEMPLATE_ID, count(*) from MESSAGEOUT where groupid=1 and (NOTIFICATION_CODE='ID' orMESSAGE_TEMPLATE_ID=266) group by NOTIFICATION_CODE,MESSAGE_TEMPLATE_ID\n");
    append("alter table COMPETITOR add constraint c_AUTO_GRABBING_MODE check AUTO_GRABBING_MODE is null or AUTO_GRABBING_MODE='A'\n");
    append("Process finished with exit code 0\n");
  }

  private static void append(String sql) {
    PROBLEMATICS.add(sql);
  }

  public static void main(String[] args) {
    /*for (String sql : PROBLEMATICS) {
      if (sql.trim().length() > 0) {
        parseStatement(sql.trim());
      }
    }*/
    parseStatement("drop index i_insert_time on git_commit");
  }

  private static void parseStatement(String sqls) {
    Statements statements = null;
    String formattedSql = sqls.replaceAll("\n", " ");
    try {
      statements = CCJSqlParserUtil.parseStatements(formattedSql);
      System.out.println(statements);
    } catch (JSQLParserException e) {
      //System.out.println(formattedSql);
      e.printStackTrace();
    }
  }
}
