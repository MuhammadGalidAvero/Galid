package uap1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class UAP extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textHargaBarang;
	private JTextField textQuantity;
	private JTextField textTotalHarga;
	private JTextField textTotalBayar;
	private JTextField textKembalian;
	private JTable table;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UAP frame = new UAP();
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
	public UAP() {
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 620);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel JudulProgram = new JLabel("GAMING SPACE");
		JudulProgram.setHorizontalAlignment(SwingConstants.CENTER);
		JudulProgram.setFont(new Font("Stencil", Font.BOLD, 28));
		JudulProgram.setBounds(0, 10, 626, 40);
		contentPane.add(JudulProgram);
		
		JLabel lblNamaBarang = new JLabel("Nama Barang");
		lblNamaBarang.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblNamaBarang.setBounds(39, 60, 158, 22);
		contentPane.add(lblNamaBarang);
		
		
		JLabel lblHargaBarang = new JLabel("Harga Barang (Rp)");
		lblHargaBarang.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblHargaBarang.setBounds(39, 103, 158, 22);
		contentPane.add(lblHargaBarang);
		
		JLabel lblBanyak = new JLabel("Quantity");
		lblBanyak.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblBanyak.setBounds(39, 147, 158, 22);
		contentPane.add(lblBanyak);
		
		JLabel lblTotal = new JLabel("Total Harga");
		lblTotal.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblTotal.setBounds(123, 379, 122, 22);
		contentPane.add(lblTotal);
		
		JLabel lblBayar = new JLabel("Total Bayar");
		lblBayar.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblBayar.setBounds(123, 424, 122, 22);
		contentPane.add(lblBayar);
		
		JLabel lblKembalian = new JLabel("Kembalian");
		lblKembalian.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblKembalian.setBounds(123, 504, 122, 22);
		contentPane.add(lblKembalian);
		
		textHargaBarang = new JTextField();
		textHargaBarang.setColumns(10);
		textHargaBarang.setBounds(238, 106, 230, 30);
		contentPane.add(textHargaBarang);
		
		textQuantity = new JTextField();
		textQuantity.setColumns(10);
		textQuantity.setBounds(238, 150, 122, 30);
		contentPane.add(textQuantity);
		
		
		textTotalHarga = new JTextField();
		textTotalHarga.setColumns(10);
		textTotalHarga.setBounds(238, 371, 230, 30);
		contentPane.add(textTotalHarga);
		
		textTotalBayar = new JTextField();
		textTotalBayar.setColumns(10);
		textTotalBayar.setBounds(238, 423, 230, 30);
		contentPane.add(textTotalBayar);
		
		textKembalian = new JTextField();
		textKembalian.setColumns(10);
		textKembalian.setBounds(238, 503, 230, 30);
		contentPane.add(textKembalian);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 200, 616, 2);
		contentPane.add(separator);
		
		JButton btnBayar = new JButton("Bayar");
		btnBayar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int TotalHarga = Integer.parseInt(textTotalHarga.getText().substring(3));
				int TotalBayar = Integer.parseInt(textTotalBayar.getText());		
				int Kembalian = TotalBayar - TotalHarga;
				textKembalian.setText(" RP" + Kembalian);
				}
		});
		btnBayar.setFont(new Font("Tempus Sans ITC", Font.BOLD, 16));
		btnBayar.setBounds(296, 463, 103, 30);
		contentPane.add(btnBayar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("");
		scrollPane.setBounds(20, 212, 593, 135);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFont(new Font("Tempus Sans ITC", Font.BOLD, 16));
		table.setToolTipText("");
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nama Barang", "Harga Barang", "Quantity", "SubTotal"
			}
		));
		scrollPane.setViewportView(table);
		
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tes= comboBox.getSelectedItem().toString();
				
				if (tes == "FIFA 24") {
					textHargaBarang.setText("200000");
				} else if (tes == "MotoGP23") {
					textHargaBarang.setText("250000");
				} else if (tes == "Elden Ring") {
					textHargaBarang.setText("600000");
				} else if (tes == "GTA 5") {
					textHargaBarang.setText("150000");
				} else if (tes == "God of War") {
					textHargaBarang.setText("300000");
				}
				
			}
		});
		comboBox.setFont(new Font("Tempus Sans ITC", Font.BOLD, 16));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Pilih Barang", "FIFA 24", "MotoGP23", "Elden Ring", "GTA 5", "God of War"}));
		comboBox.setBounds(238, 63, 230, 30);
		contentPane.add(comboBox);
		
		JButton btnInput = new JButton("Input");
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String NamaBarang = comboBox.getSelectedItem().toString();
			int QTY = Integer.parseInt(textQuantity.getText());
			int HargaBarang = Integer.parseInt(textHargaBarang.getText());
			int SubTotal = HargaBarang * QTY;
			
			DefaultTableModel tbl = (DefaultTableModel) table.getModel();
			
			tbl.addRow (new Object[]{
				NamaBarang,
				"RP " + HargaBarang,
				QTY,
				"RP " + SubTotal
			});
			int TotalHarga = 0;
			for(int i = 0; i<table.getRowCount(); i++) {
				TotalHarga += Integer.parseInt(table.getValueAt(i, 3).toString().substring(3));
			}
			textTotalHarga.setText("Rp " + TotalHarga);
			textQuantity.setText(null);
			}
			
		});
		btnInput.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
		btnInput.setBounds(370, 149, 98, 31);
		contentPane.add(btnInput);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox.setSelectedIndex(0);
				textHargaBarang.setText("");
				textQuantity.setText("");
				textTotalHarga.setText("");
				textTotalBayar.setText("");
				textKembalian.setText("");
				
				DefaultTableModel tbl = (DefaultTableModel) table.getModel();
				while (table.getRowCount() > 0) {
				    tbl.removeRow(0);
				}

				
			}
		});
		btnReset.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
		btnReset.setBounds(192, 543, 103, 30);
		contentPane.add(btnReset);
		
		JButton btnExit = new JButton("Exit\r\n");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
		btnExit.setBounds(404, 543, 103, 30);
		contentPane.add(btnExit);
		
		
		
		
	}
}
