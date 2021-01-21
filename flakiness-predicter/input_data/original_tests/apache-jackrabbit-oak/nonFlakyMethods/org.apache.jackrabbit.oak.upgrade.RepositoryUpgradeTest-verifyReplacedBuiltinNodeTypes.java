@Test public void verifyReplacedBuiltinNodeTypes() throws Exception {
  Session session=createAdminSession();
  try {
    NodeTypeManager manager=session.getWorkspace().getNodeTypeManager();
    NodeType nt=manager.getNodeType(UserConstants.NT_REP_GROUP);
    assertTrue("Migrated repository must have new nodetype definitions",nt.isNodeType(UserConstants.NT_REP_MEMBER_REFERENCES));
  }
  finally {
    session.logout();
  }
}
