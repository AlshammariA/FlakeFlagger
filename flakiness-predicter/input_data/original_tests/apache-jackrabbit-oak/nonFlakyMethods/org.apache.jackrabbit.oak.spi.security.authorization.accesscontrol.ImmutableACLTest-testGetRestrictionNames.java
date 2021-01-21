@Test public void testGetRestrictionNames() throws RepositoryException {
  AbstractAccessControlList acl=createEmptyACL();
  String[] restrNames=acl.getRestrictionNames();
  assertNotNull(restrNames);
  List<String> names=Lists.newArrayList(restrNames);
  for (  RestrictionDefinition def : getRestrictionProvider().getSupportedRestrictions(getTestPath())) {
    assertTrue(names.remove(namePathMapper.getJcrName(def.getName())));
  }
  assertTrue(names.isEmpty());
}
