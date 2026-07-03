# 단어 정렬

**출처**: 백준 1181
**유형**: 정렬 / Comparator
**제한**: 시간 2초 | 메모리 256MB | N ≤ 20,000

## 문제

N개의 단어가 주어졌을 때, 아래 조건으로 정렬해서 출력하세요.

1. 길이가 짧은 단어 먼저
2. 길이가 같으면 사전순
3. **중복 제거** (같은 단어는 한 번만 출력)

## 입력

첫째 줄에 N, 이후 N줄에 단어가 하나씩 주어진다.

## 출력

조건에 맞게 정렬해서 출력.

## 예제 1

**입력**
```
13
but
i
wont
hesitate
no
more
no
more
it
cannot
wait
im
yours
```
**출력**
```
i
im
it
no
but
more
wait
wont
yours
cannot
hesitate
```