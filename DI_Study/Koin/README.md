### Koin 을 활용한 의존성 주입

#### Koin 설치

jcenter 레포지토리가 등록되어있는지 확인하고 koin_version 변수를 원하는 버전으로 선언한다.

```
buildscript {
    ext.koin_version = '버전 코드'
    repositories {
        jcenter()
    }
}

...

//build.gradle 파일
dependencies {
    implementation "org.koin:koin-androidx-viewmodel:$koin_version"
    testImplementation "org.koin:koin-test:$koin_version"
}
```

#### Module 선언

+ Repository 클래스와 이 클래스 객체를 파라미터로 받는 Controller, ViewModel 클래스를 만든다.
+ module 키워드로 주입 받을 객체를 모듈로 만들어 선언
+ 생성한 모듈을 App 클래스의 onCreate LifeCycle 에서 startKoin을 호출하여 넘겨준다.
  + App 클래스를 새로 생성한 경우 manifest.xml 에 등록한다+ 

+ 키워드

  + single : 앱이 실행되는 동안 계속 유지되는 싱글톤 객체를 생성

  + factory : 요청할때마다 매번 새로운 객체를 생성

  + get() : 컴포넌트 내에서 이미 생성된 의존성을 주입 받을 수 있음

    - 이미 생성된 객체 중 해당 타입에 알맞는 객체를 Koin 이 주입해준다.

  + androidLogger : AndroidLogger를 Koin Logger로 사용한다.

  + androidContext : 해당 안드로이드의 application Context를 사용한다

  + modules : 사용할 모듈을 등록한다.

    

### 의존성 주입 받기

위의 과정에서 등록한 모듈을 주입 받아 사용할 수 있다.

+ by inject()로 lazy하게 controller를 주입 받을 수 있다.

+ viewModel 키워드로 모듈을 등록하면, 일반적인 클래스들과는 달리, Koin이 해당 ViewModel을 ViewModelFactory에 등록하고 현재 컴포넌트와 바인딩하여, 주입받을 때도 ViewModelFactory에서 해당 ViewModel 객체를 불러온다.
  +  get()키워드를 이용하면 non-lazy하게 주입받을 수 있다.
  +  getViewModel() 키워드를 이용하면 non-lazy하게 주입받을 수 있다.

+ 키워드 :
  +  Lazy : 프로그램의 퍼포먼스를 높이기 위해 처음부터 초기화하는 것이 아니라 필요한 순간까지 최대한 초기화를 지연시킨다는 것을 의미한다.
    +  실행 시간 및 메로리 효율을 개선할 수 있다.

```
//by inject class DoraemonActivity : AppCompatActivity() { 
	val controller : DoremonController by inject() ... 
} 

//viewModel에서의 injection 

val viewModel : DoremonViewModel by viewModel() 

//단, viewModel의 경우, get을 이용해서 non-lazy하게 의존성을 주입할 수 있다. 
//DoraemonViewModel에서 Repo를 주입받는다고 할 때 
//Module 선언 

val viewModelModule = module {
	viewModel {DoremonViewModel(get())} 
} 

//viewmodel 

class DoraemonViewModel : ViewModel(val repo : DoraemonRepository) {
	... 
} //위와 같이도 사용할 수 있다.
```



참고: https://yejinson97gaegul.tistory.com/93 [코딩하는 개굴이]

참고: https://spoqa.github.io/2020/11/02/android-dependency-injection-with-koin.html [spoqa]