# 오류 처리

## 오류 코드보다 예외를 사용하라
- 오류 플래그로 제어를 하면 코드가 복잡해 지기 때문에 예외를 던지는 편이 낫다. 그러면 호출자 코드가 더 깔끔해 진다.

## Try-Catch-Finally 문부터 작성하라
- 강제로 예외를 일으키는 테스트 케이스를 작성한 후 테스트에 통과하는 코드를 작성하는 방법을 권장
  - 그러면 자연적으로 try 블록의 트랜잭션 범위부터 구현하게 되므로 범위내에서 트랜잭션 본질을 유지하기 쉬워진다.
  
## 미확인 예외를 사용하라
- 확인된 예외는 OCP를 위반한다. 상위 메소드 모두가 선언부에 그 예뢰를 정의해야 한다.
  - 결국 최상위 단게까지 연쇄적인 수정이 일어난다. (최하위 함수에서 던지는 예이를 알아야 하므로 캡슐화가 깨진다.)
  
## 예외에 의미를 제공하라
- 예외를 던질 때 전후 상황을 충분히 덧붙이면 오류가 발생한 원인과 위치를 찾기 쉬워진다.
- 호출 스팩만으로 정보가 부족하다.
  
## 호출자를 고려해 예외 클래스를 정의하라
- 외부 API를 감싸면 외부 라이브러리와 프로그램 사이에 의존성이 크게 줄어든다.
- ex) DeviceResponseException,ATM1212UnlockedException,GMXError -> PortDeviceFailure (상위 예외로 변환)

## 정상 흐름을 정의하라
- 특수 사례 패턴을 이용하면 예외적인 상황을 캡슐화해서 처리하므로 클라이언트 코드가 예외적인 상호아을 처리할 필요가 없어진다.

## null을 반환하지 마라
- null을 반환하는 코드는 오히려 호출자에게 문제를 떠넘긴다.
  - null 대신 예외를 던지거나 특수 사례 객체를 반환한다.

## null을 전달하지 마라
- 메소드에서 null을 반환하는 방식도 나쁘지만 메소드로 null을 전달하는 방식은 더 나쁘다.
- 대다수 프로그래밍 언어는 호출자가 실수로 넘기는 null을 적절히 처리하는 방법이 없다.
  - 애초에 null을 넘기지 못하도록 금지하는 정책이 함리적이다.