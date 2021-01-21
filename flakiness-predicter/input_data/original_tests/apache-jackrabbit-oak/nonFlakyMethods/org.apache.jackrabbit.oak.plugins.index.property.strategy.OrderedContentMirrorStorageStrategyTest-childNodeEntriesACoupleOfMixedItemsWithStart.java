/** 
 * test the iteration of the index with 2 shuffled items including the :start node as first <code> :index : { :start : { :next=n1 }, n0 : { :next= }, n1 : { :next=n0 } } </code>
 */
@SuppressWarnings("unchecked") @Test public void childNodeEntriesACoupleOfMixedItemsWithStart(){
  final String n0=KEYS[1];
  final String n1=KEYS[0];
  final NodeState nodeStart=EmptyNodeState.EMPTY_NODE.builder().setProperty(NEXT,n1).getNodeState();
  final NodeState node0=EmptyNodeState.EMPTY_NODE.builder().setProperty(NEXT,"").getNodeState();
  final NodeState node1=EmptyNodeState.EMPTY_NODE.builder().setProperty(NEXT,n0).getNodeState();
  OrderedContentMirrorStoreStrategy store=new OrderedContentMirrorStoreStrategy();
  NodeBuilder index=EmptyNodeState.EMPTY_NODE.builder();
  index.setChildNode(START,nodeStart);
  index.setChildNode(n0,node0);
  index.setChildNode(n1,node1);
  NodeState indexState=index.getNodeState();
  Iterable<ChildNodeEntry> children=(Iterable<ChildNodeEntry>)store.getChildNodeEntries(indexState,true);
  assertNotNull("The iterable cannot be null",children);
  assertEquals("Expecting 3 items in the index",3,Iterators.size(children.iterator()));
  ChildNodeEntry entry=null;
  children=(Iterable<ChildNodeEntry>)store.getChildNodeEntries(indexState,true);
  Iterator<ChildNodeEntry> it=children.iterator();
  assertTrue("We should still have elements left to loop through",it.hasNext());
  entry=it.next();
  assertEquals("The first element should be :start",START,entry.getName());
  assertEquals("Wrong entry returned",nodeStart,entry.getNodeState());
  assertTrue("We should still have elements left to loop through",it.hasNext());
  entry=it.next();
  assertEquals("The second element should be n1",n1,entry.getName());
  assertEquals("Wrong entry returned",node1,entry.getNodeState());
  assertTrue("We should still have elements left to loop through",it.hasNext());
  entry=it.next();
  assertEquals("The third element should be n0",n0,entry.getName());
  assertEquals("Wrong entry returned",node0,entry.getNodeState());
  assertFalse("We should be at the end of the list",it.hasNext());
}
