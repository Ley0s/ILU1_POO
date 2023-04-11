package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipement = new Equipement[2];
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
		System.out.println(prendreParole() + "\" " + texte + " \"");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		
		assert force > 0;
		int oldForce = force;
		
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
		if(force > 0) {
			parler("A�e");
		} else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
		
		assert force <= oldForce;
		return equipementEjecte;
	}
	
	private int calculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grace � mon �quipement sa force est diminu�e de ";
			for (int i = 0; i < nbEquipement; i++) {
				if ((equipement[i] != null && equipement[i].equals(Equipement.BOUCLIER)) == true) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
			}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		if (forceCoup <= resistanceEquipement) {
			forceCoup = 1;
		} else {
			forceCoup -= resistanceEquipement;
		}
		assert forceCoup >= 0;
		return forceCoup;
	}
		
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'�quipement de " + nom + " s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipement[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipement[i];
				nbEquipementEjecte++;
				equipement[i] = null;
			}
		}
		return equipementEjecte;
	}
	
	private void ajouterEquip(Equipement equip) {
		equipement[nbEquipement]=equip;
		nbEquipement++;
	}
	
	public void sEquiper(Equipement equip) {
		String soldat = "Le soldat " + getNom();
		switch(nbEquipement) {
			case 1:
				if(equipement[0] == equip) {
					System.out.println(soldat + " poss�de d�j� un " + equip + ".");
				} else {
					System.out.println(soldat + " s'�quipe avec un " + equip + ".");
					ajouterEquip(equip);
				}
				break;
			case 0: 
				System.out.println(soldat + " s'�quipe avec un " + equip + ".");
				ajouterEquip(equip);
				break;
			default:
				System.out.println(soldat + " est d�j� bien prot�g�.");
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
		
		//tests m�thodes
//		brutus.parler("Salut la team !");
//		System.out.println(brutus.getForce());
//		brutus.recevoirCoup(2);
//		System.out.println(brutus.getForce());
	}
}