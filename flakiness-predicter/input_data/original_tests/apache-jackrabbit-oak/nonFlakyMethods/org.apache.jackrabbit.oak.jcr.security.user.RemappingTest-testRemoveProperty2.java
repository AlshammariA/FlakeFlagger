@Test public void testRemoveProperty2() throws Exception {
  for (  String relPath : unmappedPaths) {
    try {
      authorizable.removeProperty(relPath);
      fail();
    }
 catch (    RepositoryException e) {
    }
  }
}
