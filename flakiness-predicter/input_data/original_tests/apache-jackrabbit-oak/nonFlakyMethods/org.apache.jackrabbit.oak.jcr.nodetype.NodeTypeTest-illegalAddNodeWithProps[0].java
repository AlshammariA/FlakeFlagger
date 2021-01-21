@Test(expected=ConstraintViolationException.class) public void illegalAddNodeWithProps() throws Exception {
  Session session=getAdminSession();
  Node root=session.getRootNode();
  ValueFactory vf=session.getValueFactory();
  Node n=root.addNode("q1","nt:query");
  n.setProperty("jcr:statement",vf.createValue("statement"));
  n.setProperty("jcr:language",vf.createValue("language"));
  Node n2=n.addNode("q2","nt:query");
  n2.setProperty("jcr:statement",vf.createValue("statement"));
  n2.setProperty("jcr:language",vf.createValue("language"));
  session.save();
}
