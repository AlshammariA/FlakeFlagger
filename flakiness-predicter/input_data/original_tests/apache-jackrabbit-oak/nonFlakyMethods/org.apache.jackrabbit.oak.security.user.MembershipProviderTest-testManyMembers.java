@Test public void testManyMembers() throws Exception {
  Set<String> members=new HashSet<String>();
  Group grp=createGroup();
  for (int i=0; i < NUM_USERS; i++) {
    User usr=createUser();
    grp.addMember(usr);
    members.add(usr.getID());
  }
  root.commit();
  checkMembers(grp,members);
  Tree tree=root.getTree(grp.getPath());
  assertEquals("rep:members property must have correct number of references",SIZE_TH,tree.getProperty(UserConstants.REP_MEMBERS).count());
  Tree membersList=tree.getChild(UserConstants.REP_MEMBERS_LIST);
  assertTrue("rep:memberList must exist",membersList.exists());
  assertEquals("rep:memberList must have correct primary type.",UserConstants.NT_REP_MEMBER_REFERENCES_LIST,membersList.getProperty(JcrConstants.JCR_PRIMARYTYPE).getValue(Type.STRING));
  assertEquals("rep:memberList must have correct number of child nodes.",(NUM_USERS / SIZE_TH) - 1,membersList.getChildrenCount(Long.MAX_VALUE));
}
