@Test public void testHasPropertyByInvalidRelativePath() throws NotExecutableException, RepositoryException {
  List<String> wrongPaths=new ArrayList<String>();
  wrongPaths.add("../jcr:primaryType");
  wrongPaths.add("../../jcr:primaryType");
  wrongPaths.add("../testing/jcr:primaryType");
  for (  String path : wrongPaths) {
    assertFalse(user.hasProperty(path));
  }
  List<String> invalidPaths=new ArrayList<String>();
  invalidPaths.add("..");
  invalidPaths.add(".");
  invalidPaths.add(null);
  for (  String invalidPath : invalidPaths) {
    try {
      assertFalse(user.hasProperty(invalidPath));
    }
 catch (    RepositoryException e) {
    }
  }
}
