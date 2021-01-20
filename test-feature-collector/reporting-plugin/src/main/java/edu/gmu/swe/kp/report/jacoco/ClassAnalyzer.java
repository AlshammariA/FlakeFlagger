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
package edu.gmu.swe.kp.report.jacoco;

import org.jacoco.core.internal.analysis.StringPool;
import org.jacoco.core.internal.flow.ClassProbesVisitor;
import org.jacoco.core.internal.flow.MethodProbesVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.Opcodes;

import java.util.HashMap;

/**
 * Analyzes the structure of a class.
 */
public class ClassAnalyzer extends ClassProbesVisitor {

	private final SessionCoverageVisitor visitor;
	private final HashMap<String, HashMap<String, boolean[]>> data;
	private final StringPool stringPool;
	private final long classID;
	//	private final HashMap<String, TestSessionCoverage> linesHitPerSession;
	private final String className;

	/**
	 * Creates a new analyzer that builds coverage data for a class.
	 *
	 * @param visitor       coverage node for the analyzed class data
	 * @param executionData execution data for this class or <code>null</code>
	 * @param stringPool    shared pool to minimize the number of {@link String} instances
	 */
	public ClassAnalyzer(final SessionCoverageVisitor visitor,
	                     final HashMap<String, HashMap<String, boolean[]>> executionData, final StringPool stringPool, final long classID, final String className) {
		this.visitor = visitor;
		this.data = executionData;
		this.stringPool = stringPool;
		this.classID = classID;
//		this.linesHitPerSession = linesHitPerSession;
		this.className = className;
	}

	private String name;

	@Override
	public void visit(final int version, final int access, final String name,
	                  final String signature, final String superName,
	                  final String[] interfaces) {
//		coverage.setSignature(stringPool.get(signature));
//		coverage.setSuperName(stringPool.get(superName));
//		coverage.setInterfaces(stringPool.get(interfaces));
		visitor.preVisitClass(name);
		this.name = name;
	}

	@Override
	public void visitEnd() {
		visitor.postVisitClass(name);

	}

	@Override
	public void visitSource(final String source, final String debug) {
//		coverage.setSourceFileName(stringPool.get(source));
	}

	@Override
	public MethodProbesVisitor visitMethod(final int access, final String name,
	                                       final String desc, final String signature, final String[] exceptions) {

//		InstrSupport.assertNotInstrumented(name, coverage.getName());

		if (isMethodFiltered(access, name)) {
			return null;
		}

		return new MethodAnalyzer(stringPool.get(name), stringPool.get(desc),
				stringPool.get(signature), data, classID, visitor, className, stringPool) {
			@Override
			public void visitEnd() {
				super.visitEnd();
//				final IMethodCoverage methodCoverage = getCoverage();
//				if (methodCoverage.getInstructionCounter().getTotalCount() > 0) {
//					// Only consider methods that actually contain code
////					coverage.addMethod(methodCoverage);
//				}
			}
		};
	}

	// TODO: Use filter hook in future
	private boolean isMethodFiltered(final int access, final String name) {
		return (access & Opcodes.ACC_SYNTHETIC) != 0
				&& !name.startsWith("lambda$");
	}

	@Override
	public FieldVisitor visitField(final int access, final String name,
	                               final String desc, final String signature, final Object value) {
//		InstrSupport.assertNotInstrumented(name, coverage.getName());
		return super.visitField(access, name, desc, signature, value);
	}

	@Override
	public void visitTotalProbeCount(final int count) {
		// nothing to do
	}

}

