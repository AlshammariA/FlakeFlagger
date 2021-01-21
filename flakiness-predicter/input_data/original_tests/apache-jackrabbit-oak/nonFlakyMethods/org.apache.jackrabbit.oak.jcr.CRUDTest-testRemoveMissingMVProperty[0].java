@Test public void testRemoveMissingMVProperty() throws RepositoryException {
  Session session=getAdminSession();
  Node root=session.getRootNode();
  Property p=root.setProperty("missing",(String[])null);
  assertNotNull(p);
  try {
    p.getValues();
    fail("must throw InvalidItemStateException");
  }
 catch (  InvalidItemStateException e) {
  }
}
