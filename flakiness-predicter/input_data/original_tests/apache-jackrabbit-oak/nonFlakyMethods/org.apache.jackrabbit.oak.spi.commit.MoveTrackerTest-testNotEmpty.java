@Test public void testNotEmpty(){
  MoveTracker mt=new MoveTracker();
  mt.addMove("/a/b/c","/d/e/f");
  assertFalse(mt.isEmpty());
}
