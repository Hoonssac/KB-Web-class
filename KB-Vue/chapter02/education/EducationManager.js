import fs from 'fs/promises';
import path from 'path';
import { fileURLToPath } from 'url';

export class EducationManager {
  constructor() {
    this.Programs = [];
    this.records = [];
  }

  registerProgram(program) {
    this.Programs.push(program);
    console.log(`[등록 완료] 교육 과정: ${program.title}`);
  }
  completeProgramWithFunction(title) {
    const program = this.Programs.find((p) => p.title === title);

    function markComplete() {
      this.records.push({
        title: program.title,
        discription: program.discription,

        completed: true,
      });
      console.log(`[이수 완료 - 일반 함수] ${program.title}`);
    }
    markComplete.call(this);
  }

  completeProgramWithArrowFunction(title) {
    const program = this.Programs.find((p) => p.title === title);
    const markComplete = () => {
      this.records.push({
        title: program.title,
        discription: program.discription,
        completed: true,
      });
      console.log(`[이수 완료 - 화살표 함수] ${program.title}`);
    };
    markComplete();
  }

  async saveToFile() {
    const __filename = fileURLToPath(import.meta.url);
    const __dirname = path.dirname(__filename);
    const filePath = path.join(__dirname, 'education_records.json');
    try {
      await fs.writeFile(filePath, JSON.stringify(this.records, null, 2));
      console.log('[파일 저장 완료] 교육 기록이 파일로 저장되었습니다.');
    } catch {}
  }
}
