@Test public void testGetPropertyNamesByRelPath() throws NotExecutableException, RepositoryException {
  String relPath="testing/Fullname";
  Value v=superuser.getValueFactory().createValue("Super User");
  try {
    user.setProperty(relPath,v);
    superuser.save();
  }
 catch (  RepositoryException e) {
    throw new NotExecutableException("Cannot test 'Authorizable.setProperty'.");
  }
  try {
    for (Iterator<String> it=user.getPropertyNames(); it.hasNext(); ) {
      String name=it.next();
      assertFalse("Fullname".equals(name));
    }
    for (Iterator<String> it=user.getPropertyNames("testing"); it.hasNext(); ) {
      String name=it.next();
      String rp="testing/" + name;
      assertFalse(user.hasProperty(name));
      assertNull(user.getProperty(name));
      assertTrue(user.hasProperty(rp));
      assertNotNull(user.getProperty(rp));
    }
    for (Iterator<String> it=user.getPropertyNames("./testing"); it.hasNext(); ) {
      String name=it.next();
      String rp="testing/" + name;
      assertFalse(user.hasProperty(name));
      assertNull(user.getProperty(name));
      assertTrue(user.hasProperty(rp));
      assertNotNull(user.getProperty(rp));
    }
  }
  finally {
    user.removeProperty(relPath);
    superuser.save();
  }
}
