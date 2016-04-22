package model.baseDAO;

public class DaoFactory {
	
	private static DaoAnnexeLivret daoAnnexeLivret = null;
	private static DaoContact daoContact = null;
	private static DaoFormation daoFormation = null;
	private static DaoLivret daoLivret = null;
	private static DaoLog daoLog = null;
	private static DaoModule daoModule = null;
	private static DaoModuleLivret daoModuleLivret = null;
	private static DaoPeriode daoPeriode = null;
	private static DaoPeriodeLivret daoPeriodeLivret = null;
	private static DaoProjetProLivret daoProjetProLivret = null;
	private static DaoResultatParcoursLivret daoResultatParcoursLivret = null;
	private static DaoRole daoRole = null;
	private static DaoSequence daoSequence = null;
	private static DaoSequenceLivret daoSequenceLivret = null;
	private static DaoSpecialisation daoSpecialisation = null;
	private static DaoSuiviLivret daoSuiviLivret = null;
	private static DaoTypePeriode daoTypePeriode = null;
	private static DaoTypePeriodeLivret daoTypePeriodeLivret = null;
	private static DaoUtilisateur daoUtilisateur = null;
	
	
	public static DaoParent getDaoAnnexeLivret()
	{
		if (daoAnnexeLivret == null)
		{
			daoAnnexeLivret = new DaoAnnexeLivret();
		}
		
		return daoAnnexeLivret;
	}
	
	public static DaoContact getDaoContact()
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
	
	public static DaoParent getDaoModuleLivret()
	{
		if (daoModuleLivret == null)
		{
			daoModuleLivret = new DaoModuleLivret();
		}
		
		return daoModuleLivret;
	}
	
	public static DaoParent getDaoPeriode()
	{
		if (daoPeriode == null)
		{
			daoPeriode = new DaoPeriode();
		}
		
		return daoPeriode;
	}
	
	public static DaoParent getDaoPeriodeLivret()
	{
		if (daoPeriodeLivret == null)
		{
			daoPeriodeLivret = new DaoPeriodeLivret();
		}
		
		return daoPeriodeLivret;
	}
	
	
	public static DaoParent getDaoProjetProLivret()
	{
		if (daoProjetProLivret == null)
		{
			daoProjetProLivret = new DaoProjetProLivret();
		}
		
		return daoProjetProLivret;
	}
	
	public static DaoParent getDaoResultatParcoursLivret()
	{
		if (daoResultatParcoursLivret == null)
		{
			daoResultatParcoursLivret = new DaoResultatParcoursLivret();
		}
		
		return daoResultatParcoursLivret;
	}
	
	public static DaoParent getDaoRole()
	{
		if (daoRole == null)
		{
			daoRole = new DaoRole();
		}
		
		return daoRole;
	}
	
	public static DaoParent getDaoSequence()
	{
		if (daoSequence == null)
		{
			daoSequence = new DaoSequence();
		}
		
		return daoSequence;
	}
	
	public static DaoParent getDaoSequenceLivret()
	{
		if (daoSequenceLivret == null)
		{
			daoSequenceLivret = new DaoSequenceLivret();
		}
		
		return daoSequenceLivret;
	}
	
	
	public static DaoParent getDaoSpecialisation()
	{
		if (daoSpecialisation == null)
		{
			daoSpecialisation = new DaoSpecialisation();
		}
		
		return daoSpecialisation;
	}
	
	public static DaoParent getDaoSuiviLivret()
	{
		if (daoSuiviLivret == null)
		{
			daoSuiviLivret = new DaoSuiviLivret();
		}
		
		return daoSuiviLivret;
	}
	
	public static DaoParent getDaoTypePeriode()
	{
		if (daoTypePeriode == null)
		{
			daoTypePeriode = new DaoTypePeriode();
		}
		
		return daoTypePeriode;
	}
	
	public static DaoParent getDaoTypePeriodeLivret()
	{
		if (daoTypePeriodeLivret == null)
		{
			daoTypePeriodeLivret = new DaoTypePeriodeLivret();
		}
		
		return daoTypePeriodeLivret;
	}
	
	public static DaoParent getDaoUtilisateur()
	{
		if (daoUtilisateur == null)
		{
			daoUtilisateur = new DaoUtilisateur();
		}
		
		return daoUtilisateur;
	}
	
	
}
