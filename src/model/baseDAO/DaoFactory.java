package model.baseDAO;

public class DaoFactory {
	
	private static DaoAnnexe daoAnnexe = null;
	private static DaoContact daoContact = null;
	private static DaoFormation daoFormation = null;
	private static DaoLivret daoLivret = null;
	private static DaoLog daoLog = null;
	private static DaoModule daoModule = null;
	private static DaoModuleLiv daoModuleLiv = null;
	private static DaoPeriode daoPeriode = null;
	private static DaoPeriodeLiv daoPeriodeLiv = null;
	private static DaoProjetProLiv daoProjetProLiv = null;
	private static DaoResultatParcoursLiv daoResultatParcoursLiv = null;
	private static DaoSequence daoSequence = null;
	private static DaoSequenceLiv daoSequenceLiv = null;
	private static DaoSpecialisation daoSpecialisation = null;
	private static DaoSuiviLiv daoSuiviLiv = null;
	private static DaoTypeUtilisateur daoTypeUtilisateur = null;
	private static DaoUtilisateur daoUtilisateur = null;
	
	
	public static DaoParent getDaoAnnexe()
	{
		if (daoAnnexe == null)
		{
			daoAnnexe = new DaoAnnexe();
		}
		
		return daoAnnexe;
	}
	
	public static DaoParent getDaoContact()
	{
		if (daoContact == null)
		{
			daoContact = new DaoContact();
		}
		
		return daoContact;
	}
	
	public static DaoParent getDaoFormation()
	{
		if (daoFormation == null)
		{
			daoFormation = new DaoFormation();
		}
		
		return daoFormation;
	}
	
	public static DaoParent getDaoLivret()
	{
		if (daoLivret == null)
		{
			daoLivret = new DaoLivret();
		}
		
		return daoLivret;
	}
	
	public static DaoParent getDaoLog()
	{
		if (daoLog == null)
		{
			daoLog  = new DaoLog();
		}
		
		return daoLog;
	}
	
	public static DaoParent getDaoModule()
	{
		if (daoModule == null)
		{
			daoModule = new DaoModule();
		}
		
		return daoModule;
	}
	
	public static DaoParent getDaoModuleLiv()
	{
		if (daoModuleLiv == null)
		{
			daoModuleLiv = new DaoModuleLiv();
		}
		
		return daoModule;
	}
	
	public static DaoParent getDaoPeriode()
	{
		if (daoPeriode == null)
		{
			daoPeriode = new DaoPeriode();
		}
		
		return daoPeriode;
	}
	
	public static DaoParent getDaoPeriodeLiv()
	{
		if (daoPeriodeLiv == null)
		{
			daoPeriodeLiv = new DaoPeriodeLiv();
		}
		
		return daoPeriode;
	}
	
	
	public static DaoParent getDaoProjetProLiv()
	{
		if (daoProjetProLiv == null)
		{
			daoProjetProLiv = new DaoProjetProLiv();
		}
		
		return daoProjetProLiv;
	}
	
	public static DaoParent getDaoResultatParcoursLiv()
	{
		if (daoResultatParcoursLiv == null)
		{
			daoResultatParcoursLiv = new DaoResultatParcoursLiv();
		}
		
		return daoResultatParcoursLiv;
	}
	
	public static DaoParent getDaoSequence()
	{
		if (daoSequence == null)
		{
			daoSequence = new DaoSequence();
		}
		
		return daoSequence;
	}
	
	public static DaoParent getDaoSequenceLiv()
	{
		if (daoSequenceLiv == null)
		{
			daoSequenceLiv = new DaoSequenceLiv();
		}
		
		return daoSequenceLiv;
	}
	
	
	public static DaoParent getDaoSpecialisation()
	{
		if (daoSpecialisation == null)
		{
			daoSpecialisation = new DaoSpecialisation();
		}
		
		return daoSpecialisation;
	}
	
	public static DaoParent getDaoSuiviLiv()
	{
		if (daoSuiviLiv == null)
		{
			daoSuiviLiv = new DaoSuiviLiv();
		}
		
		return daoSuiviLiv;
	}
	
	public static DaoParent getDaoUtilisateur()
	{
		if (daoUtilisateur == null)
		{
			daoUtilisateur = new DaoUtilisateur();
		}
		
		return daoUtilisateur;
	}
	
	public static DaoParent getDaoTypeUtilisateur()
	{
		if (daoTypeUtilisateur == null)
		{
			daoTypeUtilisateur = new DaoTypeUtilisateur();
		}
		
		return daoTypeUtilisateur;
	}
}
