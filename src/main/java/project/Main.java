package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class Main extends Frame implements ActionListener {
	JTextField tf1;
	JTextField tf2;
	JLabel l;
	JButton b;

	Main() {
		tf1 = new JTextField();
		tf2 = new JTextField();
		tf1.setBounds(75, 200, 50, 20);
		tf2.setBounds(200, 200, 50, 20);
		l = new JLabel();
		l.setBounds(50, 100, 250, 20);
		b = new JButton("Gaseste parcursurile intre");
		b.setBounds(50, 100, 250, 30);
		b.addActionListener(this);
		add(b);
		add(tf1);
		add(tf2);
		add(l);
		setSize(400, 400);
		setLayout(null);
		setVisible(true);
	}

	public static void main(String[] args)

	{
		new Main();

	}

	public void actionPerformed(ActionEvent e) {
		try {
			int from = Integer.parseInt(tf1.getText());
			int to = Integer.parseInt(tf2.getText());
			try {
				long now = System.currentTimeMillis();
				Map<String, Set<String>> formulas = CSVParser.readCSV();
				Combinations combinations = new Combinations(formulas.keySet());
				combinations.doAllNonRepetitiveCombinationsBetweenIndices(from, to);
				RouteVerification routeVerification = new RouteVerification(combinations.getFinalElements(), formulas);
				ArrayList<String> returnValue = routeVerification.doRouteVerifications();



				JFrame f = new JFrame();

				DefaultListModel<String> l1 = new DefaultListModel<>();
				for (String a : returnValue) {
					l1.addElement(a);
				}
				JList<String> list = new JList<>(l1);
				JScrollPane scrollBar1 = new JScrollPane();



				list.setBounds(100, 100, 75, 175);
				scrollBar1.setBounds(75, 100, 225, 175);
				scrollBar1.setViewportView(list);
				f.add(scrollBar1);
				f.setSize(400, 400);
				f.setLayout(null);
				f.setVisible(true);
				f.setResizable(true);

				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // EDIT


				JLabel label = new JLabel();
				label.setBounds(150, 300, 75, 75);
				label.setSize(500, 100);
				String data = "Totul a durat: " + (System.currentTimeMillis() - now) + " ms";
				label.setText(data);
				f.add(label);

				System.out.println();

			} catch (IOException a) {
				a.printStackTrace();
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
}
