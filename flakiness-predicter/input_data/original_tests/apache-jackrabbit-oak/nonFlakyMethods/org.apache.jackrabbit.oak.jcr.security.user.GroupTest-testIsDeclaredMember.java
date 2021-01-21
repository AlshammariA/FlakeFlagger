@Test public void testIsDeclaredMember() throws RepositoryException, NotExecutableException {
  User auth=getTestUser(superuser);
  Group newGroup1=null;
  Group newGroup2=null;
  try {
    newGroup1=userMgr.createGroup(createGroupId());
    newGroup2=userMgr.createGroup(createGroupId());
    superuser.save();
    assertFalse(newGroup1.isDeclaredMember(auth));
    assertFalse(newGroup2.isDeclaredMember(auth));
    assertTrue(newGroup2.addMember(auth));
    superuser.save();
    assertTrue(newGroup2.isDeclaredMember(auth));
    assertTrue(newGroup2.isDeclaredMember(userMgr.getAuthorizable(auth.getID())));
    assertTrue(newGroup1.addMember(newGroup2));
    superuser.save();
    assertTrue(newGroup1.isDeclaredMember(newGroup2));
    assertTrue(newGroup1.isDeclaredMember(userMgr.getAuthorizable(newGroup2.getID())));
    assertTrue(newGroup1.isMember(auth));
    assertTrue(newGroup1.isMember(userMgr.getAuthorizable(auth.getID())));
    assertFalse(newGroup1.isDeclaredMember(auth));
    assertFalse(newGroup1.isDeclaredMember(userMgr.getAuthorizable(auth.getID())));
  }
  finally {
    if (newGroup1 != null) {
      newGroup1.remove();
      superuser.save();
    }
    if (newGroup2 != null) {
      newGroup2.remove();
      superuser.save();
    }
  }
}
