@Test public void testRegisterNodeTypeWithPrivilege() throws Exception {
  modify(null,JCR_NODE_TYPE_DEFINITION_MANAGEMENT.toString(),true);
  try {
    Workspace testWsp=testSession.getWorkspace();
    NodeTypeManager ntm=testWsp.getNodeTypeManager();
    NodeTypeTemplate ntd=ntm.createNodeTypeTemplate();
    ntd.setName("testRegisterNodeTypeWithPrivilege");
    ntd.setMixin(true);
    ntm.registerNodeType(ntd,true);
    NodeTypeTemplate[] ntds=new NodeTypeTemplate[2];
    ntds[0]=ntd;
    ntds[1]=ntm.createNodeTypeTemplate();
    ntds[1].setName("anotherRegisterNodeTypeWithPrivilege");
    ntds[1].setDeclaredSuperTypeNames(new String[]{"nt:file"});
    ntm.registerNodeTypes(ntds,true);
  }
  finally {
    modify(null,JCR_NODE_TYPE_DEFINITION_MANAGEMENT.toString(),false);
  }
}
