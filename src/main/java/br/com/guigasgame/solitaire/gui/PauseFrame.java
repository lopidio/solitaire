package br.com.guigasgame.solitaire.gui;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import br.com.guigasgame.solitaire.score.AwsApiGatewayScoreRepository;
import br.com.guigasgame.solitaire.score.ScoreRepository;
import br.com.guigasgame.solitaire.score.SerializerScoreRepository;

public class PauseFrame extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JRadioButton animationButton;
	private JRadioButton soundButton;
	private JTextField name;
	private JLabel playerLabel;
	private JButton btnResume;
	private JTable localRecordsTable;
	private JTable onlineRecordsTable;
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
		super("Options");
		try
		{
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		}
		catch (ClassNotFoundException | InstantiationException | IllegalAccessException
		        | UnsupportedLookAndFeelException e)
		{
			e.printStackTrace();
		}

		setLocationRelativeTo(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setResizable(false);
		setContentPane(panel);
		setBounds(100, 100, 600, 450);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		btnResume = new JButton("Resume");
		btnResume.setBounds(10, 30, 120, 25);
		panel.add(btnResume);
		
		GridBagLayout gbpanel = new GridBagLayout();
//		GridBagConstraints gbcpanel = new GridBagConstraints();
		panel.setLayout(gbpanel);

		animationButton = new JRadioButton("animation");
		panel.add(animationButton);

		soundButton = new JRadioButton("sound");
		panel.add(soundButton);


		playerLabel = new JLabel("Player Name");
		panel.add(playerLabel);

		name = new JTextField();
		name.setPreferredSize(new Dimension(150, 20));
		panel.add(name);
		
		localRecordsTable = createRecordsTable(new SerializerScoreRepository());
		localRecordsTable.setToolTipText("Local Records");
		JScrollPane scplocalRecords = new JScrollPane(localRecordsTable);
		panel.add(scplocalRecords);
		
		onlineRecordsTable = createRecordsTable(new AwsApiGatewayScoreRepository());
		onlineRecordsTable.setToolTipText("Online Records");
		JScrollPane scponlineRecords = new JScrollPane(onlineRecordsTable);
//		panel.add(scponlineRecords);
		
		
		setContentPane(panel);
		pack();
		setVisible(true);
	}

	private JTable createRecordsTable(ScoreRepository repository)
	{
		ScoreTableTransformer table = new ScoreTableTransformer();

		String[][] dataRecords = table.perform(repository.getTop(10));
		String[] headerRecords = table.getHeaders();;
		JTable recordsTable = new JTable(dataRecords, headerRecords);
		recordsTable.setRowHeight(18);
		return recordsTable;
	}
}
