@Test public void testGetPropertyNames3() throws Exception {
  try {
    Iterator it=authorizable.getPropertyNames("uTest:node");
    fail();
  }
 catch (  RepositoryException e) {
  }
}
