package collection.set.test;

public class Rectangle {

	private int width;
	private int height;

	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		Rectangle rectangle = (Rectangle) o;
		return width == rectangle.width && height == rectangle.height;
	}

	@Override
	public int hashCode() {
		int result = width;
		result = 31 * result + height;
		return result;
	}

	@Override
	public String toString() {
		return "Rectangle{" +
			"width=" + width +
			", height=" + height +
			'}';
	}
}
