public class Main {

	public static void main(String[] args) {
		Array arr = new Array(7);
		Helpers.printArray(arr.getArray());
		arr.rotateRightJuggle(2);
		Helpers.printArray(arr.getArray());
	}
}
