package Graphics;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class TestPerso {
	DossierPersonnelFrame pp ;
	
	public TestPerso()
	{	
	}
	
	public boolean testField()
	{
		Border border = BorderFactory.createLineBorder(Color.red);
		pp.cinField.setBorder(border);
		return true;
	}
}
