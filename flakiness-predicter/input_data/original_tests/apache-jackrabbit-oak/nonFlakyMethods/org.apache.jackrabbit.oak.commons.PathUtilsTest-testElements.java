public void testElements(){
  String path="a/b/c";
  String[] elementsArray=path.split("/");
  Iterable<String> elementsIterable=PathUtils.elements(path);
  int k=0;
  for (  String name : elementsIterable) {
    Assert.assertEquals(elementsArray[k++],name);
  }
  assertEquals(3,k);
  k=0;
  for (  String name : elementsIterable) {
    Assert.assertEquals(elementsArray[k++],name);
  }
  assertEquals(3,k);
}
