@Test public void testAddMemberTwice() throws NotExecutableException, RepositoryException {
  User auth=getTestUser(superuser);
  Group newGroup=null;
  try {
    newGroup=userMgr.createGroup(createGroupId());
    superuser.save();
    assertTrue(newGroup.addMember(auth));
    superuser.save();
    assertFalse(newGroup.addMember(auth));
    superuser.save();
    assertTrue(newGroup.isMember(auth));
  }
  finally {
    if (newGroup != null) {
      newGroup.removeMember(auth);
      newGroup.remove();
      superuser.save();
    }
  }
}
