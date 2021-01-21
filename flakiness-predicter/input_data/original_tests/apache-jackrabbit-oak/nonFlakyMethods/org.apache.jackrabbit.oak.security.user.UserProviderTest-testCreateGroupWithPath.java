@Test public void testCreateGroupWithPath() throws Exception {
  UserProvider up=createUserProvider(4);
  Tree group=up.createGroup("authors","a/b/c");
  assertNotNull(group);
  assertTrue(Text.isDescendant(customGroupPath,group.getPath()));
  String groupPath=customGroupPath + "/a/b/c/authors";
  assertEquals(groupPath,group.getPath());
}
