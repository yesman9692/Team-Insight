

## 개요
2020년도 1학기 빅데이터캡스톤디자인 프로젝트 관리 페이지입니다.


## 팀
- 팀명 : **천리안**
- 팀원 및 역할
    - 진형석 : 프로젝트 진행 총괄 & 보고서 작성 & 서버 구축 및 관리 &  git 관리 & 기타 프로그램 작성 & 오픈소스 활용 검토
    - 양원석 : 프로젝트 전체 알고리즘 작성 & 서류작성 및 물품구매 관리 & 라즈베리 파이 및 카메라 세팅 & 영상처리 코딩(파이썬)
    - 박주승 : 안드로이드 레이아웃 초안 & 아두이노 설계 & 적외선 센터 카운터 코딩
    - 조성욱 : 소스코드 보완 & QA & 테스팅(시나리오, 성능측정)


## 주제 및 기대효과
  - 프로젝트명 : **붐비나 안붐비나 - 헛걸음 방지 앱**
  
  - 프로젝트 내용 :
  적외선/영상처리 센서로 인원수를 카운팅하고 실시간으로 앱으로 공유해서 바쁜 곳을 피해 헛걸음을 막는 앱
  식사시간의 교내/외 식당, 출퇴근시 택시/버스 정류장, 쉬는시간의 교내 편의점 및 인쇄실
  라즈베리파이 서버 - [ 아두이노(적외선센서), 라즈베리파이(영상처리센서) ]  : 다중 무선 통신, 안드로이드 앱과 연동	
  
  - 기대효과
    - 적외선 센서와 영상처리를 통하여 유동인구 및 혼잡도를 파악 할 수 있다.
    - 사람이 붐비는 바쁜 시간(식사, 출퇴근)의 인원수를 파악해 바쁜 곳을 피해 헛걸음을 막을 수 있다.
    - 시간별 유동인구 데이터를 얻고 분석해서 다양하게 응용 가능하다. (계절/기간별 방문인원 파악, 상권 분석 등)


## 개발 환경
  - APM (Apache, PHP, MariaDB)
    - Apache/2.4.38 (Raspbian)
    - PHP Version 7.3.14-1~deb10u1
      - phpMyAdmin 4.6.6deb5
    - MariaDB 10.3.22-Raspbian 10
  - Android Studio OS 6.0+
  - Raspberry Pi 4B / 3B
  - Arduino UNO R3 


## 기능 및 기술
  - 적외선 센서 출입 카운팅
  - 영상처리 센서로 인원수 파악
  - 서버 데이터 연동 분석 
  - 안드로이드 앱 


## 디렉토리 구조
```
Document        프로젝트 문서 관련 디렉토리
DB              데이터베이스 관련 디렉토리
Report          보고서 관리 디렉토리
Minutes         회의록 관리 디렉토리
etc             기타 필요한 연결 프로그램 소스코드 및 자료
img             기타 이미지 자료
```

## 전체적인 구성도

<img src="/img/전체적인_구성도.png" width="500px"  title="px(픽셀) 크기 설정" alt="RubberDuck"></img><br/>

<img src="/img/Git_branch.png" width="250px" title="px(픽셀) 크기 설정" alt="RubberDuck"></img><br/>


