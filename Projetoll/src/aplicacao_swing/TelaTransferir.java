package aplicacao_swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import fachada.Fachada;

public class TelaTransferir extends JFrame {
	private JPanel contentPane;
	private JLabel lblNome;
	private JTextField textField;
	private JTextField textFieldD;
	private JTextField textFieldV;
	private JButton btnTranferir;
	private JLabel lblmsg;

	/**
	 * Create the application.
	 */
	public TelaTransferir() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setTitle("Transferir");
		setBounds(100, 100, 345, 175);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		lblNome = new JLabel("cpf:");
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
//		lblNome.setBounds(10, 29, 50, 14);
		lblNome.setBounds(20, 8, 69, 14);
		contentPane.add(this.lblNome);
		
		textField = new JTextField();
		textField.setBounds(99, 8, 86, 20);
		contentPane.add(this.textField);
		
		lblNome = new JLabel("chavePiks:");
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setBounds(20, 36, 69, 14);
		contentPane.add(this.lblNome);
		
		textFieldD = new JTextField();
		textFieldD.setBounds(99, 33, 86, 20);
		contentPane.add(this.textFieldD);
		
		lblNome = new JLabel("valor:");
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setBounds(20, 61, 69, 14);
		contentPane.add(this.lblNome);
		
		textFieldV = new JTextField();
		textFieldV.setBounds(99, 61, 86, 20);
		contentPane.add(this.textFieldV);
		
		/* SET COLUMNS */
		
		textField.setColumns(10);
		textFieldD.setColumns(10);
		textFieldV.setColumns(10);
		
		btnTranferir = new JButton("Transferir");
		btnTranferir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String cpf = textField.getText();
					String chave = textFieldD.getText();
					double valor = Double.parseDouble( textFieldV.getText() );
					Fachada.transferir(cpf, chave, valor);
					
					lblmsg.setText("Transferência Realizada");
				} catch (Exception e) {
					lblmsg.setText(e.getMessage());
				}
			}
		});
		
		btnTranferir.setBounds(200, 33, 95, 23);
		contentPane.add(this.btnTranferir);
		
		lblmsg = new JLabel("Mensagem");
		lblmsg.setBounds(19, 111, 294, 14);
		contentPane.add(this.lblmsg);

	}
}
