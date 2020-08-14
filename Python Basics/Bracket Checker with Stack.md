# Stack으로 괄호 검사하기
Stack 자료구조는 많은 곳에서 활용될 수 있지만, 가장 대표적인 활용법 중 하나가 코드에서 괄호가 잘 열리고, 잘 닫혔는지를 판단하는 것입니다. 본 자료에서는 괄호 검사 코드를 파이썬으로 Stack을 활용해 만들어보도록 하겠습니다.

## 괄호 검사기?
괄호가 적합하게 쓰여있는지를 평가하려면 우선, 적합한 괄호의 활용이 무엇인지를 따져봐야 합니다.
* `( }` 이 경우는 아주 간단한 제대로 활용되지 않은 예로, 열려있는 괄호의 종류와 다른 종류가 닫혔습니다.
* `(( )` 이 경우는 열린 괄호의 개수와 닫힌 괄호의 개수가 다른 것을 확인할 수 있습니다.
* `({ )}` 이 경우는 개수와 종류는 맞지만 그 순서가 잘못됐습니다. 마지막에 열린 괄호가 먼저 닫혀야 합니다.

세 번째 경우를 보면 마지막에 열린 괄호가 가장 먼저 닫혀야 하는 스택의 성질을 가지고 있습니다. 따라서 스택을 사용하면서 스택의 크기를 확인해주며 두 번째 경우를 해결할 수 있고, `pop` 연산에서 자료의 종류를 확인함으로써 첫 번째 경우를 확인할 수 있습니다.

