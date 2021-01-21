/** 
 * test the insert of shuffled items Building a final structure like <code> { :start : { :next = n1 }, n0 : { :next = "" }, n1 : { :next = n2 }, n2 : { :next = n0 } } </code> where: <code> Stage 1 ======= { :start : { :next = n0 }, n0 : { :next = } } Stage 2 ======= { :start : { :next = n1 }, n0 : { :next = }, n1 : { :next = n0 } } Stage 3 ======= { :start : { :next = n1 }, n0 : { :next = }, n1 : { :next = n2 }, n2 : { :next = n0 } } Stage 4 ======= { :start : { :next = n1 }, n0 : { :next = n3 }, n1 : { :next = n2 }, n2 : { :next = n0 }, n3 : { :next = } } </code>
 */
@Test public void fourShuffledElements(){
  IndexStoreStrategy store=new OrderedContentMirrorStoreStrategy();
  NodeBuilder index=EmptyNodeState.EMPTY_NODE.builder();
  String n0=KEYS[2];
  String n1=KEYS[0];
  String n2=KEYS[1];
  String n3=KEYS[3];
  store.update(index,"/a/b",EMPTY_KEY_SET,newHashSet(n0));
  NodeState n=index.getChildNode(START).getNodeState();
  assertEquals(":start should point to the first node",n0,Iterables.toArray(n.getProperty(NEXT).getValue(Type.STRINGS),String.class)[0]);
  assertTrue("the first node should point nowhere",Strings.isNullOrEmpty(index.getChildNode(n0).getString(NEXT)));
  store.update(index,"/a/b",EMPTY_KEY_SET,newHashSet(n1));
  n=index.getChildNode(START).getNodeState();
  assertEquals(":start should point to n1",n1,Iterables.toArray(n.getProperty(NEXT).getValue(Type.STRINGS),String.class)[0]);
  n=index.getChildNode(n1).getNodeState();
  assertEquals("'n1' should point to 'n0'",n0,Iterables.toArray(n.getProperty(NEXT).getValue(Type.STRINGS),String.class)[0]);
  assertTrue("n0 should still be point nowhere",Strings.isNullOrEmpty(index.getChildNode(n0).getString(NEXT)));
  store.update(index,"/a/b",EMPTY_KEY_SET,newHashSet(n2));
  n=index.getChildNode(START).getNodeState();
  assertEquals(":start should point to n1",n1,Iterables.toArray(n.getProperty(NEXT).getValue(Type.STRINGS),String.class)[0]);
  n=index.getChildNode(n1).getNodeState();
  assertEquals("n1 should be pointing to n2",n2,Iterables.toArray(n.getProperty(NEXT).getValue(Type.STRINGS),String.class)[0]);
  n=index.getChildNode(n2).getNodeState();
  assertEquals("n2 should be pointing to n0",n0,Iterables.toArray(n.getProperty(NEXT).getValue(Type.STRINGS),String.class)[0]);
  n=index.getChildNode(n0).getNodeState();
  assertTrue("n0 should still be the last item of the list",Strings.isNullOrEmpty(Iterables.toArray(n.getProperty(NEXT).getValue(Type.STRINGS),String.class)[0]));
  store.update(index,"/a/b",EMPTY_KEY_SET,newHashSet(n3));
  n=index.getChildNode(START).getNodeState();
  assertEquals(":start should point to n1",n1,Iterables.toArray(n.getProperty(NEXT).getValue(Type.STRINGS),String.class)[0]);
  n=index.getChildNode(n1).getNodeState();
  assertEquals("n1 should be pointing to n2",n2,Iterables.toArray(n.getProperty(NEXT).getValue(Type.STRINGS),String.class)[0]);
  assertEquals("n2 should be pointing to n0",n0,getNext(index.getChildNode(n2)));
  assertEquals("n0 should be pointing to n3",n3,getNext(index.getChildNode(n0)));
  assertTrue("n3 should be the last element",Strings.isNullOrEmpty(getNext(index.getChildNode(n3))));
}
