package it.unibo.es2;

import java.util.HashMap;
import java.util.Map;

public class LogicsImpl implements Logics {

    private final int size;
    private final Map<Pair<Integer, Integer>, String> textOfButtons = new HashMap<>();

	public LogicsImpl(int size) {
		this.size = size;
        for (int i=0; i<size; i++){
            for (int j=0; j<size; j++){
                this.textOfButtons.put(new Pair<>(i,j), "");
                
            }
        }
	}

    @Override
    public String hit(Pair<Integer,Integer> elem) {
        if(textOfButtons.get(elem) == ""){
            textOfButtons.replace(elem, "*");
        } else {
            textOfButtons.replace(elem, "");
        }
        return textOfButtons.get(elem);
    }

    @Override
    public boolean toQuit() {

        
        String value = "*";
        Integer tmp;
        //Coloumn  
        for (int i=0; i<size; i++){
            tmp = 0;
            for(int j=0; j<size; j++){
                if(textOfButtons.get(new Pair<>(i, j)) == value){
                    tmp++;
                } else{
                    tmp--;
                }
            }           
            if(tmp==size){
                return true;
            }
        }        
        //Line  
        for (int i=0; i<size; i++){
            tmp = 0;
            for(int j=0; j<size; j++){
                if(textOfButtons.get(new Pair<>(j, i)) == value){
                    tmp++;
                } else{
                    tmp--;
                }
            }           
            if(tmp==size){
                return true;
            }
        } 
        return false;
        
    }
}
