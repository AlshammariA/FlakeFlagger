@Test public void singleUuidMiss(){
  UuidPredicate p=new UuidPredicate(new String[]{generateUUID()});
  NodeState tree=createNodeWithUuid(generateUUID());
  assertFalse(p.apply(tree));
}
