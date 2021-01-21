@Test public void accessRemovedItem() throws RepositoryException {
  Node foo=getNode("/foo");
  Node bar=foo.addNode("bar");
  Property p=bar.setProperty("name","value");
  foo.remove();
  try {
    bar.getPath();
    fail("Expected InvalidItemStateException");
  }
 catch (  InvalidItemStateException expected) {
  }
  try {
    p.getPath();
    fail("Expected InvalidItemStateException");
  }
 catch (  InvalidItemStateException expected) {
  }
}
