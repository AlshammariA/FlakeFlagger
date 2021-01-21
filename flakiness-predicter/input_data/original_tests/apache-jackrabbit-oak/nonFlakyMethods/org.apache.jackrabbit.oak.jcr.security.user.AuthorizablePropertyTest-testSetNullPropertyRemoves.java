@Test public void testSetNullPropertyRemoves() throws RepositoryException, NotExecutableException {
  Value v=superuser.getValueFactory().createValue("testValue");
  try {
    user.setProperty("testProperty",v);
    user.setProperty("testMvProperty",new Value[]{v});
    superuser.save();
  }
 catch (  RepositoryException e) {
    throw new NotExecutableException("Cannot test 'Authorizable.setProperty'.");
  }
  user.setProperty("testProperty",(Value)null);
  assertFalse(user.hasProperty("testProperty"));
  user.setProperty("testMvProperty",(Value[])null);
  assertFalse(user.hasProperty("testMvProperty"));
}
