## 의존성 주입 (DI)란?

### 의존성이란?

```
class Doraemon { 
	private Pocket pocket; 
	public Doraemon() { 
	this.pocket = new Pocket(); 
	} 
	public startDoremon() { 
	this.pocket.searchPocket(); 
	} 
}
```

Doraemon 클래스의 startDoramon 함수의 호출을 위해서는 Pocket 클래스가 필수적이다. 이런 상황에서, Doraemon 클래스 Pocket 클래스의 의존성을 가진다.

의존성이 생길 경우, 코드의 재활용성이 떨어지고, Pocket 클래스가 수정될 경우, Programmer 클래스도 함께 수정되어야 하므로, 결합도 (coupling)이 높아진다.



### 의존성을 주입해야하는 이유

+ 코드의 가독성을 높여준다.

+ Unit Test 가 쉬워진다.

+ 코드의 재활용성을 높인다.

+ 객체 간의 의존성(종속성)을 직접 설정하여 줄이거나 없앨 수 있다.

+ 객체 간의 결합도를 낮추면서 유연하게 만들 수 있다.



### 안드로이드에서의 DI 방법

안드로이드에서는 두가지 방식의 의존성 주입이 가능하다.

- 생성자 주입 (Constructor Injection) : 생성자를 통해 의존하는 객체 전달
  - 위의 예시의 방법이 생성자 주입에 해당한다.
- 필드 주입 (Field Injection) : 객체가 초기화된 후에 의존하는 객체 전달

직접 코드로 구현하는 것도 가능하지만, 라이브러리들을 사용하여 쉽게 구현 가능하다.

+ Koin, Dagger2, Dagger - Hilt 등..

