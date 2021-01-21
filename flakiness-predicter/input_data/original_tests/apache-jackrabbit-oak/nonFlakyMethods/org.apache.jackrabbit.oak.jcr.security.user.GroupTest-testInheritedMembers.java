@Test public void testInheritedMembers() throws Exception {
  Set<Authorizable> authorizables=new HashSet<Authorizable>();
  try {
    User testUser=userMgr.createUser(createUserId(),"pw");
    authorizables.add(testUser);
    Group group1=userMgr.createGroup(createGroupId());
    authorizables.add(group1);
    Group group2=userMgr.createGroup(createGroupId());
    authorizables.add(group2);
    Group group3=userMgr.createGroup(createGroupId());
    group1.addMember(testUser);
    group2.addMember(testUser);
    group3.addMember(group1);
    group3.addMember(group2);
    Iterator<Authorizable> members=group3.getMembers();
    while (members.hasNext()) {
      Authorizable a=members.next();
      assertTrue(authorizables.contains(a));
      assertTrue(authorizables.remove(a));
    }
    assertTrue(authorizables.isEmpty());
  }
  finally {
    for (    Authorizable a : authorizables) {
      a.remove();
    }
  }
}
