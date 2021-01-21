@Test public void testNestedMemberships() throws Exception {
  Set<String> memberships=new HashSet<String>();
  User user=createUser();
  Group grp=createGroup();
  memberships.add(grp.getID());
  for (int i=0; i < 10; i++) {
    Group g1=createGroup();
    grp.addMember(g1);
    memberships.add(g1.getID());
    for (int j=0; j < 10; j++) {
      Group g2=createGroup();
      g1.addMember(g2);
      memberships.add(g2.getID());
      g2.addMember(user);
    }
  }
  root.commit();
  Iterator<Group> iter=user.memberOf();
  while (iter.hasNext()) {
    Group group=iter.next();
    Assert.assertTrue(memberships.remove(group.getID()));
  }
  assertEquals(0,memberships.size());
}
