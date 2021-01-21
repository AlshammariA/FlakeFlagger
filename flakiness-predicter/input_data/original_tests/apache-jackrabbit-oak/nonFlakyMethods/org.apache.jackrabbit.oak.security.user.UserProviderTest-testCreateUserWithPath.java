@Test public void testCreateUserWithPath() throws Exception {
  UserProvider up=createUserProvider(1);
  Tree userTree=up.createUser("nadine","a/b/c");
  assertNotNull(userTree);
  assertTrue(Text.isDescendant(customUserPath,userTree.getPath()));
  String userPath=customUserPath + "/a/b/c/nadine";
  assertEquals(userPath,userTree.getPath());
}
