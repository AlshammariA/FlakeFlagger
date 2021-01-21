/** 
 * test the saving of 2 new keys that comes already ordered final state of the index will be <code> :index : { :start : { :next=n0 }, n0 : { :next=n1 }, n1 : { :next= } } </code>
 */
@Test public void first2newKeysAlreadyOrdered(){
  final String path="/foo/bar";
  final String n0=KEYS[0];
  final String n1=KEYS[1];
  IndexStoreStrategy store=new OrderedContentMirrorStoreStrategy();
  NodeBuilder index=EmptyNodeState.EMPTY_NODE.builder();
  NodeBuilder node=null;
  store.update(index,path,EMPTY_KEY_SET,newHashSet(n0));
  node=index.getChildNode(START);
  assertTrue(":index should have :start",node.exists());
  assertEquals(":start should point to n0",n0,Iterables.toArray(node.getProperty(NEXT).getValue(Type.STRINGS),String.class)[0]);
  node=index.getChildNode(n0);
  assertTrue(":index should have n0",node.exists());
  assertEquals("n0 should point nowhere at this stage","",Iterables.toArray(node.getProperty(NEXT).getValue(Type.STRINGS),String.class)[0]);
  store.update(index,path,EMPTY_KEY_SET,newHashSet(n1));
  node=index.getChildNode(START);
  assertTrue(":index should still have :start",node.exists());
  assertEquals(":start should still point to n0",n0,Iterables.toArray(node.getProperty(NEXT).getValue(Type.STRINGS),String.class)[0]);
  node=index.getChildNode(n0);
  assertTrue("n0 should still exists",node.exists());
  assertEquals("n0 should point to n1",n1,Iterables.toArray(node.getProperty(NEXT).getValue(Type.STRINGS),String.class)[0]);
  node=index.getChildNode(n1);
  assertTrue("n1 should exists",node.exists());
  assertEquals("n1 should point nowhere","",Iterables.toArray(node.getProperty(NEXT).getValue(Type.STRINGS),String.class)[0]);
}
