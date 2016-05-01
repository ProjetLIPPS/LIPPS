package controleur;

import java.util.ArrayList;
import java.util.List;

import ihm.fenetre.PanelMngRowMod;
import model.objet.Formation;
import model.objet.Module;

public class LoadModSeqList {
	
	 
	public static List<PanelMngRowMod> listeAllModule(Formation formation)   
	{
		
		ArrayList<PanelMngRowMod> listMod = new ArrayList<PanelMngRowMod>();
		
//		for (Module mod : formation.getListModule())
//		{
//			PanelMngModuleRowMod rowmod = new PanelMngModuleRowMod(mod);
//			listMod.add(rowmod);
//		}
			
		return listMod;
		
	}

	
	
/*	public List<PanelMngModuleRowSeq> listeSequence() {
		
		ArrayList<PanelMngModuleRowSeq> listSeq = new ArrayList<PanelMngModuleRowSeq>();
		
		// recuperation depuis la bdd des objets sequences associes à un module donnée
		
				// methode provisoire en dur >>>
				
				Sequence seq1 = new  Sequence("Testmoduleint");
				
				PanelMngModuleRowSeq rowseq1 = new PanelMngModuleRowSeq(seq1);
				
				listSeq.add(seqmod1);
				
				return listSeq;
		
		
		return listSeq;
		
	}*/
	
	
	
	
	
	
	
	
	
	
	
}
