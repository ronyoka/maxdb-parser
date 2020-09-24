/*-
 * #%L
 * JSQLParser library
 * %%
 * Copyright (C) 2004 - 2020 JSQLParser
 * %%
 * Dual licensed under GNU LGPL 2.1 or Apache License 2.0
 * #L%
 */
package net.sf.jsqlparser;

import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.Statements;

public class Test {

  public static void main(String[] args) {
    parseStatement("create table code_change_target\n"
        + "(\n"
        + "    groupid         groupid key,\n"
        + "    notification_id code_change_notif_id key,\n"
        + "    target_id       fixed(6) key,\n"
        + "    folder_name     varchar(800) ascii,\n"
        + "    file_name       varchar(200) ascii,\n"
        + "    foreign key f_code_change_notification (groupid, notification_id) references code_change_notification (groupid, notification_id)\n"
        + ")");

  }

  private static void parseStatement(String sqls) {
    Statements statements = null;
    try {
      statements = CCJSqlParserUtil.parseStatements(
          sqls);
      System.out.println(statements);
    } catch (JSQLParserException e) {
      e.printStackTrace();
    }
  }
}
