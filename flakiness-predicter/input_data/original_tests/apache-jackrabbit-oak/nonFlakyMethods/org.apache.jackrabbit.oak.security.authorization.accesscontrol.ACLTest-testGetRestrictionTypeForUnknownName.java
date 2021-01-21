@Test public void testGetRestrictionTypeForUnknownName() throws RepositoryException {
  AbstractAccessControlList acl=createEmptyACL();
  assertEquals(PropertyType.UNDEFINED,acl.getRestrictionType("unknownRestrictionName"));
}
