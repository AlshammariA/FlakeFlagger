@Test public void testGetRestrictionType() throws RepositoryException {
  String[] names=acl.getRestrictionNames();
  for (  String name : names) {
    int type=acl.getRestrictionType(name);
    assertTrue(type > PropertyType.UNDEFINED);
  }
}
