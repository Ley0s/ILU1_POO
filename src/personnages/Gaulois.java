package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int nbTrophees;
	private int effetPotion = 0;
	private Equipement[] trophees = new Equipement[100];
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	
	public String getNom() {
		return nom;
	}
	
	public int getForce() {
		return force;
	}

	public int getEffetPotion() {
		return effetPotion;
	}
	
	public int getNbTrophees() {
		return nbTrophees;
	}

	public void setForce(int force) {
		this.force = force;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "\" " + texte + " \"");
	}
	
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] trophee = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; trophee != null && i < trophee.length; i++, nbTrophees++) {
			this.trophees[nbTrophees] = trophee[i];
		}
	}
	
	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
		parler("Merci Druide, je sens que ma force est " + forcePotion + " fois décuplée");
	}

	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" 
				+ effetPotion + "]";
	}
	
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		System.out.println(asterix);
		
  		//tests mï¿½thodes
		Romain brutus = new Romain("Brutus", 10);
		asterix.parler("salut la team !");
		asterix.boirePotion(6);
		System.out.println(brutus.getForce());
		asterix.frapper(brutus);
		System.out.println(brutus.getForce());
	}
}
