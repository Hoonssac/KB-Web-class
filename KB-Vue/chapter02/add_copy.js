import _ from 'lodash';

const teacher = {
  name: 'yura',
  age: 20,
  emails: ['yura@gmail.com'],
};

// const copyT = teacher; => 주소값이 복사돼서 같이 변경됨!
// 해결방법 1. Object.assign 이용해서 target 객체에 출처 객체를 복사
// const copyT = Object.assign({}, teacher);
// 해결방법 2. 전개 연산자 이용해서 객체 생성
// => 참조형 데이터를 가지고 있을 때 한계 (얕은 복사)
// const copyT = { ...teacher };
// 깊은 복사까지 하기 위한 lodash 사용법
const copyT = _.cloneDeep(teacher);
console.log(copyT === teacher);

teacher.age = 21;
console.log(teacher);
console.log(copyT);

teacher.emails.push('yura2@gmail.com');
console.log(teacher.emails === copyT.emails);
console.log(teacher);
console.log(copyT);
