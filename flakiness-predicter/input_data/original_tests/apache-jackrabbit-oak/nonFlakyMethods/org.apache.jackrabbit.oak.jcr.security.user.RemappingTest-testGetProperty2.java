@Test public void testGetProperty2() throws Exception {
  for (  String relPath : unmappedPaths) {
    try {
      authorizable.getProperty(relPath);
      fail();
    }
 catch (    RepositoryException e) {
    }
  }
}
