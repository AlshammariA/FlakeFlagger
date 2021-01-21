@Test public void seekLessThanEqualNotFound(){
  OrderedContentMirrorStoreStrategy store=new OrderedContentMirrorStoreStrategy(OrderDirection.DESC);
  NodeBuilder index=EmptyNodeState.EMPTY_NODE.builder();
  String n0=KEYS[1];
  String n1=KEYS[3];
  String n2=KEYS[2];
  store.update(index,"/a/b",EMPTY_KEY_SET,newHashSet(n0));
  store.update(index,"/a/b",EMPTY_KEY_SET,newHashSet(n1));
  store.update(index,"/a/b",EMPTY_KEY_SET,newHashSet(n2));
  String searchFor=KEYS[0];
  ChildNodeEntry item=store.seek(index.getNodeState(),new OrderedContentMirrorStoreStrategy.PredicateLessThan(searchFor,true));
  assertNull("we should have not found an item",item);
}
