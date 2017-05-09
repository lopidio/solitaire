package br.com.guigasgame.solitaire.gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import br.com.guigasgame.solitaire.config.ConfigFile;
import br.com.guigasgame.solitaire.score.AwsApiGatewayScoreRepository;
import br.com.guigasgame.solitaire.score.ScoreModel;
import br.com.guigasgame.solitaire.score.ScoreRepository;
import br.com.guigasgame.solitaire.score.SerializerScoreRepository;

public class MenuOptionsFrame extends JFrame
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
	private boolean newGameRequired;
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
					
					MenuOptionsFrame frame = new MenuOptionsFrame();
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
	public MenuOptionsFrame()
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
//		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.NONE);

		setBounds(100, 100, 600, 450);
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(300,  550));
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		
//		GridBagLayout gbpanel = new GridBagLayout();
//		panel.setLayout(null);

		createButtons();
		createSpritesChanger();
		createPlayerNameComponents();
		createRadioButtons();
		createRecordsTable();
		
		setContentPane(panel);
		pack();
		setVisible(true);
	}

	private void createSpritesChanger()
	{
		playerLabel = new JLabel("Card Cover");
		panel.add(playerLabel);

		String[] cardBackStrings = new String[]{"Woman", "Flower", "Blue Pattern", "Pink Pattern", "Gui Logo"}; //get month names
		
		JComboBox<?> comboBox = new JComboBox<String>(cardBackStrings);
		int cardCoverIndex = Integer.parseInt(confFile.getValue("cardCover"));
		comboBox.setSelectedIndex(cardCoverIndex);
		comboBox.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				confFile.setValue("cardCover", String.valueOf(comboBox.getSelectedIndex()));
			}
		});
		
		panel.add(comboBox);
	}

	private void createRecordsTable()
	{
		localRecordsTable = createRecordsTable(new SerializerScoreRepository());
		if (null != localRecordsTable)
		{
			localRecordsTable.setToolTipText("Local Records");
			JScrollPane scrollLocalTable = new JScrollPane(localRecordsTable);
			panel.add(scrollLocalTable);
			scrollLocalTable.setPreferredSize(new Dimension(300, 210));
		}
		
		onlineRecordsTable = createRecordsTable(new AwsApiGatewayScoreRepository());
		if (null != onlineRecordsTable)
		{
			onlineRecordsTable.setToolTipText("Online Records");
			JScrollPane scrollOnlineTable = new JScrollPane(onlineRecordsTable);
			panel.add(scrollOnlineTable);
			scrollOnlineTable.setPreferredSize(new Dimension(300, 210));
		}
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
		btnResume.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				dispose();
			}
		});

		panel.add(btnResume);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});
		panel.add(btnQuit);
		
		JButton btnNewGame = new JButton("New Game");
		btnNewGame.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				newGameRequired = true;
				dispose();
			}
		});
		panel.add(btnNewGame);
	}

	private JTable createRecordsTable(ScoreRepository repository)
	{
		ScoreTableTransformer table = new ScoreTableTransformer();

		List<ScoreModel> top = repository.getTop(50);
		if (top != null)
		{
			String[][] dataRecords = table.perform(top);
			String[] headerRecords = table.getHeaders();
			JTable recordsTable = new JTable(dataRecords, headerRecords){
				private static final long serialVersionUID = 1L;
				
				@Override
				public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
					Component component = super.prepareRenderer(renderer, row, column);
					int rendererWidth = component.getPreferredSize().width;
					TableColumn tableColumn = getColumnModel().getColumn(column);
					tableColumn.setPreferredWidth(Math.min(rendererWidth + getIntercellSpacing().width, tableColumn.getPreferredWidth()));
					return component;
				}
			};
			recordsTable.setRowHeight(18);
			return recordsTable;
		}
		return null;
	}

	public boolean requiresNewGame()
	{
		return newGameRequired;
	}
}
