@Test public void testIndirectMembers() throws NotExecutableException, RepositoryException {
  User user=getTestUser(superuser);
  Group newGroup=null;
  Group newGroup2=null;
  try {
    newGroup=userMgr.createGroup(createGroupId());
    newGroup2=userMgr.createGroup(createGroupId());
    superuser.save();
    newGroup.addMember(newGroup2);
    superuser.save();
    assertTrue(newGroup.isMember(newGroup2));
    newGroup2.addMember(user);
    superuser.save();
    assertFalseIsMember(newGroup.getDeclaredMembers(),user);
    assertFalseMemberOfContainsGroup(user.declaredMemberOf(),newGroup);
    assertTrueIsMember(newGroup.getMembers(),user);
    assertTrueMemberOfContainsGroup(user.memberOf(),newGroup);
    assertFalse(newGroup.removeMember(user));
    superuser.save();
  }
  finally {
    if (newGroup != null) {
      newGroup.removeMember(newGroup2);
      newGroup.remove();
      superuser.save();
    }
    if (newGroup2 != null) {
      newGroup2.removeMember(user);
      newGroup2.remove();
      superuser.save();
    }
  }
}
