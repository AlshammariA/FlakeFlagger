@Test public void testRegisterNodeType() throws Exception {
  Workspace testWsp=testSession.getWorkspace();
  NodeTypeManager ntm=testWsp.getNodeTypeManager();
  NodeTypeTemplate ntd=ntm.createNodeTypeTemplate();
  ntd.setName("testRegisterNodeType");
  ntd.setMixin(true);
  try {
    ntm.registerNodeType(ntd,true);
    fail("Node type registration should be denied.");
  }
 catch (  AccessDeniedException e) {
  }
  try {
    ntm.registerNodeType(ntd,false);
    fail("Node type registration should be denied.");
  }
 catch (  AccessDeniedException e) {
  }
  NodeTypeTemplate[] ntds=new NodeTypeTemplate[2];
  ntds[0]=ntd;
  ntds[1]=ntm.createNodeTypeTemplate();
  ntds[1].setName("anotherRegisterNodeType");
  ntds[1].setDeclaredSuperTypeNames(new String[]{"nt:file"});
  try {
    ntm.registerNodeTypes(ntds,true);
    fail("Node type registration should be denied.");
  }
 catch (  AccessDeniedException e) {
  }
  try {
    ntm.registerNodeTypes(ntds,false);
    fail("Node type registration should be denied.");
  }
 catch (  AccessDeniedException e) {
  }
}
