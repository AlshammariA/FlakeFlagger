/** 
 * Test the iteration of an empty index
 */
@Test public void childNodeEntriesEmptyIndex(){
  OrderedContentMirrorStoreStrategy store=new OrderedContentMirrorStoreStrategy();
  NodeState index=EmptyNodeState.EMPTY_NODE;
  @SuppressWarnings("unchecked") Iterable<ChildNodeEntry> children=(Iterable<ChildNodeEntry>)store.getChildNodeEntries(index);
  assertNotNull("A returned Iterable cannot be null",children);
}
