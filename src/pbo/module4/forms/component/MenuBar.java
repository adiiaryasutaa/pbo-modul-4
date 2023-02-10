package pbo.module4.forms.component;

import pbo.module4.Application;
import pbo.module4.forms.listener.menu.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class MenuBar extends JMenuBar {
	private ArrayList<JMenu> menus;
	public MenuBar() {
		this.init();
	}

	private void init() {
		this.setBackground(new Color(249, 250, 251));

		this.menus = new ArrayList<>(7);

		try {
			JMenu berandaMenu = new JMenu("Beranda");
			berandaMenu.setIcon(new ImageIcon(Application.getResourceURL("home.png")));
			berandaMenu.addMouseListener(new BerandaMenuMouseListener(this));
			this.add(berandaMenu);

			this.add(Box.createHorizontalStrut(40));

			JMenu testMenu = new JMenu("Test");
			testMenu.setIcon(new ImageIcon(Application.getResourceURL("folder.png")));
			testMenu.addMouseListener(new DataJurusanMenuMouseListener(this));
			this.menus.add(testMenu);

			JMenu dataJurusanMenu = new JMenu("Data Jurusan");
			dataJurusanMenu.setIcon(new ImageIcon(Application.getResourceURL("folder.png")));
			dataJurusanMenu.addMouseListener(new DataJurusanMenuMouseListener(this));
			this.menus.add(dataJurusanMenu);

			JMenu dataKelasMenu = new JMenu("Data Kelas");
			dataKelasMenu.setIcon(new ImageIcon(Application.getResourceURL("home.png")));
			dataKelasMenu.addMouseListener(new DataKelasMenuMouseListener(this));
			this.menus.add(dataKelasMenu);

			JMenu dataMapelMenu = new JMenu("Data Mapel");
			dataMapelMenu.setIcon(new ImageIcon(Application.getResourceURL("book.png")));
			dataMapelMenu.addMouseListener(new DataMapelMenuMouseListener(this));
			this.menus.add(dataMapelMenu);

			JMenu dataSiswaMenu = new JMenu("Data Siswa");
			dataSiswaMenu.setIcon(new ImageIcon(Application.getResourceURL("file-text.png")));
			dataSiswaMenu.addMouseListener(new DataSiswaMenuMouseListener(this));
			this.menus.add(dataSiswaMenu);

			JMenu dataDiri = new JMenu("Data Diri");
			dataDiri.setIcon(new ImageIcon(Application.getResourceURL("user.png")));
			dataDiri.addMouseListener(new DataDiriMenuMouseListener(this));
			this.menus.add(dataDiri);

			for (JMenu menu : this.menus) {
				this.add(menu);
				this.add(Box.createHorizontalStrut(4));
			}

			this.add(Box.createHorizontalGlue());

			JMenu logoutMenu = new JMenu("Keluar");
			logoutMenu.setIcon(new ImageIcon(Application.getResourceURL("log-out.png")));
			logoutMenu.addMouseListener(new LogOutMenuMouseListener(this));
			this.add(logoutMenu);

		} catch (URISyntaxException | IOException e) {
			throw new RuntimeException(e);
		}

		this.setVisible(false);
	}
}
