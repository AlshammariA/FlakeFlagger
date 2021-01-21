@Test public void testRemoveSpecialUserPropertiesDirectly() throws RepositoryException, NotExecutableException {
  Node n=getNode(user,superuser);
  try {
    n.getProperty(UserConstants.REP_PASSWORD).remove();
    fail("Attempt to remove protected property rep:password should fail.");
  }
 catch (  ConstraintViolationException e) {
  }
  try {
    if (n.hasProperty(UserConstants.REP_PRINCIPAL_NAME)) {
      n.getProperty(UserConstants.REP_PRINCIPAL_NAME).remove();
      fail("Attempt to remove protected property rep:principalName should fail.");
    }
  }
 catch (  ConstraintViolationException e) {
  }
}
