@Test public void testAddMember() throws NotExecutableException, RepositoryException {
  User auth=getTestUser(superuser);
  Group newGroup=null;
  try {
    newGroup=userMgr.createGroup(createGroupId());
    superuser.save();
    assertFalse(newGroup.isMember(auth));
    assertFalse(newGroup.removeMember(auth));
    superuser.save();
    assertTrue(newGroup.addMember(auth));
    superuser.save();
    assertTrue(newGroup.isMember(auth));
    assertTrue(newGroup.isMember(userMgr.getAuthorizable(auth.getID())));
  }
  finally {
    if (newGroup != null) {
      newGroup.removeMember(auth);
      newGroup.remove();
      superuser.save();
    }
  }
}
