@Test public void testMembersPropertyType() throws NotExecutableException, RepositoryException {
  Node n=getNode(group,superuser);
  if (!n.hasProperty(UserConstants.REP_MEMBERS)) {
    group.addMember(user);
  }
  Property p=n.getProperty(UserConstants.REP_MEMBERS);
  for (  Value v : p.getValues()) {
    assertEquals(PropertyType.WEAKREFERENCE,v.getType());
  }
}
