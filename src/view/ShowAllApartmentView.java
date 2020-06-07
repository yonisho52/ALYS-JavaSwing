package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class ShowAllApartmentView {
	
	SearchDetailsView searchDetailsView;
	AddNewApartmentView addNewApartmentView;
	ShowAllApartmentView showAllApartmentView;
	ShowUserApartmentView showUserApartmentView;
	MainView mainView;

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowAllApartmentView window = new ShowAllApartmentView();
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
	public ShowAllApartmentView(SearchDetailsView searchDetailsView,AddNewApartmentView addNewApartmentView,
			ShowAllApartmentView showAllApartmentView,ShowUserApartmentView showUserApartmentView, MainView mainView) {
		this.mainView = mainView;
		this.searchDetailsView = searchDetailsView;
		this.addNewApartmentView = addNewApartmentView;
		this.showAllApartmentView = showAllApartmentView;
		this.showUserApartmentView = showUserApartmentView;
		initialize();
	}
	
	public ShowAllApartmentView() {
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
