package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement equipement[];
	private int nbEquipement=0;
	
	public Romain(String nom, int force) {
		assert force > 0;
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}
	
	public int getForce() {
		return force;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + " »");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
	public void recevoirCoup(int forceCoup) {
		assert force >= 0;
		int temp = force;
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
		assert force < temp;
	}
	
	private void ajouterEquip(Equipement equip) {
		System.out.println(" s'équipe avec un " + equip + ".");
		equipement[nbEquipement]=equip;
		nbEquipement++;
	}
	
	public void sEquiper(Equipement equip) {
		System.out.println("Le soldat " + getNom());
		switch(nbEquipement) {
		case 2:
			System.out.println(" est déjà bien protégé.");
			break;
		case 1:
			if(equipement[0] == equip) {
				System.out.println(" possède déjà un " + equip + ".");
			} else {
				ajouterEquip(equip);
			}
			break;
		case 0: 
			ajouterEquip(equip);
			break;
		}
	}
	
	@Override
	public String toString() {
		return "Romain [nom=" + nom + ", force=" + force + "]";
	}
	
	public static void main(String[] args) {
		Romain brutus = new Romain("Brutus", 6);
		System.out.println(brutus);
		brutus.sEquiper(Equipement.CASQUE);
		brutus.sEquiper(Equipement.CASQUE);
		brutus.sEquiper(Equipement.BOUCLIER);
		brutus.sEquiper(Equipement.CASQUE);
		
		//tests méthodes
//		brutus.parler("Salut la team !");
//		System.out.println(brutus.getForce());
//		brutus.recevoirCoup(2);
//		System.out.println(brutus.getForce());
	}
}