import java.util.*;

interface Token {

}

class NumberToken implements Token {
	public int number;
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
	List<Token> expression;
	int currIndex = 0;
	public Evaluator(List<Token> expression) {
		this.expression = expression;
	}
	private double evaluateNoBracketsExpression(List<Token> tokens) {
		return null;
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