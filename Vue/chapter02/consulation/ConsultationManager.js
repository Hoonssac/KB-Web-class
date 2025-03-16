export class ConsultationManager {
  constructor() {
    this.customers = [];
  }
  registerConsultation(customer) {
    // 중복 등록 확인
    const isDuplicate = this.customers.some(
      (c) =>
        c.name === customer.name &&
        c.num === customer.num &&
        c.pet === customer.pet
    );

    if (isDuplicate) {
      console.log(
        `[상담 중복 오류] ${customer.name}: 이미 등록된 상담 기록입니다.`
      );
      return;
    }

    // 전화번호 형식 확인
    const phoneRegex = /^010-\d{4}-\d{4}$/;
    if (!phoneRegex.test(customer.num)) {
      console.log(
        `[상담 등록 오류] ${customer.name}: 잘못된 전화번호 형식입니다.`
      );
      return;
    }

    this.customers.push(customer);
    console.log(`[상담 등록] ${customer.name} - 선호 펫: ${customer.pet}`);

    // 1초 후 자동 저장 완료 메시지 출력
    setTimeout(() => {
      console.log(`[저장 완료] ${customer.name} 상담 기록 저장 완료!`);
    }, 1000);
  }

  autoEndConsultation() {
    setTimeout(() => {
      console.log(`[상담 기록 저장 종료]`);
    }, 5000);
  }
}
