@Test public void testAddItselfAsMember() throws RepositoryException, NotExecutableException {
  Group newGroup=null;
  try {
    newGroup=userMgr.createGroup(createGroupId());
    superuser.save();
    assertFalse(newGroup.addMember(newGroup));
    superuser.save();
    newGroup.removeMember(newGroup);
    superuser.save();
  }
  finally {
    if (newGroup != null) {
      newGroup.remove();
      superuser.save();
    }
  }
}
