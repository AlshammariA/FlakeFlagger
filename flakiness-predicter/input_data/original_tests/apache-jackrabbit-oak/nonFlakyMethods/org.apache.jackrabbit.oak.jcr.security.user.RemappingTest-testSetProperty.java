@Test public void testSetProperty() throws Exception {
  for (  String relPath : mappedPaths) {
    authorizable.setProperty(relPath,nameValue);
    authorizable.setProperty(relPath,new Value[]{nameValue});
  }
}
