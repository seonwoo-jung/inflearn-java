package generic.ex3;

public class AnimalHospitalV2<T> {

	private T animal;

	public void set(T animal) {
		this.animal = animal;
	}

	public void checkup() {
		// T의 타입을 메서드를 정의하는 시점에는 알 수 없다. Object의 기능만 사용
		animal.toString();
		animal.equals(null);

		// 컴파일 오류
		// System.out.println("동물 이름: " + animal.getName());
		// System.out.println("동물 크기: " + animal.getSize());
		// animal.sound();
	}

	public T bigger(T target) {
		// 컴파일 오류
		// return animal.getSize() > target.getSize() ? animal : target;
		return null;
	}
}
