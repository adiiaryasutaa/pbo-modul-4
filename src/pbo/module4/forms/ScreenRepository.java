package pbo.module4.forms;

import javax.swing.*;
import java.util.LinkedHashMap;

public class ScreenRepository extends LinkedHashMap<String, JComponent> {
	public ScreenRepository() {}

	public void show(String name) {
		this.hideAll();
		this.get(name).setVisible(true);
	}

	public void hideAll() {
		for (var screen: this.values()) {
			screen.setVisible(false);
		}
	}

	@Override
	public JComponent put(String key, JComponent value) {
		return super.put(key, value);
	}
}
