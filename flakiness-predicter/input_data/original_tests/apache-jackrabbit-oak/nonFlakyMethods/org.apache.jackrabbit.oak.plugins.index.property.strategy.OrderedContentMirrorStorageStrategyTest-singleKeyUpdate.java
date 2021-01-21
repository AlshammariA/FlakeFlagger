/** 
 * perform a test where the index gets updated if an already existent node/key gets updated by changing the key and the key contains only 1 item. Where the second key is greater than the first. <code> Stage 1 ======= :index : { :start { :next = n0 }, n0 : { :next =, content : { foobar : { match = true } } } } Stage 2 ======= :index : { :start : { :next = n1 }, n1 : { :next =, content : { foobar : { match = true } } } } </code>
 */
@Test public void singleKeyUpdate(){
  final String n0=KEYS[0];
  final String n1=KEYS[1];
  final String path="/content/foobar";
  final String[] nodes=Iterables.toArray(PathUtils.elements(path),String.class);
  IndexStoreStrategy store=new OrderedContentMirrorStoreStrategy();
  NodeBuilder index=EmptyNodeState.EMPTY_NODE.builder();
  NodeBuilder node=null;
  store.update(index,path,EMPTY_KEY_SET,newHashSet(n0));
  node=index.getChildNode(START);
  assertTrue(":start should exists",node.exists());
  assertEquals(":start should point to n0",n0,getNext(node));
  node=index.getChildNode(n0);
  assertTrue(":index should have n0",node.exists());
  assertTrue("n0 should point nowhere",Strings.isNullOrEmpty(getNext(node)));
  node=node.getChildNode(nodes[0]);
  assertTrue("n0 should have /content",node.exists());
  node=node.getChildNode(nodes[1]);
  assertTrue("/content should contain /foobar",node.exists());
  assertTrue("/foobar should have match=true",node.getBoolean("match"));
  store.update(index,path,newHashSet(n0),newHashSet(n1));
  node=index.getChildNode(START);
  assertEquals(":start should now point to n1",n1,getNext(node));
  node=index.getChildNode(n1);
  assertTrue("n1 should exists",node.exists());
  assertTrue("n1 should point nowhere",Strings.isNullOrEmpty(getNext(node)));
  node=node.getChildNode(nodes[0]);
  assertTrue("n1 should have /content",node.exists());
  node=node.getChildNode(nodes[1]);
  assertTrue("/content should contain /foobar",node.exists());
  assertTrue("/foobar should have match=true",node.getBoolean("match"));
}
