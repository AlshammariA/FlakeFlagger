@Test public void testEditMembers() throws RepositoryException, NotExecutableException {
  assertFalse(everyone.addMember(getTestUser(superuser)));
  assertFalse(everyone.removeMember(getTestUser(superuser)));
  Group anotherGroup=null;
  try {
    anotherGroup=userMgr.createGroup("testGroup");
    superuser.save();
    assertFalse(everyone.addMember(anotherGroup));
    assertFalse(everyone.removeMember(anotherGroup));
    assertFalse(anotherGroup.addMember(everyone));
    assertFalse(anotherGroup.removeMember(everyone));
  }
  finally {
    if (anotherGroup != null) {
      anotherGroup.remove();
      superuser.save();
    }
  }
}
