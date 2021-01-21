@Test public void testRemoveMissingProperty() throws RepositoryException {
  Session session=getAdminSession();
  Node root=session.getRootNode();
  Property p=root.setProperty("missing",(String)null);
  assertNotNull(p);
  try {
    p.getValue();
    fail("must throw InvalidItemStateException");
  }
 catch (  InvalidItemStateException e) {
  }
}
