/** 
 * test the iteration of the descending index with 2 shuffled items <code> :index : { :start : { :next=n1 }, n0 : { :next= }, n1 : { :next=n0 } } </code>
 */
@Test public void descendingOrderChildNodeEntriesACoupleOfMixedItems(){
  OrderedContentMirrorStoreStrategy store=new OrderedContentMirrorStoreStrategy(OrderDirection.DESC);
  NodeBuilder index=EmptyNodeState.EMPTY_NODE.builder();
  final String n0=KEYS[0];
  final String n1=KEYS[1];
  store.update(index,"/a/b",EMPTY_KEY_SET,newHashSet(n0));
  store.update(index,"/a/b",EMPTY_KEY_SET,newHashSet(n1));
  NodeState indexState=index.getNodeState();
  NodeState node0=indexState.getChildNode(n0);
  NodeState node1=indexState.getChildNode(n1);
  Iterable<? extends ChildNodeEntry> children=store.getChildNodeEntries(indexState);
  assertNotNull("The iterable cannot be null",children);
  assertEquals("Expecting 2 items in the index",2,Iterators.size(children.iterator()));
  ChildNodeEntry entry=null;
  children=store.getChildNodeEntries(indexState);
  Iterator<? extends ChildNodeEntry> it=children.iterator();
  assertTrue("We should have 2 elements left to loop through",it.hasNext());
  entry=it.next();
  assertEquals("The first element should be n1",n1,entry.getName());
  assertEquals("Wrong entry returned",node1,entry.getNodeState());
  assertTrue("We should have 1 elements left to loop through",it.hasNext());
  entry=it.next();
  assertEquals("The second element should be n0",n0,entry.getName());
  assertEquals("Wrong entry returned",node0,entry.getNodeState());
  assertFalse("We should have be at the end of the list",it.hasNext());
}
