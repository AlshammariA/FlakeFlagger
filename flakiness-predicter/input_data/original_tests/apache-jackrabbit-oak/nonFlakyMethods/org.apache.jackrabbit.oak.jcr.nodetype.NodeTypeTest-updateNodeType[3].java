@Test public void updateNodeType() throws Exception {
  Session session=getAdminSession();
  Node root=session.getRootNode();
  ValueFactory vf=session.getValueFactory();
  NodeTypeManager manager=session.getWorkspace().getNodeTypeManager();
  Node n=root.addNode("q1","nt:query");
  n.setProperty("jcr:statement",vf.createValue("statement"));
  session.save();
  NodeTypeDefinition ntd=manager.getNodeType("nt:query");
  NodeTypeTemplate ntt=manager.createNodeTypeTemplate(ntd);
  try {
    manager.registerNodeType(ntt,true);
  }
 catch (  ConstraintViolationException unexpected) {
    fail();
  }
  @SuppressWarnings("unchecked") List<PropertyDefinitionTemplate> pdts=ntt.getPropertyDefinitionTemplates();
  for (  PropertyDefinitionTemplate pdt : pdts) {
    if ("jcr:language".equals(pdt.getName())) {
      pdt.setMandatory(true);
    }
  }
  try {
    manager.registerNodeType(ntt,true);
    fail();
  }
 catch (  ConstraintViolationException expected) {
  }
  n.setProperty("jcr:language",vf.createValue("language"));
  session.save();
  try {
    manager.registerNodeType(ntt,true);
  }
 catch (  ConstraintViolationException unexpected) {
    fail();
  }
}
