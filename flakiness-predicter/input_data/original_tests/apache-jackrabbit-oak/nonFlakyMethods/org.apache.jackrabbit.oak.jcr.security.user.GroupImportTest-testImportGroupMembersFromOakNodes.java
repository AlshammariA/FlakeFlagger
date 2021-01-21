/** 
 * @since OAK 1.0 : Importing new rep:MembershipReferences structure
 */
@Test public void testImportGroupMembersFromOakNodes() throws Exception {
  List<String> createdUsers=new LinkedList<String>();
  Node target=getTargetNode();
  try {
    for (int i=0; i < 32; i++) {
      String user="testUser" + i;
      if (userMgr.getAuthorizable(user) == null) {
        userMgr.createUser(user,user);
        createdUsers.add(user);
      }
    }
    if (!userMgr.isAutoSave()) {
      adminSession.save();
    }
    doImport(getTargetPath(),getClass().getSimpleName() + "-testImportGroupMembersFromOakNodes.xml");
    if (!userMgr.isAutoSave()) {
      adminSession.save();
    }
    Authorizable authorizable=userMgr.getAuthorizable("testGroup");
    assertNotNull("testGroup authorizable must exist",authorizable);
    assertTrue("testGroup authorizable must be a group",authorizable.isGroup());
    Group testGroup=(Group)authorizable;
    for (int i=0; i < 32; i++) {
      String user="testUser" + i;
      assertTrue(user + " should be member of " + testGroup,testGroup.isMember(userMgr.getAuthorizable(user)));
    }
    authorizable=userMgr.getAuthorizable("shrimps");
    assertNotNull("shrimps authorizable must exist",authorizable);
    assertTrue("shrimps authorizable must be a group",authorizable.isGroup());
    testGroup=(Group)authorizable;
    for (int i=0; i < 32; i++) {
      String user="testUser" + i;
      assertTrue(user + " should be member of " + testGroup,testGroup.isMember(userMgr.getAuthorizable(user)));
    }
  }
  finally {
    adminSession.refresh(false);
    for (    String user : createdUsers) {
      Authorizable a=userMgr.getAuthorizable(user);
      if (a != null && !a.isGroup()) {
        a.remove();
      }
    }
    for (NodeIterator it=target.getNodes(); it.hasNext(); ) {
      it.nextNode().remove();
    }
    adminSession.save();
  }
}
