@Test public void testRemoveProperty() throws Exception {
  for (  String relPath : mappedPaths) {
    authorizable.removeProperty(relPath);
  }
}
