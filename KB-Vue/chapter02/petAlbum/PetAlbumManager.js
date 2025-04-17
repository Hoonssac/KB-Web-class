import fs from 'fs/promises';
import path from 'path';
import { fileURLToPath } from 'url';
import { PetPhoto } from './PetPhoto.js';
import { PetGrowthRecord } from './PetGrowthRecord.js';

export class PetAlbumManager {
  constructor() {
    this.photos = [];
    this.growthRecords = [];
  }

  async addRecord(record) {
    if (record instanceof PetPhoto) {
      const isDuplicate = this.photos.some(
        (p) => p.photoPath === record.photoPath
      );
      if (isDuplicate) {
        console.log(`[등록 오류] ${record.name}: 중복된 사진입니다.`);
        return;
      }
      record.uploadDate = new Date();
      this.photos.push(record);
      console.log(`[등록 완료] ${record.name}: Photo가 등록되었습니다.`);
    } else if (record instanceof PetGrowthRecord) {
      const isDuplicate = this.growthRecords.some(
        (r) => r.recordDate === r.recordDate
      );
      if (isDuplicate) {
        console.log(`[등록 오류] ${record.name}: 중복된 성장 기록입니다.`);
        return;
      }
      this.growthRecords.push(record);
      console.log(
        `[등록 완료] ${record.name}: Growth Record가 등록되었습니다.`
      );
    }
    await this.saveToFile();
  }

  async saveToFile() {
    const __filename = fileURLToPath(import.meta.url);
    const __dirname = path.dirname(__filename);
    const filePath = path.join(__dirname, 'pet_album.json');
    const data = [
      ...this.photos.map((photo) => ({ ...photo, type: 'Photo' })),
      ...this.growthRecords.map((record) => ({
        ...record,
        type: 'Growth Record',
      })),
    ];
    try {
      await fs.writeFile(filePath, JSON.stringify(data, null, 2));
      console.log('[파일 저장 완료] 앨범 기록이 파일로 저장되었습니다.');
    } catch (error) {
      console.error('파일 저장 중 오류가 발생했습니다:', error);
    }
  }
}
