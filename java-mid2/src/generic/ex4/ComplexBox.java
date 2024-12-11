package generic.ex4;

import generic.animal.Animal;

public class ComplexBox<T extends Animal> {

	private T animal;

	public void set(T animal) {
		this.animal = animal;
	}

	public <Z> Z printAndReturn(Z z) {
		System.out.println("animal.className: " + animal.getClass().getName());
		System.out.println("t.className: " + z.getClass().getName());
		return z;
	}
}