## 보고서 
- [프로젝트신청서](https://github.com/yesman9692/Team-Insight/blob/master/Report/%EC%BA%A1%EC%8A%A4%ED%86%A4%EB%94%94%EC%9E%90%EC%9D%B8_%EC%8B%A0%EC%B2%AD%EC%84%9C(%EC%B2%9C%EB%A6%AC%EC%95%88).hwp)
- [중간보고서](https://github.com/yesman9692/Team-Insight/blob/master/Report/%EC%BA%A1%EC%8A%A4%ED%86%A4%EB%94%94%EC%9E%90%EC%9D%B8_%EC%A4%91%EA%B0%84%EB%B3%B4%EA%B3%A0%EC%84%9C(%EC%B2%9C%EB%A6%AC%EC%95%88).hwp)
- [결과보고서(작성중)](https://github.com/yesman9692/Team-Insight/blob/master/Report/%EC%BA%A1%EC%8A%A4%ED%86%A4%EB%94%94%EC%9E%90%EC%9D%B8_%EA%B2%B0%EA%B3%BC%EB%B3%B4%EA%B3%A0%EC%84%9C(%EC%B2%9C%EB%A6%AC%EC%95%88)_%EC%9E%91%EC%84%B1%EC%A4%91.hwp)
    
    
### 회의록 
- 장소는 초반에는 화상통화, 이후부터는 스터디룸에 모여서 진행
    - [캡스톤디자인_천리안_회의록(200000)_양식](https://github.com/yesman9692/Team-Insight/blob/master/Minutes/%EC%BA%A1%EC%8A%A4%ED%86%A4%EB%94%94%EC%9E%90%EC%9D%B8_%EC%B2%9C%EB%A6%AC%EC%95%88_%ED%9A%8C%EC%9D%98%EB%A1%9D(200000)_%EC%96%91%EC%8B%9D.hwp)
    - [캡스톤디자인_천리안_회의록(200327)_처음](https://github.com/yesman9692/Team-Insight/blob/master/Minutes/%EC%BA%A1%EC%8A%A4%ED%86%A4%EB%94%94%EC%9E%90%EC%9D%B8_%EC%B2%9C%EB%A6%AC%EC%95%88_%ED%9A%8C%EC%9D%98%EB%A1%9D(200327)_%EC%B2%98%EC%9D%8C.hwp)
    - [캡스톤디자인_천리안_회의록(200328)_팀장](https://github.com/yesman9692/Team-Insight/blob/master/Minutes/%EC%BA%A1%EC%8A%A4%ED%86%A4%EB%94%94%EC%9E%90%EC%9D%B8_%EC%B2%9C%EB%A6%AC%EC%95%88_%ED%9A%8C%EC%9D%98%EB%A1%9D(200328)_%ED%8C%80%EC%9E%A5.hwp)
    - [캡스톤디자인_천리안_회의록(200330)_주제선정1](https://github.com/yesman9692/Team-Insight/blob/master/Minutes/%EC%BA%A1%EC%8A%A4%ED%86%A4%EB%94%94%EC%9E%90%EC%9D%B8_%EC%B2%9C%EB%A6%AC%EC%95%88_%ED%9A%8C%EC%9D%98%EB%A1%9D(200330)_%EC%A3%BC%EC%A0%9C%EC%84%A0%EC%A0%951.hwp)
    - [캡스톤디자인_천리안_회의록(200331)_주제선정2](https://github.com/yesman9692/Team-Insight/blob/master/Minutes/%EC%BA%A1%EC%8A%A4%ED%86%A4%EB%94%94%EC%9E%90%EC%9D%B8_%EC%B2%9C%EB%A6%AC%EC%95%88_%ED%9A%8C%EC%9D%98%EB%A1%9D(200331)_%EC%A3%BC%EC%A0%9C%EC%84%A0%EC%A0%952.hwp)
    - [캡스톤디자인_천리안_회의록(200401)_주제구체화](https://github.com/yesman9692/Team-Insight/blob/master/Minutes/%EC%BA%A1%EC%8A%A4%ED%86%A4%EB%94%94%EC%9E%90%EC%9D%B8_%EC%B2%9C%EB%A6%AC%EC%95%88_%ED%9A%8C%EC%9D%98%EB%A1%9D(200401)_%EC%A3%BC%EC%A0%9C%EA%B5%AC%EC%B2%B4%ED%99%94.hwp)
    - [캡스톤디자인_천리안_회의록(200402)_지도교수면담](https://github.com/yesman9692/Team-Insight/blob/master/Minutes/%EC%BA%A1%EC%8A%A4%ED%86%A4%EB%94%94%EC%9E%90%EC%9D%B8_%EC%B2%9C%EB%A6%AC%EC%95%88_%ED%9A%8C%EC%9D%98%EB%A1%9D(200402)_%EC%A7%80%EB%8F%84%EA%B5%90%EC%88%98%EB%A9%B4%EB%8B%B4.hwp)
    - [캡스톤디자인_천리안_회의록(200403)_신청서_작성_및_보완](https://github.com/yesman9692/Team-Insight/blob/master/Minutes/%EC%BA%A1%EC%8A%A4%ED%86%A4%EB%94%94%EC%9E%90%EC%9D%B8_%EC%B2%9C%EB%A6%AC%EC%95%88_%ED%9A%8C%EC%9D%98%EB%A1%9D(200403)_%EC%8B%A0%EC%B2%AD%EC%84%9C_%EC%9E%91%EC%84%B1_%EB%B0%8F_%EB%B3%B4%EC%99%84.hwp)
    - [캡스톤디자인_천리안_회의록(200408)_신청서_완성_및_제출](https://github.com/yesman9692/Team-Insight/blob/master/Minutes/%EC%BA%A1%EC%8A%A4%ED%86%A4%EB%94%94%EC%9E%90%EC%9D%B8_%EC%B2%9C%EB%A6%AC%EC%95%88_%ED%9A%8C%EC%9D%98%EB%A1%9D(200408)_%EC%8B%A0%EC%B2%AD%EC%84%9C_%EC%99%84%EC%84%B1_%EB%B0%8F_%EC%A0%9C%EC%B6%9C.hwp)
    - [캡스톤디자인_천리안_회의록(200409)_깃허브_연동](https://github.com/yesman9692/Team-Insight/blob/master/Minutes/%EC%BA%A1%EC%8A%A4%ED%86%A4%EB%94%94%EC%9E%90%EC%9D%B8_%EC%B2%9C%EB%A6%AC%EC%95%88_%ED%9A%8C%EC%9D%98%EB%A1%9D(200409)_%EA%B9%83%ED%97%88%EB%B8%8C_%EC%97%B0%EB%8F%99.hwp)
    - [캡스톤디자인_천리안_회의록(200413)_물품구입_적외선센서(아두이노)](https://github.com/yesman9692/Team-Insight/blob/master/Minutes/%EC%BA%A1%EC%8A%A4%ED%86%A4%EB%94%94%EC%9E%90%EC%9D%B8_%EC%B2%9C%EB%A6%AC%EC%95%88_%ED%9A%8C%EC%9D%98%EB%A1%9D(200413)_%EB%AC%BC%ED%92%88%EA%B5%AC%EC%9E%85_%EC%A0%81%EC%99%B8%EC%84%A0%EC%84%BC%EC%84%9C(%EC%95%84%EB%91%90%EC%9D%B4%EB%85%B8).hwp)
    - [캡스톤디자인_천리안_회의록(200414)_물품구입_영상처리센서(라즈파이)](https://github.com/yesman9692/Team-Insight/blob/master/Minutes/%EC%BA%A1%EC%8A%A4%ED%86%A4%EB%94%94%EC%9E%90%EC%9D%B8_%EC%B2%9C%EB%A6%AC%EC%95%88_%ED%9A%8C%EC%9D%98%EB%A1%9D(200414)_%EB%AC%BC%ED%92%88%EA%B5%AC%EC%9E%85_%EC%98%81%EC%83%81%EC%B2%98%EB%A6%AC%EC%84%BC%EC%84%9C(%EB%9D%BC%EC%A6%88%ED%8C%8C%EC%9D%B4).hwp)
    - [캡스톤디자인_천리안_회의록(200418)_물품구입_기타물품_및_예산정리](https://github.com/yesman9692/Team-Insight/blob/master/Minutes/%EC%BA%A1%EC%8A%A4%ED%86%A4%EB%94%94%EC%9E%90%EC%9D%B8_%EC%B2%9C%EB%A6%AC%EC%95%88_%ED%9A%8C%EC%9D%98%EB%A1%9D(200418)_%EB%AC%BC%ED%92%88%EA%B5%AC%EC%9E%85_%EA%B8%B0%ED%83%80%EB%AC%BC%ED%92%88_%EB%B0%8F_%EC%98%88%EC%82%B0%EC%A0%95%EB%A6%AC.hwp)
    - [캡스톤디자인_천리안_회의록(200421)_앱_UI_개발_및_토의](https://github.com/yesman9692/Team-Insight/blob/master/Minutes/%EC%BA%A1%EC%8A%A4%ED%86%A4%EB%94%94%EC%9E%90%EC%9D%B8_%EC%B2%9C%EB%A6%AC%EC%95%88_%ED%9A%8C%EC%9D%98%EB%A1%9D(200421)_%EC%95%B1_UI_%EA%B0%9C%EB%B0%9C_%EB%B0%8F_%ED%86%A0%EC%9D%98.hwp)
    - [캡스톤디자인_천리안_회의록(200423)_서버구축_APM(Apache, PHP, MariaDB)](https://github.com/yesman9692/Team-Insight/blob/master/Minutes/%EC%BA%A1%EC%8A%A4%ED%86%A4%EB%94%94%EC%9E%90%EC%9D%B8_%EC%B2%9C%EB%A6%AC%EC%95%88_%ED%9A%8C%EC%9D%98%EB%A1%9D(200423)_%EC%84%9C%EB%B2%84%EA%B5%AC%EC%B6%95_APM(Apache%2C%20PHP%2C%20MariaDB).hwp)
    - [캡스톤디자인_천리안_회의록(200424)_영상처리센서_설계_및_코딩](https://github.com/yesman9692/Team-Insight/blob/master/Minutes/%EC%BA%A1%EC%8A%A4%ED%86%A4%EB%94%94%EC%9E%90%EC%9D%B8_%EC%B2%9C%EB%A6%AC%EC%95%88_%ED%9A%8C%EC%9D%98%EB%A1%9D(200424)_%EC%98%81%EC%83%81%EC%B2%98%EB%A6%AC%EC%84%BC%EC%84%9C_%EC%84%A4%EA%B3%84_%EB%B0%8F_%EC%BD%94%EB%94%A9.hwp)
    - [캡스톤디자인_천리안_회의록(200428)_적외선센서_설계_및_코딩](https://github.com/yesman9692/Team-Insight/blob/master/Minutes/%EC%BA%A1%EC%8A%A4%ED%86%A4%EB%94%94%EC%9E%90%EC%9D%B8_%EC%B2%9C%EB%A6%AC%EC%95%88_%ED%9A%8C%EC%9D%98%EB%A1%9D(200428)_%EC%A0%81%EC%99%B8%EC%84%A0%EC%84%BC%EC%84%9C_%EC%84%A4%EA%B3%84_%EB%B0%8F_%EC%BD%94%EB%94%A9.hwp)



### 사전 지식
- 이 프로젝트를 이해 및 수정하기 위해서는 다음과 같은 이해가 있으면 도움이 될 것입니다.
  - 리눅스에 대한 지식과 이해
  - 파이썬, C언어, SQL 문법
  - 데이터베이스(DB) 기본 사용 방법
  - 서버 구축 관련 지식(APM)
  - 라즈베리파이 관련 지식
  - 아두이노 관련 지식
  - 적외선, 영상처리 등 각종 센서 지식


### 핵심 문서(작성중)
문서명 | 설명
---- | ----
[적외선 센서 코딩](https://github.com/yesman9692/Team-Insight) | 아두이노(C언어)에 적외선 카운트 코딩
[영상처리 센서 코딩](https://github.com/yesman9692/Team-Insight) | 라즈베리파이(파이썬)에 영상처리 카운트 코딩
[데이터베이스(SQL)](https://github.com/yesman9692/Team-Insight) | SQL을 정의해 놓은 문서
[테스트 상황](https://github.com/yesman9692/Team-Insight) | 이 프로젝트에서 테스트 하기 위한 상황을 가정하고 설명한 파일



### 참고 문서
문서명 | 설명
---- | ----
[MariaDB 기본 명령어](https://github.com/yesman9692/Team-Insight/blob/master/etc/DB_command.md) | 마리아 DB의 기본 명령어 및 설치법
[오픈소스 활용 가능성 검토](https://github.com/yesman9692/Team-Insight/blob/master/etc/OSS__analysis.md/) | 이 프로젝트를 위한 여러 오픈소스 비교 및 활용 가능성 검토





### 추진 계획
- 서버
  - 영상처리센서(라즈베리파이) - 서버(라즈베리파이) 간 통신
  - 적외선센서(아두이노) - 서버(라즈베리파이) 간 통신
- 안드로이드
  - 세부 디자인, 아이콘 구상 및 구현
  - 서버 데이터베이스와 통신
- 영상처리
  - 영상처리 최적화
- 적외선 센서
  - 와이파이 모듈 설치 후 서버 통신
