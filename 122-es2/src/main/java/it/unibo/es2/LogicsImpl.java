package it.unibo.es2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;

public class LogicsImpl implements Logics {

    private final int size;
    private final Map< Pair<Integer, Integer>, String> textOfButtons = new HashMap<>();

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
        List<Integer> tmp = new ArrayList<>();
        //Coloumn  
        for (int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                if(textOfButtons.get(new Pair<>(i, j)) == value){
                    tmp.add(j, 0);
                } else{
                    tmp.add(j, 1);
                }
            }           
            return tmp.contains(0);
        }        
        tmp.clear();
        //Line
        for (int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                if(textOfButtons.get(new Pair<>(j, i)) == value){
                    tmp.add(i, 0);
                } else{
                    tmp.add(i, 1);
                }
            }           
            return tmp.contains(0);
        } 
        
        return false;
        
    }
}
