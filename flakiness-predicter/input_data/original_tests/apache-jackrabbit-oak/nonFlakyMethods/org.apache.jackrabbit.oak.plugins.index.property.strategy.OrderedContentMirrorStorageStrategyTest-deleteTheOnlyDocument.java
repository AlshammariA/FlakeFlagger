/** 
 * test when a document is deleted and is the only one under the indexed key <p> <i>it relies on the functionality of the store.update() for creating the index</i> </p> <code> Stage 1 ======= :index : { :start : { :next = n0 }, n0 : { :next = , sampledoc : { match = true } } } Stage 2 ======= :index : { :start : { :next = } } </code>
 */
@Test public void deleteTheOnlyDocument(){
  final String n0=KEYS[0];
  final String path="/sampledoc";
  NodeBuilder index=EmptyNodeState.EMPTY_NODE.builder();
  IndexStoreStrategy store=new OrderedContentMirrorStoreStrategy();
  store.update(index,path,EMPTY_KEY_SET,newHashSet(n0));
  store.update(index,path,newHashSet(n0),EMPTY_KEY_SET);
  assertFalse("The node should have been removed",index.hasChildNode(n0));
  assertTrue("as the index should be empty, :start should point nowhere",Strings.isNullOrEmpty(index.getChildNode(START).getString(NEXT)));
}
