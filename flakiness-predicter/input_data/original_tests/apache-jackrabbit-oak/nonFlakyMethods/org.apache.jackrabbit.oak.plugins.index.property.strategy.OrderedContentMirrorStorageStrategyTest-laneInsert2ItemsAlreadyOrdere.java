/** 
 * tests the insert of an item that has to be appended 
 */
@Test public void laneInsert2ItemsAlreadyOrdere(){
  MockOrderedContentMirrorStoreStrategy store=new MockOrderedContentMirrorStoreStrategy();
  NodeBuilder index=null;
  NodeBuilder n=null;
  String n0=KEYS[0];
  String n1=KEYS[1];
  index=EmptyNodeState.EMPTY_NODE.builder();
  store.setLane(0);
  store.update(index,"/a/b",EMPTY_KEY_SET,newHashSet(n0));
  store.update(index,"/a/b",EMPTY_KEY_SET,newHashSet(n1));
  printSkipList(index.getNodeState());
  n=index.getChildNode(START);
  assertNotNull(n);
  assertNotNull(n.getProperty(NEXT));
  assertEquals(ImmutableList.of(n0,"","",""),n.getProperty(NEXT).getValue(Type.STRINGS));
  n=index.getChildNode(n0);
  assertNotNull(n);
  assertNotNull(n.getProperty(NEXT));
  assertEquals(ImmutableList.of(n1,"","",""),n.getProperty(NEXT).getValue(Type.STRINGS));
  n=index.getChildNode(n1);
  assertNotNull(n);
  assertNotNull(n.getProperty(NEXT));
  assertEquals(OrderedContentMirrorStoreStrategy.EMPTY_NEXT,n.getProperty(NEXT).getValue(Type.STRINGS));
  index=EmptyNodeState.EMPTY_NODE.builder();
  store.setLane(0);
  store.update(index,"/a/b",EMPTY_KEY_SET,newHashSet(n0));
  store.setLane(1);
  store.update(index,"/a/b",EMPTY_KEY_SET,newHashSet(n1));
  printSkipList(index.getNodeState());
  n=index.getChildNode(START);
  assertNotNull(n);
  assertNotNull(n.getProperty(NEXT));
  assertEquals(ImmutableList.of(n0,n1,"",""),n.getProperty(NEXT).getValue(Type.STRINGS));
  n=index.getChildNode(n0);
  assertNotNull(n);
  assertNotNull(n.getProperty(NEXT));
  assertEquals(ImmutableList.of(n1,"","",""),n.getProperty(NEXT).getValue(Type.STRINGS));
  n=index.getChildNode(n1);
  assertNotNull(n);
  assertNotNull(n.getProperty(NEXT));
  assertEquals(OrderedContentMirrorStoreStrategy.EMPTY_NEXT,n.getProperty(NEXT).getValue(Type.STRINGS));
}
