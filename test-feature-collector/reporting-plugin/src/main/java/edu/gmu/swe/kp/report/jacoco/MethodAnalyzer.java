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

import org.jacoco.core.analysis.IMethodCoverage;
import org.jacoco.core.analysis.ISourceNode;
import org.jacoco.core.internal.analysis.MethodCoverageImpl;
import org.jacoco.core.internal.analysis.StringPool;
import org.jacoco.core.internal.flow.IFrame;
import org.jacoco.core.internal.flow.LabelInfo;
import org.jacoco.core.internal.flow.MethodProbesVisitor;
import org.objectweb.asm.Handle;
import org.objectweb.asm.Label;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;

/**
 * A {@link MethodProbesVisitor} that analyzes which statements and branches of
 * a method have been executed based on given probe data.
 */
public class MethodAnalyzer extends MethodProbesVisitor {

	private final HashMap<String, boolean[]> data;

	private final MethodCoverageImpl coverage;

	private int currentLine = ISourceNode.UNKNOWN_LINE;

	private int firstLine = ISourceNode.UNKNOWN_LINE;

	private int lastLine = ISourceNode.UNKNOWN_LINE;

	// Due to ASM issue #315745 there can be more than one label per instruction
	private final List<Label> currentLabel = new ArrayList<Label>(2);

	/**
	 * List of all analyzed instructions
	 */
	private final List<Instruction> instructions = new ArrayList<Instruction>();

	/**
	 * List of all predecessors of covered probes
	 */
	private final HashMap<String, List<Instruction>> coveredProbes = new HashMap<String, List<Instruction>>();

	/**
	 * List of all jumps encountered
	 */
	private final List<Jump> jumps = new ArrayList<Jump>();

	/**
	 * Last instruction in byte code sequence
	 */
	private Instruction lastInsn;

	private final long classID;

	private final SessionCoverageVisitor visitor;

	private final String className;
	private final String methodName;

	private final StringPool stringPool;

	/**
	 * New Method analyzer for the given probe data.
	 *
	 * @param name      method name
	 * @param desc      method descriptor
	 * @param signature optional parameterized signature
	 * @param data      recorded probe date of the containing class or
	 *                  <code>null</code> if the class is not executed at all
	 */
	public MethodAnalyzer(final String name, final String desc,
	                      final String signature, final HashMap<String, HashMap<String, boolean[]>> data, final long classID, SessionCoverageVisitor vis, String className, StringPool stringPool) {
		super();
		this.data = data.get(className);
		this.coverage = new MethodCoverageImpl(name, desc, signature);
		this.classID = classID;
		this.visitor = vis;
		this.className = className;
		this.stringPool = stringPool;
		this.methodName = name + desc;
	}

	/**
	 * Returns the coverage data for this method after this visitor has been
	 * processed.
	 *
	 * @return coverage data for this method
	 */
	public IMethodCoverage getCoverage() {
		return coverage;
	}

	@Override
	public void visitLabel(final Label label) {
		currentLabel.add(label);
		if (!LabelInfo.isSuccessor(label)) {
			lastInsn = null;
		}
	}

	HashSet<Integer> linesInMethod = new HashSet<Integer>();

	@Override
	public void visitLineNumber(final int line, final Label start) {
		currentLine = line;
		linesInMethod.add(line);
		if (firstLine > line || lastLine == ISourceNode.UNKNOWN_LINE) {
			firstLine = line;
		}
		if (lastLine < line) {
			lastLine = line;
		}
	}

	private void visitInsn() {
		final Instruction insn = new Instruction(currentLine);
		instructions.add(insn);
		if (lastInsn != null) {
			insn.setPredecessor(lastInsn);
		}
		final int labelCount = currentLabel.size();
		if (labelCount > 0) {
			for (int i = labelCount; --i >= 0; ) {
				LabelInfo.setInstruction(currentLabel.get(i), insn);
			}
			currentLabel.clear();
		}
		lastInsn = insn;
	}

	@Override
	public void visitInsn(final int opcode) {
		visitInsn();
	}

	@Override
	public void visitIntInsn(final int opcode, final int operand) {
		visitInsn();
	}

	@Override
	public void visitVarInsn(final int opcode, final int var) {
		visitInsn();
	}

	@Override
	public void visitTypeInsn(final int opcode, final String type) {
		visitInsn();
	}

	@Override
	public void visitFieldInsn(final int opcode, final String owner,
	                           final String name, final String desc) {
		visitInsn();
	}

	@Override
	public void visitMethodInsn(final int opcode, final String owner,
	                            final String name, final String desc, final boolean itf) {
		visitInsn();
	}

	@Override
	public void visitInvokeDynamicInsn(final String name, final String desc,
	                                   final Handle bsm, final Object... bsmArgs) {
		visitInsn();
	}

	@Override
	public void visitJumpInsn(final int opcode, final Label label) {
		visitInsn();
		jumps.add(new Jump(lastInsn, label));
	}

	@Override
	public void visitLdcInsn(final Object cst) {
		visitInsn();
	}

	@Override
	public void visitIincInsn(final int var, final int increment) {
		visitInsn();
	}

	@Override
	public void visitTableSwitchInsn(final int min, final int max,
	                                 final Label dflt, final Label... labels) {
		visitSwitchInsn(dflt, labels);
	}

	@Override
	public void visitLookupSwitchInsn(final Label dflt, final int[] keys,
	                                  final Label[] labels) {
		visitSwitchInsn(dflt, labels);
	}

