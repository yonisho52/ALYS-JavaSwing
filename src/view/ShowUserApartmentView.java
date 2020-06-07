package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
