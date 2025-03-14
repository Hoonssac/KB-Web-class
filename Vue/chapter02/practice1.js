let pets = {};

// 날짜를 두 자리 수 형식으로 변환하는 헬퍼 함수
function formatDate(date) {
  const year = date.getFullYear();
  // 월과 일을 두 자리 수로 포맷팅 (1 -> 01, 10 -> 10)
  const month = String(date.getMonth() + 1).padStart(2, '0');
  const day = String(date.getDate()).padStart(2, '0');
  return `${year}-${month}-${day}`;
}

class Pet {
  constructor(name, spacies, vaccinations, healthCheckDate, alreadyWarned) {
    this.name = name;
    this.spacies = spacies;
    this.vaccinations = vaccinations || [];
    this.healthCheckDate = healthCheckDate;
    this.alreadyWarned = alreadyWarned;
  }

  addVaccination(vaccine) {
    if (!this.vaccinations.includes(vaccine)) {
      this.vaccinations.push(vaccine);
      console.log(`[예방접종 추가] ${this.name}: ${vaccine}`);
    } else {
      console.log(
        `[예방접종 중복] ${this.name}: ${vaccine}은 이미 등록되어 있습니다.`
      );
    }
  }

  updateHealthCheckDate(newDate) {
    this.healthCheckDate = newDate;
    this.alreadyWarned = false;
    console.log(`[건강검진 업데이트] ${this.name}: ${formatDate(newDate)}`);
  }
}

class PetHealthManager {
  constructor() {
    this.healCheckInterval = null;
    this.checkTimeout = null;
  }

  registerPet(pet) {
    console.log(
      `[등록] ${pet.spacies} - ${pet.name} (예방접종: ${
        pet.vaccinations
      }, 건강검진: ${formatDate(pet.healthCheckDate)})`
    );
    pets[pet.name] = pet;
  }

  checkHealthStatus() {
    // 이미 실행 중인 인터벌이 있으면 중지
    if (this.healCheckInterval) {
      clearInterval(this.healCheckInterval);
    }

    // 이미 설정된 타임아웃이 있으면 중지
    if (this.checkTimeout) {
      clearTimeout(this.checkTimeout);
    }

    this.healCheckInterval = setInterval(() => {
      const currentDate = new Date();

      // 모든 반려동물 검사
      for (const petName in pets) {
        const pet = pets[petName];
        const healthCheckDate = pet.healthCheckDate;
        const timeDiff = currentDate.getTime() - healthCheckDate.getTime();
        const oneYearInMs = 365 * 24 * 60 * 60 * 1000;

        if (timeDiff > oneYearInMs && !pet.alreadyWarned) {
          console.log(
            `[건강검진 경고] ${pet.name}: 1년 이상 건강검진을 받지 않았습니다!`
          );
          pet.alreadyWarned = true;
        }
      }
    }, 3000);

    // 10초 후에 건강 상태 검사 종료
    this.checkTimeout = setTimeout(() => {
      this.stopHealthCheck();
      console.log(`[검사 종료]`);
    }, 10000);
  }

  // 건강 상태 검사 중지 메서드
  stopHealthCheck() {
    if (this.healCheckInterval) {
      clearInterval(this.healCheckInterval);
      this.healCheckInterval = null;
    }
  }
}

// 🐾 시스템 사용 예시
const manager = new PetHealthManager();

// 펫 등록
const pet1 = new Pet('나비', '고양이', ['종합백신'], new Date('2023-03-10'));
manager.registerPet(pet1);

// 예방접종 추가
pet1.addVaccination('광견병');
pet1.addVaccination('광견병');

// 건강 상태 검사 시작
manager.checkHealthStatus();

// 5초 후 건강검진 업데이트 (경고 초기화 테스트)
setTimeout(() => {
  pet1.updateHealthCheckDate(new Date());
}, 5000);
