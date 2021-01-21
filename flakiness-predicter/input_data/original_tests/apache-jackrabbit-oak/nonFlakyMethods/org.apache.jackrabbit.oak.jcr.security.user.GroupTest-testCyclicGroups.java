@Test public void testCyclicGroups() throws AuthorizableExistsException, RepositoryException, NotExecutableException {
  Group group1=null;
  Group group2=null;
  Group group3=null;
  try {
    group1=userMgr.createGroup(createGroupId());
    group2=userMgr.createGroup(createGroupId());
    group3=userMgr.createGroup(createGroupId());
    assertTrue(group1.addMember(group2));
    superuser.save();
    assertTrue(group2.addMember(group3));
    superuser.save();
    assertFalse(group3.addMember(group1));
    superuser.save();
  }
  finally {
    if (group1 != null)     group1.remove();
    if (group2 != null)     group2.remove();
    if (group3 != null)     group3.remove();
  }
}
