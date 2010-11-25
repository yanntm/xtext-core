/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parser;

import org.eclipse.xtext.parser.impl.PartialParsingPointers;
import org.eclipse.xtext.testlanguages.SimpleExpressionsTestLanguageStandaloneSetup;

/**
 * @author Jan K�hnlein - Initial contribution and API
 * @author Sebastian Zarnekow
 */
public class PartialParsingPointerExpressionTest extends AbstractPartialParsingPointerTest {
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(SimpleExpressionsTestLanguageStandaloneSetup.class);
	}
	
	public void testExpression_1_1() throws Exception {
		String model = "(a+b+c)*(c/d)";
		PartialParsingPointers parsingPointers = calculatePartialParsingPointers(model, 1, 1);
		checkParseRegionPointers(parsingPointers, "a+b+c", "Action", "Addition");
	}
		
	public void testExpression_3_1() throws Exception {
		String model = "(a+b+c)*(c/d)";
		PartialParsingPointers parsingPointers = calculatePartialParsingPointers(model, 3, 1);
		checkParseRegionPointers(parsingPointers, "a+b+c", "Action", "Addition");
	}
	
	public void testExpression_5_2() throws Exception {
		String model = "(a+b+c)*(c/d)";
		PartialParsingPointers parsingPointers = calculatePartialParsingPointers(model, 5, 2);
		checkParseRegionPointers(parsingPointers, "(a+b+c)", "RuleCall", "Parens");
	}
	
	public void testExpression_6_1() throws Exception {
		String model = "(a+b+c)*(c/d)";
		PartialParsingPointers parsingPointers = calculatePartialParsingPointers(model, 6, 1);
		checkParseRegionPointers(parsingPointers, "(a+b+c)", "RuleCall", "Parens");
	}
	
	public void testExpression_8_2() throws Exception {
		String model = "(a+b+c)*(c/d)";
		PartialParsingPointers parsingPointers = calculatePartialParsingPointers(model, 8, 2);
		checkParseRegionPointers(parsingPointers, "(a+b+c)*(c/d)", "ParserRule", "Sequence");
	}
	
	public void testExpression_9_2() throws Exception {
		String model = "(a+b+c)*(c/d)";
		PartialParsingPointers parsingPointers = calculatePartialParsingPointers(model, 9, 2);
		checkParseRegionPointers(parsingPointers, "c/d", "RuleCall", "Addition");
	}
	
	public void testExpression_a_b() throws Exception {
		String model = "a b";
		PartialParsingPointers parsingPointers = calculatePartialParsingPointers(model, 1, 1);
		checkParseRegionPointers(parsingPointers, "a b", "Action", "Sequence");
	}

}