@Test public void verifyMemberOf() throws Exception {
  JackrabbitSession session=createAdminSession();
  try {
    UserManager userMgr=session.getUserManager();
    for (int i=0; i < getNumUsers(); i++) {
      User user=(User)userMgr.getAuthorizable(TEST_USER_PREFIX + i);
      assertNotNull(user);
      Set<String> groups=new HashSet<String>();
      for (int j=0; j < getNumGroups(); j++) {
        groups.add(TEST_GROUP_PREFIX + j);
      }
      Iterator<Group> groupIterator=user.declaredMemberOf();
      while (groupIterator.hasNext()) {
        Group grp=groupIterator.next();
        assertTrue("user must be member of group " + grp.getID(),groups.remove(grp.getID()));
      }
      assertEquals("user " + user.getID() + " must be member of all groups",0,groups.size());
    }
  }
  finally {
    session.logout();
  }
}
