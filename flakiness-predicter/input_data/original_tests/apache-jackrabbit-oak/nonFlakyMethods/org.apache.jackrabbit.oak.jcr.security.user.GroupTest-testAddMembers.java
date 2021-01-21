@Test public void testAddMembers() throws NotExecutableException, RepositoryException {
  User auth=getTestUser(superuser);
  Group newGroup=null;
  int size=100;
  List<User> users=new ArrayList<User>(size);
  try {
    newGroup=userMgr.createGroup(createGroupId());
    superuser.save();
    for (int k=0; k < size; k++) {
      users.add(userMgr.createUser("user_" + k,"pass_" + k));
    }
    superuser.save();
    for (    User user : users) {
      assertTrue(newGroup.addMember(user));
    }
    superuser.save();
    for (    User user : users) {
      assertTrue(newGroup.isMember(user));
    }
    for (    User user : users) {
      assertTrue(newGroup.removeMember(user));
    }
    superuser.save();
    for (    User user : users) {
      assertFalse(newGroup.isMember(user));
    }
  }
  finally {
    for (    User user : users) {
      user.remove();
      superuser.save();
    }
    if (newGroup != null) {
      newGroup.removeMember(auth);
      newGroup.remove();
      superuser.save();
    }
  }
}
