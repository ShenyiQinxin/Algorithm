


class PyramidNumber{

	static void patternOne(int rows){
		int rowCount = 1;
		//the rows
		for(int i=rows; i>=1; i--){
			//left columns
			for(int j=1; j<i; j++){
				System.out.print(" ");
			}
			//right columns
			for(int j=1; j<=rowCount; j++){
				System.out.print(rowCount+" ");
			}
			System.out.println();
			rowCount++;
		}
	}

	static void patternTwo(int rows){
		int rowCount = 1;
		//the rows
		for(int i=rows; i>=1; i--){
			//left columns
			for(int j=1; j<i; j++){
				System.out.print(" ");
			}
			//right columns
			for(int j=1; j<=rowCount; j++){
				System.out.print(j+" ");
			}
			System.out.println();
			rowCount++;
		}

	}

	static void patternThree(int rows){
		int rowCount = 1;
		//the rows
		for(int i=rows; i>=1; i--){
			//left columns
			for(int j=1; j<i; j++){
				System.out.print(" ");
			}
			//right columns
			for(int j=1; j<=rowCount; j++){
				System.out.print("* ");
			}
			System.out.println();
			rowCount++;
		}
	}

	static void patternFour(int rows){
		int rowCount = 1;
		//the rows
		for(int i=rows; i>=1; i--){
			//left columns
			for(int j=1; j<=(i-1)*2; j++){
				System.out.print(" ");
			}
			//right columns
			for(int j=1; j<=rowCount; j++){
				System.out.print(j+" ");
			}
			for(int j=rowCount-1; j>=1; j--){
				System.out.print(j+" ");
			}
			System.out.println();
			rowCount++;
		}
	}

	static void patternFive(int rows){
		int rowCount = 1;
		//the rows
		for(int i=rows; i>=1; i--){
			//left columns
			for (int j = 1; j <= (i-1)*2; j++){
                System.out.print(" ");
            }
            //right columns
			for(int j=i; j<=rows; j++){
				System.out.print(j+" ");
			}
			for(int j=rows-1; j>=i; j--){
				System.out.print(j+" ");
			}
			System.out.println();
			rowCount++;
		}

	}

	static void patternSix(int rows){
		int rowCount = rows;
		//the rows
		for(int i=0; i< rows; i++){
			//left columns
			for(int j=1; j<=(i)*2;j++){
				 System.out.print(" ");
			}
			//right columns
			for(int j=1; j<=rowCount; j++){
				System.out.print(j+" ");
			}
			for(int j=rowCount-1; j>=1; j--){
				System.out.print(j+" ");
			}
			System.out.println();
			rowCount--;
		}

	}

	public static void main(String[] args){

		/*patternOne(9);
		patternTwo(9);
		patternThree(9);
		patternFour(9);*/
		//patternFive(9);
		patternSix(9);
	}
	
}