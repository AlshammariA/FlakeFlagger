@Test public void testMultiMove4(){
  MoveTest test=new MoveTest().addMove("/a/b/c","/a/f/c","/a/b/c").addMove("/a/f/c/d","/a/b/d","/a/b/c/d").addMove("/a/b/d/e","/a/f/c/e","/a/b/c/d/e").addMove("/a/f/c","/a/b/d/e","/a/b/c");
  test.assertResult();
}
