@Test public void testRemoveGroupIfMemberExist() throws RepositoryException, NotExecutableException {
  User auth=getTestUser(superuser);
  String newGroupId=null;
  try {
    Group newGroup=userMgr.createGroup(createGroupId());
    superuser.save();
    newGroupId=newGroup.getID();
    assertTrue(newGroup.addMember(auth));
    newGroup.remove();
    superuser.save();
  }
  finally {
    Group gr=(Group)userMgr.getAuthorizable(newGroupId);
    if (gr != null) {
      gr.removeMember(auth);
      gr.remove();
      superuser.save();
    }
  }
}
