@Test public void testUnique() throws CommitFailedException {
  IndexStoreStrategy store=new ContentMirrorStoreStrategy();
  NodeState root=EMPTY_NODE;
  NodeBuilder indexMeta=root.builder();
  NodeBuilder index=indexMeta.child(INDEX_CONTENT_NODE_NAME);
  store.update(index,"a",EMPTY,KEY);
  store.update(index,"b",EMPTY,KEY);
  Assert.assertTrue("ContentMirrorStoreStrategy should guarantee uniqueness on insert",store.count(indexMeta.getNodeState(),Collections.singleton("key"),2) > 1);
}
