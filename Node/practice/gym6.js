fs = require('fs');
const listPath = './Node/practice/members/logs/checkin.txt';

const name = '이승기';
const date = new Date();
let month = date.getMonth() + 1;
let day = date.getDate();
let hour = date.getHours();
let minute = date.getMinutes();
month = month >= 10 ? month : '0' + month;
day = day >= 10 ? day : '0' + day;
hour = hour >= 10 ? hour : '0' + hour; //hour 두자리로 출력
minute = minute >= 10 ? minute : '0' + minute; //minute 두자리로 출력
const mes = `\n${name}: 출석 완료 (${date.getFullYear()}-${month}-${day} ${hour}:${minute})`;

function enter() {
  return new Promise((resolve) => {
    fs.readFile(listPath, 'utf-8', (err, data) => {
      if (err) {
        console.error(err);
        return;
      }

      if (data.includes(name)) {
        resolve(`${name} 회원님은 이미 출석하셨습니다!`);
      } else {
        setTimeout(() => {
          fs.appendFileSync(listPath, mes);
          console.log(
            `${name}: 출석 완료 (${date.getFullYear()}-${month}-${day} ${hour}:${minute}`
          );
          resolve('출석 기록이 파일에 저장되었습니다!');
        }, 1000);
      }
    });
  });
}

async function check() {
  console.log('출석 중...');
  console.log(await enter());
}

check();
