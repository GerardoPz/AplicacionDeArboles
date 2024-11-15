package ito;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TJOption {
	//se utiliza el parceo igual que el BufferedReader, se obtiene de cadena por eso se usa el parceo para convertir en dato primitivo
	//el string no se parcea por que el JOpcion es una cadena
	public static byte leerByte(String msje){
		while (true) {
			try {
			return(Byte.parseByte(JOptionPane.showInputDialog(null,msje,"[byte]",JOptionPane.QUESTION_MESSAGE)));
			} catch (NumberFormatException e) {
				TJOption.imprimeError("Solo se admiten enteros positivos y negativos en el rango: "+Byte.MIN_VALUE+"/"+Byte.MAX_VALUE);
			}
		}
		
	}
	public static int leerInt(String msje){
		while (true) {
			try {
				return(Integer.parseInt(JOptionPane.showInputDialog(null,msje,"[int]",JOptionPane.QUESTION_MESSAGE)));
			}catch (NumberFormatException e) {
				TJOption.imprimeError("Solo se admiten enteros positivos y negativos en el rango: "+Integer.MIN_VALUE+"/"+Integer.MAX_VALUE);
			}

		}
		
	}
	public static short leerShort(String msje){
		while (true) {
			try{
				return(Short.parseShort(JOptionPane.showInputDialog(null,msje,"[short]",JOptionPane.QUESTION_MESSAGE)));
			}catch (NumberFormatException e) {
				TJOption.imprimeError("Solo se admiten enteros positivos y negativos en el rango: "+Short.MIN_VALUE+"/"+Short.MAX_VALUE);
			}
		}
		
	}
	public static long leerLong(String msje){
		while (true) {
			try{
		return(Long.parseLong(JOptionPane.showInputDialog(null,msje,"[long]",JOptionPane.QUESTION_MESSAGE)));
			}catch (NumberFormatException e) {
				TJOption.imprimeError("Solo se admiten enteros positivos y negativos en el rango: "+Long.MIN_VALUE+"/"+Long.MAX_VALUE);
			}
		}
	}
	public static float leerFloat(String msje){
		while (true) {
			try{
		return(Float.parseFloat(JOptionPane.showInputDialog(null,msje,"[float]",JOptionPane.QUESTION_MESSAGE)));
			}catch (NumberFormatException e) {
				TJOption.imprimeError("Solo se admiten enteros positivos y negativos en el rango: "+Float.MIN_VALUE+"/"+Float.MAX_VALUE);
			}
		}
	}
	public static double leerDouble(String msje){
		while (true) {
			try{
		return(Double.parseDouble(JOptionPane.showInputDialog(null,msje,"[double]",JOptionPane.QUESTION_MESSAGE)));
			}catch (NumberFormatException e) {
				TJOption.imprimeError("Solo se admiten enteros positivos y negativos en el rango: "+Double.MIN_VALUE+"/"+Double.MAX_VALUE);
			}
		}
	}
	//el string no se parcea por que el JOpcion es una cadena
	public static String leerString(String msje){
		return(JOptionPane.showInputDialog(null,msje,"[string]",JOptionPane.QUESTION_MESSAGE));
	}
	public static char leerChar(String msje){
		return(JOptionPane.showInputDialog(null,msje,"[char]",JOptionPane.QUESTION_MESSAGE)).charAt(0);
	}
	//para imprimir a pantalla
	public static void imprimePantalla(String msje) {
		JOptionPane.showMessageDialog(null,msje,"Salida",JOptionPane.INFORMATION_MESSAGE);
	}
	public static void imprimeError(String msje) {
		JOptionPane.showMessageDialog(null,msje,"Error!",JOptionPane.ERROR_MESSAGE);
	}
	//muestra dos botones de un si o no es como un if-else
	public static int seguirSino() {
		return JOptionPane.showConfirmDialog(null,"Deseas continuar","Capturando datos",JOptionPane.YES_NO_OPTION);
	}
	//muestra opciones
	public static String Genero() {
		String valores[]= {"Masculino","Femenino"};
		return ((String) JOptionPane.showInputDialog(null,"Selecciona","tu genero",JOptionPane.QUESTION_MESSAGE,null,valores,valores[0]));
	}
	//define un espacio = jtextarea
	//define JScrollPane para el cursor
	//Font para el tipo de letra
	public static void panelScroll(String cad) {
		JTextArea areaSalida=new JTextArea(10,60);
		JScrollPane scroller=new JScrollPane(areaSalida);
		Font font=new Font("Arial",Font.BOLD,15);
		areaSalida.setFont(font);
		areaSalida.setForeground(Color.BLUE);
		areaSalida.setBackground(Color.YELLOW);
		areaSalida.append("\n"+cad);
		JOptionPane.showMessageDialog(null,scroller,"Datos: ",JOptionPane.PLAIN_MESSAGE);
	}
	
	public static String desplegablePlanetas() {
		String valores[]={"Mercurio","Venus","La tierra","Marte","Jupiter","Saturno","Urano","Neptuno"};
		String res =(String)JOptionPane.showInputDialog(null,"Planetas","Selecciona un planeta: ",JOptionPane.QUESTION_MESSAGE,null,valores,valores[0]);
		return(res);
	}
	
	public static String desplegableTipos() {
		String valores[]={"Gaseoso","Terrestre","Enano"};
		String res =(String)JOptionPane.showInputDialog(null,"Tipo De planeta","Selecciona un tipo: ",JOptionPane.QUESTION_MESSAGE,null,valores,valores[0]);
		return(res);
	}
	
	public static boolean desplegableObservable() {
		String valores[]={"True","False"};
		String res =(String)JOptionPane.showInputDialog(null,"Planeta obsservable","Selecciona una opcion: ",JOptionPane.QUESTION_MESSAGE,null,valores,valores[0]);
		return(res=="True");
	}
	
	public static String desplegableRaza() {
		String valores[]={"Pastor aleman","Bulldog","Labrador retriever","Husky Siberiano","Poodle","Chihuahua"
				,"Golden retriever","Mastin español","San bernardo"};
		String res =(String)JOptionPane.showInputDialog(null,"Tipo de raza","Selecciona un tipo: ",JOptionPane.QUESTION_MESSAGE,null,valores,valores[0]);
		return(res);
	}
	
	public static String desplegableGato() {
		String valores[]={"Corto","Mediano","Largo","Sin pelo"};
		String res =(String)JOptionPane.showInputDialog(null,"Tipo de pelo","Selecciona un tipo: ",JOptionPane.QUESTION_MESSAGE,null,valores,valores[0]);
		return(res);
	}
	
	public static String desplegableCapas() {
		String valores[]={"Alazan","Albino","Bayo","Blanco","Castaño","mulato o zaimno","Isabelo","Negro","Palomino"
				,"Pio","Ruano","Tordo"};
		String res =(String)JOptionPane.showInputDialog(null,"Tipo de capa","Selecciona un tipo: ",JOptionPane.QUESTION_MESSAGE,null,valores,valores[0]);
		return(res);
	}
	
	public static String desplegableTamañoAnimal() {
		String valores[]={"Gande","Mediando","Chico"};
		String res =(String)JOptionPane.showInputDialog(null,"Tipo de tamaño","Selecciona un tipo: ",JOptionPane.QUESTION_MESSAGE,null,valores,valores[0]);
		return(res);
	}
	
	public static String desplegableNovela() {
		String valores[]={"historica","romantica","policiaca","realista","ciencia ficcion","aventura"};
		String res =(String)JOptionPane.showInputDialog(null,"Tipo de citrico","Selecciona un tipo de novela: ",JOptionPane.QUESTION_MESSAGE,null,valores,valores[0]);
		return(res);
	}
	
	public static String desplegableMateria() {
		String valores[]={"Calculo integral","POO","Algebra lineal","Contabilidad financiera","cultura empresarial","Quimica","Probabilidad y estadistica"};
		String res =(String)JOptionPane.showInputDialog(null,"Materia","Selecciona una materia: ",JOptionPane.QUESTION_MESSAGE,null,valores,valores[0]);
		return(res);
	}

	public static String desplegableAula() {
		String valores[]={"1","2","3","4","5","6","7"};
		String res =(String)JOptionPane.showInputDialog(null,"Numero de aula","Selecciona un numero de aula: ",JOptionPane.QUESTION_MESSAGE,null,valores,valores[0]);
		return(res);
	}
	
	public static String desplegableMes() {
		String valores[]={"Enero","Febrero","Marzo","Abril","Mayo","Junio"};
		String res =(String)JOptionPane.showInputDialog(null,"Mes","Selecciona un mes del año: ",JOptionPane.QUESTION_MESSAGE,null,valores,valores[0]);
		return(res);
	}
	
	public static String desplegaTerrestre() {
		String valores[]={"Militar","Civil"};
		String res =(String)JOptionPane.showInputDialog(null,"Vehiculo","Selecciona un tipo de vehiculo: ",JOptionPane.QUESTION_MESSAGE,null,valores,valores[0]);
		return(res);
	}
	
	public static String desplegaMarino() {
		String valores[]={"Superficie","Submarino"};
		String res =(String)JOptionPane.showInputDialog(null,"Vehiculo","Selecciona un tipo de vehiculo: ",JOptionPane.QUESTION_MESSAGE,null,valores,valores[0]);
		return(res);
	}
	
	public static String desplegaSemestre() {
		String valores[]={"1","2","3","4","5","6","7","8","9","10"};
		String res =(String)JOptionPane.showInputDialog(null,"Semestres","Selecciona un semestre: ",JOptionPane.QUESTION_MESSAGE,null,valores,valores[0]);
		return(res);
	}
	
	public static String desplegaCarrera() {
		String valores[]={"Sistemas","Gestion empresarial","Informatica","Industrial","Quimica",
				"Semiconductores","Electrica","Electronica","Mecanica",};
		String res =(String)JOptionPane.showInputDialog(null,"Carreras","Selecciona una carrera: ",JOptionPane.QUESTION_MESSAGE,null,valores,valores[0]);
		return(res);
	}

	public static String desplegaCargoDirec() {
		String valores[]={"Director","sub-Director","Gerente","Asociado"};
		String res =(String)JOptionPane.showInputDialog(null,"Cargos","Selecciona una cargo directivo: ",JOptionPane.QUESTION_MESSAGE,null,valores,valores[0]);
		return(res);
	}

	public static String desplegaTipoAsociado() {
		String valores[]={"Directivo","Natural"};
		String res =(String)JOptionPane.showInputDialog(null,"Asociados","Selecciona una tipode asociado: ",JOptionPane.QUESTION_MESSAGE,null,valores,valores[0]);
		return(res);
	}
	public static String leeDato() {
        return JOptionPane.showInputDialog("Ingrese la posicion:");
    }

	public static String boton(String menu) {
		String valores[]=menu.split(",");
		int  n;
		n = JOptionPane.showOptionDialog(null,
				" SELECCIONA  DANDO CLICK ", " M E N U", 
				JOptionPane.NO_OPTION, //sin botones
		JOptionPane.QUESTION_MESSAGE,null, // utiliza icono predeterminado
		valores,valores[0]); // botón determinado
		return ( valores[n]);
		}

}