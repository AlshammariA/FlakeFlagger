/** 
 * test when the only document is deleted from an indexed key but there're still some keys left in the index <p> <i>it relies on the functionality of the store.update() for creating the index</i> </p> <code> Stage 1 ======= :index : { :start : { :next = n1 }, n0 : { :next = , content : { doc0 : { match = true } } }, n1 : { :next = n2, content : { doc1 : { match = true } } } n2 : { :next = n0, content : { doc2 : { match = true } } } } Stage 2 ======= :index : { :start : { :next = n1 }, n0 : { :next = , content : { doc0 : { match = true } } }, n1 : { :next = n0, content : { doc1 : { match = true } } } } </code>
 */
@Test public void deleteTheOnlyDocumentInMultiKeysIndex(){
  final String path0="/content/doc0";
  final String path1="/content/doc1";
  final String path2="/content/doc2";
  final String n0=KEYS[2];
  final String n1=KEYS[0];
  final String n2=KEYS[1];
  NodeBuilder index=EmptyNodeState.EMPTY_NODE.builder();
  IndexStoreStrategy store=new OrderedContentMirrorStoreStrategy();
  store.update(index,path0,EMPTY_KEY_SET,newHashSet(n0));
  store.update(index,path1,EMPTY_KEY_SET,newHashSet(n1));
  store.update(index,path2,EMPTY_KEY_SET,newHashSet(n2));
  store.update(index,path2,newHashSet(n2),EMPTY_KEY_SET);
  assertTrue(index.hasChildNode(START));
  assertTrue(index.hasChildNode(n0));
  assertTrue(index.hasChildNode(n1));
  assertFalse(index.hasChildNode(n2));
  assertEquals(n1,getNext(index.getChildNode(START)));
  assertEquals(n0,getNext(index.getChildNode(n1)));
  assertTrue(Strings.isNullOrEmpty(getNext(index.getChildNode(n0))));
  String[] subNodes=Iterables.toArray(PathUtils.elements(path0),String.class);
  assertTrue(index.getChildNode(n0).hasChildNode(subNodes[0]));
  assertTrue(index.getChildNode(n0).getChildNode(subNodes[0]).hasChildNode(subNodes[1]));
  assertTrue(index.getChildNode(n0).getChildNode(subNodes[0]).getChildNode(subNodes[1]).getBoolean("match"));
  subNodes=Iterables.toArray(PathUtils.elements(path1),String.class);
  assertTrue(index.getChildNode(n1).hasChildNode(subNodes[0]));
  assertTrue(index.getChildNode(n1).getChildNode(subNodes[0]).hasChildNode(subNodes[1]));
  assertTrue(index.getChildNode(n1).getChildNode(subNodes[0]).getChildNode(subNodes[1]).getBoolean("match"));
}
