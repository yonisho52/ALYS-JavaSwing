package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class SearchDetailsView {
	
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
	}

}
