package utilisateur;

import java.util.ArrayList;


public class Module
{
	private String description;
	private ArrayList<Sequence> sequence = new ArrayList<Sequence>();
	
	public Module(String str)
	{
		description = str;
	}
	
	public void ajouterSeq(Sequence sq)
	{
		sequence.add(sq);
	}

	public String getDescription()
	{
		return description;
	}

	public ArrayList<Sequence> getSequence()
	{
		return sequence;
	}
	
}
