@Test public void testManyMemberships() throws Exception {
  Set<String> memberships=new HashSet<String>();
  User usr=createUser();
  for (int i=0; i < NUM_GROUPS; i++) {
    Group grp=createGroup();
    grp.addMember(usr);
    memberships.add(grp.getID());
  }
  root.commit();
  Iterator<Group> iter=usr.declaredMemberOf();
  while (iter.hasNext()) {
    Group group=iter.next();
    Assert.assertTrue(memberships.remove(group.getID()));
  }
  assertEquals(0,memberships.size());
}
