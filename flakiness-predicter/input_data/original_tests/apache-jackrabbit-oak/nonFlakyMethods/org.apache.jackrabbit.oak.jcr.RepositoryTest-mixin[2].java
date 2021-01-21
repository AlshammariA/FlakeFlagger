@Test public void mixin() throws RepositoryException {
  NodeTypeManager ntMgr=getAdminSession().getWorkspace().getNodeTypeManager();
  NodeTypeTemplate mixTest=ntMgr.createNodeTypeTemplate();
  mixTest.setName("mix:test");
  mixTest.setMixin(true);
  ntMgr.registerNodeType(mixTest,false);
  Node testNode=getNode(TEST_PATH);
  NodeType[] mix=testNode.getMixinNodeTypes();
  assertEquals(0,mix.length);
  testNode.addMixin("mix:test");
  testNode.getSession().save();
  Session session2=createAnonymousSession();
  try {
    mix=session2.getNode(TEST_PATH).getMixinNodeTypes();
    assertEquals(1,mix.length);
    assertEquals("mix:test",mix[0].getName());
  }
  finally {
    session2.logout();
  }
  testNode.removeMixin("mix:test");
}
