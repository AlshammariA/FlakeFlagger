@Test public void seekGreaterThanEqualsNotFound(){
  OrderedContentMirrorStoreStrategy store=new OrderedContentMirrorStoreStrategy();
  NodeBuilder index=EmptyNodeState.EMPTY_NODE.builder();
  String n0=KEYS[1];
  String n2=KEYS[2];
  String n3=KEYS[0];
  store.update(index,"/a/b",EMPTY_KEY_SET,newHashSet(n0));
  store.update(index,"/a/b",EMPTY_KEY_SET,newHashSet(n2));
  store.update(index,"/a/b",EMPTY_KEY_SET,newHashSet(n3));
  String searchFor=KEYS[3];
  ChildNodeEntry item=store.seek(index.getNodeState(),new OrderedContentMirrorStoreStrategy.PredicateGreaterThan(searchFor,true));
  assertNull("we should have not found an item",item);
}
