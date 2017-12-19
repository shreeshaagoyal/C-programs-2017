import java.util.*;

interface Token {

}

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
	public Evaluator() {
	}
	private double evaluateNoBracketsExpression(List<Token> tokens) {
		if (tokens.size() == 1) {
			return tokens.get(0).number;
		}

		/** CHANGE MINUS OPERATOR TO PLUS AND DIVIDE OPERATOR TO MULTIPLY */
		List<Token> changedTokens = new List<Token>();
		changedTokens = changeOperators(tokens);


		/** MULTIPLY NUMBERS TOGETHER UNTIL ONLY PLUS OPERATORS LEFT */
		List<Token> newTokens = new List<Token>();
		newTokens = multiplyTokens(changedTokens);

		/** ADD ALL NUMBERS IN ARRAY OF TOKENS */
		double result;
		int j = 1;
		for (int i = 0; i < newTokens.size(); i++) {
			
			j = j + 2;
		}

	}

	private List<Token> multiplyTokens(List<Token> tokens) {
		List<Token> newTokens = new List<Token>();
		int j = 1;
		for (int i = 0; j < tokens.size(); i++) {
			newTokens.add(tokens.get(i));
			if (tokens.get(j) == OperatorToken.OperatorType.MULTIPLY) {
				NumberToken product = new NumberToken();
				product.number = ((tokens.get(j-1)).number * tokens.get(j+1)).number;
				newTokens.add(product);
				i = j + 1;
			}
			j = j + 2;
		}

		return newTokens;
	}

	private List<Token> changeOperators(List<Token> tokens) {
		/** CHANGE MINUS OPERATOR TO PLUS AND DIVIDE OPERATOR TO MULTIPLY */
		for (int i = 1; i < tokens.size(); i=i+2) {
			if (tokens.get(i) == OperatorToken.OperatorType.MINUS) {
				OperatorToken plusOperatorToken = new OperatorToken();
				plusOperatorToken.operatorType = OperatorToken.OperatorType.PLUS;
				tokens.set(i, plusOperatorToken);
				
				NumberToken numToken = new NumberToken();
				numToken.number = subtractify(tokens.get(i+1).number);
				tokens.set(i+1, numToken);
			}

			if (tokens.get(i) == OperatorToken.OperatorType.DIVIDE) {
				OperatorToken multiplyOperatorToken = new OperatorToken();
				multiplyOperatorToken.operatorType = OperatorToken.OperatorType.MULTIPLY;
				tokens.set(i, multiplyOperatorToken);

				NumberToken numToken = new NumberToken();
				numToken.number = reciprocal(tokens.get(i+1).number);
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

	public double bracketSolver(List<Token> tokens) {
		List<Token> tempExpression = new List<Token>();
		for (; this.currIndex < tokens.size(); this.currIndex++) {

			if (tokens.get(this.currIndex) instanceof BracketToken) {
				if ((tokens.get(this.currIndex)).bracketType == BracketToken.BracketType.OPEN) {
					tempExpression.add(bracketSolver(getExpressionInBracket(tokens)));
				}
			} else {
				tempExpression.add(tokens.get(this.currIndex));
			}

		}

		return evaluateNoBracketsExpression(tempExpression);

	}

	private List<Token> getExpressionInBracket(List<Token> tokens) {
		int bracketCount = 0;
		List<Token> tempExpression = new ArrayList<Token>();
		for (; this.currIndex < tokens.size(); this.currIndex++) {
			Token currToken = tokens.get(this.currIndex);
			if (currToken instanceof Bracket) {
				if (currToken.bracketType == BracketToken.BracketType.OPEN) {
					bracketCount++;
				} else if (currToken.bracketType == BracketToken.BracketType.CLOSE) {
					bracketCount--;
				} else if (bracketCount == 0) {
					return removeEndBrackets(tempExpression);
				}
			}
			tempExpression.add(currToken);
		}
	}

	private List<Token> removeEndBrackets(List<Token> tokens) {
		tokens.remove(0);
		return tokens;
	}
}

class Main {
	public static void main(String[] args) {
		System.out.println("Hello, world!");

		Parser parser = new Parser("(32+4)-987");
		List<Token> tokens = parser.tokenize();

		Evaluator evaluator = new Evaluator();
		double result = evaluator.bracketSolver(tokens);

		assert(tokens.size() == 7);
		assert(tokens.get(0) instanceof BracketToken);
		assert(((BracketToken)(tokens.get(0))).bracketType == BracketToken.BracketType.OPEN);
		assert(tokens.get(1) instanceof NumberToken);
		assert(((NumberToken)(tokens.get(1))).number == 32);
		assert(tokens.get(2) instanceof OperatorToken);
		assert(((OperatorToken)(tokens.get(2))).operatorType == OperatorToken.OperatorType.PLUS);

		System.out.println("All tests passed!");
	}
}