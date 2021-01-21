/** 
 * test the iteration over an empty list when the :start is required. In this case :start should always be returned <code> :index : { :start : { :next= } } </code>
 */
@Test public void childNodeEntriesNoItemsWithStart(){
  NodeState nodeStart=EmptyNodeState.EMPTY_NODE.builder().setProperty(NEXT,"").getNodeState();
  NodeBuilder index=EmptyNodeState.EMPTY_NODE.builder();
  OrderedContentMirrorStoreStrategy store=new OrderedContentMirrorStoreStrategy();
  index.setChildNode(START,nodeStart);
  Iterable<? extends ChildNodeEntry> children=store.getChildNodeEntries(index.getNodeState(),true);
  assertEquals("Wrong size of Iterable",1,Iterators.size(children.iterator()));
  Iterator<? extends ChildNodeEntry> it=store.getChildNodeEntries(index.getNodeState(),true).iterator();
  assertTrue("We should have at least 1 element",it.hasNext());
  ChildNodeEntry entry=it.next();
  assertEquals(":start is expected",START,entry.getName());
  assertEquals("wrong node returned",nodeStart,entry.getNodeState());
  assertFalse("We should be at the end of the list",it.hasNext());
}
