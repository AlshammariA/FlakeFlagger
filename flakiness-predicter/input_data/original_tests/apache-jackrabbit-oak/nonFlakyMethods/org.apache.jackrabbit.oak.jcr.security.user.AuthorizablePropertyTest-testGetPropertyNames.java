@Test public void testGetPropertyNames() throws NotExecutableException, RepositoryException {
  String propName="Fullname";
  Value v=superuser.getValueFactory().createValue("Super User");
  try {
    user.setProperty(propName,v);
    superuser.save();
  }
 catch (  RepositoryException e) {
    throw new NotExecutableException("Cannot test 'Authorizable.setProperty'.");
  }
  try {
    for (Iterator<String> it=user.getPropertyNames(); it.hasNext(); ) {
      String name=it.next();
      assertTrue(user.hasProperty(name));
      assertNotNull(user.getProperty(name));
    }
  }
  finally {
    user.removeProperty(propName);
    superuser.save();
  }
}
