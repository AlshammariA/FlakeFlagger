@Test public void testSingleMove(){
  Map<String,String> moves=ImmutableMap.of("/a/b/c","/d/e/f","/aa/bb/cc","/aa/f/cc");
  for (  String src : moves.keySet()) {
    MoveTracker mt=new MoveTracker();
    String dest=moves.get(src);
    mt.addMove(src,dest);
    assertEquals(src,mt.getSourcePath(dest));
    assertEquals(dest,mt.getDestPath(src));
  }
}
