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
    parseStatement("alter table it_task_review drop primary key");

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
