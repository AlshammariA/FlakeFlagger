/** 
 * test the insert of 4 shuffled items in a descending ordered index expected: <code> :index : { :start : { :next= n1}, n0 : { :next= n3}, n1 : { :next= n2}, n2: { :next= n0}, n3 : { :next= }, } </code>
 */
@Test public void descendingOrderInsert4ShuffledItems(){
  IndexStoreStrategy store=new OrderedContentMirrorStoreStrategy(OrderDirection.DESC);
  NodeBuilder index=EmptyNodeState.EMPTY_NODE.builder();
  String n0=KEYS[1];
  String n1=KEYS[3];
  String n2=KEYS[2];
  String n3=KEYS[0];
  store.update(index,"/a/b",EMPTY_KEY_SET,newHashSet(n0));
  store.update(index,"/a/b",EMPTY_KEY_SET,newHashSet(n1));
  store.update(index,"/a/b",EMPTY_KEY_SET,newHashSet(n2));
  store.update(index,"/a/b",EMPTY_KEY_SET,newHashSet(n3));
  assertEquals(":start should point to n1",n1,getNext(index.getChildNode(START)));
  assertEquals("n0 should point to n3",n3,getNext(index.getChildNode(n0)));
  assertEquals("n1 should point to n2",n2,getNext(index.getChildNode(n1)));
  assertEquals("n2 should point to n1",n0,getNext(index.getChildNode(n2)));
  assertTrue("n3 should point nowhere",Strings.isNullOrEmpty(getNext(index.getChildNode(n3))));
}
