@Test public void removeNode2() throws RepositoryException {
  Node foo=getNode("/foo");
  getAdminSession().removeItem(foo.getPath());
  try {
    foo.getParent();
    fail("Cannot retrieve the parent from a transiently removed item.");
  }
 catch (  InvalidItemStateException e) {
  }
}
