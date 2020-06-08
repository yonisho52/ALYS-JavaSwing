package view;

import java.awt.EventQueue;
import java.util.Observable;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JList;

public class SearchDetailsView extends Observable {
	
	ShowAllApartmentView showAllApartmentView;

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchDetailsView window = new SearchDetailsView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	
	public SearchDetailsView(ShowAllApartmentView showAllApartmentView) {
	
		this.showAllApartmentView = showAllApartmentView;
		initialize();
	}
	public SearchDetailsView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 653, 477);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel mostSearchedApartmentsLabel = new JLabel("\u05D4\u05D3\u05D9\u05E8\u05D5\u05EA \u05E9\u05D7\u05D9\u05E4\u05E9\u05D5 \u05D4\u05DB\u05D9 \u05D4\u05E8\u05D1\u05D4");
		mostSearchedApartmentsLabel.setBounds(328, 46, 172, 16);
		frame.getContentPane().add(mostSearchedApartmentsLabel);
		
		JButton BackButton = new JButton("\u05D7\u05D6\u05E8\u05D4");
		BackButton.setBounds(12, 42, 97, 25);
		frame.getContentPane().add(BackButton);
		
		JButton PrintButton = new JButton("\u05D4\u05D3\u05E4\u05E1");
		PrintButton.setBounds(12, 80, 97, 25);
		frame.getContentPane().add(PrintButton);
		
		JList list = new JList();
		list.setBounds(32, 304, 255, -154);
		frame.getContentPane().add(list);
		
		JList list_1 = new JList();
		list_1.setBounds(12, 146, 611, 271);
		frame.getContentPane().add(list_1);
	}

}
