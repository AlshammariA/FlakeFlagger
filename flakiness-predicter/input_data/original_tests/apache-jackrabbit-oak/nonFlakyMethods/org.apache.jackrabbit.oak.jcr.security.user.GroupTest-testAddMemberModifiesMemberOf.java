@Test public void testAddMemberModifiesMemberOf() throws NotExecutableException, RepositoryException {
  User auth=getTestUser(superuser);
  Group newGroup=null;
  try {
    newGroup=userMgr.createGroup(createGroupId());
    superuser.save();
    assertFalseMemberOfContainsGroup(auth.memberOf(),newGroup);
    assertTrue(newGroup.addMember(auth));
    superuser.save();
    assertTrueMemberOfContainsGroup(auth.declaredMemberOf(),newGroup);
    assertTrueMemberOfContainsGroup(auth.memberOf(),newGroup);
  }
  finally {
    if (newGroup != null) {
      newGroup.removeMember(auth);
      newGroup.remove();
      superuser.save();
    }
  }
}
