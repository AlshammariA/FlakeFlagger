@Test public void testRemoveSpecialGroupPropertiesDirectly() throws RepositoryException, NotExecutableException {
  Node n=getNode(group,superuser);
  try {
    if (n.hasProperty(UserConstants.REP_PRINCIPAL_NAME)) {
      n.getProperty(UserConstants.REP_PRINCIPAL_NAME).remove();
      fail("Attempt to remove protected property rep:principalName should fail.");
    }
  }
 catch (  ConstraintViolationException e) {
  }
  try {
    if (n.hasProperty(UserConstants.REP_MEMBERS)) {
      n.getProperty(UserConstants.REP_MEMBERS).remove();
      fail("Attempt to remove protected property rep:members should fail.");
    }
  }
 catch (  ConstraintViolationException e) {
  }
}
