@Test public void seekGreaterThanNotFound(){
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
  String searchFor=n1;
  ChildNodeEntry item=store.seek(index.getNodeState(),new OrderedContentMirrorStoreStrategy.PredicateGreaterThan(searchFor));
  assertNull("no item should have been found",item);
}
