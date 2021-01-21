/** 
 * test when the document is deleted but there're still some documents left under the indexed key <p> <i>it relies on the functionality of the store.update() for creating the index</i> </p> <code> Stage 1 ======= :index : { :start : { :next = n0 }, n0 : { :next = , doc1 : { match=true }, doc2 : { match=true } } } Stage 2 ======= :index : { :start : { :next = n0 }, n0 : { :next  =, doc2 : { match = true } } } </code>
 */
@Test public void deleteOneOfTheDocuments(){
  final String n0=KEYS[0];
  final String doc1="doc1";
  final String doc2="doc2";
  final String path1="/" + doc1;
  final String path2="/" + doc2;
  NodeBuilder index=EmptyNodeState.EMPTY_NODE.builder();
  IndexStoreStrategy store=new OrderedContentMirrorStoreStrategy();
  store.update(index,path1,EMPTY_KEY_SET,newHashSet(n0));
  store.update(index,path2,EMPTY_KEY_SET,newHashSet(n0));
  store.update(index,path1,newHashSet(n0),EMPTY_KEY_SET);
  assertTrue(index.hasChildNode(START));
  assertTrue(index.hasChildNode(n0));
  assertEquals(":start should still point to n0",n0,getNext(index.getChildNode(START)));
  assertTrue("n0 should point nowhere",Strings.isNullOrEmpty(getNext(index.getChildNode(n0))));
  assertFalse(index.getChildNode(n0).hasChildNode(doc1));
  assertTrue(index.getChildNode(n0).hasChildNode(doc2));
  assertTrue(index.getChildNode(n0).getChildNode(doc2).getBoolean("match"));
}
