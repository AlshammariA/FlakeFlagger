@Test public void testGetRestrictionType() throws RepositoryException {
  AbstractAccessControlList acl=createEmptyACL();
  for (  RestrictionDefinition def : getRestrictionProvider().getSupportedRestrictions(getTestPath())) {
    int reqType=acl.getRestrictionType(namePathMapper.getJcrName(def.getName()));
    assertTrue(reqType > PropertyType.UNDEFINED);
    assertEquals(def.getRequiredType().tag(),reqType);
  }
}
