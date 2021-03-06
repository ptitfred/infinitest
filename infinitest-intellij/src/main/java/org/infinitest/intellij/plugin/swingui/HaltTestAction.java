/*
 * This file is part of Infinitest.
 *
 * Copyright (C) 2010
 * "Ben Rady" <benrady@gmail.com>,
 * "Rod Coffin" <rfciii@gmail.com>,
 * "Ryan Breidenbach" <ryan.breidenbach@gmail.com>, et al.
 *
 * Infinitest is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Infinitest is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Infinitest.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.infinitest.intellij.plugin.swingui;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;

import org.infinitest.TestControl;

public class HaltTestAction extends AbstractAction
{
    private static final long serialVersionUID = -1L;

    private final ImageIcon stopIcon;
    private final ImageIcon startIcon;
    private final TestControl control;

    public HaltTestAction(TestControl testControl)
    {
        control = testControl;
        stopIcon = new ImageIcon(HaltTestAction.class.getResource("stop.png"));
        startIcon = new ImageIcon(HaltTestAction.class.getResource("rerun.png"));
        setIcon();
    }

    private void setIcon()
    {
        if (control.shouldRunTests())
        {
            putValue(Action.SMALL_ICON, stopIcon);
            putValue(Action.SHORT_DESCRIPTION, "Stop running the tests");
        }
        else
        {
            putValue(Action.SMALL_ICON, startIcon);
            putValue(Action.SHORT_DESCRIPTION, "Start running the tests");
        }
    }

    public void actionPerformed(ActionEvent e)
    {
        control.setRunTests(!control.shouldRunTests());
        setIcon();
    }
}
