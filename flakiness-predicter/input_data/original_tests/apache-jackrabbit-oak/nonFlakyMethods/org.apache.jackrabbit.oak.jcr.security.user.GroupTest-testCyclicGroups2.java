@Test public void testCyclicGroups2() throws AuthorizableExistsException, RepositoryException, NotExecutableException {
  Group group1=null;
  Group group2=null;
  Group group3=null;
  try {
    group1=userMgr.createGroup(createGroupId());
    group2=userMgr.createGroup(createGroupId());
    group3=userMgr.createGroup(createGroupId());
    assertTrue(group1.addMember(group2));
    assertTrue(group2.addMember(group3));
    assertFalse("Cyclic group membership must be detected.",group3.addMember(group1));
  }
 catch (  RepositoryException e) {
  }
 finally {
    if (group1 != null)     group1.remove();
    if (group2 != null)     group2.remove();
    if (group3 != null)     group3.remove();
  }
}
