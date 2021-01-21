@Test public void nodeTypeRegistry() throws RepositoryException {
  NodeTypeManager ntMgr=getAdminSession().getWorkspace().getNodeTypeManager();
  assertFalse(ntMgr.hasNodeType("foo"));
  NodeTypeTemplate ntd=ntMgr.createNodeTypeTemplate();
  ntd.setName("foo");
  ntMgr.registerNodeType(ntd,false);
  assertTrue(ntMgr.hasNodeType("foo"));
  ntMgr.unregisterNodeType("foo");
  assertFalse(ntMgr.hasNodeType("foo"));
}
