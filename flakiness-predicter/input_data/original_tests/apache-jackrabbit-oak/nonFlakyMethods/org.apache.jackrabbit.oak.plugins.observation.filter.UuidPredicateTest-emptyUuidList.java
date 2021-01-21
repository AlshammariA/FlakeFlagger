@Test public void emptyUuidList(){
  UuidPredicate p=new UuidPredicate(new String[]{});
  NodeState tree=createNodeWithUuid(generateUUID());
  assertFalse(p.apply(tree));
}
