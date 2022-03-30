___
## Immutability
_컴포넌트 상태의 불변성_

### Basic Principles:
1. 절대로 컴포넌트의 상태를 직접 조작 금지
2. 컴포넌트 상태를 불변으로 다루어라
3. setState나 useState에서 반환해주는 함수를 사용해서 상태를 조작

> ### Violation Example : Class Component
> ```javascript
> this.state.emails = [{}, {}, {}];
> let emails = this.state.emails;
> emails.push({});
> ```

### 상태를 불변성으로 유지 해야하는 이유
1. this.state를 직접 조작하는 것은 React 상태 관리를 우회하는 행위 (React Programming 모델에 반하는 것) -> Against the React paradigm and Potentially Dangerous
2. 이 후, setState() 호출은 this.state를 직접 조작한 내용을 무효화 한다.
3. 성능 개선의 여지가 없어진다  
   - 객체 변경 유무 검사 시 객체의 동**질**성 비교는 고비용
   - 객체 변경 유무 검사 시 객체의 동**일**성 비교는 저비용 (object1 === object2)
4. 결론은 변경하지 말고 대체! : 불변성의 주개념
5. Functional JavaScript 에서는 4번이 표준이 아니다(가능하지만) 따라서 의도치 않게 변경할 가능성이 있다 -> 이를 주의해야 한다.

### How I :
1. 비파괴 배열 메소드 및 연산자 : map, filter, reduce, concat, ...(ES6 spread 연산자 활용)
2. [src/01](./01.js) 참고

### How II:
1. Object.assign 을 이용해 변경이 적용된 객체를 새로 생성하는 방법
2. [src/02](./02.js) 참고

### How III:
1. I, II는 Nest Object 가 있는 경우 까다롭다.
   - Object.assign은 deep copy 지원 안함.
   - deep clone을 뜨는 방법은 비용이 비싸다.
   - 직접 하는 방법은 관리가 어렵고 코드에 실수가 있을 가능 성 많음.
2. 이는 자바스크립트가 원래 저 따위이기 때문에 어쩔 수 없다.
3. [src/03](./03.js) 참고

### How IV:
1. React Addon에 복잡하고 중첩된 객체의 변경을 도와주는 immutablity helper 함수를 사용하는 것이다.
2. add-on 설치
```shell
$ npm i react-addons-update
```

3. 적용
```javascript
import update from 'react-addons-update';

const newObject = update(objectInState, { [WHERE] : { [WHAT]: updateValue } });
```

4. 업데이트 형식
   - 속성 변경       $set
   - 배열 요소 추가   $push
   - 배열 요소 변경   $set

5. WHAT 명령
   - $push      *
   - $splice
   - $unsift
   - $set       *
   - $merge
   - $apply

6. [src/04](./04.js) 참고