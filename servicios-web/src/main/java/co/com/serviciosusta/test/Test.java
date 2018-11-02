package co.com.serviciosusta.test;

public class Test {

	public static void main(String[] args) {
		boolean SilviaTellsMe = false;
		
		
		if(SilviaTellsMe){
			System.out.println("Dejo de molestar");
		}else{
			while (!SilviaTellsMe) {
				for(int i=1; i<100; i++){
					if(!SilviaTellsMe){
						System.out.println("Dime");
					}else{
						System.out.println("Se canzo y me dice");
						SilviaTellsMe = true;
						break;
					}
				}
				
			}
		}
	}

}