	private void visitSwitchInsn(final Label dflt, final Label[] labels) {
		visitInsn();
		LabelInfo.resetDone(labels);
		jumps.add(new Jump(lastInsn, dflt));
		LabelInfo.setDone(dflt);
		for (final Label l : labels) {
			if (!LabelInfo.isDone(l)) {
				jumps.add(new Jump(lastInsn, l));
				LabelInfo.setDone(l);
			}
		}
	}

	@Override
	public void visitMultiANewArrayInsn(final String desc, final int dims) {
		visitInsn();
	}

	@Override
	public void visitProbe(final int probeId) {
		addProbe(probeId);
		lastInsn = null;
	}

	@Override
	public void visitJumpInsnWithProbe(final int opcode, final Label label,
	                                   final int probeId, final IFrame frame) {
		visitInsn();
		addProbe(probeId);
	}

	@Override
	public void visitInsnWithProbe(final int opcode, final int probeId) {
		visitInsn();
		addProbe(probeId);
	}

	@Override
	public void visitTableSwitchInsnWithProbes(final int min, final int max,
	                                           final Label dflt, final Label[] labels, final IFrame frame) {
		visitSwitchInsnWithProbes(dflt, labels);
	}

	@Override
	public void visitLookupSwitchInsnWithProbes(final Label dflt,
	                                            final int[] keys, final Label[] labels, final IFrame frame) {
		visitSwitchInsnWithProbes(dflt, labels);
	}

	private void visitSwitchInsnWithProbes(final Label dflt,
	                                       final Label[] labels) {
		visitInsn();
		LabelInfo.resetDone(dflt);
		LabelInfo.resetDone(labels);
		visitSwitchTarget(dflt);
		for (final Label l : labels) {
			visitSwitchTarget(l);
		}
	}

	private void visitSwitchTarget(final Label label) {
		final int id = LabelInfo.getProbeId(label);
		if (!LabelInfo.isDone(label)) {
			if (id == LabelInfo.NO_PROBE) {
				jumps.add(new Jump(lastInsn, label));
			} else {
				addProbe(id);
			}
			LabelInfo.setDone(label);
		}
	}

	@Override
	public void visitEnd() {
		// Wire jumps:
		for (final Jump j : jumps) {
			LabelInfo.getInstruction(j.target).setPredecessor(j.source);
		}

		// Propagate probe values:
		visitor.preVisitMethod(className, methodName);
		HashSet<Integer> allLinesCovered = new HashSet<Integer>();
		HashSet<Integer> allLinesCoveredDiff = new HashSet<Integer>();

		HashSet<Integer> diffLinesThisMethod = new HashSet<Integer>();
		HashSet<Instruction> coveredInsns = new HashSet<Instruction>();
		int allInsns = instructions.size();
		for (Entry<String, List<Instruction>> e : coveredProbes.entrySet()) {
			if (e.getKey().equals("#not#a#test"))
				continue;
			String[] d = e.getKey().split("#", 2);
			if(d.length < 2)
				continue;
			String testClazz = stringPool.get(d[0]);
			String testMeth = stringPool.get(d[1]);
			HashSet<Integer> cov = new HashSet<Integer>();
			int nInsnCovered = 0;

			for (final Instruction p : e.getValue()) {

				Instruction i = p;
				while (i != null && i.coveredBranches++ == 0) {
					nInsnCovered++;
					coveredInsns.add(i);
					cov.add(i.getLine());
					i = i._predecessor;
				}
				if (i != null) {
					nInsnCovered++;
					cov.add(i.getLine());
					coveredInsns.add(i);
				}
			}
			int nDiffCovered = 0;
			for (Integer i : cov)
				if (diffLinesThisMethod.contains(i)) {
					nDiffCovered++;
					allLinesCoveredDiff.add(i);
				}
			allLinesCovered.addAll(cov);
			visitor.visitCoverage(testClazz, testMeth, className, cov, linesInMethod.size(), nInsnCovered, allInsns, nDiffCovered, diffLinesThisMethod.size());
		}
		visitor.endVisitMethod(className, methodName, allLinesCovered.size(), linesInMethod.size(), coveredInsns.size(), allInsns, allLinesCoveredDiff.size(), diffLinesThisMethod.size());
		// Report result:
		coverage.ensureCapacity(firstLine, lastLine);
//		for (final Instruction i : instructions) {
//			final int total = i.getBranches();
//			final int covered = i.getCoveredBranches();
//			final ICounter instrCounter = covered == 0 ? CounterImpl.COUNTER_1_0
//					: CounterImpl.COUNTER_0_1;
//			final ICounter branchCounter = total > 1 ? CounterImpl.getInstance(
//					total - covered, covered) : CounterImpl.COUNTER_0_0;
//			coverage.increment(instrCounter, branchCounter, i.getLine());
//		}
		coverage.incrementMethodCounter();
	}

	private void addProbe(final int probeId) {
//		System.out.println(data);
		lastInsn.addBranch();
		if (data == null)
			return;
		for (Entry<String, boolean[]> entry : data.entrySet()) {
			if (entry.getValue() != null && entry.getValue().length > probeId && entry.getValue()[probeId]) {
				List<Instruction> insns = coveredProbes.get(entry.getKey());
				if (insns == null) {
					insns = new ArrayList<Instruction>();
					coveredProbes.put(entry.getKey(), insns);
				}
				insns.add(lastInsn);
			}
		}
	}

	private static class Jump {

		final Instruction source;
		final Label target;

		Jump(final Instruction source, final Label target) {
			this.source = source;
			this.target = target;
		}
	}

}
