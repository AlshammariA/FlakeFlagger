/** 
 * Existing tree structure: - /a/b/c/d/e - /a/f Moves: - /a/b/c    -> /a/f/c - /a/f/c/d  -> /a/b/d - /a/b/d/e  -> /a/f/c/e - /a/f/c/e  -> /a/f/e Expected mapping original-source vs destination: - "/a/b/c"     -> "/a/f/c" - "/a/b/c/d"   -> "/a/b/d" - "/a/b/c/d/e" -> "/a/f/e"
 */
@Test public void testMultiMove2(){
  MoveTest test=new MoveTest().addMove("/a/b/c","/a/f/c","/a/b/c").addMove("/a/f/c/d","/a/b/d","/a/b/c/d").addMove("/a/b/d/e","/a/f/c/e","/a/b/c/d/e").addMove("/a/f/c/e","/a/f/e","/a/b/c/d/e");
  test.assertResult();
}
