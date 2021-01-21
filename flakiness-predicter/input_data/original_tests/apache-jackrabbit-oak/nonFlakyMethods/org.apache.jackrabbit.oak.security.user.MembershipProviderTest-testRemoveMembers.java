@Test public void testRemoveMembers() throws Exception {
  Set<String> members=new HashSet<String>();
  String[] users=new String[NUM_USERS];
  Group grp=createGroup();
  for (int i=0; i < NUM_USERS; i++) {
    User usr=createUser();
    grp.addMember(usr);
    members.add(usr.getID());
    users[i]=usr.getID();
  }
  root.commit();
  for (int i=0; i < SIZE_TH; i++) {
    Authorizable auth=userMgr.getAuthorizable(users[i]);
    members.remove(users[i]);
    grp.removeMember(auth);
  }
  root.commit();
  checkMembers(grp,members);
  Tree tree=root.getTree(grp.getPath());
  assertNull("rep:members property not exist",tree.getProperty(UserConstants.REP_MEMBERS));
  for (int i=0; i < SIZE_TH / 2; i++) {
    Authorizable auth=userMgr.getAuthorizable(users[i]);
    members.add(users[i]);
    grp.addMember(auth);
  }
  root.commit();
  assertEquals("rep:members property must have correct number of references",SIZE_TH / 2,tree.getProperty(UserConstants.REP_MEMBERS).count());
  checkMembers(grp,members);
  for (int i=2 * SIZE_TH; i < (3 * SIZE_TH); i++) {
    Authorizable auth=userMgr.getAuthorizable(users[i]);
    members.remove(users[i]);
    grp.removeMember(auth);
  }
  root.commit();
  checkMembers(grp,members);
  Tree membersList=tree.getChild(UserConstants.REP_MEMBERS_LIST);
  assertFalse("the first overflow node must not exist",membersList.getChild("1").exists());
  for (int i=2 * SIZE_TH; i < (3 * SIZE_TH); i++) {
    Authorizable auth=userMgr.getAuthorizable(users[i]);
    members.add(users[i]);
    grp.addMember(auth);
  }
  root.commit();
  checkMembers(grp,members);
  membersList=tree.getChild(UserConstants.REP_MEMBERS_LIST);
  assertTrue("the first overflow node must not exist",membersList.getChild("1").exists());
}
