import fs from 'fs/promises';
import path from 'path';
import { fileURLToPath } from 'url';

export class PetRecommender {
  constructor() {
    this.recommendations = [];
  }
  recommendPet(customer) {
    let recommendedPet = '';
    if (
      customer.lifestyle == '활동적' &&
      customer.housing == '단독주택' &&
      customer.familyMembers == '어린이 없음'
    ) {
      recommendedPet = '골든 리트리버';
    } else if (
      customer.lifestyle == '조용한' &&
      customer.housing == '아파트' &&
      customer.familyMembers == '어린이 있음'
    ) {
      recommendedPet = '고양이';
    }

    const recommendation = {
      name: customer.name,
      recommendedPet: recommendedPet,
    };
    this.recommendations.push(recommendation);
    return recommendation;
  }
  async saveToFile() {
    const __filename = fileURLToPath(import.meta.url);
    const __dirname = path.dirname(__filename);
    const filePath = path.join(__dirname, 'pet_recommendations.json');
    try {
      await fs.writeFile(
        filePath,
        JSON.stringify(this.recommendations, null, 2)
      );
    } catch {}
  }
}
