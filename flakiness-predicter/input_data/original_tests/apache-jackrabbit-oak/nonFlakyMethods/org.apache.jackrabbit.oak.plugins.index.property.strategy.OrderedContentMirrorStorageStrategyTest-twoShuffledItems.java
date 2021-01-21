/** 
 * test the insert of two shuffled items Building final a structure like <code> :index : { :start : { :next=n1 }, n0 : { :next= }, n1 : { :next=n0 } } </code> where: <code> Stage 1 ======= :index : { :start : { :next = n0 }, n0 : { :next = } } Stage 2 ======= :index : { :start : { :next = n1 }, n0 : { :next = }, n1 : { :next = n0 } } </code>
 */
@Test public void twoShuffledItems(){
  IndexStoreStrategy store=new OrderedContentMirrorStoreStrategy();
  NodeState root=EmptyNodeState.EMPTY_NODE;
  NodeBuilder index=root.builder();
  String key1st=KEYS[1];
  String key2nd=KEYS[0];
  NodeState ns=null;
  store.update(index,"/foo/bar",EMPTY_KEY_SET,newHashSet(key1st));
  ns=index.getChildNode(START).getNodeState();
  assertEquals(":start is expected to point to the 1st node",key1st,Iterables.toArray(ns.getProperty(NEXT).getValue(Type.STRINGS),String.class)[0]);
  ns=index.getChildNode(key1st).getNodeState();
  assertTrue("At Stage 1 the first node is expected to point nowhere as it's the last",Strings.isNullOrEmpty(ns.getString(NEXT)));
  store.update(index,"/foo/bar",EMPTY_KEY_SET,newHashSet(key2nd));
  ns=index.getChildNode(START).getNodeState();
  assertEquals(":start is expected to point to the 2nd node",key2nd,Iterables.toArray(ns.getProperty(NEXT).getValue(Type.STRINGS),String.class)[0]);
  ns=index.getChildNode(key1st).getNodeState();
  assertTrue("At stage 2 the first element should point nowhere as it's the last",Strings.isNullOrEmpty(ns.getString(NEXT)));
  ns=index.getChildNode(key2nd).getNodeState();
  assertEquals("At Stage 2 the second element should point to the first one",key1st,Iterables.toArray(ns.getProperty(NEXT).getValue(Type.STRINGS),String.class)[0]);
}
