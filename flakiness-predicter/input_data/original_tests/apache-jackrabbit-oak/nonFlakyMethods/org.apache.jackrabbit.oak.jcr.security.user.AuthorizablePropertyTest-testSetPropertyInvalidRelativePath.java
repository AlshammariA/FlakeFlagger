@Test public void testSetPropertyInvalidRelativePath() throws NotExecutableException, RepositoryException {
  Value[] v=new Value[]{superuser.getValueFactory().createValue("Super User")};
  List<String> invalidPaths=new ArrayList<String>();
  invalidPaths.add("../testing/Fullname");
  invalidPaths.add("../../testing/Fullname");
  invalidPaths.add("testing/testing/../../../Fullname");
  invalidPaths.add("/testing/Fullname");
  for (  String invalidRelPath : invalidPaths) {
    try {
      user.setProperty(invalidRelPath,v);
      fail("Modifications outside of the scope of the authorizable must fail. Path was: " + invalidRelPath);
    }
 catch (    RepositoryException e) {
    }
 finally {
      superuser.refresh(false);
    }
  }
}
