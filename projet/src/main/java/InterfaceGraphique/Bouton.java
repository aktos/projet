package InterfaceGraphique;
import javax.swing.JButton;


public class Bouton extends JButton{
	private String name;
	
	public Bouton(String str){
		super(str);
		this.name = str;
	}
	
}
