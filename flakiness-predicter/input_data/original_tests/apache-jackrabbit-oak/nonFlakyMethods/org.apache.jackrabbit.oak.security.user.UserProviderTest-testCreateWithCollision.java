@Test public void testCreateWithCollision() throws Exception {
  UserProvider userProvider=createUserProvider();
  Tree userTree=userProvider.createUser("AmaLia",null);
  Map<String,String> colliding=new HashMap<String,String>();
  colliding.put("AmaLia",null);
  colliding.put("AmaLia","s/ome/path");
  colliding.put("amalia",null);
  colliding.put("Amalia","a/b/c");
  for (  String uid : colliding.keySet()) {
    try {
      Tree c=userProvider.createUser(uid,colliding.get(uid));
      root.commit();
      fail("userID collision must be detected");
    }
 catch (    CommitFailedException e) {
    }
  }
  for (  String uid : colliding.keySet()) {
    try {
      Tree c=userProvider.createGroup(uid,colliding.get(uid));
      root.commit();
      fail("userID collision must be detected");
    }
 catch (    CommitFailedException e) {
    }
  }
}
