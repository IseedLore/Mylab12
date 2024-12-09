package it.unibo.es3;

public interface Logics {
    /**
	 * @return the new value a button should show after being pressed
	 */
	void Start(Pair<Integer,Integer> elem);

	/**
	 * @return whether it is time to quit
	 */
	boolean toQuit();
}
