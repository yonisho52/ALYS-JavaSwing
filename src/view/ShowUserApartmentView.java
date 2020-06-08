package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ShowUserApartmentView {


	ShowAllApartmentView showAllApartmentView;
	
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowUserApartmentView window = new ShowUserApartmentView();
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
	public ShowUserApartmentView(ShowAllApartmentView showAllApartmentView) {
		

		this.showAllApartmentView = showAllApartmentView;
		initialize();
	}
	
	public ShowUserApartmentView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 660, 475);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel showApartmentsLabel = new JLabel("\u05E6\u05E4\u05D9\u05D9\u05D4 \u05D1\u05D3\u05D9\u05E8\u05D5\u05EA \u05E9\u05DC\u05DA");
		showApartmentsLabel.setBounds(393, 41, 127, 16);
		frame.getContentPane().add(showApartmentsLabel);
		
		JButton BackButton = new JButton("\u05D7\u05D6\u05E8\u05D4");
		BackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		BackButton.setBounds(12, 37, 97, 25);
		frame.getContentPane().add(BackButton);
		
		JButton EditApartmentButton = new JButton("\u05E2\u05E8\u05D5\u05DA \u05D3\u05D9\u05E8\u05D4 \u05DE\u05E1\u05D5\u05DE\u05E0\u05EA");
		EditApartmentButton.setBounds(0, 77, 147, 20);
		frame.getContentPane().add(EditApartmentButton);
		
		JButton DeleteButton = new JButton("\u05DE\u05D7\u05E7 \u05D3\u05D9\u05E8\u05D4 \u05DE\u05E1\u05D5\u05DE\u05E0\u05EA");
		DeleteButton.setBounds(10, 111, 153, 25);
		frame.getContentPane().add(DeleteButton);
		
		JList ApartmentList = new JList();
		ApartmentList.setBounds(12, 149, 618, 266);
		frame.getContentPane().add(ApartmentList);
	}
}
