@Test public void verifyMembers() throws Exception {
  JackrabbitSession session=createAdminSession();
  try {
    UserManager userMgr=session.getUserManager();
    for (int i=0; i < getNumGroups(); i++) {
      Group grp=(Group)userMgr.getAuthorizable(TEST_GROUP_PREFIX + i);
      assertNotNull(grp);
      Set<String> testUsers=new HashSet<String>();
      for (int j=0; j < getNumUsers(); j++) {
        testUsers.add(TEST_USER_PREFIX + j);
      }
      Iterator<Authorizable> declaredMembers=grp.getDeclaredMembers();
      while (declaredMembers.hasNext()) {
        Authorizable auth=declaredMembers.next();
        assertTrue("group must have member " + auth.getID(),testUsers.remove(auth.getID()));
      }
      assertEquals("group must have all members",0,testUsers.size());
    }
  }
  finally {
    session.logout();
  }
}
