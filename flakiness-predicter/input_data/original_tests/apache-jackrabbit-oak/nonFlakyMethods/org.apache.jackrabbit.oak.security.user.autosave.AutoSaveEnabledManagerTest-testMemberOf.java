@Test public void testMemberOf() throws Exception {
  User u=mgr.createUser("u","u");
  Group g=mgr.createGroup("g");
  assertTrue(g.addMember(u));
  Iterator<Group> groups=u.memberOf();
  assertTrue(groups.hasNext());
  Group gAgain=groups.next();
  assertTrue(gAgain instanceof GroupImpl);
  assertTrue(gAgain.removeMember(u));
  assertFalse(root.hasPendingChanges());
  assertFalse(u.declaredMemberOf().hasNext());
}
