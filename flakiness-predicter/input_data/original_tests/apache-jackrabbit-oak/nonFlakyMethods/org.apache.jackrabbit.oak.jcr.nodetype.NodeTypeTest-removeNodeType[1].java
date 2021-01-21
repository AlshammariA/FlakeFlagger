@Test public void removeNodeType() throws Exception {
  Session session=getAdminSession();
  Node root=session.getRootNode();
  ValueFactory vf=session.getValueFactory();
  NodeTypeManager manager=session.getWorkspace().getNodeTypeManager();
  Node n=root.addNode("q1","nt:query");
  n.setProperty("jcr:statement",vf.createValue("statement"));
  n.setProperty("jcr:language",vf.createValue("language"));
  session.save();
  try {
    manager.unregisterNodeType("nt:query");
    fail();
  }
 catch (  ConstraintViolationException expected) {
  }
  n.remove();
  session.save();
  try {
    manager.unregisterNodeType("nt:query");
  }
 catch (  ConstraintViolationException unexpected) {
    fail();
  }
}
