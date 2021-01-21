/** 
 * test the case where we want an iterator for the children of a brand new index. In this case :start doesn't exists but if we ask for it we should return it.
 */
@Test public void childNodeEntriesNewIndexWithStart(){
  NodeState nodeStart=EmptyNodeState.EMPTY_NODE.builder().setProperty(NEXT,OrderedContentMirrorStoreStrategy.EMPTY_NEXT,Type.STRINGS).getNodeState();
  NodeBuilder index=EmptyNodeState.EMPTY_NODE.builder();
  OrderedContentMirrorStoreStrategy store=new OrderedContentMirrorStoreStrategy();
  Iterator<? extends ChildNodeEntry> children=store.getChildNodeEntries(index.getNodeState(),true).iterator();
  assertEquals("Wrong number of children",1,Iterators.size(children));
  children=store.getChildNodeEntries(index.getNodeState(),true).iterator();
  assertTrue("at least one item expected",children.hasNext());
  ChildNodeEntry child=children.next();
  assertEquals(START,child.getName());
  assertEquals(nodeStart,child.getNodeState());
  assertFalse(children.hasNext());
}
