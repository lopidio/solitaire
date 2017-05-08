package br.com.guigasgame.solitaire.gui;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import br.com.guigasgame.solitaire.config.ConfigFile;
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
	private JTable localRecordsTable;
	private JTable onlineRecordsTable;
	private ConfigFile confFile;
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
		confFile = ConfigFile.getInstance();
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 600, 450);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		
		GridBagLayout gbpanel = new GridBagLayout();
		panel.setLayout(gbpanel);

		createButtons();
		createRadioButtons();
		createPlayerNameComponents();
		createSpritesChanger();
		createRecordsTable();
		
		
		setContentPane(panel);
		pack();
		setVisible(true);
	}

	private void createSpritesChanger()
	{
		String[] cardBackStrings = new String[]{"Woman", "Flower", "Blue Pattern", "Pink Pattern", "Gui Logo"}; //get month names
		List<String> backNames = Arrays.asList(cardBackStrings);
		SpinnerListModel cardBackModel = new SpinnerListModel(backNames.toArray());
		JSpinner spinner = new JSpinner(cardBackModel);
		
		int cardCoverIndex = Integer.parseInt(confFile.getValue("cardCover"));
		spinner.setValue(backNames.get(cardCoverIndex));
		spinner.addChangeListener(new ChangeListener()
		{
			@Override
			public void stateChanged(ChangeEvent e)
			{
				confFile.setValue("cardCover", String.valueOf(backNames.indexOf(spinner.getValue())));
			}
		});
		panel.add(spinner);
	}

	private void createRecordsTable()
	{
		localRecordsTable = createRecordsTable(new SerializerScoreRepository());
		localRecordsTable.setToolTipText("Local Records");
		JScrollPane scplocalRecords = new JScrollPane(localRecordsTable);
		panel.add(scplocalRecords);
		
		onlineRecordsTable = createRecordsTable(new AwsApiGatewayScoreRepository());
		onlineRecordsTable.setToolTipText("Online Records");
		JScrollPane scponlineRecords = new JScrollPane(onlineRecordsTable);
		panel.add(scponlineRecords);
	}

	private void createPlayerNameComponents()
	{
		playerLabel = new JLabel("Player Name");
		panel.add(playerLabel);

		name = new JTextField();
		name.setText(confFile.getValue("playerName"));
		name.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				confFile.setValue("playerName", name.getText());				
			}
		});
		name.setPreferredSize(new Dimension(150, 20));
		panel.add(name);
	}

	private void createRadioButtons()
	{
		boolean animationEnabled = Boolean.parseBoolean(confFile.getValue("animationEnabled"));
		animationButton = new JRadioButton("animation");
		animationButton.setSelected(animationEnabled);
		animationButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
		        JRadioButton button = (JRadioButton) e.getSource();
		        confFile.setValue("animationEnabled", String.valueOf(button.isSelected()));
			}
		});
		panel.add(animationButton);

		boolean soundEnabled = Boolean.parseBoolean(confFile.getValue("soundEnabled"));
		soundButton = new JRadioButton("sound");
		soundButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
		        JRadioButton button = (JRadioButton) e.getSource();
		        confFile.setValue("soundEnabled", String.valueOf(button.isSelected()));
			}
		});
		soundButton.setSelected(soundEnabled);
		panel.add(soundButton);
	}

	private void createButtons()
	{
		JButton btnResume = new JButton("Resume");
		panel.add(btnResume);
		
		JButton btnQuit = new JButton("Quit");
		panel.add(btnQuit);

		JButton btnNewGame = new JButton("New Game");
		panel.add(btnNewGame);
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
