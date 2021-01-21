@Test public void testSingleValueToMultiValue() throws RepositoryException, NotExecutableException {
  Value v=superuser.getValueFactory().createValue("testValue");
  try {
    user.setProperty("testProperty",v);
    superuser.save();
  }
 catch (  RepositoryException e) {
    throw new NotExecutableException("Cannot test 'Authorizable.setProperty'.");
  }
  user.setProperty("testProperty",new Value[]{v});
  Property p=superuser.getProperty(user.getPath() + "/testProperty");
  assertTrue(p.isMultiple());
}
