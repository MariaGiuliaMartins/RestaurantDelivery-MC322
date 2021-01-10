package View;

import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter; 

public class UserRegisterForm 
	extends JFrame 
	implements ActionListener { 

	// Components of the Form 
	private Container c; 
	private JLabel title; 
	private JLabel name; 
  private JTextField tname;
  private JLabel cpf; 
  private JTextField tcpf;
  private JLabel email; 
  private JTextField temail;   
	private JLabel mno; 
  private JTextField tmno;
  private JLabel street; 
  private JTextField tstreet;
  private JLabel cep; 
  private JTextField tcep;
  private JLabel number; 
  private JTextField tnumber;
  private JLabel district; 
  private JTextField tdistrict;
  private JLabel state; 
  private JTextField tstate;
  private JLabel city; 
  private JTextField tcity;
  private JLabel password; 
  private JPasswordField passwordField; 
	private JLabel gender; 
	private JRadioButton male; 
	private JRadioButton female; 
	private ButtonGroup gengp; 
	private JButton sub; 
	private JButton reset; 
	private JTextArea tout; 
	private JLabel res; 
	private JTextArea resadd; 

	// constructor, to initialize the components 
	// with default values. 
	public UserRegisterForm() 
	{ 
		setTitle("Formulário para registro de usuários"); 
		setBounds(300, 90, 900, 600); 
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		setResizable(false); 

		c = getContentPane(); 
		c.setLayout(null); 

		title = new JLabel("Formulário para registro de usuários"); 
		title.setFont(new Font("Arial", Font.PLAIN, 30)); 
		title.setSize(800, 30); 
		title.setLocation(175, 30); 
		c.add(title); 

		name = new JLabel("Nome"); 
		name.setFont(new Font("Arial", Font.PLAIN, 20)); 
		name.setSize(100, 20); 
		name.setLocation(100, 100); 
		c.add(name); 

		tname = new JTextField(); 
		tname.setFont(new Font("Arial", Font.PLAIN, 15)); 
		tname.setSize(190, 20); 
		tname.setLocation(200, 100); 
    c.add(tname); 
    
    cpf = new JLabel("CPF"); 
		cpf.setFont(new Font("Arial", Font.PLAIN, 20)); 
		cpf.setSize(100, 20); 
		cpf.setLocation(100, 135); 
		c.add(cpf); 

		tcpf = new JTextField(); 
		tcpf.setFont(new Font("Arial", Font.PLAIN, 15)); 
		tcpf.setSize(190, 20); 
		tcpf.setLocation(200, 135); 
    c.add(tcpf); 
    
    email = new JLabel("E-mail"); 
		email.setFont(new Font("Arial", Font.PLAIN, 20)); 
		email.setSize(100, 20); 
		email.setLocation(100, 165); 
		c.add(email); 

		temail = new JTextField(); 
		temail.setFont(new Font("Arial", Font.PLAIN, 15)); 
		temail.setSize(190, 20); 
		temail.setLocation(200, 165); 
    c.add(temail); 
    
    password = new JLabel("Senha"); 
		password.setFont(new Font("Arial", Font.PLAIN, 20)); 
		password.setSize(100, 20); 
		password.setLocation(100, 190); 
		c.add(password); 

		passwordField = new JPasswordField();
    passwordField.setFont(new Font("Arial", Font.PLAIN, 15));
    passwordField.setSize(190, 20); 
		passwordField.setLocation(200, 190); 
    c.add(passwordField);

    gender = new JLabel("Sexo"); 
		gender.setFont(new Font("Arial", Font.PLAIN, 20)); 
		gender.setSize(100, 20); 
		gender.setLocation(100, 215); 
		c.add(gender); 

		male = new JRadioButton("Masculino"); 
		male.setFont(new Font("Arial", Font.PLAIN, 15)); 
		male.setSelected(true); 
		male.setSize(100, 20); 
		male.setLocation(200, 215); 
		c.add(male); 

		female = new JRadioButton("Feminino"); 
		female.setFont(new Font("Arial", Font.PLAIN, 15)); 
		female.setSelected(false); 
		female.setSize(130, 20); 
		female.setLocation(300, 215); 
		c.add(female); 

		gengp = new ButtonGroup(); 
		gengp.add(male); 
		gengp.add(female); 

		mno = new JLabel("Telefone"); 
		mno.setFont(new Font("Arial", Font.PLAIN, 20)); 
		mno.setSize(100, 20); 
		mno.setLocation(100, 240); 
		c.add(mno); 

		tmno = new JTextField(); 
		tmno.setFont(new Font("Arial", Font.PLAIN, 15)); 
		tmno.setSize(190, 20); 
		tmno.setLocation(200, 240); 
    c.add(tmno); 
    
    cep = new JLabel("CEP"); 
		cep.setFont(new Font("Arial", Font.PLAIN, 20)); 
		cep.setSize(100, 20); 
		cep.setLocation(100, 265); 
		c.add(cep); 

		tcep = new JTextField(); 
		tcep.setFont(new Font("Arial", Font.PLAIN, 15)); 
		tcep.setSize(190, 20); 
		tcep.setLocation(200, 265); 
    c.add(tcep); 

    street = new JLabel("Rua"); 
		street.setFont(new Font("Arial", Font.PLAIN, 20)); 
		street.setSize(100, 20); 
		street.setLocation(100, 290); 
		c.add(street); 

		tstreet = new JTextField(); 
		tstreet.setFont(new Font("Arial", Font.PLAIN, 15)); 
		tstreet.setSize(190, 20); 
		tstreet.setLocation(200, 290); 
    c.add(tstreet); 
    
    number = new JLabel("Número"); 
		number.setFont(new Font("Arial", Font.PLAIN, 20)); 
		number.setSize(100, 20); 
		number.setLocation(100, 315); 
		c.add(number); 

		tnumber = new JTextField(); 
		tnumber.setFont(new Font("Arial", Font.PLAIN, 15)); 
		tnumber.setSize(190, 20); 
		tnumber.setLocation(200, 315); 
    c.add(tnumber); 
    
    district = new JLabel("Bairro"); 
		district.setFont(new Font("Arial", Font.PLAIN, 20)); 
		district.setSize(100, 20); 
		district.setLocation(100, 340); 
		c.add(district); 

		tdistrict = new JTextField(); 
		tdistrict.setFont(new Font("Arial", Font.PLAIN, 15)); 
		tdistrict.setSize(190, 20); 
		tdistrict.setLocation(200, 340); 
    c.add(tdistrict); 
    
    city = new JLabel("Cidade"); 
		city.setFont(new Font("Arial", Font.PLAIN, 20)); 
		city.setSize(100, 20); 
		city.setLocation(100, 365); 
		c.add(city); 

		tcity = new JTextField(); 
		tcity.setFont(new Font("Arial", Font.PLAIN, 15)); 
		tcity.setSize(190, 20); 
		tcity.setLocation(200, 365); 
		c.add(tcity); 

		state = new JLabel("Estado"); 
		state.setFont(new Font("Arial", Font.PLAIN, 20)); 
		state.setSize(100, 20); 
		state.setLocation(100, 390); 
		c.add(state); 

		tstate = new JTextField(); 
		tstate.setFont(new Font("Arial", Font.PLAIN, 15)); 
		tstate.setSize(190, 20); 
		tstate.setLocation(200, 390);
		c.add(tstate); 

		sub = new JButton("Finalizar"); 
		sub.setFont(new Font("Arial", Font.PLAIN, 15)); 
		sub.setSize(100, 20); 
		sub.setLocation(160, 450); 
		sub.addActionListener(this); 
		c.add(sub); 

		reset = new JButton("Resetar"); 
		reset.setFont(new Font("Arial", Font.PLAIN, 15)); 
		reset.setSize(100, 20); 
		reset.setLocation(270, 450); 
		reset.addActionListener(this); 
		c.add(reset); 

		tout = new JTextArea(); 
		tout.setFont(new Font("Arial", Font.PLAIN, 15)); 
		tout.setSize(300, 400); 
		tout.setLocation(500, 100); 
		tout.setLineWrap(true); 
		tout.setEditable(false); 
		c.add(tout); 

		res = new JLabel(""); 
		res.setFont(new Font("Arial", Font.PLAIN, 20)); 
		res.setSize(500, 25); 
		res.setLocation(100, 500); 
		c.add(res); 

		resadd = new JTextArea(); 
		resadd.setFont(new Font("Arial", Font.PLAIN, 15)); 
		resadd.setSize(200, 75); 
		resadd.setLocation(580, 175); 
		resadd.setLineWrap(true); 
		c.add(resadd); 

		setVisible(true); 
	} 

	// method actionPerformed() 
	// to get the action performed 
	// by the user and act accordingly 
	public void actionPerformed(ActionEvent e) 
	{ 
		if (e.getSource() == sub) { 
				String data1; 
				String data 
					= "Nome : "
          + tname.getText() + "\n"
          + "CPF : "
          + tcpf.getText() + "\n"
          + "E-mail : "
					+ temail.getText() + "\n"
					+ "Telefone : "
					+ tmno.getText() + "\n"; 
				if (male.isSelected()) 
					data1 = "Gender : Male"
							+ "\n"; 
				else
					data1 = "Gender : Female"
              + "\n"; 
              
        String data2 = "CEP : " + tcep.getText()
          + "Rua : "
          + tstreet.getText() + "\n"
          + "Número : "
          + tnumber.getText() + "\n"
          + "Bairro : "
          + tdistrict.getText() + "\n"
          + "Cidade : "
          + tcity.getText() + "\n"
          + "Estado : "
					+ tstate.getText() + "\n";
				
				tout.setText(data + data1 + data2); 
				tout.setEditable(false); 
				
				File file = new File("src/data/usuarios.txt");
				
				try {
					if (!file.exists()){
						file.createNewFile();
					}

					String finalUserData = tname.getText() + ',' + tcpf.getText() + "," + temail.getText() + "," + 
															 tmno.getText() + "," + (male.isSelected() ? "Masculino" : "Feminino") + ',' 
															 + tstreet.getText() + "," + tnumber.getText() + "," + tdistrict.getText()
															 + "," + tcity.getText() + "," + tstate.getText() + "\n";

					PrintWriter out = new PrintWriter(new FileWriter(file, true));

					out.append(finalUserData);
					out.close();

					res.setText("Registrado com sucesso!"); 
				} catch(IOException ex){
					res.setText("Falha no registro!");
				}
			} 

		else if (e.getSource() == reset) { 
			String def = ""; 
			tname.setText(def); 
			tmno.setText(def); 
			res.setText(def); 
      tout.setText(def); 
      passwordField.setText(def);
      temail.setText(def);
      tcpf.setText(def);
      tstreet.setText(def);
      tcep.setText(def);
      tnumber.setText(def);
      tdistrict.setText(def);
      tstate.setText(def);
      tcity.setText(def);
			resadd.setText(def); 
		} 
	} 
} 
