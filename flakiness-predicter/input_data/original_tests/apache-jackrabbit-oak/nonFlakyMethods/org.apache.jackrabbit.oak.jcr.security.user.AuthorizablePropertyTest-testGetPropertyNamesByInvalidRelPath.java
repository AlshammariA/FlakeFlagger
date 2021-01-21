@Test public void testGetPropertyNamesByInvalidRelPath() throws NotExecutableException, RepositoryException {
  List<String> invalidPaths=new ArrayList<String>();
  invalidPaths.add("");
  invalidPaths.add("/");
  invalidPaths.add("../");
  invalidPaths.add("../../");
  invalidPaths.add("../testing");
  invalidPaths.add("/testing");
  invalidPaths.add(null);
  for (  String invalidRelPath : invalidPaths) {
    try {
      user.getPropertyNames(invalidRelPath);
      fail("Calling Authorizable#getPropertyNames with " + invalidRelPath + " must fail.");
    }
 catch (    RepositoryException e) {
    }
  }
}
