@Test public void testGetNotExistingProperty() throws RepositoryException, NotExecutableException {
  String hint="Fullname";
  String propName=hint;
  int i=0;
  while (user.hasProperty(propName)) {
    propName=hint + i;
    i++;
  }
  assertNull(user.getProperty(propName));
  assertFalse(user.hasProperty(propName));
}
