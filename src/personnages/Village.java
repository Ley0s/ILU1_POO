package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private int nbVillageois=0;
	private Gaulois villageois[];
	
	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		this.villageois = new Gaulois[nbVillageoisMaximum];
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public String getNom() {
		return nom;
	}
	
	public void ajouterHabitant(Gaulois gaulois) {
		villageois[nbVillageois]=gaulois;
		nbVillageois++;
	}
	
	public Gaulois trouverHabitant(int indice) {
		return villageois[indice];
	}
	
	public static void main(String[] args) {
		Village villageDesIrreductibles = new Village("Village des Irréductibles", 30);
		Chef abraracourcix;
		villageDesIrreductibles.setChef(abraracourcix);
		abraracourcix = new Chef("Abraracourcix", 6, villageDesIrreductibles);
		
		
//		Gaulois gaulois = villageDesIrréductibles.trouverHabitant(30);
//		Cette ligne donne une erreur car l'indice max est 29 et non 30
		
	}
}
