@Test public void verifyGroupNodeTypes() throws Exception {
  JackrabbitSession session=createAdminSession();
  try {
    UserManager userMgr=session.getUserManager();
    for (int i=0; i < getNumGroups(); i++) {
      Group grp=(Group)userMgr.getAuthorizable(TEST_GROUP_PREFIX + i);
      assertNotNull(grp);
      Node grpNode=session.getNode(grp.getPath());
      NodeType nt=grpNode.getPrimaryNodeType();
      assertEquals("Migrated group needs to be rep:Group",UserConstants.NT_REP_GROUP,nt.getName());
      assertTrue("Migrated group needs to be new node type",nt.isNodeType(UserConstants.NT_REP_MEMBER_REFERENCES));
    }
  }
  finally {
    session.logout();
  }
}
