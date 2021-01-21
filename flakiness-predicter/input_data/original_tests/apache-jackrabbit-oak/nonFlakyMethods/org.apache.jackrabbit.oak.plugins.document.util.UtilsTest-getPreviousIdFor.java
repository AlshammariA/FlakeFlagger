@Test public void getPreviousIdFor(){
  Revision r=new Revision(System.currentTimeMillis(),0,0);
  assertEquals("2:p/" + r.toString() + "/0",Utils.getPreviousIdFor("/",r,0));
  assertEquals("3:p/test/" + r.toString() + "/1",Utils.getPreviousIdFor("/test",r,1));
  assertEquals("15:p/a/b/c/d/e/f/g/h/i/j/k/l/m/" + r.toString() + "/3",Utils.getPreviousIdFor("/a/b/c/d/e/f/g/h/i/j/k/l/m",r,3));
}
