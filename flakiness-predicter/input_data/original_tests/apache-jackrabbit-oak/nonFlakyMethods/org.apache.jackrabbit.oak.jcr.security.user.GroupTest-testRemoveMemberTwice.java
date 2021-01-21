@Test public void testRemoveMemberTwice() throws NotExecutableException, RepositoryException {
  User auth=getTestUser(superuser);
  Group newGroup=null;
  try {
    newGroup=userMgr.createGroup(createGroupId());
    superuser.save();
    assertTrue(newGroup.addMember(auth));
    superuser.save();
    assertTrue(newGroup.removeMember(userMgr.getAuthorizable(auth.getID())));
    superuser.save();
    assertFalse(newGroup.removeMember(auth));
    superuser.save();
  }
  finally {
    if (newGroup != null) {
      newGroup.remove();
      superuser.save();
    }
  }
}
