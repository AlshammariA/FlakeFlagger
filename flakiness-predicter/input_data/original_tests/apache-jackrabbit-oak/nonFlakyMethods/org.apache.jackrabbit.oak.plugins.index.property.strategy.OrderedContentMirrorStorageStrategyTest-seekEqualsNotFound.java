@Test public void seekEqualsNotFound(){
  OrderedContentMirrorStoreStrategy store=new OrderedContentMirrorStoreStrategy();
  NodeBuilder index=EmptyNodeState.EMPTY_NODE.builder();
  String n0=KEYS[1];
  String n1=KEYS[3];
  String n2=KEYS[2];
  String n3=KEYS[0];
  String nonExisting="dsrfgdrtfhg";
  store.update(index,"/a/b",EMPTY_KEY_SET,newHashSet(n0));
  store.update(index,"/a/b",EMPTY_KEY_SET,newHashSet(n1));
  store.update(index,"/a/b",EMPTY_KEY_SET,newHashSet(n2));
  store.update(index,"/a/b",EMPTY_KEY_SET,newHashSet(n3));
  assertNull("The item should have not been found",store.seek(index.getNodeState(),new OrderedContentMirrorStoreStrategy.PredicateEquals(nonExisting)));
}
