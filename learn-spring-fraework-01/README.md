# section 2

java spring 학습

## contents

-   강한 결합 vs 느슨한 결합
-   의존성 주입
-   제어의 역전

### 강한 결합

[example](./src/main/java/com/precisionbio/learnspringframework/game/tightcoupling/AppGamingBasic.java)

-   실생활 예시
    -   자동차와 엔진 > 바꾸기 어렵고 교체 시 비용이 많이 발생

### 느슨한 결합

[example](./src/main/java/com/precisionbio/learnspringframework/game/looselycoupling/AppGamingBasic.java)

-   실생활 예시
    -   자동차와 타이어 > 바꾸기 쉽고 비용이 적음

#### 결론

-   변하지 않는 것은 "변화" 뿐이다.
-   가능한 한 느슨한 결합을 유지하도록 노력해야한다.
    -   가능한 한 기존 코드를 적게 수정하는 방향으로 개발 해야한다.
