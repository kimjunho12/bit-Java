___
## EL
_Expression Language_
특정 스코프 영역에 보관되어 있는 객체를 추출하여 이 객체의 값 또는 속성 **값을 추출**하여 표현
- `$`와 `{ }`으로 구현
- 관련된 연산자와 **EL 만의 내장 객체**를 사용
- Query 문자열을 추출하여 표현하는 경우 간단하게 구현 가능

### EL의 내장 객체
- pageContext : pageContext 객체 (JSP/EL의 공통 내장 객체)
- <span style="color:blue"> pageScope : page scope에 포함된 객체들</span>
- <span style="color:blue"> requestScope : request scope에 포함된 객체들</span>
- <span style="color:blue"> sessionScope : session scope에 포함된 객체들</span>
- <span style="color:blue"> applicationScope : application 스코프에 포함된 객체들</span>
- <span style="color:blue"> param : HTTP의 파라메터들</span>
- paramValues : 한 파라메터의 값들
- header : 헤더 정보
- headerValues : 한 헤더의 값들
- cookie : 쿠키들
- initParam : 컨텍스트의 초기화 파라미터

### 객체의 호출

- HttpSession 객체에 cart 라는 명칭으로 저장된 객체의 getApple() 을 호출<br>
`${ sessionScope.cart.apple } 또는 ${ cart.apple }`
- EL 에서의 . 연산자
<span style="color: blue;">_변수명.xxx_</span><br>
Ⅰ. 일반 Java 객체이면 getXxx()의 호출 결과와 동일<br>
Ⅱ. Map 객체이면 get("xxx")을 호출한 결과와 동일<br>

<br>

>       1. scope(범위)
>       객체가 존재하는 범위
>       
>       2. 객체가 오래 지속되는 순서
>       Application(Context) Scope > Session Scope > Request Scope > Page Context
>       
>       3. EL이 이름으로 객체를 찾는 순서
>       Application(Context) Scope < Session Scope < Request Scope < Page Context
>       
>       ❗ 주의 : 같은 이름으로 여러 범위에 객체를 저장할 경우, 주의 필요


### EL의 연산자
- ❕ 문자열 결합 : += (문자, 숫자 상관없이 문자처럼 이어 붙임)<br>
`${"EL" += 12 += 34 += "-문자열 결합연산" } : EL1234-문자열 결합연산`

### EL 변수
pageContext의 Attribute (JSP내에서만 사용가능한 pageScope 객체)


> - ${header.xxx} : 헤더 중 xxx에 담긴 값 추출
> - ${param.xxx} : query 파라미터 중 name이 xxx인 값 추출
> - ${oooScope.xxx} : oooScope에 담긴 값중 키가 xxx인 값 추출
> - ${xxx} : 변수가 xxx인 값 추출

## JSTL
_JSP Standard Tag Library_
JSP에서 사용 가능한 표준 태그 라이브러리

### JSTL 라이브러리
- 기본기능 (core) `<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>`
- 형식화 (format) `<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>`
- 데이터베이스 (sql)
- XML 처리 (xml)
- 함수처리 (function) `<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>`
