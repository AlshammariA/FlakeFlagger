@Test public void selectDescendant(){
  Selector selector=new RelativePathSelector("/a/b/c",Selectors.PARENT);
  UniversalFilter filter=new UniversalFilter(root,root,selector,ALL);
  assertEquals(nodeC,selector.select(filter,null,null));
}
