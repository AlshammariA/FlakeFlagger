/** 
 * <p> Tests the index pruning mechanism </p> <ul> <li> adds a few levels of nodes, nodes with an even index will have the 'match' property set</li> <li> pruning in this case means that whatever path that doesn't have a 'match' property is considered dead weight and should be removed from the index</li> </ul>
 */
@Test public void testIndexPruning(){
  IndexStoreStrategy store=new ContentMirrorStoreStrategy();
  NodeState root=EMPTY_NODE;
  NodeBuilder index=root.builder();
  for (  String path : asList("/","a/b/c","a/b/d","b","d/e","d/e/f")) {
    store.update(index,path,EMPTY,KEY);
  }
  checkPath(index,"key","",true);
  checkPath(index,"key","a/b/c",true);
  checkPath(index,"key","a/b/d",true);
  checkPath(index,"key","b",true);
  checkPath(index,"key","d/e",true);
  checkPath(index,"key","d/e/f",true);
  store.update(index,"/",KEY,EMPTY);
  checkPath(index,"key","d/e/f",true);
  store.update(index,"d/e",KEY,EMPTY);
  checkPath(index,"key","d/e/f",true);
  store.update(index,"d/e/f",KEY,EMPTY);
  checkNotPath(index,"key","d");
  store.update(index,"a/b/d",KEY,EMPTY);
  store.update(index,"a/b",KEY,EMPTY);
  checkPath(index,"key","a/b/c",true);
  store.update(index,"",EMPTY,KEY);
  store.update(index,"d/e/f",KEY,EMPTY);
  store.update(index,"b",KEY,EMPTY);
  store.update(index,"a/b/c",KEY,EMPTY);
  store.update(index,"",KEY,EMPTY);
  Assert.assertEquals(0,index.getChildNodeCount(1));
}
