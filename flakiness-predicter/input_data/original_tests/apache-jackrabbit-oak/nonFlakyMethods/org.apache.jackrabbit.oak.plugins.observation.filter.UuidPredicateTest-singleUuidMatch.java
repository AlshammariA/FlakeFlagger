@Test public void singleUuidMatch(){
  String uuid=generateUUID();
  UuidPredicate p=new UuidPredicate(new String[]{uuid});
  NodeState tree=createNodeWithUuid(uuid);
  assertTrue(p.apply(tree));
}
