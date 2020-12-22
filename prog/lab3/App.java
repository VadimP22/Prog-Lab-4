package prog.lab3;

public class App {

	public static void main(String[] args) {

			MessagePrinter printerToConsole = new MessagePrinter() {
				@Override
				public void print(String message) {
						System.out.println(message);
				}
			};


        	Human spruts;
        	FoodSource cupboard = new Cupboard();
        	Storage floor = new Floor();
        	House sprutsHouse;


			try {
				spruts = new Spruts(printerToConsole);
			} catch (AlreadyExistsException e) {
				printerToConsole.print("Spruts");
				printerToConsole.print(e.getMessage());
				return;
			}



			try {
				sprutsHouse = new SprutsHouse(printerToConsole, spruts, floor, cupboard);
			} catch (AlreadyExistsException e) {
				printerToConsole.print("SprutsHouse");
				printerToConsole.print(e.getMessage());
				return;
			}


			sprutsHouse.passDay();

	}
	
}
