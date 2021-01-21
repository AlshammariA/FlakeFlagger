@Test public void testCreateWithCustomDepth() throws Exception {
  UserProvider userProvider=createUserProvider(3);
  Tree userTree=userProvider.createUser("b",null);
  assertEquals(customUserPath + "/b/bb/bbb/b",userTree.getPath());
  Map<String,String> m=new HashMap<String,String>();
  m.put("bb","/b/bb/bbb/bb");
  m.put("bbb","/b/bb/bbb/bbb");
  m.put("bbbb","/b/bb/bbb/bbbb");
  m.put("bL","/b/bL/bLL/bL");
  m.put("bLbh","/b/bL/bLb/bLbh");
  m.put("b_Lb","/b/b_/b_L/b_Lb");
  m.put("basiL","/b/ba/bas/basiL");
  for (  String uid : m.keySet()) {
    userTree=userProvider.createUser(uid,null);
    assertEquals(customUserPath + m.get(uid),userTree.getPath());
  }
}
