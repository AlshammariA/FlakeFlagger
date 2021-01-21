/** 
 * Tests the insert of 4 items that will always have to be added at the beginning of the list. Just to simulate the use-case of lastModified DESC. <code> Stage 1 ======= :index : { :start : { :next=n0 }, n0 : { :next= } } Stage 2 ======= :index : { :start : { :next=n1 }, n0 : { :next= }, n1 : { :next=n0 } } Stage 3 ======= :index : { :start : { :next=n2 }, n0 : { :next= }, n1 : { :next=n0 }, n2 : { :next=n1 } } Stage 4 ======= :index : { :start : { :next=n3 }, n0 : { :next= }, n1 : { :next=n0 }, n2 : { :next=n1 }, n3 : { :next=n2 } } </code>
 */
@Test public void descendingOrder4StagedInsertsAlwaysGreater(){
  IndexStoreStrategy store=new OrderedContentMirrorStoreStrategy(OrderDirection.DESC);
  NodeBuilder index=EmptyNodeState.EMPTY_NODE.builder();
  String n0=KEYS[0];
  String n1=KEYS[1];
  String n2=KEYS[2];
  String n3=KEYS[3];
  store.update(index,"/a/b",EMPTY_KEY_SET,newHashSet(n0));
  assertEquals(":start should point to n0",n0,getNext(index.getChildNode(START)));
  assertTrue("n0 should point nowhere",Strings.isNullOrEmpty(getNext(index.getChildNode(n0))));
  store.update(index,"/a/b",EMPTY_KEY_SET,newHashSet(n1));
  assertEquals(":start should point to n1",n1,getNext(index.getChildNode(START)));
  assertEquals("n1 should point to n0",n0,getNext(index.getChildNode(n1)));
  assertTrue("n0 should point nowhere",Strings.isNullOrEmpty(getNext(index.getChildNode(n0))));
  store.update(index,"/a/b",EMPTY_KEY_SET,newHashSet(n2));
  assertEquals(":start should point to n2",n2,getNext(index.getChildNode(START)));
  assertEquals("n2 should point to n1",n1,getNext(index.getChildNode(n2)));
  assertEquals("n1 should point to n0",n0,getNext(index.getChildNode(n1)));
  assertTrue("n0 should point nowhere",Strings.isNullOrEmpty(getNext(index.getChildNode(n0))));
  store.update(index,"/a/b",EMPTY_KEY_SET,newHashSet(n3));
  assertEquals(":start should point to n3",n3,getNext(index.getChildNode(START)));
  assertEquals("n3 should point to n2",n2,getNext(index.getChildNode(n3)));
  assertEquals("n2 should point to n1",n1,getNext(index.getChildNode(n2)));
  assertEquals("n1 should point to n0",n0,getNext(index.getChildNode(n1)));
  assertTrue("n0 should point nowhere",Strings.isNullOrEmpty(getNext(index.getChildNode(n0))));
}
