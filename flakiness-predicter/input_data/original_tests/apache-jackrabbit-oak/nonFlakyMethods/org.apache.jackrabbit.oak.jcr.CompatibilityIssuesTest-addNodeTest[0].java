@Test public void addNodeTest() throws RepositoryException {
  Session session=getAdminSession();
  String ntName="test";
  NodeTypeManager ntm=session.getWorkspace().getNodeTypeManager();
  NodeTypeTemplate ntt=ntm.createNodeTypeTemplate();
  ntt.setName(ntName);
  NodeDefinitionTemplate child=ntm.createNodeDefinitionTemplate();
  child.setName("*");
  child.setDefaultPrimaryTypeName("nt:base");
  child.setRequiredPrimaryTypeNames(new String[]{"nt:base"});
  List<NodeDefinition> children=ntt.getNodeDefinitionTemplates();
  children.add(child);
  ntm.registerNodeType(ntt,true);
  Node node=session.getRootNode().addNode("defaultNtBase",ntName);
  node.addNode("nothrow");
  try {
    node.addNode("throw","nt:hierarchyNode");
    fail("Abstract primary type should cause ConstraintViolationException");
  }
 catch (  ConstraintViolationException expected) {
  }
  session.save();
}
