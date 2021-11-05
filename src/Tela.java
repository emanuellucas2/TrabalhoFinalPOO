

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class Tela extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtNome;
	private JTextField txtTipoDoSensor;
	private JLabel lblRegistreUmNovo;
	private JLabel lblSensor;
	private JTextField txtNomeDoArquivo;
	private JButton btnSalvar;
	private JLabel lblId;
	private JLabel lblNome;
	private JLabel lblTipoDoSensor;
	private JLabel lblNomeDoArquivo;
	private JButton btnAdicionar;
	private JComboBox<String> comboBox;
	private JButton btnTrocar;
	private JButton btnRemover;
	private Sensor sensorAtual;
	private JPanel childpanel;
	private String caminho = "/home/emanuel/Documentos/";


	public Tela() {
		
		this.sensorAtual = null;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		childpanel = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtId = new JTextField();
		txtId.setBounds(250, 500, 125, 25);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setBounds(375, 500, 125, 25);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtTipoDoSensor = new JTextField();
		txtTipoDoSensor.setBounds(500, 500, 125, 25);
		contentPane.add(txtTipoDoSensor);
		txtTipoDoSensor.setColumns(10);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(625, 500, 125, 25);
		contentPane.add(btnAdicionar);
		
		lblRegistreUmNovo = new JLabel("Registre um novo sensor:");
		lblRegistreUmNovo.setBounds(250, 450, 200, 15);
		contentPane.add(lblRegistreUmNovo);
		
		lblSensor = new JLabel("Sensor");
		lblSensor.setBounds(5, 0, 200, 30);
		contentPane.add(lblSensor);
		
		txtNomeDoArquivo = new JTextField();
		txtNomeDoArquivo.setBounds(625, 50, 125, 15);
		contentPane.add(txtNomeDoArquivo);
		txtNomeDoArquivo.setColumns(10);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(625, 75, 125, 25);
		contentPane.add(btnSalvar);
		
		lblId = new JLabel("Id:");
		lblId.setBounds(250, 475, 70, 15);
		contentPane.add(lblId);
		
		lblNome = new JLabel("Nome:");
		lblNome.setBounds(375, 475, 70, 15);
		contentPane.add(lblNome);
		
		lblTipoDoSensor = new JLabel("Tipo do sensor:");
		lblTipoDoSensor.setBounds(500, 475, 120, 15);
		contentPane.add(lblTipoDoSensor);
		
		lblNomeDoArquivo = new JLabel("Nome do Arquivo:");
		lblNomeDoArquivo.setBounds(625, 25, 150, 15);
		contentPane.add(lblNomeDoArquivo);
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(5, 475, 180, 25);
		contentPane.add(comboBox);
		
		btnTrocar = new JButton("Trocar");
		btnTrocar.setBounds(5, 500, 180, 25);
		contentPane.add(btnTrocar);
		
		btnRemover = new JButton("Remover");
		btnRemover.setBounds(625, 525, 125, 25);
		contentPane.add(btnRemover);
		
		
		
	}
	

	public String getCaminho() {
		return caminho;
	}


	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}


	public JTextField getTxtId() {
		return txtId;
	}

	public void setTxtId(JTextField txtId) {
		this.txtId = txtId;
	}

	public JTextField getTxtNome() {
		return txtNome;
	}

	public void setTxtNome(JTextField txtNome) {
		this.txtNome = txtNome;
	}

	public JTextField getTxtTipoDoSensor() {
		return txtTipoDoSensor;
	}

	public void setTxtTipoDoSensor(JTextField txtTipoDoSensor) {
		this.txtTipoDoSensor = txtTipoDoSensor;
	}

	public JLabel getLblRegistreUmNovo() {
		return lblRegistreUmNovo;
	}

	public void setLblRegistreUmNovo(JLabel lblRegistreUmNovo) {
		this.lblRegistreUmNovo = lblRegistreUmNovo;
	}

	public JLabel getLblSensor() {
		return lblSensor;
	}

	public void setLblSensor(JLabel lblSensor) {
		this.lblSensor = lblSensor;
	}

	public JTextField getTxtNomeDoArquivo() {
		return txtNomeDoArquivo;
	}

	public void setTxtNomeDoArquivo(JTextField txtNomeDoArquivo) {
		this.txtNomeDoArquivo = txtNomeDoArquivo;
	}

	public JButton getBtnSalvar() {
		return btnSalvar;
	}

	public void setBtnSalvar(JButton btnSalvar) {
		this.btnSalvar = btnSalvar;
	}

	public JLabel getLblId() {
		return lblId;
	}

	public void setLblId(JLabel lblId) {
		this.lblId = lblId;
	}

	public JLabel getLblNome() {
		return lblNome;
	}

	public void setLblNome(JLabel lblNome) {
		this.lblNome = lblNome;
	}

	public JLabel getLblTipoDoSensor() {
		return lblTipoDoSensor;
	}

	public void setLblTipoDoSensor(JLabel lblTipoDoSensor) {
		this.lblTipoDoSensor = lblTipoDoSensor;
	}

	public JLabel getLblNomeDoArquivo() {
		return lblNomeDoArquivo;
	}


	public void setLblNomeDoArquivo(JLabel lblNomeDoArquivo) {
		this.lblNomeDoArquivo = lblNomeDoArquivo;
	}

	public JButton getBtnAdicionar() {
		return btnAdicionar;
	}

	public void setBtnAdicionar(JButton btnAdicionar) {
		this.btnAdicionar = btnAdicionar;
	}

	public JComboBox<String> getComboBox() {
		return comboBox;
	}

	public void setComboBox(JComboBox<String> comboBox) {
		this.comboBox = comboBox;
	}

	public JButton getBtnTrocar() {
		return btnTrocar;
	}

	public void setBtnTrocar(JButton btnTrocar) {
		this.btnTrocar = btnTrocar;
	}

	public JButton getBtnRemover() {
		return btnRemover;
	}

	public void setBtnRemover(JButton btnRemover) {
		this.btnRemover = btnRemover;
	}

	public Sensor getSensorAtual() {
		return sensorAtual;
	}

	public void setSensorAtual(Sensor sensorAtual) {
		this.sensorAtual = sensorAtual;
	}

	public void setG(Grafico g) {
		
		
		childpanel = g.getJanela();
		childpanel.setBounds(5, 30, 600, 400);
		contentPane.add(childpanel);
		

	}
	
}
