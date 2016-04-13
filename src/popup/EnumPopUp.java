package popup;

public enum EnumPopUp
{
	CREATION_MODELE_FORMATION(1),
	CREATION_Formation(2),
	CREATION_MODULE(3),
	CREATION_COMPTE(4);
	
	
	private Integer code;
	
	
	EnumPopUp(Integer code)
	{
		this.code = code;
	}

	
}
