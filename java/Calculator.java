import java.util.*;

interface Token {}

class NumberToken implements Token {
	public double number;
}

class OperatorToken implements Token {
	public enum OperatorType {
		PLUS,
		MINUS,
		MULTIPLY,
		DIVIDE
	}

	public OperatorType operatorType;
}

class BracketToken implements Token {
	public enum BracketType {
		OPEN,
		CLOSE
	}

	public BracketType bracketType;
}

class Parser {
	String expression;
	int currIndex = 0;

	public Parser(String expression) {
		this.expression = expression;
	}

	public List<Token> tokenize() {
		List<Token> tokens = new ArrayList<Token>();

		Token token = getNextToken();
		while (token != null) {
			tokens.add(token);
			token = getNextToken();
		}

		return tokens;
	}

	private Token getNextToken() {
		if (this.currIndex == this.expression.length()) {
			return null;
		}

		char c = this.expression.charAt(this.currIndex);

		// Number
		if ((c >= '0') && (c <= '9')) {
			return getNumberToken();
		}

		Token token;

		// Operator
		if (c == '+') {
			OperatorToken opToken = new OperatorToken();
			opToken.operatorType = OperatorToken.OperatorType.PLUS;
			token = opToken;
		}
		else if (c == '-') {
			OperatorToken opToken = new OperatorToken();
			opToken.operatorType = OperatorToken.OperatorType.MINUS;
			token = opToken;
		}
		else if (c == '*') {
			OperatorToken opToken = new OperatorToken();
			opToken.operatorType = OperatorToken.OperatorType.MULTIPLY;
			token = opToken;
		}
		else if (c == '/') {
			OperatorToken opToken = new OperatorToken();
			opToken.operatorType = OperatorToken.OperatorType.DIVIDE;
			token = opToken;
		}

		// Bracket
		else if (c == '(') {
			BracketToken bracketToken = new BracketToken();
			bracketToken.bracketType = BracketToken.BracketType.OPEN;
			token = bracketToken;
		}
		else if (c == ')') {
			BracketToken bracketToken = new BracketToken();
			bracketToken.bracketType = BracketToken.BracketType.CLOSE;
			token = bracketToken;
		}

		// Invalid operator
		else {
			throw new IllegalArgumentException("Character not a valid input");
		}

		// Applied to operator tokens and bracket tokens only:
		this.currIndex++;

		return token;
	}

	private NumberToken getNumberToken() {
		NumberToken num = new NumberToken();
		int resultNum = 0;

		for (; this.currIndex < this.expression.length(); this.currIndex++) {
			char c = this.expression.charAt(this.currIndex);
			
			if ((c >= '0') && (c <= '9')) {
				resultNum = (c - '0') + (10 * resultNum);
			} else {
				break;
			}
		}

		num.number = resultNum;
		return num;
	}
}

class Evaluator {
	int currIndex = 0;
	int referenceValue = 0;
	public Evaluator() {
	}
	private Token evaluateNoBracketsExpression(List<Token> tokens) {
		if (tokens.size() == 1) {
			return tokens.get(0);
		}

		/** CHANGE MINUS OPERATOR TO PLUS AND DIVIDE OPERATOR TO MULTIPLY */
		List<Token> changedTokens = new ArrayList<Token>();
		changedTokens = changeOperators(tokens);


		/** MULTIPLY NUMBERS TOGETHER UNTIL ONLY PLUS OPERATORS LEFT */
		List<Token> newTokens = new ArrayList<Token>();
		newTokens = multiplyTokens(changedTokens);

		/** ADD ALL NUMBERS IN ARRAY OF TOKENS */
		return addAllTokens(newTokens);

	}

	private Token addAllTokens(List<Token> tokens) {
		double result = 0;
		for (int i = 0; i < tokens.size(); i++) {
			result += ((NumberToken) tokens.get(i)).number;
		}
		NumberToken sum = new NumberToken();
		sum.number = result;
		return sum;
	}

	private List<Token> multiplyTokens(List<Token> tokens) {
		int printCursor = 0;
		int operatorCursor = 1;
		List<Token> toBeAdded = new ArrayList<Token>();
		for (; printCursor < tokens.size(); printCursor += 2) {
			if (operatorCursor == tokens.size()) {
				toBeAdded.add(tokens.get(printCursor));
				return toBeAdded;
			}
			if (((OperatorToken) tokens.get(operatorCursor)).operatorType != OperatorToken.OperatorType.MULTIPLY) {
				toBeAdded.add(tokens.get(printCursor));
			} else if (((OperatorToken) tokens.get(operatorCursor)).operatorType == OperatorToken.OperatorType.MULTIPLY) {
				List<Token> toBeMultiplied = new ArrayList<Token>();
				for (; operatorCursor <= tokens.size(); operatorCursor += 2) {
					if (operatorCursor == tokens.size()) {
						toBeMultiplied.add(tokens.get(printCursor));
						break;
					}
					if (((OperatorToken) tokens.get(operatorCursor)).operatorType == OperatorToken.OperatorType.MULTIPLY) {
						toBeMultiplied.add(tokens.get(printCursor));
					} else {
						toBeMultiplied.add(tokens.get(printCursor));
						break;
					}
					printCursor += 2;
				}
				Token result = multiplyAllTokens(toBeMultiplied);
				toBeAdded.add(result);
			}
			operatorCursor += 2;
		}
		return toBeAdded;
	}

