package br.com.guigasgame.solitaire.gui;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToggleButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PauseFrame extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					PauseFrame frame = new PauseFrame();
					frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PauseFrame()
	{
		setLocationRelativeTo(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.setBounds(12, 32, 117, 25);
		contentPane.add(btnContinuar);
		
		JToggleButton tglbtnEfeitosSonoros = new JToggleButton("Efeitos Sonoros");
		tglbtnEfeitosSonoros.setBounds(271, 174, 167, 25);
		contentPane.add(tglbtnEfeitosSonoros);
		
		table = new JTable();
		table.setName("Tabela");
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{1123, null, null, null, null},
			},
			new String[] {
				"position", "name", "score", "time", "moves"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Integer.class, Float.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.setRowSelectionAllowed(false);
		table.setBounds(57, 141, 120, 80);
		contentPane.add(table);
	}
}
