@Test public void multipleUuidsMiss(){
  UuidPredicate p=new UuidPredicate(new String[]{generateUUID(),generateUUID(),generateUUID()});
  NodeState tree=createNodeWithUuid(generateUUID());
  assertFalse(p.apply(tree));
}
