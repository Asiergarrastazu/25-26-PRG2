import java.util.Scanner;

public class Buscaminas{

	static final int FILAS = 5;
	static final int COLUMNAS = 7;
	static final int MINAS = 5;
	static final int MAX_MINAS_TOCADAS = 2;
	static final int MAX_MOVIMIENTOS = 31;

	static String[][] mapaMinasMostrar = 	
		{
			{" ", "1", "2", "3", "4", "5", "6", "7"},
			{"1", "-", "-", "-", "-", "-", "-", "-"},
			{"2", "-", "-", "-", "-", "-", "-", "-"},
			{"3", "-", "-", "-", "-", "-", "-", "-"},
			{"4", "-", "-", "-", "-", "-", "-", "-"},
			{"5", "-", "-", "-", "-", "-", "-", "-"}
		};
		
	static String[][] mapaMinasActivas = 	
		{
			{" ", "1", "2", "3", "4", "5", "6", "7"},
			{"1", "0", "0", "0", "0", "0", "0", "0"},
			{"2", "0", "0", "0", "0", "0", "0", "0"},
			{"3", "0", "0", "0", "0", "0", "0", "0"},
			{"4", "0", "0", "0", "0", "0", "0", "0"},
			{"5", "0", "0", "0", "0", "0", "0", "0"}
		};

	public static void main(String[] args){	
		Scanner scan = new Scanner(System.in);

		int i = 0;	
		while (i < MINAS){
			int PosXMina = (int)(Math.random() * FILAS + 1);
			int PosYMina = (int)(Math.random() * COLUMNAS + 1);

			if (mapaMinasActivas[PosXMina][PosYMina].equals("1")){
				continue;
			} else {
				mapaMinasActivas[PosXMina][PosYMina] = "1";
				i++;
			}
		}

		int posX = 0, posY = 0;
		int juegoEncendido = 1;
		int valoresCorrectos;
		int contadorMapa = 0;
		int contadorMinas = 0;

		while(juegoEncendido == 1){

			for(i = 0; i <= FILAS; i++){            
				for (int j = 0; j <= COLUMNAS; j++){                                     
					System.out.print(mapaMinasMostrar[i][j] + " ");
				}
				System.out.println();
			}

			valoresCorrectos = 0;

			while(valoresCorrectos == 0){
				posY = scan.nextInt();
				posX = scan.nextInt();

				if(posX >= 1 && posX <= FILAS && posY >= 1 && posY <= COLUMNAS){
					valoresCorrectos = 1;
				}
			}

			if(!mapaMinasMostrar[posX][posY].equals("-")){
				continue;
			}

			if(mapaMinasActivas[posX][posY].equals("1")){
				mapaMinasMostrar[posX][posY] = "x";
				contadorMinas++;
			} else if(mapaMinasActivas[posX][posY].equals("0")){
				mapaMinasMostrar[posX][posY] = ".";
			}

			contadorMapa++;

			if(contadorMinas > MAX_MINAS_TOCADAS){
				juegoEncendido = 0;
			} else if(contadorMapa >= MAX_MOVIMIENTOS){
				juegoEncendido = 0;
			}
		}
	}	
}