@Test public void testSetProperty2() throws Exception {
  for (  String relPath : unmappedPaths) {
    try {
      authorizable.setProperty(relPath,nameValue);
      fail();
    }
 catch (    RepositoryException e) {
    }
    try {
      authorizable.setProperty(relPath,new Value[]{nameValue});
      fail();
    }
 catch (    RepositoryException e) {
    }
  }
}
