package com.ttn.web.dto.editor;

import java.beans.PropertyEditorSupport;

public class UserIdEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String name) throws IllegalArgumentException {
		if (name.length() > 2) {
			setValue(name);
		}
	}

}