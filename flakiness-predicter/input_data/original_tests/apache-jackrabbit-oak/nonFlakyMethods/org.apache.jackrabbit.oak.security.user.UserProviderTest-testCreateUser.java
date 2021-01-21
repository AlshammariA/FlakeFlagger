@Test public void testCreateUser() throws Exception {
  UserProvider up=createUserProvider();
  Tree userTree=up.createUser("user1",null);
  assertNotNull(userTree);
  assertTrue(Text.isDescendant(defaultUserPath,userTree.getPath()));
  int level=defaultConfig.getConfigValue(UserConstants.PARAM_DEFAULT_DEPTH,UserConstants.DEFAULT_DEPTH) + 1;
  assertEquals(defaultUserPath,Text.getRelativeParent(userTree.getPath(),level));
  userTree=up.createUser("b",null);
  assertEquals(defaultUserPath + "/b/bb/b",userTree.getPath());
  Map<String,String> m=new HashMap<String,String>();
  m.put("bb","/b/bb/bb");
  m.put("bbb","/b/bb/bbb");
  m.put("bbbb","/b/bb/bbbb");
  m.put("bh","/b/bh/bh");
  m.put("bHbh","/b/bH/bHbh");
  m.put("b_Hb","/b/b_/b_Hb");
  m.put("basim","/b/ba/basim");
  for (  String uid : m.keySet()) {
    userTree=up.createUser(uid,null);
    assertEquals(defaultUserPath + m.get(uid),userTree.getPath());
  }
}
