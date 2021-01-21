@Test public void testIndependantMoves(){
  Map<String,String> m=ImmutableMap.of("/a/b/c","/d/e/f","/aa/bb/cc","/aa/f/cc");
  MoveTracker mt=new MoveTracker();
  for (  String src : m.keySet()) {
    String dest=m.get(src);
    mt.addMove(src,dest);
  }
  for (  String src : m.keySet()) {
    String dest=m.get(src);
    assertEquals(src,mt.getSourcePath(dest));
    assertEquals(dest,mt.getDestPath(src));
  }
}
