let obj = { name: '홍길동', age: 20 };
const proxy = new Proxy(obj, {
  get: function (target, key) {
    console.log('## get ' + key);
    // 해당 키에 존재하는 데이터가 없으면 에러 발생시킴
    if (!target[key]) throw new Error(`존재하지 않는 속성(${key})입니다`);
    return target[key];
  },
  set: function (target, key, value) {
    console.log('## set ' + key);
    if (!target[key]) throw new Error(`존재하지 않는 속성(${key})입니다`);
    target[key] = value;
    return true;
  },
});

// 값을 가져오므로 get 호출
console.log(proxy.name);

// 값을 설정하므로 set 호출
proxy.name = `이몽룡`;
proxy.age = 30;

console.log(proxy);
