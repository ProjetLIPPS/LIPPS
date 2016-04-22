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
	
	
	public static DaoAnnexeLivret getDaoAnnexeLivret()
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
	
	public static DaoFormation getDaoFormation()
	{
		if (daoFormation == null)
		{
			daoFormation = new DaoFormation();
		}
		
		return daoFormation;
	}
	
	public static DaoLivret getDaoLivret()
	{
		if (daoLivret == null)
		{
			daoLivret = new DaoLivret();
		}
		
		return daoLivret;
	}
	
	public static DaoLog getDaoLog()
	{
		if (daoLog == null)
		{
			daoLog  = new DaoLog();
		}
		
		return daoLog;
	}
	
	public static DaoModule getDaoModule()
	{
		if (daoModule == null)
		{
			daoModule = new DaoModule();
		}
		
		return daoModule;
	}
	
	public static DaoModuleLivret getDaoModuleLivret()
	{
		if (daoModuleLivret == null)
		{
			daoModuleLivret = new DaoModuleLivret();
		}
		
		return daoModuleLivret;
	}
	
	public static DaoPeriode getDaoPeriode()
	{
		if (daoPeriode == null)
		{
			daoPeriode = new DaoPeriode();
		}
		
		return daoPeriode;
	}
	
	public static DaoPeriodeLivret getDaoPeriodeLivret()
	{
		if (daoPeriodeLivret == null)
		{
			daoPeriodeLivret = new DaoPeriodeLivret();
		}
		
		return daoPeriodeLivret;
	}
	
	
	public static DaoProjetProLivret getDaoProjetProLivret()
	{
		if (daoProjetProLivret == null)
		{
			daoProjetProLivret = new DaoProjetProLivret();
		}
		
		return daoProjetProLivret;
	}
	
	public static DaoResultatParcoursLivret getDaoResultatParcoursLivret()
	{
		if (daoResultatParcoursLivret == null)
		{
			daoResultatParcoursLivret = new DaoResultatParcoursLivret();
		}
		
		return daoResultatParcoursLivret;
	}
	
	public static DaoRole getDaoRole()
	{
		if (daoRole == null)
		{
			daoRole = new DaoRole();
		}
		
		return daoRole;
	}
	
	public static DaoSequence getDaoSequence()
	{
		if (daoSequence == null)
		{
			daoSequence = new DaoSequence();
		}
		
		return daoSequence;
	}
	
	public static DaoSequenceLivret getDaoSequenceLivret()
	{
		if (daoSequenceLivret == null)
		{
			daoSequenceLivret = new DaoSequenceLivret();
		}
		
		return daoSequenceLivret;
	}
	
	
	public static DaoSpecialisation getDaoSpecialisation()
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
	
	public static DaoTypePeriode getDaoTypePeriode()
	{
		if (daoTypePeriode == null)
		{
			daoTypePeriode = new DaoTypePeriode();
		}
		
		return daoTypePeriode;
	}
	
	public static DaoTypePeriodeLivret getDaoTypePeriodeLivret()
	{
		if (daoTypePeriodeLivret == null)
		{
			daoTypePeriodeLivret = new DaoTypePeriodeLivret();
		}
		
		return daoTypePeriodeLivret;
	}
	
	public static DaoUtilisateur getDaoUtilisateur()
	{
		if (daoUtilisateur == null)
		{
			daoUtilisateur = new DaoUtilisateur();
		}
		
		return daoUtilisateur;
	}
	
	
}
