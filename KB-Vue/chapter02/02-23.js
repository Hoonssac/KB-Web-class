let obj1 = { name: '박문수', age: 29 };
let obj2 = obj1; // 주소값까지 복사된다.
let obj3 = { ...obj1 }; /// obj1의 값만 복사해서 새로운 객체 생성
let obj4 = { ...obj1, email: 'mspark@gmail.com' }; // 새로운 속성 추가

obj2.age = 19;
console.log(obj1); // 같은 주소를 참조하기 때문에 obj2와 동일하게 변경
console.log(obj2);
console.log(obj3);
console.log(obj1 == obj2);
console.log(obj1 == obj3);

let arr1 = [100, 200, 300];
// arr1 배열의 원소를 풀어서 삽입
let arr2 = ['hello', ...arr1, 'world'];
console.log(arr1);
console.log(arr2);
