@Test public void testMultiValueToSingleValue() throws RepositoryException, NotExecutableException {
  Value v=superuser.getValueFactory().createValue("testValue");
  try {
    user.setProperty("testProperty",new Value[]{v});
    superuser.save();
  }
 catch (  RepositoryException e) {
    throw new NotExecutableException("Cannot test 'Authorizable.setProperty'.");
  }
  user.setProperty("testProperty",v);
  Property p=superuser.getProperty(user.getPath() + "/testProperty");
  assertFalse(p.isMultiple());
}
