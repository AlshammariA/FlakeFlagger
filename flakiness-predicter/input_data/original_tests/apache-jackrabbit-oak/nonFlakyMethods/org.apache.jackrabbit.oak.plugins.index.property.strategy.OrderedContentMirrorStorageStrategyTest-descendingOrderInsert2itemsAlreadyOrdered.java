/** 
 * <p>test the insertion of 2 already ordered items</p> <p>expected</p> <code> :index : { :start : { :next=n0 }, n0 : { :next=n1 }, n1 : { :next=} } </code>
 */
@Test public void descendingOrderInsert2itemsAlreadyOrdered(){
  IndexStoreStrategy store=new OrderedContentMirrorStoreStrategy(OrderDirection.DESC);
  NodeBuilder index=EmptyNodeState.EMPTY_NODE.builder();
  String n0=KEYS[1];
  String n1=KEYS[0];
  store.update(index,"/a/b",EMPTY_KEY_SET,newHashSet(n0));
  store.update(index,"/a/b",EMPTY_KEY_SET,newHashSet(n1));
  assertEquals(":start should point to the first node",n0,getNext(index.getChildNode(START)));
  assertEquals("n0 should point to n1",n1,getNext(index.getChildNode(n0)));
  assertTrue("n1 should point nowhere",Strings.isNullOrEmpty(getNext(index.getChildNode(n1))));
}
