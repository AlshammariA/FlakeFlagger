@Test public void testDeeplyNestedGroups() throws NotExecutableException, RepositoryException {
  Set<Group> groups=new HashSet<Group>();
  try {
    User auth=getTestUser(superuser);
    Group topGroup=userMgr.createGroup(createGroupId());
    Group bottomGroup=topGroup;
    for (int k=0; k < 100; k++) {
      Group g=userMgr.createGroup(createGroupId());
      groups.add(g);
      bottomGroup.addMember(g);
      bottomGroup=g;
    }
    bottomGroup.addMember(auth);
    for (    Group g : groups) {
      Iterator<Authorizable> declaredMembers=g.getDeclaredMembers();
      assertTrue(declaredMembers.hasNext());
      declaredMembers.next();
      assertFalse(declaredMembers.hasNext());
    }
    HashSet<Group> allGroups=new HashSet<Group>(groups);
    for (Iterator<Authorizable> it=topGroup.getMembers(); it.hasNext(); ) {
      Authorizable a=it.next();
      assertTrue(a.equals(auth) || allGroups.remove(a));
    }
    assertTrue(allGroups.isEmpty());
  }
  finally {
    for (    Group g : groups) {
      g.remove();
    }
  }
}
