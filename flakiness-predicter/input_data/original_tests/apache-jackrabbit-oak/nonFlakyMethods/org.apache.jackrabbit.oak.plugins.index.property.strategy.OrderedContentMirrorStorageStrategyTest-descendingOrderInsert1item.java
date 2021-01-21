/** 
 * test the insert of 1 item in a descending order index. it should not really matter but just checking we don't break anything expecting <code> :index : { :start : { :next = n0 }, n0 : { :next = } } </code>
 */
@Test public void descendingOrderInsert1item(){
  IndexStoreStrategy store=new OrderedContentMirrorStoreStrategy(OrderDirection.DESC);
  NodeBuilder index=EmptyNodeState.EMPTY_NODE.builder();
  String n0=KEYS[1];
  store.update(index,"/a/b",EMPTY_KEY_SET,newHashSet(n0));
  assertEquals(":start should point to the first node",n0,getNext(index.getChildNode(START)));
  assertTrue("the first node should point nowhere",Strings.isNullOrEmpty(getNext(index.getChildNode(n0))));
}
