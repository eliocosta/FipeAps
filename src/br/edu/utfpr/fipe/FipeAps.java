package br.edu.utfpr.fipe;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FipeAps extends JFrame {

	private JPanel contentPane;

	JComboBox<Marca> comboBox_marca = new JComboBox<Marca>();
	JComboBox<Veiculo> comboBox_modelo = new JComboBox<Veiculo>();
	JComboBox comboBox_ano = new JComboBox();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					
					FipeAps frame = new FipeAps();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FipeAps() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 330, 327);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/******** COMBO MARCAS *************/
		List<Marca> marcas = new DaoFipe().getMarcas();
		
		for(Marca marca : marcas) {
			comboBox_marca.addItem(marca);
		}
		comboBox_marca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Marca item = (Marca)comboBox_marca.getSelectedItem();
							
				List<Veiculo> veiculos = new DaoFipe().getVeiculos(item.getCodigo());
				
				comboBox_modelo.removeAllItems();
				for(Veiculo veiculo : veiculos) {
					comboBox_modelo.addItem(veiculo);
				}
			}	
		});
		comboBox_marca.setBounds(140, 8, 164, 20);
		comboBox_marca.setSelectedIndex(0);
		contentPane.add(comboBox_marca);

		
		/******** COMBO MODELO *************/
		comboBox_modelo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Veiculo veiculo = (Veiculo)comboBox_modelo.getSelectedItem();
				System.out.println(veiculo.getCodigo());
				
//				List<Ano> anos = new DaoFipe().getAnos(veiculo.getCodigo());
//				
//				comboBox_ano.removeAllItems();
//				for(Ano ano : anos) {
//					comboBox_ano.addItem(ano);
//				}
			}
		});
		comboBox_modelo.setBounds(140, 39, 164, 20);
		contentPane.add(comboBox_modelo);
		
		/******** COMBO ANO *************/
		comboBox_ano.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		comboBox_ano.setBounds(140, 70, 164, 20);
		contentPane.add(comboBox_ano);
		
		JLabel lblNewLabel = new JLabel("Marca:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(84, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblModelo.setBounds(78, 43, 52, 14);
		contentPane.add(lblModelo);
		
		JLabel lblAno = new JLabel("Ano:");
		lblAno.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAno.setBounds(88, 73, 42, 14);
		contentPane.add(lblAno);
		
		JLabel lblVeculo = new JLabel("Ve\u00EDculo:");
		lblVeculo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVeculo.setBounds(84, 111, 46, 14);
		contentPane.add(lblVeculo);
		
		JLabel lblAnomodelo = new JLabel("Ano/Modelo:");
		lblAnomodelo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAnomodelo.setBounds(52, 136, 78, 14);
		contentPane.add(lblAnomodelo);
		
		JLabel lblCombustvel = new JLabel("Combust\u00EDvel:");
		lblCombustvel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCombustvel.setBounds(52, 161, 78, 14);
		contentPane.add(lblCombustvel);
		
		JLabel lblValor = new JLabel("Valor:");
		lblValor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblValor.setBounds(84, 186, 46, 14);
		contentPane.add(lblValor);
		
		JLabel lblMsReferncia = new JLabel("M\u00EAs Refer\u00EAncia:");
		lblMsReferncia.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMsReferncia.setBounds(38, 211, 92, 14);
		contentPane.add(lblMsReferncia);
		
		JLabel lblCdigoFipe = new JLabel("C\u00F3digo Fipe:");
		lblCdigoFipe.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCdigoFipe.setBounds(52, 236, 78, 14);
		contentPane.add(lblCdigoFipe);
		
		JLabel resultVeiculo = new JLabel("");
		resultVeiculo.setBounds(140, 111, 46, 14);
		contentPane.add(resultVeiculo);
		
		JLabel resultModelo = new JLabel("");
		resultModelo.setBounds(140, 136, 46, 14);
		contentPane.add(resultModelo);
		
		JLabel resultCombustivel = new JLabel("");
		resultCombustivel.setBounds(140, 161, 46, 14);
		contentPane.add(resultCombustivel);
		
		JLabel resultValor = new JLabel("");
		resultValor.setBounds(140, 186, 46, 14);
		contentPane.add(resultValor);
		
		JLabel resultMes = new JLabel("");
		resultMes.setBounds(140, 211, 46, 14);
		contentPane.add(resultMes);
		
		JLabel resultCodigo = new JLabel("");
		resultCodigo.setBounds(140, 236, 46, 14);
		contentPane.add(resultCodigo);
	}
}
