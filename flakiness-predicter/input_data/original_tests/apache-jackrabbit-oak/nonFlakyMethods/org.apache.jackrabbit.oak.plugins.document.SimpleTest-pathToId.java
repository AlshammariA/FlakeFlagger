@Test public void pathToId(){
  assertEquals("0:/",Utils.getIdFromPath("/"));
  assertEquals("/",Utils.getPathFromId("0:/"));
  assertEquals("1:/test",Utils.getIdFromPath("/test"));
  assertEquals("/test",Utils.getPathFromId("1:/test"));
  assertEquals("10:/1/2/3/3/4/6/7/8/9/a",Utils.getIdFromPath("/1/2/3/3/4/6/7/8/9/a"));
  assertEquals("/1/2/3/3/4/6/7/8/9/a",Utils.getPathFromId("10:/1/2/3/3/4/6/7/8/9/a"));
}
