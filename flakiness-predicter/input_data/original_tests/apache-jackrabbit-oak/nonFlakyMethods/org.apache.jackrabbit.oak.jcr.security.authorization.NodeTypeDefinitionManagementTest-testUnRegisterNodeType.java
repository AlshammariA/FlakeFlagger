@Test public void testUnRegisterNodeType() throws Exception {
  NodeTypeManager ntm=superuser.getWorkspace().getNodeTypeManager();
  NodeTypeTemplate ntd=ntm.createNodeTypeTemplate();
  ntd.setName("testUnregisterNodeType");
  ntd.setMixin(true);
  ntm.registerNodeType(ntd,true);
  Workspace testWsp=testSession.getWorkspace();
  try {
    try {
      NodeTypeManager testNtm=testWsp.getNodeTypeManager();
      testNtm.unregisterNodeType(ntd.getName());
      fail("Node type unregistration should be denied.");
    }
 catch (    AccessDeniedException e) {
    }
    try {
      NodeTypeManager testNtm=testWsp.getNodeTypeManager();
      testNtm.unregisterNodeTypes(new String[]{ntd.getName()});
      fail("Node type unregistration should be denied.");
    }
 catch (    AccessDeniedException e) {
    }
  }
  finally {
    ntm.unregisterNodeType(ntd.getName());
  }
}
