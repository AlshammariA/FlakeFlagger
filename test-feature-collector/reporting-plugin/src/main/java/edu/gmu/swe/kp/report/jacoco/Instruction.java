package edu.gmu.swe.kp.report.jacoco;


/*******************************************************************************
 * Copyright (c) 2009, 2017 Mountainminds GmbH & Co. KG and Contributors
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Marc R. Hoffmann - initial API and implementation
 *
 *******************************************************************************/


/**
 * Representation of a byte code instruction for analysis. Internally used for
 * analysis.
 */
public class Instruction extends org.jacoco.core.internal.flow.Instruction {
	public Instruction(int line) {
		super(line);
	}

	public int coveredBranches;
	public Instruction _predecessor;

	public void setPredecessor(final Instruction predecessor) {
		super.setPredecessor(predecessor);
		this._predecessor = predecessor;

	}

}
