package lt.gt.sudoku;

public class Util {
	public static String printBoard ( Board b ) {
		StringBuffer result = new StringBuffer ();
		
		for ( int y=0; y<9; y++) { 
			for ( int x=0; x<9; x++)
				result.append( b.getB(x, y) ).append( ", " );
			result.append( "\n" );
		}
		
		return result.toString(); 
	}
	
	public static String printCandidates ( CandidatesBoard c ) {
		StringBuffer result = new StringBuffer ();
		for ( int y=0; y<9; y++) { 
			for ( int x=0; x<9; x++)
				result.append( c.getCandidates(x,y).getCandidatesSet() ).append( "; " );
			result.append( "\n" );
		}
		return result.toString(); 
	}
}
