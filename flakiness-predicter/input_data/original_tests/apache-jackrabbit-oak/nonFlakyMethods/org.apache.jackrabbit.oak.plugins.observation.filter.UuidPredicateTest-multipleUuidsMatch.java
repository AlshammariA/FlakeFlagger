@Test public void multipleUuidsMatch(){
  String uuid=generateUUID();
  UuidPredicate p=new UuidPredicate(new String[]{generateUUID(),generateUUID(),uuid});
  NodeState tree=createNodeWithUuid(uuid);
  assertTrue(p.apply(tree));
}
