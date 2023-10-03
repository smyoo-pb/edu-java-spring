# section 9

## 학습 목표

-   Full Stack Architecture implementation
    -   Frontend
    -   Backend
    -   Database
    -   CI/CD
    -   Docker

## 학습 내용

1. Modern JavaScript
2. React 기초
3. What is Components
4. REST API
5. Routing
6. State
7. Authentication
8. Counter Example
9. Todo Management App

## Introduction

### What is Full Stack Architecture?

Web Service 구현에 대해 풀 스택 아키텍처를 말할 땐때는 주로 3가지 구성 요소(컴포넌트)를 이야기 한다.

-   front-end
    -   React Framework
-   backend REST API
    -   Spring Boot
-   database
    -   H2 > MySQL
-   authentication
    -   Spring Security (Basic > JWT)

### Why Full Stack Architecture?

-   구축 하기 여럽다
    -   여러 종류 언어로 구현
    -   다양한 종류의 프레임워크에 대한 이해도
-   Why?
    -   유연한 구조를 갖는다.
    -   확장 용이성

## Moden JavaScript

### JavaScript 역사

초기 JavaScript는 DOM객체를 다루는데 중점을 두었다.
코드 작성이 매우 어렵고 유지 보수가 어려웠다.

최근 10년동안 JavaScript는 크게 발전하여 현재 가장 유명한 프로그래밍 언어 중 하나로 자리 매김하였다.

**버전 히스토리**

-   ES5 - 2009
-   ES6 - 2015 - ES2015
    -   ES6 이후로 매년 업데이트
    -   ES6 업데이트 이후로 가장 크게 변화함.
    -   클래스 도입으로 인한 객체지향 프로그래밍 용이
    -   arrow function 도입
    -   let, const 등의 새로운 키워드 등장
    -   import/export 등의 표준 모듈 방식 추가
    -   promise 문법 등장으로 비동기 프로그래밍 개선
-   ES7 - 2016 - ES2016
-   ES8 - 2017 - ES2017
    -   async/await 문법 등장
-   ES9 - 2018 - ES2018
-   ES10 - 2019 - ES2019
-   ES11 - 2020 - ES2020
-   ES12 - 2021 - ES2021
-   ES13 - 2022 - ES2022

**ES:ECMASCRIPT**

-   ECMA Script는 표준이다.
-   JavaScript는 ECMA Script의 구현이다.

## React 기초

-   React: 가장 인기 있는 JS 라이브러리
    -   SPA(Single Page Applications)
-   Component based

### create react app

```sh
npx create-react-app todo-app --template=typescript
```

```sh
npm start # start react app

npm run build # build react app

npm test # test react app

npm install --save react-router-dom # react routing library
```

## What is Components

### React Component

-   JSX
-   TSX(For TypeScript)

```js
// class 방식
class App extends React.Component {
    render() {
        return <div>Hello, World</div>;
    }
}

// function 방식
function App() {
    return <div>Hello, World</div>;
}
```

### React Hooks

#### useState

```ts
const [count, setCount] = useState(0);

setCount(count + 1);
```

### Counter Component 만들기

-   [Counter Component 만들기](./todo-app/src/components/counter/Counter.tsx)

### Todo App Component 만들기

-   [Todo App Component 만들기](./todo-app/src/components/todo/Todo.tsx)

#### Login Component

-   login

#### Welcome Component

-   routing
