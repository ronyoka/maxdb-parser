/*-
 * #%L
 * JSQLParser library
 * %%
 * Copyright (C) 2004 - 2019 JSQLParser
 * %%
 * Dual licensed under GNU LGPL 2.1 or Apache License 2.0
 * #L%
 */
package net.sf.jsqlparser.statement.values;

import static net.sf.jsqlparser.test.TestUtils.asList;
import static net.sf.jsqlparser.test.TestUtils.assertDeparse;
import static net.sf.jsqlparser.test.TestUtils.assertEqualsObjectTree;
import static net.sf.jsqlparser.test.TestUtils.assertSqlCanBeParsedAndDeparsed;
import static net.sf.jsqlparser.test.TestUtils.toReflectionString;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.expression.LongValue;
import net.sf.jsqlparser.expression.StringValue;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.select.Select;
import net.sf.jsqlparser.statement.select.SetOperationList;
import org.junit.Test;

public class ValuesTest {

    @Test
    public void testDuplicateKey() throws JSQLParserException {
        String statement = "VALUES (1, 2, 'test')";
        Statement parsed = assertSqlCanBeParsedAndDeparsed(statement);
        Select created = new Select().withSelectBody(new SetOperationList()
            .addBrackets(Boolean.FALSE).addSelects(new ValuesStatement().addExpressions(new LongValue(1))
                                                                        .addExpressions(asList(new LongValue(2), new StringValue("test")))));

        assertDeparse(created, statement);
        assertEqualsObjectTree(parsed, created);
        System.out.println(toReflectionString(created));
    }

    @Test
    public void testComplexWithQueryIssue561() throws JSQLParserException {
        assertSqlCanBeParsedAndDeparsed(
            "WITH split (word, str, hascomma) AS (VALUES ('', 'Auto,A,1234444', 1) UNION ALL SELECT substr(str, 0, CASE WHEN instr(str, ',') THEN instr(str, ',') ELSE length(str) + 1 END), ltrim(substr(str, instr(str, ',')), ','), instr(str, ',') FROM split WHERE hascomma) SELECT trim(word) FROM split WHERE word != ''");
    }
}
