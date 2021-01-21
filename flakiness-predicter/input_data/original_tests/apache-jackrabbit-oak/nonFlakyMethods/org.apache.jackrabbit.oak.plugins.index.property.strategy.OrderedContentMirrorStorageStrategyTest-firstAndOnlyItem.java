/** 
 * checks that the fist item/key is inserted with an empty property 'next' expected structure: <code> :index : { :start : { :next=n0 }, n0 : { :next=, foo : { bar: { match=true} } } } </code>
 */
@Test public void firstAndOnlyItem(){
  final String path="/foo/bar";
  final String[] pathNodes=Iterables.toArray(PathUtils.elements(path),String.class);
  final String no=KEYS[0];
  IndexStoreStrategy store=new OrderedContentMirrorStoreStrategy();
  NodeBuilder index=EmptyNodeState.EMPTY_NODE.builder();
  NodeBuilder node=null;
  store.update(index,path,EMPTY_KEY_SET,newHashSet(no));
  assertFalse(":index should be left alone with not changes",index.hasProperty(NEXT));
  node=index.getChildNode(START);
  assertTrue(":index should have the :start node",node.exists());
  assertEquals(":start should point to n0",no,Iterables.toArray(node.getProperty(NEXT).getValue(Type.STRINGS),String.class)[0]);
  node=index.getChildNode(no);
  assertTrue("n0 should exists in the index",node.exists());
  assertEquals("n0 should point nowhere as it's the last (and only) element","",Iterables.toArray(node.getProperty(NEXT).getValue(Type.STRINGS),String.class)[0]);
  node=node.getChildNode(pathNodes[0]);
  assertTrue("n0 should contain 'foo'",node.exists());
  node=node.getChildNode(pathNodes[1]);
  assertTrue("'foo' should contain 'bar'",node.exists());
  assertTrue("the 'foo' node should have 'match=true'",node.getBoolean("match"));
}
