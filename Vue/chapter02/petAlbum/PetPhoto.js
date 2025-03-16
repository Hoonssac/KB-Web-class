import { Pet } from './Pet.js';

export class PetPhoto extends Pet {
  constructor(name, spacies, adoptionDate, photoPath, uploadDate) {
    super(name, spacies, adoptionDate);
    this.photoPath = photoPath;
    this.uploadDate = uploadDate;
  }
}
