import java.util.HashMap;
import java.util.Map;



public class BigSquare {
	
	static String[] table = {"A","B","C","D","E","F","G","H","I"};
	static int[][] crisscross = new int[table.length][table.length];
	static Map<String, TextField> list = new HashMap<String, TextField>();
	Map<String, Label> dialoglist= new HashMap<String, Label>();
	
	static int[][] textFieldToCrisscross(){
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table.length; j++) {
		crisscross[i][j] = Integer.parseInt(list.get(table[i] + table[j]).getText());
			}}
		return crisscross;
		
	}

	

}
