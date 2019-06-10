public class Datum {

	private int dag;
	private int maand;
	private int jaar;

	  /**
	   * Constructor
	   */
	public Datum(){
		dag = 0;
		maand = 0;
		jaar = 0;
	}

	public Datum(int dag, int maand, int jaar){
			setDag(dag);
			setMaand(maand);
			setJaar(jaar);
	}

	public int getDag() {
		return dag;
	}

	public int getMaand() {
		return maand;
	}

	public int getJaar() {
		return jaar;
	}

	public void setDag(int dag) {
		this.dag = dag;
	}

	public void setMaand(int maand) {
		this.maand = maand;
	}

	public void setJaar(int jaar) {
		this.jaar = jaar;
	}

	public void volgendeDag() {
		setDag(dag+1);
		if (!bestaatDatum()) {
			setDag(1);
			setMaand(maand+1);
			if (!bestaatDatum()) {
				setMaand(1);
				setJaar(jaar+1);
				if (!bestaatDatum()) {
					setJaar(1900);
				}
			}
		}
	}

	public boolean bestaatDatum(){
		if(dag > 31 | maand > 12 | jaar > 2100) return false;
		if(dag < 1 | maand < 1 | jaar < 1900) return false;
		switch(maand) {
			case 4:
			case 6:
			case 9:
			case 11:
				if (dag > 30) return false;
				break;
			case 2:
				if(dag>29) return false;
				if((jaar%4 > 0 | jaar%100 < 1 & jaar%400 > 0) & dag > 28) return false;
		}
		return true;
	}
	
	/**
	 * Getter voor Sting weergave van datum
	 * @return Geboortedatum
	 */
	public String getDatumAsString() {
		if (bestaatDatum()) return "" + jaar + "-" + maand + "-" + dag;
		return "Onbekend";
		}
}
