@Test public void testMultiMoveIncludingNewNodes(){
  MoveTest test=new MoveTest().addMove("/a/b/c","/a/f/c","/a/b/c").addMove("/a/f/c/d","/a/b/d","/a/b/c/d").addMove("/a/b/d/e","/a/f/c/e","/a/b/c/d/e").addMove("/a/b/d/e","/a/b/c/d/e","/a/b/c/d/e");
  test.assertResult();
}
