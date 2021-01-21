@Test public void accessRemovedProperty() throws RepositoryException {
  Node foo=getNode("/foo");
  Property p=foo.setProperty("name","value");
  p.remove();
  try {
    p.getPath();
    fail("Expected InvalidItemStateException");
  }
 catch (  InvalidItemStateException expected) {
  }
}
