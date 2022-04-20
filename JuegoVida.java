
public class JuegoVida
{
	public static void main(String[] args)
	{
		int M = 2, N = 2;

		// Define el tamaño
		int[][] tamaño = { { 0, 0},
			{ 1, 1 }
		};

		//Tablero
		System.out.println("Estado inical");
		for (int i = 0; i < M; i++)
		{
			for (int j = 0; j < N; j++)
			{
				if (tamaño[i][j] == 0)
					System.out.print("~");
				else
					System.out.print("#");
			}
			System.out.println();
		}
		System.out.println();
		sigEstado(tamaño, M, N);
	}

	// Función para el siguiente estado
	static void sigEstado(int tamaño[][], int M, int N)
	{
		int[][] siguiente = new int[M][N];
		for (int l = 0; l < M; l++)
		{
			for (int m = 0; m < N; m++)
			{
				// Celula viva
				int celulaViva = 0;
				for (int i = -1; i <= 1; i++)
					for (int j = -1; j <= 1; j++)
					if ((l+i>=0 && l+i<M) && (m+j>=0 && m+j<N))
						celulaViva += tamaño[l + i][m + j];

				celulaViva -= tamaño[l][m];

				// Reglas del Juego de la vida

				// Celula muere por soledas
				if ((tamaño[l][m] == 1) && (celulaViva < 2))
					siguiente[l][m] = 0;

				// Celula muere por sobrepoblación
				else if ((tamaño[l][m] == 1) && (celulaViva > 3))
					siguiente[l][m] = 0;

				// Celula nace
				else if ((tamaño[l][m] == 0) && (celulaViva == 3))
					siguiente[l][m] = 1;

				// Queda igual
				else
					siguiente[l][m] = tamaño[l][m];
			}
		}

		System.out.println("Siguiente estado");
		for (int i = 0; i < M; i++)
		{
			for (int j = 0; j < N; j++)
			{
				if (siguiente[i][j] == 0)
					System.out.print("~");
				else
					System.out.print("#");
			}
			System.out.println();
		}
	}
}