	private Token multiplyAllTokens(List<Token> toBeMultiplied) {
		int product = 1;
		for (int i = 0; i < toBeMultiplied.size(); i++) {
			product *= ((NumberToken) toBeMultiplied.get(i)).number;
		}
		NumberToken result = new NumberToken();
		result.number = product;
		return result;
	}

	private List<Token> changeOperators(List<Token> tokens) {
		/** CHANGE MINUS OPERATOR TO PLUS AND DIVIDE OPERATOR TO MULTIPLY */
		for (int i = 1; i < tokens.size(); i=i+2) {
			if (((OperatorToken) tokens.get(i)).operatorType == OperatorToken.OperatorType.MINUS) {
				OperatorToken plusOperatorToken = new OperatorToken();
				plusOperatorToken.operatorType = OperatorToken.OperatorType.PLUS;
				tokens.set(i, plusOperatorToken);
				
				NumberToken numToken = new NumberToken();
				numToken.number = subtractify(((NumberToken) tokens.get(i+1)).number);
				tokens.set(i+1, numToken);
			}

			if (((OperatorToken) tokens.get(i)).operatorType == OperatorToken.OperatorType.DIVIDE) {
				OperatorToken multiplyOperatorToken = new OperatorToken();
				multiplyOperatorToken.operatorType = OperatorToken.OperatorType.MULTIPLY;
				tokens.set(i, multiplyOperatorToken);

				NumberToken numToken = new NumberToken();
				numToken.number = reciprocal(((NumberToken) tokens.get(i+1)).number);
				tokens.set(i+1, numToken);
			}
		}

		return tokens;
	}

	private double reciprocal(double num) {
		return 1/num;
	}

	private double subtractify(double num) {
		return ((-1) * num);
	}

	public Token bracketSolver(List<Token> tokens) {
		List<Token> result = new ArrayList<Token>();


		for (int i = 0; i < tokens.size(); i++) {
			Token currToken = tokens.get(i);
			if (currToken instanceof BracketToken) {
				if (((BracketToken) currToken).bracketType == BracketToken.BracketType.OPEN) {
					List<Token> expressionInBrackets = getExpressionInBrackets(tokens, i);
					i = getBracketEndPosition(tokens, i);
					Token solvedBracketsExpression = bracketSolver(expressionInBrackets);
					result.add(solvedBracketsExpression);
				}
			} else {
				result.add(currToken);
			}
		}

		// base case
		/** RETURNS RESULT OF EXPRESSION WITH NO BRACKETS */
		return evaluateNoBracketsExpression(result);

	}

	private int getBracketEndPosition(List<Token> tokens, int index) {
		int bracketCount = 1;
		for (int i = index + 1; i < tokens.size(); i++) {
			Token currToken = tokens.get(i);
			if (currToken instanceof BracketToken) {
				if (((BracketToken) currToken).bracketType == BracketToken.BracketType.OPEN) {
					bracketCount++;
				} else if (((BracketToken) currToken).bracketType == BracketToken.BracketType.CLOSE) {
					bracketCount--;
					if (bracketCount == 0) {
						return i;
					}
				}
			}
		}
		return 0;
	}

	private List<Token> getExpressionInBrackets(List<Token> tokens, int index) {
		int bracketCount = 1;
		List<Token> result = new ArrayList<Token>();
		for (int i = index + 1; i < tokens.size(); i++) {
			Token currToken = tokens.get(i);
			if (currToken instanceof BracketToken) {
				if (((BracketToken) currToken).bracketType == BracketToken.BracketType.OPEN) {
					bracketCount++;
				} else if (((BracketToken) currToken).bracketType == BracketToken.BracketType.CLOSE) {
					bracketCount--;
				}
			}

			result.add(currToken);

			if (bracketCount == 0) {
				result = popLastItem(result);
				return result;
			}
		}
		return result;
	}

	private List<Token> popLastItem(List<Token> tokens) {
		tokens.remove(tokens.size() - 1);
		return tokens;
	}

}

class Calculator {
	public static void main(String[] args) {
		System.out.println("Hello, world!");

		Parser parser = new Parser("(77.27+97.14+91.43+91.43+91.18+117.14+100+80+100)/9");
		List<Token> tokens = parser.tokenize();

		Evaluator evaluator = new Evaluator();
		Token result = evaluator.bracketSolver(tokens);

		assert(tokens.size() == 7);
		assert(tokens.get(0) instanceof BracketToken);
		assert(((BracketToken)(tokens.get(0))).bracketType == BracketToken.BracketType.OPEN);
		assert(tokens.get(1) instanceof NumberToken);
		assert(((NumberToken)(tokens.get(1))).number == 32);
		assert(tokens.get(2) instanceof OperatorToken);
		assert(((OperatorToken)(tokens.get(2))).operatorType == OperatorToken.OperatorType.PLUS);

		System.out.println("All tests passed!");

		System.out.println("result = " + (((NumberToken) result).number));
	}
}