## 괄호 검사기 구현해보기
파이썬과 스택을 이용해서 직접 구현해보도록 하겠습니다. 가장 기본적인 스택의 기능만을 활용하였습니다. 스택 코드의 작성 및 기능은 [파이썬으로 Stack 구현하기](https://github.com/sleepy-juan/Computing-Supplementary/blob/master/Python%20Basics/Stack%20with%20Python.md)에 설명되어 있습니다.
```python
# checkBracket: code -> true/false
# - check whether bracket is proper or not
def checkBracket(code):
	stack = Stack()
	for ch in code:
		if ch in ['(', '{', '[']:	# for open brackets
			stack.push(['(', '{', '['].index(ch)) # push the index of the bracket
```
우선 여는 괄호가 주어졌을 때는 별다른 처리 없이 스택에 넣어줍니다. 위에서 이야기한 모든 에러가 나는 경우는 닫는 괄호가 마지막 여는 괄호와 맞지 않거나, 크기가 맞지 않을 때 발생하기 때문입니다.
여는 괄호와 닫는 괄호를 쉽게 비교하기 위해 괄호 자체를 넣지 않고 괄호가 몇 번째인지를 대신 넣어주었습니다. 위 방식을 이용하면 `(`와 `)`가 모두 0, `{`와 `}`가 모두 1, `[`와 `]`가 모두 2가 되게끔 만들 수 있습니다.
```python
# checkBracket: code -> true/false
# - check whether bracket is proper or not
def checkBracket(code):
	stack = Stack()
	for ch in code:
		if ch in ['(', '{', '[']:	# for open brackets
			stack.push(['(', '{', '['].index(ch)) # push the index of the bracket
		elif ch in [')', '}', ']']:	# for close brackets
			if stack.top() == None:	# case 2: no open bracket but close bracket coming
				return False
```
가장 생각하기 쉬운 경우부터 구현해 보았습니다. 스택의 `top` 이 None이라는 뜻은 지금까지 들어왔던 여는 괄호가 없거나, 모든 괄호가 이미 닫혔다는 뜻인데 닫는 괄호가 또 들어왔습니다. 이 경우는 False를 리턴합니다.
```python
# checkBracket: code -> true/false
# - check whether bracket is proper or not
def checkBracket(code):
	stack = Stack()
	for ch in code:
		if ch in ['(', '{', '[']:	# for open brackets
			stack.push(['(', '{', '['].index(ch)) # push the index of the bracket
		elif ch in [')', '}', ']']:	# for close brackets
			if stack.top() == None:	# case 2: no open bracket but close bracket coming
				return False
			if [')', '}', ']'].index(ch) != stack.top():	# case 1,3: last open bracket doesn't match to close bracket
				return False
```
닫고자 하는 괄호가 마지막으로 열린 괄호와 다른 종류인 상황도 구현해주었습니다. 위에서 `push` 한 대로 괄호 자체가 아닌 괄호의 순서로 비교해 주었습니다.
```python
# checkBracket: code -> true/false
# - check whether bracket is proper or not
def checkBracket(code):
	stack = Stack()
	for ch in code:
		if ch in ['(', '{', '[']:	# for open brackets
			stack.push(['(', '{', '['].index(ch)) # push the index of the bracket
		elif ch in [')', '}', ']']:	# for close brackets
			if stack.top() == None:	# case 2: no open bracket but close bracket coming
				return False
			if [')', '}', ']'].index(ch) != stack.top():	# case 1,3: last open bracket doesn't match to close bracket
				return False
			else:	# or, the code is proper
				stack.pop()
```
위 경우에 모두 해당하지 않는다면 적절한 닫는 괄호가 나왔다는 뜻이니 `pop` 연산을 통해 열리 괄호를 하나 닫아줍니다.
```python
# checkBracket: code -> true/false
# - check whether bracket is proper or not
def checkBracket(code):
	stack = Stack()
	for ch in code:
		if ch in ['(', '{', '[']:	# for open brackets
			stack.push(['(', '{', '['].index(ch)) # push the index of the bracket
		elif ch in [')', '}', ']']:	# for close brackets
			if stack.top() == None:	# case 2: no open bracket but close bracket coming
				return False
			if [')', '}', ']'].index(ch) != stack.top():	# case 1,3: last open bracket doesn't match to close bracket
				return False
			else:	# or, the code is proper
				stack.pop()
	
	if stack.top() != None: # if stack is not empty at the end of checking
		return False # meaning that there's more open brackets than close brackets
	return True
```
마지막 부분이 중요합니다. 모든 닫는 괄호에 대해서 연산을 했음에도 불구하고 `top`이 None이 아니라면, 즉 스택에 여전히 열린 괄호가 있다면 여는 괄호를 닫는 괄호보다 많이 사용했다는 뜻입니다. 따라서 이 경우도 False를 리턴합니다.
나머지 모든 경우에 대해 True를 리턴하면 괄호 검사기를 완성할 수 있습니다.

### 테스트하기
역시 테스트는 중요합니다. 아래 코드를 위 괄호 검사 코드와 함께 실행시켜봅시다. 아무런 결과가 나오지 않는다면 성공적으로 스택이 작성된 것입니다!
```python
def testEqual(a, b):
	if a != b:
		print("Result must be " + str(a) + " but given " + str(b))

def testStack():
	testEqual(True, checkBracket('')) # test empty string
	testEqual(True, checkBracket('({[]})')) # test proper string
	testEqual(True, checkBracket('({}[]{()})')) # test proper complicated string
	testEqual(False, checkBracket('{]')) # test wrong string, case 1
	testEqual(False, checkBracket('(()')) # test wrong string, case 2
	testEqual(False, checkBracket('{}}')) # test wrong string, case 2
	testEqual(False, checkBracket('({)}')) # test wrong string, case 3
```

## 정리하기
이번 자료에서는 Stack 자료구조를 이용해 괄호 검사기를 만들어 보았습니다. 괄호 검사는 Stack을 활용한 응용 예 중 가장 대표적인 예시입니다. Stack이 활용된 방식을 다시 살펴봅시다.

### 결과 코드
```python
# checkBracket: code -> true/false
# - check whether bracket is proper or not
def checkBracket(code):
	stack = Stack()
	for ch in code:
		if ch in ['(', '{', '[']:	# for open brackets
			stack.push(['(', '{', '['].index(ch)) # push the index of the bracket
		elif ch in [')', '}', ']']:	# for close brackets
			if stack.top() == None:	# case 2: no open bracket but close bracket coming
				return False
			if [')', '}', ']'].index(ch) != stack.top():	# case 1,3: last open bracket doesn't match to close bracket
				return False
			else:	# or, the code is proper
				stack.pop()
	
	if stack.top() != None: # if stack is not empty at the end of checking
		return False # meaning that there's more open brackets than close brackets
	return True
```

## 크레딧
| 작성자 | 이주안 |
| ------------ | ------------ |
| 약력 | KAIST 전산학부 |
| 질문 및 피드백 | juanlee@kaist.ac.kr |
| 마지막 수정일 | 2020.08.14 |
