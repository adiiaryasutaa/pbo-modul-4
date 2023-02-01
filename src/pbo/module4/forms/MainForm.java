package pbo.module4.forms;

import pbo.module4.Application;
import pbo.module4.forms.listener.menubar.DataJurusanMenuMouseListener;
import pbo.module4.forms.listener.menubar.DataKelasMenuMouseListener;
import pbo.module4.forms.listener.menubar.DataMapelMenuMouseListener;
import pbo.module4.forms.listener.menubar.DataSiswaMenuMouseListener;
import pbo.module4.record.Siswa;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class MainForm extends JFrame {
	private JPanel panel;
	private JMenuBar menuBar;

	private static final JurusanForm jurusanForm = new JurusanForm();
	private static final KelasForm kelasForm = new KelasForm();
	private static final MapelForm mapelForm = new MapelForm();
	private static final SiswaForm siswaForm = new SiswaForm();

	public MainForm() throws URISyntaxException, IOException {
		this.setContentPane(this.panel);
		this.placeOnCenterScreen();
		this.prepareMenuBar();
		this.prepareForms();
	}

	private void placeOnCenterScreen() {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);

		this.setBounds(x, y, 1000, 720);
		this.setLocationRelativeTo(null);
	}

	private void prepareMenuBar() throws URISyntaxException, IOException {
		this.menuBar = new JMenuBar();
		this.menuBar.setBackground(new Color(249, 250, 251));

		JMenu dataJurusanMenu = new JMenu("Data Jurusan");
		dataJurusanMenu.setIcon(new ImageIcon(Application.getResourceURL("folder.png")));
		dataJurusanMenu.addMouseListener(new DataJurusanMenuMouseListener());
		this.menuBar.add(dataJurusanMenu);

		JMenu dataKelasMenu = new JMenu("Data Kelas");
		dataKelasMenu.setIcon(new ImageIcon(Application.getResourceURL("home.png")));
		dataKelasMenu.addMouseListener(new DataKelasMenuMouseListener());
		this.menuBar.add(dataKelasMenu);

		JMenu dataMapelMenu = new JMenu("Data Mapel");
		dataMapelMenu.setIcon(new ImageIcon(Application.getResourceURL("book.png")));
		dataMapelMenu.addMouseListener(new DataMapelMenuMouseListener());
		this.menuBar.add(dataMapelMenu);

		JMenu dataSiswaMenu = new JMenu("Data Siswa");
		dataSiswaMenu.setIcon(new ImageIcon(Application.getResourceURL("file-text.png")));
		dataSiswaMenu.addMouseListener(new DataSiswaMenuMouseListener());
		this.menuBar.add(dataSiswaMenu);

		menuBar.add(new JMenu("Data Diri")).setIcon(new ImageIcon(Application.getResourceURL("user.png")));

		this.setJMenuBar(menuBar);
	}

	private void prepareForms() {
		this.panel.add(MainForm.jurusanForm).setVisible(true);
		this.panel.add(MainForm.kelasForm).setVisible(false);
		this.panel.add(MainForm.mapelForm).setVisible(false);
		this.panel.add(MainForm.siswaForm).setVisible(false);
	}

	public static JurusanForm getJurusanForm() {
		return MainForm.jurusanForm;
	}

	public static KelasForm getKelasForm() {
		return MainForm.kelasForm;
	}

	public static MapelForm getMapelForm() {
		return MainForm.mapelForm;
	}

	public static SiswaForm getSiswaForm() {
		return MainForm.siswaForm;
	}
}
