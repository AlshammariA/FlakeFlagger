@Test public void testHasProperty2() throws Exception {
  for (  String relPath : unmappedPaths) {
    try {
      authorizable.hasProperty(relPath);
      fail();
    }
 catch (    RepositoryException e) {
    }
  }
}
