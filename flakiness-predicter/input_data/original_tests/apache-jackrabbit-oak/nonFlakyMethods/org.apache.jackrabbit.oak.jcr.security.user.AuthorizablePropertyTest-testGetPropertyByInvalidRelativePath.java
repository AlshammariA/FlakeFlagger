@Test public void testGetPropertyByInvalidRelativePath() throws NotExecutableException, RepositoryException {
  List<String> wrongPaths=new ArrayList<String>();
  wrongPaths.add("../jcr:primaryType");
  wrongPaths.add("../../jcr:primaryType");
  wrongPaths.add("../testing/jcr:primaryType");
  for (  String path : wrongPaths) {
    assertNull(user.getProperty(path));
  }
  List<String> invalidPaths=new ArrayList<String>();
  invalidPaths.add("/testing/jcr:primaryType");
  invalidPaths.add("..");
  invalidPaths.add(".");
  invalidPaths.add(null);
  for (  String invalidPath : invalidPaths) {
    try {
      assertNull(user.getProperty(invalidPath));
    }
 catch (    RepositoryException e) {
    }
  }
}
