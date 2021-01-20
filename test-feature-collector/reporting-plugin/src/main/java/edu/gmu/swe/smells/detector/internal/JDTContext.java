package edu.gmu.swe.smells.detector.internal;

import edu.gmu.swe.kp.report.ClassInfo;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.compiler.IProblem;
import org.eclipse.jdt.core.dom.*;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * Retrieve information about any class using the JDTContext - it will return AST components
 *
 * @author jon
 */
public class JDTContext {

	final HashSet<String> allClassFiles = new HashSet<>();
	final HashMap<String, ClassInfo> allTypes = new HashMap<>();
	final String[] cp;
	final String[] sp;

	public JDTContext(Collection<String> sourceClasses, Collection<String> testClasses, String[] sourceDirs, String[] cp) {
		allClassFiles.addAll(sourceClasses);
		allClassFiles.addAll(testClasses);
		this.sp = sourceDirs;
		this.cp = cp;
		try {
			collectAllTypes();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

	}

	public String getDefiningSourceFile(String className)
	{
		ClassInfo info = allTypes.get(className);
		if(info != null)
		{
			return info.sourceFileName;
		}
		return null;
	}

	public BodyDeclaration getAST(String className) {
		if (className.contains("."))
			className = className.replace(".", "/");
		if (allTypes.get(className) == null)
			return null;
		return allTypes.get(className).body;

	}

	public MethodDeclaration getMethod(String className, String methodName, String methodDesc) {
		if (className.contains("."))
			className = className.replace(".", "/");
		ClassInfo i = allTypes.get(className);
		if (i == null)
			return null;
		if (methodName.contains("["))//for parameterized tests
			methodName = methodName.substring(0, methodName.indexOf('['));
		for (ClassInfo.MethodInfo m : i.methods) {
			if (m.name.equals(methodName) && (methodDesc == null || m.desc.equals(methodDesc)))
				return m.method;
		}
		if (i.superName != null) {
			return getMethod(i.superName, methodName, methodDesc);
		}
		//Check on super type
		return null;
	}


	private void collectAllTypes() throws FileNotFoundException, UnsupportedEncodingException {

		ASTParser p = ASTParser.newParser(AST.JLS8);
		Map<String, String> options = JavaCore.getOptions();
		JavaCore.setComplianceOptions(JavaCore.VERSION_1_8, options);
		p.setCompilerOptions(options);
		p.setKind(ASTParser.K_COMPILATION_UNIT);

		LinkedList<CompilationUnit> compilationUnits = new LinkedList<>();
		LinkedList<String> sourceFiles = new LinkedList<>();
		for (String path : allClassFiles) {
			if (path != null)
				sourceFiles.add(path);
		}

		p.setBindingsRecovery(true);
		p.setResolveBindings(true);
		String[] encodings = new String[sp.length];
		for (int i = 0; i < sp.length; i++)
			encodings[i] = "UTF-8";
		p.setEnvironment(cp, sp, encodings, true);
		p.setKind(ASTParser.K_COMPILATION_UNIT);
		String[] sfs = sourceFiles.toArray(new String[0]);
		encodings = new String[sfs.length];
		for (int i = 0; i < sfs.length; i++)
			encodings[i] = "UTF-8";

		FileASTRequestor req = new FileASTRequestor() {
			@Override
			public void acceptAST(String sourceFilePath, CompilationUnit ast) {
				super.acceptAST(sourceFilePath, ast);
				if(sourceFilePath.endsWith(".java"))
					collectAllTypes(ast, sourceFilePath);
			}

			@Override
			public void acceptBinding(String bindingKey, IBinding binding) {
				super.acceptBinding(bindingKey, binding);
				System.out.println("Binding" + bindingKey);
			}
		};
		p.createASTs(sfs, encodings, new String[0], req, null);
	}

	private void collectAllTypes(final CompilationUnit root, final String sourceFileName) {
		for (IProblem prob : root.getProblems()) {
			if(prob.isError())
				System.err.println("Problem: " + prob + " in " + sourceFileName);
		}
		root.accept(new ASTVisitor() {
			ClassInfo thisClass = null;

			String packageName;

			@Override
			public boolean visit(PackageDeclaration node) {
				packageName = node.getName().getFullyQualifiedName();
				return super.visit(node);
			}

			@Override
			public void endVisit(TypeDeclaration node) {
				thisClass = thisClass.parent;
				super.endVisit(node);
			}

			@Override
			public boolean visit(EmptyStatement node) {
				return super.visit(node);
			}

			@Override
			public boolean visit(AnonymousClassDeclaration node) {
				String name = thisClass.className + "$" + thisClass.anonCounter;
				thisClass.anonCounter++;
				ClassInfo newThisClass = new ClassInfo();
				newThisClass.sourceFileName = sourceFileName;
				newThisClass.className = name;
				newThisClass.parent = thisClass;
				thisClass.innerClasses.add(newThisClass);
				thisClass = newThisClass;
				int startLine = root.getLineNumber(node.getStartPosition());
				int endLine = root.getLineNumber(node.getStartPosition() + node.getLength());
				for (Object b : node.bodyDeclarations()) {
					thisClass.body = ((BodyDeclaration) b);
					allTypes.put(thisClass.className, thisClass);
				}
				return super.visit(node);
			}

			@Override
			public void endVisit(AnonymousClassDeclaration node) {
				thisClass = thisClass.parent;
				super.endVisit(node);
			}

			@Override
			public void endVisit(EnumDeclaration node) {
				thisClass = thisClass.parent;
				super.endVisit(node);
			}

			@Override
			public boolean visit(EnumDeclaration node) {
				String name = (packageName == null ? "" : packageName + ".") + node.getName().toString();
				name = name.replace('.', '/');
				if (thisClass == null) {
					thisClass = new ClassInfo();
					thisClass.sourceFileName = sourceFileName;
					thisClass.className = name.replace('.', '/');
					thisClass.body = node;
					allTypes.put(thisClass.className, thisClass);
//					ret.add(thisClass);

				}
				if (thisClass.className != null && !thisClass.className.equals(name)) {
					ClassInfo newThisClass = new ClassInfo();
					newThisClass.sourceFileName = sourceFileName;
					name = thisClass.className + "$" + node.getName().toString();
					newThisClass.className = name;
					thisClass.innerClasses.add(newThisClass);
					newThisClass.parent = thisClass;
					thisClass = newThisClass;
					int startLine = root.getLineNumber(node.getStartPosition());
					int endLine = root.getLineNumber(node.getStartPosition() + node.getLength());
					thisClass.body = node;
					allTypes.put(thisClass.className, thisClass);
				}
				if (thisClass.className == null)
					thisClass.className = name.replace('.', '/');
				return super.visit(node);
			}

			@Override
			public boolean visit(TypeDeclaration node) {
				String name = (packageName == null ? "" : packageName + ".") + node.getName().toString();
				name = name.replace('.', '/');
				if (thisClass == null) {
					// Root element
					thisClass = new ClassInfo();
					thisClass.sourceFileName = sourceFileName;
					thisClass.className = name;
					thisClass.body = node;
					allTypes.put(thisClass.className, thisClass);
				}
				if (thisClass.className != null && !thisClass.className.equals(name)) {
					ClassInfo newThisClass = new ClassInfo();
					newThisClass.sourceFileName =sourceFileName;
					name = thisClass.className + "$" + node.getName().toString();
					newThisClass.className = name;
					thisClass.innerClasses.add(newThisClass);
					newThisClass.parent = thisClass;
					thisClass = newThisClass;
					int startLine = root.getLineNumber(node.getStartPosition());
					int endLine = root.getLineNumber(node.getStartPosition() + node.getLength());
					thisClass.body = node;
					allTypes.put(thisClass.className, thisClass);
				}
				if (node.getSuperclassType() != null && node.getSuperclassType().resolveBinding() != null && node.getSuperclassType().resolveBinding().getBinaryName() != null)
					thisClass.superName = node.getSuperclassType().resolveBinding().getBinaryName().toString();
				thisClass.className = name;
				return super.visit(node);
			}

			@Override
			public boolean visit(MethodDeclaration node) {
				StringBuffer fq = new StringBuffer();
				String name;
				if (node.isConstructor())
					name = "<init>";
				else
					name = node.getName().toString();
				fq.append('(');
				boolean hasParams = false;
				for (Object p : node.parameters()) {
					SingleVariableDeclaration d = (SingleVariableDeclaration) p;
					ITypeBinding b = d.getType().resolveBinding();
					if (b != null)
						fq.append(toDesc(b.getBinaryName()));
					else
						fq.append(toDesc(d.getType().toString()));
					hasParams = true;
				}
//				if (hasParams) {
//					fq.deleteCharAt(fq.length() - 1);
//				}
				fq.append(')');
				if (node.isConstructor())
					fq.append('V');
				else {
					if (node.getReturnType2() == null) {
						fq.append('V');
					} else {
						ITypeBinding b = node.getReturnType2().resolveBinding();
						if (b != null)
							fq.append(toDesc(b.getBinaryName()));
						else
							fq.append(toDesc(node.getReturnType2().toString()));
					}
				}
				if (thisClass != null)
					thisClass.methods.add(new ClassInfo.MethodInfo(fq.toString(), name, thisClass.className, node));
				return true;
			}

			String toDesc(String binaryName) {
				if (binaryName == null)
					return null;
				if (binaryName.length() == 1)
					return binaryName;
				else if (binaryName.charAt(0) == '[')
					return binaryName.replace('.', '/');// +";";
				else
					return "L" + binaryName.replace('.', '/') + ";";
			}

		});
	}
}
