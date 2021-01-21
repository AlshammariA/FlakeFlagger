@Test public void testRemoveGroupClearsMembership() throws NotExecutableException, RepositoryException {
  User auth=getTestUser(superuser);
  Group newGroup=null;
  String groupId;
  try {
    newGroup=userMgr.createGroup(createGroupId());
    groupId=newGroup.getID();
    superuser.save();
    assertTrue(newGroup.addMember(auth));
    superuser.save();
    boolean isMember=false;
    Iterator<Group> it=auth.declaredMemberOf();
    while (it.hasNext() && !isMember) {
      isMember=groupId.equals(it.next().getID());
    }
    assertTrue(isMember);
  }
  finally {
    if (newGroup != null) {
      newGroup.remove();
      superuser.save();
    }
  }
  Iterator<Group> it=auth.declaredMemberOf();
  while (it.hasNext()) {
    assertFalse(groupId.equals(it.next().getID()));
  }
  it=auth.memberOf();
  while (it.hasNext()) {
    assertFalse(groupId.equals(it.next().getID()));
  }
}
