package ceceply.pbo.mod4.gui;

import javax.swing.*;
import java.util.LinkedHashMap;

public class ScreenRepository extends LinkedHashMap<String, JComponent> {
	private JFrame context;

	public ScreenRepository(JFrame context) {
		this.context = context;
	}

	public void show(String name) {
		this.hideAll();
		this.get(name).setVisible(true);
	}

	public void hideAll() {
		for (var screen: this.values()) {
			screen.setVisible(false);
			screen.requestFocus();
		}
	}

	public void addAllScreenToContext() {
		for (var screen : this.values()) {
			this.context.add(screen).setVisible(false);
		}
	}

	@Override
	public JComponent put(String key, JComponent value) {
		return super.put(key, value);
	}

	@Override
	public void clear() {
		this.hideAll();
		super.clear();
	}
}
