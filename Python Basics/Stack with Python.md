# 파이썬으로 Stack 구현하기
이번 자료에서는 파이썬으로 가장 기본적인 자료 구조 중 하나인 Stack을 구현해보도록 하겠습니다. 

## Stack이란?
Stack은 가장 기본적인 자료구조 중 하나로써, 마치 책상 위에 접시를 쌓는 형태가 특징입니다. 책상 위에 쌓인 접시를 생각하면, 접시를 쌓은 후 하나씩 사용할 때 마지막에 넣은 접시부터 사용할 수 있는 것을 알 수 있습니다. Stack도 이렇게 제일 마지막에 들어간 것이 제일 먼저 사용되는(Last In First Out, LIFO) 구조를 가진 자료구조입니다.

### Stack은 어디에 사용될까요?
LIFO 구조를 사용하는 대부분의 곳에 활용될 수 있습니다. 
* 실행취소 기능과 같이 취소를 누르면 거꾸로 되돌아가며 기능을 실행해야 할 때 유리합니다. 지금까지 실행했던 명령어들을 Stack에 일렬로 넣어둔 후 반대로 꺼내는 동작을 통해 실행 취소를 구현합니다.
* 시스템에서 함수의 호출 등, 마지막에 호출된 함수가 제일 먼저 결과물을 만들어내야 하는 상황에서 스택 구조가 사용됩니다.
* 코드 상에서 괄호가 문법에 맞는지 등을 판단할때, 열리는 괄호( `(, {, [` ) 를 순차적으로 넣고 닫히는 괄호 ( `),},]` ) 가 나올 때 대응되는 괄호를 순차적으로 빼는 방식으로 문법 적합성을 판단할 수 있습니다.

## Stack 구현해보기
파이썬을 이용해 스택을 구현해보도록 하겠습니다. 본 자료에서는 스택의 부가적인 기능은 제외한 채 `push`, `pop`, `top` 만을 구현합니다.
```python
class Stack:
	def __init__(self):
		self.stack = [] # create empty list to put elements
		self.size = 0 # the number of elements
```
시작은 클래스와 자료를 넣을 빈 리스트 `stack` 를 만드는 것으로 시작합니다. 스택에 넣은 데이터의 개수를 저장할 `size` 변수도 같이 만들어서 0으로 초기화를 해주었습니다.
```python
class Stack:
	def __init__(self):
		self.stack = [] # create empty list to put elements
		self.size = 0 # the number of elements
	
	# push: element -> void
	# - push given element e to the stack
	def push(self, e):
		self.stack.append(e) # put element at the end of the list
		self.size += 1 # increase size
```
`push` 연산은 `stack` 변수에 자료를 집어 넣고, `size` 값을 하나 늘리는 방식으로 간단하게 구현할 수 있습니다.
```python
class Stack:
	def __init__(self):
		self.stack = [] # create empty list to put elements
		self.size = 0 # the number of elements
	
	# push: element -> void
	# - push given element e to the stack
	def push(self, e):
		self.stack.append(e) # put element at the end of the list
		self.size += 1 # increase size
	
	# pop: void -> element
	# - pop the element from the stack
	# - if the stack is empty, return null
	def pop(self):
		if self.size == 0:
			return null
		self.size -= 1
		return self.stack.pop()
```
`pop` 연산은 `size` 변수의 값을 하나 줄이고 `stack` 리스트의 마지막 값을 리턴하는 방식으로 간단하게 구현할 수 있습니다. 주의할 점은 스택이 비어있을 때, 즉 스택의 크기가 0일 때는 별도로 에러를 처리해주어야 합니다. 위 코드에서는 null을 리턴해주었습니다.
```python
class Stack:
	def __init__(self):
		self.stack = [] # create empty list to put elements
		self.size = 0 # the number of elements
	
	# push: element -> void
	# - push given element e to the stack
	def push(self, e):
		self.stack.append(e) # put element at the end of the list
		self.size += 1 # increase size
	
	# pop: void -> element
	# - pop the element from the stack
	# - if the stack is empty, return null
	def pop(self):
		if self.size == 0:
			return null
		self.size -= 1
		return self.stack.pop()
		
	#top: void -> element
	# - return the last element from the stack
	# - if the stack is empty, return null
	def top(self):
		if self.size == 0:
			return null
		return self.stack[len(self.stack)-1]
```
`top` 연산은 `stack` 리스트의 마지막 값을 크기의 조정 없이 리턴하며 구현할 수 있습니다. 주의할 점은 이때 자료를 삭제하지 않도록 주의해야 한다는 점이며, `pop` 과 마찬가지로 스택의 크기가 0일 때 에러 처리를 해주어야 한다는 점입니다.
이것으로 스택이 완성되었습니다.
### 테스트하기
코드를 작성할 때는 코드만큼이나 코드를 테스트하는 과정도 중요합니다. 테스트 코드는 상상할 수 있는 범위 모두에서 실제 작성된 코드를 고려하지 않고 작동 방식만 놓고 평가해야 합니다.
아래 코드를 위 스택 클래스와 함께 실행시켜봅시다. 아무런 결과가 나오지 않는다면 성공적으로 스택이 작성된 것입니다!
```python
def testEqual(a, b):
	if a != b:
		print("Result must be " + str(a) + " but given " + str(b))

def testStack():
	stack = Stack()
	stack.push(3)
	stack.push(2)
	stack.push(1)
	testEqual(1, stack.pop()) # test pop
	testEqual(2, stack.top()) # test top
	testEqual(2, stack.pop()) # test pop after top
	testEqual(3, stack.pop()) # test pop
	testEqual(null, stack.pop()) # test pop if empty
	testEqual(null, stack.top()) # test top if empty
```

## 정리하기
이번 자료에서는 파이썬으로 간단한 자료구조인 Stack을 구현해보았습니다. Stack은 간단한만큼 응용되어 활용되기 쉬운 자료구조이기도 합니다. 

### 결과 코드
```python
class Stack:
	def __init__(self):
		self.stack = [] # create empty list to put elements
		self.size = 0 # the number of elements
	
	# push: element -> void
	# - push given element e to the stack
	def push(self, e):
		self.stack.append(e) # put element at the end of the list
		self.size += 1 # increase size
	
	# pop: void -> element
	# - pop the element from the stack
	# - if the stack is empty, return null
	def pop(self):
		if self.size == 0:
			return null
		self.size -= 1
		return self.stack.pop()
		
	#top: void -> element
	# - return the last element from the stack
	# - if the stack is empty, return null
	def top(self):
		if self.size == 0:
			return null
		return self.stack[len(self.stack)-1]
```

## 크레딧
| 작성자 | 이주안 |
| ------------ | ------------ |
| 약력 | KAIST 전산학부 |
| 질문 및 피드백 | juanlee@kaist.ac.kr |
| 마지막 수정일 | 2020.08.14 |
