@Test public void testRemoveNotExistingProperty() throws RepositoryException, NotExecutableException {
  String hint="Fullname";
  String propName=hint;
  int i=0;
  while (user.hasProperty(propName)) {
    propName=hint + i;
    i++;
  }
  assertFalse(user.removeProperty(propName));
  superuser.save();
}
