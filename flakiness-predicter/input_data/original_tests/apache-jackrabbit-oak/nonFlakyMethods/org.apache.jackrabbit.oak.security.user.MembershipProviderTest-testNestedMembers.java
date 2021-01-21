@Test public void testNestedMembers() throws Exception {
  Set<String> members=new HashSet<String>();
  Set<String> declaredMembers=new HashSet<String>();
  Group grp=createGroup();
  for (int i=0; i < 10; i++) {
    Group g1=createGroup();
    grp.addMember(g1);
    members.add(g1.getID());
    declaredMembers.add(g1.getID());
    for (int j=0; j < 10; j++) {
      Group g2=createGroup();
      g1.addMember(g2);
      members.add(g2.getID());
      for (int k=0; k < 10; k++) {
        User usr=createUser();
        g2.addMember(usr);
        members.add(usr.getID());
      }
    }
  }
  root.commit();
  checkMembers(grp,members);
  Iterator<Authorizable> iter=grp.getDeclaredMembers();
  while (iter.hasNext()) {
    Authorizable member=iter.next();
    Assert.assertTrue(declaredMembers.remove(member.getID()));
  }
  assertEquals(0,declaredMembers.size());
}
