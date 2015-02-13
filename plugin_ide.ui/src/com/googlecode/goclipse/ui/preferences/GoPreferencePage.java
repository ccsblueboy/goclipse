/*******************************************************************************
 * Copyright (c) 2015, 2015 Bruno Medeiros and other Contributors.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Bruno Medeiros - initial API and implementation
 *******************************************************************************/
package com.googlecode.goclipse.ui.preferences;

import melnorme.lang.ide.ui.LangUIPlugin;
import melnorme.lang.ide.ui.preferences.common.AbstractComponentsPrefPage;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.osgi.framework.Version;

import com.googlecode.goclipse.core.GoCore;

public class GoPreferencePage extends AbstractComponentsPrefPage {
	
	public static final String ID = "com.googlecode.goclipse.ui.PreferencePage";
	
	protected final GoSDKConfigBlock goSDKConfigBlock = new GoSDKConfigBlock(this);
	
	public GoPreferencePage() {
		super(LangUIPlugin.getCorePrefStore());
		
		setDescription("GoClipse v" + getVersionText());
	}
	
	protected static String getVersionText() {
		Version version = GoCore.getDefault().getBundle().getVersion();
		
		return version.getMajor() + "." + version.getMinor() + "." + version.getMicro();
	}
	
	@Override
	protected String getHelpId() {
		return null;
	}
	
	@Override
	protected Control createContents(Composite parent) {
		return goSDKConfigBlock.createComponent(parent);
	}
	
}