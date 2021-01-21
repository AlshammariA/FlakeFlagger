@Test public void verifyNewBuiltinNodeTypes() throws Exception {
  Session session=createAdminSession();
  try {
    NodeTypeManager manager=session.getWorkspace().getNodeTypeManager();
    assertTrue(manager.hasNodeType(UserConstants.NT_REP_MEMBER_REFERENCES));
    assertTrue(manager.hasNodeType(IndexConstants.INDEX_DEFINITIONS_NODE_TYPE));
  }
  finally {
    session.logout();
  }
}
