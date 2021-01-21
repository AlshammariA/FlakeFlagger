@Test public void testGroup() throws Exception {
  User u=mgr.createUser("u","u");
  Group g=mgr.createGroup("g");
  assertTrue(g.addMember(u));
  assertFalse(root.hasPendingChanges());
  assertTrue(g.isDeclaredMember(u));
  Iterator<Authorizable> it=g.getDeclaredMembers();
  if (it.hasNext()) {
    Authorizable a=it.next();
    assertTrue(a instanceof AuthorizableImpl);
    a.setProperty("prop",getValueFactory().createValue("blub"));
    assertFalse(root.hasPendingChanges());
  }
  it=g.getMembers();
  if (it.hasNext()) {
    Authorizable a=it.next();
    assertTrue(a instanceof AuthorizableImpl);
    a.setProperty("prop",getValueFactory().createValue("blub"));
    assertFalse(root.hasPendingChanges());
  }
  assertTrue(g.removeMember(u));
  assertFalse(root.hasPendingChanges());
  assertFalse(g.isDeclaredMember(u));
}
