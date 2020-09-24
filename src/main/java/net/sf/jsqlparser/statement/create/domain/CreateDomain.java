/*-
 * #%L
 * JSQLParser library
 * %%
 * Copyright (C) 2004 - 2020 JSQLParser
 * %%
 * Dual licensed under GNU LGPL 2.1 or Apache License 2.0
 * #L%
 */
package net.sf.jsqlparser.statement.create.domain;

import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.StatementVisitor;

public class CreateDomain implements Statement {

  private String kind;
  private String kind2;
  private String kind3;


  @Override
  public void accept(StatementVisitor statementVisitor) {
    //todo statementVisitor.visit(this);
  }

  @Override
  public String toString() {
    return "CREATE DOMAIN " + kind + " " + kind2 + "(" + kind3 + ")";
  }

  public String getKind() {
    return kind;
  }

  public void setKind(String kind) {
    this.kind = kind;
  }

  public String getKind2() {
    return kind2;
  }

  public void setKind2(String kind2) {
    this.kind2 = kind2;
  }

  public String getKind3() {
    return kind3;
  }

  public void setKind3(String kind3) {
    this.kind3 = kind3;
  }
}
