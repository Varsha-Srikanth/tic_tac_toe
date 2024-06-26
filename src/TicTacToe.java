
public class TicTacToe implements ActionListener {

	Random random = new Random();
	JFrame frame = new JFrame();
	JPanel title_panel = new JPanel();
	JPanel button_panel = new JPanel();
	JLabel textfield = new JLabel();
	JButton[] buttons = new JButton[9];
	boolean player1_turn;
	int counter = 0;

	TicTacToe() {

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 600);
		frame.getContentPane().setBackground(new Color(50, 50, 50));
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);

		textfield.setBackground(new Color(25, 25, 25));
		textfield.setForeground(new Color(25, 255, 150));
		textfield.setFont(new Font("Ink Free", Font.BOLD, 75));
		textfield.setHorizontalAlignment(JLabel.CENTER);
		textfield.setText("Tic-Tac-Toe");
		textfield.setOpaque(true);

		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(0, 0, 800, 100);

		button_panel.setLayout(new GridLayout(3, 3));
		button_panel.setBackground(new Color(50, 50, 50));

		for (int i = 0; i < 9; i++) {
			buttons[i] = new JButton();
			button_panel.add(buttons[i]);
			buttons[i].setFont(new Font("MV Boli", Font.ITALIC, 120));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
		}

		title_panel.add(textfield);
		frame.add(title_panel, BorderLayout.NORTH);
		frame.add(button_panel);

		firstTurn();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		for (int i = 0; i < 9; i++) {
			if (e.getSource() == buttons[i]) {
				if (player1_turn) {
					if (buttons[i].getText() == "") {
						buttons[i].setForeground(Color.BLUE);
						buttons[i].setText("X");
						player1_turn = false;
						textfield.setText(" Trisha's turn");
						check();
					}

				} else {
					if (buttons[i].getText() == "") {
						buttons[i].setForeground(Color.RED);
						buttons[i].setText("O");
						player1_turn = true;
						textfield.setText("Varsha's turn");
						check();
					}
				}

			}
		}
	}

	public void firstTurn() {

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (random.nextInt(2) == 0) {
			player1_turn = true;
			textfield.setText(" Varsha's turn");
		} else {

			player1_turn = false;
			textfield.setText("Trisha's turn");

		}

	}

	public void check() {

		if ((buttons[0].getText() == "X") &&
				(buttons[1].getText() == "X") &&
				(buttons[2].getText() == "X")) {
			XWins(0, 1, 2);
		}

		if ((buttons[3].getText() == "X") &&
				(buttons[4].getText() == "X") &&
				(buttons[5].getText() == "X")) {
			XWins(3, 4, 5);
		}

		if ((buttons[6].getText() == "X") &&
				(buttons[7].getText() == "X") &&
				(buttons[8].getText() == "X")) {
			XWins(6, 7, 8);
		}

		if ((buttons[0].getText() == "X") &&
				(buttons[3].getText() == "X") &&
				(buttons[6].getText() == "X")) {
			XWins(0, 3, 6);
		}

		if ((buttons[1].getText() == "X") &&
				(buttons[4].getText() == "X") &&
				(buttons[7].getText() == "X")) {
			XWins(1, 4, 7);
		}

		if ((buttons[2].getText() == "X") &&
				(buttons[5].getText() == "X") &&
				(buttons[8].getText() == "X")) {
			XWins(2, 5, 8);
		}

		if ((buttons[0].getText() == "X") &&
				(buttons[4].getText() == "X") &&
				(buttons[8].getText() == "X")) {
			XWins(0, 4, 8);
		}

		if ((buttons[2].getText() == "X") &&
				(buttons[4].getText() == "X") &&
				(buttons[6].getText() == "X")) {
			XWins(2, 4, 6);
		}

		if ((buttons[0].getText() == "O") &&
				(buttons[1].getText() == "O") &&
				(buttons[2].getText() == "O")) {
			OWins(0, 1, 2);
		}

		if ((buttons[3].getText() == "O") &&
				(buttons[4].getText() == "O") &&
				(buttons[5].getText() == "O")) {
			OWins(3, 4, 5);
		}

		if ((buttons[6].getText() == "O") &&
				(buttons[7].getText() == "O") &&
				(buttons[8].getText() == "O")) {
			OWins(6, 7, 8);
		}

		if ((buttons[0].getText() == "O") &&
				(buttons[3].getText() == "O") &&
				(buttons[6].getText() == "O")) {
			OWins(0, 3, 6);
		}

		if ((buttons[1].getText() == "O") &&
				(buttons[4].getText() == "O") &&
				(buttons[7].getText() == "O")) {
			OWins(1, 4, 7);
		}

		if ((buttons[2].getText() == "O") &&
				(buttons[5].getText() == "O") &&
				(buttons[8].getText() == "O")) {
			OWins(2, 5, 8);
		}

		if ((buttons[0].getText() == "O") &&
				(buttons[4].getText() == "O") &&
				(buttons[8].getText() == "O")) {
			OWins(0, 4, 8);
		}

		if ((buttons[2].getText() == "X") &&
				(buttons[4].getText() == "X") &&
				(buttons[6].getText() == "X")) {
			OWins(2, 4, 6);
		}

	}

	public void XWins(int a, int b, int c) {

		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);

		for (int i = 0; i < 9; i++) {
			buttons[i].setEnabled(false);
		}
		textfield.setText("Varsha won");
		counter = 1;

	}

	public void OWins(int a, int b, int c) {

		buttons[a].setBackground(Color.YELLOW);
		buttons[b].setBackground(Color.YELLOW);
		buttons[c].setBackground(Color.YELLOW);

		for (int i = 0; i < 9; i++) {
			buttons[i].setEnabled(false);
		}
		textfield.setText("Trisha won");
		counter = 1;
	}

	public void draw(counter)
	{
		if (counter!=1)
			System.out.println("Draw");
	}
}
