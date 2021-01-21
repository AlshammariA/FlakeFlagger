/** 
 * Test the insert of 1 item into an empty index. Start should always point with all the lanes to the first element
 */
@Test public void insertWithLanes1Item(){
  MockOrderedContentMirrorStoreStrategy store=new MockOrderedContentMirrorStoreStrategy();
  NodeBuilder index=EmptyNodeState.EMPTY_NODE.builder();
  String n0=KEYS[0];
  store.setLane(0);
  store.update(index,"/a/b",EMPTY_KEY_SET,newHashSet(n0));
  NodeBuilder n=index.getChildNode(START);
  assertNotNull("There should always be a :start",n);
  assertEquals(":start's :next should always point to the first element",ImmutableList.of(n0,"","",""),n.getProperty(NEXT).getValue(Type.STRINGS));
  n=index.getChildNode(n0);
  assertNotNull(n);
  assertEquals(OrderedContentMirrorStoreStrategy.EMPTY_NEXT,n.getProperty(NEXT).getValue(Type.STRINGS));
  index=EmptyNodeState.EMPTY_NODE.builder();
  store.setLane(1);
  store.update(index,"/a/b",EMPTY_KEY_SET,newHashSet(n0));
  n=index.getChildNode(START);
  assertNotNull("There should always be a :start",n);
  assertEquals(":start's :next should always point to the first element",ImmutableList.of(n0,n0,"",""),n.getProperty(NEXT).getValue(Type.STRINGS));
  n=index.getChildNode(n0);
  assertNotNull(n);
  assertEquals(OrderedContentMirrorStoreStrategy.EMPTY_NEXT,n.getProperty(NEXT).getValue(Type.STRINGS));
  index=EmptyNodeState.EMPTY_NODE.builder();
  store.setLane(2);
  store.update(index,"/a/b",EMPTY_KEY_SET,newHashSet(n0));
  n=index.getChildNode(START);
  assertNotNull("There should always be a :start",n);
  assertEquals(":start's :next should always point to the first element",ImmutableList.of(n0,n0,n0,""),n.getProperty(NEXT).getValue(Type.STRINGS));
  n=index.getChildNode(n0);
  assertNotNull(n);
  assertEquals(OrderedContentMirrorStoreStrategy.EMPTY_NEXT,n.getProperty(NEXT).getValue(Type.STRINGS));
  index=EmptyNodeState.EMPTY_NODE.builder();
  store.setLane(3);
  store.update(index,"/a/b",EMPTY_KEY_SET,newHashSet(n0));
  n=index.getChildNode(START);
  assertNotNull("There should always be a :start",n);
  assertEquals(":start's :next should always point to the first element",ImmutableList.of(n0,n0,n0,n0),n.getProperty(NEXT).getValue(Type.STRINGS));
  n=index.getChildNode(n0);
  assertNotNull(n);
  assertEquals(OrderedContentMirrorStoreStrategy.EMPTY_NEXT,n.getProperty(NEXT).getValue(Type.STRINGS));
}
