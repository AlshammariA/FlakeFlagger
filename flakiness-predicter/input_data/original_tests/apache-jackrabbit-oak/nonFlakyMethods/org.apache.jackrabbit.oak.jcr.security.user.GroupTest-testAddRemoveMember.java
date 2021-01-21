@Test public void testAddRemoveMember() throws NotExecutableException, RepositoryException {
  User auth=getTestUser(superuser);
  Group newGroup1=null;
  Group newGroup2=null;
  try {
    newGroup1=userMgr.createGroup(createGroupId());
    newGroup2=userMgr.createGroup(createGroupId());
    superuser.save();
    assertFalse(newGroup1.isMember(auth));
    assertFalse(newGroup1.removeMember(auth));
    superuser.save();
    assertFalse(newGroup2.isMember(auth));
    assertFalse(newGroup2.removeMember(auth));
    superuser.save();
    assertTrue(newGroup1.addMember(auth));
    superuser.save();
    assertTrue(newGroup1.isMember(auth));
    assertTrue(newGroup1.isMember(userMgr.getAuthorizable(auth.getID())));
    assertTrue(newGroup2.addMember(auth));
    superuser.save();
    assertTrue(newGroup2.isMember(auth));
    assertTrue(newGroup2.isMember(userMgr.getAuthorizable(auth.getID())));
    assertTrue(newGroup1.removeMember(auth));
    superuser.save();
    assertTrue(newGroup2.removeMember(auth));
    superuser.save();
    assertTrue(newGroup1.addMember(auth));
    superuser.save();
    assertTrue(newGroup1.isMember(auth));
    assertTrue(newGroup1.isMember(userMgr.getAuthorizable(auth.getID())));
    assertTrue(newGroup1.removeMember(auth));
    superuser.save();
  }
  finally {
    if (newGroup1 != null) {
      newGroup1.removeMember(auth);
      newGroup1.remove();
      superuser.save();
    }
    if (newGroup2 != null) {
      newGroup2.removeMember(auth);
      newGroup2.remove();
      superuser.save();
    }
  }
}
