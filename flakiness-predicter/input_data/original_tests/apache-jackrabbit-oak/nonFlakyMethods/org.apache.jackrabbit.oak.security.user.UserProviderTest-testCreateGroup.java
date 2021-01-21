@Test public void testCreateGroup() throws RepositoryException {
  UserProvider up=createUserProvider();
  Tree groupTree=up.createGroup("group1",null);
  assertNotNull(groupTree);
  assertTrue(Text.isDescendant(defaultGroupPath,groupTree.getPath()));
  int level=defaultConfig.getConfigValue(UserConstants.PARAM_DEFAULT_DEPTH,UserConstants.DEFAULT_DEPTH) + 1;
  assertEquals(defaultGroupPath,Text.getRelativeParent(groupTree.getPath(),level));
}
