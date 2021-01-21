@Test public void seekGreaterThan(){
  OrderedContentMirrorStoreStrategy store=new OrderedContentMirrorStoreStrategy();
  NodeBuilder index=EmptyNodeState.EMPTY_NODE.builder();
  String n0=KEYS[1];
  String n1=KEYS[3];
  String n2=KEYS[2];
  String n3=KEYS[0];
  store.update(index,"/a/b",EMPTY_KEY_SET,newHashSet(n0));
  store.update(index,"/a/b",EMPTY_KEY_SET,newHashSet(n1));
  store.update(index,"/a/b",EMPTY_KEY_SET,newHashSet(n2));
  store.update(index,"/a/b",EMPTY_KEY_SET,newHashSet(n3));
  printSkipList(index.getNodeState());
  String searchFor=n2;
  ChildNodeEntry item=store.seek(index.getNodeState(),new OrderedContentMirrorStoreStrategy.PredicateGreaterThan(searchFor));
  assertNotNull("we should have found an item",item);
  assertEquals(n1,item.getName());
}
