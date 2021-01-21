/** 
 * test the use case where a document change the indexed property. For example document that change author. <p> <i>it relies on the functionality of the store.update() for creating the index</i> </p> <code> Stage 1 ======= :index : { :start : { :next = n0 }, n0 : { :next = , content : { one { match=true }, two { match=true } } } } Stage 2 ======= :index : { :start : { :next = n0 }, n0 : { :next = n1, content : { one : { match = true } } }, n1 : { :next = , content : { two : { match = true } } } } </code>
 */
@Test public void documentChangingKey(){
  final String path0="/content/one";
  final String path1="/content/two";
  final String n0=KEYS[0];
  final String n1=KEYS[1];
  NodeBuilder index=EmptyNodeState.EMPTY_NODE.builder();
  IndexStoreStrategy store=new OrderedContentMirrorStoreStrategy();
  store.update(index,path0,EMPTY_KEY_SET,newHashSet(n0));
  store.update(index,path1,EMPTY_KEY_SET,newHashSet(n0));
  assertTrue(index.hasChildNode(START));
  assertTrue(index.hasChildNode(n0));
  assertFalse(index.hasChildNode(n1));
  NodeBuilder node=index.getChildNode(START);
  assertEquals(":start pointing to wrong node",n0,getNext(node));
  node=index.getChildNode(n0);
  assertTrue("n0 should go nowhere",Strings.isNullOrEmpty(getNext(node)));
  String[] path=Iterables.toArray(PathUtils.elements(path0),String.class);
  node=node.getChildNode(path[0]);
  assertTrue(node.exists());
  node=node.getChildNode(path[1]);
  assertTrue(node.exists());
  assertTrue(node.getBoolean("match"));
  path=Iterables.toArray(PathUtils.elements(path0),String.class);
  node=index.getChildNode(n0).getChildNode(path[0]);
  assertTrue(node.exists());
  node=node.getChildNode(path[1]);
  assertTrue(node.exists());
  assertTrue(node.getBoolean("match"));
  store.update(index,path1,newHashSet(n0),newHashSet(n1));
  assertTrue(index.hasChildNode(START));
  assertTrue(index.hasChildNode(n0));
  assertTrue(index.hasChildNode(n1));
  node=index.getChildNode(START);
  assertEquals(":start pointing to wrong node",n0,getNext(node));
  node=index.getChildNode(n0);
  assertEquals(n1,getNext(node));
  path=Iterables.toArray(PathUtils.elements(path0),String.class);
  node=node.getChildNode(path[0]);
  assertTrue(node.exists());
  node=node.getChildNode(path[1]);
  assertTrue(node.exists());
  assertTrue(node.getBoolean("match"));
  path=Iterables.toArray(PathUtils.elements(path1),String.class);
  node=index.getChildNode(n0).getChildNode(path[0]);
  assertFalse("/content/two should no longer be under n0",node.hasChildNode(path[1]));
  node=index.getChildNode(n1);
  assertTrue("n1 should point nowhere",Strings.isNullOrEmpty(node.getString(NEXT)));
  path=Iterables.toArray(PathUtils.elements(path1),String.class);
  node=node.getChildNode(path[0]);
  assertTrue(node.exists());
  node=node.getChildNode(path[1]);
  assertTrue(node.exists());
  assertTrue(node.getBoolean("match"));
}
