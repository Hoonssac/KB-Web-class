import { Pet } from './Pet.js';

export class PetGrowthRecord extends Pet {
  constructor(name, spacies, adoptionDate, description, recordDate) {
    super(name, spacies, adoptionDate);
    this.description = description;
    this.recordDate = recordDate;
  }
}
