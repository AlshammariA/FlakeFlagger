@Test public void testHasProperty() throws Exception {
  for (  String relPath : mappedPaths) {
    assertTrue(authorizable.hasProperty(relPath));
  }
}
