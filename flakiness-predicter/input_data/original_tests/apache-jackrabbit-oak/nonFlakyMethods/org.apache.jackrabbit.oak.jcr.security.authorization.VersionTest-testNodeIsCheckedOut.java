@Test public void testNodeIsCheckedOut() throws RepositoryException {
  Session s=repository.login(new GuestCredentials());
  sessions.add(s);
  assertFalse(s.nodeExists("/"));
  assertTrue(s.nodeExists("/testNode"));
  assertTrue(s.getWorkspace().getVersionManager().isCheckedOut("/testNode"));
}
