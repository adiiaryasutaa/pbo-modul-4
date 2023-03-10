package ceceply.pbo.mod4.gui.component;

import ceceply.pbo.mod4.Application;
import ceceply.pbo.mod4.auth.AuthModel;
import ceceply.pbo.mod4.auth.UserLevel;
import ceceply.pbo.mod4.gui.MainFrame;
import ceceply.pbo.mod4.gui.listener.menu.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class MenuBar extends JMenuBar {
	private MainFrame context;
	private ArrayList<JMenu> menus;

	public MenuBar(MainFrame context) {
		this.context = context;
		this.init();
	}

	private void init() {
		this.setBackground(new Color(249, 250, 251));
		this.menus = new ArrayList<>();
	}

	public void update() {
		this.menus.clear();
		this.removeAll();

		AuthModel model = Application.getAuthManager().getUser();

		if (model == null) {
			this.setVisible(false);
			return;
		}

		try {
			UserLevel userLevel = Application.getAuthManager().getUser().userLevel();

			JMenu berandaMenu = new JMenu("Beranda");
			berandaMenu.setIcon(new ImageIcon(Application.getResourceURL("home.png")));
			berandaMenu.addMouseListener(new BerandaMenuMouseListener(this.context));
			this.add(berandaMenu);

			if (userLevel == UserLevel.ADMIN) {
				this.add(Box.createHorizontalStrut(40));

				JMenu dataJurusanMenu = new JMenu("Data Jurusan");
				dataJurusanMenu.setIcon(new ImageIcon(Application.getResourceURL("folder.png")));
				dataJurusanMenu.addMouseListener(new DataJurusanMenuMouseListener(this.context));
				this.menus.add(dataJurusanMenu);

				JMenu dataKelasMenu = new JMenu("Data Kelas");
				dataKelasMenu.setIcon(new ImageIcon(Application.getResourceURL("home.png")));
				dataKelasMenu.addMouseListener(new DataKelasMenuMouseListener(this.context));
				this.menus.add(dataKelasMenu);

				JMenu dataMapelMenu = new JMenu("Data Mapel");
				dataMapelMenu.setIcon(new ImageIcon(Application.getResourceURL("book.png")));
				dataMapelMenu.addMouseListener(new DataMapelMenuMouseListener(this.context));
				this.menus.add(dataMapelMenu);

				JMenu dataSiswaMenu = new JMenu("Data Siswa");
				dataSiswaMenu.setIcon(new ImageIcon(Application.getResourceURL("file-text.png")));
				dataSiswaMenu.addMouseListener(new DataSiswaMenuMouseListener(this.context));
				this.menus.add(dataSiswaMenu);

				JMenu dataDiri = new JMenu("Data Diri");
				dataDiri.setIcon(new ImageIcon(Application.getResourceURL("user.png")));
				dataDiri.addMouseListener(new DataDiriMenuMouseListener(this.context));
				this.menus.add(dataDiri);
			} else if (userLevel.equals(UserLevel.SISWA)) {

			}

			for (JMenu menu : this.menus) {
				this.add(menu);
				this.add(Box.createHorizontalStrut(4));
			}

			this.add(Box.createHorizontalGlue());

			JMenu logoutMenu = new JMenu("Keluar");
			logoutMenu.setIcon(new ImageIcon(Application.getResourceURL("log-out.png")));
			logoutMenu.addMouseListener(new LogOutMenuMouseListener(this.context));
			this.add(logoutMenu);

		} catch (URISyntaxException | IOException e) {
			throw new RuntimeException(e);
		}

		this.setVisible(true);
	}
}
