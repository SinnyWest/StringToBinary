package stringToBinary;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class StringToBinaryConverter {

	// fields
	private final static String FILE = "src/stringToBinary/resources/file.txt";
	private static String[] fileDataArray;

	/**
	 * reads strings from file storing in array
	 */
	public static void read() {

		try {
			BufferedReader br = new BufferedReader( new InputStreamReader( new FileInputStream( FILE ) ) );

			String strLine = null;

			while( ( strLine = br.readLine() ) != null ) {

				fileDataArray = strLine.split(",");
			}
			br.close();
		}
		catch( Exception ex ){ System.err.println( ex.getMessage() ); 
		}
	}
	

	public static void convertToBinary() {
		
		Integer lrc = 0;
			
		byte[] stringToByte;

		for( int i = 0; i < fileDataArray.length; i++ ) {
		
			String data = fileDataArray[ i ];		

			stringToByte = data.getBytes();
			
			for( byte s : stringToByte ) {
				
				lrc ^= s;	
			}	
			String binary = Integer.toBinaryString( lrc );
						
			System.out.println( "The LRC and Binary of " + fileDataArray[ i ] + " are: " + lrc + ", " + binary );
		}
	}


	public static void main(String[] args) {

		read();
		convertToBinary();
	}

}
