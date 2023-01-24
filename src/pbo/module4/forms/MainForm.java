package pbo.module4.forms;

import pbo.module4.Application;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class MainForm extends JFrame {
	private JPanel panel;

	public MainForm() throws URISyntaxException, IOException {
		this.setContentPane(this.panel);
		this.prepareMenuBar();

		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);

		this.setBounds(x, y, 1000, 720);
		this.setLocationRelativeTo(null);

		this.panel.add(new JurusanForm()).setVisible(true);
	}

	private void prepareMenuBar() throws URISyntaxException, IOException {
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(249, 250, 251));

		menuBar.add(new JMenu("Data Jurusan")).setIcon(new ImageIcon(Application.getResourceURL("folder.png")));
		menuBar.add(new JMenu("Data Kelas")).setIcon(new ImageIcon(Application.getResourceURL("home.png")));
		menuBar.add(new JMenu("Data Mapel")).setIcon(new ImageIcon(Application.getResourceURL("book.png")));
		menuBar.add(new JMenu("Data Siswa")).setIcon(new ImageIcon(Application.getResourceURL("file-text.png")));
		menuBar.add(new JMenu("Data Diri")).setIcon(new ImageIcon(Application.getResourceURL("user.png")));

		this.setJMenuBar(menuBar);
	}
}
