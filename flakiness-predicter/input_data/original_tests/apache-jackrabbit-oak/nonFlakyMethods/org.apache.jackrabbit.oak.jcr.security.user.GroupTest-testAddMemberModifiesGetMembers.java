@Test public void testAddMemberModifiesGetMembers() throws NotExecutableException, RepositoryException {
  User auth=getTestUser(superuser);
  Group newGroup=null;
  try {
    newGroup=userMgr.createGroup(createGroupId());
    superuser.save();
    assertFalseIsMember(newGroup.getMembers(),auth);
    assertFalseIsMember(newGroup.getDeclaredMembers(),auth);
    assertTrue(newGroup.addMember(auth));
    superuser.save();
    assertTrueIsMember(newGroup.getMembers(),auth);
    assertTrueIsMember(newGroup.getDeclaredMembers(),auth);
  }
  finally {
    if (newGroup != null) {
      newGroup.removeMember(auth);
      newGroup.remove();
      superuser.save();
    }
  }
}
