package generic.ex4;

import generic.animal.Cat;
import generic.animal.Dog;

public class MethodMain3 {

	public static void main(String[] args) {
		Dog dog = new Dog("멍멍이", 100);
		Cat cat = new Cat("냐옹이", 50);

		ComplexBox<Dog> hospital = new ComplexBox<>();
		hospital.set(dog);

		// ComplexBox 클래스에 T는 Dog로, Z는 Cat으로 바뀐다.
		Cat returnCat = hospital.printAndReturn(cat);
		System.out.println("returnCat = " + returnCat);
	}
}
