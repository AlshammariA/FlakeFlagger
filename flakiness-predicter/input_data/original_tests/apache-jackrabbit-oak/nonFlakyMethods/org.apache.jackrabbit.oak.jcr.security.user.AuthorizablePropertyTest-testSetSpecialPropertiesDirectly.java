@Test public void testSetSpecialPropertiesDirectly() throws NotExecutableException, RepositoryException {
  Node n=getNode(user,superuser);
  try {
    String pName=user.getPrincipal().getName();
    n.setProperty(UserConstants.REP_PRINCIPAL_NAME,new StringValue("any-value"));
    n.setProperty(UserConstants.REP_PRINCIPAL_NAME,new StringValue(pName));
    fail("Attempt to change protected property rep:principalName should fail.");
  }
 catch (  ConstraintViolationException e) {
  }
  try {
    String imperson="anyimpersonator";
    n.setProperty(UserConstants.REP_IMPERSONATORS,new Value[]{new StringValue(imperson)},PropertyType.STRING);
    fail("Attempt to change protected property rep:impersonators should fail.");
  }
 catch (  ConstraintViolationException e) {
  }
}
