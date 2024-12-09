package it.unibo.es1;

import java.util.ArrayList;
import java.util.List;

public class LogicsImpl implements Logics {

	private final int size;
	private final List<Integer> values;
	private final List<Boolean> enablings;

	public LogicsImpl(int size) {
		this.size = size;
		this.values = new ArrayList<Integer>(this.size);
		this.enablings = new ArrayList<Boolean>(this.size);
		for(int i = 0; i < size; i++) {
			this.values.add(0);
		}
		for(int i = 0; i < size; i++) {
			this.enablings.add(true);
		}
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public List<Integer> values() {
		return new ArrayList<>(this.values);
	}

	@Override
	public List<Boolean> enablings() {
		return new ArrayList<>(this.enablings);
	}

	@Override
	public int hit(int elem) {
		int value = this.values.get(elem) +1;
		this.values.remove(elem);
		this.values.add(elem, value);
		if(value == this.size){
			this.enablings.remove(elem);
			this.enablings.add(elem, false);
		}
		return value;
	}

	@Override
	public String result() {
		return this.values.toString().replaceAll(", ", "|").replace("[","<<").replace("]",">>");
	}

	@Override
	public boolean toQuit() {
		return this.values.stream().distinct().count() == 1;
	}
}
