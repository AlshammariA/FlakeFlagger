@Test public void testImportGroupMembersFromNodes() throws Exception {
  List<String> createdUsers=new LinkedList<String>();
  Node target=getTargetNode();
  try {
    String[] users={"angi","adi","hansi","lisi","luzi","susi","pipi","hari","gabi","eddi","debbi","cati","admin","anonymous"};
    for (    String user : users) {
      if (userMgr.getAuthorizable(user) == null) {
        userMgr.createUser(user,user);
        createdUsers.add(user);
      }
    }
    if (!userMgr.isAutoSave()) {
      adminSession.save();
    }
    doImport(getTargetPath(),getClass().getSimpleName() + "-testImportGroupMembersFromNodes.xml");
    if (!userMgr.isAutoSave()) {
      adminSession.save();
    }
    Authorizable aShrimps=userMgr.getAuthorizable("shrimps");
    assertNotNull("Shrimps authorizable must exist",aShrimps);
    assertTrue("Shrimps authorizable must be a group",aShrimps.isGroup());
    Group gShrimps=(Group)aShrimps;
    for (    String user : users) {
      assertTrue(user + " should be member of " + gShrimps,gShrimps.isMember(userMgr.getAuthorizable(user)));
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
