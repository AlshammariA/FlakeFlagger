/** 
 * test the iteration of the index with 2 shuffled items <code> :index : { :start : { :next=n1 }, n0 : { :next= }, n1 : { :next=n0 } } </code>
 */
@SuppressWarnings("unchecked") @Test public void childNodeEntriesACoupleOfMixedItems(){
  final String n0=KEYS[1];
  final String n1=KEYS[0];
  final NodeState node0=EmptyNodeState.EMPTY_NODE.builder().setProperty(NEXT,"").getNodeState();
  final NodeState node1=EmptyNodeState.EMPTY_NODE.builder().setProperty(NEXT,n0).getNodeState();
  OrderedContentMirrorStoreStrategy store=new OrderedContentMirrorStoreStrategy();
  NodeBuilder index=EmptyNodeState.EMPTY_NODE.builder();
  index.child(START).setProperty(NEXT,n1);
  index.setChildNode(n0,node0);
  index.setChildNode(n1,node1);
  NodeState indexState=index.getNodeState();
  Iterable<ChildNodeEntry> children=(Iterable<ChildNodeEntry>)store.getChildNodeEntries(indexState);
  assertNotNull("The iterable cannot be null",children);
  assertEquals("Expecting 2 items in the index",2,Iterators.size(children.iterator()));
  ChildNodeEntry entry=null;
  children=(Iterable<ChildNodeEntry>)store.getChildNodeEntries(indexState);
  Iterator<ChildNodeEntry> it=children.iterator();
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
