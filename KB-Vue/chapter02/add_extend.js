class Vehicle {
  constructor(name, wheel) {
    (this.name = name), (this.wheel = wheel);
  }
}
const myVehicle = new Vehicle('운송수단', 2);
console.log(myVehicle);

// 상속 키워드는 extends
class Bicycle extends Vehicle {
  constructor(name, wheel, coolr) {
    // super 키워드로 부모 클래스 호출 가능
    super(name, wheel);
    this.color = color;
  }
}
const myBicycle = new Bicycle('자전거', 2, '핑크');
console.log(myBicycle);
